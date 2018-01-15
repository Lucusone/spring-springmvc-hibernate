package com.xjgc.xjap.authority.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.authority.entity.XtResClass;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.service.IXtResClassService;
import com.xjgc.xjap.utils.JsonTool;

@Service("xtResClassService")
@Scope(value="prototype")
@Transactional
public class XtResClassService  extends BaseService implements IXtResClassService{

	@Override
	public List<XtResClass> getAll() {
		return xtResClassDao.findAll();
	}

	@Override
	public XtResClass getXtResClassById(String id) {
		
		return xtResClassDao.findXtResClassById(id);
	}

	@Override
	public List<XtResClass> getByPage(int page, int rows) {
		return xtResClassDao.findByPage(page, rows);
	}

	@Override
	public long getTotal() {
		return xtResClassDao.findTotal();
	}

	@Override
	public void add(XtResClass resClass) {
		xtResClassDao.addEntity(resClass);
	}

	@Override
	public void delete(XtResClass resClass) {
		xtResClassDao.deleteEntity(resClass);
	}

	@Override
	public void update(XtResClass resClass) {
		xtResClassDao.updateEntity(resClass);
	}

	//此处并没有根据roleId来查询，而是查询全部
	@Override
	public String getResZTreeByRoleId(String roleId) {
		
		List<XtResClass> res = xtResClassDao.findAll();
		
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		for(XtResClass xtres : res)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("id", xtres.getResClassId());
			if(xtres.getXtResClass() == null)
			{
				map.put("pId", null);
			}
			else
			{
				map.put("pId", xtres.getXtResClass().getResClassId());
			}
			map.put("open", true);
			map.put("name", xtres.getResClassName());
			
			lists.add(map);
			
		}
		return JsonTool.Obj2Json(lists);
		
	}

	@Override
	public XtRole getRoleById(String roleId) {
		return xtRoleDao.findRoleById(roleId);
	}

}
