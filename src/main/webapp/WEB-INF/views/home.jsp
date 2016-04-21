
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>

    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<%@include file="/WEB-INF/layout/navbar.jspx" %>
<div class="container body-content">



    <h2>Log in.</h2>
    <div class="row">
        <div class="col-md-8">
            <section id="loginForm">
                <form action="/Account/Login" class="form-horizontal" method="post" role="form"><input name="__RequestVerificationToken" type="hidden" value="_FROmWy3AgKzHUPqWjFErWN3rkFwiKX2FXe6nhxyefL1P2Tr_AoIQVSTDkxpHnh1VUL5YUZanwwIYJvyOBAk23tVAv4JcW5GUcwPLbw4nlo1" />                <h4>Use a local account to log in.</h4>
                    <hr />
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="Email">Email</label>
                        <div class="col-md-5">
                            <input class="form-control" data-val="true" data-val-email="The Email field is not a valid e-mail address." data-val-required="The Email field is required." id="Email" name="Email" type="text" value="" />
                            <span class="field-validation-valid text-danger" data-valmsg-for="Email" data-valmsg-replace="true"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="Password">Password</label>
                        <div class="col-md-5">
                            <input class="form-control" data-val="true" data-val-required="The Password field is required." id="Password" name="Password" type="password" />
                            <span class="field-validation-valid text-danger" data-valmsg-for="Password" data-valmsg-replace="true"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <div class="checkbox">
                                <input data-val="true" data-val-required="The Remember me? field is required." id="RememberMe" name="RememberMe" type="checkbox" value="true" /><input name="RememberMe" type="hidden" value="false" />
                                <label for="RememberMe">Remember me?</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <input type="submit" value="Log in" class="btn btn-default" />
                        </div>
                    </div>
                    <p>
                        <a href="/Account/Register">Register as a new user</a>
                    </p>
                </form>        </section>
        </div>
        <div class="col-md-4">
            <section id="socialLoginForm">

                <h4>Zarządzaj swoimi bazami danych!</h4>
                <hr />
                <div style="display: block; margin: 20px">
                    <p>
                        Dzięki DatabaseManager zarządzanie silnikami różnych baz danych nigdy nie było prostsze. Używaj narzędzia już dziś za darmo!.
                    </p>
                    </br>
                    <img src="/images/postgres.png" width="75"/>
                    <img src="/images/oracle.png" width="75"/>
                    <img src="/images/sql_server.png" width="75"/>
                    <img src="/images/mysql.png" width="75"/>
                </div>


            </section>
        </div>
    </div>


    <%@include file="/WEB-INF/layout/footer.jspx" %>
</div>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>