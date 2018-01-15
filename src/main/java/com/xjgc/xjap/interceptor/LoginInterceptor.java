package com.xjgc.xjap.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("login after method-----");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("login  post method-----");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("login  pre---method");
		
		HttpSession session = request.getSession();
		System.out.println();
		if(session.getAttribute("currentUser") != null)
		{
			return true;
		}
			
		else
		{
			//if(session.gets)
			//request.setAttribute("anyoneLogin", true);
			request.getRequestDispatcher("/index.jsp").forward(request, response); 
			return false;
		}
			
	}

}
