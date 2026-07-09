# 面接レビュー合否予測プロジェクト (Interview Outcome Prediction)

本プロジェクトは、Saramin(サラミン)の面接レビューデータを活用し、テキスト分析(LDA)および機械学習・ディープラーニングモデル(LightGBM, RNN)を用いて、面接レビューの内容から合格・不合格の確率を予測するAndroidアプリケーションです。

## プロジェクト概要

- **目的**: 面接レビュー文からの合格・不合格予測モデルの開発およびAndroidアプリケーションの実装
- **データソース**: Saramin 面接レビュー掲示板(クローリング)
- **主な分析手法**:
    - **データ収集**: Webスクレイピング
    - **自然言語処理**: MeCabによる形態素解析、Tokenizerを用いた整数エンコーディング、パディング処理
    - **モデル構築**: LDAトピックモデリング、ChatGPT APIによるデータ加工、LightGBM分類器、RNNモデル

## ディレクトリ構成

```text
project_root/
├── crawling/      # 面接レビューデータ収集スクリプト
├── lda/           # トピックモデリング分析
├── chatgpt_api/   # APIを活用したデータ拡張・加工
├── prediction/    # モデル学習および評価用ノートブック
├── models/        # 学習済みモデル (LGBM, RNN)
├── data/          # 生データ・前処理済みデータ・Tokenizer
└── app/           # Androidアプリケーション (Kotlin, Gradle)
```

## 主な機能とアーキテクチャ

### 1. 合否予測モデル

入力されたテキストに対し、学習済みモデルを用いて合格の可能性をパーセンテージで算出します。

- **LGBMモデル**: 軽量かつ高速な推論が可能(`models/LGBMmodel.txt`)
- **RNNモデル**: 文脈を考慮したシーケンシャルな学習を実現(`models/RNNmodel.h5`)
- **前処理**: 形態素解析器 MeCab でトークン化を行い、`pad_sequences` で長さを統一(LGBM: 75, RNN: 100)

### 2. Androidアプリケーション (app/)

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
        │   │   └── (各種業界・職種別 Fragment.kt)
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

- `data/raw/` : クローリングで収集した未加工の面接レビューテキスト
- `data/processed/` : 形態素解析・トークン化・パディングまで完了した学習用データ
- `data/tokenizer/` : 学習時に使用したTokenizerオブジェクト(推論時に同じものを再利用する必要あり)

> ⚠️ 個人情報(実名・連絡先など)が含まれるデータはリポジトリに含めず、`.gitignore` で除外することを推奨します。モデルファイルやデータ容量が大きい場合はGit LFSの利用も検討してください。

## 使用ライブラリ・ツール

| カテゴリ | ライブラリ・ツール |
|---|---|
| データ分析・モデル学習 | Python, python-mecab-ko, LightGBM, TensorFlow/Keras, scikit-learn, Pickle |
| データ収集・加工 | Webスクレイピング, ChatGPT API |
| アプリ | Kotlin, Android SDK, Gradle |

## セットアップ手順

1. **データ取得**: `crawling/` 内のノートブックを実行し、データを収集します(要ログイン情報)。
2. **前処理・分析**: `lda/` および `chatgpt_api/` でデータのクレンジングと特徴量抽出を行います。
3. **モデル学習**: `prediction/` にある各ノートブックを実行し、モデルを学習・保存します。
4. **アプリ実行**: 学習済みモデルを Android アプリに組み込む、または API サーバー経由で呼び出せるよう連携し、`app/` を Android Studio でビルド・実行します。

## 注意事項

> ⚠️ クローリングコードにはログインID・パスワードの入力が必要です。実行前にご自身のアカウント情報に置き換えるか、`.env` ファイルに分離して使用してください。
>
> ⚠️ ChatGPT API を利用するノートブックは API キーを環境変数(`OPENAI_API_KEY`)またはプロンプト入力で受け取る形式に変更済みです。コードに直接キーを書き込まないでください。
>
> ⚠️ Android プロジェクト内の `build/`、`.gradle/`、`.idea/` フォルダはビルドキャッシュ・IDE設定であり、リポジトリには含めず `.gitignore` で除外することを推奨します。

## チームメンバー

- 9班(2023年データ青年キャンパス)

## ライセンス

本プロジェクトは教育目的で作成されました。
