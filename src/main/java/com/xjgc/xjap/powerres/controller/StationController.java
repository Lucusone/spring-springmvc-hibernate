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

import com.xjgc.xjap.powerres.entity.Station;
import com.xjgc.xjap.powerres.service.IXtStationService;
import com.xjgc.xjap.utils.JsonTool;


@Controller
@Scope(value="prototype")
@RequestMapping("/powerres")
public class StationController {
	
	@Resource
	private IXtStationService xtStationService;
	
	@RequestMapping(value="/liststation/{districtId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String listCompany(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order,
            @PathVariable("districtId") String districtId)
	{
		
		List<Station> lists = xtStationService.listPagesByDistrictID(Integer.parseInt(districtId),offset,limit,order,sort);
		
		List<Map<String,Object>> listmaps = new ArrayList<Map<String,Object>>(); 
		
		for(Station com: lists)
		{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", com.getId());
			map.put("name", com.getName());
			listmaps.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		Long total = xtStationService.getTatal(Integer.parseInt(districtId));
		map.put("total", total);
		map.put("rows", listmaps);
		
		String result = JsonTool.Obj2Json(map);
		
		return result;
	}

}
