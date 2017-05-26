myApp.controller('purchaseCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('purchase/').success(function(data) {
            $scope.purchases = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.purchaseData = {};
        var Obj={};


        $scope.btnClick = function(purchase) {
            console.log(purchase);

            if (purchase.selected != false ){
                $scope.purchaseData = {
                    id: purchase.id,
                    purchaseDate: purchase.purchaseDate
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a purchase first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatepurchase Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.purchaseData.id){
                $http
                    .put('purchase/',$scope.purchaseData)
                    .success(function(data) {

                    $scope.purchases.forEach(function(purchase){
                        if(purchase.id == $scope.purchaseData.id){
                            purchase.id= $scope.purchaseData.id;
                            purchase.purchaseDate= $scope.purchaseData.purchaseDate;
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
                $http.post('purchase/',$scope.purchaseData).success(function(data) {
                    $scope.purchases.push(data);
                    $scope.showForm = false;
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error')
                });

            }

        }
        //addpurchase function against add button
        $scope.addpurchase = function() {
            $scope.showForm = true;
            $scope.purchaseData = {
                id: '',
                purchaseDate: ''
            }

        }
        //deletepurchase Function against delete button
        $scope.deletepurchase = function() {
            console.log($scope.purchaseData);
            //$scope.showForm = true;
            $http
                .delete('purchase/'+$scope.purchaseData.id)
                .success(function(data) {
                var index=0;
                $scope.purchases.forEach(function(purchase){
                    index = $scope.purchases.indexOf(purchase);
                    if(purchase.id == $scope.purchaseData.id){
                        $scope.purchases.splice(index,1);

                    }

                })
                toastr.success('Given information has been updated successfully', 'Successfully Updated');
            })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
            });
        }

        $scope.editpurchase = function(){
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