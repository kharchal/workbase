<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <c:import url="util/imports.jsp"/>
</head>
<body class="container">
    <c:import url="util/header.jsp"/>
    <hr>
    <strong><span style="color: red;">${msg}</span></strong>
    <br>
    ${time}
    <c:import url="util/footer.jsp"/>
</body>
</html>