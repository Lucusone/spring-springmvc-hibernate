<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<div id=detailDialog class="crudDialog" style="height:600px">
	<form id="detailForm" method="post">
        <div class="col-sm-4 text-left inner">
            <p>对应的用户为：</p>
        </div>  
		<table id="tableUser"></table>
	</form>
</div>


<script>
var $tableUser = $('#tableUser');



function  tableUser() {
	// bootstrap table初始化
	$tableUser.bootstrapTable({
		dataType:"json",
		method:"get",
		url: '${basePath}/authority/xtuser/listUserByRoleId/' + roleId,
		height: getHeight(),
		striped: true,
		minimumCountColumns: 2,
		clickToSelect: true,
		detailView: true,
		detailFormatter: 'detailFormatter',
		pagination: true,
		paginationLoop: false,
		sidePagination: 'server',
		silentSort: false,
		smartDisplay: false,
		escape: true,
		idField: 'userId',
		searchOnEnterKey: true,
		maintainSelected: true,
		columns: [
			{field: 'userId', title: '用户ID', align:'center'},
			{field: 'userName', title: '用户名称'}
		]
	});
}
</script>
</body>
</html>