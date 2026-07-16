# 面接レビュー合否予測プロジェクト (Interview Outcome Prediction)

本プロジェクトは、Saramin(サラミン)の面接レビューデータを活用し、テキスト分析(LDA)および機械学習・ディープラーニングモデル(LightGBM, RNN)を用いて、面接レビューの内容から合格・不合格の確率を予測するAndroidアプリケーションです。

## プロジェクト概要

- **目的**: 面接レビュー文からの合格・不合格予測モデルの開発、予想面接質問の提供、自己紹介書添削、およびAndroidアプリケーションの実装
- **データソース**: Saramin 面接レビュー掲示板(クローリング)
- **主な分析手法**:
    - **データ収集**: Webスクレイピング
    - **自然言語処理**: MeCabによる形態素解析、Tokenizerを用いた整数エンコーディング、パディング処理
    - **モデル構築**: LDAトピックモデリング、ChatGPT APIによるデータ加工、LightGBM分類器、RNNモデル

## 担当した役割 (My Role)

本プロジェクトはチーム開発で進めており、私は以下の領域を担当しました。

- **モデル設計**: 合否予測のためのLightGBM分類器・RNNモデルの設計と学習パイプラインの構築
- **データクローリングおよび前処理**: Saramin面接レビュー掲示板のWebスクレイピング実装、MeCabによる形態素解析・Tokenizer整数エンコーディング・パディング処理などの前処理設計
- **API呼び出し設計**: ChatGPT API(データ加工・自己紹介書添削)およびAndroidアプリからサーバー(`/predict`, `/feedback`)への通信部分の設計
- **アーキテクチャ設計**: クローリング → 前処理 → モデル学習 → サーバー推論 → Androidアプリという全体パイプラインの構成設計

## ディレクトリ構成

```text
project_root/
├── crawling/      # 面接レビューデータ収集ノートブック (crawl_interview_reviews.ipynb)
├── lda/           # トピックモデリング分析 (topic_modeling_lda.ipynb)
├── chatgpt_api/   # APIを活用したデータ拡張・加工 (chatgpt_data_augmentation.ipynb)
├── prediction/    # モデル学習・評価用ノートブックとTokenizer
├── server/        # 自己紹介書添削API (ChatGPT API連携、Flask)
└── app/           # Androidアプリケーション (Kotlin, Gradle)
```

## 主な機能とアーキテクチャ

### 1. 合否予測モデル

入力されたテキストに対し、学習済みモデルを用いて合格の可能性をパーセンテージで算出します。

- **LGBMモデル**: 軽量かつ高速な推論が可能
- **RNNモデル**: 文脈を考慮したシーケンシャルな学習を実現
- **前処理**: 形態素解析器 MeCab でトークン化を行い、`pad_sequences` で長さを統一(LGBM: 75, RNN: 100)
- モデル自体は `prediction/` のノートブックで学習し、実際の推論はAndroidアプリからRetrofit経由で外部サーバーの `/predict` エンドポイントを呼び出す構成(サーバー実装はこのリポジトリには含まれていません)

### 2. 予想面接質問

業種(銀行・建設・IT・メディア・医療など)×職種の組み合わせごとに、あらかじめ用意した予想面接質問(全208カテゴリ・計1,755問)を表示する機能です。

- 質問データは `app/app/src/main/assets/interview_questions.json` に一元化されています。もともとは業種×職種の組み合わせごとに専用のFragmentクラスとXMLレイアウトへ質問を直接ハードコーディングしており、ほぼ同じ内容のレイアウトが208個重複していました。
- 共通の `InterviewQuestionsFragment` を作り、`question_set` 引数でJSONのキーを指定するだけで任意のカテゴリの質問を表示できるようにリファクタリングしました。呼び出し側(ボタンのnavigate先)はnav_graphの destination id をそのまま使うため変更不要です。
- 現時点では銀行業(`bank_*`, 20カテゴリ)にこのパターンを適用済みです。残りのカテゴリも同じ手順(nav_graphのdestinationを`InterviewQuestionsFragment`に差し替え、対応するJSONキーを引数に指定)で順次移行できます。

### 3. 自己紹介書添削

自己紹介書の文章を入力すると、ChatGPT APIが採用担当者の観点から改善点を添削してくれる機能です。

