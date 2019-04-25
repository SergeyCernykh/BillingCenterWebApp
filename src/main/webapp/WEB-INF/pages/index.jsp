<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<button>Клиенты</button>|<button>Услуги</button><br>
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
    </tr>
    <c:forEach items="${services}" var = "serv">
        <tr>
            <td><c:out value="${serv.name}"/></td>
            <td><c:out value="${serv.internet}"/></td>
            <td><c:out value="${serv.minutes}"/></td>
            <td><c:out value="${serv.sms}"/></td>
            <td><c:out value="${serv.specialoffer}"/></td>
            <td><c:out value="${serv.cost}"/></td>
            <td><button>Редактировать</button></td>
        </tr>
    </c:forEach>
</table>
<br>
<button>Создать новую услугу</button>
</body>
</html>
