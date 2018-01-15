<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="currentuserOrg" value="${sessionScope.currentOrg.orgId}"/>
<c:set var="currentuserOrgName" value="${sessionScope.currentOrg.orgName}"/>
<div id="createDialog" class="crudDialog">
	<form id="createForm" method="post">
		<div class="form-group">
			<label for="userName">用户名称</label>
			<input id="userName" type="text" class="form-control" name="userName" maxlength="20">
		</div>
		<div class="form-group">
			<label for="userPassword">用户密码</label>
			<input id="userPassword" type="text" class="form-control" name="userPassword" maxlength="32">
		</div>
		<div class="form-group">
			<label for="userxtres">首选功能</label>
			<input id="userxtres" type="text" class="form-control" name="userxtres">
			<input id="res_Id" type="text" class="form-control" name="res_Id" maxlength="20" style="display:none">
		</div>
		<div class="form-group">
			<label for="userxtorg">所属公司</label>
			<input id="userxtorg" type="text" class="form-control" name="userxtorg" value="${currentOrg.orgName}" >
			<input id="org_Id" type="text" class="form-control" name="org_Id" maxlength="20" style="display:none" value="${currentOrg.orgId}" >
		</div>
		<div class="form-group">
			<label for="userxtdept">所属部门</label>
			<input id="userxtdept" type="text" class="form-control" name="userxtdept">
			<input id="dept_Id" type="text" class="form-control" name="dept_Id" maxlength="20" style="display:none">
		</div>
		<div class="form-group">
			<label for=userMobile>电话</label>
			<input id="userMobile" type="text" class="form-control" name="userMobile" maxlength="20">
		</div>
		<div class="form-group">
			<label for="userEmail">邮箱</label>
			<input id="userEmail" type="text" class="form-control" name="userEmail" maxlength="50">
		</div>
		<div class="form-group">
			<label for="userAddr">地址</label>
			<input id="userAddr" type="text" class="form-control" name="userAddr" maxlength="50">
		</div>
		<div class="radio">
			<div class="radio radio-inline radio-success">
				<input id="locked_0" type="radio" name="userInvalid" value="0" checked>
				<label for="locked_0">正常 </label>
			</div>
			<div class="radio radio-inline">
				<input id="locked_1" type="radio" name="userInvalid" value="1">
				<label for="locked_1">锁定 </label>
			</div>
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">返回</a>
		</div>
	</form>
</div>
<script>

$(function() {
	selectedOrgName = document.getElementById('userxtorg').value;
	selectedOrgId = document.getElementById('org_Id').value;
})

var userdeptDialog;
$('#userxtdept').click(function() {
    userdeptDialog = $.dialog({
		animationSpeed: 300,
		title: '请选择所属部门',
		//columnClass: 'col-sm-12',
		content: 'url:${basePath}/authority/xtuser/showDeptTree/',
		onContentReady: function () {
			initdeptTree(document.getElementById('org_Id').value,setxtDept);
		}
	});
});

var userorgDialog;
$('#userxtorg').click(function() {
    userorgDialog = $.dialog({
		animationSpeed: 300,
		title: '请选择所属公司',
		//columnClass: 'col-sm-12',
		content: 'url:${basePath}/authority/xtuser/showOrgTree/',
		onContentReady: function () {
			initorgTree('${currentuserOrg}','${currentuserOrgName}',setxtOrganization);
		}
	});
});

function setxtDeptnull()
{
	$("#userxtdept").val("");
	$("#dept_Id").val("");
};

var userresDialog;
$('#userxtres').click(function() {
    userresDialog = $.dialog({
		animationSpeed: 300,
		title: '首选功能',
		//columnClass: 'col-sm-12',
		content: 'url:${basePath}/authority/xtuser/showMenusTree/',
		onContentReady: function () {
			initresTree(setxtResource);
		}
	});
});

function setxtResource(resName,res_Id)
{
	$("#userxtres").val(resName);
	$("#res_Id").val(res_Id);
}

function setxtOrganization(orgName,orgId)
{
	$("#userxtorg").val(orgName);
	$("#org_Id").val(orgId);
}

function setxtDept(deptName,deptId)
{
	$("#userxtdept").val(deptName);
	$("#dept_Id").val(deptId);
}


function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/authority/xtuser/create',
        data: $('#createForm').serialize(),
        dataType:'json',
        beforeSend: function() {
            if ($('#userName').val() == '') {
                $('#userName').focus();
                errorInput("用户名不能为空");
                return false;
            }
            if ($('#userPassword').val() == '' || $('#userPassword').val().length < 5) {
                $('#userPassword').focus();
                errorInput("密码不能为空且大于5位！");
                return false;
            }
            if ($('#userMobile').val() == '' || !(isTel($('#userMobile').val()))) {
                $('#userMobile').focus();
                errorInput("请输入正确的电话格式");
                return false;
            }
            if(!(isEmail($('#userEmail').val()))){
              	$('#userEmail').focus();
              	errorInput("请输入正确的邮编格式！");
            	return false;
            }	
            if(isNull($('#userAddr').val())){
            	$('#userAddr').focus();
            	errorInput("请输入正确地址，大于3字符");
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