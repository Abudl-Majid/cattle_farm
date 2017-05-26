myApp.controller('feedUsedCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('feedUsed/').success(function(data) {
            $scope.feedUseds = data;
        });
        $http.get('animal/').success(function(data) {
            $scope.animals = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.feedUsedData = {};
        var Obj={};


        $scope.btnClick = function(feedUsed) {
            console.log(feedUsed);

            if (feedUsed.selected != false ){
                $scope.feedUsedData = {
                    id: feedUsed.id,
                    quantity: feedUsed.quantity,
                    animal: feedUsed.animal
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a feedUsed first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatefeedUsed Function against update button
        $scope.save = function() {

            $scope.showForm = true;

            if($scope.feedUsedData.id){

                $http
                    .put('feedUsed/',$scope.feedUsedData)
                    .success(function(data) {
                        $scope.feedUseds.forEach(function(feedUsed){
                            if(feedUsed.id === $scope.feedUsedData.id){
                                feedUsed.id = $scope.feedUsedData.id;
                                feedUsed.quantity = $scope.feedUsedData.quantity;
                                feedUsed.animal = $scope.feedUsedData.animal;

                            }
                        });
                        toastr.success('Given information has been updated successfully', 'Successfully Updated');
                        $scope.showForm = false;
                    })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error')
                    });
            }
            else{
                obj={
                    quantity:$scope.feedUsedData.quantity,
                    animal: $scope.feedUsedData.animal
                };
                $http
                    .post('feedUsed/',obj)
                    .success(function(data) {
                    //data.animal=$scope.feedUsedData.animal;
                    $scope.feedUseds.push(data);
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                    $scope.showForm = false;
                })
                .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error');

            })
            }

        }
        //addfeedUsed function against add button
        $scope.addfeedUsed = function() {
            $scope.showForm = true;
            $scope.feedUsedData = {
                id: '',
                quantity: '',
                animal: '',

            }

        }
        //deletefeedUsed Function against delete button
        $scope.deletefeedUsed = function() {
            console.log($scope.feedUsedData);
            //$scope.showForm = true;
            $http
                .delete('feedUsed/'+$scope.feedUsedData.id)
                .success(function(data) {
                var index=0;
                $scope.feedUseds.forEach(function(feedUsed){
                    index = $scope.feedUseds.indexOf(feedUsed);
                    if(feedUsed.id == $scope.feedUsedData.id){
                        $scope.feedUseds.splice(index,1);

                    }

                })
                 toastr.success('Given information has been deleted successfully', 'Successfully Updated');

            })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error');

                });
        }

        $scope.editfeedUsed = function(){
            $scope.showForm = true;
        }
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