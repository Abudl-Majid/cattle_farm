myApp.controller('farmCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $scope.showForm = false;

        $http.get('farm/').success(function(data) {
            $scope.farms = data;
        });
        $http.get('company/').success(function(data) {
            $scope.companys = data;
        });


        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.farmData = {};
        var Obj={};


        $scope.btnClick = function(farm) {
            console.log(farm);

            if (farm.selected != false ){
                $scope.farmData = {
                    id: farm.id,
                    farmName: farm.farmName,
                    company: farm.company.id


                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a farm first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatefarm Function against update button
        $scope.save = function() {
            $scope.showForm = true;


            //console.log(farmData.company);

            if($scope.farmData.id){
                $http
                    .put('farm/',$scope.farmData)
                    .success(function(data) {
                    $scope.farms.forEach(function(farm){
                        if(farm.id == $scope.farmData.id){
                            farm.id= $scope.farmData.id;
                            farm.farmName= $scope.farmData.farmName;
                            farm.company= {id:$scope.farmData.company.id};
                        }
                    });
                    $scope.showForm = false;
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');


                })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error');

                });
            }
            else{
                $http
                    .post('farm/',{"farmName": $scope.farmData.farmName, "company":{"id":$scope.farmData.company.id}})
                    .success(function(data) {
                    data.company.companyName = $scope.farmData.company.companyName;
                    $scope.farms.push(data);
                    $scope.showForm = false;
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error');

                });
            }

        }
        //addfarm function against add button
        $scope.addfarm = function() {
            $scope.showForm = true;
            $scope.farmData = {
                id: '',
                farmName: '',
                company: '',
            }

        }
        //deletefarm Function against delete button
        $scope.deletefarm = function() {
            console.log($scope.farmData);
            //$scope.showForm = true;
            $http
                .delete('farm/'+$scope.farmData.id)
                .success(function(data) {
                var index=0;
                $scope.farms.forEach(function(farm){
                    index = $scope.farms.indexOf(farm);
                    if(farm.id == $scope.farmData.id){
                        $scope.farms.splice(index,1);

                    }

                })
                toastr.success('Given information has been updated successfully', 'Successfully Updated');

            })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error');

            });
        }

        $scope.editfarm = function(){
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