var app = angular
        .module("myModule", [])
        .controller("myController", function ($scope, $http,$log,$location,$anchorScroll) {

            /*/$http.get("EmployeeService.asmx/GetAllEmployees")
                 .then(function (response) {
                     $scope.employees = response.data;
                 });*/

            /*$http({
                method:'GET',
                url:"EmployeeService.asmx/GetAllEmployees"})
                 .then(function (response) {
                     $scope.employees = response.data;
                     $log.info(response.data);
                 }, function (reason) {
                     $scope.error = reason.data;
                     $log.info(reason);
                 });*/
            var sucesscallback = function (response) {
                $scope.employees = response.data;
            }
            var errorcallback = function (response) {
                $scope.error = response.data;
            }
            $http({
                method: 'GET',
                url: "EmployeeService.asmx/GetAllEmployees"
            })
                 .then(sucesscallback, errorcallback);

            $http({
                method: 'GET',
                url: "CountryService.asmx/GetData"
            })
                 .then(function (response) {
                     $scope.countries = response.data;
                 });
            $scope.scrollTo = function (countryName) {
                $location.hash(countryName);
                $anchorScroll();
            }


        });