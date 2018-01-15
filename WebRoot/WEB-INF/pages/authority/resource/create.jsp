<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="createDialog" class="crudDialog">
	<form id="createForm" method="post">
		<!--div class="form-group">
			<label for="resId">资源ID</label>
			<input id="resId" type="text" class="form-control" name="resId" maxlength="20">
		</div-->
		<div class="form-group">
			<label for="resName">资源名称</label>
			<input id="resName" type="text" class="form-control" name="resName" maxlength="20">
		</div>
		<div class="form-group">
			<label for=resUrl>资源Url</label>
			<input id="resUrl" type="text" class="form-control" name="resUrl" maxlength="300">
		</div>
		<div class="form-group">
			<label for="resObjectName">资源对象名称</label>
			<input id="resObjectName" type="text" class="form-control" name="resObjectName" maxlength="50">
		</div>
		<div class="form-group">
			<label for="resAccessType">访问资源类型</label>
			<input id="resAccessType" type="text" class="form-control" name="resAccessType" maxlength="50">
		</div>
		<div class="form-group">
			<label for="resUsebymenu">资源所属菜单</label>
			<input id="resUsebymenu" type="text" class="form-control" name="resUsebymenu" maxlength="50">
		</div>
		<div class="form-group">
			<label for="resHelpPath">资源帮助路径</label>
			<input id="resHelpPath" type="text" class="form-control" name="resHelpPath" maxlength="50">
		</div>
		<div class="form-group">
			<label for="resUsebywf">WF</label>
			<input id="resUsebywf" type="text" class="form-control" name="resUsebywf" maxlength="50">
		</div>
		<div class="form-group">
			<label for="resOrder">资源顺序</label>
			<input id="resOrder" type="number" class="form-control" name="resOrder" maxlength="50">
		</div>
		<div class="form-group">
			<select id="resTypeId" name="resTypeId" style="width: 100%">
				<c:forEach var="xtResType" items="${xtResTypes}">
					<option value="${xtResType.resTypeId}">${xtResType.resTypeName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<select id="resClassId" name="resClassId" style="width: 100%" place>
				<c:forEach var="xtResClass" items="${xtResClasses}">
					<option value="${xtResClass.resClassId}">${xtResClass.resClassName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="radio">
			<div class="radio radio-inline radio-success">
				<input id="locked_0" type="radio" name="resActive" value="0" checked>
				<label for="locked_0">正常 </label>
			</div>
			<div class="radio radio-inline">
				<input id="locked_1" type="radio" name="resActive" value="1">
				<label for="locked_1">锁定 </label>
			</div>
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>

function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/authority/xtresource/create',
        data: $('#createForm').serialize(),
        dataType:'json',
        beforeSend: function() {
            if ($('#resId').val() == '') {
                $('#resId').focus();
                return false;
            }
            if(isNull($('#resName').val())){
            	$('#resName').focus();
            	errorInput("资源名称不能为空！");
            	return false;
            }
            if(isNull($('#resUrl').val())){
            	$('#resUrl').focus();
            	errorInput("资源URL不能为空！");
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
</script>