<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Rejestracja</title>
    <link rel='stylesheet' href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='../styles/styles.css'>
</head>
<body>
<%@include file="/WEB-INF/layout/navbar.jsp" %>
<div class="container body-content">
    <h2>Rejestracja</h2>
    <form:form action="${spring:mvcUrl('AC#accountCreate').build()}" modelAttribute="accountDTO" class="form-horizontal" method="post" role="form"><input name="__RequestVerificationToken" type="hidden"/>
        <h4>Utwórz nowe konto.</h4>
        <hr />
        <div class="validation-summary-valid text-danger" data-valmsg-summary="true"><ul><li style="display:none"></li>
        </ul></div>    <div class="form-group">
            <label class="col-md-2 control-label" for="username">Login</label>
            <div class="col-md-5">
                <form:input class="form-control" data-val="true" data-val-email="The Email field is not a valid e-mail address." data-val-required="The Email field is required." id="username" name="username" path="username" type="text" value="" />
                <form:errors path="username" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="password">Hasło</label>
            <div class="col-md-5">
                <form:input class="form-control" data-val="true" data-val-length="The Password must be at least 6 characters long." data-val-length-max="100" data-val-length-min="6" data-val-required="The Password field is required." id="password" name="password" path="password" type="password" />
                <form:errors path="password" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="matchingPassword">Potwierdź hasło</label>
            <div class="col-md-5">
                <form:input class="form-control" data-val="true" data-val-equalto="The password and confirmation password do not match." data-val-equalto-other="*.Password" id="matchingPassword" name="matchingPassword" path="matchingPassword" type="password" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <input type="submit" class="btn btn-default" value="Zarejestruj" />
            </div>
        </div>
    </form:form>

    <%@include file="/WEB-INF/layout/footer.jspx" %>
</div>
    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
