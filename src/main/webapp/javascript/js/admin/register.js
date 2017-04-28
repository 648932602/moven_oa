var basePath;
$(function(){
	basePath = getBasePath();
	$("#registerPanel").panel({
		width : 300,
		height : 200,
		iconCls : "icon-login",
		title : "注册"
	});
	$("#confirmBtn").click(function(){
		var registerForm = $("#registerForm").form().serialize();
		$.ajax({
			type : "POST",
			dataType : "json",
			url : basePath + "/admin/register",
			data : registerForm,
			success : function(msg){
				var result = msg.success;
				if("" != result && "success" == result){
					window.location.href = basePath + "/admin/login";
				} else {
					$.messager.alert('注册失败', "此用户已被注册！");
				}
			},  
			error: function (msg) {  
				$.messager.alert('注册失败', '网络异常，请稍候重试！'); 
			}  
		});
	});
	$("#backBtn").click(function(){
		window.location.href = basePath + "/admin/login";
	});
});
