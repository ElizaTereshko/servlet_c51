<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10.02.2022
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="nav" style="background-color: lightblue">
  <div class="btn-group" role="group" aria-label="Basic example">
    <a class="nav-link" href="/">Home</a>
    <a class="nav-link" href="/history_calculator">History</a>
  </div>
</nav>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-sm-5">
      <form action="/calculator" method="post">
        <div class="mb-3">
          <input type="text" name="theFirstValue" placeholder="The first value" class="form-control" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
        </div>
        <select class="form-select mb-3" name="operationSign" required>
          <option disabled selected>Choose operation</option>
          <option value="+">+</option>
          <option value="/">/</option>
          <option value="-">-</option>
          <option value="*">*</option>
        </select>
        <div class="mb-3">
          <input type="text" name="theSecondValue" placeholder="The second value" class="form-control" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
        </div>
        <button type="submit" class="btn btn-primary">Result</button>
        ${requestScope.msgInvalidData}
        ${requestScope.msgInfinity}
        ${requestScope.msgOperation}
        ${requestScope.result}
      </form>
    </div>
  </div>
</div>
</body>
</html>
