<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<title>开启你的日志之旅</title>
	<style type="text/css">
	body{
		margin:0;
		padding:0;
		background-color: #edf3ff;

	}
	.body{
	margin:0;
	padding:0;
    margin: 0;
    padding: 0;
    font-size: 14px;
    font-family: Helvetica Neue,Helvetica,PingFang SC,Hiragino Sans GB,Microsoft YaHei,微软雅黑,Arial,sans-serif;
	}
	#black{
		background-color: black;
		height: 0;
	}
	.login{
		background-color: white;
	}
	.main{
		padding-top:30px;
	}
	.left{
		height:90%;
		width:40%;
		float: left;
		background-color: green;
	}
	.right{
		margin-left:8%;
		height: 90%;
		width: 50%;
		float: left;
		background-color: skyblue;
	}
	.search{
		height: 10%;
		background-color: yellow;
		margin-left: 40px;
	}
	.items{

		height: 10%;
		background-color: yellow;
	}
	/*拯救高度坍塌--文章文本*/
	.caption:after{
	display:block;
	visibility:hidden;
	clear:both;
	height:0;
	content:'.'
	
	
	}
	
	.caption{
	zoom:1;
	}
	/*拯救高度坍塌--图片*/
.box:after{
	display:block;
	visibility:hidden;
	clear:both;
	height:0;
	content:'.'
	
	
	}
.box{
	zoom:1;
	}


</style>


</head>
<body>

<div class="modal fade" id="loginModal" >
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
   
        <!-- 模态框头部 -->
        <div class="modal-header">
          <h4 class="modal-title">捷淘，开启你的日记之旅</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
   
        <!-- 模态框主体 -->
        <div class="modal-body">
        		<div class="form-group">
					<label for="firstname" class="control-label">账号</label>
						
							<input type="text" class="form-control" id="username" 
				  				 placeholder="请输入账号" />
						
				</div>
				
				  <div class="form-group">
					<label for="lastname" class="control-label">密码</label>
						
							<input type="password" class="form-control" id="password" 
				 				  placeholder="密码" />
						
					</div>
        		
        		  
        </div>
   
        <!-- 模态框底部 -->
        <div class="modal-footer">
          <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button  class="btn btn-primary" onclick="checkLanding()" data-loading-text="登录中...">登录</button>
					<a><button type="" class="btn btn-link" onclick="addUser()">注册</button></a>
				</div>
				
			</div>
        </div>
   
      </div>
    </div>
  </div>
  


















	<!-- <div class="row" style="position: fixed;z-index: 99;top:20%;right:40%;" id="check"> -->
<!-- 	<div class="col-lg-6 col-xs-6 col-md-6" style="background-color: #edf3ff;position: fixed;z-index:2;top:20%;left:30%;display:none;" id="check2">

		<div class="form-horizontal" role="form">

			<div class="form-group">
					<label for="firstname" class="col-lg-2 col-xs-2 col-md-2 control-label">登录</label>
						
				</div>


				<div class="form-group">
					<label for="firstname" class="col-lg-2 col-xs-2 col-md-2 control-label">账号</label>
						<div class="col-lg-10 col-xs-10 col-md-10">
							<input type="text" class="form-control" id="username" 
				  				 placeholder="请输入账号">
						</div>
				</div>
				
				<div class="form-group">
					<label for="lastname" class="col-lg-2 col-xs-2 col-md-2 control-label">密码</label>
						<div class="col-lg-10 col-xs-10 col-md-10">
							<input type="password" class="form-control" id="password" 
				 				  placeholder="密码">
						</div>
				</div>
				
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label>
							<input type="checkbox" id="remenber"> 请记住我
						</label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button  class="btn btn-primary" onclick="checkLanding()" data-loading-text="登录中...">登录</button>
					<a><button type="" class="btn btn-link" onclick="addUser()">注册</button></a>
					<button  class="btn btn-warning" onclick="cancelLanding()">取消登录</button>
				</div>
				
				
			</div>
		

		</div>
	</div> -->
	<!-- </div> -->


<!-- <div class="container-fluid"> -->


