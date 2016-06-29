<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>我的话题</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="public/styles/myinfos.css">
 </head>
  
  <body>
   	<div id="container">
		<div id="title"><span>我的话题</span><a id="returnindex" href="">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="">用户 : ${userName }</a></div>
		<div id="list">
			<ul>
				<c:forEach var="a" items="${infolist }">
					<li><span><a href="Infos.html?id=${a.id }">${a.title }</a></span>　　${a.createTime }</li>
				</c:forEach>
			</ul>
		</div>
	</div>
  </body>
</html>
