package com.tianrui.web.action.session;

import javax.servlet.http.HttpServletRequest;

import tianrui.work.bean.MemberInfo;

public class SessionManage {

	public static void setSessionManage(HttpServletRequest request, MemberInfo user){
		request.getSession().removeAttribute("MemberInfo");
		request.getSession().setAttribute("MemberInfo", user);
	}
	
	public static MemberInfo getSessionManage(HttpServletRequest request){
		MemberInfo user = new MemberInfo();
		user = (MemberInfo) request.getSession().getAttribute("MemberInfo");
		return user;
	}
}
