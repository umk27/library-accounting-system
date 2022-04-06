<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find-book-info</title>
</head>
<body>

<h2>Введите название книги и имя автора</h2>
<br>
<br>

<form:form action="showBookInfo" modelAttribute="book">

    Название <form:input path="title"/>
    <br><br>
    Автор <form:input path="authorName"/>
    <br><br>

    <input type="submit" value="Найти информацию о книге"/>

</form:form>
<br>
<br>
${ex}
<br>
<br>
<a href="/">Вернуться на главную страницу</a>


</body>
</html>
