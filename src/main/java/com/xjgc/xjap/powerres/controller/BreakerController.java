package com.xjgc.xjap.powerres.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.DecimalFormat;
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

import com.xjgc.xjap.powerres.entity.Breaker;
import com.xjgc.xjap.powerres.service.IXtAnalogService;
import com.xjgc.xjap.powerres.service.IXtBreakerService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.RestfulClient;


@Controller
@Scope(value="prototype")
@RequestMapping("/powerres")
public class BreakerController {
	
	@Resource
	private IXtBreakerService xtBreakerService;
	
	@Resource
	private IXtAnalogService xtAnalogService;
	
	
	/***
	 * 
	 * @param response
	 * @param offset
	 * @param limit
	 * @param search
	 * @param sort
	 * @param order
	 * @param feederId
	 * @return 所有断路器的静态信息和动态信息，同时提供图形数据
	 */
	@RequestMapping(value="/listbreak/{feederId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String listCompany(HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order,
            @PathVariable("feederId") String feederId,
            ModelMap modelMap)
	{
		
		List<Breaker> lists = xtBreakerService.listPagesByFeederID(Integer.parseInt(feederId), offset, limit, order, sort);
		
		
		List<Map<String,Object>> listmaps = new ArrayList<Map<String,Object>>();
		
		List<Double> threeList = new ArrayList<Double>();
		
		for(Breaker com: lists)
		{
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("id", com.getId());
			map.put("name", com.getName());
			map.put("description", com.getDescription());
			
			String idA = xtAnalogService.getIDByBreakerID(com.getId(), 10102).toString();
			String idB = xtAnalogService.getIDByBreakerID(com.getId(), 10103).toString();
			String idC = xtAnalogService.getIDByBreakerID(com.getId(), 10104).toString();
			
			Double currentA = RestfulClient.getSingleCurrent("method", "dbname", idA);
			Double currentB = RestfulClient.getSingleCurrent("method", "dbname", idB);
			Double currentC = RestfulClient.getSingleCurrent("method", "dbname", idC);
			
			//A相电流
			map.put("A", currentA);
			
			//B相电流
			map.put("B", currentB);
			
			//C相电流
			map.put("C", currentC);

			Double threeBlance = threebal(currentA,currentB,currentC);
			map.put("Balance", threeBlance);
			
			threeList.add(threeBlance);
			
			listmaps.add(map);
		}
		
		
	
		
		Map<String,Object> map = new HashMap<String, Object>();
		Long total = xtBreakerService.getTatal(Integer.parseInt(feederId));

		//计算三相不平衡率超过百分之50的BK所占的比例
		int temp = 0;
		for(Double double1 : threeList)
		{
			if (double1 >  0.5) {
				temp++;
			}
		}
		
		Double percentBal = Double.valueOf(Double.valueOf(temp)/Double.valueOf(total));
		
		for(Map<String, Object> map2 : listmaps)
		{
			map2.put("percentBal", percentBal);
		}
		
		map.put("total", total);
		map.put("rows", listmaps);
		
		
		String result = JsonTool.Obj2Json(map);
		
		
		
		
		return result;
	}
	
	@RequestMapping(value="/listbreakerid/{breakerId}",produces="text/html;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String getBreakIDS(
			 @PathVariable("breakerId") String breakerId)
	{
		
		Integer A = xtAnalogService.getIDByBreakerID(Integer.parseInt(breakerId), 10102);
		Integer B = xtAnalogService.getIDByBreakerID(Integer.parseInt(breakerId), 10103);
		Integer C = xtAnalogService.getIDByBreakerID(Integer.parseInt(breakerId), 10104);
		
		String data = String.valueOf(A)+","+String.valueOf(B)+","+String.valueOf(C);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		String result = JsonTool.Obj2Json(map);
		
		return result;
		
	}
	
	@RequestMapping(value="/listbreakerABC/{cur_values}",produces="text/html;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String getBreakABC(
			 @PathVariable("cur_values") String cur_values)
	{
		
		
		List<Map<String,Object>> listmaps = new ArrayList<Map<String,Object>>(); 
		
		String[]  strings  = cur_values.split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("A", strings[0]);
		map.put("B", strings[1]);
		map.put("C", strings[2]);
		
		listmaps.add(map);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("total", 1);
		map2.put("rows", listmaps);
		
		
		String result = JsonTool.Obj2Json(map2);
		
		
		
		//处理ids后，以json返回
		
		return result;
		
	}
	
	
	
	/*
	 * @RequestMapping(value="/listbreak/{feederId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String listCompany(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order,
            @PathVariable("feederId") String feederId)
	{
		
		List<Breaker> lists = xtBreakerService.listPagesByFeederID(Integer.parseInt(feederId), offset, limit, order, sort);
		
		List<Map<String,Object>> listmaps = new ArrayList<Map<String,Object>>(); 
		
		for(Breaker com: lists)
		{
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("id", com.getId());
			map.put("name", com.getName());
			
			map.put("description", com.getDescription());
							
			
			listmaps.add(map);
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		Long total = xtBreakerService.getTatal(Integer.parseInt(feederId));
		map.put("total", total);
		map.put("rows", listmaps);
		
		String result = JsonTool.Obj2Json(map);
		
		return result;
	}
	 * 
	 * 
	 */

	public Double threebal(double a,double b,double c) 
	  {
		double avg = (Math.abs(a)+Math.abs(b)+Math.abs(c))/3;
		
		double max1 = Math.max(Math.abs(a-avg),Math.abs(b-avg));
		
		double maxcal = Math.max(max1, Math.abs(c-avg));
		
		double result = 0;
		
	    if(avg == 0){
	    	result = 0;
	    }
	    else{
	    	result = maxcal/avg;
	    }
	    DecimalFormat    df   = new DecimalFormat("######0.00");  
		String res = df.format(Double.valueOf(result));
		 
	    return Double.valueOf(res);
	}
}
