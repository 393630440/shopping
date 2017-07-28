package com.tianrui.admin.action.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tianrui.work.bean.AdminUser;

/** session管理*/
public class SessionAdminManager {

	public static void setSessionManager(HttpServletRequest request,AdminUser user){
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
	}
	
	public static AdminUser getSessionManager(HttpServletRequest request){
		AdminUser user = new AdminUser();
		HttpSession session = request.getSession();
		user = (AdminUser) session.getAttribute("user");
		return user;
	}
}
