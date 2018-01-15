$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 数据表格动态高度
//	$(window).resize(function () {
//		$('#table').bootstrapTable('resetView', {
//			height: getHeight()
//		});
//	});
	// 设置input特效
	$(document).on('focus', 'input[type="text"]', function() {
		$(this).parent().find('label').addClass('active');
	}).on('blur', 'input[type="text"]', function() {
		if ($(this).val() == '') {
			$(this).parent().find('label').removeClass('active');
		}
	});
	// 设置input的number特效
	$(document).on('focus', 'input[type="number"]', function() {
		$(this).parent().find('label').addClass('active');
	}).on('blur', 'input[type="number"]', function() {
		if ($(this).val() == '') {
			$(this).parent().find('label').removeClass('active');
		}
	});
	// select2初始化
	$('select').select2();
});
// 动态高度
function getHeight() {
	return $(window).height() - 20;
}
// 数据表格展开内容
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
}
// 初始化input特效
function initMaterialInput() {
	$('form input[type="text"]').each(function () {
		if ($(this).val() != '') {
			$(this).parent().find('label').addClass('active');
		}
	});
	$('form input[type="number"]').each(function () {
		if ($(this).val() != '') {
			$(this).parent().find('label').addClass('active');
		}
	});
}

//判断是否是电话号码
function isTel(str){
	var reg=/^([0-9]|[\-])+$/g;
	if(str.length<7 || str.length>18){
		return false;
	}
	else{
		return reg.exec(str);
	}
}
//判断是否为空
function isNull(strval){
	if(strval !== ''){
		return false;
	}
	return true;
}

//判断是否是正确的email地址
function isEmail(obj){  
	var pattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;  
	if(!isNull(obj)){
		return pattern.test(obj);
	} 
	else{
		return false; 
	}	 
}

//判断有效地址
function isAddr(addr){
	if(isNull(addr)||addr.length<5){
//		alert(addr+"in addr");
		return false;
	}
	return true;
}

//判断有效邮编
function isCode(code){
	var res= /^[1-9][0-9]{5}$/;
	if(!isNull(code)){
		return res.test(code);
	}
	else return false;
	
}
//异常输入提醒
function errorInput(value){
	$.confirm({
		theme: 'dark',
		animation: 'rotateX',
		closeAnimation: 'rotateX',
		title: false,
		content:value,
		buttons: {
			confirm: {
				text: '关闭',
				btnClass: 'waves-effect waves-button waves-light'
			}
		}
	});
}

//折叠展开
function collapse_in_out() {
	if($('#treepanel').hasClass("in")){
		$('#treepanel').removeClass("in col-sm-2");
		$('#tablepanel').removeClass("col-sm-10");
		$('#tablepanel').addClass("col-sm-12");
		$('#a_left_right').html('<i class="fa fa-toggle-right"></i>展开');
	}
	else {
		$('#treepanel').addClass("in in col-sm-2");
		$('#tablepanel').removeClass("col-sm-12");
		$('#tablepanel').addClass("col-sm-10");
		$('#a_left_right').html('<i class="fa fa-toggle-left"></i>折叠');
	}
	$table.bootstrapTable('refresh');
}

//--无极菜单
function breadthFirstTravel(jsontree) {
  var queue = new Array();
  queue.unshift(jsontree);
  queue.unshift('levelflag');
  var level = 1;
  while(queue.length){
    var front = queue.pop();
    if(front == 'levelflag'){
      level++;
      if(queue.length){
        queue.unshift('levelflag');
      }else{
        break;
      }
    }
    else
    {
      front.level = level;
      var children = front.children;
      if(children && children.length){
        for(var i = 0; i < children.length; i++){
          queue.unshift(children[i]);
        }
      }
    }
  }
  return jsontree;
}

function generateMenu(node,ul){
	var li;
	if(node.url){
		li = $(["<li><a class=\"waves-effect\" style=\"padding-left:"+(50+10*node.level)+"px;height:30px\" href=\"javascript:Tab.addTab('"+node.name+"', '"+node.url+"');\">"+node.name+"</a></li>"].join("")).appendTo(ul);	
	}else if(node.level == 1){
		li = $(["<li class=\"sub-menu toggled system_menus system_1 1\">" + 
                    "<a class=\"waves-effect\" style=\"padding-left:"+(50+10*node.level)+"px;height:35px\" href=\"javascript:;\"><i class=\"zmdi zmdi-collection-plus\"></i> "+node.name+"</a>" + 
                    "</li>"].join("")).appendTo(ul);
	}else{
		li = $(["<li class=\"sub-menu system_menus system_1 1\">" + 
                    "<a class=\"waves-effect\" style=\"padding-left:"+(50+10*node.level)+"px;height:35px\" href=\"javascript:;\"><i class=\"zmdi zmdi-collection-plus\"></i> "+node.name+"</a>" + 
                    "</li>"].join("")).appendTo(ul);
	}

	var children = node.children;
	if(children && children.length) {
		for(var i = 0; i < children.length; i++){
			ul = $("<ul></ul>").appendTo(li); 
			generateMenu(children[i],ul);
		}
	}
}

function getMenu(userId) {
	$.ajax({
		url: BASE_PATH + '/authority/xtmenu/refreshMenu/'+userId,
		type: 'POST',
		dataType:"json",
		data: {},
		success: function(json){
			if (json.code == 1) {
				var menulevel = breadthFirstTravel(json.data);
				generateMenu(menulevel,$("#main-menu"));
			} else {
				if (0 == json.code) {
					alert(json.data);
				}
			}
		},
		error: function(error){
			console.log(error);
		}
	});
}
//--无极菜单

function deleteAction(content,url,inittree) {
	deleteDialog = $.confirm({
		type: 'red',
		animationSpeed: 300,
		title: false,
		content: content,
		buttons: {
			confirm: {
				text: '确认',
				btnClass: 'waves-effect waves-button',
				action: function () {
					$.ajax({
						type: 'post',
						url: url,
						dataType:'json',
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
								deleteDialog.close();
								if( (inittree != null) && (typeof inittree == 'function')){
									inittree();
								}
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
			},
			cancel: {
				text: '取消',
				btnClass: 'waves-effect waves-button'
			}
		}
	});
}
