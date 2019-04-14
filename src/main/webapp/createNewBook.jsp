<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 14.04.2019
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="createBook" method="post">
    Tile: <input type="text" name="title" value="title">
    Category:<input type="text" name="category" value="category">
    Cover: <input type="text" name="cover" value="cover">
    Author: <input type="text" name="author" value="author">
    Price: <input type="number" name="price" value="10">
    <input type="submit" value="createBook">
</form>

</body>
</html>
