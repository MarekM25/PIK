/**
 * Created by Marek on 06.06.2016.
 */
var app = angular.module("app",[]);

app.controller("AppCtrl",function($scope,$http) {
    var app = this;
    $scope.statementText='';
    $scope.execute= function () {
        $http({
            url: '../statement/execute',
            method: "POST",
            data: { 
                'connectionId': $scope.connectionId,
                "statementText" : window.editor.getValue() 
            }
        })
            .then(function(response) {
                    $scope.queryResult = response.data;
                    console.log($scope.queryResult);
                },
                function(response) {
                    console.log('lipa');
                    console.log(response);
                });
    }

});
