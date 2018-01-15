package com.xjgc.xjap.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class XtPermInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("interceptor3 after method-----");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("interceptor3 post method-----");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//判定用户是否有权限
		
		String url = request.getRequestURL().toString();
		//拦截到的url如http://localhost:8080/XJAP/authority/index，http://210.10.40.191:8080/XJAP/authority/index;
		//需要去掉XJAP之前的内容
		url = url.substring(url.indexOf("/XJAP"));
//		
		//若干url需要特殊处理如：/XJAP/authority/index
		//特殊的url将来可以写到配置文件中
		System.out.println(url);
//		
//		if("/XJAP/authority/index".equals(url)||"/XJAP/sso/logout".equals(url)||(url != null && url.contains("tree")))
//		{
//			return true;
//		}
//		
//		List<String> resUrlList = (List<String>)request.getSession().getAttribute("resUrlList");
//		
//		
//		Boolean isAssign =  resUrlList.contains(url);
//		
//		return isAssign;
		
		return true;
	}

}
