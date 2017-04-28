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
<script type="text/javascript" src="${contextPath}/javascript/js/production/editProduction.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/production/editProduction.css" />
<!-- 引用结束 -->
<!-- JS代码 -->
<script type="text/javascript">
var production = ${production};
$(function(){
	if(!isNullObj(production)){
		$("#productionForm").form("load", production);
		$("#saveOrUpdate").html("修改");
	}
});
// 判断是否为空对象
function isNullObj(obj){
    for(var i in obj){
        if(obj.hasOwnProperty(i)){
            return false;
        }
    }
    return true;
}
</script>
<!-- 代码结束 -->
	<div id="editFrame">
		<form id="productionForm">
			<input type="hidden"  id="id" name="id" />
			产品类型：
			<select id="type" name="type">
				<option value="0">其他</option>		
				<option value="1">水果</option>		
				<option value="2">零食</option>		
				<option value="3">日常用品</option>		
			</select><br/>
			产&nbsp;品&nbsp;名&nbsp;：<input type="text"  id="name" name="name" /><br/>
			品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牌：<input type="text"  id="brand" name="brand" /><br/>
			状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：<input type="radio" name="isDel" value="0" checked="checked">未下架&nbsp;&nbsp;<input type="radio" name="isDel" value="1" >下架
		</form>
		<button id="saveOrUpdate">保存</button>
		<button id="reset">重置</button>
	</div>
</body>
</html>