- Android: `FourthFragment.kt`(入力・表示) → Retrofitで `server/coverletter_feedback.py` の `/feedback` エンドポイントを呼び出し
- サーバー: Flask + OpenAI API。プロンプトで「全体の印象」「具体的な改善点」「改善例文」の3項目で添削結果を返すよう指示しています

### 4. Androidアプリケーション (app/)

Kotlin と Gradle で実装されたAndroidアプリです。ユーザーが面接レビュー文を入力すると、学習済みモデルを用いて合格・不合格の可能性を表示します。

**アプリ構成**
```text
app/
├── build.gradle
├── settings.gradle
└── app/
    ├── build.gradle
    └── src/
        ├── main/
        │   ├── AndroidManifest.xml
        │   ├── java/com/nayeon/daechungapp2/
        │   │   ├── MainActivity.kt
        │   │   ├── KeepStateFragment.kt
        │   │   ├── ThirdFragment.kt          # 面接予測 (/predict 呼び出し)
        │   │   ├── FourthFragment.kt         # 自己紹介書添削 (/feedback 呼び出し)
        │   │   ├── InterviewQuestionsFragment.kt  # 予想面接質問(共通実装)
        │   │   └── (各種業界・職種別 Fragment.kt)
        │   ├── assets/
        │   │   └── interview_questions.json  # 予想面接質問データ(全208カテゴリ)
        │   └── res/
        │       ├── layout/
        │       ├── drawable/
        │       ├── values/
        │       └── menu/
        ├── test/
        └── androidTest/
```

**ビルド・実行方法**

1. Android Studio でプロジェクトを開く
2. Gradle Sync を実行して依存関係を取得
3. エミュレータまたは実機を接続し、Run ▶ ボタンでアプリを起動

パッケージ名は `com.nayeon.daechungapp2` です。

## データについて

- `prediction/tokenizer.pickle` : 学習時に使用したTokenizerオブジェクト(推論時に同じものを再利用する必要あり)
- クローリングで収集した生データや学習済みモデルの重みファイルは、個人情報・サイズの理由からこのリポジトリには含まれていません。`crawling/` `prediction/` のノートブックを実行することで再現できます。

## 使用ライブラリ・ツール

| カテゴリ | ライブラリ・ツール |
|---|---|
| データ分析・モデル学習 | Python, python-mecab-ko, LightGBM, TensorFlow/Keras, scikit-learn, Pickle |
| データ収集・加工 | Webスクレイピング, ChatGPT API |
| 自己紹介書添削サーバー | Python, Flask, OpenAI API (`server/`) |
| アプリ | Kotlin, Android SDK, Gradle, Retrofit |

## セットアップ手順

1. **データ取得**: `crawling/` 内のノートブックを実行し、データを収集します(要ログイン情報)。
2. **前処理・分析**: `lda/` および `chatgpt_api/` でデータのクレンジングと特徴量抽出を行います。
3. **モデル学習**: `prediction/` にある各ノートブックを実行し、モデルを学習・保存します。
4. **自己紹介書添削サーバー起動** (任意):
   ```bash
   pip install -r server/requirements.txt
   export OPENAI_API_KEY=...
   python server/coverletter_feedback.py
   ```
5. **アプリ実行**: 学習済みモデルを Android アプリに組み込む、または API サーバー経由で呼び出せるよう連携し、`app/` を Android Studio でビルド・実行します。

## 注意事項

> ⚠️ クローリングコードにはログインID・パスワードの入力が必要です。実行前にご自身のアカウント情報に置き換えるか、`.env` ファイルに分離して使用してください。
>
> ⚠️ ChatGPT API・OpenAI API を利用するノートブック/サーバーは API キーを環境変数(`OPENAI_API_KEY`)で受け取る形式です。コードに直接キーを書き込まないでください。
>
> ⚠️ Android プロジェクト内の `build/`、`.gradle/`、`.idea/`、`local.properties` はビルドキャッシュ・IDE設定・ローカル環境固有情報であり、`.gitignore` で除外しています。
>
> ⚠️ Android アプリが呼び出す `/predict` `/feedback` サーバーのホスト(`14.39.70.187`)は開発当時のものです。実際に動かす場合は、ご自身が起動したサーバーのアドレスに書き換えてください。
