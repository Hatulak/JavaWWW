<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 19.03.2019
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fd" uri="/WEB-INF/funkcjeDaty" %>
<!DOCTYPE html>
<html>
<head>
    <title>Jsp Test</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<c:set var="testSet" scope="session" value="${\"TEST C:SET\"}"/>
<c:out value="${testSet}"/>

<h1>Autor: Przemysław Piątek</h1>

Liczba: ${liczba} <br>
Liczba2: ${liczba2}<br>

<c:forEach var="napis" items="${napisy}" varStatus="i">
    Napis nr: ${i.count} ${napis}<br>
</c:forEach>

<br><br>
<h1>Obiekt książki: ${ksiazka.tytul} , ${ksiazka.autor}</h1>


<c:forEach var="napis" items="${sessionScope.inne_napisy}" varStatus="i">
    Inny napis nr:<b> ${i.count} ${napis}</b><br>
</c:forEach>

<c:out value="test c:out"/>

<c:catch var="catchBlock">
    <% int test = 1 / 0;%>
</c:catch>
<c:if test="${catchBlock != null}">
    <p>Wyrzucony wyjatek:<b> ${catchBlock}</b> <br>
        Wiadomosc wyjatku:<b> ${catchBlock.message}</b></p>
</c:if>

<c:choose>
    <c:when test="${liczba <= 0}">
        Liczba: ${liczba} jest mniejsza lub rowna 0
    </c:when>

    <c:when test="${liczba >=10}">
        Liczba: ${liczba} jest wieksza lub rowna 10
    </c:when>

    <c:otherwise>
        Liczba: ${liczba} jest z zakresu 1-9
    </c:otherwise>
</c:choose>
<br>

<c:forTokens items="Przemek,Adam,Jakub,Mateusz,Damian,Andrzej,Sławomir,Alan" delims="," var="imie">
    <c:out value="${imie}"/><br>
</c:forTokens>

<br><br><br><br><br>
<h1>Zawartosc strony index.jsp</h1>
<c:import var="link" url="http://localhost:8080/testjava_war_exploded/index.jsp"/>
<c:out value="${link}"/>

<br><br>
<c:remove var="link"/>
<p>After Removing link: <c:out value="${link}"/></p>

<br>
${fd:dzisiejszaData()} <br>
${fd:formatujZliczb(12,10 ,1293)}<br>
${fd:formatujZNapisow("10","maj" ,"1982")}<br>


</body>
</html>
