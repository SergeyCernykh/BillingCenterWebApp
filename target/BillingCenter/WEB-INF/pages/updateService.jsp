<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Создание услуги</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<body>
    <form:form id="formUpdate" modelAttribute="service" method="post" action="updateServiceAction">
        <form:hidden path="id"/>
        Наименование <form:input path="name"/><br/>
        Количество GB <form:input path="internet"/><br/>
        Количество минут <form:input path="minutes"/><br/>
        Количество СМС <form:input path="sms"/><br/>
        Акция <form:input path="specialoffer"/><br/>
        Стоимость <form:input path="cost"/><br/>
        <button>Сохранить</button>
    </form:form>
</body>
</html>
