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
<title>欢迎使用</title>
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath}/javascript/js/common/common.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/js/admin/home.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/admin/home.css" />
</head>
<body>
<div id="homeFrame">
    <div id="top" data-options="region:'north', split:false, collapsible:false, border:false" >
    <div style="float: left;">
		<span id="timer"></span>
    </div>
    <div style="float: right;">
		欢迎使用，<span style="color: red;">	${admin.nickname}	</span>！
		<a href="<%=basePath %>/admin/logout">退出登录</a>
    </div>
    </div>   
    <div id="left" data-options="region:'west', title:'菜单', split:false, collapsible:true" >
    </div>   
    <div id="middle" data-options="region:'center', title:'统计', split:false, collapsible:false" >
    </div>
</div>
</body>
</html>