package com.tianrui.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;

import tianrui.work.api.ICashBackService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.req.cash.CashBackInfoReq;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.resp.cash.CashBackInfoResp;
import tianrui.work.resp.cash.CashBackResp;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/admin/shop/cash")
public class CashAction {
	@Autowired
	ICashBackService cashBackService;
	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("savepage")
	@AutherWeb(typeString = "admin")
	public ModelAndView savepage() throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfoFindReq req = new MemberInfoFindReq();
		PageTool<MemberInfoResp> page = memberInfoService.select(req);
		view.addObject("mlist", page.getList());
		view.setViewName("admin/cash/save_cash");
		return view;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(CashBackReq req) throws Exception{
		Result rs = Result.getSuccessful();
		rs = cashBackService.addCashBack(req);
		return rs;
	}
	
	@RequestMapping("page")
	@AutherWeb(typeString = "admin")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/cash/page");
		return view;
	}
	
	@RequestMapping("find")
	@ResponseBody
	public Result find(CashBackReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<CashBackResp> page = cashBackService.queryCashBack(req);
		rs.setData(page);
		return rs;
	}
	
	@RequestMapping("pageInfo")
	@AutherWeb(typeString = "admin")
	public ModelAndView pageInfo(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/cash/pageInfo");
		return view;
	}
	
	@RequestMapping("findInfo")
	@ResponseBody
	public Result findInfo(CashBackInfoReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<CashBackInfoResp> page = cashBackService.queryCashBackInfo(req);
		rs.setData(page);
		return rs;
	}
}
