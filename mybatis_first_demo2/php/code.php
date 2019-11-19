<?php

class code{

public function getopenid(){

$js_code =$_GET["code"];
 
 $getUrl ="https://api.weixin.qq.com/sns/jscode2session?appid=wx047847917123655d&secret=441e087880180d700f0207d354bcd5f5&js_code=".$js_code."&grant_type=authorization_code";




  $ch = curl_init();
  curl_setopt($ch, CURLOPT_URL, $getUrl);
  curl_setopt($ch, CURLOPT_HEADER, 0);
  curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
  curl_setopt($ch, CURL_SSLVERSION_SSL, 2);
  curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
  curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, FALSE);
  $data = curl_exec($ch);
  $response = json_decode($data);

echo $data;



   
		}
 



	}

$str=new code;
$str->getopenid();



?>
  

 



 
    





	






