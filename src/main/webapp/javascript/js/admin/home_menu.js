// 全局变量
var basePath;
//var topPanel;
//var leftPanel;
//var centerPanel;
$(function(){
	bathPath = getBasePath();
	//菜单树
	$('#menuTree').tree({    
	    url : basePath + "/admin/getMenuByRoleId",
	    method : "GET",
	    formatter:function(node){
			return node.text;
	    },
	    onClick: function(node){
//	    	centerPanel.panel('refresh', basePath + "/WEB-INF/jsp/admin/login.jsp");
	    	centerPanel.panel('refresh', basePath + node.url);
//			console.log(node.url); 
		}
	});
});