<!-- logo -->

			<div class=row>

				<div class="col logo">
					<h3>
						<a href="./jietao.jsp">&nbsp&nbsp 捷淘——记录生活美好</a>
					</h3>
				</div>
	
			</div>
	
		
		
		
		
		
		<!--头部开始-->
			<div class="row">
				<div class="col-lg-12 col-xs-12 col-md-12 ">
						

		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">首页</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">关于我们</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">功能选择 <span class="caret"></span></a>
          <ul class="dropdown-menu">
           <li onclick="toJsp('addText')"><a >发布文章</a></li>
            <li onclick="toJsp('manageText')"><a >管理文章</a></li>
           <!--   <li onclick="toJsp(findText.jsp)"><a >查找文章</a></li>-->
            <li role="separator" class="divider"></li>
           <!-- <li onclick="toJsp(readText.jsp)"><a >浏览文章</a></li>-->
             <li onclick="toJsp('toMySeft')"><a >我的收藏</a></li>
              <li onclick="toLogin()"><a >切换账号</a></li>
          </ul>
        </li>
      </ul>
      
      <div class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" id="searchfactor" class="form-control" placeholder="Search">
        </div>
        <button  onclick="SearchText()"  class="btn btn-default">查找</button>
        
        <div class="form-group">
		<label for="name">查找条件</label>
		<select class="form-control" id="searchfactorselect">
			<option value=1>文章内容</option>
			<option value=2>文章作者</option>
			<option value=3>文章标题</option>
			<option value=4>创作时间</option>
		</select>
        </div>
      </div>
      <ul class="nav navbar-nav navbar-right">
      	 <li><input id=myID type=hidden /><a onclick="toMySeft()" id=hasstate>用户：<text id='myname'></text></a></li>
       		<li><a id=nostate >状态：未登录</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">功能选择 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li onclick="toJsp('addText')"><a >发布文章</a></li>
            <li onclick="toJsp('manageText')"><a>管理文章</a></li>
       <!--      <li onclick="toJsp('findText')"><a >查找文章</a></li>--> 
            <li role="separator" class="divider"></li>
          <!--   <li onclick="toJsp('readText')"><a  >浏览文章</a></li> -->
             <li onclick="toJsp('toMySeft')"><a >我的收藏</a></li>
             <li onclick="toLogin()"><a >切换账号</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>



						</div>


				
				
				

				</div>

			</div>
			<!--the head over -->
			
			<!--black-->
			<div class="row">

				<div class="col-xs-12 col-md-12 col-lg-12"  style="background-color:black;margin-top: 0;"><p>&nbsp</p></div>



			</div>
	
			<!--black over-->

			<!--login -->
			<div class="row">

				<div class="col-xs-12 col-md-12 col-lg-12 " style="background-color: white;">
					
							<!-- 信息警告消息的上下文按钮 -->
					<button type="button" class="btn btn-info" style="float: right;" id='login' data-toggle="modal" data-target="#loginModal">登陆</button>
					<button type="button" class="btn btn-info" style="float: right;" onclick="addUser()" id="adduser">注册</button>






				</div>

			</div>
			<!--login over-->

			<!--blue-->
			<div class="row">

				<div class="col-xs-12 col-md-12 col-lg-12"><p>
				
				
				
				</p></div>
			</div>
			<!--blue over-->
			

			

			<!--分页标签  -->
					<div class="col-xs-12 col-md-12 col-lg-12" style="background-color:white;display:none">
					<ul class="pagination" style="display:none" >
					<li>共有<text id='count'></text>条记录</li>
					<li>当前页<text id='nowpage'></text></li>
					<li>每页<input id=num value='5'></input>条记录</li>
					<li><button onclick="query(1,10)">查询</button></li>
					<li><a href="#" id='prepage' onclick=prepage() hidden='true'>&laquo;</a></li>
					<li><a href="#" id='nextpage' onclick=nextpage() hidden='true'>&raquo;</a></li>
					</ul >
				
						<ul id='page' class="pagination">
						<li></li>
						
						</ul>
					</div>
		





			
			<div class="row">
				<!--main left-->
				<div class="col-xs-12 col-md-2 col-lg-2">
						<ul class="nav nav-pills nav-stacked" style="position: fixed;">
						<li class="active"><a href="">Home</a ></li>
						<li onclick="toJsp('addText')"><a>发布文章</a></li>
            			<li onclick="toJsp('manageText')"><a>管理文章</a></li>
            		<!--  	<li onclick="toJsp('findText')"><a>查找文章</a></li>-->
           				 <li role="separator" class="divider"></li>
           			<!-- 	 <li onclick="toJsp('readText')"><a >浏览文章</a></li> -->
             			<li onclick="toJsp('toMySeft')"><a>我的收藏</a></li>
             			<li onclick="toLogin()"><a >切换账号</a></li>
						</ul>
				</div>
				
				
				
			<div class="pager"  style="position: fixed;z-index:5;bottom:10%;right:3%;">
					<li class="next" onclick='loadMore()'><a>加载更多文章 &rarr;</a></li>
			</div>
					
			
				
					
					
				<!--mian left over-->
				<!--main rigth 我这里设置每一次加载五篇文章，可以通过设置id=num的input值修改，默认是隐藏的-->
				<div class="col-xs-12 col-md-10 col-lg-10" style="background-color: white;" id="shareText" >

				</div>
				
				<div class="col-xs-12 col-md-10 col-lg-10" style="background-color: white;display:none;" id="shareText2" >

				</div>
				
				
				
				
				
