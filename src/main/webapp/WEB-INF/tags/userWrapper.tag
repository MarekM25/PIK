<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/layout/header.jsp" %>
<link rel="stylesheet" href="<spring:url value="/webjars/codemirror/5.5/lib/codemirror.css"/>">
    <link rel="stylesheet" href="<spring:url value="/webjars/codemirror/5.5/addon/hint/show-hint.css"/>">
<script src="<spring:url value="/webjars/codemirror/5.5/lib/codemirror.js"/>"></script>
    <script src="<spring:url value="/webjars/codemirror/5.5/addon/hint/show-hint.js"/>"></script>
    <script src="<spring:url value="/webjars/codemirror/5.5/addon/hint/sql-hint.js"/>"></script>
    <script src="<spring:url value="/webjars/codemirror/5.5/mode/sql/sql.js"/>"></script>
    <script src="<spring:url value="/webjars/angularjs/1.5.5/angular.min.js"/>"></script>
</head>
<body>
<%@include file="/WEB-INF/layout/userNavbar.jsp" %>

<div class="container body-content" ng-app="app" ng-controller="AppCtrl as app">
    <jsp:doBody/>

    <%@include file="/WEB-INF/layout/footer.jspx" %>
</div>
<script src="<spring:url value="/js/app.js"/>"></script>
</body>
</html>