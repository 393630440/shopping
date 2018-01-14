package com.tianrui.web.action.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import tianrui.work.bean.MemberInfo;
import tianrui.work.mapper.java.MemberInfoMapper;

public class SessionManage {
	
	public static void setSessionManage(HttpServletRequest request, MemberInfo user) {
		request.getSession().removeAttribute("MemberInfo");
		request.getSession().setAttribute("MemberInfo", user);
	}
	
	public static void uptSessionManage(HttpServletRequest request,MemberInfo info){
		request.getSession().removeAttribute("MemberInfo");
		request.getSession().setAttribute("MemberInfo", info);
	}

	public static MemberInfo getSessionManage(HttpServletRequest request) {
		MemberInfo user = new MemberInfo();
		user = (MemberInfo) request.getSession().getAttribute("MemberInfo");
//		user.setMemberId("o1DUP1kzHzTpIqmKuajnAQyqe9uU");
//		user.setMemberRank("1");
		return user;
	}

}
