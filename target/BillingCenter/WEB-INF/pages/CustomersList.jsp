<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>Клиенты</title>
<body>
<span><a href="customers">Клиенты</a></span> | <span><a href="services">Услуги</a></span><br>
<h2>Таблица клиентов</h2><br>
<table id="table" border="1px" >
    <tr>
        <th>Имя</th>
        <th>Услуга</th>
        <th>Комания</th>
        <th>Счет</th>
        <th>Максимальный кредит</th>
        <th>Дата погашения кредита</th>
        <th>Заблокирован</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${customers}" var = "cust">
        <tr>
            <td><c:out value="${cust.name}"/></td>
            <td><c:out value="${cust.servicesByServiceid.name}"/></td>
            <td><c:out value="${cust.companyflag}"/></td>
            <td><c:out value="${cust.bill}"/></td>
            <td><c:out value="${cust.maxdebt}"/></td>
            <td><c:out value="${cust.maxdaytorepayment}"/></td>
            <td><c:out value="${cust.blockedflag}"/></td>
            <td><span><a href="fullCustomerInfoForm?id=${cust.id}">Подробнее</a></span></td>
            <td><span><a href="deleteCustomerAction?id=${cust.id}">Удалить</a></span></td>
        </tr>
    </c:forEach>
</table>
<br>
<form:form id="createCustomerForm" method="post" action="createCustomerForm">
    <button id="createCustomer">Создать нового клиента</button>
</form:form>
</body>
</html>
