package com.xjgc.xjap.authority.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope(value="prototype")
@RequestMapping("/")
public class XtUserRoleController {
	
	//根据用户id,查询该用户未授权的角色和未授权的角色
	public String getRolesByUserId()
	{
		return null;
	}
	
	//根据前端提交的用户ID和已经授权角色，将用户的角色存入数据库
	
}
