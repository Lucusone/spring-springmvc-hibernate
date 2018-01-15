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
			<label for="orgName">公司名称</label>
			<input id="orgName" type="text" class="form-control" name="orgName" maxlength="20">
		</div>
		<div class="form-group">
			<label for="orgName1111">上级公司名称</label>
			<input id="orgName1111" type="text" class="form-control" name="orgName1111" maxlength="20"  value="${selectedNodeOrg.orgName}" readonly>
		</div>
		<div class="form-group">
			<label for="parId">上级公司Id</label>
			<input id="parId" type="text" class="form-control" name="parId" maxlength="20"  value="${selectedNodeOrg.orgId}" readonly>
		</div>		
		<div class="form-group">
			<label for=orgTel>电话</label>
			<input id="orgTel" type="text" class="form-control" name="orgTel" maxlength="20">
		</div>
		<div class="form-group">
			<label for="orgFax">传真</label>
			<input id="orgFax" type="text" class="form-control" name="orgFax" maxlength="50">
		</div>
		<div class="form-group">
			<label for="orgPostcode">邮编</label>
			<input id="orgPostcode" type="text" class="form-control" name="orgPostcode" maxlength="50">
		</div>
		<div class="form-group">
			<label for="orgEmail">邮箱</label>
			<input id="orgEmail" type="text" class="form-control" name="orgEmail" maxlength="50">
		</div>
		<div class="form-group">
			<label for="orgAddress">地址</label>
			<input id="orgAddress" type="text" class="form-control" name="orgAddress" maxlength="50">
		</div>
		<div class="form-group">
			<label for="orgWebsite">主页</label>
			<input id="orgWebsite" type="text" class="form-control" name="orgWebsite" maxlength="50">
		</div>
		<div class="form-group">
			<label for="orgCode">编码</label>
			<input id="orgCode" type="text" class="form-control" name="orgCode" maxlength="50">
		</div>
		<div class="radio">
			<div class="radio radio-inline radio-success">
				<input id="locked_0" type="radio" name="orgIsinvalid" value="0" checked>
				<label for="locked_0">正常 </label>
			</div>
			<div class="radio radio-inline">
				<input id="locked_1" type="radio" name="orgIsinvalid" value="1">
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
        url: '${basePath}/authority/xtorg/create',
        data: $('#createForm').serialize(),
        dataType:'json',
        beforeSend: function() {
            if ($('#orgId').val() == '') {
                $('#orgId').focus();
                
                return false;
            }
            if(isNull($('#orgName').val())){
                $('#orgName').focus();
                errorInput("公司名称不能为空！");
                return false;            
            }
            if(isNull($('#orgName1111').val())){
                $('#orgName1111').focus();
                 errorInput("所属公司不能为空！");
                return false;            
            }
            if(!isTel($('#orgTel').val())){
                $('#orgTel').focus();
                errorInput("请输入正确的电话格式！");
                return false;            
            }
            if(!isTel($('#orgFax').val())){
                $('#orgFax').focus();
                errorInput("请输入正确的传真格式！");
                return false;            
            } 
            if(!isCode($('#orgPostcode').val())){
                $('#orgPostcode').focus();
                 errorInput("请输入正确的邮编格式！");
                return false;            
            }
            if(!isEmail($('#orgEmail').val())){
                $('#orgEmail').focus();
                 errorInput("请输入正确的email格式！");
                return false;            
            }
            if(!isAddr($('#orgAddress').val())){
                $('#orgAddress').focus();
                 errorInput("请输入正确的地址，大于3字符！");
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