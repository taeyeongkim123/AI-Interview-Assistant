# 面接レビューに基づく合否予測プロジェクト

2023年データ青年キャンパス9班のプロジェクトです。
Saramin(サラミン)の面接レビューデータをクローリングし、テキスト分析(LDA)と機械学習/ディープラーニングモデル(LGBM、RNN)を活用して、面接レビューの文章が合格・不合格のどちらに近いかを予測します。さらに、学習済みモデルを実際に使えるアプリケーションとしても提供します。

## プロジェクト概要

- **目的**: 面接レビューのテキストのみから合格・不合格の可能性を予測するモデルの開発、およびそれを利用するアプリの実装
- **データソース**: Saramin 面接レビュー掲示板(クローリング)
- **分析手法**: LDAトピックモデリング、ChatGPT APIの活用、LGBM/RNN分類モデル

## フォルダ構成

```
데청캠_9조_프로젝트/
├── README.md
├── data/
│   ├── raw/                       # クローリングした生データ
│   ├── processed/                 # 前処理・トークン化済みデータ
│   └── tokenizer/
│       ├── tokenizer.pickle       # LGBM用 Tokenizer
│       └── tokenizer02.pickle     # RNN用 Tokenizer
├── crawling/
│   └── 데이터크롤링.ipynb          # Saramin 面接レビューのクローリング(ログイン必須)
├── lda/
│   └── LDA_Colab.ipynb            # LDAトピックモデリング
├── chatgpt_api/
│   └── chatgpt_api이용.ipynb      # ChatGPT APIを活用したデータ加工・分析
├── prediction/
│   ├── 합불예측_LGBM.ipynb
│   ├── 합불예측_LGBM테스트.ipynb
│   ├── 합불예측_LGBM테스트수정_최종.ipynb
│   ├── 합불예측_rnn.ipynb
│   ├── 합불예측_rnn_epoch_1.ipynb
│   └── 합불예측_rnn테스트.ipynb
├── models/
│   ├── LGBMmodel.txt               # 学習済みLGBMモデル
│   └── RNNmodel.h5                 # 学習済みRNNモデル
└── app/
    ├── app.py                      # Flaskアプリケーション本体(合否予測)
    ├── requirements.txt            # アプリ実行に必要なライブラリ一覧
    ├── templates/
    │   └── index.html              # 入力フォーム・結果表示ページ
    └── static/
        └── style.css                # 画面スタイル(任意)
```

## 主な機能

### 1. データクローリング
Saraminにログインし、面接レビュー掲示板のテキストデータを収集します。収集した生データは `data/raw/` に保存されます。
> ⚠️ クローリングコードにはログインID・パスワードの入力が必要です。実行前にご自身のアカウント情報に置き換えるか、`.env` ファイルに分離して使用してください。

### 2. LDAトピックモデリング
収集した面接レビューのテキストから、主要なトピック(面接の雰囲気、質問の種類、難易度など)を抽出します。

### 3. 合否予測モデル
- **前処理**: `mecab` を用いた韓国語形態素解析によるトークン化、`Tokenizer` による整数エンコーディング、`pad_sequences` によるシーケンス長の統一(LGBM: max_len=75、RNN: max_len=100)
- **モデル1(LGBM)**: LightGBMベースの分類モデル(`models/LGBMmodel.txt`)
- **モデル2(RNN)**: Kerasベースの分類モデル(`models/RNNmodel.h5`)
- どちらのモデルも、入力文に対して合格・不合格の確率(%)を出力します。

**予測関数の使用例**
```python
input_sentence = "대답을 잘 하고 나왔다."
predicted_result = predict_sen(input_sentence, model)
print(predicted_result)
# This sentence is 88.23% likely to be 합격.
```

### 4. アプリケーション(app/, Flask)
Flaskで実装したWebアプリです。ユーザーが面接レビュー文を入力すると、学習済みモデル(LGBMまたはRNN)が合格・不合格の可能性を返します。

```bash
cd app
pip install -r requirements.txt
python app.py
```

実行後、ターミナルに表示される `http://127.0.0.1:5000` にブラウザでアクセスして利用します。

**`app.py` の想定構成例**
```python
from flask import Flask, render_template, request
import pickle
# import lightgbm as lgb  # または from tensorflow.keras.models import load_model

app = Flask(__name__)

# モデル・Tokenizerの読み込み
# model = lgb.Booster(model_file='../models/LGBMmodel.txt')
# with open('../data/tokenizer/tokenizer.pickle', 'rb') as f:
#     tokenizer = pickle.load(f)

@app.route('/', methods=['GET', 'POST'])
def index():
    result = None
    if request.method == 'POST':
        sentence = request.form['sentence']
        # result = predict_sen(sentence, model)
    return render_template('index.html', result=result)

if __name__ == '__main__':
    app.run(debug=True)
```

## データについて

- `data/raw/` : クローリングで収集した未加工の面接レビューテキスト
- `data/processed/` : 形態素解析・トークン化・パディングまで完了した学習用データ
- `data/tokenizer/` : 学習時に使用したTokenizerオブジェクト(推論時に同じものを再利用する必要あり)

> ⚠️ 個人情報(実名・連絡先など)が含まれるデータはリポジトリに含めず、`.gitignore` で除外することを推奨します。モデルファイルやデータ容量が大きい場合はGit LFSの利用も検討してください。

## 使用ライブラリ

- `python-mecab-ko` — 韓国語形態素解析
- `lightgbm` — LGBMモデル
- `tensorflow` (`keras`) — RNNモデル、Tokenizer、pad_sequences
- `scikit-learn` — データ分割、評価指標
- `pickle` — Tokenizerオブジェクトの保存・読み込み
- `flask` — Webアプリケーションフレームワーク

## 実行方法

1. Google Colab で各ノートブックを実行(Google Drive のマウントが必要)
2. `crawling` → `lda`/`chatgpt_api` → `prediction` の順に実行することを推奨
3. モデルファイル(`models/LGBMmodel.txt`、`models/RNNmodel.h5`)と tokenizer(`data/tokenizer/*.pickle`)は、ご自身の Google Drive のパスに合わせて修正してください
4. モデル学習・保存後、`app/` フォルダのアプリケーションを実行して実際に予測を試すことができます

```python
model = lgb.Booster(model_file='自分のパス/models/LGBMmodel.txt')
# または
model = load_model('自分のパス/models/RNNmodel.h5')
```

## チームメンバー

- 9班(2023年データ青年キャンパス)

## ライセンス

本プロジェクトは教育目的で作成されました。
