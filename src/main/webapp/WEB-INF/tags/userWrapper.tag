<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/layout/header.jsp" %>
<body>
<%@include file="/WEB-INF/layout/userNavbar.jsp" %>
<div class="container body-content">
    <c:if test="${ERROR_MESSAGE != null}">
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Error!</strong> ${ERROR_MESSAGE}
        </div>
    </c:if>
    <jsp:doBody/>

    <%@include file="/WEB-INF/layout/footer.jspx" %>
</div>

</body>
</html>