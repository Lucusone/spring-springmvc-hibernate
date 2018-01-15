<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<div id="menuresDialog" class="crudDialog" style="height:600px">
	<form id="menuresForm" method="post">
		<div class="row">
			<div class="col-sm-2">
				<div class="form-group">
					<div class="fg-line">
						<ul id="resztree" class="ztree"></ul>
					</div>
				</div>
			</div>
			<div class="col-sm-10">
				<div class="form-group text-left dialog-buttons">
					<a class="btn btn-success waves-light" href="javascript:;" onclick="menuresSubmit();">保存</a>
					<a class="btn btn-default waves-light" href="javascript:;" onclick="menuresDialog.close();">取消</a>
				</div>
				<div class="form-group">
					<div class="fg-line">
						<table id="restable" class="table table-hover table-condensed"></table>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

<script>

var $restable = $('#restable');
var res_roleId = '4028817a1182f18801118d155b980080';

var res_setting = {
	check: {
		enable: false,
	},
	async: {
		enable: true, //设置启用异步加载
		url: '${basePath}/authority/xtresclass/tree/' + res_roleId,
	},
	data: {
		simpleData: {
			enable: true //设置启用简单数据格式,还可以设置简单数据格式的属性名,idKey,pidKey
		}
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("resztree");
			getresTableData(node.id);
			$restable.bootstrapTable('refresh');
		}
	}
};
function initresTree() {
	$.fn.zTree.init($('#resztree'), res_setting);
}
function getresTableData(resId) {
	$restable.bootstrapTable('destroy');
	$restable.bootstrapTable({
		dataType:"json",
		method:"get",
		url: '${basePath}/authority/xtresource/list/'+ resId,
		sidePagination:"server",
		striped: true,
		minimumCountColumns: 2,
		clickToSelect: true,
		//detailView: true,
		detailFormatter: 'detailFormatter',
		pagination: true,
		paginationLoop: true,
		sidePagination: 'server',
		silentSort: false,
		smartDisplay: false,
		escape: true,
		idField: 'resId',
		searchOnEnterKey: true,
		maintainSelected: true,
		columns: [
			{field: 'ck', checkbox: true},
			{field: 'resId', title: '资源ID', align:'center',visible:false},
			{field: 'resName', title: '资源名称'},
			{field: 'resUrl', title: '资源Url'},
			{field: 'resObjectName', title: '资源对象名称'},
			{field: 'resAccessType', title: '访问资源类型'},
			{field: 'resUsebymenu', title: '资源所属菜单'},
			{field: 'resUsebywf', title: 'WF'},
			{field: 'resHelpPath', title: '资源帮助路径'},
			{field: 'resOrder', title: '资源顺序'},
 			{field: 'resActive', title: '状态', sortable: true, align: 'center', formatter: 'lockedFormatter'},
		]
	});
}

function initmenures() {
	initresTree();
	// bootstrap table初始化
	getresTableData("ROOT");
}


// 格式化状态
function lockedFormatter(value, row, index) {
	if (value == 1) {
		return '<span class="label label-default">锁定</span>';
	} else {
		return '<span class="label label-success">正常</span>';
	}
}

function menuresSubmit() {
	var rows = $restable.bootstrapTable('getSelections');
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
		restable_selectrow = rows[0];	
		setRes(restable_selectrow.resName,restable_selectrow.resId);
		menuresDialog.close();
	}
}

</script>