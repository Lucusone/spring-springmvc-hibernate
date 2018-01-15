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

import com.xjgc.xjap.authority.entity.XtDept;
import com.xjgc.xjap.authority.service.IXtDeptService;
import com.xjgc.xjap.authority.service.IXtOrgService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtdept")
public class XtDeptController {
		
	@Resource
	private IXtDeptService xtDeptService;
	
	@Resource
	private IXtOrgService xtOrgService;
	
	//显示列表的时候需要前端发送有个orgId和选中树的deptId
	@RequestMapping("/list/{orgId}/{deptId}")
	@ResponseBody
	public String getAll(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order,
            @PathVariable("orgId") String orgId,
            @PathVariable("deptId") String deptId) throws Exception
	{
		
		List<XtDept> depts = xtDeptService.getPagesByOrgIdOrByParId(orgId, deptId, offset, limit, order, sort);
		
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		for(XtDept dept : depts)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("deptId", dept.getDeptId());
			map.put("deptName",dept.getDeptName());
			map.put("deptTel", dept.getDeptTel());
			map.put("deptFax", dept.getDeptFax());
			
			if(null == dept.getXtDept())
			{
				map.put("xtDept", null);
			}
			else
			{
				map.put("xtDept", dept.getXtDept().getDeptName());
			}
			
			if(null == dept.getXtOrganization())
			{
				map.put("xtOrganization", null);
				map.put("xtOrgId", null);
			}
			else
			{
				map.put("xtOrganization",dept.getXtOrganization().getOrgName());
				map.put("xtOrgId", dept.getXtOrganization().getOrgId());
			}
			map.put("deptAddr", dept.getDeptAddr());
			lists.add(map);
			
		}
		
		Long totalOfPages = xtDeptService.getTotalByOrgIdOrParId(orgId, deptId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", totalOfPages);
		map.put("rows", lists);
		String result = JsonTool.Obj2Json(map);
		System.out.println(result);
		try {
			ResponseUtil.write(response, result);
		} catch (Exception e) {
		}
		return null;
	}
	
	//根据公司ID来选择角色树,此处前台写死的默认orgId,
	@RequestMapping(value="/tree/{orgId}",method = RequestMethod.POST)
	@ResponseBody
	public String getDeptTreeByOrgId(HttpServletResponse response,ModelMap modelMap,
    		@PathVariable("orgId") String orgId)
	{
		
		String deptsTree = xtDeptService.getDeptTreeByOrgId(orgId);
		//modelMap.put("role", );
		try {
			ResponseUtil.write(response,deptsTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}

	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/dept/index";
    }
	
	@RequestMapping(value = "/create/{selectedNodeDeptId}", method = RequestMethod.GET)
    public String create(ModelMap modelMap,
    		@PathVariable("selectedNodeDeptId") String selectedNodeDeptId) {
		
		XtDept selectedNodeDept = xtDeptService.getXtDeptById(selectedNodeDeptId);
		
		modelMap.put("selectedNodeDept", selectedNodeDept);
		
        return "/authority/dept/create";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void createDept(HttpServletRequest request,HttpServletResponse response,XtDept dept) {
		
		String parId =  request.getParameter("parId");
		String orgId =  request.getParameter("orgId");
		
		if(null != dept)
		{
			dept.setXtOrganization(xtOrgService.getOrganizationById(orgId));
			dept.setXtDept(xtDeptService.getXtDeptById(parId));
			dept.setDeptId(UUIDTool.getUUID());
		}
		
		xtDeptService.add(dept);
		
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
		
		XtDept xtDept = xtDeptService.getXtDeptById(id);
		modelMap.put("xtdept", xtDept);
		
		modelMap.put("parXtdept", xtDept.getXtDept());
		
		modelMap.put("org", xtDept.getXtOrganization());
		
		
		System.out.println("--------"+id);
		
        return "/authority/dept/update";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
    public void updateDept(HttpServletRequest request,HttpServletResponse response, XtDept dept) {
		
		String parId = request.getParameter("parId");
		String orgId = request.getParameter("orgId");
		
		dept.setXtOrganization(xtOrgService.getOrganizationById(orgId));
		dept.setXtDept(xtDeptService.getXtDeptById(parId));
		
		xtDeptService.update(dept);
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

	//删除操作是否支持批量删除
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.POST)
	@ResponseBody
    public String deleteDept(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		//先循环判断一遍是否为叶子节点
		boolean isLeaf = true;
		for(int i=0; i<idArray.length;i++)
		{
			if(!xtDeptService.getIsLeafDept(idArray[i]))
			{
				isLeaf = false;
				break;
			}
		}
		Map<String,Object> map = new HashMap<String, Object>();
		if(isLeaf)
		{
			for(int i=0; i<idArray.length;i++)
			{
				xtDeptService.deleteById(idArray[i]);
			}
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
