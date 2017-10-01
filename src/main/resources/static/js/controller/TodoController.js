/**
 * Created by melo on 01/10/17.
 */
/**
 * Created by melo on 01/10/17.
 */
angular.module('todoApp').controller('TodoController',
    ['$scope', '$http',  function( $scope, $http) {

        var refreshTodo = function () {
            $http({
                method: 'GET',
                url: '/todo/'
            }).then(function success(response) {
                $scope.todos =response.data;
            }, function error(response) {
                console.log('Error in retrieving the todos'+ response)
            });
        };

        $scope.saveTodo = function () {
            var datatoSave = {text :$scope.todoText}
            $http({
                method: 'POST',
                url: '/todo/',
                data : datatoSave
            }).then(function success (response){
                refreshTodo();
            },function error(response) {
                console.log('Error in creating the todo'+ response)
            });
            $scope.todoText="";
        };

        $scope.deleteTodo = function (todo) {
            $http({
                method: 'DELETE',
                url: '/todo/'+todo.id
            }).then(function success (response){
                refreshTodo();
            },function error(response) {
                console.log('Error in deleting the todo'+ response)
            });

        };

        $scope.patchTodo = function (todo) {
            $http({
                method: 'PATCH',
                url: todo._links.self.href,
                data: {name: todo.name}
            }).then(function success (response){
                refreshTodo();
            },function error(response) {
                console.log('Error in patching the todo'+ response)
            });
        };

        $scope.todoText="";
        refreshTodo();
    }]);