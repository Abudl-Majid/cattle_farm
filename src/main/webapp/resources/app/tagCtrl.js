myApp.controller('tagCtrl', ['$scope', '$http',
    function ($scope, $http) {

        $scope.showForm = false;

        $http.get('tag/').success(function(data) {
            $scope.tags = data;
        });

        $scope.orderProp = 'name';
        $scope.listView = true;
        $scope.tagData = {};
        var Obj={};


        $scope.btnClick = function(tag) {
            console.log(tag);

            if (tag.selected != false ){
                $scope.tagData = {
                    id: tag.id,
                    tagName: tag.tagName
                }
            }
        }
        $scope.onClickOption = function() {
            if (!$scope.selected) {

                alert("slect a tag first");}
            else {
                $scope.showForm = false;
            }
        }
        //updatetag Function against update button
        $scope.save = function() {
            $scope.showForm = true;

            if($scope.tagData.id && $valid){
                $http
                    .put('tag/',$scope.tagData)
                    .success(function(data) {
                        $scope.tags.forEach(function(tag){
                            if(tag.id == $scope.tagData.id){
                                tag.id= $scope.tagData.id;
                                tag.tagName= $scope.tagData.tagName;
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
                if($valid){
                    $http
                        .post('tag/',$scope.tagData)
                        .success(function(data) {
                            $scope.tags.push(data);
                            $scope.showForm = false;
                            toastr.success('Given information has been updated successfully', 'Successfully Updated');
                        })
                        .error(function(error){
                            toastr.error('Unknown error occured during the processing please try again', 'Error')
                        });
                }
            }
        }
        //addtag function against add button
        $scope.addtag = function() {
            $scope.showForm = true;
            $scope.tagData = {
                id: '',
                tagName: ''

            }

        }
        //deletetag Function against delete button
        $scope.deletetag = function() {
            console.log($scope.tagData);
            //$scope.showForm = true;
            $http
                .delete('tag/'+$scope.tagData.id)
                .success(function(data) {
                    var index=0;
                    $scope.tags.forEach(function(tag){
                        index = $scope.tags.indexOf(tag);
                        if(tag.id == $scope.tagData.id){
                            $scope.tags.splice(index,1);

                        }

                    })
                    toastr.success('Given information has been updated successfully', 'Successfully Updated');

                })
                .error(function(error){
                    toastr.error('Unknown error occured during the processing please try again', 'Error')
                });
        }

        $scope.edittag = function(){
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