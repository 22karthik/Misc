var express = require('express');
var router = express.Router();
var mongoose=require('mongoose');
var assert=require('assert');
mongoose.connect('localhost:27017/test');
var Schema=mongoose.Schema;

var userDataSchema=new Schema({
    title:{type:String,required:true},
    content:String,
    author:String
},{collection:'user-data'});

var userData=mongoose.model('userData',userDataSchema)
/* GET home page. */
router.get('/', function(req, res, next) {
 /* res.render('index', { title: 'Form validation',sucess:req.session.sucess,errors:req.session.errors});
    req.session.errors=null;*/
 res.render('index');
});

//to retrive the inserted data
router.get('/get-data', function(req, res, next) {
    userData.find()
        .then(function(doc){
          res.render('index',{items:doc});
        });

});

router.post('/insert',function(req, res, next) {
var item={
  title:req.body.title,
    content:req.body.content,
    author:req.body.author
};
var data=new userData(item);
data.save();
res.redirect('/');
});

//for update
router.post('/update',function(req,res,next){
    var item={
        title:req.body.title,
        content:req.body.content,
        author:req.body.author
    };
    var id=req.body.id;
    userData.findById(id,function(err,doc){
        if(err){
            console.log('sorry cannot update');
        }
        else{
            doc.title=req.body.title;
            doc.content=req.body.content;
            doc.author=req.body.author;
            doc.save();
        }
    });
});

//delete the data from the database

router.post('/delete',function(req,res,next){
    var id=req.body.id;
    userData.findByIdAndRemove(id).exec();
    res.redirect('/');
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