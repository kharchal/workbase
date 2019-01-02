<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
    <c:import url="../util/imports.jsp"/>
</head>
<body class="container">
    <c:import url="../util/header.jsp"/>
    <h1>Payment edit</h1>
    <c:set var="url"><c:url value="/login/"/></c:set>
    <form action="${url}" method="post">
    <table class="table">
        <%--<colgroup>--%>
            <%--<col width="15%"/>--%>
            <%--<col width="50%"/>--%>
            <%--<col width="35%"/>--%>
        <%--</colgroup>--%>

        <tr>
            <td>
                <label for="login">LOGIN</label>
            </td>
            <td>
                <input id="login" name="login" class="form-control"/>
            </td>
            <%--<td>--%>
                <%--<f:errors path="client" cssClass="red"/>--%>
            <%--</td>--%>
        </tr>
        <tr>
            <td>
                <label for="password">PASSWORD</label>
            </td>
            <td>
                <input id="password" name="password" class="form-control"/>
            </td>
            <%--<td>--%>
                <%--<f:errors path="date" cssClass="red"/>--%>
            <%--</td>--%>
        </tr>
        <tr>
            <td colspan="3" align="middle">
                <button class="btn btn-info">Login</button>
            </td>
        </tr>
    </table>
    </form>
    <c:import url="../util/footer.jsp"/>
</body>
</html>