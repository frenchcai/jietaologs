<?php
//this to get weixingonzhonhao openid
$appid2 = "wx4711d6a8aee6654a"; 
$appid='wx0f5ef167a14f12f2';

$secret='6017a74588a107773a284a7557753da1';
$secret2 = "ad867405ab274def9c4af4c559a97b18"; 
$code = $_GET["code"]; 
$get_token_url = 'https://api.weixin.qq.com/sns/oauth2/access_token?appid='.$appid.'&secret='.$secret.'&code='.$code.'&grant_type=authorization_code';
$ch = curl_init();
curl_setopt($ch,CURLOPT_URL,$get_token_url); 
curl_setopt($ch,CURLOPT_HEADER,0); 
curl_setopt($ch,CURLOPT_SSL_VERIFYPEER,FALSH); 
curl_setopt($ch,CURLOPT_SSL_VERIFYHOST,FALSH); 
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1 ); 
//curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 10); 
$res = curl_exec($ch); 

if(curl_errno($ch)){

echo 'error'.curl_error($ch);

}
curl_close($ch); 
$json_obj = json_decode($res,true); 
//根据openid和access_token查询用户信息 
$access_token = $json_obj['access_token']; 
$openid=$json_obj['openid']; 



//getuninid

$get_unionid_url='https://api.weixin.qq.com/cgi-bin/user/info?access_token='.$access_token.'&openid='.$openid.'&lang=zh_CN';


$ch2 = curl_init();
curl_setopt($ch2,CURLOPT_URL,$get_unionid_url); 
curl_setopt($ch2,CURLOPT_SSL_VERIFYPEER,FALSH); 
curl_setopt($ch2,CURLOPT_SSL_VERIFYHOST,FALSH); 
curl_setopt($ch2, CURLOPT_RETURNTRANSFER, 1 ); 

$data = curl_exec($ch2); 

if(curl_errno($ch2)){

echo 'error'.curl_error($ch2);

}

curl_close($ch2); 
$unioniddata = json_decode($data,true); 

$unionid =$unioniddata['unionid']; 














/*$get_user_info_url = 'https://api.weixin.qq.com/sns/userinfo?access_token='.$access_token.'&openid='.$openid.'&lang=zh_CN'; 
 
$ch = curl_init(); 
curl_setopt($ch,CURLOPT_URL,$get_user_info_url); 
curl_setopt($ch,CURLOPT_HEADER,0); 
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1 ); 
curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 10); 
$res = curl_exec($ch); 
curl_close($ch); 
 
//解析json 
$user_obj = json_decode($res,true); 
$_SESSION['user'] = $user_obj; 
print_r($user_obj); 
*/
echo"weixinvopenid  ".$openid;

echo$code;

echo"3333".$data;
echo$unioniddata['openid'];
?>