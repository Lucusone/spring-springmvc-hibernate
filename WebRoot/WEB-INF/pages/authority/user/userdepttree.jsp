<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<div id="userdeptDialog" class="crudDialog" style="height:450px">
	<form id="userdeptForm" method="post">
		<div class="row">
			<div class="col-sm-12">
			
				<div class="form-group">
					<div class="fg-line">
						<ul id="userdeptztree" class="ztree" style="height:380px;overflow-y :scroll;"></ul>
					</div>
				</div>
			
				<div class="form-group pull-right">
					<a class="btn btn-success waves-light" href="javascript:;" onclick="userdeptSubmit();">保存</a>
					<a class="btn btn-default waves-light" href="javascript:;" onclick="userdeptDialog.close();">取消</a>
				</div>

			</div>
		</div>
	</form>
</div>

<script>

var selectedDeptName = null;
var selectedDeptId = null;
var deptCallback;

function initdeptTree(selectedOrgId,func) {
	deptCallback = func;
	var dept_setting = {
		check: {
			enable: false,
		},
		async: {
			enable: true, //设置启用异步加载
			url: '${basePath}/authority/xtdept/tree/' + selectedOrgId,
		},
		data: {
			simpleData: {
				enable: true //设置启用简单数据格式,还可以设置简单数据格式的属性名,idKey,pidKey
			}
		},
		callback: {
			onClick:function(e, id, node){
				var zTree = $.fn.zTree.getZTreeObj("userdeptztree");
				selectedDeptName = node.name;
				selectedDeptId = node.id;
			}
		}
	};

	$.fn.zTree.init($('#userdeptztree'), dept_setting);
}

function userdeptSubmit() {
	if (selectedDeptId == null) {
		$.confirm({
			title: false,
			content: '请选择一个部门!',
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
		if((deptCallback != null) && (typeof deptCallback == 'function')){
			deptCallback(selectedDeptName,selectedDeptId);
		}	
		userdeptDialog.close();
	}
}

</script>