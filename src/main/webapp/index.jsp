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
<h2>Add Book</h2>
<form method="post" action="<%=request.getContextPath() %>/book/add">
bookname:<input type="text" name="name" id="name">
author:<input type="text" name="author" id="author">
<input type="submit" value="Add">
</form>
<form method="post" action="<%=request.getContextPath() %>/user/getUserById">
userId:<input type="text" name="id" id="id">
<input type="submit" value="Get">
</form>
<form method="post" action="<%=request.getContextPath() %>/user/add">
userName:<input type="text" name="name" id="name">
<input type="submit" value="Add">
</form>
</body>
</html>
