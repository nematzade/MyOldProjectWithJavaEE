/**
 * Created by Mohammad on 05/02/2018.
 */

var app = angular.module('uniApp', []);

app.controller('uniController', function ($scope,$http) {

    $http.get("/action/uniController/read")
        .then(function (response) {$scope.unis = response.data;});

});