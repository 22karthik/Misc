var express = require('express');
var router = express.Router();

var assert=require('assert');
var db=require('monk')('localhost:27017/test');
var userData=db.get('user-data');
/* GET home page. */
router.get('/', function(req, res, next) {
 /* res.render('index', { title: 'Form validation',sucess:req.session.sucess,errors:req.session.errors});
    req.session.errors=null;*/
 res.render('index');
});

//to retrive the inserted data
router.get('/get-data', function(req, res, next) {
var data=userData.find({},function(err, docs){
    if (err) throw err;
  res.render('index',{items:docs});
});
});

router.post('/insert',function(req, res, next) {
var item={
  title:req.body.title,
    content:req.body.author,
    author:req.body.author
};
userData.insert(item);
res.redirect('/');
});

//for update
router.post('/update',function(req,res,next){
    var item={
        title:req.body.title,
        content:req.body.author,
        author:req.body.author
    };
    var id=req.body.id;
    //userData.update({"_id":db.id(id)},item);
    userData.updateById(id,item);

});

//delete the data from the database

router.post('/delete',function(req,res,next){
    var id=req.body.id;
    userData.remove({"_id":db.id(id)});
    userData.removeById(id);
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