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
import com.xjgc.xjap.authority.service.IXtOrgService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtorg")
public class XtOrganizationConroller {
	
	@Resource
	private IXtOrgService xtOrgService;
	
	//��ʾ�б��ʱ����Ҫǰ�˷����и�orgId
	@RequestMapping("/list/{orgId}")
	@ResponseBody
	public String getAll(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order,
			@PathVariable("orgId") String orgId) throws Exception
	{
		
		List<XtOrganization> lists = xtOrgService.getPageOrgs(orgId, offset, limit, sort, order);
		
		Long totalOfOrgs = xtOrgService.getTotalOrgs(orgId);
		
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		
		for(XtOrganization xtOrg:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("orgId", xtOrg.getOrgId());
			map.put("orgName", xtOrg.getOrgName());
			map.put("orgTel",xtOrg.getOrgTel());
			map.put("orgFax", xtOrg.getOrgFax());
			map.put("orgPostcode", xtOrg.getOrgPostcode());
			
			map.put("orgEmail", xtOrg.getOrgEmail());
			map.put("orgAddress", xtOrg.getOrgAddress());
			map.put("orgWebsite", xtOrg.getOrgWebsite());
			map.put("orgCode", xtOrg.getOrgCode());
			map.put("orgIsinvalid", xtOrg.getOrgIsinvalid());
			
			listMap.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("total", totalOfOrgs);
		map.put("rows", listMap);
		
		String result = JsonTool.Obj2Json(map);

		System.out.println(result);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping(value="/tree",method = RequestMethod.POST)
	@ResponseBody
	public String getOrgTree(HttpServletResponse response,ModelMap modelMap)
	{
		
		String orgTree = xtOrgService.getOrgTree();
		//modelMap.put("role", );
		try {
			ResponseUtil.write(response,orgTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
	//根据orgId来获得以该orgId为根的公司树，异步树，只获得根节点的孩子节点 @PathVariable("orgId") String orgId
	@RequestMapping(value="/orgTree/",method = RequestMethod.POST)
	@ResponseBody
	public String handleOrgTree(HttpServletResponse response,HttpServletRequest request,ModelMap modelMap)
	{
		//XtOrganization xtOrg =  (XtOrganization)(request.getSession().getAttribute("currentOrg"));
		String orgId = request.getParameter("id");
		String orgTree = xtOrgService.getAsyncTreeByOrgId(orgId);
		try {
			ResponseUtil.write(response,orgTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
	@RequestMapping(value="/tree2/{id}",method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String getOrgTree2(
			@PathVariable("id") String id) 
	{
		System.out.println(id);
		
		//String orgTree = xtOrgService.getOrgTree();
		Map<String,Object> map =  new HashMap<String, Object>();
		map.put("name","xm");
		
        return JsonTool.Obj2Json(map);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/organization/index";
    }
	
	@RequestMapping(value = "/create/{selectedNodeOrgId}", method = RequestMethod.GET)
    public String create(ModelMap modelMap,
    		@PathVariable("selectedNodeOrgId") String selectedNodeOrgId) {
		
		XtOrganization selectedNodeOrg = xtOrgService.getOrganizationById(selectedNodeOrgId);
		
		modelMap.put("selectedNodeOrg", selectedNodeOrg);
		
        return "/authority/organization/create";
    }	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void create(HttpServletRequest request,HttpServletResponse response, XtOrganization org) {
		
		String parId =  request.getParameter("parId");
		String orgId =  request.getParameter("orgId");
		
		if(null != org)
		{
			org.setXtOrganization(xtOrgService.getXtOrgById(parId));
			org.setOrgId(UUIDTool.getUUID());
		}
		
		xtOrgService.add(org);

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
		
		XtOrganization xtOrganization = xtOrgService.getOrganizationById(id);
		modelMap.put("xtorganization", xtOrganization);

		modelMap.put("parXtorg", xtOrganization.getXtOrganization());
		
		System.out.println("--------"+id);
		
        return "/authority/organization/update";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
    public void update(HttpServletRequest request,HttpServletResponse response, XtOrganization organization) {
		
		String orgId = request.getParameter("parId");
		
		organization.setXtOrganization(xtOrgService.getOrganizationById(orgId));
		
		xtOrgService.update(organization);
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
    public String delete(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		//先循环判断一遍是否为叶子节点
		boolean isLeaf = true;
		for(int i=0; i<idArray.length;i++)
		{
			if(!xtOrgService.getIsLeafDept(idArray[i]))
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
				xtOrgService.deleteById(idArray[i]);
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
