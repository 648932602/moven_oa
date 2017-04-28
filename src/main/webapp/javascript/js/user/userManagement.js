var basePath;
$(function(){
	basePath = getBasePath();
	//用户表
	$('#userTable').datagrid({
		border : false,
	    url : basePath + "/user/getUserList",
	    method : 'POST',
	    columns : [[
	        {
	        	title : 'ID',
		    	field : 'id',
		    	width : 100
		    }, {
		    	title : 'NAME',
		    	field : 'name',
		    	width : 100
		    }, {
		    	title : 'SEX',
		    	field : 'sex',
		    	width : 100,
		    	formatter: function(value){
		    		if(null != value){
		    			switch(value){
		    			case 0 : 
		    				return "保密"; 
		    				break;
		    			case 1 : 
		    				return "男"; 
		    				break;
		    			case 2 : 
		    				return "女"; 
		    				break;
		    			default : 
		    				return "未定义";
		    			break;
		    			}
		    		} else {
		    			return "";
		    		}
		    	}
		    }
	    ]]    
	}); 
});
