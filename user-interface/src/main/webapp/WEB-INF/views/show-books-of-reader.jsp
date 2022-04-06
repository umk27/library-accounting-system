<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2022
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show-books-of-reader</title>
</head>
<body>

<h2>Книги, которые взял читатель ${reader.name}</h2>

<table>
    <tr>
        <th>Название</th>
        <th>Число страниц</th>
    </tr>

    <c:forEach var="b" items="${booksOfReader}">

        <tr>
            <td>${b.title}</td>
            <td>${b.countPage}</td>
        </tr>

    </c:forEach>
</table>
<br>
<br>
<a href="/">Вернуться на главную страницу</a>

</body>

</html>
