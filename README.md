# 面接レビュー合否予測プロジェクト (Interview Outcome Prediction)

本プロジェクトは、JobPlanet(ジョブプラネット)の面接レビューデータを活用し、テキスト分析(LDA)および機械学習・ディープラーニングモデル(LightGBM, RNN)を用いて、面接レビューの内容から合格・不合格の確率を予測するAndroidアプリケーションです。

## プロジェクト概要

- **目的**: 面接レビュー文からの合格・不合格予測モデルの開発、職種別予想面接質問の提供、自己紹介書添削、およびAndroidアプリケーションの実装
- **データソース**: JobPlanet 面接レビュー(Webスクレイピング、約31万件収集・クレンジング後257,826件)
- **主な分析手法**:
    - **データ収集**: BeautifulSoup・requestsによるWebスクレイピング
    - **自然言語処理**: MeCabによる形態素解析(7品詞抽出)、Tokenizerを用いた整数エンコーディング、パディング処理
    - **モデル構築**: LDAトピックモデリング、ChatGPT API(`gpt-3.5-turbo`)によるデータ拡張、LightGBM分類器、RNN(LSTM)モデル

## 担当した役割 (My Role)

本プロジェクトはチーム開発で進めており、私は以下の領域を担当しました。

- **モデル設計**: 合否予測のためのLightGBM分類器・RNN(LSTM)モデルの設計と学習パイプラインの構築
- **データクローリングおよび前処理**: JobPlanet面接レビューのWebスクレイピング実装、MeCabによる形態素解析・Tokenizer整数エンコーディング・パディング処理などの前処理設計
- **API呼び出し設計**: ChatGPT API(`gpt-3.5-turbo`によるデータ拡張・自己紹介書添削)およびAndroidアプリからFlaskサーバー(`/predict`, `/feedback`)への通信部分の設計
- **アーキテクチャ設計**: クローリング → 前処理 → モデル学習 → サーバー推論 → Androidアプリという全体パイプラインの構成設計

## ディレクトリ構成

```text
project_root/
├── crawling/      # 面接レビューデータ収集ノートブック (crawl_interview_reviews.ipynb)
├── lda/           # トピックモデリング分析 (topic_modeling_lda.ipynb)
├── chatgpt_api/   # APIを活用したデータ拡張・高度化パイプライン
│   ├── chatgpt_data_augmentation.ipynb
│   └── advanced_question_pipeline.py # 質問生成高度化 (N-gram, TF-IDF, 3段質問生成)
├── prediction/    # モデル学習・評価用ノートブックとTokenizer
├── server/        # 合否予測(/predict)および自己紹介書添削(/feedback) Flaskサーバー
└── app/           # Androidアプリケーション (Kotlin, Gradle)
```

## 主な機能とアーキテクチャ

### 1. 合否予測モデル

入力された面接レビュー文に対し、学習済みモデルを用いて合格の可能性を算出します。

- **LightGBMモデル**: 軽量かつ高速な推論が可能(Test Accuracy: 約83.7%)
- **RNN(LSTM)モデル**: 文脈を考慮したシーケンシャルな学習を実現(Test Accuracy: 約76.9%)
- **前処理**: 形態素解析器 MeCab で合否判定に寄与する品詞(`NNG`, `NNP`, `VA`, `VV`, `XR`, `VA+EC`, `VV+EC`)のみを抽出し、`pad_sequences` で長さを統一(LightGBM: 75, RNN: 100)
- **不均衡データ対策**: `train_test_split` で学習データとテストデータを分割した後、学習データのみに `RandomOverSampler` を適用してデータリーケージを防止

### 2. 予想面接質問および面接雰囲気の要約

業種(銀行・建設・IT・メディア・医療など10業種)×職種の組み合わせごとに、LDAトピックモデリングとChatGPT API(`gpt-3.5-turbo`)で生成した予想面接質問(全208カテゴリ・計1,755問)および面接の雰囲気を表示します。

- **質問生成高度化パイプライン (`advanced_question_pipeline.py`)**:
  - 実レビューから質問文の原型を安全に抽出 (`extract_raw_questions`)
  - N-gram (Bi-gram) 結合による専門用語の文脈維持 (`preprocess_corpus_with_bigrams`)
  - TF-IDF による職種固有の希少技術キーワード抽出 (`extract_domain_specific_keywords`)
  - 実務技術・職種価値観・深層圧迫質問の3段階立体質問セット生成 (`generate_multidimensional_questions`)
- 質問データは `app/app/src/main/assets/interview_questions.json` に集約し、共通の `InterviewQuestionsFragment` がNavigation引数(`question_set`)を受け取って動的に描画する設計としています。

### 3. 自己紹介書添削

自己紹介書の文章を入力すると、ChatGPT API(`gpt-3.5-turbo`)が採用担当者の観点から改善点を添削する機能です。

- Android: `FourthFragment.kt` → Retrofitで `server/coverletter_feedback.py` の `/feedback` エンドポイントを呼び出し
- サーバー: Flask + OpenAI API(`openai==0.27.8`)により「全体の印象」「具体的な改善点」「修正例文」を返却

### 4. Androidアプリケーション (app/)

Kotlin と Gradle で実装されたAndroidアプリです。

**アプリ構成**
```text
app/
├── build.gradle
├── settings.gradle
└── app/
    ├── build.gradle.kts
    └── src/
        ├── main/
        │   ├── AndroidManifest.xml
        │   ├── java/com/nayeon/daechungapp2/
        │   │   ├── MainActivity.kt
        │   │   ├── KeepStateFragment.kt
        │   │   ├── FirstFragment.kt              # 職種別 予想面接質問
        │   │   ├── SecondFragment.kt             # 職種別 合否雰囲気比較
        │   │   ├── ThirdFragment.kt              # 面接結果予測 (/predict 呼び出し)
        │   │   ├── FourthFragment.kt             # 自己紹介書添削 (/feedback 呼び出し)
        │   │   ├── InterviewQuestionsFragment.kt # 予想面接質問 表示Fragment
        │   │   └── (各業種 Job / Feel Fragment)
        │   ├── assets/
        │   │   └── interview_questions.json      # 予想面接質問データ(全208カテゴリ)
        │   └── res/
        ├── test/
        └── androidTest/
```

## 使用ライブラリ・ツール

| カテゴリ | ライブラリ・ツール |
|---|---|
| データ分析・モデル学習 | Python, python-mecab-ko, Gensim(LDA), LightGBM, TensorFlow/Keras, scikit-learn, imbalanced-learn |
| データ収集・加工 | BeautifulSoup, requests, OpenAI API (`openai==0.27.8`, `gpt-3.5-turbo`) |
| APIサーバー | Python, Flask (`server/coverletter_feedback.py`) |
| アプリ | Kotlin, Android SDK, Navigation Component, Retrofit2 |

## セットアップ手順

1. **データ取得**: `crawling/crawl_interview_reviews.ipynb` を実行して面接レビューを収集します。
2. **トピック抽出・データ拡張**: `lda/topic_modeling_lda.ipynb` および `chatgpt_api/chatgpt_data_augmentation.ipynb` を実行します。
3. **モデル学習**: `prediction/train_lgbm_classifier.ipynb` を実行し、`LGBMmodel.txt` と `tokenizer.pickle` を生成します。
4. **APIサーバー起動**:
   ```bash
   pip install -r server/requirements.txt
   export OPENAI_API_KEY=...
   python server/coverletter_feedback.py
   ```
5. **アプリ実行**: `app/` を Android Studio で開き、ビルド・実行します。
