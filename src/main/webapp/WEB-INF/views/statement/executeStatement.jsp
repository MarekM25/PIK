<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<t:userWrapper>

    <div class="row">
        <br>
        <div class="col-md-2">
            <label for="query">Wybierz bazę danych</label>
        </div>
        <div class="col-md-6">
            <form:select path="connectionList" items="${connectionList}" itemValue="id" itemLabel="initialDatabase" ng-model="connectionId"/>
        </div>
        <div class="col-md-12">
            </br>
            <textarea id="query" ng-model="statementText" class="form-control" rows="8"></textarea>
            </br>
            <c:if test="${empty connectionList}">
                <div class="alert-danger">
                    <p>Aby wykonać skrypt najpierw dodaj połączenie</p>
                </div>
            </c:if>
            <c:if test="${not empty connectionList}">
                <button type="button" class="btn btn-info" ng-click="execute()">Wykonaj skrypt</button>
            </c:if>
        </div>
    </div>
    </br>
    </br>
    </br>
    <div class="row">
        <div ng-if="queryResult.successful == true">
            <div ng-if="queryResult.selectQuery == false" class="alert-success">
                <p>Polecenie zostało wykonanie poprawnie</p>
            </div>
            <div ng-if="queryResult.selectQuery == true">
                <table class="table table-hover">
                    <thead class="thead-inverse" style="background: black; color: white">
                    <tr>
                        <td ng-repeat="column in queryResult.columnsNames"> {{column}}</td>
                    </tr>
                    </thead>
                    <tr ng-repeat="row in queryResult.rows">
                        <td ng-repeat="tuple in row">
                            {{tuple}}
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div ng-if="queryResult.successful == false" class="alert-danger">
        <p>Polecenie niepoprawne!</p>
        <p>Błąd: {{queryResult.errorMessage}}</p>
    </div>

    <script>
        window.onload = function () {
            var mime = 'text/x-mariadb';
            // get mime type
            if (window.location.href.indexOf('mime=') > -1) {
                mime = 'text/x-sql'
            }
            window.editor = CodeMirror.fromTextArea(document.getElementById('query'), {
                mode: mime,
                indentWithTabs: true,
                smartIndent: true,
                lineNumbers: true,
                matchBrackets: true,
                extraKeys: {"Ctrl-Space": "autocomplete"},
                hintOptions: {
                    tables: {
                        users: {name: null, score: null, birthDate: null},
                        countries: {name: null, population: null, size: null}
                    }
                }
            })
        };
    </script>
</t:userWrapper>
