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

.tb{
	wihth:50%;
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
	<%
		String currentUser = (String) session.getAttribute("CURRENT_USER");
		if(currentUser == null || currentUser.equals("")) {
	%>
		
        <script type="text/javascript" language="javascript">      
        	alert("您还没有登录，请登录..."); 
        	top.location.href="/NetDisk/page/login.jsp";
        </script>
	<%
		}
	%>


	<div class="jumbotron">
		<h1><a href="/NetDisk/toMain.do">604 Net Disk System</a></h1>
		<h2>文件详情</h2>
	</div>
	
<div class="container"  >
	
<table class="table table-condensed">
  <caption>文件信息</caption>
  <tbody>
    <tr>
      <td>文件名称</td>
      <td>文件大小</td>
      <td>上传者</td>
      <td>公开性</td>
      <td>上传时间</td>
    </tr>
    <tr>
      <td>${userFile.fileName}</td>
      <td>${userFile.fileSize}</td>
      <td>${userFile.fileOwner}</td>
      <td>${userFile.fileVisibility}</td>
      <td>${userFile.fileTime}</td>
      </tr>
  </tbody>
</table>


<div>${userFile.fileTime}</div>
<div>asdfasdf</div>

<div><a href="download.do?id=${userFile.fileId}">
	<button>下载</button>
	</a></div>
</div>

<script type="text/javascript">
 
    function DownloadFile() {
    	
    }

  </script>
  
</body>
</html>














