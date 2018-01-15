<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<div id=detailDialogPer class="crudDialog" style="height:600px">
	<form id="detailFormPer" method="post">
        <div>
            <p>对应的权限为：</p>
            <ul id="menuztree" class="ztree"></ul>
        </div>
	</form>
</div>

<script>
var $menuztree = $('#menuztree');



var setting = {

	check: {
		enable: false,
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
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("menuztree");
		},
// 		onAsyncSuccess: zTreeOnAsyncSuccess
	}
};
function initTree() {
	$.fn.zTree.init($('#menuztree'), setting); 
}

</script>
</body>
</html>