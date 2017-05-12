/// <reference path="script.js" />
app.factory('stringfunction', function () {
    return {
        processString: function (input) {

            if (!input) {
                return input;
            }
            var output = "";
            for (var i = 0; i < input.length; i++) {
                if (i > 0 && input[i] == input[i].toUpperCase()) {
                    output = output + " ";
                }
               
                    output = output + input[i];
                
            }//for
            return output;
        }
    };
});