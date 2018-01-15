package com.xjgc.xjap.appframe.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.appframe.utils.SessionTool;
import com.xjgc.xjap.authority.entity.XtLog;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.service.IXtLogService;
import com.xjgc.xjap.authority.service.IXtMenuService;
import com.xjgc.xjap.authority.service.IXtResourceService;
import com.xjgc.xjap.authority.service.IXtUserRoleService;
import com.xjgc.xjap.authority.service.IXtUserService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.NetworkTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.StringTool;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/sso")
public class LoginController {

	@Resource
	private IXtUserService xtuserService;
	
	@Resource
	private IXtLogService xtLogService;
	
	@Resource
	private IXtUserRoleService xtUserRoleService;
	
	@Resource
	private IXtMenuService xtMenuService;
	
	@Resource
	private IXtResourceService xtResourceService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	@ResponseBody
	public void login(String username,String password, HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		
		System.out.println(username);
		System.out.println(password);
		
		XtUser userLogin = null;
		
		if(StringTool.isSafe(username)&&StringTool.isSafe(password))
		{
			userLogin = xtuserService.getLogin(username, password);
		}
		
		if(userLogin != null)
		{
			HttpSession session = request.getSession();
			System.out.println(session.isNew());
			session.setAttribute("currentUser", userLogin);
			session.setAttribute("currentOrg", userLogin.getXtOrganization());
			
			System.out.println(session.getAttribute("currentOrg"));
			
			//session.setAttribute("roleId", xtUserRoleService.getRolesOfUser(userLogin.getUserId()).get(0).getRoleId());
			//String menus = xtMenuService.getRoleMenusByRoleId(xtUserRoleService.getRolesOfUser(userLogin.getUserId()).get(0).getRoleId()); 
			//modelMap.put("menus", xtMenuService.getRoleMenusByRoleId(xtUserRoleService.getRolesOfUser(userLogin.getUserId()).get(0).getRoleId()));
			//modelMap.put("menusNull", xtMenuService.getMenusByResIdNUll());
			
			String userId = userLogin.getUserId();
			
			
			int size = xtUserRoleService.getRolesOfUser(userId).size();
			
			String roleId = null;
			//用户没有对应的角色的情况
			if(size != 0)
			{
				XtRole xtRole = xtUserRoleService.getRolesOfUser(userId).get(0);
				roleId = xtRole.getRoleId();
			}
		
			
			//获得roleId关联的所有菜单，但是某些非叶子节点没有关联资源，也就是此处获得的菜单都是叶子节点菜单
			List<Map<String,Object>> menus = xtMenuService.getRoleMenusByRoleId(roleId);
			
			//获得没有关联资源的菜单，也就是此处获得的都是非叶子节点菜单(此处的非叶子节点并不只是当前用户关联的非叶子节点)
			List<Map<String,Object>> menusNull1 = xtMenuService.getMenusByResIdNUll();
			
			//只获得当前用户关联的非叶子节点
			List<Map<String,Object>> menusNull = new ArrayList<Map<String,Object>>();
			
			
			for(Map<String,Object> map : menusNull1)
			{
				for(Map<String,Object> map1 : menus)
				{
					if(map1.get("pId") != null)
					{
						if(map1.get("pId").equals(map.get("id")))
						{
							menusNull.add(map);
							break;
						}
					}
					
				}
			}
			
			//将当前用户关联的叶子节点和非叶子节点都放入session中
			session.setAttribute("menus", menus);
			session.setAttribute("menusNull", menusNull);
			
			//将用户关联的资源列表也放入session
			session.setAttribute("resUrlList", xtResourceService.getResUrlByRoleId(roleId));
			
			System.out.println(session.getAttribute("resUrlList"));
			System.out.println(menus);
			System.out.println(menusNull);
			
			SessionTool.addSession(userLogin.getUserId(), session);
			
			System.out.println(session.getAttribute("currentUser") == null);
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("data", "/authority/index");
			String result = null;
			String clientHostName = request.getRemoteHost();
			this.addLog(userLogin, request.getRemoteAddr(), "【"+userLogin.getUserName()+"】登录系统", "系统-登录",clientHostName);
			try {
				result = JsonTool.Obj2Json(map);
				ResponseUtil.write(response,result);
			} catch (Exception e) {
			}
		}
		else{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("code", 0);
			map.put("data", "用户名或者密码有误！");
			String result = null;
			try {
				result = JsonTool.Obj2Json(map);
				ResponseUtil.write(response,result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("---------"+result);
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		
			HttpSession session = request.getSession();
			XtUser user = (XtUser)session.getAttribute("currentUser");
			
			if(SessionTool.isContainsSession(session))
			{
				SessionTool.removeSession(session);
			}
			else {
				session.invalidate();
			}
			String clientHostName = request.getRemoteHost();
			this.addLog(user, NetworkTool.getIpAddress(request), "【"+user.getUserName()+"】退出系统", "系统-退出",clientHostName);
			return "redirect:/";
			
	}	
	
	//此时用户如果已经登录，则应该直接跳到主页面
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response)
	{
		
		Map<String,Object> map = new HashMap<String, Object>();
	
		String result = null;
		
		//如果用户已经登录，并且是同一浏览器，则直接跳转到主界面
		XtUser user = (XtUser)request.getSession().getAttribute("currentUser");
		
		HttpSession session = request.getSession();
		
		if (user != null) 
		{
			return "/authority/index";
		}
		else 
		{
			//如果用户未登录，或者用户已经登录但不是同一浏览器，则需要将上一用户T掉,并给上一用户有效的提示信息
			return "/authority/login/login";
		}
	}
	
	public void addLog(XtUser xtUser, String clientIp, String description,String operType,String clientHostName)
	{
		XtLog log = new XtLog();
		
		log.setXtOplogid(UUIDTool.getUUID());
		log.setXtOplogcomputer(clientHostName);
		log.setXtOplogcomputer(operType);
		log.setXtOplogipaddress(clientIp);
		log.setXtOplogtime(new Timestamp(new Date().getTime()));
		
		//操作类型
	
		//log.setXtLogClass(new XtLogClass());
		
		//操作描述
		log.setXtOplogdescribe(description);
		
		xtLogService.save(log);
		
	}
}
