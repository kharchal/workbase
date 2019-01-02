<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients page</title>
    <c:import url="../util/imports.jsp"/>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://code.jquery.com/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(document).ready( function() {
            // $( "#datex" ).datepicker();
            $( "#datex" ).datepicker( { dateFormat: "dd-mm-yy"} );
        } );
    </script>
</head>
<body class="container">
    <c:import url="../util/header.jsp"/>
    <h1>Client edit</h1>
    <f:form modelAttribute="abc" action="/date/save">
    <table class="table">
        <colgroup>
            <col width="15%"/>
            <col width="50%"/>
            <col width="35%"/>
        </colgroup>
        <tr>
            <td>
                <label for="id">Id</label>
            </td>
            <td>
                <f:input path="id" id="id" readonly="true"  cssClass="form-control"/>
            </td>
            <td></td>
        </tr>

        <tr>
            <td>
                <label for="datex">Date</label>
            </td>
            <td>
                <f:input id="datex" path="date" cssClass="form-control" readonly="true" />
            </td>
            <td>
                <f:errors path="date" cssClass="red"/>
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