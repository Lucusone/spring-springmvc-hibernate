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

import com.xjgc.xjap.authority.entity.XtResClass;
import com.xjgc.xjap.authority.entity.XtResType;
import com.xjgc.xjap.authority.entity.XtResource;
import com.xjgc.xjap.authority.service.IXtResClassService;
import com.xjgc.xjap.authority.service.IXtResTypeService;
import com.xjgc.xjap.authority.service.IXtResourceService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtresource")
public class XtResourceConroller {
	
	@Resource
	private IXtResourceService xtResourceService;
	
	@Resource
	private IXtResTypeService xtResTypeService;
	
	@Resource
	private IXtResClassService xtResClassService;
	
	
	//根据class_id,列表显示资源
	@RequestMapping("/list/{id}")
	@ResponseBody
	public String getAll(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, defaultValue = "asc") String order,
            @PathVariable("id") String id) throws Exception
	{
		
		List<XtResource> lists = xtResourceService.getPageResByClassId(id, offset, limit, sort, order);
		
		Long totalOfRes = xtResourceService.getTotalResByClassId(id);
		
		//List<XtResource> lists = xtResourceService.findXtResourceByPage(offset, limit);
		
		//Long totalOfRes = xtResourceService.getResourceTotal();
		
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		
		for(XtResource xtRes:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("resId", xtRes.getResId());
			map.put("resName",xtRes.getResName() );
			map.put("resUrl",xtRes.getResUrl());
			map.put("resObjectName",xtRes.getResObjectName() );
			map.put("resAccessType", xtRes.getResAccessType());
			
			map.put("resActive",xtRes.getResActive());
			map.put("resUsebymenu", xtRes.getResUsebymenu());
			map.put("resUsebywf", xtRes.getResUsebywf());
			map.put("resHelpPath", xtRes.getResHelpPath());
			map.put("resOrder", xtRes.getResOrder());
			
			listMap.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("total", totalOfRes);
		map.put("rows", listMap);
		
		String result = JsonTool.Obj2Json(map);

		System.out.println(result);
		ResponseUtil.write(response, result);
		return null;
	}

	//跳转到资源管理界面
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/resource/index";
    }
	
	//增加资源，弹出增加界面
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
		
		List<XtResClass> xtResClasses = xtResClassService.getAll();
		
		List<XtResType> xtResTypes = xtResTypeService.getAll();
		
		modelMap.put("xtResClasses", xtResClasses);
		modelMap.put("xtResTypes", xtResTypes);
		
        return "/authority/resource/create";
    }
	
	//响应用户点击的增加资源的“保存”动作
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void createRes(HttpServletResponse response, XtResource res,HttpServletRequest request) {
		
		String resTypeId =  request.getParameter("resTypeId");
		String resClassId =  request.getParameter("resClassId");
		
		XtResType xtResType = xtResTypeService.getXtResTypeById(resTypeId);
		XtResClass xtResClass = xtResClassService.getXtResClassById(resClassId);
		if(null != res)
		{
			res.setResId(UUIDTool.getUUID());
			res.setXtResClass(xtResClass);
			res.setXtResType(xtResType);
		}
	
		System.out.println("---");
		xtResourceService.save(res);
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("code", 1);
		map.put("message", "success");
		map.put("data",1);
		
		String result = null;
		result = JsonTool.Obj2Json(map);
		try {
			ResponseUtil.write(response,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
	//编辑资源，弹出编辑资源页面
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(ModelMap modelMap,
    		@PathVariable("id") String id) {
		
		XtResource res = xtResourceService.getResourceById(id);
		List<XtResClass> xtResClasses = xtResClassService.getAll();
		List<XtResType> xtResTypes = xtResTypeService.getAll();
		
		modelMap.put("xtResClasses", xtResClasses);
		modelMap.put("xtResTypes", xtResTypes);
		
		modelMap.put("xtresource", res);
		
        return "/authority/resource/update";
    }
	
	//响应用户在编辑资源页面的“保存”动作
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateRes(HttpServletResponse response,XtResource res,HttpServletRequest request) {
		
		String resTypeId =  request.getParameter("resTypeId");
		String resClassId =  request.getParameter("resClassId");
		
		XtResType xtResType = xtResTypeService.getXtResTypeById(resTypeId);
		XtResClass xtResClass = xtResClassService.getXtResClassById(resClassId);
		
		res.setXtResClass(xtResClass);
		res.setXtResType(xtResType);
		
		xtResourceService.update(res);
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
	
	//删除资源
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.POST)
	@ResponseBody
    public String deleteRes(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		for(int i=0; i<idArray.length;i++)
		{
			xtResourceService.deleteById(idArray[i]);
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
			e.printStackTrace();
		}
        return null;
    }
	
}
