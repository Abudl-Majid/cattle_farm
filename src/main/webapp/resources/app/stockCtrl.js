myApp.controller('stockCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('stock/').success(function(data) {
            $scope.stocks = data;
        });
        $http.get('product/').success(function(data) {
            $scope.products = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.stockData = {};
        var Obj={};


        $scope.btnClick = function(stock) {
            console.log(stock);

            if (stock.selected != false ){
                $scope.stockData = {
                    id: stock.id,
                    qtyInHand: stock.qtyInHand,
                    product: stock.product,

                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a stock first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatestock Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.stockData.id){
                $http
                    .put('stock/',$scope.stockData)
                    .success(function(data) {
                        $scope.stocks.forEach(function(stock){
                            if(stock.id == $scope.stockData.id){
                                stock.id= $scope.stockData.id;
                                stock.qtyInHand= $scope.stockData.qtyInHand;
                                stock.product= $scope.stockData.product;
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
                    .post('stock/',$scope.stockData)
                    .success(function(data) {
                        $scope.stocks.push(data);
                        $scope.showForm = false;
                        toastr.success('Given information has been updated successfully', 'Successfully Updated');
                    })
                    .error(function(error){
                        toastr.error('Unknown error occured during the processing please try again', 'Error')
                    });
            }

        }
        //addstock function against add button
        $scope.addstock = function() {
            $scope.showForm = true;
            $scope.stockData = {
                id: '',
                qtyInHand: '',
                product: ''
            }

        }
        //deletestock Function against delete button
        $scope.deletestock = function() {
            console.log($scope.stockData);
            //$scope.showForm = true;
            $http
                .delete('stock/'+$scope.stockData.id)
                .success(function(data) {
                    var index=0;
                    $scope.stocks.forEach(function(stock){
                        index = $scope.stocks.indexOf(stock);
                        if(stock.id == $scope.stockData.id){
                            $scope.stocks.splice(index,1);

                        }

                    })
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');
                })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
                });
        }

        $scope.editstock = function(){
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