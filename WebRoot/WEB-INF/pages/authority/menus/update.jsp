﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="updateDialog" class="crudDialog">
	<form id="updateForm" method="post">
		<div class="form-group">
			<label for="xtMenu">所属菜单</label>
			<input id="xtMenu" type="text" class="form-control" name="xtMenu" value="${xtmenu.xtMenu.menuName}" maxlength="20" readonly>
			<input id="xtMenu_ParentId" type="text" class="form-control" name="xtMenu_ParentId" value="${xtmenu.xtMenu.menuId}" maxlength="20" style="display:none">
			<input id="menuId" type="text" class="form-control" name="menuId" value="${xtmenu.menuId}" maxlength="20" style="display:none" readonly>
		</div>
		
		<div class="form-group">
			<label for=xtResource>对应资源</label>
			<input id="xtResource" type="text" class="form-control" name="xtResource" value="${xtmenu.xtResource.resName}">
			<input id="xtresId" type="text" class="form-control" name="xtresId" value="${xtmenu.xtResource.resId}" maxlength="20" style="display:none">
		</div>
		<div class="form-group">
			<label for="menuName">菜单名称</label>
			<input id="menuName" type="text" class="form-control" name="menuName" maxlength="50" value="${xtmenu.menuName}">
		</div>
		<div class="form-group">
			<label for="menuHint">菜单提示</label>
			<input id="menuHint" type="text" class="form-control" name="menuHint" maxlength="50" value="${xtmenu.menuHint}">
		</div>
		<div class="form-group">
			<label for="menuDesc">菜单描述</label>
			<input id="menuDesc" type="text" class="form-control" name="menuDesc" maxlength="50" value="${xtmenu.menuDesc}">
		</div>
		<div class="form-group">
			<label for="menuIconPath">初始状态图标路径</label>
			<input id="menuIconPath" type="text" class="form-control" name="menuIconPath" maxlength="50" value="${xtmenu.menuIconPath}">
		</div>
		<div class="form-group">
			<label for="menuIcon">初始状态图标文件名</label>
			<input id="menuIcon" type="text" class="form-control" name="menuIcon" maxlength="50" value="${xtmenu.menuIcon}">
		</div>
		<div class="form-group">
			<label for="menuIconPathOpen">打开状态图标路径</label>
			<input id="menuIconPathOpen" type="text" class="form-control" name="menuIconPathOpen" maxlength="50" value="${xtmenu.menuIconPathOpen}">
		</div>
		<div class="form-group">
			<label for="menuIconOpen">打开状态图标文件名</label>
			<input id="menuIconOpen" type="text" class="form-control" name="menuIconOpen" maxlength="50" value="${xtmenu.menuIconOpen}">
		</div>
		<div class="form-group">
			<label for="menuOrder">排序号</label>
			<input id="menuOrder" type="number" class="form-control" name="menuOrder" maxlength="50" value="${xtmenu.menuOrder}">
		</div>
		<div class="form-group">
			<label for="menuIsnewwindowopen">在新窗口打开页面</label>
			<input id="menuIsnewwindowopen" type="text" class="form-control" name="menuIsnewwindowopen" maxlength="50" value="${xtmenu.menuIsnewwindowopen}">
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="updateSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="updateDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>

var menuresDialog;
$('#xtResource').click(function() {
    menuresDialog = $.dialog({
		animationSpeed: 300,
		title: '请选择对应资源',
		columnClass: 'col-sm-12',
		content: 'url:${basePath}/authority/xtmenu/menures',
		onContentReady: function () {
			initMaterialInput();
			initmenures();
		}
	});
});

function setRes(resName,resId)
{
	$("#xtResource").val(resName);
	$("#xtresId").val(resId);
}

function updateSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/authority/xtmenu/update',
        data: $('#updateForm').serialize(),
        dataType:'json',
        beforeSend: function() {
			if ($('#xtMenu').val() == '') {
                $('#xtMenu').focus();
            }
			if(isNull($('#xtResource').val())){
                $('#xtResource').focus();
                 errorInput("对应资源不能为空！");
                return false;            
            }
            if(isNull($('#menuName').val())){
                $('#menuName').focus();
                errorInput("菜单名称不能为空！");
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
				updateDialog.close();
				initTree();
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