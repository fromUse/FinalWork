<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<link rel="stylesheet" type="text/css" href="public/styles/myinfos.css">
	<script type="text/javascript" src="public/js/jquery.min.js"></script>
 </head>
  <script type="text/javascript">
  $(function(){
  
	

  });

  function deleteinfo(id){
  
  	var flag= confirm("确定删除？");
  				if(flag){
  				
  				location = "DeleteInfo.html?id=" + id;
  				}

  }
  </script>
  <body>
   	<div id="container">
		<div id="title"><span>我的话题</span><a id="returnindex" href="">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<span>用户 : ${userName }</span> &nbsp;&nbsp;&nbsp;&nbsp;<a href="InfoRelease.html">发布话题</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="Logout.html">注销</a></div>
		<div id="list">
			<ul>
				<c:if test="${fn:length(infolist)==0 }">
						<a href="InfoRelease.html" id="release"> >>>没有话题？点击发布吧</a>
				</c:if>
				<c:forEach var="a" items="${infolist }">
					<li><span><a href="Infos.html?id=${a.id }">${a.title }</a></span>　　${a.createTime }    &nbsp;&nbsp;&nbsp;&nbsp;<a href="InfosUpdate.html?id=${a.id }">修改</a> <a href="javascript:void()"   onclick="deleteinfo(${a.id })">删除</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
  </body>
</html>
