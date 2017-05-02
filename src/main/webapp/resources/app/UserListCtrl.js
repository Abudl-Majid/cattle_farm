myApp.controller('UserListCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('user/').success(function(data) {
            $scope.users = data;
        });
        /*$http.post('user/').success(function(data) {
            $scope.users = data;
        });
        $http.put('user/').success(function(data) {
            $scope.users = data;
        });
        $http.delete('user/').success(function(data) {
            $scope.users = data;
        });*/

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.userData = {};
        var Obj={};
        var userObj={"id": 8,
            "username": "tahir khan",
            "password": "yahir",
            "email": "tahir@vroozi.com",
            "name": "Abdul Majid",
            "selected": false
    }

        $scope.btnClick = function(user) {
            console.log(user);
            if (user.selected != false ){
                $scope.showForm = true;
                $scope.userData = {
                    UserName: user.username,
                    Password: user.password,
                    Name: user.name,
                    Email: user.email
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a user first");}
                else {
                    $scope.showForm = false;
                }
            }
            //updateUser Function against update button
        $scope.upDateUser = function() {
            //$scope.showForm = true;
            $http.put('user/').success(function(data) {
                $scope.users = data;

        });}
        //addUser function against add button
        $scope.addUser = function() {
            //$scope.showForm = true;
            console
             obj =   {
                "username": $scope.userData.UserName,
                "password": $scope.userData.Password,
                "email": $scope.userData.Name,
                "name": $scope.userData.Email
            };
            $http.post('user/', obj).success(function(data) {
                $scope.userData = data;

            });}

        //deleteUser Function against delete button
        $scope.deleteUser = function() {
            console.log($scope.userData);
            //$scope.showForm = true;
            $http.delete('user/',Obj).success(function(data) {
                $scope.userData = data;

            });
        }

        $scope.editUser = function(){
            $scope.showForm = true;
        }
    }]);