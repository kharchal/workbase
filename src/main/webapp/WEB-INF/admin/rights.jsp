<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Mappings</h1>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>MAPPING</th>
            <th>ACCESS RIGHTS</th>
        </tr>
        <c:forEach var="m" items="${rightList}">
            <tr>
                <td>${m.id}</td>
                <td><span style="font-weight: bold"> ${m.mapping} </span>&nbsp;
                    <span style="font-size: x-small; font-style: italic;">${m.description}</span></td>
                <td>
                    <c:forEach var="r" items="${roles}">
                        <c:set var="x" value="${!r.mappings.contains(m)}"/>
                        <a href="<c:url value="/rights/for/${r.id}/${x ? 'on' : 'off'}/${m.id}"/>" class="btn btn-default btn-xs">
                            <span style="color: ${x ? 'red' : 'green'};">${r.value}</span>
                        </a>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:import url="../util/footer.jsp"/>
</body>
</html>