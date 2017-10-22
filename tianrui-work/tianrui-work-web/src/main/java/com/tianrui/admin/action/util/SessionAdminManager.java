package com.tianrui.admin.action.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import tianrui.work.api.IAdminUserService;
import tianrui.work.bean.AdminUser;

/** session管理*/
public class SessionAdminManager {

	@Autowired
	static IAdminUserService adminUserService;
	
	public static void setSessionManager(HttpServletRequest request,AdminUser user){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.setAttribute("user", user);
	}
	
	public static AdminUser getSessionManager(HttpServletRequest request){
		AdminUser user = new AdminUser();
		HttpSession session = request.getSession();
		user = (AdminUser) session.getAttribute("user");
		return user;
	}
}
