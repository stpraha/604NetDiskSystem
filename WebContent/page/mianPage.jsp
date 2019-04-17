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

<body>

<div class="container">
  <h2>动态标签</h2>
  <p><strong>提示:</strong> 与 .tab-pane 和 data-toggle="tab" (data-toggle="pill" ) 一同使用, 设置标签页对应的内容随标签的切换而更改。</p>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">公共文件</a></li>
    <li><a data-toggle="tab" href="#menu1">私人文件</a></li>
    <li><a data-toggle="tab" href="#menu2">说明页</a></li>
    <li><a data-toggle="tab" href="#menu3">预留页</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
    
		<p>菜鸟教程 —— 学的不仅是技术，更是梦想！！！</p>
      
      
		<div  class="col-md-8 " id="right_Content">
		<br/>
		<br/>
		<div class="list-group">
			<a class="list-group-item active">博文列表</a>
					
			<!-- 这里初始化文章列表 -->
			<c:forEach var="article" items="${article_list}" >
			<div  class="list-group-item">		
				<h5><a href="ArticleServlet?id=${article.id}">${article.title}</a></h5>
			</div>
			</c:forEach>
			<!-- 初始化文章列表完成 -->		
											
		</div>
	  </div>
	  
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3>菜单 1</h3>
      <p>这是菜单 1 显示的内容。这是菜单 1 显示的内容。这是菜单 1 显示的内容。</p>
    </div>
    <div id="menu2" class="tab-pane fade">
      <h3>菜单 2</h3>
      <p>这是菜单 2 显示的内容。这是菜单 2 显示的内容。这是菜单 2 显示的内容。</p>
    </div>
    <div id="menu3" class="tab-pane fade">
      <h3>菜单 3</h3>
      <p>这是菜单 3 显示的内容。这是菜单 3 显示的内容。这是菜单 3 显示的内容。</p>
    </div>
  </div>
</div>


</body>
</html>