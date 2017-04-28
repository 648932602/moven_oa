var basePath;
$(function(){
	basePath = getBasePath();
	$("#loginPanel").panel({
		width : 300,
		height : 170,
		iconCls : "icon-login",
		title : "登录"
	});
	$("#loginBtn").click(function(){
		var loginForm = $("#loginForm").form().serialize();
		$.ajax({
			type : "POST",
			dataType : "json",
			url : basePath + "/admin/login",
			data : loginForm,
			success : function(msg){
				var result = msg.success;
				if("" != result && "success" == result){
					$("#loginForm").fadeOut(500);
					setTimeout(function(){
						window.location.href = basePath + "/admin/login";
					}, 600);
				} else {
					$.messager.alert('登录失败', "请核对您的用户名和密码！");
				}
			},  
			error: function (msg) {  
				$.messager.alert('登录失败', '网络异常，请稍候重试！'); 
			}  
		});
	});
	$("#registerBtn").click(function(){
		window.location.href = basePath + "/admin/register";
	});
	// 监听按键事件，当为回车时，触发事件
	$(document).keypress(function(key){
		if(13 == key.which){
			var name = document.activeElement.name;
			if("" != name){
				$("#loginBtn").click();
			}
		}
	});
});
