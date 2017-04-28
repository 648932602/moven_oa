// 全局变量
var basePath;
var topPanel;
var leftPanel;
var centerPanel;
$(function(){
	bathPath = getBasePath();
	//数据表格
	//库存表
	$('#stockTable').datagrid({
	    url : basePath + "/admin/getMenuByRoleId",
	    method : 'GET',
	    columns : [[
	        {
	        	title : 'ID',
		    	field : 'id',
		    	width : 100
		    }, {
		    	title : 'TITLE',
		    	field : 'text',
		    	width : 100
		    }, {
		    	title : 'ICON',
		    	field : 'iconCls',
		    	width : 100,
		    	align : 'right'
		    }
	    ]]    
	}); 
	//热销表
	$('#hotTable').datagrid({    
		url : basePath + "/admin/getMenuByRoleId",
		method : 'GET',
		columns : [[
            {
            	title : 'ID',
            	field : 'id',
            	width : 100
            }, {
            	title : 'TITLE',
            	field : 'text',
            	width : 100
            }, {
            	title : 'ICON',
            	field : 'iconCls',
            	width : 100,
            	align : 'right'
            }
        ]]    
	}); 
	//热销表
	$('#topTable').datagrid({    
		url : basePath + "/admin/getMenuByRoleId",
		method : 'GET',
		columns : [[
	        {
	        	title : 'ID',
	        	field : 'id',
	        	width : 100
	        }, {
	        	title : 'TITLE',
	        	field : 'text',
	        	width : 100
	        }, {
	        	title : 'ICON',
	        	field : 'iconCls',
	        	width : 100,
	        	align : 'right'
	        }
        ]]    
	}); 
	//热销表
	$('#buttomTable').datagrid({    
		url : basePath + "/admin/getMenuByRoleId",
		method : 'GET',
		columns : [[
	        {
	        	title : 'ID',
	        	field : 'id',
	        	width : 100
	        }, {
	        	title : 'TITLE',
	        	field : 'text',
	        	width : 100
	        }, {
	        	title : 'ICON',
	        	field : 'iconCls',
	        	width : 100,
	        	align : 'right'
	        }
        ]]    
	}); 
});