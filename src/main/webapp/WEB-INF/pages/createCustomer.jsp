<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Создание клиента</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<body>
<span><a href="customers">Клиенты</a></span> | <span><a href="services">Услуги</a></span><br>
<form:form id="formCreate" modelAttribute="customer" method="post" action="saveCustomerAction">
    <table>
        <tr><td>Имя </td><td><form:input id="name" path="name"/></td></tr>
        <tr><td>Услуга</td><td> <select id="serviceid"  name="serviceid">
            <option value="${null}"> ----- </option>
            <c:forEach items="${services}" var="serv">
             <option value="${serv.id}"> ${serv.name}</option>
            </c:forEach>
            </select></td></tr>
        <tr><td> Максимальный кредит</td><td><form:input id="maxbebt" path="maxdebt"/></td></tr>
        <tr><td>Компания </td><td><form:checkbox id="companyflag" path="companyflag"/></td></tr>
        <tr><td><button type="submit" id="save">Сохранить</button></form:form></td>
            <td><form:form id="cancelCreate" modelAttribute="customer" method="post" action="customers">
                <button id="cancel">Отмена</button>
            </form:form></td></tr>
    </table>

</body>
</html>