<script type="text/javascript"> 

function query(begin, num){
	//alert(begin);
	num=$("#num").val();
	//alert(num);
	allNum=num;
	$.ajax({
		  url: "/mybatis_first_demo2/queryAllTextServlet", 
	      type: 'POST',  
	      data: "begin="+begin+"&num="+num,  
	      dataType: 'json',  
	      success:function(json){
	    //	console.log(json);
	    		var count=json[0].count
	    		 var picpath1='';
	    		var picpath2='';
	    	//	 $("#shareText").empty();
	    	//如果只有加载更多这个按钮，无需把之前的记录情况，考虑到用户是刷屏浏览查看文章，所以，我们直接在后面加元素即可
	    		//	$("#info").append("<tr><th>姓名</th><th>性别</th><th>密码</th><th>学院</th><th>班级</th><th>电话</th></tr>");
	    	  for(var i=1;i<json.length;i++){
	    	//	 console.log(json);
	    		 picpath1=json[i].picpath1;
	    		 picpath2=json[i].picpath2;
	    	//	  alert(picpath2.length);
	    	if(picpath1.length!=0&&picpath2.length!=0){
	    		$("#shareText").append("<div id=textID"+i+" class='col-sm-12 col-md-6 clo-lg-6'><input type=hidden value="+json[i].userID+" />"+"<input type=hidden value="+json[i].textID+" />"+"<div class=thumbnail><div class='box box-element'><img src=./images/"+json[i].username+"/"+picpath1+"	/><img src=./images/"+json[i].username+"/"+picpath2+" /></div>"+"<div class='caption'><h4>"+json[i].title+"</h4><h4>"+json[i].username+"</h4><p>"+json[i].text+"</p><p>"+"<input id=unionID"+i+" type=hidden value="+json[i].userID+json[i].textID+" />"+"<a role=button onclick=isLike("+i+") id=blike"+i+">点赞"+json[i].num_like+"</a><a role=button onclick=addToMine("+i+") id=btome"+i+">收藏</a><a role=button onclick=sendMessage("+i+") data-toggle='modal' data-target='#myModal'>留言"+json[i].num_message+"</a></p></div></div></div>" );
	    		$("#shareText img").css({"width":"48%","float":"left","margin-left":"1%"});
	    		
	    		//children("p.1").css({"color":"red","border":"2px solid red"});
	    	}else if(picpath2.length==0){
	    	//	alert(json[i].textID);
	    		$("#shareText").append("<div id=textID"+i+"class='col-sm-12 col-md-6 clo-lg-6'><input type=hidden value="+json[i].userID+" />"+"<input type=hidden value="+json[i].textID+" / >"+"<div class=thumbnail><div class='box box-element'><img src=./images/"+json[i].username+"/"+picpath1+"	/></div>"+"<div class='caption'><h4>"+json[i].title+"</h4><h4>"+json[i].username+"</h4><p>"+json[i].text+"</p><p>"+"<input id=unionID"+i+" type=hidden value="+json[i].userID+json[i].textID+" />"+"<a role=button onclick=isLike("+i+") id=blike"+i+">点赞</a><a role=button onclick=addToMine("+i+") id=btome"+i+">收藏</a><a role=button onclick=sendMessage("+i+") data-toggle='modal' data-target='#myModal'>留言"+json[i].num_message+"</a></p></div></div></div>" );
	    	//	$("#shareText img").css("margin-bottom","5%");
	    		$("img").addClass("img-fluid");
	    		
	    		
	    		
	    		
	    	}else{
	    	//	alert("第一种图片为空");
	    		$("#shareText").append("<div id=textID"+i+" class='col-sm-12 col-md-6 clo-lg-6'><input type=hidden value="+json[i].userID+" />"+"<input type=hidden value="+json[i].textID+" />"+"<div class=thumbnail><div class='box box-element'><img src=./images/"+json[i].username+"/"+picpath2+"	/></div>"+"<div class='caption'><h4>"+json[i].title+"</h4><h4>"+json[i].username+"</h4><p>"+json[i].text+"</p><p>"+"<input id=unionID"+i+" type=hidden value="+json[i].userID+json[i].textID+" />"+"<a role=button onclick=isLike("+i+") id=blike"+i+">点赞</a><a role=button onclick=addToMine("+i+") id=btome"+i+">收藏</a><a role=button onclick=sendMessage("+i+") data-toggle='modal' data-target='#myModal'>留言"+json[i].num_message+"</a></p></div></div></div>" );
	    	//	$("#shareText img").css("margin-bottom","5%");
	    		
	    	}
	    		  
			//$("#shareText>div").addClass("col-sm-12 col-md-6 clo-lg-6");
			$("#shareText a").addClass("btn btn-default");
			//是按钮有浮动，消除高度塌陷
			$("#shareText a").css("float","right");
			//$(".caption").addClass("col-sm-12 col-md-12 clo-lg-12'");
			//文章的标题跑到第二章图片的上面，是因为图片的浮动造成的，我们可以消除浮动，可以解决问题
		//	$(".caption").css("overflow","hidden");
		//	$(".caption").css("clear","right");
			
			
			
			
		
			
			
			

	    
	    	  }
	    	  
	    	  
	    	  
	    	  
	    	  
	    	 	
	    		if(typeof $.cookie('user') == "undefined"){
	    			
	    			
	  			
	    		}else{
	    			var user1=$.cookie('user');
	    		//	console.log($.cookie('user'));
	    			var user=JSON.parse($.cookie('user'));
	    			$("#myname").text(user.user.username);
	  			$("#myID").val(user.user.userID);
	  		
	  			$("#nostate").hide();
	  			$("#hasstate").show();
	  			$("#adduser").hide();
	  			$("#login").hide();
	    			
	  			
	  		//只有登录的有cookie才遍历likejson	
	  			if(typeof $.cookie('likejson') == "undefined"){
	  			//	alert("json清除");
	  	
	  				
	  				
	  				}else{	
	  					var likejson=$.cookie('likejson');
	  					likejson=JSON.parse(likejson);
	  				//	alert(likejson);
	  					for(var i=0;i<likejson.length;i++){
	  					//	console.log(likejson);
	  					//	var unionID=likejson[i].unionID;
	  						if(user.user.username==likejson[i].username){
	  						//	console.log(likejson[i].username);
	  						//	console.log(likejson[i].unionID);
	  							$("input[value="+likejson[i].unionID+"]").next().css("background-color","skyblue");
	  							//alert($("input[value="+likejson[i].unionID+"]").val());
	  						}
	  						
	  		
	  		
	  				}
	  			}
	  			
	    		}
	  			
	  			
	  			
	  			
	  			
	    			
	    	
	    	  
	    	  
	    	  
	    	  
	    	  
	    	$("#count").html(count);

	    	$("#nowpage").html(begin);
	    	//显示当前页数，因为begin默认为一，所以，第一次查询当前页都是一
	    	

	    	console.log(

	    	);
	  //设置总页数。当总数除以每页的记录数的时候，如果余数不为零，说明最后一页的记录数的条数是余数，我们要增加一页来放置剩下来的记录
	 //     这种情况包含两种情况，当总记录数小于每页的记录的时候，不能被整除，余数为总记录数。这个时候页数为一页，不能为零
	//  第二张情况是总记录数大于每页记录，但不能被整除，一样需要增加一页
	    	var num2=Number(num);
	    	var count2=Number(count);
	    	Allcount=count2;
	    	var page=0;
	    	if(count2%num2!==0){
	    		
	    		page=(count2/num2)+1;
	    		//console.log(count2/num2);

	    	
	    	
	    		
	    		
	    		
	    		
	    	}else{
	    		page=count2/num2;
	    	
	    	}
	    	
	    	
	    	

	    	//当下一页的按钮隐蔽之后，点击页数的查找记录时候，如果不是小于最后一页，激活按钮
	    	numbegin=Number(begin);
	    	if(numbegin<parseInt(Number(page))){
	    		$("#nextpage").show();
	    	}else{
	    		$("#nextpage").hide();
	    	}
	    	
	    	
	    	//激活上一页——如果当前页不是第一页，则显示按钮，否则显示按钮
	    	if(numbegin!=1){
	    		$("#prepage").show();
	    	}else{
	    		$("#prepage").hide();
	    	}
	    	
	    	
	    	

	    //	console.log(page);
	    	
	    	ALLPAGE=page;
	    		$("#page").empty();
	    		//当每一页的记录数目发生变化的时候，我们可以调整页码，在调整之前，要对之前的页数进行清除
	    	
	    		//显示当前页数
	    	for(var j=1;j<=page;j++){
	    		$("#page").append("<li><a onclick=topage("+j+")>第"+j+"页</a></li>");
	    	}
	    	  
	      },
	 error:function(){
	    	  console.log("error");
	    	  alert("我是有底线的啦");
	      }
	      
	})


	};
			
