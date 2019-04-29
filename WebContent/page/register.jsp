<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>604 Net Disk System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style type="text/css">

.message{ 
	color: #d8635a;  
}

body{
	margin:0px;  
	background-color: white; 
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;  
	text-align: center;  
	color: #A6A6A6;  
}

input{
	width: 300px;  
	height: 50px;   
	padding-left:3px;  
	font-size: 18px;  
}


button{  
    width: 200px;  
    height: 50px;  
    margin-top: 25px;  
    background: #1E90FF;  
    border-radius: 10px;  
    border:none;
    font-size: 18px;
    font-weight: 700;  
    color: #fff;
}
button:hover {
background: #79A84B;  
outline: 0;
}
</style>



<body>
<div>
	<div class="jumbotron">
		<h1><a href="/NetDisk/toMain.do">604 Net Disk System</a></h1>
		<h2>用户注册</h2>
	</div>
	
	<div class="message" id="messageDiv">
		<div class="row">
			<div class="span4">
				<div class="alert alert-block">
					<h4 class="alert-heading">注册失败！</h4>
					<div id="messageUser">用户名已存在！</div>
					<div id="messageInput">格式错误！</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/try/bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
	<script src="/try/bootstrap/twitter-bootstrap-v2/docs/assets/js/bootstrap-alert.js"></script>
	
	
	<form action="/NetDisk/register.do" method="post">
		<div>
			<input type="text" name="username" style="display:inline-block" placeholder="username"/>
			<br>
			<br>
			<input type="password" name="password" style="display:inline-block" placeholder="password"/>
			<br>
			<br>
			<input type="password" name="confirm_password" style="display:inline-block" placeholder="confirm password"/>
			<br>
			<br>
			<input type="text" name="school_id" style="display:inline-block" placeholder="school id"/>
			<br>
			<br>
			<input type="text" name="email" style="display:inline-block" placeholder="email(@hust.edu.cn)"/>
		</div>
	    <button type="submit" style="display:inline-block" id="btn-register">Sign up</button>
	</form>
	
	<div id="message"></div>
	<div id="idUsed"></div>
	<div id="correctInput"></div>

</div>

<script type="text/javascript">
	function getQueryVariable(variable)
	{
	       var query = window.location.search.substring(1);
	       var vars = query.split("&");
	       for (var i=0;i<vars.length;i++) {
	               var pair = vars[i].split("=");
	               if(pair[0] == variable){return pair[1];}
	       }
	       return("");
	}
	
	var urlMessage = getQueryVariable("message");
	var errorMessage = getQueryVariable("errorMessage");
	
	if (urlMessage != "registerfailed") {
		document.getElementById('messageDiv').style.display="none";//隐藏
	}
	
	if(errorMessage != "idUsed") {
		document.getElementById('messageUser').style.display="none";
	}
	
	if(errorMessage != "inputError") {
		document.getElementById('messageInput').style.display="none";
	}
</script>

</body>
</html>