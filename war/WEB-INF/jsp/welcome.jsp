<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ようこそ</title>
    </head>
    <body>
        <form action="/ad0818/LoginServlet" method="post">
            ユーザーID:<input type="text" name="userId"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
            <a href="/ad0818/RegisterUser">新規登録</a>
        </form>
    </body>
</html>