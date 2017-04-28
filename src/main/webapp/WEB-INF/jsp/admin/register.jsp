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
<title>欢迎注册</title>
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath}/javascript/js/common/common.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/js/admin/register.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/admin/register.css" />
</head>
<body>
	<div id="registerFrame">
		<div id="registerPanel" >
			<form id="registerForm">
				昵&nbsp;&nbsp;&nbsp;称：<input type="text" id="nickname" name="nickname" class="registerText" /><br/>
				用户名：<input type="text" id="username" name="username" class="registerText" /><br/>
				密&nbsp;&nbsp;&nbsp;码：<input type="password" id="password" name="password" class="registerText" /><br/>
				<button type="button"  id="confirmBtn" name="confirmBtn"  class="registerBtn" >确认</button>
				<button type="button"  id="backBtn" name="backBtn" class="registerBtn" >返回</button>
			</form>
		</div>
	</div>
</body>
</html>