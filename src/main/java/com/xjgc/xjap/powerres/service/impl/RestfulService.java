package com.xjgc.xjap.powerres.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xjgc.xjap.appframe.service.impl.BaseService;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

@Service("restfulService")
//@Transactional
public class RestfulService extends BaseService{
	
//	@Qualifier("restTemplate")
//	@Autowired
//	private RestTemplate restTemplate;
	
	
	
	public String getValues() {
		
		RestTemplate restTemplate = new RestTemplate();
		/***
		 * POST
		 * Content-Type:application/x-www-form-urlencoded
		 */
		
		 HttpHeaders headers = new HttpHeaders();
	     MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8");
	     headers.setContentType(type);
	        //headers.add("Accept", MediaType.APPLICATION_JSON.toString());
	        //headers.add("Accept", MediaType.APPLICATION_JSON.toString());
	       
	      // String url2 ="http://localhost:8080/XJAP/authority/xtorg/tree2/id";
	        	
		String url = "http://210.10.40.200:9001/iserver/services/SCRIPTDATA?request=getvalues&dbname=analog_value&id=100014,100015,100016";
		
	   //String url = "http://210.10.40.191:9001/iserver/services/SCRIPTDATA?";    
	        
	    Map<String, Object> urlVariables = new HashMap<String, Object>();
		
		urlVariables.put("request","getvalues");
		urlVariables.put("dbname","analog_value");
		urlVariables.put("id", "100014,100015,100016");
		
		String requeString = "request=getvalues&dbname=analog_value&id=100014,100015,100016";
		
		 HttpEntity<String> formEntity = new HttpEntity<String>("", headers);
		 
		// restTemplate.execute(url, HttpMethod.GET);
		 
		 JSONObject string = restTemplate.getForObject(url,JSONObject.class);
				 //postForObject(url, null,JSONObject.class);
		 
		 
		//JSON string = restTemplate.getForObject(url,formEntity, JSON.class);
		 
//		JSONObject result = restTemplate.getForObject(restURI,
//		       JSONObject.class, urlVariables);
		//System.out.println("11111111");
		return string.toString();
	}
	
	public String getValuesByHttpClient()
	{
		return null;
	}
	public static void main(String[] args) {
		//System.out.println("1212");
		RestfulService rf = new RestfulService();
		String result = rf.getValues();
		
		System.out.print(result);
	
	}
	

}
