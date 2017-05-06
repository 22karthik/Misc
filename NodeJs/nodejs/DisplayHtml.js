var http=require('http');
//search file system to find the file
var fs=require('fs');
function displayFunc(request,response){
response.writeHead(200,{'Content-Type':'text/html'});
fs.readFile('./index.html',null,function(error,data){
    if(error){
        response.writeHead(404);
        response.write('file not found');
    }
    else{
        response.write(data);
    }
response.end();
});

}
http.createServer(displayFunc).listen(8000);