<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 02.04.2019
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="el" items="${applicationScope['list']}">
    ${el}<br>
</c:forEach>


<form action="jspFormToAddNumber" method="post" id="form1"><br/>

    <input type="number" name="newNumber"><br/>

    <input type="submit" value="Send">
</form>

</body>
</html>
