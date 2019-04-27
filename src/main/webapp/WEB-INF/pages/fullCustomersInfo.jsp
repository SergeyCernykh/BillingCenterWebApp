<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Клиент</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<body>
<span><a href="customers">Клиенты</a></span> | <span><a href="services">Услуги</a></span><br>
<form:form id="formUpdate" modelAttribute="customer" method="post" action="updateCustomerAction">
    <table>
        <form:hidden path="id"/>
        <tr><td>Имя </td><td><form:input path="name"/></td></tr>
        <tr><td>Услуга</td><td> <select id = "serviceid"  name="serviceid">
            <c:forEach items="${services}" var="serv">
                <option value="${serv.id}"> ${serv.name}</option>
            </c:forEach>
        </select></td></tr>
        <tr><td> Максимальный кредит</td><td><form:input path="maxdebt"/></td></tr>
        <tr><td>Компания </td><td><form:checkbox path="companyflag"/></td></tr>
        <tr><td><button type="submit">Сохранить</button></form:form></td>
            <td><form:form id="cancelUpdate" modelAttribute="customer" method="post" action="customers">
                <button>Отмена</button>
            </form:form></td></tr>
    </table>

</body>
</html>
