<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients page</title>
    <c:import url="../util/imports.jsp"/>
</head>
<body class="container">
    <c:import url="../util/header.jsp"/>
        <h1>Clients</h1>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>SURNAME</th>
            <th>LEVEL</th>
            <th>BALANCE</th>
            <th>
                <c:if test="${!rights.contains('/clients/create/')}">
                    <a href="/clients/create/" class="btn btn-warning btn-sm">Create</a>
                </c:if>
            </th>
        </tr>
        <c:forEach var="client" items="${clients}">
            <tr>
                <td>${client.id}</td>
                <td>${client.person.name}</td>
                <td>${client.person.surname}</td>
                <td>${client.level.value}</td>
                <td>${client.balance}</td>
                <td>
                    <%--<c:set var="url_" value="/clients/show/" scope="request"/>--%>
                    <%--<c:set var="test_end" value="{id}" scope="request"/>--%>
                    <%--<c:set var="href_end" value="${client.id}" scope="request"/>--%>
                    <%--<c:set var="css_class" value="btn btn-info btn-sm" scope="request"/>--%>
                    <%--<c:set var="text" value="Read" scope="request"/>--%>
                    <%--<c:import url="../util/button.jsp"/>--%>
                    <c:if test="${!rights.contains('/clients/show/{id}')}">
                        <a href="/clients/show/${client.id}" class="btn btn-info btn-sm">Read</a>
                    </c:if>
                    <c:if test="${!rights.contains('/clients/edit/{id}')}">
                        <a href="/clients/edit/${client.id}" class="btn btn-success btn-sm">Edit</a>
                    </c:if>
                    <c:if test="${!rights.contains('/clients/delete/{id}')}">
                        <a href="/clients/delete/${client.id}" class="btn btn-danger btn-sm">Delete</a>
                    </c:if>
                    <c:if test="${true}">
                        <a href="/payments/for/${client.id}" class="btn btn-warning btn-sm">Payment</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:import url="../util/footer.jsp"/>
</body>
</html>