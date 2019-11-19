<?php
var https = require('https');
var request = require('request');
var Promise = require('promise');  //promise用于流程控制，即保证先获取到access_token,在调用创建自定义菜单接口
 var appId='wx0f5ef167a14f12f2';
 var appSecret='6017a74588a107773a284a7557753da1';
//var appId = 'wx482687a49f5f45b3'; //记得换成你自己测试号的信息
//var appSecret = 'aca22799b4549eaeaaacf6b652605c1a';

function getToKen(appId, appSecret) {        

    return new Promise(function (resolve, reject) {

        var url = 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=' + appId + '&secret=' + appSecret;
        request({
            uri : url
        }, function (err, res, data) {
            var result = JSON.parse(data);
            console.log("result.access_token=", result);

            resolve(result.access_token);  //把获取的access_token返回去
        });

    });

}

   //menu为创建自定义菜单的具体内容，也就是post到微信服务器的body
var menu = {          
    "button" : [{
            "name" : "我的账号",
            "sub_button" : [{
                    "type" : "click",
                    "name" : "test1",
                    "key" : "V1001_MY_ACCOUNT"
                }, {
                    "type" : "click",
                    "name" : "test2",
                    "key" : "V1002_BID_PROJECTS"
                }, {
                    "type" : "click",
                    "name" : "test3",
                    "key" : "V1003_RETURN_PLAN"
                }, {
                    "type" : "click",
                    "name" : "test4",
                    "key" : "V1004_TRANS_DETAIL"
                }, {
                    "type" : "click",
                    "name" : "test5",
                    "key" : "V1005_REGISTER_BIND"
                }
            ]
        }, {
            "type" : "view",
            "name" : "百度",
            "url" : "http://www.baidu.com/"
        }, {

            "type" : "view",
            "name" : "个人博客",
            "url" : "http://blog.csdn.net/yezhenxu1992/"

        }
    ]
};

var post_str = new Buffer(JSON.stringify(menu));   //先将menu转成JSON数据格式，在赋给post_srt数组

//console.log("JSON.stringify(menu)=", JSON.stringify(menu));
//console.log("post_str.toString()=", post_str.toString());
//console.log("post_str.length", post_str.length);


//调用getToken函数，getToken函数执行完，接下来才执行then函数中的匿名函数,其中，access_token为返回来的参数。
//对promise控制流程的原理操作不熟悉的家伙，请移步度娘，这个技术特别重要！尤其是在基于事件、异步IO的nodejs中，很多时候， 代码的执行顺序并非顺序执行，所以很有必要控制代码的流程。

getToKen(appId, appSecret).then(function (access_token)) {  
    var post_options = {
        host : 'api.weixin.qq.com',
        port : '443',
        path : '/cgi-bin/menu/create?access_token=' + access_token,
        method : 'POST',
        headers : {
            'Content-Type' : 'application/x-www-form-urlencoded',
            'Content-Length' : post_str.length
        }
    };

    var post_req = https.request(post_options, function (response) {
            var responseText = [];
            var size = 0;
            response.setEncoding('utf8');
            response.on('data', function (data) {
                responseText.push(data);
                size += data.length;
            });
            response.on('end', function () {
                console.log("responseText=", responseText);
            });
        });

    post_req.write(post_str);   // 把menu数据post到微信服务器，剩下的微信自动帮我们搞定了。
    post_req.end();
});

?>