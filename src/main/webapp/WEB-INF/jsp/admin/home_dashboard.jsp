<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- 外部文件引用 -->
<script type="text/javascript" src="${contextPath}/javascript/js/admin/home_dashboard.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/admin/home_dashboard.css" />
<!-- 引用结束 -->

<div  id="dashboard" >
   	<ul>
   		<li>
   			<span>库存统计</span>
	    	<table id="stockTable"></table>
   		</li>
   		<li>
   			<span>热销统计</span>
	    	<table id="hotTable"></table>
   		</li>
   		<li>
   			<span>排行统计</span>
	    	<table id="topTable"></table>
   		</li>
   		<li>
   			<span>滞销统计</span>
	    	<table id="buttomTable"></table>
   		</li>
   	</ul>
</div>
