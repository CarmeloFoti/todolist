/**
 * Created by melo on 01/10/17.
 */
var app = angular.module('todoApp',['ui.router']);


app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'template/todo.html',
                controller:'TodoController',
                controllerAs:'ctrl'
            });
        $urlRouterProvider.otherwise('/');
    }]);