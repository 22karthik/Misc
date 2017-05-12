/// <reference path="angular-route.min.js" />
/// <reference path="J:\angularjs\WebCentric\AngularService\AngularService\Scripts/angular.min.js" />

var app = angular.module("mymodule", ["ngRoute"])
                 .config(function ($routeProvider,$locationProvider) {
                     $routeProvider
                     .when("/home", {
                         templateUrl: "Templates/home.html",
                         controller:"homecontroller"
                     })

                     .when("/courses", {
                         templateUrl: "Templates/courses.html",
                         controller: "coursescontroller"
                     })

                     .when("/students", {
                         templateUrl: "Templates/students.html",
                         controller: "studentscontroller"
                     })
                     .when("/students/:id", {
                             templateUrl: "Templates/studentsDetails.html",
                             controller: "studentsDetailscontroller"
                         })
                     .otherwise({
                         redirectTo:"/home"
                     })
                     $locationProvider.html5Mode(true);
                 })
                   
    //create the controllers
                    .controller("homecontroller", function ($scope) {
                        $scope.message = "Home page";
                    })
                       
                    .controller("coursescontroller", function ($scope) {
                        $scope.courses = ["C#","VB.NET","JAVA"];
                    })
                    
                    .controller("studentscontroller", function ($scope,$http) {
                        $http.get("StudentService.asmx/GetAllStudents")
                        .then(function (response) {
                            $scope.students = response.data;
                        })
                    })

                        .controller("studentsDetailscontroller", function ($scope,$http,$routeParams) {
                            $http({
                                url:"StudentService.asmx/GetStudents",
                                params:{id:$routeParams.id},
                                method:"get"})
                            .then(function (response) {
                                $scope.student = response.data;
                            })
                        });
