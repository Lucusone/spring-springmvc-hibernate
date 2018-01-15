package com.xjgc.xjap.authority.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.authority.entity.XtLog;
import com.xjgc.xjap.authority.service.IXtLogService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.ResponseUtil;

@Controller
@Scope(value="prototype")
@RequestMapping("/authority/xtlog")
public class XtLogConroller {
	
	@Resource
	private IXtLogService xtLogService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAll(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) throws Exception
	{
		
		List<XtLog> lists = xtLogService.getByPage(offset, limit);	
		Long totalOfUsers = xtLogService.getTotal();	
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		for(XtLog xtLog:lists)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("xtOplogid", xtLog.getXtOplogid());
			map.put("xtOplogtime", xtLog.getXtOplogtime());
			map.put("xtOplogdescribe", xtLog.getXtOplogdescribe());
			map.put("xtOplogipaddress", xtLog.getXtOplogipaddress());
			map.put("xtOplogcomputer", xtLog.getXtOplogcomputer());
			
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
        return "/authority/log/index";
    }
	
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.POST)
	@ResponseBody
    public String deleteLog(HttpServletResponse response,
    		@PathVariable("ids") String ids) 
	{
		System.out.println("--------"+ids);
		String[] idArray = ids.split("-");
		
		for(int i=0; i<idArray.length;i++)
		{
			XtLog log = xtLogService.getXtLogById(idArray[i]);
			xtLogService.delete(log);	
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
