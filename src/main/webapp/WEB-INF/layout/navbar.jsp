<!--
  Created by IntelliJ IDEA.
  User: Marek
  Date: 21.04.2016
  Time: 21:29
  To change this template use File | Settings | File Templates.
-->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="navbar navbar-inverse navbar-fixed-top" xmlns:spring="http://www.springframework.org/tags">
    <div class="container">
        <div class="navbar-header" >

            <a class="navbar-brand" style="color:white;" href="<s:url value="/"/>">Database Manager</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${spring:mvcUrl('AC#accountCreate').build()}" style="color:white;"  id="registerLink">Zarejestruj</a></li>
            </ul>

        </div>
    </div>
</div>