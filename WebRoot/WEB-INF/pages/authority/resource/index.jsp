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
	<title>资源管理</title>
	<jsp:include page="/templates/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a id="a_left_right" class="waves-effect waves-button" href="javascript:;" onclick="collapse_in_out()"><i class="fa fa-toggle-left"></i>折叠</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增资源</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑资源</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction_res()"><i class="zmdi zmdi-close"></i> 删除资源</a>
	</div>
	<div class="col-sm-2 collapse in" id="treepanel">
		<div class="form-group">
			<ul id="ztree" class="ztree"></ul>
		</div>
	</div>
	<div class="col-sm-10" id="tablepanel">
		<table id="table"></table>
	</div>
</div>
<jsp:include page="/templates/footer.jsp" flush="true"/>
<script>

var $table = $('#table');
var roleId = '4028817a1182f18801118d155b980080';

var setting = {
	check: {
		enable: false,
	},
	async: {
		enable: true, //设置启用异步加载
		url: '${basePath}/authority/xtresclass/tree/' + roleId,
	},
	data: {
		simpleData: {
			enable: true //设置启用简单数据格式,还可以设置简单数据格式的属性名,idKey,pidKey
		}
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("ztree");
			getTableData(node.id);
			$table.bootstrapTable('refresh');
		}
	}
};
function initTree() {
	$.fn.zTree.init($('#ztree'), setting);
}
function getTableData(resId) {
	$table.bootstrapTable('destroy');
	$table.bootstrapTable({
		dataType:"json",
		method:"get",
		url: '${basePath}/authority/xtresource/list/'+ resId,
		sidePagination:"server",
		//height: getHeight(),
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
		idField: 'resId',
		searchOnEnterKey: true,
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'ck', checkbox: true},
			{field: 'resId', title: '资源ID', align:'center'},
			{field: 'resName', title: '资源名称'},
			{field: 'resUrl', title: '资源Url'},
			{field: 'resObjectName', title: '资源对象名称'},
			{field: 'resAccessType', title: '访问资源类型'},
			{field: 'resUsebymenu', title: '资源所属菜单'},
			{field: 'resUsebywf', title: 'WF'},
			{field: 'resHelpPath', title: '资源帮助路径'},
			{field: 'resOrder', title: '资源顺序'},
 			{field: 'resActive', title: '状态', sortable: true, align: 'center', formatter: 'lockedFormatter'},
			{field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
		]
	});
}
$(function() {
	initTree();
	// bootstrap table初始化
	getTableData("ROOT");
	
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a id="update" class="update" href="javascript:;"  data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a id="delete"class="delete" href="javascript:;"  data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
window.actionEvents={
	"click #update":function(e,value,row,index){
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑资源',
			content: 'url:${basePath}/authority/xtresource/update/' + row.resId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
 	},
 	"click #delete":function(e,value,row,index){
 		var content = '确认删除该资源吗？';
		var url = '${basePath}/authority/xtresource/delete/' + row.resId;
		deleteAction(content,url,initTree);
 	}
}


// 格式化状态
function lockedFormatter(value, row, index) {
	if (value == 1) {
		return '<span class="label label-default">锁定</span>';
	} else {
		return '<span class="label label-success">正常</span>';
	}
}
// 新增
var createDialog;
function createAction() {
	createDialog = $.dialog({
		animationSpeed: 300,
		title: '新增资源',
		content: 'url:${basePath}/authority/xtresource/create',
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
			title: '编辑资源',
			content: 'url:${basePath}/authority/xtresource/update/' + rows[0].resId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
	}
}
// 删除
var deleteDialog;
function deleteAction_res() {
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
 		var content = '确认删除该资源吗？';
		var ids = new Array();
		for (var i in rows) {
			ids.push(rows[i].resId);
		}
		var url = '${basePath}/authority/xtresource/delete/' +ids.join("-");
		deleteAction(content,url,initTree);
	}
}
</script>
</body>
</html>