<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
    <h2>Logowanie</h2>
    <div class="row">
        <div class="col-md-8">
            <section id="loginForm">
                <form action="" class="form-horizontal" method="post" role="form"><input name="__RequestVerificationToken" type="hidden" />
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <h4>Podaj login i hasło.</h4>
                    <hr />
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="username">Login</label>
                        <div class="col-md-5">
                            <input class="form-control" data-val="true" id="username" name="username" type="text" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="password">Hasło</label>
                        <div class="col-md-5">
                            <input class="form-control" data-val="true" data-val-required="The Password field is required." id="password" name="password" type="password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <input type="submit" value="Zaloguj" class="btn btn-default" />
                        </div>
                    </div>
                    <p>
                        <a href="${spring:mvcUrl('AC#accountCreate').build()}">Zarejestruj jako nowy użytkownik</a>
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
                    <img src="<spring:url value="images/postgres.png"/>" width="75"/>
                    <img src="<spring:url value="images/oracle.png"/>" width="75"/>
                    <img src="<spring:url value="images/sql_server.png"/>" width="75"/>
                    <img src="<spring:url value="images/mysql.png"/>" width="75"/>
                </div>
            </section>
        </div>
    </div>
    <c:if test="${param.error ne null}">
        <div>
            <p style="color:red">Niepoprawny login i hasło.</p>
        </div>
    </c:if>
    <c:if test="${param.logout ne null}">
        <div>
            <p style="color:red">Zostałeś wylogowany.</p>
        </div>
    </c:if>
</t:wrapper>