/// <reference path="angular.min.js" />

var app = angular.module("mymodule", [])
        .controller("country", function () {
            this.name = "India";

        })

      .controller("state", function () {
          this.name = "Karnataka";

      })

    .controller("city", function () {

        this.name = "Bangalore";

    });
