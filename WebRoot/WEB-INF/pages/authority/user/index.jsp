<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="currentuserOrg" value="${sessionScope.currentOrg.orgId}"/>
<c:set var="currentuserOrgName" value="${sessionScope.currentOrg.orgName}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户管理</title>
	<jsp:include page="/templates/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增用户</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑用户</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction_user()"><i class="zmdi zmdi-close"></i> 删除用户</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="roleAction()"><i class="zmdi zmdi-accounts"></i> 用户角色指派</a>
	</div>
	<div class="form-inline pull-right">
         <input id="orgName" type="text" class="form-control" name="orgName" placeholder="请选择所属公司" value="${currentOrg.orgName}">
         <input id="org_Id_index" type="text" class="form-control" name="org_Id_index" maxlength="20" style="display:none" value="${currentOrg.orgId}">
         <input id="searchKey" type="text" class="form-control" name="searchKey" placeholder="关键字">
         <button id="searchBtn" class="btn btn-success" onclick="searchBtnSubmit()" style="margin-left:10px">查询</button>
    </div>
	<table id="table"></table>
</div>
<jsp:include page="/templates/footer.jsp" flush="true"/>
<script>
var selectedOrgName;
var selectedOrgId;
var $table = $('#table');
$(function() {
	searchBtnSubmit();
});
// 格式化操作按钮
function updateactionFormatter(value, row, index) {
    return [
    '<a id="updatecell" href="javascript:;" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
    '<a id="deletecell" class="delete" href="javascript:;" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');	
}

window.operateEvents = {
	"click #updatecell":function(e,value,row,index){
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑用户',
			content: 'url:${basePath}/authority/xtuser/update/' + row.userId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
	},
	"click #deletecell":function(e,value,row,index){
		var content = '确认删除该用户吗？';
		var url = '${basePath}/authority/xtuser/delete/' + row.userId;
		deleteAction(content,url,null);
	}
}

// 格式化图标
function avatarFormatter(value, row, index) {
    return '<img src="${basePath}' + value + '" style="width:20px;height:20px;"/>';
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
		animationSpeed: 200,
		title: '新增用户',
		content: 'url:${basePath}/authority/xtuser/create',
		onContentReady: function () {
			initMaterialInput();
		}
	});
	//location.href = "${basePath}/authority/xtuser/create";
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
			title: '编辑用户',
			content: 'url:${basePath}/authority/xtuser/update/' + rows[0].userId,
			onContentReady: function () {
				initMaterialInput();
			}
		});
	}
}
//删除
var deleteDialog;
function deleteAction_user() {
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
		var content = '确认删除该用户吗？';
		var ids = new Array();
		for (var i in rows) {
			ids.push(rows[i].userId);
		}
		var url = '${basePath}/authority/xtuser/delete/' + ids.join("-");
		deleteAction(content,url,null);
	}
}
// 用户角色
var roleDialog;
var roleUserId;
function roleAction() {
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
		roleUserId = rows[0].userId;
		roleDialog = $.dialog({
			animationSpeed: 300,
			title: '用户角色',
			content: 'url:${basePath}/authority/xtuser/role/' + roleUserId,
			onContentReady: function () {
				initMaterialInput();
				$('select').select2({
					placeholder: '请选择用户角色',
					allowClear: true
				});
			}
		});
	}
}

var userorgDialog;
$('#orgName').click(function() {
    userorgDialog = $.dialog({
		animationSpeed: 300,
		title: '请选择所属公司',
		//columnClass: 'col-sm-12',
		content: 'url:${basePath}/authority/xtuser/showOrgTree/',
		onContentReady: function () {
			initorgTree('${currentuserOrg}','${currentuserOrgName}',setorgIndex);
		}
	});
});

function setorgIndex(orgName,orgId)
{
	$("#orgName").val(orgName);
	$("#org_Id_index").val(orgId);
}

function searchBtnSubmit(){
	var orgId = document.getElementById('org_Id_index').value;
	var search = document.getElementById('searchKey').value;
	if(search === ''){
		search = null;
	}
	$table.bootstrapTable('destroy');
	$table.bootstrapTable({
		url: '${basePath}/authority/xtuser/list/'+ orgId + '/' +search,
		height: getHeight(),
		striped: true,
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
		idField: 'userId',
		searchOnEnterKey: true,
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'ck', checkbox: true},
			{field: 'userId', title: '编号', align:'center'},
            {field: 'userName', title: '姓名'},
			{field: 'userMobile', title: '电话'},
			{field: 'userEmail', title: '邮箱'},
			{field: 'userAddr', title: '地址'},
 			{field: 'userInvalid', title: '状态', sortable: true, align: 'center', formatter: 'lockedFormatter'},
			{field: 'Button', title: '操作', align: 'center', events:'operateEvents', formatter: 'updateactionFormatter', clickToSelect: false},
		]
	});
}

</script>
</body>
</html>