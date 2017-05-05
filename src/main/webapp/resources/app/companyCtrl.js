myApp.controller('companyCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $scope.showForm = false;

        $http.get('company/').success(function(data) {
            $scope.companys = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.companyData = {};
        var Obj={};


        $scope.btnClick = function(company) {
            console.log(company);

            if (company.selected != false ){
                $scope.companyData = {
                    id: company.id,
                    companyName: company.companyName
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a company first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatecompany Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.companyData.id){
                $http.put('company/',$scope.companyData).success(function(data) {

                    $scope.companys.forEach(function(company){
                        if(company.id == $scope.companyData.id){
                            company.id= $scope.companyData.id;
                            company.companyName= $scope.companyData.companyName;
                        }
                    });
                    $scope.showForm = false;

                });
            }
            else{
                $http.post('company/',$scope.companyData).success(function(data) {
                    $scope.companys.push(data);
                    $scope.showForm = false;
                });
            }

        }
        //addcompany function against add button
        $scope.addcompany = function() {
            $scope.showForm = true;
            $scope.companyData = {
                id: '',
                companyName: '',
            }

        }
        //deletecompany Function against delete button
        $scope.deletecompany = function() {
            console.log($scope.companyData);
            //$scope.showForm = true;
            $http.delete('company/'+$scope.companyData.id).success(function(data) {
                var index=0;
                $scope.companys.forEach(function(company){
                    index = $scope.companys.indexOf(company);
                    if(company.id == $scope.companyData.id){
                        $scope.companys.splice(index,1);

                    }

                })

            });
        }

        $scope.editcompany = function(){
            $scope.showForm = true;
        }

    }]);