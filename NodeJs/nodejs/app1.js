/**
 * Created by Jeeva Karthik on 5/3/2017.
 */
var http=require('http');
var fs=require('fs');
var url=require('url');

function renderHtml(path,response){
    fs.readFile(path,null,function(error,data){
      if(error){
          response.writeHead(404);
          response.write('file not found');
      }
      else{
          response.write(data);
          response.end();
      }
    });
}
module.exports={
    handleRequest:function(request,response){
        response.writeHead(200,{'Content-Type':'text/html'});
        var path=url.parse(request.url).pathname;
        switch(path){
            case '/':
                renderHtml('./index.html',response);
                break;
            case '/login':
                renderHtml('./login.html',response);
                break;
            default:
                response.write('invalid url supplied');
                response.end();
        }

    }
}