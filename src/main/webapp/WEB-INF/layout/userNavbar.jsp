<%--
  Created by IntelliJ IDEA.
  User: Marek
  Date: 03.05.2016
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="navbar navbar-inverse navbar-fixed-top" xmlns:spring="http://www.springframework.org/tags">
    <div class="container">
        <div class="navbar-header" >

            <a class="navbar-brand" style="color:white;" href="<s:url value="/"/>">Database Manager</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<s:url value="logout"/>" style="color:white;"  id="registerLink">Wyloguj</a></li>
            </ul>

        </div>
    </div>
</div>