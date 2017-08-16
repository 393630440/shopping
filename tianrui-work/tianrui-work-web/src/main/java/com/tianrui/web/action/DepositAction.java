package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.api.IMemberRechangeService;
import tianrui.work.api.IWithdrawalService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.WithdrawalFindReq;
import tianrui.work.req.WithdrawalReq;
import tianrui.work.req.rechange.RechargeFindReq;
import tianrui.work.resp.WithdrawalResp;
import tianrui.work.resp.rechange.MemberRechargeResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/***
 * 提款申请
 * @author jh
 *
 */
@Controller
@RequestMapping("/wechat/shop/deposit")
public class DepositAction {

	@Autowired
	IWithdrawalService withdrawalService;
	@Autowired
	IMemberInfoService memberInfoService;
	@Autowired
	IMemberRechangeService memberRechangeService;
	/**
	 * 提现
	 * */
	@RequestMapping("page")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/deposit/page");
		return view;
	}
	/***
	 * 充值
	 * @return
	 */
	@RequestMapping("cPage")
	public ModelAndView cPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/deposit/cpage");
		return view;
	}
	
	@RequestMapping("savePage")
	public ModelAndView savePage(HttpServletRequest request) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		Result rs = memberInfoService.selectByOpenid(info.getMemberId());
		view.setViewName("/shop/deposit/save");
		view.addObject("info", rs.getData());
		return view;
	}
	
	@RequestMapping("savecPage")
	public ModelAndView savecPage(HttpServletRequest request) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		Result rs = memberInfoService.selectByOpenid(info.getMemberId());
		view.setViewName("/shop/deposit/csave");
		view.addObject("info", rs.getData());
		return view;
	}
	@RequestMapping("payPage")
	public ModelAndView payPage(String money){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/pay/chongPay");
		view.addObject("money", money);
		return view;
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Result select(WithdrawalFindReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		PageTool<WithdrawalResp> page = withdrawalService.select(req);
		rs.setData(page);
		return rs;
	}
	@RequestMapping("save")
	@ResponseBody
	public Result save(WithdrawalReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		req.setMemberName(info.getWechatName());
		rs = withdrawalService.save(req);
		return rs;
	}
	
	@RequestMapping("cselect")
	@ResponseBody
	public Result cselect(RechargeFindReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<MemberRechargeResp> page = memberRechangeService.select(req);
		rs.setData(page);
		return rs;
	}
	
}
