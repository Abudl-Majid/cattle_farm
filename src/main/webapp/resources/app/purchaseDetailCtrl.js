myApp.controller('purchaseDetailCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('purchaseDetail/').success(function(data) {
            $scope.purchaseDetails = data;
        });
        $http.get('animal/').success(function(data) {
            $scope.animals = data;
        });
        $http.get('purchaseType/').success(function(data) {
            $scope.purchaseTypes = data;
        });
        //$http.get('purchase/').success(function(data) {
          //  $scope.purchases = data;
        //});
        $http.get('product/').success(function(data) {
            $scope.products = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.purchaseDetailData = {};
        var Obj={};


        $scope.btnClick = function(purchaseDetail) {
            console.log(purchaseDetail);

            if (purchaseDetail.selected != false ){
                $scope.purchaseDetailData = {
                    id: purchaseDetail.id,
                    purchase: purchaseDetail.purchase,
                    price: purchaseDetail.price,
                    quantity: purchaseDetail.quantity,
                    animal:purchaseDetail.animal,
                    product:purchaseDetail.product,
                    purchaseType:purchaseDetail.purchaseType

                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a purchaseDetail first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatepurchaseDetail Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.purchaseDetailData.id){
                $http
                    .put('purchaseDetail/',$scope.purchaseDetailData)
                    .success(function(data) {
                        $scope.purchaseDetails.forEach(function(purchaseDetail){
                            if(purchaseDetail.id == $scope.purchaseDetailData.id){
                                purchaseDetail.id= $scope.purchaseDetailData.id;
                                purchaseDetail.purchase= $scope.purchaseDetailData.purchase;
                                purchaseDetail.price= $scope.purchaseDetailData.price;
                                purchaseDetail.quantity= $scope.purchaseDetailData.quantity;
                                purchaseDetail.animal= $scope.purchaseDetailData.animal;
                                purchaseDetail.product= $scope.purchaseDetailData.product;
                                purchaseDetail.purchaseType= $scope.purchaseDetailData.purchaseType;
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
                    .post('purchaseDetail/detail/ ',$scope.purchaseDetailData)
                    .success(function(data) {
                        $scope.purchaseDetails.push(data);
                        $scope.showForm = false;
                        toastr.success('Given information has been updated successfully', 'Successfully Updated');
                    })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error')
                    });
            }

        }
        //addpurchaseDetail function against add button
        $scope.addpurchaseDetail = function() {
            $scope.showForm = true;
            $scope.purchaseDetailData = {
                id: '',
                purchase: '',
                price: '',
                quantity: '',
                animal: '',
                product: '',
                purchaseType: ''
            }

        }
        //deletepurchaseDetail Function against delete button
        $scope.deletepurchaseDetail = function() {
            console.log($scope.purchaseDetailData);
            //$scope.showForm = true;
            $http
                .delete('purchaseDetail/'+$scope.purchaseDetailData.id)
                .success(function(data) {
                    var index=0;
                    $scope.purchaseDetails.forEach(function(purchaseDetail){
                        index = $scope.purchaseDetails.indexOf(purchaseDetail);
                        if(purchaseDetail.id == $scope.purchaseDetailData.id){
                            $scope.purchaseDetails.splice(index,1);

                        }

                    })
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
                });
        }

        $scope.editpurchaseDetail = function(){
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