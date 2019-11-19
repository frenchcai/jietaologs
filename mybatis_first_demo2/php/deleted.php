<?php

class deleted{

public function delete(){
$ok=substr($_GET["fileID"],strpos($_GET['fileID'],"/",25)+1);
$ok2=substr($_GET['fileID2'],strpos($_GET['fileID2'],"/",25)+1);


$ok=iconv("utf-8","gb2312",$ok);
$ok2=iconv("utf-8","gb2312",$ok2);



$filepath="C:\\HwsHostMaster\\wwwroot\\www.lingshiji_22fqiz\\web\\".$ok;



$filepath2="C:\\HwsHostMaster\\wwwroot\\www.lingshiji_22fqiz\\web\\".$ok2;



if(file_exists($filepath2)){
	echo$ok;
	echo$ok2;
	echo$filepath;
	echo$filepath2;


	unlink($filepath);
	unlink($filepath2);
	
	}else{	


echo"123";
	echo$filepath;

		unlink($filepath);




	}

}

}
 
$test=new deleted;
$test->delete();








?>