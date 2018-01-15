package com.xjgc.xjap.powerres.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.powerres.entity.Bay;
import com.xjgc.xjap.powerres.service.IXtBayService;
import com.xjgc.xjap.utils.JsonTool;


@Controller
@Scope(value="prototype")
@RequestMapping("/powerres")
public class BayController {
	
	@Resource
	private IXtBayService xtBayService;
	

	
	@RequestMapping(value="/listbay/{stationId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String listCompany(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order,
            @PathVariable("stationId") String stationId)
	{
		
		List<Bay> lists = xtBayService.listPagesByStationID(Integer.parseInt(stationId), offset, limit, order, sort);
		
		List<Map<String,Object>> listmaps = new ArrayList<Map<String,Object>>(); 
		
		for(Bay com: lists)
		{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", com.getId());
			map.put("name", com.getName());
			listmaps.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		Long total = xtBayService.getTatal(Integer.parseInt(stationId));
		map.put("total", total);
		map.put("rows", listmaps);
		
		String result = JsonTool.Obj2Json(map);
		
		return result;
	}

}
