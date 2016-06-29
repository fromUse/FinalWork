<%@ page language="java" pageEncoding="UTF-8"%>
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

<title>My JSF 'InfoReleaseSuccess.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<link rel="stylesheet" type="text/css" href="public/styles/release.css">
<script type="text/javascript">
	var t = 3; // 设定跳转的时间
	setInterval("refer()", 1000); // 启动1秒定时
	function refer() {
		if (t == 0) {
			location = "MyInfos.html"; // 设定跳转的链接地址
		}
		document.getElementById('show').innerHTML = "<span style='color:red'>" + t + "</span>"; // 显示倒计时
		t--; // 计数器递减
	}
</script>
</head>

<body>
	<div id="container">
		<p>发布成功</p>
		<p><span id="show"></span>秒后跳转到我的话题</p>
		<span>跳转失效<a href="MyInfos.html">点这里</a></a></span>
	</div>
</body>
</html>