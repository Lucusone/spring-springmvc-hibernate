package com.xjgc.xjap.authority.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority")
public class AuthorityController {

	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String ss(ModelMap modelMap)
	{
		return "/authority/index";
	}
}
