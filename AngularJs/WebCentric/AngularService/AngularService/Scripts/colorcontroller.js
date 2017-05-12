var app = angular.module("mymodule", [])
.controller("redcontroller", function ($scope, $rootScope) {
    $scope.redcolor = "Iam a red color";
    $rootScope.root = "iam root color";
})

.controller("greencontroller", function ($scope) {
    $scope.greencolor = "Iam a red color";

});