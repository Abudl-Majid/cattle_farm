myApp.controller('purchaseTypeCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('purchaseType/').success(function(data) {
            $scope.purchaseTypes = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.purchaseTypeData = {};
        var Obj={};


        $scope.btnClick = function(purchaseType) {
            console.log(purchaseType);

            if (purchaseType.selected != false ){
                $scope.purchaseTypeData = {
                    id: purchaseType.id,
                    purchaseType: purchaseType.purchaseType
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a purchaseType first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatepurchaseType Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.purchaseTypeData.id){
                $http
                    .put('purchaseType/',$scope.purchaseTypeData)
                    .success(function(data) {

                    $scope.purchaseTypes.forEach(function(purchaseType){
                        if(purchaseType.id == $scope.purchaseTypeData.id){
                            purchaseType.id= $scope.purchaseTypeData.id;
                            purchaseType.purchaseType= $scope.purchaseTypeData.purchaseType;
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
                $http
                    .post('purchaseType/',$scope.purchaseTypeData)
                    .success(function(data) {
                    $scope.purchaseTypes.push(data);
                    $scope.showForm = false;
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');

                })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error')
                });
            }

        }
        //addpurchaseType function against add button
        $scope.addpurchaseType = function() {
            $scope.showForm = true;
            $scope.purchaseTypeData = {
                id: '',
                purchaseType: ''
            }

        }
        //deletepurchaseType Function against delete button
        $scope.deletepurchaseType = function() {
            console.log($scope.purchaseTypeData);
            //$scope.showForm = true;
            $http
                .delete('purchaseType/'+$scope.purchaseTypeData.id)
                .success(function(data) {
                var index=0;
                $scope.purchaseTypes.forEach(function(purchaseType){
                    index = $scope.purchaseTypes.indexOf(purchaseType);
                    if(purchaseType.id == $scope.purchaseTypeData.id){
                        $scope.purchaseTypes.splice(index,1);

                    }
                })
                toastr.success('Given information has been updated successfully', 'Successfully Updated');
            })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
            });
        }

        $scope.editpurchaseType = function(){
            $scope.showForm = true;
        }
    }]);