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
                $scope.userData = {
                  id: user.id,
                  username: user.username,
                  password: user.password,
                  name: user.name,
                  email: user.email
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
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.userData.id){
              $http.put('user/',$scope.userData).success(function(data) {

                $scope.users.forEach(function(user){
                    if(user.id == $scope.userData.id){
                        user.id= $scope.userData.id;
                          user.username= $scope.userData.username;
                          user.password= $scope.userData.password;
                          user.name= $scope.userData.name;
                          user.email= $scope.userData.email;
                    }
                });
                $scope.showForm = false;

              });
            }
            else{
              $http.post('user/',$scope.userData).success(function(data) {
                $scope.users.push(data);
                $scope.showForm = false;
              });
            }

}
        //addUser function against add button
        $scope.addUser = function() {
          $scope.showForm = true;
          $scope.userData = {
            id: '',
            username: '',
            password: '',
            name: '',
            email: ''
          }

        }
        //deleteUser Function against delete button
        $scope.deleteUser = function() {
            console.log($scope.userData);
            //$scope.showForm = true;
            $http.delete('user/'+$scope.userData.id).success(function(data) {
                var index=0;
                $scope.users.forEach(function(user){
                  index = $scope.users.indexOf(user);
                    if(user.id == $scope.userData.id){
                      $scope.users.splice(index,1);

                    }

                })

            });
        }

        $scope.editUser = function(){
            $scope.showForm = true;
        }
    }]);