/// <reference path="angular-route.min.js" />
/// <reference path="J:\angularjs\WebCentric\AngularService\AngularService\Scripts/angular.min.js" />
//ngRoute
var app = angular.module("mymodule", ["ngRoute"])
                 .config(function ($routeProvider, $locationProvider) {
                     //caseinsensitive router
                     $routeProvider.caseInsensitiveMatch = true;

                     $routeProvider
                     .when("/home", {
                         template:"<h1>Hello inline template in action</h1>",
                         controller: "homecontroller",
                         controllerAs: "homectrl"
                     })

                     .when("/courses", {
                         templateUrl: "Templates/courses.html",
                         controller: "coursescontroller",
                         controllerAs: "coursesctrl",
                        
                 })



                     .when("/students", {
                         templateUrl: "Templates/students.html",
                         controller: "studentscontroller",
                         controllerAs: "studentsctrl",
                         resolve: {
                             studentsList: function ($http) {
                                 return $http.get("StudentService.asmx/GetAllStudents")
                                  .then(function (response) {
                                      return response.data;
                                  })
                             }
                         }
                     })
                     .when("/students/:id", {
                         templateUrl: "Templates/studentsDetails.html",
                         controller: "studentsDetailscontroller",
                         controllerAs: "studentsdetailsctrl"
                     })
                          .when("/searchname/:name?", {
                              templateUrl: "Templates/studentsSearch.html",
                              controller: "studentssearchcontroller",
                              controllerAs: "studentssearchctrl"
                          })
                         .otherwise({
                         redirectTo: "/home"
                     })
                     $locationProvider.html5Mode(true);
                 })

    //create the controllers
                    .controller("homecontroller", function () {
                        this.message = "Home page";
                    })

                    .controller("coursescontroller", function () {
                        this.courses = ["C#", "VB.NET", "JAVA"];
                    })

                    .controller("studentscontroller", function (studentsList, $route, $scope,$log,$location) {
                        var vm = this;
                        vm.searchname = function () {
                            if (vm.name)
                                $location.url("/searchname/" + vm.name);
                            else
                                $location.url("/searchname");
                        }
                        $scope.$on("$routeChangeStart", function (event, next, current) {
                            /*/ if(!confirm("Are you sure to navigate away from this page"+next.$$route.originalPath))
                             {
                                 event.preventDefault();
                             }*/

                            $log.debug("rouechangestart fired");
                            $log.debug(event);
                            $log.debug(next);
                            $log.debug(current);



                        });//con function
                        //for reload just this view
                        vm.reloadData = function () {
                            $route.reload();
                        }
                        vm.students = studentsList;
                        /*$http.get("StudentService.asmx/GetAllStudents")

                        .then(function (response) {
                            vm.students = response.data;
                        })*/
                    })//control

                        .controller("studentsDetailscontroller", function ($http, $routeParams) {
                            var vm = this;
                            $http({
                                url: "StudentService.asmx/GetStudents",
                                params: { id: $routeParams.id },
                                method: "get"
                                
                            })

                            .then(function (response) {
                                vm.student = response.data;
                            })
                            //controller for nested 
                        })


                     .controller("studentssearchcontroller", function ($http, $routeParams) {
                           var vm = this;
                           if ($routeParams.name) {
                         $http({
                             url: "StudentService.asmx/GetStudentsByName",
                             method: "get",
                             params: { name: $routeParams.name }
                         }).then(function (response) {
                             vm.student = response.data;
                         })
                           }
                           else {
                               $http.get("StudentService.asmx/GetAllStudents")

                            .then(function (response) {
                                vm.student = response.data;
                            })

                           }

                   
                    //controller for nested 
                });
