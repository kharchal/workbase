<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
Logo |
<a href="<c:url value='/'/>"> Main</a> |
<a href="<c:url value='/clients/'/>">Clients</a> |
<a href="<c:url value='/payments/'/>">Payments</a> |
<a href="<c:url value='/rights/'/>">Rights</a> |
Link |
<a href="<c:url value='/setrole/nemo'/>">as Annonymous</a> |
<a href="<c:url value='/setrole/dean'/>">as Dean</a> |
<a href="<c:url value='/setrole/admin'/>">as Admin</a> |
... |
<a href="<c:url value="/login/"/>"> Login ... </a>
you are logged as <b>${userRole}</b> |
<a href="<c:url value='/api/clients/'/>">/api/clients/</a> |
<a href="<c:url value='/api/clients/qwe/'/>">/api/clients/qwe/</a>
</hr>