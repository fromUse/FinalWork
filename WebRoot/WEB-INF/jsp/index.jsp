<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="public/styles/index.css">

</head>

<body>
	<div id="container">
		<div id="title"><span>话题广场</span></div>
		<div id="list">
			<ul>
				<c:forEach var="a" items="${infolist }">
					<li><span><a href="Infos.html?id=${a.id }">${a.title }</a></span>　　${a.createTime }</li>
				</c:forEach>
			</ul>
		</div>
					<a href="InfoRelease.html" id="release"> >>>没有话题？点这里发布</a>
	</div>
</body>
</html>
