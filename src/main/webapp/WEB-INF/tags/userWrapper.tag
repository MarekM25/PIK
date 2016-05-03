<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/layout/header.jsp" %>
<body>
<%@include file="/WEB-INF/layout/userNavbar.jsp" %>
<div class="container body-content">
    <jsp:doBody/>

    <%@include file="/WEB-INF/layout/footer.jspx" %>
</div>

</body>
</html>