/// <reference path="angular-route.min.js" />
/// <reference path="J:\angularjs\WebCentric\AngularService\AngularService\Scripts/angular.min.js" />
//ngRoute
var app = angular.module("mymodule", ["ui.router"])
                 .config(function ($stateProvider, $urlMatcherFactoryProvider, $urlRouterProvider, $locationProvider) {
                     //caseinsensitive router
                     //$routeProvider.caseInsensitiveMatch = true;
                     //provide default route

                     $urlRouterProvider.otherwise("/home");
                     $urlMatcherFactoryProvider.caseInsensitive(true);
                     $stateProvider
                     .state("home", {
                         url: "/home",
                         templateUrl: "Templates/home.html",
                         controller: "homecontroller",
                         controllerAs: "homectrl",
                         //add custom data
                         data: {
                             customData1: "Home state custom data1",
                             customData2: "Home state custom data2"
                         }
                     })

                     .state("courses", {
                         url: "/courses",
                         templateUrl: "Templates/courses.html",
                         controller: "coursescontroller",
                         controllerAs: "coursesctrl",

                     })

                    .state("studentParent", {
                        url: "/students",
                        
                        controller: "studentsParentcontroller",
                        controllerAs: "studentparentsctrl",
                        templateUrl: "Templates/studentParent.html",
                        resolve: {
                            studentTotals: function ($http) {
                                return $http.get("StudentService.asmx/GetStudentTotals")
                                 .then(function (response) {
                                     return response.data;
                                 })
                            }
                        },
                        abstract: true

                    })

                    .state("studentParent.students", {
                        url: "/",
                        views: {
                            "studentData":{
                                templateUrl: "Templates/students.html",
                                controller: "studentscontroller",
                                controllerAs: "studentsctrl",
                                resolve: {
                                    studentslist: function ($http) {
                                        return $http.get("StudentService.asmx/GetAllStudents")
                                         .then(function (response) {
                                             return response.data;
                                         })
                                    }
                                }
                            },
                            "totalData":{
                                templateUrl: "Templates/studentTotal.html",
                                controller: "studentTotalcontroller",
                                controllerAs: "studentsTotalctrl"
                                    }

                            }
                            
                        
                    })

                     .state("studentParent.studentDetails", {
                         url: "/:id",
                         views: {
                             "studentData":{
                             templateUrl: "Templates/studentsDetails.html",
                             controller: "studentsDetailscontroller",
                             controllerAs: "studentsdetailsctrl"
                             }
                             
                         },
                         
                     })



                .state("studentSearch", {
                    url: "/searchname/:name",
                    templateUrl: "Templates/studentsSearch.html",
                    controller: "studentssearchcontroller",
                    controllerAs: "studentssearchctrl"
                })

                     $locationProvider.html5Mode(true);
                 })





    ////create the controllers
                    .controller("studentTotalcontroller", function (studentTotals) {
                        
                        this.total = studentTotals.total;
                    })
                   .controller("studentsParentcontroller", function (studentTotals) {
                       this.males = studentTotals.males;
                       this.females = studentTotals.females;
                       this.total = studentTotals.total;
                   })

                   
                    .controller("homecontroller", function () {
                        this.message = "Home page";
                    })

                    .controller("coursescontroller", function () {
                        this.courses = ["C#", "VB.NET", "JAVA"];
                    })

                   .controller("studentscontroller", function (studentslist, $state) {
                       var vm = this;

                       vm.searchname = function () {
                           $state.go("studentSearch", {name:vm.name});
                       }

                       vm.reloadData = function () {
                           $state.reload();
                       }

                       vm.students = studentslist;
                      // vm.studentTotals = studentTotals;
                   })
                     


                   .controller("studentsDetailscontroller", function ($http, $stateParams) {
                       var vm = this;
                       $http({
                           url: "StudentService.asmx/GetStudents",
                           params: { id: $stateParams.id },
                           method: "get"

                       })

                       .then(function (response) {
                           vm.student = response.data;
                       })
                       //controller for nested 
                   })

                    .controller("studentssearchcontroller", function ($http, $stateParams) {
                        var vm = this;
                     
                            $http({
                                url: "StudentService.asmx/GetStudentsByName",
                                    params: { name:$stateParams.name },
                                method: "get"                            
                               
                                


                            }).then(function (response) {
                                vm.student = response.data;
                            })
                      
                    });

                       


                        //controller for nested 
                  
