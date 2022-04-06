<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2022
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save-reader</title>
</head>
<body>

<h2>Введите имя читателя</h2>
<br>
<br>

<form:form action="saveReaderQuery" modelAttribute="reader">

    Имя читателя <form:input path="name"/>
    <br><br>

    <input type="submit" value="Сохранить читателя"/>

</form:form>
<br>
<br>
${mes}
<br>
<br>
<a href="/">Вернуться на главную страницу</a>

</body>
</html>
