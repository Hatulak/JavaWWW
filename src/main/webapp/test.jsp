<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 19.03.2019
  Time: 09:05
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Test</title>
</head>
<body>
<h1>Autor: Przemysław Piątek</h1>
<%--${applicationScope}--%>
<c:forTokens var="czlowiek" items="Przemek,Mateusz,Adam,Slawek,Damian,Jakub,Andrzej" delims=",">
    <c:out value="${czlowiek}"/><br>
</c:forTokens>
</body>
</html>
