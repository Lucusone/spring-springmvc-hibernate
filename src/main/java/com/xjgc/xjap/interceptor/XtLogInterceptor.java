package com.xjgc.xjap.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xjgc.xjap.authority.dao.IXtLogDao;
import com.xjgc.xjap.authority.dao.impl.XtLogDao;
import com.xjgc.xjap.authority.entity.XtLog;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.service.IXtLogService;
import com.xjgc.xjap.utils.JsonTool;
import com.xjgc.xjap.utils.NetworkTool;
import com.xjgc.xjap.utils.PropertyUtil;
import com.xjgc.xjap.utils.UUIDTool;

public class XtLogInterceptor implements HandlerInterceptor{

	@Resource
	private IXtLogService xtLogService;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	
		System.out.println(request.getRequestURL());
		HandlerMethod handlerMethod = (HandlerMethod) arg2;
		
		boolean isAddLog = true;
		//根据函数名，分析参数，得到【操作类型】
		String operType = PropertyUtil.getProperty(handlerMethod.getMethod().getName(),"");
		
		//根据配置文件获得的操作类别为""的话，该操作不需要写日志
		if("".equals(operType))
		{
			isAddLog = false;
		}
		
		if(isAddLog)
		{
			String clientIp = request.getRemoteAddr();
			String clientHostName = request.getRemoteHost();
			XtUser xtUser = (XtUser)request.getSession().getAttribute("currentUser");
			
			//根据函数名，分析参数，分析url，得到【操作描述】--需要说明【】对【】操作了【】
			StringBuffer description = new StringBuffer();
			
			description.append("用户【"+xtUser.getUserName()+"】执行了操作【"+operType+"】被操作的对象是：");
			
			RequestMapping rm = handlerMethod.getMethodAnnotation(RequestMapping.class);
			
			//这是获得注解的value值
			RequestMethod[] method = rm.method();
			
			String[] vas = rm.value();
			
			String[] paths = rm.path();
			
			
			//如果是删除操作：
			
			//获得被删除对象的ID
			if(operType.startsWith("删除"))
			{
				StringBuffer parms = request.getRequestURL();
				String[] parmsArray = parms.toString().split("/");
				description.append(parmsArray[parmsArray.length-1]);
				System.out.println(request.getRequestURL());
				
			}
			else
			{
				//通过reques获得的参数列表，可以将map转换成json串，直接写入日志。该方法不适用于删除操作。
				Map<String,String[]> maps = request.getParameterMap();
				
				description.append(JsonTool.Obj2Json(maps));
				
//				for(String key : maps.keySet())
//				{
//					System.out.println(key);
//				}
//				
//				for(String[] values : maps.values())
//				{
//					for(String value : values)
//					{
//						System.out.println(value);
//					}
//				}
			}
			
		
			
			
		
//			
//			
//			Iterator keys = request.getParameterMap().keySet().iterator();
//			
//			
//			if(keys.hasNext())
//			{
//				System.out.println(keys.next());
//			}
//			
//			
//			Iterator values = request.getParameterMap().values().iterator();
//			if(values.hasNext())
//			{
//				System.out.println(values.next());
//			}
//			

			xtLogService.addLog(xtUser, clientIp, description.toString(), clientHostName);
		}
		
	

		System.out.println("interceptor2  after method-----");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("interceptor2 post method-----");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		System.out.println("interceptor2 pre---method");
		
		
		return true;
//		HttpSession session = request.getSession();
//		XtUser xtuser = (XtUser)session.getAttribute("currentUser");
//		if("admin01".equals(xtuser.getUserName()))
//		{
//			
//			return true;
//		}
//			
//		else
//		{
//			request.getRequestDispatcher("/WEB-INF/common/unauthorizedError").forward(request, response); 
//			return false;
//		}
			
	}

}
