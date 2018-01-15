package com.xjgc.xjap.authority.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.authority.entity.XtResClass;
import com.xjgc.xjap.authority.service.IXtResClassService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtresclass")
public class XtResClassConroller {
	
	@Resource
	private IXtResClassService xtResClassService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAll(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, defaultValue = "asc") String order) throws Exception
	{
		
		List<XtResClass> lists = xtResClassService.getByPage(offset, limit);	
		Long totalOfUsers = xtResClassService.getTotal();	
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		for(XtResClass xtResClass:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("resClassId", xtResClass.getResClassId());
			map.put("resClassName", xtResClass.getResClassName());
			
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

	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/resclass/index";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/authority/resclass/create";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void createResClass(HttpServletResponse response,XtResClass xtResClass) {
		
		if(null != xtResClass)
		{
			xtResClass.setResClassId(UUIDTool.getUUID());
		}
		xtResClassService.add(xtResClass);
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
		XtResClass resClass = xtResClassService.getXtResClassById(id);
		modelMap.put("xtresclass", resClass);
		
        return "/authority/resclass/update";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
    public void updateResClass(HttpServletResponse response, XtResClass resClass) {
		
		xtResClassService.update(resClass);
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
    public String deleteResClass(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		for(int i=0; i<idArray.length;i++)
		{
			XtResClass resClass = xtResClassService.getXtResClassById(idArray[i]);
			xtResClassService.delete(resClass);
			
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
	
	@RequestMapping(value="/tree/{roleId}",method = RequestMethod.POST)
	@ResponseBody
	public String getResTreeByRoleId(HttpServletResponse response,ModelMap modelMap,
    		@PathVariable("roleId") String roleId)
	{
		
		String resTree = xtResClassService.getResZTreeByRoleId(roleId);
		
		modelMap.put("role", xtResClassService.getRoleById(roleId));
		
		try {
			ResponseUtil.write(response,resTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
}
