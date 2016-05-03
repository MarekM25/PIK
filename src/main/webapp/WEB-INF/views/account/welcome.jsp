<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<t:wrapper>
<form action="<spring:url value="logout"/>" method="post">
    <input type="submit" value="Wyloguj"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<h3>Witamy, <sec:authentication property="principal.username"/>!</h3>
</t:wrapper>