<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="permissionDialog" class="crudDialog">
	<form id="permissionForm" method="post">
	<a class="waves-effect waves-button" href="javascript:;" onclick="permissionAction()"><i class="zmdi zmdi-key"></i> 对应资源</a>
		<div class="form-group">
			<ul id="ztree" class="ztree">12</ul>
		</div>
		<div class="form-group">
			<label for="roleId">角色ID</label>
			<input id="roleId" type="text" class="form-control" name="roleId" maxlength="20">
		</div>
		<div class="form-group">
			<label for="roleName">角色名称</label>
			<input id="roleName" type="text" class="form-control" name="roleName" maxlength="20">
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>

	</form>
</div>
<!-- <div id="createDialog" class="crudDialog"> -->
<%-- 	<form id="createForm" method="post"> --%>
<!-- 		<div class="form-group"> -->
<!-- 			<label for="roleId">角色ID</label> -->
<!-- 			<input id="roleId" type="text" class="form-control" name="roleId" maxlength="20"> -->
<!-- 		</div> -->
<!-- 		<div class="form-group"> -->
<!-- 			<label for="roleName">角色名称</label> -->
<!-- 			<input id="roleName" type="text" class="form-control" name="roleName" maxlength="20"> -->
<!-- 		</div> -->
<!-- 		<div class="form-group text-right dialog-buttons"> -->
<!-- 			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a> -->
<!-- 			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a> -->
<!-- 		</div> -->
<%-- 	</form> --%>
<!-- </div> -->

<script>
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/authority/xtrole/create',
        data: $('#createForm').serialize(),
        dataType:'json',
        beforeSend: function() {
            if ($('#roleId').val() == '') {
                $('#roleId').focus();
                return false;
            }
            if(isNull($('#roleName').val())){
            	$('#roleName').focus();
                return false;
            }
        },
        success: function(result) {
			if (result.code != 1) {
				if (result.data instanceof Array) {
					$.each(result.data, function(index, value) {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content: value.errorMsg,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
					});
				} else {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content:result.data,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
				}
			} else {
				createDialog.close();
				
				$table.bootstrapTable('refresh');
			}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
			$.confirm({
				theme: 'dark',
				animation: 'rotateX',
				closeAnimation: 'rotateX',
				title: false,
				content: textStatus,
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'waves-effect waves-button waves-light'
					}
				}
			});
        }
    });
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
var changeDatas = [];
var setting = {
	check: {
		enable: true,
		// 勾选关联父，取消关联子
		chkboxType: { "Y" : "ps", "N" : "ps" }
	},
	async: {
		enable: true, //设置启用异步加载
		url: '${basePath}/authority/xtmenu/menus/' + roleId,
	},
	data: {
		simpleData: {
			enable: true //设置启用简单数据格式,还可以设置简单数据格式的属性名,idKey,pidKey
		}
	},
	callback: {
		onCheck: function() {
			var zTree = $.fn.zTree.getZTreeObj("ztree")
			var changeNodes = zTree.getCheckedNodes();
			changeDatas = [];
			for (var i = 0; i < changeNodes.length; i ++) {
				var changeData = {};
				changeData.resId = changeNodes[i].resId;
				changeData.checked = changeNodes[i].checked;
				changeDatas.push(changeData);
			}
		},
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("ztree");
			if(node.isParent) {
				zTree.expandNode();
			} else {
				alert(node.name);
			}
		}
	}
};
function initTree() {
	$.fn.zTree.init($('#ztree'), setting);
}

function permissionSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/authority/xtperAssign/saveMenusByRoleId/' + roleId,
        dataType:'json',
        data: {datas: JSON.stringify(changeDatas), roleId: roleId},
        success: function(result) {
			if (result.code != 1) {
				if (result.data instanceof Array) {
					$.each(result.data, function(index, value) {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content: value.errorMsg,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
					});
				} else {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content: result.data.errorMsg,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
				}
			} else {
				permissionDialog.close();
				$table.bootstrapTable('refresh');
			}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
			$.confirm({
				theme: 'dark',
				animation: 'rotateX',
				closeAnimation: 'rotateX',
				title: false,
				content: textStatus,
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'waves-effect waves-button waves-light'
					}
				}
			});
        }
    });
}
</script>