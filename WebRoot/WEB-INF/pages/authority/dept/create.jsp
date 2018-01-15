<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="createDialog" class="crudDialog">
	<form id="createForm" method="post">
		<div class="form-group">
			<label for="deptName">部门名称</label>
			<input id="deptName" type="text" class="form-control" name="deptName" maxlength="20" >
		</div>
		<div class="form-group">
			<label for="deptName1111">上级部门名称</label>
			<input id="deptName1111" type="text" class="form-control" name="deptName1111" maxlength="20"  value="${selectedNodeDept.deptName}" readonly>
		</div>
		<div class="form-group">
			<label for="parId">上级部门Id</label>
			<input id="parId" type="text" class="form-control" name="parId" maxlength="20"  value="${selectedNodeDept.deptId}" readonly>
		</div>
		<div class="form-group">
			<label for=deptTel>部门电话</label>
			<input id="deptTel" type="text" class="form-control" name="deptTel" maxlength="20">
		</div>
		<div class="form-group">
			<label for="deptFax">部门传真</label>
			<input id="deptFax" type="text" class="form-control" name="deptFax" maxlength="50">
		</div>
		<div class="form-group">
			<label for="deptAddr">部门地址</label>
			<input id="deptAddr" type="text" class="form-control" name="deptAddr" maxlength="50">
		</div>
		<div class="form-group">
			<label for="orgName">所属组织</label>
			<input id="orgName" type="text" class="form-control" name="orgName" maxlength="50"  value="${selectedNodeDept.xtOrganization.orgName}" readonly>
		</div>
		<div class="form-group">
			<label for="orgId">所属组织ID</label>
			<input id="orgId" type="text" class="form-control" name="orgId" maxlength="50"  value="${selectedNodeDept.xtOrganization.orgId}" readonly>
		</div>
<!-- 		<div class="radio"> -->
<!-- 			<div class="radio radio-inline radio-success"> -->
<!-- 				<input id="locked_0" type="radio" name="orgIsinvalid" value="0" checked> -->
<!-- 				<label for="locked_0">正常 </label> -->
<!-- 			</div> -->
<!-- 			<div class="radio radio-inline"> -->
<!-- 				<input id="locked_1" type="radio" name="orgIsinvalid" value="1"> -->
<!-- 				<label for="locked_1">锁定 </label> -->
<!-- 			</div> -->
<!-- 		</div> -->
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
        url: '${basePath}/authority/xtdept/create',
        data: $('#createForm').serialize(),
        dataType:'json',
        beforeSend: function() {
            if ($('#deptId').val() == '') {
                $('#deptId').focus();
                return false;
            }
            if(isNull($('#deptName1111').val())){
	            $('#deptName1111').focus();
	            errorInput("输入正确的部门名称！");
	            return false;
            }
            if(!isTel($('#deptTel').val())){
	            $('#deptTel').focus();
	            errorInput("请输入正确电话格式！");
	            return false;
            }
            if(!isTel($('#deptFax').val())){
	            $('#deptFax').focus();
	            errorInput("请输入正确电话格式！");
	            return false;
            }
            if(!isAddr($('#deptAddr').val())){
	            $('#deptAddr').focus();
	            errorInput("请输入正确地址，大于3字符！");
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