/// <reference path="angular.min.js" />
//create a module->main of java
var myapp = angular.module("myapp", []);

//create the controller and associate the controller to module

/*var myController = function ($scope) {
    $scope.message = "Welcome to angular";
}
myapp.controller("myController", myController);*/

myapp.controller("myController", function ($scope) {
    $scope.message = "Welcome to angular";
    //create the object in angular js
    var country={
        name: "India",
        capital: "Delhi",
        flag:"/images/kar.jpg"
    };
    $scope.country = country;

    //create the array of employees
    var Employees = [
     { name: "kar", DOB:new Date("June 22,1993"), gender: "male", salary: 60000 },
     { name: "smi", DOB:new Date("September 27,1999"), gender: "female", salary: 50000 },
     { name: "poo", DOB:new Date("November 29,1994"), gender: "female", salary: 30000 },
     { name: "nis", DOB: new Date("June 04,2002"), gender: "female", salary: 20000 },
     { name: "vin", DOB: new Date("June 04,2002"), gender: "male", salary: 20000 }
    ];
   

    var countrydata = [
                      {
                          name: "UK",
                          cities: [
                              { name: "London" },
                              { name: "Bristol" },
                              { name: "manchester" },
                          ]
                      },
                       {
                           name: "India",
                           cities: [
                               { name: "Chennai" },
                               { name: "Bangalore" },
                               { name: "Kolkota" },
                           ]
                       },
                        {
                            name: "USA",
                            cities: [
                                { name: "Los Angeles" },
                                { name: "Las vegas" },
                                { name: "Arizona" },
                            ]
                        }

                      ];
    $scope.countrydata = countrydata;

    $scope.employees = Employees;
    $scope.sortcolumn = "name";
    $scope.reversesort = false;

    $scope.sortData = function (column) {
        $scope.reversesort = ($scope.sortcolumn == column) ? !$scope.reversesort : false;
        $scope.sortcolumn = column;
    }
    $scope.getsortData = function (column) {
        if ($scope.sortcolumn == column) {
            return $scope.reversesort ? 'arrow-down' : 'arrow-up';
        }
        return '';
    }
    $scope.search = function (item) {
        if ($scope.searchText == undefined) {
            return true;
        }
        else {
            if (item.name.toLowerCase().indexOf($scope.searchText.toLowerCase()) != -1 ||
                item.gender.toLowerCase().indexOf($scope.searchText.toLowerCase()) != -1)
                {
                return true;
            }
            return false;
        }
    }

});
