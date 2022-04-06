<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2022
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>return-book</title>
</head>
<body>

<h2>Введите название книги, имя автора и имя читателя</h2>
<br>
<br>

<form:form action="returnBookQuery" modelAttribute="book">

    Название <form:input path="title"/>
    <br><br>
    Автор <form:input path="authorName"/>
    <br><br>
    Читатель <form:input path="readerName"/>
    <br><br>
    <input type="submit" value="Забрать книгу"/>

</form:form>
<br>
<br>
${mes}
<br>
<br>
<a href="/">Вернуться на главную страницу</a>

</body>
</html>
