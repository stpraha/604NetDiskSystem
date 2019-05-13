<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<div class="jumbotron">
		<h1><a href="/NetDisk/toMain.do">604 Net Disk System</a></h1>
		<h2>文件列表</h2>
	</div>

<div class="container">

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">公共文件</a></li>
    <li><a data-toggle="tab" href="#menu1">我的文件</a></li>
    <li><a data-toggle="tab" href="#menu2">说明页</a></li>
    <li><a data-toggle="tab" href="#menu3">个人中心</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
		<div class="list-group">
			<div>${param.publicFileList}</div>
			<c:forEach var="publicUserfile" items="${publicFileList}" >
				<div class="list-group-item"><a href="toFile.do?id=${publicUserfile.fileId}">${publicUserfile.fileName}</a></div>
			</c:forEach>									
		</div>
	</div>
    <div id="menu1" class="tab-pane fade">
      <div class="list-group">
			<div>${param.privateFileList}</div>
			<c:forEach var="privateUserfile" items="${privateFileList}" >
				<div class="list-group-item"><a href="toFile.do?id=${privateUserfile.fileId}">${privateUserfile.fileName}</a></div>
			</c:forEach>									
		</div>>
    </div>
    <div id="menu2" class="tab-pane fade">
      <h2>604网盘系统</h2>
      <p>公共文件页面显示的是共享文件，全部人可见</p>
      <p>我的文件页面显示的是私人文件，只有所有者可见</p>
      <p>在个人中心里可以进行登录、注销、文件管理、上传文件</p>
      <p>在个人中心中同时也可以使用管理员功能</p>
      <p>如有BUG请及时联系管理员！</p>

    </div>
    <div id="menu3" class="tab-pane fade">
      <div><h3>当前用户：${sessionScope.CURRENT_USER }</h3></div>
      <button id="btn-login" onclick="javascrtpt:window.location.href='/NetDisk/page/login.jsp'">登录</button>
      <br>
      <a href="/NetDisk/logout.do"><button id="btn-logout">注销</button></a>
      <br>
      <a href="/NetDisk/toManage.do"><button id="btn-manage">文件管理</button></a>
      <br>
      <a href="/NetDisk/toUpload.do"><button >文件上传</button></a>
      <br>
      <a href="/NetDisk/toManagerPage.do"><button >管理员</button></a>
    </div>
  </div>
</div>



</body>
</html>