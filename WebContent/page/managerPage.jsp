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
		<h2>管理员页面</h2>
	</div>

<div class="container">

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">文件管理</a></li>
    <li><a data-toggle="tab" href="#menu1">用户管理</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">

	<div class="cont">
		<div>${param.fileList}</div>
		<c:forEach var="userFile" items="${userFile}" >
			<table class="table table-bordered">
  					<caption><a href="toFile.do?id=${userFile.fileId}">${userFile.fileName}</a></caption>
  					<tbody>
					    <tr>
					      <td>文件名</td>
					      <td>文件大小</td>
					      <td>上传日期</td>
					      <td>上传者</td>
					      <td>是否公开</td>
					    </tr>
   						 <tr>
					      <td>${userFile.fileName}</td>
					      <td>${userFile.fileSize}</td>
					      <td>${userFile.fileTime}</td>
					      <td>${userFile.fileOwner}</td>
					      <td>${userFile.fileVisibility}</td>
					    </tr>
					    <tr>
					      <td><a href="delete.do?id=${userFile.fileId}">删除</a></td>
					      <td>修改</td>
					      <td>修改</td>
					      <td>修改</td>
					      <td><a href="switchVisibility.do?id=${userFile.fileId}&visibility=${userFile.fileVisibility}">切换</a></td>
					    </tr>
  					</tbody>
			</table>
		</c:forEach>
	</div>
	</div>
	
	<div id="menu1" class="tab-pane fade">
      <h2>还没做好呢，不打算做了，要做的话也简单的。。</h2>
      <div class="cont">

		<c:forEach var="user" items="${userList}" >
			<table class="table table-bordered">
  					<tbody>
					    <tr>
					      <td>用户名</td>
					      <td>用户ID</td>
					      <td>学号</td>
					      <td>邮箱</td>
					      <td>是否管理员</td>
					    </tr>
   						 <tr>
					      <td>${user.username}</td>
					      <td>${user.userid}</td>
					      <td>${user.schoolId}</td>
					      <td>${user.email}</td>
					      <td>${user.admin}</td>
					    </tr>
					    <tr>
					      <td>修改</td>
					      <td>修改</td>
					      <td>修改</td>
					      <td>修改</td>
					      <td>修改</td>
					    </tr>
  					</tbody>
			</table>
		</c:forEach>
	</div>


    </div>
	</div>	
	</div>				
</body>
</html>


