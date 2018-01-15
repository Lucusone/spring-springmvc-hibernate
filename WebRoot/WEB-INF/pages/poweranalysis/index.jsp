<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="currentuserOrg" value="${sessionScope.currentOrg.orgId}"/>
<c:set var="currentuserOrgName" value="${sessionScope.currentOrg.orgName}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>供电能力分析</title>
	<link href="${basePath}/statics/plugins/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${basePath}/statics/css/use_electricity_analysis.css" rel="stylesheet"/>
</head>
<body>

<div class="container-fluid page-background">
	<div class="header-page">
		<div class="row">
		    <div class="col-sm-12 page-title" align="center">
		        <label>供电能力分析</label>
		    </div>
	    </div>
	</div>
	<div class="section">
		<div class="row sum_borders">
		    <div class="col-sm-3">
		      <div class="row row_cell_sum">
		        <label>总供电能力:</label>
		        <input class="input-poweranalysis" type="text" id="power_sum" name="power_sum" readOnly="true">
		        <label>兆瓦</label>
		      </div>
		    </div>
		    <div class="col-sm-3" >
		      <div class="row row_cell_sum">
		        <label>10KV实时总负荷:</label>
		        <input class="input-poweranalysis" type="text" id="10kv_realtime_load" name="10kv_realtime_load" readOnly="true">
		        <label>兆瓦</label>
		      </div>
		    </div>
		    <div class="col-sm-3" >
		      <div class="row row_cell_sum">
		        <label>馈线N-1通过率:</label>
		        <input class="input-poweranalysis" type="text" id="feder_pass_per" name="feder_pass_per" readOnly="true">
		        <label>%</label>
		      </div>
		    </div>
		    <div class="col-sm-3" >
		      <div class="row row_cell_sum">
		        <label>负荷密度:</label>
		        <input class="input-poweranalysis" type="text" id="load_density" name="load_density" readOnly="true">
		        <label>兆瓦/平方公里</label>
		      </div>
		    </div>
		  </div>
	</div>
	<div class="main-page">
		<div class="row" style="height:100%">
		    <div class="col-sm-4" style="height:100%">
		      <div class="row" style="height: 30%">
		       <div class="card-box">
		            <label class="border-title">线路联络分析</label>
		            <div class="row" style="height:100%">
		              <div class="col-sm-7" >
		                <div class="row">
		                  <div class="col-sm-12 card-col1-row" style="margin-top:15px" align="left">
		                    <label>单辐射线路数量:</label>
		                    <input class="card-input-border" type="text" id="single_radiation_line_count" name="single_radiation_line_count" readOnly="true">
		                    <label>条</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-col1-row" align="left">
		                    <label>多分段单联络数量:</label>
		                    <input class="card-input-border" type="text" id="multisegment_single_contact_count" name="multisegment_single_contact_count" readOnly="true">
		                    <label>条</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-col1-row" align="left">
		                    <label>多分段多联络数量:</label>
		                    <input class="card-input-border" type="text" id="multisegment_multi_contact_count" name="multisegment_multi_contact_count" readOnly="true">
		                    <label>条</label>
		                  </div>
		                </div>                
		              </div>
		              <div class="col-sm-5">
		                <div id="line_connect_analysis_pie"></div>
		              </div>
		            </div>
		        </div>
		      </div>
		      <div class="row" style="height: 30%">
		         <div class="card-box">
		              <label class="border-title" style="height:10%">重要用户线路</label>
		              <div class="row" style="height:140px">
			        	<div class="col-sm-3">
			        		<div class="row">
			        			<div class="col-sm-12 card-col1-row" align="left">
			        				<label class="card-col12_1-label">单辐射线路:</label>
			        			</div>
			        		</div>
			        		<div class="row">
			        			<div class="col-sm-12 card-col1-row" align="left">
			        				<label class="card-col12_2-label">联络线路:</label>
			        			</div>
			        		</div>
			        	</div>
			        	<div class="col-sm-9">
			        		<div id="importantuser_line_bar"></div>
			        	</div>
		        	</div>
		         </div>
		      </div>
		       <div class="row" style="height:40%">
		        <div class="card-box">
		        	<label class="border-title" style="height:10%">重要用户电源分析</label>
		        	<div class="row" style="height:190px">
			        	<div class="col-sm-3">
			        		<div class="row">
			        			<div class="col-sm-12 card-col1-row" align="left">
			        				<label class="card-col13_1-label">单电源用户:</label>
			        			</div>
			        		</div>
			        		<div class="row">
			        			<div class="col-sm-12 card-col1-row" align="left">
			        				<label class="card-col13_2-label">双电源用户:</label>
			        			</div>
			        		</div>
			        		<div class="row">
			        			<div class="col-sm-12 card-col1-row" align="left">
			        				<label class="card-col13_3-label">多电源用户:</label>
			        			</div>
			        		</div>
			        	</div>
			        	<div class="col-sm-9">
			        		<div id="importantuser_poweranalysis_bar"></div>
			        	</div>
		        	</div>
		        </div>
		      </div>
		    </div>    
		    <div class="col-sm-5" style="height:100%">
		      <div class="row" style="height:60%">
		        <div class="card-box-2" id="cardbox-col21">
		          <label class="border-title">配网区域负荷密度</label>
		        </div>
		      </div>
		      <div class="row" style="height:40%">
		        <div class="card-box-2">
		          <label class="border-title" style="height:10%">线路联络点分析</label>
		          <div class="row" style="height:90%">
		              <div class="col-sm-8" >
		                <div class="row">
		                  <div class="col-sm-12 card-col2-row" align="left">
		                    <label class="card-box-22-before">非自动化开关:</label>
		                    <input class="card-input-border" type="text" id="non_automatic_switch" name="non_automatic_switch" readOnly="true">
		                    <label>台</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-col2-row" align="left">
		                    <label class="card-box-22-before">挂牌:</label>
		                    <input class="card-input-border" type="text" id="listing" name="listing" readOnly="true">
		                    <label>台</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-col2-row" align="left">
		                    <label class="card-box-22-before">通信异常:</label>
		                    <input class="card-input-border" type="text" id="communication_anomaly" name="communication_anomaly" readOnly="true">
		                    <label>台</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-col2-row" align="left">
		                    <label class="card-box-22-before">就地状态:</label>
		                    <input class="card-input-border" type="text" id="local_status" name="local_status" readOnly="true">
		                    <label>台</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-col2-row" align="left">
		                    <label class="card-box-22-before">设备故障:</label>
		                    <input class="card-input-border" type="text" id="equipment_failure" name="equipment_failure" readOnly="true">
		                    <label>台</label>
		                  </div>
		                </div>                
		              </div>
		          </div>
		        </div>
		      </div>
		    </div>
		    <div class="col-sm-3" style="height:100%">
		      <div class="row" style="height:40%">
		        <div class="card-box-3">
		          <label class="border-title" style="height:10%">线路运行状态</label>
		          <div class="row card-box-3-row-out" style="height:205px">
		          	<div class="col-sm-4">
		          		<div class="row card-box-3-row">
		          			<label>停电线路</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>故障线路</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率100以上</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率70-100%</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率30-70%</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率30%以下</label>
		          		</div>
		          	</div>
		            <div class="col-sm-5">
		            	<div id="line-running-status_bar"></div>
		            </div>
		            <div class="col-sm-3">
		            	<div class="row">
		            		<input class="card-input-noneborder" type="text" id="blackout_line" name="blackout_line" value="600" readOnly="true">
		          			<label id="blackout_line_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="fault_line" name="fault_line" value="500" readOnly="true">
		          			<label id="fault_line_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="line_load_100" name="line_load_100" value="400" readOnly="true">
		          			<label id="line_load_100_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="line_load_70-100" name="line_load_70-100" value="300" readOnly="true">
		          			<label id="line_load_70-100_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="line_load_30-70" name="line_load_30-70" value="200" readOnly="true">
		          			<label id="line_load_30-70_label" style="">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="line_load_30" name="line_load_30" value="100" readOnly="true">
		          			<label id="line_load_30_label">条</label>
		          		</div>
		            </div>
		          </div>
		        </div>
		      </div>
		      <div class="row" style="height:35%">
		        <div class="card-box-3">
		          <label class="border-title" style="height:10%;">配变运行状态</label>
		          <div class="row card-box-3-row-out" style="height:170px;">
		          	<div class="col-sm-4">
		          		<div class="row card-box-3-row">
		          			<label>停电配变</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率100以上</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率70-100%</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率30-70%</label>
		          		</div>
		          		<div class="row card-box-3-row">
		          			<label>负载率30%以下</label>
		          		</div>
		          	</div>
		            <div class="col-sm-5">
		            	<div id="peibian-running-status_bar"></div>
		            </div>
		            <div class="col-sm-3">
		            	<div class="row">
		            		<input class="card-input-noneborder" type="text" id="power_out_distribute" name="power_out_distribute" value="500">
		          			<label id="power_out_distribute_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="peibian_load_100" name="peibian_load_100" value="400">
		          			<label id="peibian_load_100_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="peibian_load_70-100" name="peibian_load_70-100" value="300">
		          			<label id="peibian_load_70-100_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="peibian_load_30-70" name="peibian_load_30-70" value="200">
		          			<label id="peibian_load_30-70_label">条</label>
		          		</div>
		          		<div class="row">
		          			<input class="card-input-noneborder" type="text" id="peibian_load_30" name="peibian_load_30" value="100">
		          			<label id="peibian_load_30_label">条</label>
		          		</div>
		            </div>
		          </div>
		          
		        </div>
		      </div>
		      <div class="row" style="height:25%">
		        <div class="card-box-3">
		          <label class="border-title">线路N-1分析</label>
		           <div class="row">
		              <div class="col-sm-8">
		                <div class="row">
		                  <div class="col-sm-12 card-box-33-row" align="left">
		                    <label>单辐射线路:</label>
		                    <input class="card-input-border" type="text" id="single_radiation_line" name="single_radiation_line">
		                    <label>条</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-box-33-row" align="left">
		                    <label>联络异常:</label>
		                    <input class="card-input-border" type="text" id="contact_abnormal" name="contact_abnormal">
		                    <label>条</label>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-sm-12 card-box-33-row" align="left">
		                    <label>馈线容量不足:</label>
		                    <input class="card-input-border" type="text" id="feder_off_capacity" name="feder_off_capacity">
		                    <label>条</label>
		                  </div>
		                </div>
		             
		              </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
	</div>
