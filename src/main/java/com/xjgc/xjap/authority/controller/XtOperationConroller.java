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

import com.xjgc.xjap.authority.entity.XtOperation;
import com.xjgc.xjap.authority.service.IXtOperationService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;
import com.xjgc.xjap.utils.UUIDTool;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtoperation")
public class XtOperationConroller {
	
	@Resource
	private IXtOperationService xtOperationService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAll(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) throws Exception
	{
		
		List<XtOperation> lists = xtOperationService.getByPage(offset, limit);	
		Long totalOfUsers = xtOperationService.getTotal();	
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		for(XtOperation xtOperation:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("operId", xtOperation.getOperId());
			map.put("operName", xtOperation.getOperName());
			
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
        return "/authority/operation/index";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/authority/operation/create";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public void createOper(HttpServletResponse response,XtOperation xtOperation) {
		if(null != xtOperation)
		{
			xtOperation.setOperId(UUIDTool.getUUID());
		}
		xtOperationService.add(xtOperation);
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
		XtOperation operation = xtOperationService.getXtOperationById(id);
		modelMap.put("xtoperation", operation);
		
        return "/authority/operation/update";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
    public void updateOper(HttpServletResponse response, XtOperation operation) {
		
		xtOperationService.update(operation);
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
    public String deleteOper(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		for(int i=0; i<idArray.length;i++)
		{
			XtOperation operation = xtOperationService.getXtOperationById(idArray[i]);
			xtOperationService.delete(operation);
			
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
	
}
