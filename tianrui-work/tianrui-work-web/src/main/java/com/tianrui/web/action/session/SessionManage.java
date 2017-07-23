package com.tianrui.web.action.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tianrui.work.bean.User;

public class SessionManage {

	public static void setSessionManage(HttpServletRequest request, User user){
		request.getSession().setAttribute("USER", user);
	}
	
	public static User getSessionManage(HttpServletRequest request,HttpServletResponse response){
		User user = null;
		user = (User) request.getSession().getAttribute("USER");
		return user;
	}
}
