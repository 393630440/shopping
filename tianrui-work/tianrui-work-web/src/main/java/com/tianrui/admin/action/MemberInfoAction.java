package com.tianrui.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
/** 前台会员帐号管理*/
@Controller
@RequestMapping("/admin/shop/member")
public class MemberInfoAction {

	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("page")
	@AutherWeb(typeString = "admin")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/member/page");
		return view;
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
}
