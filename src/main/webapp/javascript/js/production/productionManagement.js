var basePath;
$(function(){
	basePath = getBasePath();
	//库存表
	$('#productionTable').datagrid({
		rownumbers : true,
		border : false,
		singleSelect : true,
	    url : basePath + "/production/getProductionList",
	    method : 'POST',
	    columns : [[
	        {
	        	title : 'ID',
		    	field : 'id',
		    	hidden : true,
		    	width : 100
		    }, {
		    	title : 'TYPE',
		    	field : 'type',
		    	width : 100,
		    	formatter: function(value){
		    		if(null != value){
		    			switch(value){
		    				case 0 : 
		    					return "其他"; 
		    					break;
		    				case 1 : 
		    					return "水果"; 
		    					break;
		    				case 2 : 
		    					return "零食"; 
		    					break;
		    				case 3 : 
		    					return "日常用品"; 
		    					break;
		    				default : 
		    					return "未定义";
		    					break;
		    			}
		    		} else {
		    			return "";
		    		}
		    	}
		    }, {
		    	title : 'BRAND',
		    	field : 'brand',
		    	width : 100
		    }, {
		    	title : 'NAME',
		    	field : 'name',
		    	width : 100
		    }
	    ]]    
	}); 
	$('#addProduction').click(function(){
		centerPanel.panel('refresh', basePath + "/production/getEditProductionPage/0");
	});
	$('#updateProduction').click(function(){
		var production = $('#productionTable').datagrid('getSelected');
		if(null != production){
			centerPanel.panel('refresh', basePath + "/production/getEditProductionPage/" + production.id);
		} else {
			$.messager.alert('警告', "请先选择一条数据！");
		}
	});
	$('#deleteProduction').click(function(){
		var production = $('#productionTable').datagrid('getSelected');
		if(null != production){
			$.ajax({
				type : "POST",
				dataType : "json",
				url : basePath + "/production/deleteProduction",
				data : {
					id : production.id
				},
				success : function(msg){
					var result = msg.success;
					if("" != result && "success" == result){
						$('#productionTable').datagrid("reload");
						$.messager.alert('提示',  "删除成功！");
					} else {
						$.messager.alert('提示', "请重新操作！");
					}
				},  
				error: function (msg) {  
					$.messager.alert('警告', '网络异常，请稍候重试！'); 
				}  
			});
		} else {
			$.messager.alert('警告', "请先选择一条数据！");
		}
	});
});
