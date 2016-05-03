<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Database Manager</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='<spring:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
    <link rel='stylesheet' href='<spring:url value="/styles/styles.css"/>'>
</head>
<body>
<%@include file="/WEB-INF/layout/navbar.jsp" %>
<div class="container body-content">

    <jsp:doBody/>

<%@include file="/WEB-INF/layout/footer.jspx" %>
</div>
<script type="text/javascript" src="<spring:url value="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
</body>
</html>