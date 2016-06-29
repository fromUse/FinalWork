<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>用户注册</title>

<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<link rel="stylesheet" type="text/css" href="public/styles/register.css">
<script type="text/javascript" src="public/js/register.js"></script>
</head>
<body>
	<div id="container">
		<p>用户注册</p>
		<form action="RegisterAction.html" method="POST"  id="registeruser">
			<dl>
				<dd>
					用 户 名： <input type="text" name="userName" class="text" value="${registerActionForm.userName }" id="userName">&nbsp;&nbsp;<span id="usermsg" class="error_msg">(*必填，至少4位)${uservalidate }</span>
				</dd>
				<dd>
					密　　码：<input type="password" name="passWord" class="text" value="${registerActionForm.passWord }" id="passWord" >&nbsp;&nbsp;<span id="passwdmsg" class="error_msg">(*必填，至少6位)${passwdvalidate }</span>
				</dd>
				<dd>
					密码确认：<input type="password" name="notPassword" class="text" value="${registerActionForm.notPassword   }" id="NotpassWord">&nbsp;&nbsp;<span id="notpasswdmsg" class="error_msg">(*必填，至少6位)${notpasswdvalidate }</span>
				</dd>
				<dd>
				<c:choose>
					<c:when test="${registerActionForm.sex eq '男'}">
							性 別： <input type="radio" name="sex" value="男" checked="checked">男
								<input type="radio" name="sex" value="女">女
					</c:when>
					<c:when test="${registerActionForm.sex eq '女'}">
								性 別： <input type="radio" name="sex" value="男" >男
											<input type="radio" name="sex" value="女" checked="checked">女
				   </c:when>
				  <c:otherwise>
									性 別： <input type="radio" name="sex" value="男" checked="checked">男
													<input type="radio" name="sex" value="女">女
			     </c:otherwise>
				</c:choose>			
				</dd>
				<dd class="url">
					验 证 码 ：<input type="text" name="code" 
						id="code"> <img src="Code.jpg" id="code_img" alt=""验证码"  title="点击刷新">
				</dd>
				<dd>
					<input type="button" value="注册"  id="register" >
				</dd>
				<dd class="error_msg">${check_msg }</dd>
				<dd>已经有账户了? >>>> <a href="Login.html">登陆</a></dd>
			</dl>
	</form>
	</div>


</body>

</html>
<script type="text/javascript" src="public/js/jquery.min.js"></script>