"""자기소개서 첨삭 API 서버.

Android 앱(FourthFragment)에서 보낸 자기소개서 텍스트를 ChatGPT API로 첨삭해 반환한다.
기존 면접 합불예측 서버(/predict, 이 저장소에는 미포함)와 같은 호스트에서 함께
서빙하는 것을 가정하고 동일한 Flask 앱 구조를 따른다.

실행:
    export OPENAI_API_KEY=...
    python server/coverletter_feedback.py
"""
import os

from flask import Flask, jsonify, request
from openai import OpenAI

app = Flask(__name__)
client = OpenAI(api_key=os.environ["OPENAI_API_KEY"])

FEEDBACK_PROMPT = """당신은 채용 담당자 관점에서 자기소개서를 첨삭하는 전문가입니다.
아래 자기소개서를 읽고 다음 항목에 맞춰 첨삭 결과를 작성하세요.

1. 전반적인 인상 (2~3문장)
2. 구체적으로 보완하면 좋은 점 (원문 문장을 인용하며 2~4개)
3. 개선 예시 문장 (최소 1개)

자기소개서:
{cover_letter}
"""


@app.route("/feedback", methods=["POST"])
def feedback():
    payload = request.get_json(force=True) or {}
    cover_letter = payload.get("data", "").strip()
    if not cover_letter:
        return jsonify({"feedback": "자기소개서 내용을 입력해주세요."}), 400

    response = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[{"role": "user", "content": FEEDBACK_PROMPT.format(cover_letter=cover_letter)}],
        temperature=0.4,
    )
    return jsonify({"feedback": response.choices[0].message.content})


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
