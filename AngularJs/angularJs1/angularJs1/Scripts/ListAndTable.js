var app = angular
         .module("mymodule", [])
          .controller("mycontroller", function ($scope) {

   var Employees = [
     { name: "kar", DOB: new Date("June 22,1993"), gender: 1, salary: 60000 },
     { name: "smi", DOB: new Date("September 27,1999"), gender: 2, salary: 50000 },
     { name: "poo", DOB: new Date("November 29,1994"), gender: 2, salary: 30000 },
     { name: "nis", DOB: new Date("June 04,2002"), gender: 2, salary: 20000 },
     { name: "vin", DOB: new Date("June 04,2002"), gender: 1, salary: 20000 }
              ];
   $scope.employee = Employees;
   $scope.employeeView = "EmployeeList.html";
          });