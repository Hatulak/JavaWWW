<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 14.04.2019
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Update</title>
</head>
<body>

<c:if test="${requestScope.bookToUpdate != null}">
    <form action="updateBook" method="post">
        Tile: <input type="text" name="title" value="${requestScope.bookToUpdate.title}">
        Category:<input type="text" name="category" value="${requestScope.bookToUpdate.category}">
        Cover: <input type="text" name="cover" value="${requestScope.bookToUpdate.cover}">
        Author: <input type="text" name="author" value="${requestScope.bookToUpdate.author}">
        Price: <input type="number" name="price" value="${requestScope.bookToUpdate.price}">
        <input type="submit" value="updateBook">
    </form>
</c:if>

<c:if test="${requestScope.bookToUpdate == null}">
    No book was selected :(
</c:if>


</body>
</html>
