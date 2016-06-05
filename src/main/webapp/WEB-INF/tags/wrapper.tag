<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/layout/navbar.jsp" %>
<div class="container body-content">

    <jsp:doBody/>

<%@include file="/WEB-INF/layout/footer.jspx" %>
</div>

</body>
</html>