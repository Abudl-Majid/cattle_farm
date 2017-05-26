myApp.controller('UserListCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('user/').success(function(data) {
            $scope.users = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.userData = {};
        var Obj={};


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

            if($scope.userData.id && $valid){
              $http
                  .put('user/',$scope.userData)
                  .success(function(data) {
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
                      toastr.success('Given information has been updated successfully', 'Successfully Updated');
                  })
                  .error(function(error){
                      toastr.error('Unknown error occured during the processing please try again', 'Error')
                  });
            }
            else{
                if($valid){
                  $http
                      .post('user/',$scope.userData)
                      .success(function(data) {
                        $scope.users.push(data);
                        $scope.showForm = false;
                        toastr.success('Given information has been updated successfully', 'Successfully Updated');
                      })
                      .error(function(error){
                          toastr.error('Unknown error occured during the processing please try again', 'Error')
                      });
                }
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
            $http
                .delete('user/'+$scope.userData.id)
                .success(function(data) {
                    var index=0;
                    $scope.users.forEach(function(user){
                      index = $scope.users.indexOf(user);
                        if(user.id == $scope.userData.id){
                          $scope.users.splice(index,1);

                        }

                    })
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
                });
        }

        $scope.editUser = function(){
            $scope.showForm = true;
        }
        // FORM FIELD VALIDATION STARTS HERE
        $scope.isNumber=function($event) {
            var charCode = ($event.which) ? $event.which : $event.keyCode;
            if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                $event.preventDefault();
                alert("Only Numarics Are Allowed");
                return false;
            }
        }
        $scope.ValidateAlpha = function ($event) {
            var keyCode = ($event.which) ? $event.which : $eventt.keyCode
            if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32){
                alert("Only Alphabets Are Allowed");
                event.preventDefault();
                return false;
            }
        }
    }]);