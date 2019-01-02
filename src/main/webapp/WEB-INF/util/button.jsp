<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="x" value="${url_}${test_end}"/>
<%--${url_}--%>
<%--${requestScope.url_}--%>
<c:if test="${!rights.contains(x)}">
    <a href="${url_}${href_end}" class="${css_class}">${text}</a>
</c:if>