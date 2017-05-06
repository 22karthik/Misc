var express = require('express');
var router = express.Router();
var mongo=require('mongodb').MongoClient;
var objectId=require('mongodb').ObjectID;
var assert=require('assert');
var url = 'mongodb://localhost:27017/test';
/* GET home page. */
router.get('/', function(req, res, next) {
 /* res.render('index', { title: 'Form validation',sucess:req.session.sucess,errors:req.session.errors});
    req.session.errors=null;*/
 res.render('index');
});

//to retrive the inserted data
router.get('/get-data', function(req, res, next) {
    var resultArr=[];

    mongo.connect(url,function(err,db) {
        assert.equal(null,err);
        var cursor=db.collection('user-data').find();
        cursor.forEach(function(doc,err) {
            assert.equal(null, err);
            resultArr.push(doc);
        },function(){
                 db.close();
                 res.render('index',{items:resultArr});


        });
    });
});

router.post('/insert',function(req, res, next) {
var item={
  title:req.body.title,
    content:req.body.author,
    author:req.body.author

};
//now insert the data
    mongo.connect(url,function(err,db){
       assert.equal(null,err);
       db.collection('user-data').insertOne(item,function(err,result){
           assert.equal(null,err);
           console.log('inserted one row');
           db.close();
       });
    });
});

//for update
router.post('/update',function(req,res,next){
    var item={
        title:req.body.title,
        content:req.body.author,
        author:req.body.author

    };
    var id=req.body.id;
//now insert the data
    mongo.connect(url,function(err,db){
        assert.equal(null,err);
        db.collection('user-data').updateOne({"_id":objectId(id)},{$set:item},function(err,result){
            assert.equal(null,err);
            console.log('updated one row');
            db.close();
        });
    });
});

//delete the data from the database

router.post('/delete',function(req,res,next){

    var id=req.body.id;
//now insert the data
    mongo.connect(url,function(err,db){
        assert.equal(null,err);
        db.collection('user-data').deleteOne({"_id":objectId(id)},function(err,result){
            assert.equal(null,err);
            console.log('deleted one row');
            db.close();
        });
    });
});



/*router.post('/submit',function(req, res, next){
  //check validity
    req.check('email','Invalid email address').isEmail();
    req.check('password','password is invalid').isLength({min:4}).equals(req.body.confirmPassword );

    var errors=req.validationErrors();
    if(errors){
        req.session.errors=errors;
        req.session.sucess=false;
    }else{
        req.session.sucess=true;
    }
    res.redirect('/');
});*/



/*//req using get to test/id,bind the param with the id
router.get('/test/:id', function(req, res, next) {
    res.render('test', {output:req.params.id});
});

router.post('/test/submit', function(req, res, next) {
  var id=req.body.id;
    res.redirect('/test/'+id);
});*/


module.exports = router;

/* helpers like if loop
{{# if condition}}
    condition is true
{{else}}
    condition is not true
{{/if}}

{{# each anyArray as |val key|}}
{{key}}:{{value}}
{{/each}}*/