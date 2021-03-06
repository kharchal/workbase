<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mt" uri="/WEB-INF/tld/tags.tld"%>
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
    <h1>Client edit</h1>
    <f:form modelAttribute="client" action="/clients/save">
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
                <label for="person">PERSON</label>
            </td>
            <td>
                <%--<f:input type="hidden" path="personId"/>--%>
                <f:select id="person" items="${persons}" path="person.id" cssClass="form-control" readonly="true"/>
            </td>
            <td>
                <%--<f:errors path="name" cssClass="red"/>--%>
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<label for="surname">SURNAME</label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<f:input id="surname" path="surname" cssClass="form-control" readonly="true"/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<f:errors path="surname" cssClass="red"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td>
                <label for="level">LEVEL</label>
            </td>
            <td>
                <f:select id="level" path="level.id" items="${levels}" cssClass="form-control"/>
            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td>
                <label for="balance">BALANCE</label>
            </td>
            <td>
                <f:input id="balance" path="balance" cssClass="form-control"/>
            </td>
            <td>
                <f:errors path="balance" cssClass="red"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="xdate">DATE</label>
            </td>
            <td>
                <input id="xdate" name="dateString" value="<mt:date convert="${client.xdate}"/>" class="form-control"/>
                <%--<f:input path="xdate" id="xdate" cssClass="form-control"/>--%>
            </td>
            <td>
                <f:errors path="xdate"/>
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