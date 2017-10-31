package com.tianrui.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.api.IWithdrawalService;
import tianrui.work.bean.Withdrawal;
import tianrui.work.req.WithdrawalFindReq;
import tianrui.work.resp.WithdrawalResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/***
 * 提款管理
 * @author jh
 *
 */
@Controller
@RequestMapping("/admin/shop/deposit")
public class AdminDepositAction {

	@Autowired
	IWithdrawalService withdrawalService;
	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("page")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/deposit/page");
		return view;
	}
	@RequestMapping("auditPage")
	public ModelAndView auditPage(String id) throws Exception{
		ModelAndView view = new ModelAndView();
		Result rs = withdrawalService.findId(id);
		Withdrawal draw = (Withdrawal) rs.getData();
		Result sd = memberInfoService.selectByOpenid(draw.getMemberId());
		view.setViewName("/admin/deposit/audit");
		view.addObject("draw", draw);
		view.addObject("info", sd.getData());
		return view;
	}
	
	@RequestMapping("audit")
	@ResponseBody
	public Result audit(String id) throws Exception{
		Result rs = Result.getSuccessful();
		rs = withdrawalService.audit(id);
		return rs;
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Result select(WithdrawalFindReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<WithdrawalResp> page = withdrawalService.select(req);
		rs.setData(page);
		return rs;
	}
}
