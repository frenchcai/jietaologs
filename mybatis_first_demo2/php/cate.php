<?php

class code{

public function getopenid(){



$js_code =$_GET["code"];
 
 $getUrl ="https://api.weixin.qq.com/sns/jscode2session?appid=wx11c73d78354dab21&secret=61e0ef9633e165032b171aaab4a2b7e1&js_code=".$js_code."&grant_type=authorization_code";




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