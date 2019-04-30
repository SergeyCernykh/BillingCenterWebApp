<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<span><a href="customers">Клиенты</a></span> | <span><a href="services">Услуги</a></span><br>
<h2>Таблица услуг</h2><br>
<table border="1px">
    <tr>
        <th>Наименование</th>
        <th>GB</th>
        <th>Минуты</th>
        <th>СМС</th>
        <th>Акция</th>
        <th>Стоимость</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${services}" var = "serv">
        <tr>
            <td><c:out value="${serv.name}"/></td>
            <td><c:out value="${serv.internet}"/></td>
            <td><c:out value="${serv.minutes}"/></td>
            <td><c:out value="${serv.sms}"/></td>
            <td><c:out value="${serv.specialoffer}"/></td>
            <td><c:out value="${serv.cost}"/></td>
            <td><span><a href="updateServiceForm?id=${serv.id}">Редактировать</a></span></td>
            <td><span><a href="deleteServiceAction?id=${serv.id}">Удалить</a></span></td>
        </tr>
    </c:forEach>
</table>
<br>
<form:form id="createServiceForm" method="post" action="createServiceForm">
    <button>Создать новую услугу</button>
</form:form>
</body>
</html>
