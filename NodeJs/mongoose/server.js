
var http=require('http');
var module1=require('./module');
var module2=require('./module2');
function onRequest(request,response){
response.writeHead(200,{'Content-Type':'text/plain'});
response.write('hello welcome to node js by kar'+"\n");
//print the msg and function from the module
response.write(module1.myString);
    response.write("\n");
module1.myFunction();
    response.write("\n");
//print the msg and function from the module2
response.write(module2.myVariable);
    response.write("\n");
    module2.myFunction();
    response.end();
}
http.createServer(onRequest).listen(8000);