query('1','10');		
			
</script>	
				
				
				
				<!--mian right over-->
					
				
				
				
				</div>



		
			
				


			<!--mian over-->

			<!--bottom-->
				<div class="row">
				<div class="col-xs-12 col-md-12 col-lg-12"  style="background-color: black;">

			
						<p style="color:white;text-align: center;">&copyjietao</p>
					
					</div>



				</div>

		
			
		
		
		
	




<button onclick="cleanLogin()">清除登录缓存</button><button onclick="cleanLike()">清除点赞</button>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					留言信息
				</h4>
			</div>
			<div class="modal-body">
				输入留言<input type=text id='message' placeholer="此处输入留言" />
				<input type=hidden id=mtextID value='1' />
				<input type=hidden id=muserID  value='2' />
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="sendNow()">
					提交留言
				</button>
				
				</div>
				
				
				
			
		</div>
		<div class="modal-content" id="allmessage">
		
		</div>
		
		
		
		
		
		
		<!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


</body>

<script src="js/jquery.cookie.js"></script>
<script type="text/javascript">
//登录功能
function checkLanding(){
	//$(this).button('loading').delay(1000);
	var username=$("#username").val();
	var password=$("#password").val();
	console.log(username+password);
	if(username.length==0){
		alert("用户名不能为空");
		
	}else if(password.length==0){
		alert("密码不能为空");
	}else if(password.length!=0&&username.length!=0){
		$.ajax({
			url:"/mybatis_first_demo2/queryLanding",
			type:"POST",
			data:"username="+username+"&password="+password,
			dataType:"json",
			success:function(json){
				//console.log(json.user);
				var user=JSON.stringify(json);
			$.cookie('user',user, {expires: 7, path: '/' });
			//console.log($.cookie('user'));
			//alert(json.user.userID);
				if(typeof json.user.userID !="undefined"){
					$("#myname").text(json.user.username);
					$("#myID").val(json.user.userID);
					$("#nostate").hide();
					$("#hasstate").show();
					$("#login").hide();
					$("#adduser").hide();
					
	
					window.location.reload();
					
				}else{
					alert("密码或用户名错误");
					$("#login").click();
					
				}
			},
			error:function(){
				alert("密码或用户名错误");
				$("#login").click();
			}
			
			
		})
		
		
	}
	
	
	
	
	
};
//取消登录
		function cancelLanding(){
			//$("#check").hide();
		};
		
		//跳转到注册页面
		function addUser(){
			 location.href = "/mybatis_first_demo2/addUser.jsp" ;          //location.href实现客户端页面的跳转  
		}
