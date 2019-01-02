<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payments page</title>
    <c:import url="../util/imports.jsp"/>
</head>
<body class="container">
    <c:import url="../util/header.jsp"/>
        <h1>Payments</h1>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>DATE</th>
            <th>AMOUNT</th>
            <th>CLIENT</th>
            <th>ACCOUNT</th>
            <th>
                <c:if test="${rights.contains('c')}">
                    <input type="hidden" id="id"/>
                    <%--<script>--%>
                        <%--var h = window.location.href;--%>
                        <%--var x = h.indexOf('/payments/for/');--%>
                        <%--if (x >= 0) {--%>
                            <%--var xx = x + 14;--%>
                            <%--var id = h.substring(xx, h.length);--%>
                            <%--// alert('client is chosen id = ' + id);--%>
                            <%--document.getElementById("id").value = id;--%>
                        <%--}--%>
                    <%--</script>--%>
                    <a id="href" href="/payments/create/${clientId}" class="btn btn-warning btn-sm">Create</a>
                </c:if>
            </th>
        </tr>
        <c:forEach var="payment" items="${payments}">
            <tr>
                <td>${payment.id}</td>
                <td>${payment.date}</td>
                <td>
                    <fmt:formatNumber pattern="#,###" value="${payment.amount}"/>
                </td>
                <td>${payment.client.person.name} ${payment.client.person.surname}</td>
                <td>${payment.account.name}</td>
                <td>
                    <c:if test="${rights.contains('r')}">
                        <a href="/payments/show/${payment.id}" class="btn btn-info btn-sm">Read</a>
                    </c:if>
                    <c:if test="${rights.contains('u')}">
                        <a href="/payments/edit/${payment.id}" class="btn btn-success btn-sm">Edit</a>
                    </c:if>
                    <c:if test="${rights.contains('d')}">
                        <a href="/payments/delete/${payment.id}" class="btn btn-danger btn-sm">Delete</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="2" align="right">Total:</th>
            <th><fmt:formatNumber value="${total}" maxFractionDigits="3"/></th>
            <th colspan="3"></th>
        </tr>
    </table>
    <c:import url="../util/footer.jsp"/>
</body>
<%--<script>--%>
    <%--$(document).ready( function () {--%>
        <%--var x = $("#id").val();--%>
        <%--var href = $("#href").attr('href');--%>
        <%--$("#href").attr("href", href + x);--%>
            <%--// alert("www " + x);--%>

    <%--});--%>
<%--</script>--%>
</html>