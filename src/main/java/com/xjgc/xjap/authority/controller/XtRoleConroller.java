package com.xjgc.xjap.authority.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.authority.entity.XtOrganization;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.service.IXtRoleService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtrole")
public class XtRoleConroller {
	
	@Resource
	private IXtRoleService  xtRoleService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAll(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) throws Exception
	{
		
		XtOrganization xorg =  ((XtUser)request.getSession().getAttribute("currentUser")).getXtOrganization();
		
		String orgId = (xorg != null) ? xorg.getOrgId() : null;
		
		List<XtRole> lists = xtRoleService.getRolesByCondition(orgId, search, sort, order, offset, limit);
		
		Long totalOfRes = xtRoleService.getTotalByCondition(orgId, search);
		
		
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		
		for(XtRole xtRole:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("roleId", xtRole.getRoleId());
			map.put("roleName",xtRole.getRoleName() );
			map.put("role2user", xtRole.getRoleId());
			map.put("role2menu", xtRole.getRoleId());
			
			listMap.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("total", totalOfRes);
		map.put("rows", listMap);
		
		String result = JsonTool.Obj2Json(map);

		System.out.println(result);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/listRoleByResId/{resId}")
	@ResponseBody
	public String getRolesByResId(HttpServletResponse response,
			@PathVariable("resId") String resId) throws Exception
	{
		
		List<XtRole> lists = xtRoleService.getRolesByResId(resId);
		
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		
		for(XtRole xtRole:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("roleId", xtRole.getRoleId());
			map.put("roleName",xtRole.getRoleName());
			
			listMap.add(map);
		}
		
		String result = JsonTool.Obj2Json(listMap);

		System.out.println(result);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/role/index";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/authority/role/create";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void createRole(HttpServletResponse response, XtRole res) {
		
		if(null != res)
		{
			res.setRoleId(UUIDTool.getUUID());
		}
		System.out.println("---");
		xtRoleService.save(res);
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("code", 1);
		map.put("message", "success");
		map.put("data",1);
		
		String result = null;
		result = JsonTool.Obj2Json(map);
		try {
			ResponseUtil.write(response,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(ModelMap modelMap,
    		@PathVariable("id") String id) {
		
		XtRole res = xtRoleService.getRoleById(id);
		
		modelMap.put("xtrole", res);
		
        return "/authority/role/update";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateRole(HttpServletResponse response,XtRole res) {
		
		xtRoleService.update(res);
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("code", 1);
		map.put("message", "success");
		map.put("data",1);
		
		String result = null;
		result = JsonTool.Obj2Json(map);
		try {
			ResponseUtil.write(response,result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.POST)
	@ResponseBody
    public String deleteRole(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		for(int i=0; i<idArray.length;i++)
		{
			xtRoleService.deleteById(idArray[i]);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("code", 1);
		map.put("message", "success");
		map.put("data",1);
		
		String result = null;
		result = JsonTool.Obj2Json(map);
		try {
			ResponseUtil.write(response,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
	
}
