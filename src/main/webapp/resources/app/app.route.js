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
            .when("/company",{
                templateUrl:"company.jsp",
                controller:"companyCtrl"
            })
            .when("/farm",{
                templateUrl:"farm.jsp",
                controller:"farmCtrl"
            })
            .otherwise({redirectTo:"/main"})
    })

}());