<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規ユーザー登録フォーム</title>
    </head>
    <body>
        <form action="/ad0818/RegisterUser" method="post">
             ユーザID:<input type="text" name="userId"><br>
            パスワード:<input type="password" name ="pass"><br>
            <input type="submit" value="登録">
        </form>
           <a href ="/ad0818/Welcome">キャンセル</a>
    </body>
</html>
