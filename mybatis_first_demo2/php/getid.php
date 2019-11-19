<?php



class getid{

	public function https_gettoken(){
	$url='https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx4711d6a8aee6654a&secret=ad867405ab274def9c4af4c559a97b18';
	$curl=curl_init();
	curl_setopt($curl,CURLOPT_URL,$url);
	curl_setopt($curl,CURLOPT_SSL_VERIFYPEER,FALSE);
	curl_setopt($curl,CURLOPT_SSL_VERIFYHOST,FALSE);
	curl_setopt($curl,CURLOPT_RETURNTRANSFER,1);
	$data=curl_exec($curl);
	if(curl_errno($curl)){
	return 'error'.curl_error($curl);}
	curl_close($curl);
	echo $data;	


	}






}




$test=new getid();
$test->https_gettoken();




?>