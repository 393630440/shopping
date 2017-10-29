package com.tianrui.web.action.session;

import javax.servlet.http.HttpServletRequest;

import tianrui.work.bean.MemberInfo;

public class SessionManage {

	public static void setSessionManage(HttpServletRequest request, MemberInfo user) {
		request.getSession().removeAttribute("MemberInfo");
		request.getSession().setAttribute("MemberInfo", user);
	}

	public static MemberInfo getSessionManage(HttpServletRequest request) {
		MemberInfo user = new MemberInfo();
		user = (MemberInfo) request.getSession().getAttribute("MemberInfo");
		return user;
		// MemberInfo info = new MemberInfo();
		// info.setMemberId("oxN_GwUfDDT47iFOpJz3LQ70z4KI");
		// info.setMemberName("李思佳");
		// info.setWechat("oxN_GwUfDDT47iFOpJz3LQ70z4KI");
		// info.setWechatImg("http://wx.qlogo.cn/mmhead/Q3auHgzwzM7ulIHEZjnV3p8jicjDyhIyCUK1WEoVGKC1DOyiaFtibNVJQ/0");
		// info.setWechatName("李思佳");
		// info.setBalance(5000.00d);
		// info.setRedPacket(0d);
		// info.setCellphone("18337129805");
		// info.setBirthTime("2017-10-26");
		// info.setCity("郑州");
		// info.setRpExchangeRatio(1.0d);
		// info.setRpTradeMark("0");
		// info.setRpListingRatio("*");
		// info.setCreatetime(1509010108803l);
		// return info;
	}

}
