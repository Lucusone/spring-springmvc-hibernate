package com.xjgc.xjap.authority.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.authority.entity.XtPermAssign;
import com.xjgc.xjap.authority.entity.XtResource;
import com.xjgc.xjap.authority.service.IXtPermAssignService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.UUIDTool;

@Service("xtPermAssignService")
@Scope(value="prototype")
@Transactional
public class XtPermAssignService extends BaseService implements IXtPermAssignService{

	@Override
	public List<XtResource> getResourceByRoleId(String roleId) {
		return xtPermAssignDao.findAllPermByRoleId(roleId);
	}

	@Override
	public void deletePermAssignByRoleId(String roleId) {
		xtPermAssignDao.deleteEntityAllPermByRoleId(roleId);
	}

	@Override
	public boolean addPermAssignByRoleIdResId(String roleId, String resId) {
		
		boolean isAdded = false;
		
		try{
			
			//先将xt_perm_assign表中关于roleId的记录都全部删除，然后根据用户选中的记录再添加记录。
			deletePermAssignByRoleId(roleId);
			List<Map<String,Object>> lists = JsonTool.json2List(resId);
			
			for(Map<String,Object>  map : lists)
			{
					XtPermAssign xtPermAssign = new XtPermAssign();
					
					xtPermAssign.setPermAssignId(UUIDTool.getUUID());
					
					xtPermAssign.setXtRole(xtRoleDao.findRoleById(roleId));
					
					if(null == map.get("resId"))
					{
						xtPermAssign.setXtResource(null);
					}
					else
					{
						xtPermAssign.setXtResource(xtResDao.findResById(map.get("resId").toString()));
					}
					xtPermAssignDao.addEntity(xtPermAssign);
			}
			
			isAdded = true;
		}
		catch (Exception e) {
			
			isAdded = false;
		}
		
		return isAdded;
	}

}
