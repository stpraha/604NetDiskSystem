<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件管理</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
.cont{
	text-align: left;
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
		<h2>文件管理</h2>
	</div>

	<div class="cont">
		<div>${param.fileList}</div>
		<c:forEach var="userfile" items="${userFile}" >
			<table class="table table-bordered">
  <caption><a href="toFile.do?id=${userfile.fileId}">${userfile.fileName}</a></caption>
  <tbody>
    <tr>
      <td>文件名</td>
      <td>文件大小</td>
      <td>上传日期</td>
      <td>上传者</td>
      <td>是否公开</td>
    </tr>
    <tr>
      <td>${userfile.fileName}</td>
      <td>${userfile.fileSize}</td>
      <td>${userfile.fileTime}</td>
      <td>${userfile.fileOwner}</td>
      <td>${userfile.fileVisibility}</td>
    </tr>
    <tr>
      <td><a href="delete.do?id=${userfile.fileId}">删除</a></td>
      <td>修改</td>
      <td>修改</td>
      <td>修改</td>
      <td>切换</td>
    </tr>
  </tbody>
</table>
		</c:forEach>									
	</div>
	<div>test</div>
</body>
</html>


