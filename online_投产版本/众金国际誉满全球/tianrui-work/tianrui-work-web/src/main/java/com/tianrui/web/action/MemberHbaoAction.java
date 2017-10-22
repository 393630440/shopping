package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;

import tianrui.work.api.IMemberGainService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.gain.MemberGainFindReq;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.resp.gain.MemberGainResp;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/Hbao")
public class MemberHbaoAction {

	@Autowired
	IMemberGainService memberGainService;
	
	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("page")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/member/h_bao");
		return view;
	}
	
	@RequestMapping("pubPage")
	public ModelAndView pubPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/member/public_bao");
		return view;
	}
	
	@RequestMapping("find")
	@ResponseBody
	public Result find(MemberGainFindReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		PageTool<MemberGainResp> page = memberGainService.select(req);
		rs.setData(page);
		return rs;
	}
	
	@RequestMapping("findHbao")
	@ResponseBody
	public Result findHbao(HttpServletRequest request,MemberInfoFindReq req) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
//		req.setMemberId(info.getMemberId());
		PageTool<MemberInfoResp> page = memberInfoService.select(req);
		rs.setData(page);
		return rs;
	}
	
}
