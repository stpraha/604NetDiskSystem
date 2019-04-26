<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
   
    <title>上传文件</title>
    
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
  	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	
    <link rel="stylesheet" type="text/css" href="../css/webuploader.css">
    
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
		<h2>文件上传</h2>
	</div>


	<div id="uploader" class="wu-example">
	
	    <div class="btns">
	        <div id="picker">选择文件</div>
	        <br>
	        <button id="ctlBtn">开始上传</button>
	    </div>
	    <div id="thelist" class="uploader-list"></div>
	</div>
	
	<!--å¼å¥JS-->
	<script type="text/javascript" src="../js/webuploader.min.js"></script>
		<script>
		var $thelist = $('#thelist');
		var $btn = $('#ctlBtn');
		// 实例化
		var uploader = WebUploader.create({
		    pick: {
		        id: '#picker',
		        label: '选择文件'
		    },
	
		    server: '/NetDisk/upload.do',
		    
		    //auto:true
	
		});
		// 显示被选中的文件
		uploader.on('fileQueued', function (file) {
		    console.log("fileQueued");
		    $thelist.append('<div id="' + file.id + '" class="item">' +
		            '<h4 class="info">' + file.name + '</h4>' +
		            '<p class="state">等待上传...</p>' +
		            '</div>');
		});
		
		// 上传文件
	    $btn.on('click', function () {
	        uploader.upload();
	    });
		
	    // 上传中
	    uploader.on('uploadProgress', function(file, percentage) {
	    	var $li = $('#'+file.id),
	    	//这里用空格隔开的！！！
	        $percent = $li.find('.progress .progress-bar');
	
		    // 避免重复创建
		    if ( !$percent.length ) {
		        $percent = $('<div class="progress progress-striped active">' +
		          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
		          '</div>' +
		        '</div>').appendTo( $li ).find('.progress-bar');
		    }
		
		    $li.find('p.state').text('上传中');
		
		    $percent.css( 'width', percentage * 100 + '%' );
	    });
	    
	    // error
	    uploader.on('uploadError', function(file) {
	    	var $li = $('#'+file.id);
	
	    	
	    	$li.find('p.state').text('上传失败');
	    });
	    
	    // success
	    uploader.on('uploadSuccess', function(file) {
	    	var $li = $('#'+file.id);
			
			$li.find('p.state').text('上传成功');
	    });
	    
		
	</script>
</body>
</html>