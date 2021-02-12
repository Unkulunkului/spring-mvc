<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<br>
<form action="/user/authorization", method="post">
    <input name="login" type="text" placeholder="login">
    <br>
    <p style="color: red">${login}</p>
    <br>
    <input name="password" type="text" placeholder="password">
    <br>
    <p style="color: red">${password}</p>
    <br>
    <button>Sign in</button>
</form>
<br>
<p>${wrongResult}</p>
</body>
</html>