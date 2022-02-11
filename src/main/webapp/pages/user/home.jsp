<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08.02.2022
  Time: 1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<c:if test="${sessionScope.login != null}">
    <nav class="nav" style="background-color: lightblue">
        <div class="btn-group" role="group" aria-label="Basic example">
            <a class="nav-link" href="/calculator">Calculator</a>
            <form action="/logout" method="post">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </div>
    </nav>
</c:if>

<c:if test="${sessionScope.login == null}">
    <nav class="nav" style="background-color: lightblue">
        <a class="nav-link" href="/registration">Registration</a>
        <a class="nav-link" href="/authorization">Authorization</a>
    </nav>
</c:if>
</body>
</html>
