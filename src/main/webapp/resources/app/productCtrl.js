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
                $http.put('product/',$scope.productData).success(function(data) {

                    $scope.products.forEach(function(product){
                        if(product.id == $scope.productData.id){
                            product.id= $scope.productData.id;
                            product.productName= $scope.productData.productName;
                            product.productPrice= $scope.productData.productPrice;
                        }
                    });
                    $scope.showForm = false;

                });
            }
            else{
                $http.post('product/',$scope.productData).success(function(data) {
                    $scope.products.push(data);
                    $scope.showForm = false;
                });
            }

        }
        //addproduct function against add button
        $scope.addproduct = function() {
            $scope.showForm = true;
            $scope.productData = {
                id: '',
                productName: '',
                productPrice: '',
            }

        }
        //deleteproduct Function against delete button
        $scope.deleteproduct = function() {
            console.log($scope.productData);
            //$scope.showForm = true;
            $http.delete('product/'+$scope.productData.id).success(function(data) {
                var index=0;
                $scope.products.forEach(function(product){
                    index = $scope.products.indexOf(product);
                    if(product.id == $scope.productData.id){
                        $scope.products.splice(index,1);

                    }

                })

            });
        }

        $scope.editproduct = function(){
            $scope.showForm = true;
        }
    }]);