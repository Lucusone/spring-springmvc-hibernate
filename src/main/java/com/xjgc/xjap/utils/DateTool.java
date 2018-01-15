package com.xjgc.xjap.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {

	public static String DateToStrYMD(Date date)
	{
		if(date == null)
		{
			return "null";
		}
		else
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			return sdf.format(date);
		}
		
	}
	
	public static String DateToStrYMDHMS(Date date)
	{
		if(date == null)
		{
			return "null";
		}
		else
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			return sdf.format(date);
		}
		
	}
	
	
	
	public static Date StrToDate(String str)
	{
			Date date = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    try {
				date = sdf.parse(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} 
		
		
		    return date;
		 
	}
	
	
}
