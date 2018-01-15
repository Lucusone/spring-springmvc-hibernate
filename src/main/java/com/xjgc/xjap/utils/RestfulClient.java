package com.xjgc.xjap.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/*
 * 利用HttpClient进行post请求的工具类
 */
public class RestfulClient {
	
	@SuppressWarnings("finally")
	public static String doPost(String url,Map<String,String> map,String charset){
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try{
			 //创建HttpClientBuilder  
	       // HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
	        //HttpClient  
	       // httpClient = httpClientBuilder.build();  
			httpClient = HttpClients.createDefault();
			httpPost = new HttpPost(url);
			
			//设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String,String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			}
			if(list.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
				httpPost.setEntity(entity);
			}
			
			HttpResponse response = httpClient.execute(httpPost);
			
			System.out.println(response);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,charset);
				}
			}
		}catch(Exception ex){
		}
		finally{
			return result;
		}
		
	}
	
	/***
	 * 获取单相电流值
	 * @param method
	 * @param dbname
	 * @param id
	 * @return
	 */
	public static Double getSingleCurrent(String method,String dbname,String id) {
		
		try {
			
			String url = PropertyUtil.getProperty("realTimeServerUrl");
			
		     Map<String, String> map = new HashMap<String, String>();
		     map.put("request", PropertyUtil.getProperty(method));  
		     map.put("dbname", PropertyUtil.getProperty(dbname));  
		     map.put("id", id);  
		     String charset="utf-8";
			 String result = RestfulClient.doPost(url, map, charset);
			 
			 
			//String result =  RestfulClient2.getDatas(method, dbname, id);
			 
			 String string = result.substring(result.indexOf("[")+1,result.indexOf("]"));
			 
			 String trim = string.trim();
			 
			return Double.valueOf(trim);
			
		} catch (Exception e) {
			return -1.0;
		}
		finally {
			
		}
		
		
	}
	
	

	
	
	
	
	
	
	public static void main(String[] args){
		//String url ="http://192.168.237.140:9001/iserver/services/SCRIPTDATA?";
//		String url ="http://210.10.40.200:9001/iserver/services/SCRIPTDATA?";
//		
//	     Map<String, String> map = new HashMap<String, String>();
////	     map.put("request", "queryfromdb");  
////	     map.put("dbname", "querydb");
////	     map.put("context", "{\"tableName\":\"analog\",\"id\":[\"100030\",\"100031\"],\"field\":[\"name\",\"value\"]}");
//		
//	     map.put("request", "getvalues");  
//	     map.put("dbname", "analog_value");  
//	     map.put("id", "100014,10015,10016");  
//	     String charset="utf-8";
//		 String res = RestfulClient.doPost(url, map, charset);
		
		Double res = RestfulClient.getSingleCurrent("method", "dbname", "100014");
		 System.out.println(res);
	}
}