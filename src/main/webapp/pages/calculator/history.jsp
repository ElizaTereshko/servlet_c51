<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08.02.2022
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="nav" style="background-color: lightblue">
    <div class="btn-group" role="group" aria-label="Basic example">
        <a class="nav-link" href="/calculator">Calculator</a>
        <div class="row justify-content-right">
            <form action="/logout" method="post">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </div>
    </div>
</nav>
<nav class="nav" style="background-color: white">
    <h5>History:</h5>
</nav>
${requestScope.history}
${requestScope.msgEmpty}
</body>
</html>
