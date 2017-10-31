package com.tianrui.web.action.session;

import javax.servlet.http.HttpServletRequest;

import tianrui.work.bean.MemberInfo;

public class SessionManage {

	public static void setSessionManage(HttpServletRequest request, MemberInfo user) {
		request.getSession().removeAttribute("MemberInfo");
		request.getSession().setAttribute("MemberInfo", user);
	}

	public static MemberInfo getSessionManage(HttpServletRequest request) {
//		MemberInfo user = new MemberInfo();
//		user.setMemberId("oxN_GwUfDDT47iFOpJz3LQ70z4KI");
//		user.setMemberName("李思佳");
//		user.setMemberRank("2");
//		user.setWechat("oxN_GwUfDDT47iFOpJz3LQ70z4KI");
//		user.setWechatImg("http://wx.qlogo.cn/mmhead/Q3auHgzwzM7ulIHEZjnV3p8jicjDyhIyCUK1WEoVGKC1DOyiaFtibNVJQ/0");
//		user.setWechatName("李思佳");
//		user.setBalance(5000.00d);
//		user.setRedPacket(0d);
//		user.setCellphone("18337129805");
//		user.setBirthTime("2017-10-26");
//		user.setCity("郑州");
//		user.setRpExchangeRatio(1.0d);
//		user.setRpTradeMark("0");
//		user.setRpListingRatio("*");
//		user.setCreatetime(1509010108803l);

		MemberInfo user = new MemberInfo();
		user = (MemberInfo) request.getSession().getAttribute("MemberInfo");
		return user;
	}

}
