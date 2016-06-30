<%@ page language="java" pageEncoding="UTF-8" isErrorPage="true"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>错误页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	var t = 3; // 设定跳转的时间
	setInterval("refer()", 1000); // 启动1秒定时
	function refer() {
		if (t == 0) {
			location = "index.html"; // 设定跳转的链接地址
		}
		document.getElementById('show').innerHTML = "<span style='color:red'>" + t + "</span>"; // 显示倒计时
		t--; // 计数器递减
	}
</script>
  </head>
  
  <body>
    500错误背锅页面,发生未知错误 <br>
    
    <p id="show"></p>
  </body>
</html:html>
