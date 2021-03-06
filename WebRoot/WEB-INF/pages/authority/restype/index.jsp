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
	<title>资源类型管理</title>
	<jsp:include page="/templates/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增资源类型</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑资源类型</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction_resty()"><i class="zmdi zmdi-close"></i> 删除资源类型</a>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/templates/footer.jsp" flush="true"/>
<script>
var $table = $('#table');
$(function() {
	// bootstrap table初始化
	$table.bootstrapTable({
		url: '${basePath}/authority/xtrestype/list',
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
		idField: 'resTypeId',
		searchOnEnterKey: true,
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'ck', checkbox: true},
			{field: 'resTypeId', title: '资源类型ID', align:'center'},
			{field: 'resTypeName', title: '资源类型名称'},
			{field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
		]
	});
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a id ="update" class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a id ="delete" class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
window.actionEvents={
	"click #update":function(e,value,row,index){
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑资源类型',
			content: 'url:${basePath}/authority/xtrestype/update/' + row.resTypeId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
 	},
 	"click #delete":function(e,value,row,index){
 		var content = '确认删除该资源类型吗？';
		var url = 'url:${basePath}/authority/xtrestype/update/' + row.resTypeId;
		deleteAction(content,url,null);
 	}
}

// 新增
var createDialog;
function createAction() {
	createDialog = $.dialog({
		animationSpeed: 300,
		title: '新增资源类型',
		content: 'url:${basePath}/authority/xtrestype/create',
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
			title: '编辑资源类型',
			content: 'url:${basePath}/authority/xtrestype/update/' + rows[0].resTypeId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
	}
}
// 删除
var deleteDialog;
function deleteAction_resty() {
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
 		var content = '确认删除该资源类型吗？';
		var ids = new Array();
		for (var i in rows) {
			ids.push(rows[i].resTypeId);
		}
		var url = 'url:${basePath}/authority/xtrestype/update/' + ids.join("-");
		deleteAction(content,url,null);
	}
}
</script>
</body>
</html>