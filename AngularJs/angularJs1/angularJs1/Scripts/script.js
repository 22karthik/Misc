/// <reference path="angular.min.js" />
var app = angular
         .module("mymodule", [])
    .filter("gender", function () {

        return function (gender) {
            switch(gender){
                case 1: return "male";
                case 2: return "female"
            }
            
        }
    })
.controller("mycontroller", function ($scope,$location,$anchorScroll,stringfunction) {
    var technologies = [
                         { name: "C#", likes: 0, dislikes: 0 },
                         { name: "Java", likes: 0, dislikes: 0 },
                         { name: "Html", likes: 0, dislikes: 0 },
                         { name: "CSS", likes: 0, dislikes: 0 },
    ];

    $scope.technologies = technologies;

    //increment or decrement likes

    $scope.incrementLikes = function (technology) {
        technology.likes++;
    }

    $scope.incrementdislikes = function (technology) {
        technology.dislikes++;
    }

    var Employees = [
     { name: "kar", DOB: new Date("June 22,1993"), gender: 1, salary: 60000 },
     { name: "smi", DOB: new Date("September 27,1999"), gender: 2, salary: 50000 },
     { name: "poo", DOB: new Date("November 29,1994"), gender: 2, salary: 30000 },
     { name: "nis", DOB: new Date("June 04,2002"), gender: 2, salary: 20000 },
     { name: "vin", DOB: new Date("June 04,2002"), gender: 1, salary: 20000 }
    ];
    $scope.employee = Employees;

    $scope.transformString = function (input) {
        $scope.output = stringfunction.processString(input);
    }

    $scope.scrollTo= function (scrollLocation) {
         
        $location.hash(scrollLocation);
        $anchorScroll();

    }
    $scope.employeeView="EmployeeList.html"
   

});