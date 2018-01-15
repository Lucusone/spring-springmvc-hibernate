<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<div id="userorgDialog" class="crudDialog" style="height:450px">
	<form id="userorgForm" method="post">
		<div class="row">
			<div class="col-sm-12">
				
				<div class="form-group">
					<div class="fg-line">
						<ul id="userorgztree" class="ztree" style="height:380px;overflow-y :scroll;"></ul>
					</div>
				</div>
				
				<div class="form-group pull-right">
					<a class="btn btn-success waves-light" href="javascript:;" onclick="userorgSubmit();">保存</a>
					<a class="btn btn-default waves-light" href="javascript:;" onclick="userorgDialog.close();">取消</a>
				</div>
			</div>
		</div>
	</form>
</div>

<script>

var userorgId = null;
var userorgName = null;
var callbackFunction;

function initorgTree(orgId,orgName,func) {
	callbackFunction = func;
	var org_setting = {
		check: {
			enable: false,
		},
		async: {
			enable: true, //设置启用异步加载
			url: '${basePath}/authority/xtorg/orgTree/',
			autoParam:["id"]
		},
		data: {
			simpleData: {
				enable: true, //设置启用简单数据格式,还可以设置简单数据格式的属性名,idKey,pidKey
				idKey:"id",
				pIdKey:"pId"
			}
		},
		callback: {
			beforeClick:function(treeId,treeNode){ 
				var zTree = $.fn.zTree.getZTreeObj("userorgztree");
				userorgName = treeNode.name;
				userorgId = treeNode.id; 
	            if(treeNode.isParent){  
	                zTree.expandNode(treeNode);  
	                return true;  
	            }  
	            return false;  
	        }  
		}
	};

	$.fn.zTree.init($('#userorgztree'), org_setting,[{
		'id':orgId,
		'name':orgName,
		'isParent':true
	}]);
}

function userorgSubmit() {
	if (userorgId == null) {
		$.confirm({
			title: false,
			content: '请选择一个公司!',
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
		if((callbackFunction != null) && (typeof callbackFunction == 'function')){
			callbackFunction(userorgName,userorgId);
		}
		userorgDialog.close();
	}
}

</script>