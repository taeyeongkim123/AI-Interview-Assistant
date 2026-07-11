import os
import pickle
import re

from flask import Flask, jsonify, request
import lightgbm as lgb
from mecab import MeCab
import openai
from tensorflow.keras.preprocessing.sequence import pad_sequences

app = Flask(__name__)
openai.api_key = os.getenv("OPENAI_API_KEY")

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
TOKENIZER_PATH = os.path.join(BASE_DIR, "prediction", "tokenizer.pickle")
MODEL_PATH = os.path.join(BASE_DIR, "prediction", "LGBMmodel.txt")

mecab = MeCab()
TARGET_POS = ["NNG", "NNP", "VA", "VV", "XR", "VA+EC", "VV+EC"]
MAX_LEN = 75

with open(TOKENIZER_PATH, "rb") as handle:
    tokenizer = pickle.load(handle)

bst = lgb.Booster(model_file=MODEL_PATH) if os.path.exists(MODEL_PATH) else None


def preprocess_text(text):
    cleaned = re.sub(r"[^가-힣a-zA-Z0-9\s]", " ", text)
    pos_tagged = mecab.pos(cleaned)
    words = [word for word, tag in pos_tagged if tag in TARGET_POS]
    encoded = tokenizer.texts_to_sequences([words])
    return pad_sequences(encoded, maxlen=MAX_LEN)


@app.route("/predict", methods=["POST"])
def predict():
    payload = request.get_json(force=True) or {}
    text = payload.get("data", "").strip()
    if not text:
        return jsonify({"prediction": "면접 후기 내용을 입력해주세요."}), 400

    if bst is None:
        return jsonify({"prediction": "모델 파일(LGBMmodel.txt)을 찾을 수 없습니다."}), 500

    padded = preprocess_text(text)
    prob = float(bst.predict(padded)[0])
    result = "합격 가능성이 높습니다." if prob >= 0.5 else "불합격 가능성이 높습니다."
    return jsonify({"prediction": f"{result} (예측 확률: {prob * 100:.1f}%)"})


@app.route("/feedback", methods=["POST"])
def feedback():
    payload = request.get_json(force=True) or {}
    cover_letter = payload.get("data", "").strip()
    if not cover_letter:
        return jsonify({"feedback": "자기소개서 내용을 입력해주세요."}), 400

    prompt = (
        "아래 자기소개서를 읽고 채용 담당자 관점에서 "
        "1) 전반적인 인상, 2) 보완이 필요한 부분, 3) 수정 예시 문장을 작성해 주세요.\n\n"
        f"{cover_letter}"
    )

    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[{"role": "user", "content": prompt}],
    )
    answer = response["choices"][0]["message"]["content"]
    return jsonify({"feedback": answer})


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
