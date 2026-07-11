import os
import re
from gensim import corpora
from gensim.models import Phrases
from gensim.models.ldamodel import LdaModel
from gensim.models.phrases import Phraser
from mecab import MeCab
import openai
from sklearn.feature_extraction.text import TfidfVectorizer

openai.api_key = os.getenv("OPENAI_API_KEY")
mecab = MeCab()
TARGET_POS = ["NNG", "NNP", "VA", "VV", "XR"]


def extract_raw_questions(review_text):
    sentences = re.split(r"[.\n]+", review_text)
    keywords = ("?", "나요", "습니까", "했나요", "있나요", "어떻게", "무엇인가요")
    return [
        s.strip()
        for s in sentences
        if len(s.strip()) > 10 and any(k in s for k in keywords)
    ]


def preprocess_corpus_with_bigrams(raw_docs, min_count=2, threshold=5.0):
    def _tokenize(text):
        cleaned = re.sub(r"[^가-힣a-zA-Z\s]", " ", text)
        tagged = mecab.pos(cleaned)
        return [word for word, tag in tagged if tag in TARGET_POS and len(word) > 1]

    tokenized_docs = [_tokenize(doc) for doc in raw_docs]
    phrases = Phrases(tokenized_docs, min_count=min_count, threshold=threshold)
    bigram_model = Phraser(phrases)
    return [bigram_model[doc] for doc in tokenized_docs]


def extract_domain_specific_keywords(docs_by_job, top_n=10):
    job_names = list(docs_by_job.keys())
    corpus = [" ".join(docs) for docs in docs_by_job.values()]

    tfidf = TfidfVectorizer(max_features=1000)
    tfidf_matrix = tfidf.fit_transform(corpus)
    feature_names = tfidf.get_feature_names_out()

    job_keywords = {}
    for idx, job in enumerate(job_names):
        row = tfidf_matrix.getrow(idx).toarray()[0]
        top_indices = row.argsort()[-top_n:][::-1]
        job_keywords[job] = [feature_names[i] for i in top_indices]

    return job_keywords


def train_stratified_lda(tokenized_docs, num_topics=3):
    dictionary = corpora.Dictionary(tokenized_docs)
    dictionary.filter_extremes(no_below=1, no_above=0.85)
    corpus = [dictionary.doc2bow(doc) for doc in tokenized_docs]

    lda = LdaModel(
        corpus=corpus,
        id2word=dictionary.id2token,
        num_topics=num_topics,
        passes=10,
        random_state=42,
    )

    topics = []
    for topic_id in range(num_topics):
        topic_words = [word for word, _ in lda.show_topic(topic_id, topn=5)]
        topics.append(", ".join(topic_words))
    return topics


def generate_multidimensional_questions(
    job_title, domain_keywords, tech_topics, culture_topics, raw_questions
):
    if raw_questions:
        raw_q_sample = "\n".join([f"- {q}" for q in raw_questions[:3]])
    else:
        raw_q_sample = "- 없음"

    prompt = f"""
당신은 {job_title} 직무의 채용 총괄 면접관입니다.
아래 분석된 실제 면접 데이터와 키워드를 바탕으로 지원자의 실전 면접 질문 3가지를 생성해 주세요.

[분석된 데이터]
1. 직무 고유 핵심 키워드 (TF-IDF): {', '.join(domain_keywords)}
2. 실무 기술 토픽 (LDA): {tech_topics}
3. 인성/문화 토픽 (LDA): {culture_topics}
4. 실제 후기에서 추출된 질문 원형:
{raw_q_sample}

[출력 형식 가이드]
반드시 아래 3가지 카테고리로 나누어 구체적인 질문을 작성하세요:
1. [실무 기술 검증]: 위 기술 키워드와 프로젝트 경험을 파고드는 질문
2. [직무 가치관 및 협업]: 팀워크, 트러블슈팅, 문화 적합도를 묻는 인성 질문
3. [심화 꼬리/압박 질문]: 지원자가 겪었을 법한 기술적 한계나 장애 상황에 대한 대처 질문
"""

    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[{"role": "user", "content": prompt}],
        temperature=0.7,
    )
    return response["choices"][0]["message"]["content"]
