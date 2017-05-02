(function(){
   // var myApp = angular.module('myApp',["ngRoute"]);
    myApp.config(function($routeProvider){
        $routeProvider
            .when("/main",{
                templateUrl:"main.jsp",
                controller:"MainCtrl"
            })
            .when("/users",{
                templateUrl:"users.jsp",
                controller:"UserListCtrl"
            })
            .when("/customer",{
                templateUrl:"customer.jsp",
                controller:"CustomerCtrl"
            })
            .otherwise({redirectTo:"/main"})
    })

}());