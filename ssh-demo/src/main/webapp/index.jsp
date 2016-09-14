<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<!-- 1.CSS -->
		<link  rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>
		<link  rel="stylesheet" type="text/css" href="css/layout-default-latest.css"/>
		<link  rel="stylesheet" type="text/css" href="css/ui.jqgrid.css"/>
<!-- 2.JS -->
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript" src="js/jquery.layout-latest.js"></script>
		<script type="text/javascript" src="js/jquery.jqGrid.min.js"></script>
		<script type="text/javascript" src="js/grid.locale-cn.js"></script>
	
<!-- 3.就绪函数 -->
		<script type="text/javascript">
			$(document).ready(function(){
				$("#userList").jqGrid({        
				   	url:'user/pageLists',//UserController的url地址
					datatype: "json",//url返回的数据类型
				   	colNames:['序号','用户名', '密码', '创建人','创建时间','最后修改人','最后修改时间','备注'],
				   	colModel:[
						{name:'id',index:'id', width:55},
						{name:'userName',index:'userName', width:90},
						{name:'password',index:'password', width:100},
						
						{name:'creater',index:'creater', width:80, align:"right"},
						{name:'createrTime',index:'createrTime', width:130, align:"right",formatter:'date',formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y/m/d H:i:s'}},		
						{name:'updater',index:'updater', width:80,align:"right"},
						{name:'updateTime',index:'updateTime', width:130,align:"right",formatter:'date',formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y/m/d H:i:s'}},
						
						{name:'remaker',index:'remaker', width:150, sortable:false}		
				   	],
				   	rowNum:20,//每页记录数
				   	rowList:[20,50,100,200,500],//每页记录数下拉列表
				   	pager: '#userListToolBar',//工具栏  <div id="userListToolBar"></div>
				   	sortname: 'id',//排序字段
				    sortorder: "desc",//升降序 
					jsonReader: {
						root: 	"content",    		// 结果集引用名: json中代表实际模型数据的入口
						total: 	"totalPages",    	// json中代表页码总数的数据
						records:"totalElements", 	// json中代表数据行总数的数据
					},
					viewrecords: true,
					caption: "用户列表",
					height: '100%'
				});
				$("#userList").jqGrid('navGrid','#userListToolBar',{edit:false,add:false,del:false});
				
				$("#userList").jqGrid('navButtonAdd','#userListToolBar',{
					caption:"Edit",
					onClickButton:function()
					{
						var selrow = $("#userList").jqGrid('getGridParam','selrow');
						if(selrow){
							//alert("select Row userName:"+selrow);
							$("#userList").jqGrid('GridToForm',selrow,"#userForm");
						} else {
							alert("请选中一行记录!")
						}							
					} 
				});
				
			});
		</script>
</head>
<body>
			<!-- 4.视图 -->
			<table id="userList"></table>
			<div id="userListToolBar"></div>
			
			
			<form method="post"  id="userForm" action="user/saveOrUpdate" title='' style="width:350px;margin:0px;">
				<fieldset>
					<legend>用户明细</legend>
					<table>
						<tbody>
							<tr>
								<!-- ID:用户不需要关系,由系统进行维护 -->
								<td></td>
								<td><input type="text" name="id" hidden="true" readonly=true id="invid"/></td>
							</tr>
							<tr>
								<td> 用户名:</td>
								<td><input type="text" name="userName"  /></td>
							</tr>
							<tr>
								<td>密码</td>				
								<td><input type="password" name="password"  /></td>
							</tr>
							<!-- 系统维护字段
							<tr>
								<td>创建人</td>				
								<td><input type="text" name="creater"  /></td>
							</tr>
							<tr>
								<td>创建时间</td>				
								<td><input type="text" name="createrTime"  /></td>
							</tr>
							<tr>
								<td>最后修改人</td>				
								<td><input type="text" name="updater"  /></td>
							</tr>
							<tr>
								<td>最后修改时间</td>			
								<td><input type="text" name="updateTime"  /></td>
							</tr>
							-->
							<tr>
								<td>备注</td>			
								<td><input type="text" name="remaker"  /></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
								<td><input type="submit" value="提交"/></td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</form>
</body>
</html>