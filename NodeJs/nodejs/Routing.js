var http=require('http');
var app1=require('./app1');

http.createServer(app1.handleRequest).listen(3000);