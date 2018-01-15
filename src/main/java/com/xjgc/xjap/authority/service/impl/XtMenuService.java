 package com.xjgc.xjap.authority.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtMenu;
import com.xjgc.xjap.authority.service.IXtMenuService;
import com.xjgc.xjap.utils.JsonTool;

@Service("xtMenuService")
@Scope(value="prototype")
@Transactional
public class XtMenuService extends BaseService implements IXtMenuService{

	@Override
	public List<XtMenu> getRootMenu() {
		return xtMenuDao.findRootMenus();
	}

	@Override
	public List<XtMenu> getAll() {
		return xtMenuDao.findAllMenus();
	}

	@Override
	public XtMenu getMenu(String id) {
		return xtMenuDao.findXtMenuById(id);
	}

	@Override
	public List<XtMenu> getMenusByRoleId(String roleId) {
		
		return xtMenuDao.findMenusByRoleId(roleId);
		
	}

	//为角色授权时，需要展示的菜单树，此时需要将全部菜单树展示，将角色已经关联的菜单显示为选中状态
	@Override
	public String getMenusZTreeByRoleId(String roleId) {
		
		List<XtMenu> menusByRoleId = xtMenuDao.findMenusByRoleId(roleId);
		List<XtMenu> menus = xtMenuDao.findAllMenus();
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		for(XtMenu menu : menus)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", menu.getMenuId());
			
			if(null == menu.getXtResource())
			{
				map.put("url", null);
			}
			else
			{
				map.put("url", menu.getXtResource().getResUrl());
			}
			if(menu.getXtMenu() == null)
			{
				map.put("pId", null);
			}
			else
			{
				map.put("pId", menu.getXtMenu().getMenuId());
			}
			map.put("name", menu.getMenuName());
			map.put("open", menu.getMenuIconOpen());
			map.put("checked", getIsMenuChecked(menusByRoleId, menu));
			map.put("file", menu.getMenuIconPath());
			if(menu.getXtResource() == null)
			{
				map.put("resId", null);
			}
			else
			{
				map.put("resId", menu.getXtResource().getResId());
			}
			
			lists.add(map);
			
		}
		return JsonTool.Obj2Json(lists);
		
	}
	
	//根据resId来查询所有的菜单
	@Override
	public List<Map<String,Object>> getRoleMenusByRoleId(String roleId) {
		
		List<XtMenu> menusByRoleId = xtMenuDao.findMenusByRoleId(roleId);
		
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		for(XtMenu menu : menusByRoleId)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", menu.getMenuId());
			
			if(null == menu.getXtResource())
			{
				map.put("url", null);
			}
			else
			{
				map.put("url", menu.getXtResource().getResUrl());
			}
			if(menu.getXtMenu() == null)
			{
				map.put("pId", null);
			}
			else
			{
				map.put("pId", menu.getXtMenu().getMenuId());
			}
			map.put("name", menu.getMenuName());
			map.put("open", menu.getMenuIconOpen());
			map.put("file", menu.getMenuIconPath());
			if(menu.getXtResource() == null)
			{
				map.put("resId", null);
			}
			else
			{
				map.put("resId", menu.getXtResource().getResId());
			}
			
			lists.add(map);
			
		}
		return lists;
				//JsonTool.Obj2Json(lists);
		
	}
	
	//查询所有resId为空的菜单
		@Override
		public List<Map<String,Object>> getMenusByResIdNUll() {
			
			List<XtMenu> menusByRoleId = xtMenuDao.findMenusByResIdNULL();
			
			List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
			
			for(XtMenu menu : menusByRoleId)
			{
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("id", menu.getMenuId());
				
				if(null == menu.getXtResource())
				{
					map.put("url", null);
				}
				else
				{
					map.put("url", menu.getXtResource().getResUrl());
				}
				if(menu.getXtMenu() == null)
				{
					map.put("pId", null);
				}
				else
				{
					map.put("pId", menu.getXtMenu().getMenuId());
				}
				map.put("name", menu.getMenuName());
				map.put("open", menu.getMenuIconOpen());
				map.put("file", menu.getMenuIconPath());
				if(menu.getXtResource() == null)
				{
					map.put("resId", null);
				}
				else
				{
					map.put("resId", menu.getXtResource().getResId());
				}
				
				lists.add(map);
				
			}
			return lists;
					//JsonTool.Obj2Json(lists);
			
		}

	@Override
	public boolean getIsMenuChecked(List<XtMenu> menus, XtMenu menu) {
		
		return 	menus.contains(menu);
	}

	@Override
	public boolean saveMenus(String roleId, String data) {
		return false;
	}

	//此处并没有根据roleId来查询，而是查询全部
	@Override
	public String showMenusZTreeByRoleId(String roleId) {
		
		List<XtMenu> menus = xtMenuDao.findAllMenus();
		
		//List<XtMenu> menus = xtMenuDao.getMenusByRoleId(roleId);
		
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		for(XtMenu menu : menus)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", menu.getMenuId());
			if(menu.getXtMenu() == null)
			{
				map.put("pId", null);
			}
			else
			{
				map.put("pId", menu.getXtMenu().getMenuId());
			}
			map.put("name", menu.getMenuName());
			map.put("open", true);
			map.put("file", menu.getMenuIconPath());
			if(menu.getXtResource() == null)
			{
				map.put("resId", null);
			}
			else
			{
				map.put("resId", menu.getXtResource().getResId());
			}
			
			lists.add(map);
			
		}
		return JsonTool.Obj2Json(lists);
	}

	@Override
	public List<XtMenu> getMenusByParentId(String parId) {
		return xtMenuDao.findMenusByParentId(parId);
	}

	@Override
	public List<XtMenu> getPageMenus(String pId,int page, int rows, String sort,String order) {
		
		StringBuffer hql  = new StringBuffer("from XtMenu xm where xm.xtMenu.menuId = '"+pId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtMenuDao.findPageBySql(hql.toString(), new Page(page,rows));
	}

	@Override
	public Long getTotalMenus(String parId) {
		
		String hql = "select count(*) from XtMenu xm where  xm.xtMenu.menuId = '"+parId+"' ";
		
		return xtMenuDao.findTotalBySql(hql);
	}

	@Override
	public void saveMenu(XtMenu xtmenu) {
		xtMenuDao.addEntityXtMenu(xtmenu);
	}


	@Override
	public boolean deleteMenuById(String menuId) {
		
		if(getIsLeafMenuById(menuId))
		{
			xtMenuDao.deleteEntityById(menuId);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public boolean getIsLeafMenuById(String menuId) {
		return xtMenuDao.findIsLeafMenu(menuId);
	}

	@Override
	public void updateMenu(XtMenu xtMenu) {
		xtMenuDao.updateEntityXtMenu(xtMenu);
	}

	@Override
	public String showMenusByRoleId(String roleId) {
		
		//根据roleid获得所有对应resId不为空的菜单列表
		List<XtMenu> menusByRoleId = xtMenuDao.findMenusByRoleId(roleId);
		
		//获得所有对应的resId为空的菜单列表
		List<XtMenu> menusResIsNullList = xtMenuDao.findMenusByResIdNULL();
		
		//将menusResIsNullList中的包含有menusByRoleId中元素的 元素添加到menusByRoleId，并将该元素从menusResIsNullList中移除
		//while循环结束的条件是menusResIsNullList为空，或者 i == length
		boolean isOver = true;
		while (isOver) 
		{
			int length = menusResIsNullList.size();
			if (length == 0) {break;}
			int i = 0;
			for (; i < length; i++) 
			{
				//是否需要重新计算length的值
				boolean isRestart = false;
				for(XtMenu menu : menusByRoleId)
				{
					if(menu.getXtMenu()==null){break;}
					else {
						if(menu.getXtMenu().getMenuId() == menusResIsNullList.get(i).getMenuId())
						{
							menusByRoleId.add(menusResIsNullList.get(i));
							menusResIsNullList.remove(i);
							isRestart = true;
							break;
						}
						//else {break;}
					}
				}
				if (isRestart) {break;}
			}
			
			if (length == i) {
				isOver = false;
			}
		}
		
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		//构造前端识别的json格式的树
		for(XtMenu menu : menusByRoleId)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", menu.getMenuId());
			
			if(null == menu.getXtResource())
			{
				map.put("url", null);
			}
			else
			{
				map.put("url", menu.getXtResource().getResUrl());
			}
			if(menu.getXtMenu() == null)
			{
				map.put("pId", null);
			}
			else
			{
				map.put("pId", menu.getXtMenu().getMenuId());
			}
			map.put("name", menu.getMenuName());
			map.put("open", menu.getMenuIconOpen());
			map.put("file", menu.getMenuIconPath());
			if(menu.getXtResource() == null)
			{
				map.put("resId", null);
			}
			else
			{
				map.put("resId", menu.getXtResource().getResId());
			}
			
			lists.add(map);
			
		}
		
		String result = JsonTool.Obj2Json(lists);
		
		return result;
	}

	public static void main(String[] args) {
		List<String> testList = new ArrayList<String>();
		testList.add("test1");
		testList.add("test2");
		
		List<String> testList2 = new ArrayList<String>();
		int length = testList.size();
		
		testList2.add(testList.get(0));
		
		testList.remove(0);
		
		for (String string : testList2) {
			System.out.println(string);
		}
		
		System.out.println("-------");
		
		for (String string : testList) {
			System.out.println(string);
		}
	}

}
