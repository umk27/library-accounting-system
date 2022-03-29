<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="saveBookQuery" modelAttribute="book">

    Название <form:input path="title"/>
    <br><br>
    Автор <form:input path="authorName"/>
    <br><br>
    Число страниц <form:input path="countPage"/>
    <br><br>
    Книг на балансе <form:input path="numberOfBooksOnBalance"/>
    <br><br>

    <input type="submit" value="Сохранить книгу"/>

</form:form>
<br>
<br>
${mes}

</body>
</html>
