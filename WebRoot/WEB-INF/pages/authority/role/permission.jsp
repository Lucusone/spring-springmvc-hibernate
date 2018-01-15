<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="permissionDialog" class="crudDialog">
	<form id="permissionForm" method="post">
		<div class="form-group">
			<ul id="ztree" class="ztree"></ul>
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="permissionSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="permissionDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>

var changeDatas = [];
var zTree = null;
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
			initChangeDatas();
		},
		onAsyncSuccess:initChangeDatas,
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

function initChangeDatas(){
	zTree = $.fn.zTree.getZTreeObj("ztree")
	var changeNodes = zTree.getCheckedNodes();
	changeDatas = [];
	for (var i = 0; i < changeNodes.length; i ++) {
		var changeData = {};
		changeData.resId = changeNodes[i].resId;
		changeData.checked = changeNodes[i].checked;
		changeDatas.push(changeData);
	}
}

function permissionSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/authority/xtperAssign/saveMenusByRoleId/' + roleId,
        dataType:'json',
        data: {datas: JSON.stringify(changeDatas), roleId: roleId},
        beforeSend:function(){
        	if($.fn.zTree.getZTreeObj("ztree").getCheckedNodes().length<1){
        		alert("没有指定权限，请指定一个具体权限");
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