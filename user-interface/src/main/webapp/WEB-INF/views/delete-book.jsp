<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2022
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-book</title>
</head>
<body>

<h2>Введите название книги и имя автора</h2>
<br>
<br>
<form:form action="deleteBookQuery" modelAttribute="book">

    Название <form:input path="title"/>
    <br><br>
    Автор <form:input path="authorName"/>
    <br><br>

    <input type="submit" value="Удалить книгу"/>

</form:form>
<br>
<br>
${mes}
<br>
<br>
<a href="/">Вернуться на главную страницу</a>

</body>
</html>
