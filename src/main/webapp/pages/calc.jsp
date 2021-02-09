<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 04.02.2021
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<br>
<form action="/calc" method="post">
    <div class="row">
        <div class="col">
            <input type="number" name="fNum" class="form-control" placeholder="First number" aria-label="First number">
        </div>
        <div class="col">
            <input type="number" name="sNum" class="form-control" placeholder="Second number" aria-label="Second number">
        </div>
        <div class="col">
            <input type="text" name = "oper" class="form-control" placeholder="Oper" aria-label="Oper">
        </div>
    </div>
    <br>
    <button>Get result</button>
</form>
<p>Result: ${result}</p>
</body>
</html>
