package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.req.member.MemberSetUptReq;
import tianrui.work.resp.member.MemberSetResp;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/member")
public class MemberAction {

	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("infoPage")
	public ModelAndView infoPage(String openid){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/member/member");
		return view;
	}
	@RequestMapping("memberInfo")
	public ModelAndView memberInfo(HttpServletRequest request) throws Exception{
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/member/memberInfo");
		return view;
	}
	
	@RequestMapping("userPage")
	public ModelAndView userPage(HttpServletRequest request) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		
		Result rs = memberInfoService.selectByOpenid(info.getMemberId());
		MemberInfo fo = (MemberInfo) rs.getData();
		view.setViewName("/shop/member/user");
		view.addObject("redpack", fo.getRedPacket());
		view.addObject("balance", fo.getBalance());
		return view;
	}
	
	@RequestMapping("setPage")
	public ModelAndView setPage(HttpServletRequest request) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		MemberSetResp set = memberInfoService.findMemberSet(info.getMemberId());
		view.setViewName("/shop/member/memberset");
		view.addObject("set", set);
		return view;
	}
	
	@RequestMapping("memberSet")
	@ResponseBody
	public Result memberSet(MemberSetUptReq req,HttpServletRequest request) throws Exception{
		Result rs =Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		rs = memberInfoService.uptMemberSet(req);
		return rs;
	}
	
	@RequestMapping("uptMemberInfo")
	@ResponseBody
	public Result uptMemberInfo(MemberInfoSaveReq req,HttpServletRequest request) throws Exception{
		Result rs = memberInfoService.uptMemberInfo(req);
		SessionManage.setSessionManage(request, (MemberInfo)rs.getData());
		return rs;
	}
	
}
