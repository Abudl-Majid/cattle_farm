myApp.controller('loginCtrl', ['$scope', '$http', '$injector','$location',
    function ($scope, $http, $injector) {

        $scope.createFailed = false;
        $scope.login = function() {
            $http
                .post('user/login/',$scope.userData)
                .success(function (data) {
                        if (data === 'success') {
                           // $injector.get('$state').transitionTo('/main');
                            window.location = "index.jsp";
                            //console.log($state);
                            //$state.go('/main');
                        } else {
                           // window.location = "login.jsp";
                            $scope.createFailed = true;
                        }
                });

        }
    }]);