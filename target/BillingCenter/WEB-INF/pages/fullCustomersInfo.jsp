<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Клиент</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<tr>
<span><a href="customers">Клиенты</a></span> | <span><a href="services">Услуги</a></span><br>
<form:form id="formUpdate" modelAttribute="customer" method="post" action="updateCustomerAction">
<table>
    <tr><td><table>
        <form:hidden path="id"/>
        <tr><td>Имя </td><td><form:input path="name"/></td></tr>
        <tr><td>Услуга</td><td>
            <select id = "serviceid"  name="serviceid" >
            <option value="${null}"> ----- </option>
            <c:forEach items="${services}" var="serv">
                <option value="${serv.id}"
                   <c:if test="${serv.id == customer.serviceid}"> selected = "selected" </c:if> >
                     ${serv.name}</option>
            </c:forEach>
        </select>
        </td></tr>
        <tr><td> Максимальный кредит</td><td><form:input path="maxdebt"/></td></tr>
        <tr><td>Компания </td><td><form:checkbox path="companyflag"/></td></tr>
        <tr><td><button type="submit">Сохранить</button></form:form></td>
            <td><form:form id="cancelUpdate" modelAttribute="customer" method="post" action="customers">
                <button>Отмена</button>
            </form:form></td></tr>
    </table></td></tr>

    <tr><td><table>
        <c:forEach items="${customer.phoneNumbersById}" var = "phoneNumber">
            <tr>
                <td><c:out value="${phoneNumber.fullnumber}"/></td>
                <td><span><a href="deletePhoneNumberFromCustomer?rowId=${phoneNumber.rowid}">Удалить</a></span></td>
            </tr>
        </c:forEach>
        <tr><span><a href="addPhoneNumber?id=${customer.id}">Добавить новый номер </a></span></tr>
    </table></td></tr>

    <tr><td><table border="1px">
        <tr>
            <th>id</th>
            <th>ФИО</th>
            <th>Номер телефона</th>
            <th>Адрес</th>
            <th>e-mail</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${customer.customersInfosById}" var = "contact">
            <tr>
                <td><c:out value="${contact.rowid}"/></td>
                <td><c:out value="${contact.fullname}"/></td>
                <td><c:out value="${contact.phonenumber}"/></td>
                <td><c:out value="${contact.adress}"/></td>
                <td><c:out value="${contact.email}"/></td>
                <td><span><a href="updateContactForm?rowid=${contact.rowid}">Редактировать</a></span></td>
                <td><span><a href="deleteContactAction?rowid=${contact.rowid}">Удалить</a></span></td>
            </tr>
        </c:forEach>
        <tr><span><a href="createContactForm?id=${customer.id}">Добавить новое контактное лицо</a></span></tr>
    </table></td></tr>
<tr><form:form modelAttribute="billAction" action="regAction">
    <table><tr><td><c:out value="${customer.bill}"/></td></tr>
        <tr><td><form:input path="action"/></td></tr>
        <form:hidden path="customerid"/>
        <tr><td><button>Зарегистрировать</button></td></tr></table></form:form></tr>
<tr>
    История поступлений и списаний
    <table border="1px">
        <c:forEach items="${customer.actionsById}" var = "act">
            <tr>
                <td><c:out value="${act.action}"/></td>
                <td><c:out value="${act.date}"/></td>
            </tr>
        </c:forEach>
    </table>
</tr>
<tr>
    История смены услуг
    <table border="1px">
        <c:forEach items="${customer.historiesById}" var = "hist">
            <tr>
                <td><c:out value="${hist.servicesByServiceid.name}"/></td>
                <td><c:out value="${hist.from}"/></td>
                <td><c:out value="${hist.to}"/></td>
            </tr>
        </c:forEach>
    </table>
</tr>
</table>

<span><a href="customers">На главную</a></span>
</body>
</html>
