<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.ZoneId" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ page import="org.example.testing.model.Goods" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Goods</title>
</head>
<body>
<table border="1" align="center" cellpadding="3">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Date and time</th>
        <th>Price</th>
    </tr>
    <jsp:useBean id="goodList" scope="request" type="java.util.List"/>
    <c:forEach var="good" items="${goodList}">
        <jsp:useBean id="dateTimeFormatter" scope="request" type="java.time.format.DateTimeFormatter"/>
        <jsp:useBean id="good" type="org.example.testing.model.Goods.Good"/>
        <tr>
            <td>${good.id}</td>
            <td>${good.name}</td>
            <td>${good.category}</td>
            <td><%=dateTimeFormatter.format(Instant.ofEpochMilli(good.getTimestamp()).atZone(ZoneId.systemDefault()).toLocalDateTime())%>
            </td>
            <td>${good.price}</td>
        </tr>
    </c:forEach>
</table>
category(wired-headphones,wireless-headphones,smart-watches): ${category}<br>
sort(price,date): ${sort}<br>
order(desc,asc): ${order}<br>

</body>
</html>
