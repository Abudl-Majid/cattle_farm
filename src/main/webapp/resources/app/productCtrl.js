myApp.controller('productCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('product/').success(function(data) {
            $scope.products = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.productData = {};
        var Obj={};


        $scope.btnClick = function(product) {
            console.log(product);

            if (product.selected != false ){
                $scope.productData = {
                    id: product.id,
                    productName: product.productName,
                    productPrice: product.productPrice
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a product first");}
            else {
                $scope.showForm = false;
            }
        }
        //updateproduct Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.productData.id){
                $http
                    .put('product/',$scope.productData)
                    .success(function(data) {

                    $scope.products.forEach(function(product){
                        if(product.id == $scope.productData.id){
                            product.id= $scope.productData.id;
                            product.productName= $scope.productData.productName;
                            product.productPrice= $scope.productData.productPrice;
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
                    .post('product/',$scope.productData)
                    .success(function(data) {
                    $scope.products.push(data);
                    $scope.showForm = false;
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error')
                 });
            }

        }
        //addproduct function against add button
        $scope.addproduct = function() {
            $scope.showForm = true;
            $scope.productData = {
                id: '',
                productName: '',
                productPrice: ''
            }

        }
        //deleteproduct Function against delete button
        $scope.deleteproduct = function() {
            console.log($scope.productData);
            //$scope.showForm = true;
            $http
                .delete('product/'+$scope.productData.id)
                .success(function(data) {
                var index=0;
                $scope.products.forEach(function(product){
                    index = $scope.products.indexOf(product);
                    if(product.id == $scope.productData.id){
                        $scope.products.splice(index,1);

                    }

                })
                toastr.success('Given information has been updated successfully', 'Successfully Deleted');;

            })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
            });
        }

        $scope.editproduct = function(){
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