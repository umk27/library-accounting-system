<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.03.2022
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Книги автора ${author.name}
<br>
<br>

<table>
    <tr>
        <th>Название</th>
        <th>Число страниц</th>
        <th>Книг в наличии</th>
        <th>Книг на балансе</th>
    </tr>

    <c:forEach var="b" items="${booksOfAuthor}">

        <tr>
            <td>${b.title}</td>
            <td>${b.countPage}</td>
            <td>${b.numberOfBooksAvailable}</td>
            <td>${b.numberOfBooksOnBalance}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
