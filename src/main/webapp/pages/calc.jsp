<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 04.02.2021
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<br>
<s:form modelAttribute="ModelAttributeCalc" action="/calc" method="post">
    <input type="text" name="fNum" placeholder="First number">
    <s:errors>${fNum}</s:errors>
    <input type="text" name="sNum" placeholder="Second number">
    <input type="text" name="oper" placeholder="Operation">
    <button>Get result</button>
</s:form>
<%--<form action="/calc" method="post">--%>
<%--    <div class="row">--%>
<%--        <div class="col">--%>
<%--            <input type="text" name="fNum" placeholder="First number">--%>
<%--        </div>--%>
<%--        <br>--%>
<%--        <p style="color: coral">${fNum}</p>--%>
<%--        <br>--%>
<%--        <div class="col">--%>
<%--            <input  type="text" name="sNum" class="form-control" placeholder="Second number" aria-label="Second number">--%>
<%--        </div>--%>
<%--        <br>--%>
<%--        <p style="color: coral">${sNum}</p>--%>
<%--        <br>--%>
<%--        <div class="col">--%>
<%--            <input type="text" name = "oper" class="form-control" placeholder="Oper" aria-label="Oper">--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <br>--%>
<%--    <button>Get result</button>--%>
<%--</form>--%>
<p>Result: ${result}</p>
</body>
</html>
