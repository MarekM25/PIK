<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<t:userWrapper>
    <h3>Witamy, <sec:authentication property="principal.username"/>!</h3>
    <div class="row">
        <div class="col-md-12">
            </br>
            {{test}}
            <label for="query">Wpisz swoje zapytanie</label>
            <textarea id="query" ng-model="queryText" class="form-control" rows="8" id="query"></textarea>
            </br>
            <button type="button" class="btn btn-info" ng-click="execute()">Wykonaj zapytanie</button>
        </div>
        <div ng-if="queryResult.successful == true">
            <div ng-if="queryResult.selectQuery == false">
                <p>Polecenie zostało wykonanie poprawnie</p>
            </div>
            <div ng-if="queryResult.selectQuery == true">
                <table>
                    <tr>
                        <td ng-repeat="column in queryResult.columnsNames"> {{column}} </td>
                    </tr>
                    <tr ng-repeat="row in queryResult.rows">
                        <td ng-repeat="tuple in row">
                            {{tuple}}
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div ng-if="queryResult.successful == false">
            <p>Polecenie niepoprawne!</p>
            <p>Błąd: {{queryResult.errorMessage}}</p>
        </div>
    </div>
    <script>
        window.onload = function () {
            var mime = 'text/x-mariadb';
            // get mime type
            if (window.location.href.indexOf('mime=') > -1) {
                mime = 'text/x-sql'
            }
            window.editor = CodeMirror.fromTextArea(document.getElementById('query'), {
                ngModel: "queryText",
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
            });
        };
    </script>
</t:userWrapper>
