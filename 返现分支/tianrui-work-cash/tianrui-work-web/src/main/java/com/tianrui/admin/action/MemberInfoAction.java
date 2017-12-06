package com.tianrui.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;

import tianrui.work.api.IMemberGainService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.req.gain.MemberGainFindReq;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.req.member.MemberInfoHBaoReq;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.resp.gain.MemberGainResp;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
@Controller
@RequestMapping("/admin/shop/member")
public class MemberInfoAction {

	@Autowired
	IMemberInfoService memberInfoService;
	@Autowired
	IMemberGainService memberGainService;
	
	@RequestMapping("memberInfo")
	@AutherWeb(typeString = "admin")
	public ModelAndView memberInfo(String id) throws Exception{
		ModelAndView view = new ModelAndView();
		view.addObject("member", memberInfoService.selectByOpenid(id).getData());
		view.setViewName("/admin/member/member_info");
		return view;
	}
	
	@RequestMapping("page")
	@AutherWeb(typeString = "admin")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/member/page");
		return view;
	}
	@RequestMapping("saveHbaoPage")
	@AutherWeb(typeString = "admin")
	public ModelAndView saveHbaoPage() throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfoFindReq req = new MemberInfoFindReq();
		PageTool<MemberInfoResp> page = memberInfoService.select(req);
		view.addObject("mlist", page.getList());
		view.setViewName("/admin/member/save_hbao");
		return view;
	}
	
	@RequestMapping("uptMemberRank")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result uptMemberRank(String id) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfoSaveReq req = new MemberInfoSaveReq();
		req.setMemberId(id);
		req.setMemberRank("2");
		memberInfoService.uptMemberInfo(req);
		return rs;
	}
	
	@RequestMapping("select")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result select(MemberInfoFindReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<MemberInfoResp> page = memberInfoService.select(req);
		rs.setData(page);
		return rs;
	}
	
	@RequestMapping("findMemberID")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result findMemberID(String id) throws Exception{
		Result rs = memberInfoService.selectByOpenid(id);
		return rs;
	}
	@RequestMapping("saveHbao")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result saveHbao(MemberInfoHBaoReq req) throws Exception{
		Result rs = Result.getSuccessful();
		rs = memberInfoService.saveHbao(req);
		return rs;
	}
	
	@RequestMapping("find")
	@ResponseBody
	public Result find(MemberGainFindReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<MemberGainResp> page = memberGainService.select(req);
		rs.setData(page);
		return rs;
	}
	@RequestMapping("gainPage")
	public ModelAndView gainPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/member/hbaoInfo");
		return view;
	}
}
