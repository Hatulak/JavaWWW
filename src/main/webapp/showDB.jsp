<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 09.04.2019
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DB</title>
</head>
<body>


<c:forEach var="book" items="${sessionScope.books}">
    ${book.id}<br>
    ${book.title}<br>
    ${book.author}<br>
    ${book.category}<br>
    ${book.cover}<br>
    ${book.price}<br>
</c:forEach>


</body>
</html>
