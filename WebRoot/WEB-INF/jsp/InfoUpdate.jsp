<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>话题修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="public/styles/inforelease.css">
	<script type="text/javascript" src="public/js/jquery.js"></script>
	<script type="text/javascript" src="public/js/inforelease.js"></script>
</head>
<body>
	<div id="container">
		<div id="nvbar">
				&nbsp;&nbsp;话题修改<a href="" id="personinfo">用户: ${userName }</a>&nbsp;&nbsp;&nbsp;&nbsp; <a id="returnFirst"  href="">返回首页</a>
		</div>
		<div>
		     <form  action="InfoUpdateAction.html" method="post" id="inforelease">
		     		标题&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="title" id="h" value="${info.title }"><br><br>
		     		内容<br>
		     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="content" id="content"  >${info.content }</textarea>
		     		<br><br>
		     		<input type="hidden"  name="id"value="${id }">
		     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重新发布" id="send"> 				
		     </form>
		</div>
	</div>
</body>
</html>