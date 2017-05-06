function myFunction(){
    console.log('hello welcome to module export');
}
var myString="bonjour";

//export the function and string
module.exports.myFunction=myFunction;
module.exports.myString=myString;