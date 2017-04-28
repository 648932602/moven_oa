var basePath;
$(function(){
	basePath = getBasePath();
	$("#saveOrUpdate").click(function(){
		var methodValue = $("#saveOrUpdate").html();
		var productionForm = $("#productionForm").form().serialize();
		$.ajax({
			type : "POST",
			dataType : "json",
			url : basePath + "/production/addOrUpdateProduction",
			data : productionForm,
			success : function(msg){
				var result = msg.success;
				if("" != result && "success" == result){
					$.messager.alert(methodValue + '成功', methodValue + "成功！");
				} else {
					$.messager.alert(methodValue + '失败', "请重新输入！");
				}
			},  
			error: function (msg) {  
				$.messager.alert(methodValue + '失败', '网络异常，请稍候重试！'); 
			}  
		});
	});
	$("#reset").click(function(){
		var productionForm = $("#productionForm").form();
		productionForm.form("reset");
	});
});
