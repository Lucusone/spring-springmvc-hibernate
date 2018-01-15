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

import com.xjgc.xjap.authority.entity.XtMenu;
import com.xjgc.xjap.authority.service.IXtMenuService;
import com.xjgc.xjap.authority.service.IXtResourceService;
import com.xjgc.xjap.authority.service.IXtRoleService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtmenu")
public class XtMenuController {
	
	@Resource
	private IXtMenuService xtMenuService;
	
	@Resource
	private IXtRoleService xtRoleService;
	
	@Resource
	private IXtResourceService xtResourceService;
	
	@RequestMapping("/list/{id}")
	@ResponseBody
	public String getAll(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, value = "") String order,
            @PathVariable("id") String id) throws Exception
	{
		
		List<XtMenu> menus = xtMenuService.getPageMenus(id, offset, limit, sort, order);
		Long totalOfMenus = xtMenuService.getTotalMenus(id);
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		for(XtMenu menu : menus)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", menu.getMenuId());
			map.put("menuName", menu.getMenuName());
			
			map.put("xtMenu", menu.getXtMenu().getMenuId());
			map.put("xtMenuName", menu.getXtMenu().getMenuName());
			
			map.put("menuActive", menu.getMenuActive());
			
			if(null == menu.getXtResource())
			{
				map.put("xtResource", null);
			}
			else
			{
				map.put("xtResource", menu.getXtResource().getResName());
			}
			
			map.put("menuHint", menu.getMenuHint());
			map.put("menuDesc", menu.getMenuDesc());
			map.put("menuIconPath",menu.getMenuIconPath());
			map.put("menuIcon",menu.getMenuIcon());
			map.put("menuIconPathOpen",menu.getMenuIconPathOpen());
			map.put("menuIconOpen",menu.getMenuIconOpen());
			map.put("menuIsnewwindowopen",menu.getMenuIsnewwindowopen());
			map.put("menuOrder",menu.getMenuOrder());
			
			lists.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", totalOfMenus);
		map.put("rows", lists);
		String result = JsonTool.Obj2Json(map);
		System.out.println(result);
		try {
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//获得整棵菜单树
	@RequestMapping(value="/allMenus/",method = RequestMethod.POST)
	@ResponseBody
	public String getMenuTree(HttpServletResponse response,ModelMap modelMap)
	{
		
		String menusTree = xtMenuService.showMenusZTreeByRoleId(null);
		
		System.out.println(menusTree+"-----------");
		
		try {
			ResponseUtil.write(response,menusTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
	@RequestMapping(value="/tree/{roleId}",method = RequestMethod.POST)
	@ResponseBody
	public String getMenuTreeByRoleId(HttpServletResponse response,ModelMap modelMap,
    		@PathVariable("roleId") String roleId)
	{
		
		String menusTree = xtMenuService.showMenusZTreeByRoleId(roleId);
		
		System.out.println(menusTree+"-----------");
		
		modelMap.put("role", xtRoleService.getRoleById(roleId));
		
		try {
			ResponseUtil.write(response,menusTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
	//根据roleId获得该角色关联的菜单树,用于角色权限指派
	@RequestMapping(value = "/menus/{id}", method = RequestMethod.POST)
	@ResponseBody
    public String getMenusByRoleId(HttpServletResponse response,ModelMap modelMap,
    		@PathVariable("id") String id) 
	{
		String menusTree = xtMenuService.getMenusZTreeByRoleId(id);
		System.out.println(menusTree+"-----------");
		modelMap.put("role", xtRoleService.getRoleById(id));
		try {
			ResponseUtil.write(response,menusTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
	
	//根据roleId获得该角色关联的菜单树,用于展示角色对应的权限
		@RequestMapping(value = "/showmenus/{id}", method = RequestMethod.POST)
		@ResponseBody
	    public String showMenusByRoleId(HttpServletResponse response,ModelMap modelMap,
	    		@PathVariable("id") String id) 
		{
			String menusTree = xtMenuService.showMenusByRoleId(id);
			System.out.println(menusTree+"-----------");
			modelMap.put("role", xtRoleService.getRoleById(id));
			try {
				ResponseUtil.write(response,menusTree);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return null;
	    }
	
//	//根据roleId获得该角色关联的菜单树
//	@RequestMapping(value = "/menus/{pId}", method = RequestMethod.POST)
//	@ResponseBody
//    public String getMenusByPId(HttpServletResponse response,ModelMap modelMap,
//    		@PathVariable("id") String id) 
//	{
//		String menusTree = xtMenuService.getMenusZTreeByRoleId(id);
//		System.out.println(menusTree+"-----------");
//		modelMap.put("role", xtRoleService.getRoleById(id));
//		try {
//			ResponseUtil.write(response,menusTree);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        return null;
//    }
//	
	
//	@RequestMapping("/menus")
//	public String rootMenu(String rootMenuName,HttpServletResponse response)
//	{
//		
//		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String,Object> map = new HashMap<String, Object>();
//		
//		map.put("id", 1);
//		map.put("pId",0 );
//		map.put("name", "系统管理");
//		map.put("file", "main");
//		map.put("open", true);
//		list.add(map);
//		
//		for (int i = 0; i < 4; i++) {
//			
//			Map<String,Object> map1 = new HashMap<String, Object>();
//			map1.put("id", "i"+i);
//			map1.put("pId",1);
//			map1.put("name", "系统管理_1");
//			map1.put("file", "main");
//			
//			list.add(map1);
//			
//		}
//		
//		for (int i = 0; i < 4; i++) {
//			
//			Map<String,Object> map1 = new HashMap<String, Object>();
//			map1.put("id", "ii"+i);
//			map1.put("pId","i"+i);
//			map1.put("name", "系统管理_1_");
//			map1.put("file", "main");
//			list.add(map1);
//			
//		}		
//		
//		String result = null;
//		//String result = xtmenuService.getMenus(rootMenuName);
//		try {
//			result = JsonTool.Obj2Json(list);
//			ResponseUtil.write(response, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(result);
//		return null;
//	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/menus/index";
    }
	
	@RequestMapping(value = "/showMenuByRoleId", method = RequestMethod.GET)
    public String showPermByRoleId() {
        return "/authority/role/selectedpermission";
    }
	
	@RequestMapping(value = "/menures", method = RequestMethod.GET)
    public String menures() {
        return "/authority/menus/menures";
    }
	
	@RequestMapping(value = "/resindex", method = RequestMethod.GET)
    public String resindex() {
        return "/authority/resource/resindex";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/authority/menus/create";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void createMenu(HttpServletRequest request,HttpServletResponse response,XtMenu xtMenu) {
		
		String parId = request.getParameter("xtMenu_ParentId");
		String resId = request.getParameter("xtresId");
		
		if(null != xtMenu)
		{
			xtMenu.setMenuId(UUIDTool.getUUID());
			xtMenu.setXtMenu(xtMenuService.getMenu(parId));
			xtMenu.setXtResource(xtResourceService.getResourceById(resId));
		}
		
		xtMenuService.saveMenu(xtMenu);
		
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
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(ModelMap modelMap,
    		@PathVariable("id") String id) {
		
		System.out.println("--------"+id);
		//XtUser user = xtuserService.getUserById(id);
		
		modelMap.put("xtmenu", xtMenuService.getMenu(id));
		
        return "/authority/menus/update";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
    public void updateMenu(HttpServletRequest request,HttpServletResponse response, XtMenu xtMenu) {
		
		String parId = request.getParameter("xtMenu_ParentId");
		String resId = request.getParameter("xtresId");
		
		if(null != xtMenu)
		{
			xtMenu.setXtMenu(xtMenuService.getMenu(parId));
			xtMenu.setXtResource(xtResourceService.getResourceById(resId));
		}
		
		xtMenuService.updateMenu(xtMenu);
		
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
    public String deleteMenu(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		for(int i=0; i<idArray.length;i++)
		{
			xtMenuService.deleteMenuById(idArray[i]);
			//XtUser xtUser = xtuserService.getUserById(idArray[i]);
			//xtuserService.delete(xtUser);
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
	
}
