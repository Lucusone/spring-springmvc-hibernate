<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>组织容器</title>
	<jsp:include page="/templates/head.jsp" flush="true"/>
</head>
<body>
<div id="main"> 
	<div class="col-sm-3">
		<div class="form-group">
			<ul id="ztree" class="ztree"></ul>
		</div>
	</div>
	<div class="col-sm-9">
		<table id="table"></table>
		<table id="bktable"></table>
		<div class="row">
			<div class="col-sm-6">
				<div id="chartbar" style="width:400px;height:400px;"></div>
			</div>
			<div class="col-sm-6">
				<div id="chartpie" style="width:400px;height:400px;"></div>
			</div>
			
		</div>
		
	</div>
</div>
<jsp:include page="/templates/footer.jsp" flush="true"/>
<script>
var $table = $('#table');
var $bktable = $('#bktable');
var barChart = echarts.init(document.getElementById('chartbar'));
var pieChart = echarts.init(document.getElementById('chartpie'));

var setting = {
	check: {
		enable: false,
	},
	async: {
		enable: true, //设置启用异步加载
		url: '${basePath}/powerres/restree/',
	},
	data: {
		simpleData: {
			enable: true //设置启用简单数据格式,还可以设置简单数据格式的属性名,idKey,pidKey
		}
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("ztree");
			var node_id = node.id;
			var ids_type = node_id.split('_');
			var ids = ids_type[0];
			var type = ids_type[1];
			switch (type)
			{
				case 'ROOT':
				  getTableData('${basePath}/powerres/listcompany');
				  break;	
				case 'COM':
				  getTableData('${basePath}/powerres/listdistrict/'+ids);
				  break;
				case 'DIS':
				  getTableData('${basePath}/powerres/liststation/'+ids);
				  break;
				case 'FDROOT':
				  getTableData('${basePath}/powerres/listfeeder/'+ids);
				  break;
				case 'ST':
				  getTableData('${basePath}/powerres/listfeeder/'+ids);
				  break;
				case 'BKROOT':
				  getTableData('${basePath}/powerres/listbay/'+ids);
				  break;
				case 'BY':
				  //getTableData('${basePath}/powerres/listbreak/'+ids);
				  break;
				case 'FD':
				  getFDTableData('${basePath}/powerres/listbreak/'+ids);
				  //getpie(0.3);
				  break;
				case 'BK':
				  //getbkdata(ids);
				  break;
			}
			ids = null;
			type = null;
			$table.bootstrapTable('refresh');
		}
	}
};

function getTableData(url_cli){
	disposeChart();
	$table.bootstrapTable('destroy');
	$bktable.bootstrapTable('destroy');
	$table.bootstrapTable({
		dataType:"json",
		method:"post",
		url: url_cli,
		sidePagination:"server",
		height: getHeight(),
		striped: true,
		search: true,
		showRefresh: true,
		showColumns: true,
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
		idField: 'id',
		searchOnEnterKey: true,
		maintainSelected: true,
		columns: [
			{field: 'id', title: '设备ID', align:'center'},
			{field: 'name', title: '设备名称', align:'center'}
		]
	});
}

function getFDTableData(url_cli){
	disposeChart();
	$table.bootstrapTable('destroy');
	$bktable.bootstrapTable('destroy');
	$bktable.bootstrapTable({
		dataType:"json",
		method:"post",
		url: url_cli,
		sidePagination:"server",
		//height: getHeight(),
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
		idField: 'id',
		uniqueId: 'id',
		searchOnEnterKey: true,
		maintainSelected: true,
		columns: [
			{field: 'id', title: '设备ID', align:'center'},
			{field: 'name', title: '设备名称', align:'center'},
			{field: 'A', title: 'A相电流', align:'center'},
			{field: 'B', title: 'B相电流', align:'center'},
			{field: 'C', title: 'C相电流', align:'center'},
			{field: 'Balance', title: '三相不平衡率', align:'center'},
			{field: 'percentBal', title: '三相不平衡率', align:'center',visible:false}
			
		]
	});
	//alert($bktable.rows);
}

function getbar(current_value){
	barChart = echarts.init(document.getElementById('chartbar'));
    var optionbar={
        //定义一个标题
        title:{
            text:'三相电流'
        },
        legend:{
            data:['电流值']
        },
        //X轴设置
        xAxis:{
            data:['A相电流','B相电流','C相电流']
        },
        yAxis:{
        },
        //name=legend.data的时候才能显示图例
        series:[{
            name:'电流值',
            type:'bar',
            data:current_value
        }]

    };
    barChart.setOption(optionbar);
}

function getpie(per){
	pieChart = echarts.init(document.getElementById('chartpie'));
	var optionpie = {
    title : {
        text: '三相不平衡率',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['直接访问','邮件营销']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name:'',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:per, name:'大于50%'},
                {value:1-per, name:'不大于50%'},
            ]
        }
    ]
};
pieChart.setOption(optionpie);
}

function disposeChart(){
	barChart.dispose();
	pieChart.dispose();
}

function initTree() {
	$.fn.zTree.init($('#ztree'), setting);
}

$(function() {
	initTree();
	// bootstrap table初始化
	getTableData('${basePath}/powerres/listcompany');
	
	$('#bktable').on("click-row.bs.table", function(e, row, $element){
		var curr_values = [row.A, row.B, row.C];
		getpie(row.percentBal);
		getbar(curr_values);
	});
	$('#bktable').on("load-success.bs.table", function(data){
		var alldata = $bktable.bootstrapTable('getData');
		if(alldata.length > 0){
			var curr_values = [alldata[0].A, alldata[0].B, alldata[0].C];
			getpie(alldata[0].percentBal);
			getbar(curr_values);
		}
	});
});

</script>
</body>
</html>