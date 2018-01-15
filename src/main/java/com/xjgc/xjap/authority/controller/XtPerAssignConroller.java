package com.xjgc.xjap.authority.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.authority.entity.XtResource;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.service.IXtPermAssignService;
import com.xjgc.xjap.authority.service.IXtRoleService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtperAssign")
public class XtPerAssignConroller {
	
	@Resource
	private IXtPermAssignService xtPermAssignService;
	
	@Resource
	private IXtRoleService xtRoleService;
	
	//根据roleId，获得Role对象
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String getRole(@PathVariable("id") String id, ModelMap modelMap) {
       
       XtRole xtRole = xtRoleService.getRoleById(id);
        
        modelMap.put("xtRole", xtRole);
        
        return "/authority/role/permission";
    }
    
	//根据roleId，获得所有roleId对应的resource列表
    @RequestMapping(value = "/perm/{id}", method = RequestMethod.GET)
    public String getResByRoleId(@PathVariable("id") String id, ModelMap modelMap,HttpServletResponse response) {
       
        // 用户拥有角色
        List<XtResource> xtUserRoles = xtPermAssignService.getResourceByRoleId(id);
        
        String result  = JsonTool.Obj2Json(xtUserRoles);
        
        modelMap.put("xtUserRoles", xtUserRoles);
        
        return null;
    }
    
  //根据roleId获得该角色关联的菜单树
  	@RequestMapping(value = "/saveMenusByRoleId/{id}", method = RequestMethod.POST)
  	@ResponseBody
      public String saveMenusByRoleId(HttpServletRequest request,
      		HttpServletResponse response,
      		@PathVariable("id") String id) 
  	{
  		
  				System.out.println("****"+id);
  				String menus = request.getParameter("datas");
  				System.out.println("****"+menus);
  				boolean isSaved = xtPermAssignService.addPermAssignByRoleIdResId(id, menus);
  				
  				Map<String,Object> map = new HashMap<String, Object>();
  				if(isSaved)
  				{
  					map.put("code", 1);
  					map.put("message", "success");
  					map.put("data",1);
  				}
  				else
  				{
  					map.put("code", 0);
  					map.put("message", "failed");
  					map.put("data",0);
  				}
  				
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
