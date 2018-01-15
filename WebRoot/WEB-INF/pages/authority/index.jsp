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
	<title>权限管理系统</title>

	<link href="${basePath}/statics/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
	<link href="${basePath}/statics/plugins/tether-1.3.3/dist/css/tether.min.css" rel="stylesheet"/>
	<link href="${basePath}/statics/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${basePath}/statics/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="${basePath}/statics/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="${basePath}/statics/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
	<link href="${basePath}/statics/css/admin.css" rel="stylesheet"/>
	<style>
	/** skins **/
	#zheng-upms-server #header {background: #29A176;}
	#zheng-upms-server .content_tab{background: #29A176;}
	#zheng-upms-server .s-profile>a{background: url(${basePath}/statics/images/zheng-upms.png) left top no-repeat;}
	
	</style>
</head>
<body>
<header id="header">
	<ul id="menu">
		<li id="logo">
			<a href="${basePath}/authority/index">
				<img src="${basePath}/statics/images/logo.png"/>
			</a>
			<span id="system_title">权限管理系统</span>
		</li>
		<li class="pull-right">
			<ul class="hi-menu">
				<li class="dropdown">
					<a class="waves-effect waves-light" style="font-size:20px;" data-toggle="dropdown" href="javascript:;">
						${currentUser.userName} <i class="him-icon zmdi zmdi-more-vert"></i>
					</a>
					<ul class="dropdown-menu dm-icon pull-right">
						<li class="hidden-xs">
							<a class="waves-effect" data-ma-action="fullscreen" href="javascript:fullPage();"><i class="zmdi zmdi-fullscreen"></i> 全屏模式</a>
						</li>
						<li>
							<a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-account"></i> 密码设置</a>
						</li>
						<li>
							<a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-settings"></i> 系统设置</a>
						</li>
						<li>
							<a class="waves-effect" href="${basePath}/sso/logout"><i class="zmdi zmdi-run"></i> 退出登录</a>
						</li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
</header>
<section id="main">
	<aside id="hiddenbar" style="display:none"></aside>
	<!-- 左侧导航区 -->
	<aside id="sidebar">
		<div id="guide" class="s-profile">
			<a class="waves-effect waves-light">
				<label style="font-size:16px;color:white;margin:10px 0 0 80px">菜单导航</label>
				<div class="line-wrap pull-right">
					<div class="line top"></div>
					<div class="line center"></div>
					<div class="line bottom"></div>
				</div>
			</a>
		</div>
	
		<ul id="main-menu" class="main-menu">
			<li>
				<a class="waves-effect" style="height:35px;"" href="javascript:Tab.addTab('首页', 'home');"><i class="zmdi zmdi-home"></i> 首页</a>
			</li>
		</ul>
		<ul class="main-menu">
			<li>
				<div class="upms-version">
					&copy; XJAP V1.0.0
				</div>
			</li>
		</ul>
	</aside>
	<!-- /左侧导航区 -->
	<section id="content">
		<div class="content_tab">
			<div class="tab_left">
				<a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
			</div>
			<div class="tab_right">
				<a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
			</div>
			<ul id="tabs" class="tabs">
				<li id="tab_home" data-index="home" data-closeable="false" class="cur">
					<a class="waves-effect waves-light">首页</a>
				</li>
			</ul>
		</div>
		<div class="content_main">
			<div id="iframe_home" class="iframe cur">
				<p><b>系统简介</b>：本系统是基于RBAC授权和基于用户授权的细粒度权限控制通用平台，并提供单点登录、会话管理和日志管理。接入的系统可自由定义组织、角色、权限、资源等。</p><br/>
				<p><h4>系统功能概述：</h4></p>
				<p><b>系统组织管理</b>：系统和组织增加、删除、修改、查询功能。</p>
				<p><b>用户角色管理</b>：用户和角色增加、删除、修改、查询功能。</p>
				<p><b>资源权限管理</b>：资源和权限增加、删除、修改、查询功能。</p>
				<p><b>权限分配管理</b>：提供给角色和用户的权限增加、删除、修改、查询功能。</p>
				<p><b>单点登录(SSO)</b>：提供统一用户单点登录认证、用户鉴权功能。</p>
				<p><b>操作日志管理</b>：提供记录用户登录、操作等日志。</p><br/>
				<p><h4>对外接口概述：</h4></p>
				<p><b>系统组织数据接口</b>、<b>用户角色数据接口</b>、<b>资源权限数据接口</b>、<b>单点登录(SSO)接口</b>、<b>用户鉴权接口</b></p><br/>
			</div>
		</div>
	</section>
</section>
<footer id="footer"></footer>

<script src="${basePath}/statics/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/statics/plugins/tether-1.3.3/dist/js/tether.min.js"></script>
<script src="${basePath}/statics/plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${basePath}/statics/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${basePath}/statics/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${basePath}/statics/plugins/BootstrapMenu.min.js"></script>
<script src="${basePath}/statics/plugins/device.min.js"></script>
<script src="${basePath}/statics/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${basePath}/statics/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="${basePath}/statics/plugins/jquery.cookie.js"></script>
<script src="${basePath}/statics/js/admin.js"></script>
<script src="${basePath}/statics/js/common.js"></script>
<script>var BASE_PATH = '${basePath}';</script>
<script>
$(function(){
	var currentUserId = "${currentUser.userId}";
	getMenu(currentUserId);
});
</script>

</body>
</html>