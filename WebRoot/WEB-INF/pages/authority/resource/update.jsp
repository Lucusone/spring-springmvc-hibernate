<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="updateDialog" class="crudDialog">
	<form id="updateForm" method="post">
		<div class="form-group">
			<label for="resId">资源ID</label>
			<input id="resId" type="text" class="form-control" name="resId" maxlength="20" value="${xtresource.resId}" readonly>
		</div>
		<div class="form-group">
			<label for="resName">资源名称</label>
			<input id="resName" type="text" class="form-control" name="resName" maxlength="20" value="${xtresource.resName}">
		</div>
		<div class="form-group">
			<label for=resUrl>资源Url</label>
			<input id="resUrl" type="text" class="form-control" name="resUrl" maxlength="300" value="${xtresource.resUrl}">
		</div>
		<div class="form-group">
			<label for="resObjectName">资源对象名称</label>
			<input id="resObjectName" type="text" class="form-control" name="resObjectName" maxlength="50" value="${xtresource.resObjectName}">
		</div>
		<div class="form-group">
			<label for="resAccessType">访问资源类型</label>
			<input id="resAccessType" type="text" class="form-control" name="resAccessType" maxlength="50" value="${xtresource.resAccessType}">
		</div>
		<div class="form-group">
			<label for="resUsebymenu">资源所属菜单</label>
			<input id="resUsebymenu" type="text" class="form-control" name="resUsebymenu" maxlength="50" value="${xtresource.resUsebymenu}">
		</div>
		<div class="form-group">
			<label for="resHelpPath">资源帮助路径</label>
			<input id="resHelpPath" type="text" class="form-control" name="resHelpPath" maxlength="50" value="${xtresource.resHelpPath}">
		</div>
		<div class="form-group">
			<label for="resUsebywf">WF</label>
			<input id="resUsebywf" type="text" class="form-control" name="resUsebywf" maxlength="50" value="${xtresource.resUsebywf}">
		</div>
		<div class="form-group">
			<label for="resOrder">资源顺序</label>
			<input id="resOrder" type="text" class="form-control" name="resOrder" maxlength="50" value="${xtresource.resOrder}">
		</div>
		<div class="form-group">
			<select id="resTypeId" name="resTypeId" style="width: 100%">
				<c:forEach var="xtResType" items="${xtResTypes}">
					<option value="${xtResType.resTypeId}" <c:if test="${xtResType.resTypeId==xtresource.xtResType.resTypeId}">selected="selected"</c:if>>${xtResType.resTypeName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<select id="resClassId" name="resClassId" style="width: 100%">
				<c:forEach var="xtResClass" items="${xtResClasses}">
					<option value="${xtResClass.resClassId}" <c:if test="${xtResClass.resClassId==xtresource.xtResClass.resClassId}">selected="selected"</c:if>>${xtResClass.resClassName}</option>
				</c:forEach>
			</select>
		</div>
<!-- 		<div class="radio"> -->
<!-- 			<div class="radio radio-inline radio-success"> -->
<%-- 				<input id="locked_0" type="radio" name="locked" value="0" <c:if test="${xtresource.resActive==0}">checked</c:if>> --%>
<!-- 				<label for="locked_0">正常 </label> -->
<!-- 			</div> -->
<!-- 			<div class="radio radio-inline"> -->
<%-- 				<input id="locked_1" type="radio" name="locked" value="1" <c:if test="${xtresource.resActive==1}">checked</c:if>> --%>
<!-- 				<label for="locked_1">锁定 </label> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="updateDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/authority/xtresource/update',
        data: $('#updateForm').serialize(),
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