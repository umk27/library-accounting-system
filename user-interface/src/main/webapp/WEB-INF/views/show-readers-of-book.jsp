<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.03.2022
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Читатели, которые взяли книгу ${book.title}</h2>

<table>
    <tr>
        <th>Читатели</th>
    </tr>

    <c:forEach var="r" items="${readersOfBook}">

    <tr>
        <td>${r.name}</td>

    </tr>

    </c:forEach>

    <br>
    <br>
    ${mes}

</body>
</html>
