package com.xjgc.xjap.authority.service;

import java.util.List;
import java.util.Map;

import com.xjgc.xjap.authority.entity.XtMenu;

public interface IXtMenuService {

	public List<XtMenu> getRootMenu();
	
	public List<XtMenu> getMenusByParentId(String parId);
	
	public List<XtMenu> getAll();
	
	public XtMenu getMenu(String id);
	
	public List<XtMenu>  getMenusByRoleId(String roleId); 
	
	//为角色授权时，需要展示的菜单树，此时需要将全部菜单树展示，将角色已经关联的菜单显示为选中状态
	public String getMenusZTreeByRoleId(String roleId);
	
	//判断某一菜单是否属于某个角色的菜单树
	public boolean getIsMenuChecked(List<XtMenu> menus,XtMenu menu);
	
	//根据用户的角色，来展示该角色对应的菜单树。
	public String showMenusZTreeByRoleId(String roleId);
	
	public boolean saveMenus(String roleId,String data);
	
	//根据parentId,来获得分页查询的结果
	public List<XtMenu> getPageMenus(String parId ,int page, int rows,String order,String sort);
	
	//根据parentId,获得记录的总数
	public Long getTotalMenus(String parId);
	
	//保存新增菜单
	public void saveMenu(XtMenu xtmenu);
	
	public boolean deleteMenuById(String menuId);
	
	public boolean getIsLeafMenuById(String menuId);
	
	public void updateMenu(XtMenu xtMenu);
	
	//根据角色Id来查询菜单树，返回list数据
	public List<Map<String,Object>> getRoleMenusByRoleId(String roleId);
	
	//根据角色id来查询菜单树,返回json数据
	public String showMenusByRoleId(String roleId);
	
	public List<Map<String,Object>> getMenusByResIdNUll();
	
}
