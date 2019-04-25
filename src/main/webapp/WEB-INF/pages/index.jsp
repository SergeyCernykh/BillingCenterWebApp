<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello Table!</h2><br>
<table border="2px">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Cost</th>
    </tr>
    <c:forEach items="${services}" var = "serv">
        <tr>
            <td><c:out value="${serv.id}"/></td>
            <td><c:out value="${serv.name}"/></td>
            <td><c:out value="${serv.cost}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
