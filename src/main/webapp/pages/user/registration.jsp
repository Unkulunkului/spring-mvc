<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<br>
<form action="/user/registration", method="post">
    <input name="login" type="text" placeholder="login">
    <br>
    <p style="color: red">${login}</p>
    <br>
    <input name="password" type="text" placeholder="password">
    <br>
    <p style="color: red">${password}</p>
    <br>
    <input name="name" type="text" placeholder="name">
    <br>
    <p style="color: red">${name}</p>
    <br>
    <button>Sign up</button>
</form>
</body>
</html>
