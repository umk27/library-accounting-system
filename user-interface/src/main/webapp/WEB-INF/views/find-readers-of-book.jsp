<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.03.2022
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find-readers-of-book</title>
</head>
<body>

<h2>Введите название книги и имя автора</h2>

<form:form action="showReadersOfBook" modelAttribute="book">

    Название <form:input path="title"/>
    <br><br>
    Автор <form:input path="authorName"/>
    <br><br>

    <input type="submit" value="Найти читателей книги"/>

</form:form>
<br>
<br>
${mes}
<br>
<br>
<a href="/">Вернуться на главную страницу</a>
</body>
</html>
