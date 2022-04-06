<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.02.2022
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show-book-info</title>
</head>
<body>

Название: ${book.title}
<br>
<br>
Имя автора: ${book.author.name}
<br>
<br>
Число страниц: ${book.countPage}
<br>
<br>
Число книг в наличии: ${book.numberOfBooksAvailable}
<br>
<br>
Число книг на балансе: ${book.numberOfBooksOnBalance}

<br>
<br>
<a href="/">Вернуться на главную страницу</a>

</body>
</html>
