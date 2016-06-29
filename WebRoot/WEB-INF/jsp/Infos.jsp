<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>话题详细</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="public/styles/infos.css">
</head>
<body>
	<div id="container">
		<div id="head">
			<ul>
				<li><a href="">返回首页</a></li>
				<li><a href="MyInfos.html">我的话题 </a></li>
			</ul>
		</div>
		<span>${info.title }</span>
		<div id="content">${info.content }</div>
		<p>${info.createTime }</p>
	</div>
</body>
</html>