//点击登录
	function toLogin(){
			$("#login").click();
			
		}



//点赞或者取消点赞 
function isLike(textID){
	
	if($("#myID").val().length!=0){
	var user=JSON.parse($.cookie('user')).user;
		
		
	var userID=$("#textID"+textID).children().eq(0).val();
	var textID2=$("#textID"+textID).children().eq(1).val();
	var color=$("#unionID"+textID).next().css("background-color");
	console.log(color);
	
	var unionID=$("#unionID"+textID).val();
	var likejson="";
	if(typeof $.cookie("likejson") !== "undefined"){
		likejson=JSON.parse($.cookie("likejson"));
	}else{
		likejson=[];
	}
	
	
	
	if(color=="rgb(135, 206, 235)"){
		$.ajax({
			url:"/mybatis_first_demo2/notLikeServlet",
			type:"POST",
			data:"userID="+userID+"&textID="+textID2,
			dataType:'json',
			success:function(json){
				for(var i=0;i<likejson.length;i++){
					// console.log(likejson[i].unionID);
					if(likejson[i].unionID==unionID&&likejson[i].username==user.username){
						likejson.splice(i,1);
					}
					
				}
				$("#unionID"+textID).next().css("background-color","white");
				alert("取消成功");
				var a=JSON.stringify(likejson);
				$.cookie("likejson",a,{expires:365,path: '/'});
				//console.log(a);	

	
			},
			error:function(){
				alert("取消失败");
			}
			})
		
		
	}else{
		
	$.ajax({
		url:"/mybatis_first_demo2/isLikeServlet",
		type:"POST",
		data:"userID="+userID+"&textID="+textID2,
		dataType:'json',
		success:function(json){	
                var like= {};
                like.unionID =unionID;
                like.username=user.username;
                likejson.push(like);
			//	$.cookie('user',user, {expires: 7, path: '/' });
				
				
				$("#blike"+textID).css("background-color","skyblue");	
			
			
	//		$("#blike"+textID).attr("disabled",true);
			
			
			alert("点赞成功");
			var a=JSON.stringify(likejson);
			$.cookie("likejson",a,{expires:365,path: '/'});
			console.log(a);	
			
			
		},
		error:function(){
			alert("点赞失败");
		}
		
	})
	}
	}else{
		alert("请登录账号");
		$("#login").click();
		
	}
	
};
//收藏
function addToMine(textID){
	var myID=$("#myID").val();
	var userID=$("#textID"+textID).children().eq(0).val();
	var textID=$("#textID"+textID).children().eq(1).val();
	if(myID.length!=0){
	$.ajax({
		url:"/mybatis_first_demo2/addToMineServlet",
		type:"POST",
		data:"myID="+myID+"&userID="+userID+"&textID="+textID,
		dataType:'json',
		success:function(json){
			alert("收藏成功");
		
		},
		error:function(){
			alert("收藏失败");
		}
		
		
	})
	}else{
		$("#login").click();
		alert("请登录账号");
	}
	
};
//留言

