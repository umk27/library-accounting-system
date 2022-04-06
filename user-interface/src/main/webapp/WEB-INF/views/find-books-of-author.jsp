<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.03.2022
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find-books-of-author</title>
</head>
<body>

<h2>Введите имя автора</h2>
<br>
<br>

<form:form action="showBooksOfAuthor" modelAttribute="author">

    Автор <form:input path="name"/>
    <br><br>

    <input type="submit" value="Найти книги автора"/>

</form:form>
<br>
<br>
${ex}
<br>
<br>
<a href="/">Вернуться на главную страницу</a>

</body>
</html>
