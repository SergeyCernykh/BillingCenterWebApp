<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Создание услуги</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<body>
<span><a href="customers">Клиенты</a></span> | <span><a href="services">Услуги</a></span><br>
    <form:form id="formCreate" modelAttribute="service" method="post" action="saveServiceAction">
        <table>
            <tr><td>Наименование </td><td><form:input path="name"/></td></tr>
            <tr><td>Количество GB</td><td><form:input path="internet"/></td></tr>
            <tr><td>Количество минут</td><td> <form:input path="minutes"/></td></tr>
            <tr><td>Количество СМС</td><td> <form:input path="sms"/></td></tr>
            <tr><td>Акция</td><td><form:input path="specialoffer"/></td></tr>
            <tr><td>Стоимость</td><td><form:input path="cost"/></td></tr>
            <tr><td><button>Сохранить</button> </form:form></td><td>
                <form:form id="cancelCreate" modelAttribute="service" method="post" action="cancelServiceAction">
                    <button>Отмена</button>
                </form:form></td></tr>
        </table>

</body>
</html>
