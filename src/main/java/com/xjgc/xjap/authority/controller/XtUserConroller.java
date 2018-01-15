package com.xjgc.xjap.authority.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.authority.entity.XtDept;
import com.xjgc.xjap.authority.entity.XtOrganization;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.entity.XtUserRole;
import com.xjgc.xjap.authority.service.IXtDeptService;
import com.xjgc.xjap.authority.service.IXtMenuService;
import com.xjgc.xjap.authority.service.IXtOrgService;
import com.xjgc.xjap.authority.service.IXtResourceService;
import com.xjgc.xjap.authority.service.IXtRoleService;
import com.xjgc.xjap.authority.service.IXtUserRoleService;
import com.xjgc.xjap.authority.service.IXtUserService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtuser")
public class XtUserConroller {
	
	@Resource
	private IXtUserService xtuserService;
	
	@Resource
	private IXtRoleService xtRoleService;
	
	@Resource
	private IXtUserRoleService xtUserRoleService;
	
	@Resource
	private IXtOrgService xtOrgService;
	
	@Resource
	private IXtDeptService xtDeptService;
	
	@Resource
	private IXtResourceService xtResourceService;
	
	@Resource
	private IXtMenuService xtMenuService;
	
	@Resource
	private IXtOrgService xtService;
	
	@RequestMapping("/list/{orgId}/{search}")
	@ResponseBody
	public String getAll(HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order,
            @PathVariable("orgId") String orgId,
            @PathVariable("search") String search
            ) throws Exception
	{
		
		System.out.println(orgId);
		System.out.println(search);
		
		System.out.println(offset);
		System.out.println(limit);
		System.out.println(search);
		System.out.println(sort);
		System.out.println(order);
		
//		List<XtUser> lists = xtuserService.findUserByPage(offset, limit);	
//		Long totalOfUsers = xtuserService.getUserTotal();	
		
		XtOrganization xorg =  ((XtUser)request.getSession().getAttribute("currentUser")).getXtOrganization();
		System.out.println(xorg.getOrgId());
	//	String orgId = (xorg != null) ? xorg.getOrgId() : null;
		
		List<XtUser> lists = xtuserService.getUsersByCondition(orgId, search, sort, order, offset, limit);
		Long totalOfUsers = xtuserService.getTotalsByCondition(orgId, search);
	
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		for(XtUser xtUser:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("userId", xtUser.getUserId());
			map.put("userAddr", xtUser.getUserAddr());
			map.put("userEmail", xtUser.getUserEmail());
			map.put("userInvalid", xtUser.getUserInvalid());
			map.put("userName", xtUser.getUserName());
			map.put("userMobile", xtUser.getUserMobile());
			listMap.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("total", totalOfUsers);
		map.put("rows", listMap);
		
		String result = JsonTool.Obj2Json(map);

		System.out.println(result);
		ResponseUtil.write(response, result);
		return null;
	}
	
	//此处没有考虑页面中“公司”-“含下级”的具体含义，
	@RequestMapping("/listByCondition/{orgId}/{userId}/{userName}")
	@ResponseBody
	public String getUsersByCondition(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) throws Exception
	{
		
		List<XtUser> lists = xtuserService.getUserByPage(offset, limit);	
		
		Long totalOfUsers = xtuserService.getUserTotal();	
		
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		for(XtUser xtUser:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("userId", xtUser.getUserId());
			map.put("userAddr", xtUser.getUserAddr());
			map.put("userEmail", xtUser.getUserEmail());
			map.put("userInvalid", xtUser.getUserInvalid());
			map.put("userName", xtUser.getUserName());
			map.put("userMobile", xtUser.getUserMobile());
			listMap.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("total", totalOfUsers);
		map.put("rows", listMap);
		
		String result = JsonTool.Obj2Json(map);

		System.out.println(result);
		ResponseUtil.write(response, result);
		return null;
	}
	
	//此处要分页
	@RequestMapping("/listUserByRoleId/{roleId}")
	@ResponseBody
	public String getUserbyRole(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order,
			@PathVariable("roleId") String roleId) throws Exception
	{
		
		List<XtUser> lists = xtuserService.getUsersByRoleId(roleId,sort,order,offset,limit);
		
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		for(XtUser xtUser:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("userId", xtUser.getUserId());
			map.put("userName", xtUser.getUserName());
			listMap.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("total", xtuserService.getTotalByRoleId(roleId));
		map.put("rows", listMap);
		
		
		String result = JsonTool.Obj2Json(map);

		System.out.println(result);
		ResponseUtil.write(response, result);
		return null;
	}
	
	//新增用户时，弹出公司树
	@RequestMapping(value = "/showOrgTree/", method = RequestMethod.GET)
    public String showOrgTree() {
        return "/authority/user/userorgtree";
    }
	
	//新增用户时，弹出部门树
	@RequestMapping(value = "/showDeptTree/", method = RequestMethod.GET)
    public String showDeptTree() {
        return "/authority/user/userdepttre";
    }
	
	//新增用户时，弹出菜单树
	@RequestMapping(value = "/showMenusTree/", method = RequestMethod.GET)
    public String showMenusTree() {
        return "/authority/user/userrestree";
    }
	
	@RequestMapping(value = "/showUserByRoleId/", method = RequestMethod.GET)
    public String showUserByRoleId() {
        return "/authority/role/selecteduser";
    }

	public static void main(String[] args) throws Exception, Exception, Exception {
		
		List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
		for (int i=0;i<10;i++) {
			
			Map<String,String> maps = new HashMap<String, String>();
			
			maps.put("id", ""+i);
			maps.put("name", "xm"+i);
			
			listMap.add(maps);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(listMap);
		
		System.out.println(result);
		
		System.out.println(UUID.randomUUID().toString().replace("-", "").length());
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/user/index";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
		
		modelMap.put("defaultOrg", xtOrgService.getRootOrganization());
        return "/authority/user/create";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void createUser(HttpServletRequest request,HttpServletResponse response,XtUser xtUser) {
		
		String menuId = request.getParameter("res_Id");
		String deptId = request.getParameter("dept_Id");
		String orgId = request.getParameter("org_Id");
		XtDept dept = xtDeptService.getXtDeptById(deptId);
		
		if(xtUser != null)
		{
			xtUser.setUserId(UUIDTool.getUUID());
			xtUser.setXtDept(dept);
			xtUser.setXtOrganization(xtService.getOrganizationById(orgId));
			xtUser.setXtResource(xtMenuService.getMenu(menuId).getXtResource());
		}
		xtuserService.save(xtUser);
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
		
		System.out.println("--------"+id);
		XtUser user = xtuserService.getUserById(id);
		
		modelMap.put("user", user);
		
        return "/authority/user/update";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
    public void updateUser(HttpServletRequest request,HttpServletResponse response, XtUser xtUser) {
		
		String menuId = request.getParameter("res_Id");
		String deptId = request.getParameter("dept_Id");
		String orgId = request.getParameter("org_Id");
		XtDept dept = xtDeptService.getXtDeptById(deptId);
		
		if(xtUser != null)
		{
			xtUser.setXtDept(dept);
			xtUser.setXtOrganization(xtService.getOrganizationById(orgId));
			if(null != xtMenuService.getMenu(menuId))
			{
				xtUser.setXtResource(xtMenuService.getMenu(menuId).getXtResource());
			}
		}
		
		xtuserService.update(xtUser);
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
    public String deleteUser(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		for(int i=0; i<idArray.length;i++)
		{
			XtUser xtUser = xtuserService.getUserById(idArray[i]);
			xtuserService.delete(xtUser);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	//根据用户id，获得该用户拥有的角色
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String role(@PathVariable("id") String id, ModelMap modelMap) {
        // 所有角色
        List<XtRole> xtRoles = xtRoleService.getAllRole();
        // 用户拥有角色
        List<XtRole> xtUserRoles = xtUserRoleService.getRolesOfUser(id);
        
        modelMap.put("xtRoles", xtRoles);
        modelMap.put("xtUserRoles", xtUserRoles);
        return "/authority/user/role";
    }

    @RequestMapping(value = "/role/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public Object grantRole2User(@PathVariable("userId") String userId, HttpServletRequest request,HttpServletResponse response) {
    	
    	//获得角色列表
        String[] roleIds = request.getParameterValues("roleId");
        
        //根据用户id，先删除userRole表中的和这个id相关的所有数据
        xtUserRoleService.deleteUserRoleByUserId(userId);
        
        for(String roleId : roleIds){
        	XtUserRole xtUserRole = new XtUserRole();
        	XtUser xtUser = xtuserService.getUserById(userId);
        	XtRole xtRole = xtRoleService.getRoleById(roleId);
        	xtUserRole.setRoleUserId(UUID.randomUUID().toString().replace("-", ""));
        	xtUserRole.setXtUser(xtUser);
        	xtUserRole.setXtRole(xtRole);
        	xtUserRoleService.save(xtUserRole);
        }
        Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("code", 1);
		map.put("message", "success");
		map.put("data",1);
		
		String result = JsonTool.Obj2Json(map);
		try {
			ResponseUtil.write(response,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
	
}
