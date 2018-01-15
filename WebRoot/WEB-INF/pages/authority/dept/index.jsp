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
	<title>部门管理</title>
	<jsp:include page="/templates/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a id="a_left_right" class="waves-effect waves-button" href="javascript:;" onclick="collapse_in_out()"><i class="fa fa-toggle-left"></i>折叠</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增部门</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑部门</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction_dept()"><i class="zmdi zmdi-close"></i> 删除部门</a>
	</div>
	<div class="row">
		<div class="col-sm-2 collapse in" id="treepanel">
			<div class="form-group">
				<ul id="ztree" class="ztree"></ul>
			</div>
		</div>
		<div class="col-sm-10" id="tablepanel">
			<table id="table"></table>
		</div>
	</div>
</div>
<jsp:include page="/templates/footer.jsp" flush="true"/>
<script>
var $table = $('#table');
var orgId = '01';
var parId = null;
var selectedNodeDeptId=null;
var setting = {
	check: {
		enable: false,
	},
	async: {
		enable: true, //设置启用异步加载
		url: '${basePath}/authority/xtdept/tree/' + orgId,
	},
	data: {
		simpleData: {
			enable: true //设置启用简单数据格式,还可以设置简单数据格式的属性名,idKey,pidKey
		}
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("ztree");
			getTableData(orgId,node.id);
			selectedNodeDeptId=node.id;
			$table.bootstrapTable('refresh');
		}
	}
};
function initTree() {
	$.fn.zTree.init($('#ztree'), setting);
}
function getTableData(orgId,parId){
	$table.bootstrapTable('destroy');
	$table.bootstrapTable({
		dataType:"json",
		method:"get",
		url: '${basePath}/authority/xtdept/list/'+orgId+'/'+parId,
		sidePagination:"server",
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
		idField: 'deptId',
		searchOnEnterKey: true,
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'ck', checkbox: true},
			{field: 'deptId', title: '部门ID', align:'center'},
			{field: 'xtOrganization', title: '所属公司'},
			{field: 'xtOrgId', title: '所属组织ID',visible:false},
			{field: 'deptName', title: '部门名称'},
			{field: 'deptTel', title: '部门电话'},
			{field: 'deptFax', title: '部门传真'},
			{field: 'deptAddr', title: '部门地址'},
			{field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
		]
	});
}
$(function() {
	initTree();
	// bootstrap table初始化
	getTableData(orgId,parId);

});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a id="update" class="update" href="javascript:;"  data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a id="delete" class="delete" href="javascript:;"  data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
window.actionEvents={
	"click #update":function(e,value,row,index){
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑部门',
			content: 'url:${basePath}/authority/xtdept/update/' + row.deptId,
			onContentReady: function () {
				initMaterialInput();
			}
		});  
 	},
 	"click #delete":function(e,value,row,index){
 		var content = '确认删除该部门吗？';
		var url = '${basePath}/authority/xtdept/delete/' +row.deptId;
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
		title: '新增部门',
		content: 'url:${basePath}/authority/xtdept/create/'+selectedNodeDeptId,
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
			title: '编辑部门',
			content: 'url:${basePath}/authority/xtdept/update/' + rows[0].deptId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
	}
	initTree();
}
// 删除
var deleteDialog;
function deleteAction_dept() {
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
		var content = '确认删除该部门吗？';
		var ids = new Array();
		for (var i in rows) {
			ids.push(rows[i].deptId);
		}
		var url = '${basePath}/authority/xtdept/delete/' +ids.join("-");
		deleteAction(content,url,initTree);
	}
}
</script>
</body>
</html>