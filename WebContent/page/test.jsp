<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
   
    <title>æ­ç¹ä¸ä¼ </title>
    
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
  	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	
    <link rel="stylesheet" type="text/css" href="../css/webuploader.css">
    
</head>


<body>
<div id="uploader" class="wu-example">
    <!--ç¨æ¥å­æ¾æä»¶ä¿¡æ¯-->

    <div class="btns">
        <div id="picker">éæ©å¤§æä»¶</div>
        <button id="ctlBtn" class="btn btn-default">å¼å§ä¸ä¼ </button>
    </div>
    <div id="thelist" class="uploader-list"></div>
</div>
	
<div>${pageContext.request.contextPath }</div>

<!--å¼å¥JS-->
<script type="text/javascript" src="../js/webuploader.min.js"></script>
<script>
	var $thelist = $('#thelist');
	// å®ä¾å
	var uploader = WebUploader.create({
	    pick: {
	        id: '#picker',
	        label: 'éæ©æä»¶'
	    },

	    server: '${pageContext.request.contextPath }/upload.do',
	    auto: false,
	});
	// å½ææä»¶è¢«æ·»å è¿éåçæ¶å
	uploader.on('fileQueued', function (file) {
	    console.log("fileQueued");
	    $thelist.append('<div id="' + file.id + '" class="item">' +
	            '<h4 class="info">' + file.name + '</h4>' +
	            '<p class="state">ç­å¾ä¸ä¼ ...</p>' +
	            '</div>');
	});


</script>
</body>
</html>