</div>

<jsp:include page="/templates/footer.jsp" flush="true"/>

<script>
var line_running_option = {
     tooltip: {
        show:false,
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    grid: {
        left: '0%',
        right: '0%',
        bottom: '0%',
        top:'0%',
    },
    xAxis: {
        show:false,
        type: 'value'
    },
    yAxis: {
    	show:false,
        type: 'category',
        data: ['负载率30%以下','负载率30%-70%','负载率70%-100%','负载率100以上','故障线路','停电线路']
    },
    series: [
        {
            name: '线路运行状态',
            type: 'bar',
            data: [100, 200, 300, 400, 500, 600],
            barWidth: 15,
            itemStyle:{
                normal:{
                    color:'#35ab7fe8'
                }
            },
        }
    ]
};
var peibian_running_option = {
    grid: {
        left: '0%',
        right: '0%',
        bottom: '0%',
        top:'0%',
    },
    xAxis: {
        show:false,
        type: 'value'
    },
    yAxis: {
    	show:false,
        type: 'category',
        data: ['负载率30%以下','负载率30%-70%','负载率70%-100%','负载率100以上','故障线路']
    },
    series: [
        {
            name: '配变运行状态',
            type: 'bar',
            data: [100, 200, 300, 400, 500],
            barWidth: 15,
            itemStyle:{
                normal:{
                    color:'#35ab7fe8'
                }
            },
        }
    ]
};
var importantuser_poweranalysis_option = {
    legend: {
    	x:'left',
    	y:'bottom',
        data: ['同一变电站', '同一母线','同一配电线'],
        itemWidth:10,
        itemGap:15,
        textStyle:{
	        color:'#fff',
	        fontSize:12
	    }
    },
    grid: {
        left: '0%',
        right: '5%',
        bottom: '20%',
        top:'0%'
    },
    xAxis:  {
        type: 'value',
        show:false,
    },
    yAxis: {
        type: 'category',
        data: ['单电源用户','双电源用户','多电源用户'],
        show:false
    },
    series: [
        {
            name: '同一变电站',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'inside'
                }
            },
            data: [320, 302, 301],
            barWidth:20,
        },
        {
            name: '同一母线',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'inside'
                }
            },
            data: [120, 132, 101]
        },
        {
            name: '同一配电线',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'inside'
                }
            },
            data: [220, 182, 191]
        }
        
    ]
};
var importantuser_line_option = {
    legend: {
    	x:'left',
    	y:'bottom',
        data: ['带单个重要用户', '带多个重要用户'],
        itemWidth:10,
        itemGap:15,
        textStyle:{
	        color:'#fff',
	        fontSize:12
	    }
    },
    grid: {
        left: '0%',
        right: '5%',
        bottom: '20%',
        top:'0%'
    },
    xAxis:  {
        type: 'value',
        show:false,
    },
    yAxis: {
        type: 'category',
        data: ['单辐射线路','联络线路'],
        show:false
    },
    series: [
        {
            name: '带单个重要用户',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'inside'
                }
            },
            data: [320, 302],
            barWidth:20
        },
        {
            name: '带多个重要用户',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'inside'
                }
            },
            data: [120, 132],
            barWidth:15
        },
    ]
};
var line_connect_analysis_option = {
    legend: {
        orient: 'horizontal',
        x:'left',
    	y:'bottom',
    	itemWidth:10,
        itemGap:5,
        data: ['单辐射','多分段单联络','多分段多联络'],
        show:false,
    },
    series : [
        {
            name: '线路联络分析',
            type: 'pie',
            radius : '68%',
            center: ['40%', '40%'],
            data:[
                {value:335, name:'单辐射'},
                {value:310, name:'多分段单联络'},
                {value:234, name:'多分段多联络'}
            ],
            label:{
                normal:{
                    show:true,
                    position:'inner', 
                    textStyle : {
                        fontWeight : 150,
                        fontSize : 11
                    },
                    formatter:'{d}%'

                    
                }
            },
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

var line_running_status_bar = echarts.init(document.getElementById('line-running-status_bar'));
var peibian_running_status_bar = echarts.init(document.getElementById('peibian-running-status_bar'));
var importantuser_poweranalysis_bar = echarts.init(document.getElementById('importantuser_poweranalysis_bar'));
var importantuser_line_bar = echarts.init(document.getElementById('importantuser_line_bar'));
var line_connect_analysis_pie = echarts.init(document.getElementById('line_connect_analysis_pie'));

$(function() {
	line_running_status_bar.setOption(line_running_option);
	peibian_running_status_bar.setOption(peibian_running_option);
	importantuser_poweranalysis_bar.setOption(importantuser_poweranalysis_option);
	importantuser_line_bar.setOption(importantuser_line_option);
	line_connect_analysis_pie.setOption(line_connect_analysis_option);
});

function getAjaxData() {
	$.ajax({
		type : "GET",
		url : requestURL,
		async : false,
		cache : false,
		success : function(returnData) {
			//返回数据
		}
	});
}

</script>
</body>
</html>