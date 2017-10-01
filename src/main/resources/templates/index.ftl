<!DOCTYPE html>

<html lang="en" ng-app="todoApp">
<head>
    <title>TODOLIST</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/app.css" rel="stylesheet"/>
</head>
<body>

<div class="jumbotron text-center">
    <h1>Todolist App</h1>
    <p>Use this app to add todolists to various topics</p>
</div>
<div ui-view></div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="lib/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.3/angular-ui-router.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.11/ngStorage.min.js" ></script>
<script src="js/app.js"></script>





</body>
</html>