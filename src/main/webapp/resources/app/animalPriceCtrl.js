myApp.controller('animalPriceCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('animalPrice/').success(function(data) {
            $scope.animalPrices = data;
        });
        $http.get('animal/').success(function(data) {
            $scope.animals = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.animalPriceData = {};
        var Obj={};


        $scope.btnClick = function(animalPrice) {
            console.log(animalPrice);

            if (animalPrice.selected != false ){
                $scope.animalPriceData = {
                    id: animalPrice.id,
                    price : animalPrice.price,
                    version : animalPrice.version,
                    animal : animalPrice.animal
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a animalPrice first");}
            else {
                $scope.showForm = false;
            }
        }
        //updateanimalPrice Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.animalPriceData.id){
                $http
                    .put('animalPrice/',$scope.animalPriceData)
                    .success(function(data) {
                        $scope.animalPrices.forEach(function(animalPrice){
                            if(animalPrice.id === $scope.animalPriceData.id){
                                animalPrice.id = $scope.animalPriceData.id;
                                animalPrice.price = $scope.animalPriceData.price;
                                animalPrice.version =$scope.animalPriceData.version;
                                animalPrice.animal= $scope.animalPriceData.animal;
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
                Obj={
                    price:$scope.animalPriceData.price,
                    version:$scope.animalPriceData.version,
                    animal:$scope.animalPriceData.animal
                };

                $http
                    .post('animalPrice/',Obj)
                    .success(function(data) {
                        $scope.animalPrices.push(data);
                        $scope.showForm = false;
                    })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error')
                    });
            }

        }
        //addanimalPrice function against add button
        $scope.addanimalPrice = function() {
            $scope.showForm = true;
            $scope.animalPriceData = {
                id: '',
                price: '',
                version: '',
                animal: ''
            }

        }
        //deleteanimalPrice Function against delete button
        $scope.deleteanimalPrice = function() {
            console.log($scope.animalPriceData);
            //$scope.showForm = true;
            $http
                .delete('animalPrice/'+$scope.animalPriceData.id)
                .success(function(data) {
                    var index=0;
                    $scope.animalPrices.forEach(function(animalPrice){
                        index = $scope.animalPrices.indexOf(animalPrice);
                        if(animalPrice.id == $scope.animalPriceData.id){
                            $scope.animalPrices.splice(index,1);

                        }

                    })
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
                });
        }

        $scope.editanimalPrice = function(){
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