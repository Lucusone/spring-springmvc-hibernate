﻿<%@ page contentType="text/html; charset=utf-8"%>
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
	<title>操作管理</title>
	<jsp:include page="/templates/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增操作</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑操作</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction_oper()"><i class="zmdi zmdi-close"></i> 删除操作</a>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/templates/footer.jsp" flush="true"/>
<script>
var $table = $('#table');
$(function() {
	// bootstrap table初始化
	$table.bootstrapTable({
		url: '${basePath}/authority/xtoperation/list',
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
		idField: 'operId',
		searchOnEnterKey: true,
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'ck', checkbox: true},
			{field: 'operId', title: '操作ID', align:'center'},
			{field: 'operName', title: '操作名称'},
			{field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
		]
	});
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a id="update"class="update" href="javascript:;"  data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a id="delete"class="delete" href="javascript:;"  data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
window.actionEvents={
	"click #update":function(e,value,row,index){
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑操作',
			content: 'url:${basePath}/authority/xtoperation/update/' + row.operId,
			onContentReady: function () {
				initMaterialInput();
			}
		}); 
 	},
 	"click #delete":function(e,value,row,index){
 		var content = '确认删除该操作吗？';
		var url = '${basePath}/authority/xtoperation/delete/' + row.operId;
		deleteAction(content,url,null);
 	}
}
// 新增
var createDialog;
function createAction() {
	createDialog = $.dialog({
		animationSpeed: 300,
		title: '新增操作',
		content: 'url:${basePath}/authority/xtoperation/create',
		onContentReady: function () {
			initMaterialInput();
		}
	});
}
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
			title: '编辑操作',
			content: 'url:${basePath}/authority/xtoperation/update/' + rows[0].operId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
	}
}
// 删除
var deleteDialog;
function deleteAction_oper() {
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
 		var content = '确认删除该操作吗？';
		var ids = new Array();
		for (var i in rows) {
			ids.push(rows[i].operId);
		}
		var url = '${basePath}/authority/xtoperation/delete/' +ids.join('-');
		deleteAction(content,url,null);
	}
}
</script>
</body>
</html>