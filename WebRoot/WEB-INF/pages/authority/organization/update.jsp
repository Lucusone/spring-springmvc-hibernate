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
			<label for="orgId">公司ID</label>
			<input id="orgId" type="text" class="form-control" name="orgId" maxlength="20" value="${xtorganization.orgId}" readonly>
		</div>
		<div class="form-group">
			<label for="orgName">公司名称</label>
			<input id="orgName" type="text" class="form-control" name="orgName" maxlength="20" value="${xtorganization.orgName}">
		</div>
		<div class="form-group">
			<label for="orgName1111">上级公司名称</label>
			<input id="orgName1111" type="text" class="form-control" name="orgName1111" maxlength="20"  value="${parXtorg.orgName}" readonly>
		</div>
		<div class="form-group">
			<label for="parId">上级公司Id</label>
			<input id="parId" type="text" class="form-control" name="parId" maxlength="20"  value="${parXtorg.orgId}" readonly>
		</div>		
		<div class="form-group">
			<label for=orgTel>电话</label>
			<input id="orgTel" type="text" class="form-control" name="orgTel" maxlength="20" value="${xtorganization.orgTel}">
		</div>
		<div class="form-group">
			<label for="orgFax">传真</label>
			<input id="orgFax" type="text" class="form-control" name="orgFax" maxlength="50" value="${xtorganization.orgFax}">
		</div>
		<div class="form-group">
			<label for="orgPostcode">邮编</label>
			<input id="orgPostcode" type="text" class="form-control" name="orgPostcode" maxlength="50" value="${xtorganization.orgPostcode}">
		</div>
		<div class="form-group">
			<label for="orgEmail">邮箱</label>
			<input id="orgEmail" type="text" class="form-control" name="orgEmail" maxlength="50" value="${xtorganization.orgEmail}">
		</div>
		<div class="form-group">
			<label for="orgAddress">地址</label>
			<input id="orgAddress" type="text" class="form-control" name="orgAddress" maxlength="50" value="${xtorganization.orgAddress}">
		</div>
		<div class="form-group">
			<label for="orgWebsite">主页</label>
			<input id="orgWebsite" type="text" class="form-control" name="orgWebsite" maxlength="50" value="${xtorganization.orgWebsite}">
		</div>
		<div class="form-group">
			<label for="orgCode">编码</label>
			<input id="orgCode" type="text" class="form-control" name="orgCode" maxlength="50" value="${xtorganization.orgCode}">
		</div>
		<div class="radio">
			<div class="radio radio-inline radio-success">
				<input id="locked_0" type="radio" name="locked" value="0" <c:if test="${xtorg.orgIsinvalid==0}">checked</c:if>>
				<label for="locked_0">正常 </label>
			</div>
			<div class="radio radio-inline">
				<input id="locked_1" type="radio" name="locked" value="1" <c:if test="${xtorg.orgIsinvalid==1}">checked</c:if>>
				<label for="locked_1">锁定 </label>
			</div>
		</div>
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
        url: '${basePath}/authority/xtorg/update',
        data: $('#updateForm').serialize(),
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