<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<br>
<form action="/user/authorization", method="post">
    <input name="login" type="text" placeholder="login">
    <input name="password" type="text" placeholder="password">
    <button>Sign in</button>
</form>
<br>
<p>${wrongResult}</p>
</body>
</html>