function sendMessage(id){
	
	var userID=$("#textID"+id).children().eq(0).val();
	var textID=$("#textID"+id).children().eq(1).val();
	$("#muserID").val(userID);
	$("#mtextID").val(textID);
	queryMessage(id);
	
//	var userID=$("#userID").val();
//	var textID=$("#textID").val();
//	var message=$("#message").val();
	
	
/*	$.ajax({
		url: "/mybatis_first_demo2/sendMessageServlet",
		type: "POST",
		data: "userID="+userID+"&textID="+textID+"&message="+message,
		dataType:'json',  
        success:function(json){
        	
        	confirm(json.ok+"，留言成功！");	
          },
          
 
          error:function(){
        	  alert("sorry,留言失败,请重试");
          }
	})
	*/
}


function sendNow(){
	var myName=$("#myname").text();
	if(myName.length!=0){
	var message=$("#message").val();
//	alert(message);
	var userID=$("#muserID").val();
	var textID=$("#mtextID").val();
	
	if(typeof message !=null& message.length!=0){
		$.ajax({
			url: "/mybatis_first_demo2/sendMessageServlet",
			type: "POST",
			data:"userID="+userID+"&textID="+textID+"&myName="+myName+"&message="+message,
			dataType:"json",
			success:function(json){
			alert("留言成功");
			},
			error:function(){
				alert("不能发送空信息");
			}
		})
		
	}else{
		
		
	}
		
	}else{
		
		alert("请先登录账号");
		$("#login").click();
	}
	
	
	
}


function queryMessage(id){
	var userID=$("#textID"+id).children().eq(0).val();
	var textID=$("#textID"+id).children().eq(1).val();
	if(userID!=null&&textID!=null){
		$.ajax({
			url:"./queryMessageServlet",
			type:"POST",
			data:"userID="+userID+"&textID="+textID,
			dataType:"json",
			success:function(json){
				$("#allmessage").empty();
				for(var i=0;i<json.length;i++){
					$("#allmessage").append("<div class='modal-body'><p id="+json[i].myName+">用户："+json[i].myName+"</p><p>"+json[i].message+"</p></div>");
				}
			
				
			},
			error:function(){
				$("#allmessage").empty();
				$("#allmessage").append("<div class='modal-body'><p>此文章暂时没有评论哦</p></div>");
			}
			
			
		})
		
	}
	
}










var Allcount=0;
var allNum=0;
var ALLPAGE=0;

function test(textID){
	//alert($("#"+textID+":first").text());
};
//查找文章

//跳转到对应的页数
		function topage(page){
		
			$("#page").empty();
			var num=$("#num").val();
			query(page,num);
			$("#nowpage").html(page);
			
		};
