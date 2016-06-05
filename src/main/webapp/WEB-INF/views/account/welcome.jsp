<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<t:userWrapper>
<h3>Witamy, <sec:authentication property="principal.username"/>!</h3>
    <div class="row">
    <div class="col-md-12">
        </br>
        <label for="query">Wpisz swoje zapytanie</label>
        <textarea id="query" class="form-control" rows="8" id="query"></textarea>
        </br>
        <button type="button" class="btn btn-info">Wykonaj zapytanie</button>
    </div>
    </div>
    <script>
        window.onload = function() {
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
                matchBrackets : true,
                extraKeys: {"Ctrl-Space": "autocomplete"},
                hintOptions: {tables: {
                    users: {name: null, score: null, birthDate: null},
                    countries: {name: null, population: null, size: null}
                }}
            });
        };
    </script>
</t:userWrapper>
