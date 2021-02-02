## Amplify API(Graphql)で自動生成される Vehicle クラスについて

バックエンドが変更された際、
下記のコマンドにて、
`amplify codegen`
バックエンドに応じたコードが以下に生成される
`/app/src/main/java/com/amplifyframework/datastore/generated/model`

しかし、Android での amplify codegen は不具合があり(v4.41.2)

1. javascript で Graphql を作成
2. その際、プライマリーキーに ID 型を割り当てて、適当な名前をつける
3. 別のソース(Java)にて `amplify pull` を利用してバックエンドを参照し、`amplify codegen`にてコードを作成する
4. プライマリーキーを利用して API を呼び出そうとすると、ID 型は UUID のフォーマットでないとだめ、といったエラーを生成したコードから吐かれる
5. エラーを吐く箇所をコメントアウトすると動作する。

### 原因：

Javascript では ID 型に UUID の制限が無いのに対し、Java では UUID の制限がある、という一貫性のなさから生じていると思われる
