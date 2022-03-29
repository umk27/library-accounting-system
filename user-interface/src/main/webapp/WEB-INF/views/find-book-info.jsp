<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    <input type="submit" value="Найти"/>

</form:form>
<br>
<br>
${ex}


</body>
</html>
