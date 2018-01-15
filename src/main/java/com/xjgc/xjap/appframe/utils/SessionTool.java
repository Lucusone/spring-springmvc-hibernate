package com.xjgc.xjap.appframe.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xjgc.xjap.authority.entity.XtUser;

public class SessionTool {

	
	private static Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();
	
	public static synchronized void addSession(String sessionID,HttpSession session)
	{
		for (String id : sessions.keySet()) {
			
			//如果用户已经登录，即正在登录的用户id与sessions中的记录有一致的。
			if(id.equals(sessionID))
			{
				//先将sessions中的记录删掉，再将新的记录加入到sessions中。
				removeSession(id);
				sessions.put(sessionID, session);
				return;
			}
		}
		
		sessions.put(sessionID, session);
		
	}
	
	public static synchronized void removeSession(String sessionID)
	{
		if(null != sessions.get(sessionID))
		{
			sessions.get(sessionID).invalidate();
		}
		
		sessions.remove(sessionID);
	}
	
	public static synchronized void removeSession(HttpSession session)
	{
		String id = ((XtUser)session.getAttribute("currentUser")).getUserId();
		removeSession(id);
	}
	
	public static synchronized boolean isContainsSession(HttpSession session) {
		
		return sessions.containsValue(session);
	}
}
