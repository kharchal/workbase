<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment edit page</title>
    <c:import url="../util/imports.jsp"/>
</head>
<body class="container">
    <c:import url="../util/header.jsp"/>
    <h1>Payment edit</h1>
    <f:form modelAttribute="payment" action="/payments/save">
    <table class="table">
        <colgroup>
            <col width="15%"/>
            <col width="50%"/>
            <col width="35%"/>
        </colgroup>

        <tr>
            <td>
                <label for="id">ID</label>
            </td>
            <td>
                <f:input id="id" path="id" cssClass="form-control" readonly="true"/>
            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td>
                <label for="client">CLIENT</label>
            </td>
            <td>
                <f:select id="client" path="client.id" items="${clients}" cssClass="form-control"/>
            </td>
            <td>
                <f:errors path="client" cssClass="red"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="date">DATE</label>
            </td>
            <td>
                <f:input id="date" path="date" cssClass="form-control"/>
            </td>
            <td>
                <f:errors path="date" cssClass="red"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="account">ACCOUNT</label>
            </td>
            <td>
                <f:select id="account" path="account.id" items="${accounts}" cssClass="form-control"/>
            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td>
                <label for="amount">AMOUNT</label>
            </td>
            <td>
                <f:input id="amount" path="amount" cssClass="form-control"/>
            </td>
            <td>
                <f:errors path="amount" cssClass="red"/>
            </td>
        </tr>
        <tr>
            <td colspan="3" align="middle">
                <button class="btn btn-info">Save</button>
            </td>
        </tr>
    </table>
    </f:form>
    <c:import url="../util/footer.jsp"/>
</body>
</html>