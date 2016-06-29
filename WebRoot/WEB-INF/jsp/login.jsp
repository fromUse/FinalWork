<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>用户登陆</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="public/styles/login.css">
<script type="text/javascript" src="public/js/login.js"></script>
</head>

<body>

	<div id="container">
		<p>多用户留言系统</p>
		<form action="LoginAction.html" method="POST" id="login">
		<ul>
			<li>
				<input type="text" name="userName"   placeholder="用户名?"  value="${userName }">&nbsp;&nbsp;&nbsp;<span id="username" class="mes_error">${usermsg}</span>
			</li>
			<li>
			<input type="password" name="passwd"   placeholder="密码?"/>&nbsp;&nbsp;	<span  id="pwd" class="mes_error">${passmsg }</span>
			</li>
			<li>
				<input type="button" value="登陆" class="btn" id="login_btn"> 
				<input type="reset"value="重置" class="btn">
			</li>
			<li id="register"><a href="Register.html"> >>> 注册</a></li>
			</ul>
		</form>

	</div>
</body>
</html>
<script type="text/javascript" src="public/js/jquery.min.js"></script>
