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

<form action="process" method="post">
    <table>
        <c:forEach var="book" items="${sessionScope.books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.category}</td>
                <td>${book.cover}</td>
                <td>${book.price}</td>
                <td><input type="checkbox" name="checked" value="${book.id}"></td>
                <td><input type="radio" name="selected" value="${book.id}"></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" name="deleteButton" value="Delete Checked">
    <input type="submit" name="updateButton" value="Update Selected">
</form>

<form><input type="button" onclick="window.location.href = 'http://localhost:8080/testjava_war_exploded/createBook';"
             value="Create New Book"></form>
</body>
</html>
