<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <title>LOGIN PAGE</title>
</head>
<body>
<form name="f" th:action="@{/login}" method="post">
        <legend>Please Login</legend>
        <label for="username" class = "col-md-2 control-label">Username</label>
        <input type="text" class="form-control" id="username" name="username"/>
        <label for="password" class = "col-md-2 control-label">Password</label>
        <input type="password" class="form-control" id="password" name="password"/>
        <div class="form-actions">
            <button type="submit" class="btn btn-default">Log in</button>
        </div>

</form>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
