<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2022
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="showBooksOfReader" modelAttribute="reader">

    Имя читателя <form:input path="name"/>
    <br><br>

    <input type="submit" value="Найти книги читателя"/>

</form:form>
<br>
<br>
${mes}

</body>
</html>
