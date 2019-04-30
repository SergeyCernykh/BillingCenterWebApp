<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Создание конактного лица</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<body>
<span><a href="customers">Клиенты</a></span> | <span><a href="services">Услуги</a></span><br>
<form:form id="formCreate" modelAttribute="contact" method="post" action="saveContactAction">
<table>
    <form:hidden path="customerid"/>
    <tr><td>ФИО</td><td><form:input path="fullname"/></td></tr>
    <tr><td>Номер телефона</td><td><form:input path="phonenumber"/></td></tr>
    <tr><td>Адрес</td><td> <form:input path="adress"/></td></tr>
    <tr><td>E-mail</td><td> <form:input path="email"/></td></tr>
    <tr><td><button>Сохранить</button> </form:form></td>
        <td><span><a href="cancelContactAction?id=${contact.customerid}">Отмена</a></span></td></tr>
</body>
</html>
