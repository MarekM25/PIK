<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ACCOUNT_CREATE</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<%@include file="/WEB-INF/layout/navbar.jspx" %>
<div class="container body-content">



    <h2>Register.</h2>

    <form action="/Account/Register" class="form-horizontal" method="post" role="form"><input name="__RequestVerificationToken" type="hidden" value="km7vvcX3vxFU5KvBJCISgYjKfVnHbfKov1YWm0-PgkNOEV1829F97noqL5aHx1bVCUasaWLXCDk1LNd-ltPxUX5Cw_oHaGJkAG8VpP5iZu01" />    <h4>Create a new account.</h4>
        <hr />
        <div class="validation-summary-valid text-danger" data-valmsg-summary="true"><ul><li style="display:none"></li>
        </ul></div>    <div class="form-group">
            <label class="col-md-2 control-label" for="Email">Email</label>
            <div class="col-md-10">
                <input class="form-control" data-val="true" data-val-email="The Email field is not a valid e-mail address." data-val-required="The Email field is required." id="Email" name="Email" type="text" value="" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="Password">Password</label>
            <div class="col-md-10">
                <input class="form-control" data-val="true" data-val-length="The Password must be at least 6 characters long." data-val-length-max="100" data-val-length-min="6" data-val-required="The Password field is required." id="Password" name="Password" type="password" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="ConfirmPassword">Confirm password</label>
            <div class="col-md-10">
                <input class="form-control" data-val="true" data-val-equalto="The password and confirmation password do not match." data-val-equalto-other="*.Password" id="ConfirmPassword" name="ConfirmPassword" type="password" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <input type="submit" class="btn btn-default" value="Register" />
            </div>
        </div>
    </form>

    <hr />
    <%@include file="/WEB-INF/layout/footer.jspx" %>
</div>
    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
