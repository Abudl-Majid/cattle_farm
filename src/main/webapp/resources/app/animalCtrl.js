myApp.controller('animalCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('animal/').success(function(data) {
            $scope.animals = data;
        });
        $http.get('farm/').success(function(data) {
            $scope.farms = data;
        });
        $http.get('tag/').success(function(data) {
            $scope.tags = data;
        });
        $http.get('purchase/').success(function(data) {
            $scope.purchases = data;
        });


        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.animalData = {};
        var Obj={};



        $scope.btnClick = function(animal) {
            console.log(animal);

            if (animal.selected != false ){
                $scope.animalData = {
                    id: animal.id,
                    animalName: animal.animalName,
                    animalInitialPrice: animal.animalInitialPrice,
                    birthDate: animal.birthDate,
                    birthWeight: animal.birthWeight,
                    farm:animal.farm.id,
                    tag:animal.tag.id,
                    initialPurchase:animal.initialPurchase.id
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a animal first");}
            else {
                $scope.showForm = false;
            }
        }
        //updateanimal Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.animalData.id){
                $http
                    .put('animal/',$scope.animalData)
                    .success(function(data) {

                    $scope.animals.forEach(function(animal){
                        if(animal.id == $scope.animalData.id){
                            animal.id= $scope.animalData.id;
                            animal.animalName= $scope.animalData.animalName;
                            animal.animalInitialPrice= $scope.animalData.animalInitialPrice;
                            animal.birthDate= $scope.animalData.birthDate;
                            animal.birthWeight= $scope.animalData.birthWeight;
                            animal.farm= {id:$scope.animalData.farm.id};
                            animal.tag= {id:$scope.animalData.tag.id};
                            animal.initialPurchase= {id:$scope.animalData.purchase.id};
                        }
                    });
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                    $scope.showForm = false;

                })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error');

                });
            }
            else{
                var obj = {
                    animalName: $scope.animalData.animalName,
                    animalInitialPrice: $scope.animalData.animalInitialPrice,
                    birthDate: $scope.animalData.birthDate,
                    birthWeight: $scope.animalData.birthWeight,
                    farm:{ id: $scope.animalData.farm.id },
                    tag:{ id: $scope.animalData.tag.id },
                    initialPurchase:{ id: $scope.animalData.initialPurchase.id }
                };

                    $http
                        .post('animal/', obj)
                        .success(function (data) {
                            data.farm.farmName = $scope.animalData.farm.farmName;
                            data.tag.tagName = $scope.animalData.tag.tagName;
                            data.initialPurchase = $scope.animalData.initialPurchase;
                            $scope.animals.push(data);
                            $scope.showForm = false;
                            toastr.success('Given information has been updated successfully', 'Successfully Updated');
                        })

                        .error(function (error) {
                            toastr.error('Unknown error occured during the processing please try again', 'Error');

                        });

            }

        }
        //addanimal function against add button
        $scope.addanimal = function() {
            $scope.showForm = true;
            $scope.animalData = {
                id: '',
                animalName: '',
                animalInitialPrice:'',
                birthDate: '',
                birthWeight: '',
                farm: '',
                tag: '',
                initialPurchase: ''
            }

        }
        //deleteanimal Function against delete button
        $scope.deleteanimal = function() {
            console.log($scope.animalData);
            //$scope.showForm = true;
            $http
                .delete('animal/'+$scope.animalData.id)
                .success(function(data) {
                var index=0;
                $scope.animals.forEach(function(animal){
                    index = $scope.animals.indexOf(animal);
                    if(animal.id == $scope.animalData.id){
                        $scope.animals.splice(index,1);

                    }

                })
                toastr.success('Given information has been updated successfully', 'Successfully Updated');

            })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error');

            });

        }

        $scope.editanimal = function(){
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
       /* $scope.validator=function(){
            if ($scope.ValidateAlpha() != true ) {
                alert("Only Alphabates Are Allowed");
                return false;
            }
            else if ($scope.isNumber() != true) {
                alert("only Numerics Are Allowed");
                return false;
            }
            else
                return true;
        }*/
    }]);