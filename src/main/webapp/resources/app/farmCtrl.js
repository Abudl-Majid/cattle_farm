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
                $http.put('farm/',$scope.farmData).success(function(data) {

                    $scope.farms.forEach(function(farm){
                        if(farm.id == $scope.farmData.id){
                            farm.id= $scope.farmData.id;
                            farm.farmName= $scope.farmData.farmName;
                            farm.company= {id:$scope.farmData.company.id};
                        }
                    });
                    $scope.showForm = false;

                });
            }
            else{

                $http.post('farm/',{"farmName": $scope.farmData.farmName, "company":{"id":$scope.farmData.company.id}}).success(function(data) {
                    data.company.companyName=$scope.farmData.company.companyName;
                    $scope.farms.push(data);
                    $scope.showForm = false;
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
            $http.delete('farm/'+$scope.farmData.id).success(function(data) {
                var index=0;
                $scope.farms.forEach(function(farm){
                    index = $scope.farms.indexOf(farm);
                    if(farm.id == $scope.farmData.id){
                        $scope.farms.splice(index,1);

                    }

                })

            });
        }

        $scope.editfarm = function(){
            $scope.showForm = true;
        }


    }]);