<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Upload File</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
.prog{
    border:1px solid red;
    border:2px solid #000;
    width:100%;
    height:20px;
}

.check{
	zoom:1.5;
	margin-top:10px;
}

body{
	margin:0px;  
	background-color: white; 
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;   
	color: #A6A6A6;  
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

<progress id="progressBar" class="prog" value="0" max="100"></progress>

<div class="jumbotron" >	
	<h1 style="text-align: center;" >604 Net Disk System</h1>
	<h3 style="text-align: center; margin-top:30px;">Upload</h3>
</div>

<form id= "uploadForm">
 
  <input type="file" id="file" name="myfile" />
  <input type="button" onclick="UploadFile()" value="上传" />
 
</form>

<script type="text/javascript">
 
    function UploadFile() {
      var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
      var FileController = "/NetDisk/upload.do";          // 接收上传文件的后台地址 
      var progressBar = document.getElementById("progressBar");
      // FormData 对象
      var form = new FormData($( "#uploadForm" )[0]);
 
      // XMLHttpRequest 对象
      var xhr = new XMLHttpRequest();
      xhr.open("post", FileController, true);
      xhr.onload = function () {
    	progressBar.value=0;
        alert("上传完成!");
      };
 
      xhr.upload.addEventListener("progress", progressFunction, false);
      xhr.send(form);
    }
 
    function progressFunction(evt) {
      var progressBar = document.getElementById("progressBar");
      var percentageDiv = document.getElementById("percentage");
      if (evt.lengthComputable) {
        progressBar.max = evt.total;
        progressBar.value = evt.loaded;
        percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
        if(evt.loaded==evt.total){
        	progressBar.value=0;
          //alert("上传完成100%");
        }
      }
    } 
 
  </script>
   

   
</body>
</html>