//跳转到下一页			
		function nextpage(){
			//console.log($("#nowpage").text());
			var nowpage=Number($("#nowpage").text());
			var nextpage=nowpage+1;
			//console.log(ALLPAGE);
		//	var a = 160.58;
		//	var b = parseInt(a);//截取整数部分
		//	alert(b);
		//	//或者
		//	var c= Math.round(a);//四舍五入
		//	alert(c);
			
			//if(nextpage==parseInt(ALLPAGE)){
			//	$("#nextpage").hide();
			//}
			topage(nextpage.toString());
		};
//跳转到上一页		
		function prepage(){
			var nowpage=Number($("#nowpage").text());
			
		//	if(nowpage==1){
		//		$("#prepage").hide();
		//	}else{
				topage((nowpage-1).toString());
		//	}
		};
		
		//带参数跳转
		function toJsp(page){
	
			if($("#myID").val().length!=0){
				location.href = "./"+page+".jsp";
			}else{
				alert("请登录账号");
				$("#login").click();
			}
			  
		};
		
		
		
		
		
		function cleanLogin(){
			$.removeCookie('user',{ path: '/'}); 
		  
			
		};
		
		function cleanLike(){
			$.removeCookie('likejson',{ path: '/'});
		}
		
		
		function loadMore(){
			
			
			
			var nowpage=Number($("#nowpage").text());
			var nextpage=nowpage+1;
			console.log(ALLPAGE);
		//	var a = 160.58;
		//	var b = parseInt(a);//截取整数部分
		//	alert(b);
		//	//或者
		//	var c= Math.round(a);//四舍五入
		//	alert(c);
			
			//if(nextpage==parseInt(ALLPAGE)){
			//	$("#nextpage").hide();
			//}
			topage(nextpage.toString());
			
		}
		
		
$(document).ready(function(){
	
		
  		
  	//	$.removeCookie('user',{ path: '/'}); 
  	//	$.removeCookie('likejson',{ path: '/'}); 
		
			
  //		$.removeCookie('likejson',{ path: '/'}); 
					
 
	//	alert(typeof $.cookie('likejson'));
		
			
			
			
			

			
  		})
  		
  		
  		
  		
        // $(function () { $('.popover-hide').popover('hide');});
        // $(function () { $('.popover-destroy').popover('destroy');});
        // $(function () { $('.popover-toggle').popover('toggle');});
        // $(function () { $(".popover-options a").popover({html : true });});
		


	 	

	 			// var w= window.screen.width;
		 		// var h= window.screen.height ;
		 		// alert(h*0.1);
// 	 				 var w2=w;
	 				 // var h2=h*0.1;
	 				 // $("#black").attr("height",h2+"px");
// 	 				 $("div.body").css("width",w2+"px");

// 	 				 var a=h2*0.2;
// 	 				$("div.head").css("height",a+"px");

// 	 				var b1=h2*0.05;
// 	 				$("div.black").css("height",b1+"px");

// 	 				var l1=h2*0.07;
// 	 				$("div.login").css("height",l1+"px");

