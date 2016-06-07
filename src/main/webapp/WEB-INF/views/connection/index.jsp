<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:userWrapper>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-9">
                <h2>Połączenia</h2>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Silnik bazy danych</th>
                                <th>Host</th>
                                <th>Port</th>
                                <th>Nazwa bazy</th>
                                <th>Nazwa użytkownika</th>
                                <th>Hasło</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="connection" items="${connectionsList}">
                            <tr>
                                <td>
                                    ${connection.getDatabaseType()}
                                </td>
                                <td>
                                    ${connection.getHost()}
                                </td>
                                <td>
                                    ${connection.getPort()}
                                </td>
                                <td>
                                    ${connection.getInitialDatabase()}
                                </td>
                                <td>
                                    ${connection.getUsername()}
                                </td>
                                <td>********</td>
                                <td>
                                    <form:form action="${spring:mvcUrl('deleteConnection').arg(0, connection.getId()).build()}" method="post" role="form">
                                        <button type="submit" class="btn btn-danger">
                                            <span class="glyphicon glyphicon-remove" aria-hidden="true"> Usuń</span>
                                        </button>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Dodaj połaczenie
                    </div>
                    <div class="panel-body">
                        <form:form action="${spring:mvcUrl('addConnection').build()}" modelAttribute="connectionDTO" class="form-horizontal" method="post" role="form">
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="databaseType">Silnik bazy danych</label>
                                <div class="col-md-5">
                                    <form:select path="databaseType" items="${databaseTypes}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="host">Host</label>
                                <div class="col-md-5">
                                    <form:input class="form-control" data-val="true" data-val-required="Pole Host jest wymagane." id="host" name="host" path="host" type="text" value="" required="required" />
                                    <form:errors path="host" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="port">Port</label>
                                <div class="col-md-5">
                                    <form:input class="form-control" data-val="true" data-val-required="Pole Port jest wymagane." id="port" name="port" path="port" type="text" value="" required="required" />
                                    <form:errors path="port" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="initialDatabase">Nazwa bazy</label>
                                <div class="col-md-5">
                                    <form:input class="form-control" data-val="true" data-val-required="Pole Nazwa bazy jest wymagane." id="initialDatabase" name="initialDatabase" path="initialDatabase" type="text" value="" required="required" />
                                    <form:errors path="initialDatabase" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="port">Nazwa użytkownika</label>
                                <div class="col-md-5">
                                    <form:input class="form-control" data-val="true" data-val-required="Pole Nazwa użytkownika jest wymagane." id="username" name="username" path="username" type="text" value="" required="required" />
                                    <form:errors path="username" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="port">Hasło</label>
                                <div class="col-md-5">
                                    <form:input class="form-control" data-val="true" data-val-required="Pole Hasło jest wymagane." id="password" name="password" path="password" type="password" value="" required="required" />
                                    <form:errors path="password" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10">
                                    <input type="submit" class="btn btn-primary" value="Dodaj" />
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:userWrapper>