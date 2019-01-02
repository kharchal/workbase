<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <%--<c:if test="${rights.contains('c')}">--%>
                    <%--<a href="/clients/create/" class="btn btn-warning btn-sm">Create</a>--%>
                <%--</c:if>--%>
            </th>
        </tr>
        <c:forEach var="obj" items="${objects}">
            <tr>
                <td>${obj.id}</td>
                <td><fmt:formatDate value="${obj.date}" pattern="dd-MM-yyyy"/></td>
                <%--<td>${obj.date.getDayOfMonth()}-${obj.date.getMonthValue()}-${obj.date.getYear()}</td>--%>
                <%--<td>${client.person.surname}</td>--%>
                <%--<td>${client.level.value}</td>--%>
                <%--<td>${client.balance}</td>--%>
                <td>
                    <%--<c:if test="${rights.contains('r')}">--%>
                        <%--<a href="/clients/show/${client.id}" class="btn btn-info btn-sm">Read</a>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${rights.contains('u')}">--%>
                        <a href="/date/edit/${obj.id}" class="btn btn-success btn-sm">Edit</a>
                    <%--</c:if>--%>
                    <%--<c:if test="${rights.contains('d')}">--%>
                        <%--<a href="/clients/delete/${client.id}" class="btn btn-danger btn-sm">Delete</a>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${true}">--%>
                        <%--<a href="/payments/for/${client.id}" class="btn btn-warning btn-sm">Payment</a>--%>
                    <%--</c:if>--%>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:import url="../util/footer.jsp"/>
</body>
</html>