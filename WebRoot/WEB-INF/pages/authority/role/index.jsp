<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>角色管理</title>
	<jsp:include page="/templates/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增角色</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑角色</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction_role()"><i class="zmdi zmdi-close"></i> 删除角色</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="permissionAction()"><i class="zmdi zmdi-key"></i> 角色权限指派</a>
		
	</div>
	<table id="table"></table>
	
</div>
<jsp:include page="/templates/footer.jsp" flush="true"/>
<script>
var $table = $('#table');

$(function() {
	// bootstrap table初始化
	$table.bootstrapTable({
		url: '${basePath}/authority/xtrole/list',
		height: getHeight(),
		striped: true,
		search: true,
		showRefresh: true,
		showColumns: true,
		minimumCountColumns: 2,
		clickToSelect: true,
		detailView: true,
		detailFormatter: 'detailFormatter',
		pagination: true,
		paginationLoop: false,
		sidePagination: 'server',
		silentSort: false,
		smartDisplay: false,
		escape: true,
		idField: 'roleId',
		searchOnEnterKey: true,
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'ck',checkbox: true},
			{field: 'roleId', title: '角色ID', align:'center'},
			{field: 'roleName', title: '角色名称'},
			{field: 'actionUser', title: '对应用户', align:'center',formatter: 'actionFormatterDetailUser', events:'detailUserEvents', clickToSelect:false},
			{field: 'actionPermission', title: '对应权限',align:'center',formatter: 'actionFormatterDetailPermission',events:'detailPerEvents', clickToSelect: false},
			{field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter',events:'IconActionEvents',clickToSelect:false}
		]
	});
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a id="Edit" class="update" href="javascript:;"  data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a id="Remove" class="delete" href="javascript:;"  data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}


window.IconActionEvents={

 	"click #Edit":function(e,value,row,index){
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑角色',
			content: 'url:${basePath}/authority/xtrole/update/'+row.roleId,
			onContentReady: function () {
				initMaterialInput();
			}
		});  
 	},
 	"click #Remove":function(e,value,row,index){
 		var content = '确认删除该角色吗？';
		var url = '${basePath}/authority/xtrole/delete/' + row.roleId;
		deleteAction(content,url);
 	}
}

function actionFormatterDetailUser(value, row, index) {
    return [
		'<a id = "detailUser" class="waves-effect waves-button" href="javascript:;" data-toggle="tooltip" title="Edit">详细</a>　',
    ].join('');
}
window.detailUserEvents={
	
 	"click #detailUser":function(e,value,row,index){
 		roleId = row.roleId;
		detailDialog = $.dialog({
			animationSpeed: 300,
			title: '对应用户',
			columnClass: 'col-sm-12',
			content: 'url:${basePath}/authority/xtuser/showUserByRoleId/',
			onContentReady: function () {
				initMaterialInput();
				tableUser();
			}
		});
 	}
}

function actionFormatterDetailPermission(value, row, index) {
    return [
		'<a id = "detailPerm" class="waves-effect waves-button" href="javascript:;"  data-toggle="tooltip" title="Edit">详细</a>　',
    ].join('');
}
window.detailPerEvents={

 	"click #detailPerm":function(e,value,row,index){
 		roleId = row.roleId;
		detailDialog = $.dialog({
			animationSpeed: 300,
			title: '对应用户',
// 			columnClass: 'col-sm-4',
			content: 'url:${basePath}/authority/xtmenu/showMenuByRoleId',
			onContentReady: function () {
				initMaterialInput();
				initTree();
				
			}
		});
 	}
}

// 新增
var createDialog;
function createAction() {
	createDialog = $.dialog({
		animationSpeed: 300,
		title: '新增角色',
		content: 'url:${basePath}/authority/xtrole/create',
		onContentReady: function () {
			initMaterialInput();
		}
	});
}
//icon点击事件


// 编辑
var updateDialog;
function updateAction() {
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length != 1) {
		$.confirm({
			title: false,
			content: '请选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑角色',
			content: 'url:${basePath}/authority/xtrole/update/' + rows[0].roleId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
	}
}
// 删除
var deleteDialog;
function deleteAction_role() {
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length == 0) {
		$.confirm({
			title: false,
			content: '请至少选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
 		var content = '确认删除该角色吗？';
		var ids = new Array();
		for (var i in rows) {
			ids.push(rows[i].roleId);
		}
		var url = '${basePath}/authority/xtrole/delete/' + ids.join("-");
		deleteAction(content,url);
	}
}
// 角色权限
var permissionDialog;
var roleId;
function permissionAction() {
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length != 1) {
		$.confirm({
			title: false,
			content: '请选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		roleId = rows[0].roleId;
		permissionDialog = $.dialog({
			animationSpeed: 300,
			title: '角色权限',
			content: 'url:${basePath}/authority/xtperAssign/role/' + roleId,
			onContentReady: function () {
				initMaterialInput();
				initTree();
			}
		});
	}
}

var detailDialog;
function detailAction(){
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length != 1) {
		$.confirm({
			title: false,
			content: '请选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		roleId = rows[0].roleId;
		detailDialog = $.dialog({
			animationSpeed: 300,
			title: '对应用户',
			columnClass: 'col-sm-12',
			content: 'url:${basePath}/authority/xtuser/showUserByRoleId/',
			onContentReady: function () {
				initMaterialInput();
				tableUser();
			}
		});
	}
}
var detailDialogPer;
function detailActionPer(){
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length != 1) {
		$.confirm({
			title: false,
			content: '请选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		roleId = rows[0].roleId;
		detailDialog = $.dialog({
			animationSpeed: 300,
			title: '对应用户',
// 			columnClass: 'col-sm-4',
			content: 'url:${basePath}/authority/xtmenu/showMenuByRoleId',
			onContentReady: function () {
				initMaterialInput();
				initTree();
				
			}
		});
	}
}

</script>
</body>
</html>