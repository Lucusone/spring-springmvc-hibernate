package com.xjgc.xjap.powerres.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjgc.xjap.powerres.entity.Bay;
import com.xjgc.xjap.powerres.entity.Breaker;
import com.xjgc.xjap.powerres.entity.Company;
import com.xjgc.xjap.powerres.entity.District;
import com.xjgc.xjap.powerres.entity.Feeder;
import com.xjgc.xjap.powerres.entity.Station;
import com.xjgc.xjap.powerres.service.IXtBayService;
import com.xjgc.xjap.powerres.service.IXtBreakerService;
import com.xjgc.xjap.powerres.service.IXtCompanyService;
import com.xjgc.xjap.powerres.service.IXtDistrictService;
import com.xjgc.xjap.powerres.service.IXtFeederService;
import com.xjgc.xjap.powerres.service.IXtStationService;
import com.xjgc.xjap.utils.JsonTool;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/powerres")
public class PowerresController {
	
	
	private static final String ROOT = "_ROOT";
	private static final String COMPANY = "_COM";
	private static final String DISTRICT = "_DIS";
	private static final String STATION = "_ST";
	private static final String FEEDER= "_FD";
	private static final String BAY = "_BY";
	private static final String BREAKER = "_BK";
	
	private static final String FDROOT = "_FDROOT";
	private static final String BAYROOT = "_BKROOT";
	
	
	@Resource
	private IXtCompanyService xtCompanyService;
	
	@Resource
	private IXtDistrictService xtDistrictService;
	
	@Resource
	private IXtStationService xtStationService;
	
	@Resource
	private IXtFeederService xtFeederService;
	
	@Resource
	private IXtBayService xtBayService;
	
	@Resource
	private IXtBreakerService xtBreakerService;
	
	@RequestMapping(value = "/restree",produces="text/html;charset=utf-8")
	@ResponseBody
	public String getPowerres(HttpServletResponse response)
	{
		
		
		List<Company> listCompany = xtCompanyService.findCompanies();
		
		List<Map<String,Object>>  lists = new ArrayList<Map<String,Object>>();
		
		//建立一个虚拟的省公司节点
		Map<String,Object> mapRoot = new HashMap<String, Object>();
		
		mapRoot.put("id", "root"+PowerresController.ROOT);
		mapRoot.put("pId", null);
		mapRoot.put("url", null);
		mapRoot.put("name", "省公司");
		mapRoot.put("open", true);
		
		lists.add(mapRoot);
		
		for(Company com: listCompany)
		{
			
			List<District> listDistrict = xtDistrictService.listByCompanyID(com.getId());
			for(District dis : listDistrict)
			{
				
				List<Station> listStation = xtStationService.listByDistrictID(dis.getId());
				for(Station st : listStation)
				{
					
					//建立虚拟的馈线总节点
					Map<String,Object> feederRoot = new HashMap<String, Object>();
					feederRoot.put("id", st.getId()+PowerresController.FDROOT);
					feederRoot.put("pId",st.getId()+PowerresController.STATION);
					feederRoot.put("url", null);
					feederRoot.put("name", "所有馈线");
					feederRoot.put("open", true);
               		lists.add(feederRoot);
               		
               		
               		
					List<Feeder> listFeeder = xtFeederService.listByStationID(st.getId());
					System.out.println(listFeeder.size());
					for(Feeder fd : listFeeder)
					{
						
//						List<Breaker> listBreaker = xtBreakerService.listByFeederID(fd.getId());
//						for(Breaker bk : listBreaker)
//						{
//							  //建立一个断路器节点
//	                   		Map<String,Object> mapBK = new HashMap<String, Object>();
//	                   		mapBK.put("id", bk.getId()+PowerresController.BREAKER);
//	                   		mapBK.put("pId",fd.getId()+PowerresController.FEEDER);
//	                   		mapBK.put("url", null);
//	                   		mapBK.put("name", bk.getName());
//	                   		mapBK.put("open", true);
//	                   		lists.add(mapBK);
//						}
//						
						
						
		            	  //建立一个馈线节点
                   		Map<String,Object> mapLine = new HashMap<String, Object>();
                   		mapLine.put("id", fd.getId()+PowerresController.FEEDER);
                   		mapLine.put("pId",st.getId()+PowerresController.FDROOT);
                   		mapLine.put("url", null);
                   		mapLine.put("name", fd.getName());
                   		mapLine.put("open", true);
                   		lists.add(mapLine);
					}
					
					//建立虚拟的间隔总节点
					Map<String,Object> bayRoot = new HashMap<String, Object>();
					bayRoot.put("id", st.getId()+PowerresController.BAYROOT);
					bayRoot.put("pId",st.getId()+PowerresController.STATION);
					bayRoot.put("url", null);
					bayRoot.put("name", "所有间隔");
					bayRoot.put("open", true);
               		lists.add(bayRoot);
					
					List<Bay> listBay = xtBayService.listByStationID(st.getId());
					System.out.println(listBay.size()+"-------------------");
					for(Bay bay : listBay)
					{
						 //建立一个间隔节点
                 		Map<String,Object> mapJG = new HashMap<String, Object>();
                 		mapJG.put("id",bay.getId()+PowerresController.BAY );
                 		mapJG.put("pId", st.getId()+PowerresController.BAYROOT);
                 		mapJG.put("url", null);
                 		mapJG.put("name", bay.getName());
                 		mapJG.put("open", true);
                 		
                 		lists.add(mapJG);
					}
					
					
					
					
					//建立一个变电站节点
					Map<String,Object> mapBDZ = new HashMap<String, Object>();
					
             		mapBDZ.put("id",st.getId()+PowerresController.STATION );
             		mapBDZ.put("pId", dis.getId()+PowerresController.DISTRICT);
             		mapBDZ.put("url", null);
             		mapBDZ.put("name", st.getName() );
             		mapBDZ.put("open", true);
             		
             		lists.add(mapBDZ);
				}
				
				
				//建立一个分区节点
         		Map<String,Object> mapPart = new HashMap<String, Object>();
         		
         		mapPart.put("id", dis.getId()+PowerresController.DISTRICT);
         		mapPart.put("pId", com.getId()+PowerresController.COMPANY);
         		mapPart.put("url", null);
         		mapPart.put("name",  dis.getName());
         		mapPart.put("open", true);
         		
         		lists.add(mapPart);

			}
			
			//建立一个公司节点
			Map<String,Object> mapCompany = new HashMap<String, Object>();
			
			mapCompany.put("id", com.getId()+PowerresController.COMPANY);
			mapCompany.put("pId", "root"+PowerresController.ROOT);
			mapCompany.put("url", null);
			mapCompany.put("name",com.getName());
			mapCompany.put("open", true);
			
			lists.add(mapCompany);
		}
		
		
		
		String result = JsonTool.Obj2Json(lists);
		try {
			//ResponseUtil.write(response, result);
		} catch (Exception e) {
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/authority/powerres/index";
    }
	
	
}
