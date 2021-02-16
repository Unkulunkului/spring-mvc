<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 04.02.2021
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>HELLO, <c:out value="${sessionScope.user.name}" default="guest"/>. IT'S A MAIN PAGE!!!!!</h1>
<c:if test="${user==null}">
    <a href="/user/registration">Sing up</a>
    <br>
    <a href="/user/authorization">Sing in</a>
    <br>
</c:if>
<c:if test="${user != null}">
    <a href="/calc">Calc</a>
    <a href="/user/logout">Log out</a>
</c:if>
</body>
</html>
