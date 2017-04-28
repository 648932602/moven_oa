<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>欢迎登录</title>
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath}/javascript/js/common/common.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/js/admin/login.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/admin/login.css" />
</head>
<body>
	<div id="loginFrame">
		<div id="loginPanel" >
			<form id="loginForm">
				用户名：<input type="text" id="username" name="username" class="loginText" /><br/>
				密&nbsp;&nbsp;&nbsp;码：<input type="password" id="password" name="password" class="loginText" /><br/>
				<button type="button"  id="loginBtn" name="loginBtn"  class="loginBtn" >登录</button>
				<button type="button"  id="registerBtn" name="registerBtn" class="loginBtn" >注册</button>
			</form>
		</div>
	</div>
</body>
</html>