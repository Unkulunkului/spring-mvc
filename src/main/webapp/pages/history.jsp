<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<div class="container">
    <h3>History: </h3>
    <p>
        <c:forEach var="oper" items="${history}">
    <th>${oper}</th>
    <br>
    </c:forEach>
    </p>
</div>
</body>
</html>
