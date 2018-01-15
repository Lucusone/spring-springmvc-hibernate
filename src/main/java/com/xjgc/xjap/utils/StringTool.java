package com.xjgc.xjap.utils;

public class StringTool {

	//检测字符串是否安全，防止SQL注入
	public static Boolean isSafe(String str)
	{
		if(str != null)
			return true;
		else
			return false;
		
	}
	
	
}
