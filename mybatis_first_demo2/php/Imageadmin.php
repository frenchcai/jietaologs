<?php
class Imageadmin
{
	
 
  public function imageupload()
	
    { 

 date_default_timezone_set("Asia/Shanghai"); //设置时区
$code = $_FILES['file'];//获取小程序传来的图片
if(is_uploaded_file($_FILES['file']['tmp_name'])) {  
    //把文件转存到你希望的目录（不要使用copy函数）  
    $uploaded_file=$_FILES['file']['tmp_name'];  
    $username =iconv("utf-8","gb2312",$_POST["user"]);
	
	$cloud=iconv("utf-8","gb2312",$_POST["cloud"]);

    //我们给每个用户动态的创建一个文件夹  
    $user_path=$username;  
    //判断该用户文件夹是否已经有这个文件夹  
    if(!file_exists($user_path)) {  
        mkdir($user_path);  
	
    }  
	$user_path =iconv("gb2312","utf-8",$user_path);
	$cloud=iconv("gb2312","utf-8",$cloud);
    //$move_to_file=$user_path."/".$_FILES['file']['name'];  
    $file_true_name=$_FILES['file']['name'];  
    $move_to_file=$user_path."/".$cloud;

//.substr($file_true_name,strrpos($file_true_name,"."));//strrops($file_true,".")查找“.”在字符串中最后一次出现的位置  
    //echo "$uploaded_file   $move_to_file";  
    if(move_uploaded_file($uploaded_file,iconv("utf-8","gb2312",$move_to_file))) {  
        echo $_FILES['file']['name']."--上传成功".date("Y-m-d H:i:sa"); 
 
    } else {  
        echo "上传失败".date("Y-m-d H:i:sa"); 
 
    }  
} else {  
    echo "上传失败".date("Y-m-d H:i:sa");  
}  
 
 


 


    }
    public function upload()
    {
        //名字获取
        $wxid=$_POST["wxid"];
        //时间获取
        $diaryTime=$_POST["diaryTime"];
        //拼接存储名字
        $diaryTime=substr($diaryTime,0,10).substr($diaryTime,11,2).substr($diaryTime,14,2).substr($diaryTime,17);
        //得到存储名字
        $file_name=$wxid.'_'.$diaryTime.'.png';
        //存储路径
        $path='./picture/'.$file_name;
        //保存
        move_uploaded_file($_FILES['picture']['tmp_name'], $path);

    }
	
	 public function onnn(){
		echo "Hello World!";
	

	}
}
	$mytest=new Imageadmin;
	$mytest->imageupload();
	$mytest->onnn();
?>