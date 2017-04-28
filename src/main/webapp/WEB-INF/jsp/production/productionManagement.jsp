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
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/easyui/locale/easyui-lang-zh_CN.js" ></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/javascript/easyui/themes/icon.css" />
</head>
<body>
<!-- 外部文件引用 -->
<script type="text/javascript" src="${contextPath}/javascript/js/production/productionManagement.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/production/productionManagement.css" />
<!-- 引用结束 -->
	<div id="productionFrame">
		<div>
			<button id="addProduction">添加产品</button>
			<button id="updateProduction">修改产品</button>
			<button id="deleteProduction">删除产品</button>
		</div>
		<table id="productionTable"></table>
	</div>
</body>
</html>