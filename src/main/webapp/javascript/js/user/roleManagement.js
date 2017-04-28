var basePath;
$(function(){
	basePath = getBasePath();
	//获取角色列表
	$.ajax({
		type : "POST",
		dataType : "json",
		url : basePath + "/role/getRoleList",
		success : function(msg){
			if(null != msg && "{}" != "" + msg){
				var roleList = eval(msg);
				var listContext = "<ul>";
				for(var i = 0; i < roleList.length; i++){
					listContext = listContext +
					'<li onclick="getRootListById(' + roleList[i].id + ", '" + roleList[i].name + "')" + '">' +
						roleList[i].name +
					"</li>";
				}
				listContext = listContext + "</ul>";
				$("#roleList").html(listContext);
			} else {
				$.messager.alert('获取失败', '未查询到角色！'); 
			}
		},  
		error: function (msg) {  
			$.messager.alert('获取失败', '网络异常，请稍候重试！'); 
		}  
	});
	// 绑定事件
	$('#createRoot').click(function(){
		$("#name").val("");
		var checked = $('#rootList').tree('getChecked');
		for(var i = 0; i < checked.length; i++){
			$('#rootList').tree('uncheck', checked[i].target);
		}
	});
	$('#addOrUpdateRoot').click(function(){
		var checked = $('#rootList').tree('getChecked');
    	var indeterminate = $('#rootList').tree('getChecked', 'indeterminate');
    	alert(checked);
    	alert(indeterminate);
	});
});
function getRootListById(id, name){
	$("#name").val(name);
	$('#rootList').tree({
		checkbox : true,
	    url : basePath + "/admin/getMenuByRoleId",
	    method : "GET",
	    formatter:function(node){
			return node.text;
	    }
//	    onCheck: function(node, checked){
//	    	var checked = $('#rootList').tree('getChecked');
//	    	var indeterminate = $('#rootList').tree('getChecked', 'indeterminate');
//	    	alert(checked);
//	    	alert(indeterminate);
//	    	$.messager.alert('状态', 'ID : ' + node.id + ', checked : ' + checked); 
//		}
	});
};