// 	 				var m1=h2*




	 		


	 	
		 
 
   // 开始写 jQuery 代码...
   


	 	
		
	 // 	$(".body").css("height",h+"px");
	 // 	$(".body").css("width",w+"px");
	 	// $("div.head").css("height",b*0.3);
	 	// $("div.head").css("width",a*0.3);

	 function SearchText(){
		 var searchcondition=$("#searchfactorselect option:selected").val();
		// alert(searchcondition);
		 var searchfactor=$("#searchfactor").val();
		 if(searchfactor.length!=0){
		//	 alert("开始");
			 $.ajax({
				 url:"./searchTextServlet",
				 type:"POST",
				 data:"condition="+searchcondition+"&searchfactor="+searchfactor,
				 dataType:"json",
				success:function(json){
					 if(json.length>0){
						 $("#shareText2").empty();
						 $("#shareText").hide();
						 $(".next").hide();
						 $("#shareText2").show();
						// console.log(json);
				    	//	var count=json[0].count
				    		 var picpath1='';
				    		var picpath2='';
				    	//	 $("#shareText").empty();
				    	//如果只有加载更多这个按钮，无需把之前的记录情况，考虑到用户是刷屏浏览查看文章，所以，我们直接在后面加元素即可
				    		//	$("#info").append("<tr><th>姓名</th><th>性别</th><th>密码</th><th>学院</th><th>班级</th><th>电话</th></tr>");
				    	  
				    	
				    	for(var i=0;i<json.length;i++){
				    	//	 console.log(json);
				    		 picpath1=json[i].picpath1;
				    		 picpath2=json[i].picpath2;
				    	//	  alert(picpath2.length);
				    	if(picpath1.length!=0&&picpath2.length!=0){
				    		$("#shareText2").append("<div id=textID"+i+" class='col-sm-12 col-md-6 clo-lg-6'><input type=hidden value="+json[i].userID+" />"+"<input type=hidden value="+json[i].textID+" />"+"<div class=thumbnail><div class='box box-element'><img src=./images/"+json[i].username+"/"+picpath1+"	/><img src=./images/"+json[i].username+"/"+picpath2+" /></div>"+"<div class='caption'><h4>"+json[i].title+"</h4><h4>"+json[i].username+"</h4><p>"+json[i].text+"</p><p>"+"<input id=unionID"+i+" type=hidden value="+json[i].userID+json[i].textID+" />"+"<a role=button onclick=isLike("+i+") id=blike"+i+">点赞"+json[i].num_like+"</a><a role=button onclick=addToMine("+i+") id=btome"+i+">收藏</a><a role=button onclick=sendMessage("+i+") data-toggle='modal' data-target='#myModal'>留言"+json[i].num_message+"</a></p></div></div></div>" );
				    		$("#shareText2 img").css({"width":"48%","float":"left","margin-left":"1%"});
				    		
				    		//children("p.1").css({"color":"red","border":"2px solid red"});
				    	}else if(picpath2.length==0){
				    	//	alert(json[i].textID);
				    		$("#shareText2").append("<div id=textID"+i+"class='col-sm-12 col-md-6 clo-lg-6'><input type=hidden value="+json[i].userID+" />"+"<input type=hidden value="+json[i].textID+" / >"+"<div class=thumbnail><div class='box box-element'><img src=./images/"+json[i].username+"/"+picpath1+"	/></div>"+"<div class='caption'><h4>"+json[i].title+"</h4><h4>"+json[i].username+"</h4><p>"+json[i].text+"</p><p>"+"<input id=unionID"+i+" type=hidden value="+json[i].userID+json[i].textID+" />"+"<a role=button onclick=isLike("+i+") id=blike"+i+">点赞</a><a role=button onclick=addToMine("+i+") id=btome"+i+">收藏</a><a role=button onclick=sendMessage("+i+") data-toggle='modal' data-target='#myModal'>留言"+json[i].num_message+"</a></p></div></div></div>" );
				    	//	$("#shareText img").css("margin-bottom","5%");
				    		$("img").addClass("img-fluid");
				    		
				    		
				    		
				    		
				    	}else{
				    	//	alert("第一种图片为空");
				    		$("#shareText2").append("<div id=textID"+i+" class='col-sm-12 col-md-6 clo-lg-6'><input type=hidden value="+json[i].userID+" />"+"<input type=hidden value="+json[i].textID+" />"+"<div class=thumbnail><div class='box box-element'><img src=./images/"+json[i].username+"/"+picpath2+"	/></div>"+"<div class='caption'><h4>"+json[i].title+"</h4><h4>"+json[i].username+"</h4><p>"+json[i].text+"</p><p>"+"<input id=unionID"+i+" type=hidden value="+json[i].userID+json[i].textID+" />"+"<a role=button onclick=isLike("+i+") id=blike"+i+">点赞</a><a role=button onclick=addToMine("+i+") id=btome"+i+">收藏</a><a role=button onclick=sendMessage("+i+") data-toggle='modal' data-target='#myModal'>留言"+json[i].num_message+"</a></p></div></div></div>" );
				    	//	$("#shareText img").css("margin-bottom","5%");
				    		
				    	}
				    		  
						//$("#shareText>div").addClass("col-sm-12 col-md-6 clo-lg-6");
						
						
						
						
						
				   }	 
				    	$("#shareText2 a").addClass("btn btn-default");
						//是按钮有浮动，消除高度塌陷
						$("#shareText2 a").css("float","right");
						$("#shareText2").append("<div class='panel panel-success' id=success ><div class='panel-body'><h1><a onclick=backToAll()>返回</a></h1></div></div>")
						 
						 
						 
						 
						 
					 }else{
						 alert("没有找到匹配的文章");
					 }
					 
				 },
				 error:function(){
					 alert("没有找到匹配的文章");
				 }
				 
				
			 
			 
			 })
			 
			 
		 }else{
			 
			 alert("查询内容不能为空");
		 }
		 
		 	 
	 }
		 
		 function backToAll(){
			 $("#shareText2").hide();
			 $("#shareText").show();
			 $(".next").show();
		 }
		 


	</script>
</html>