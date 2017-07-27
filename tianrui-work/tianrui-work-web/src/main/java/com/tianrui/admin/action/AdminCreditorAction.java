package com.tianrui.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tianrui.work.api.ICreditorService;
import tianrui.work.req.creditor.CreditorFindReq;
import tianrui.work.resp.creditor.CreditorFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/admin/shop/creditor")
public class AdminCreditorAction {
	
	@Autowired
	ICreditorService creditorService;
	
	/** 页面跳转*/
	@RequestMapping("index")
	public ModelAndView creditorPage(){
		ModelAndView view = new ModelAndView();	
		view.setViewName("admin/creditor/index");
		return view;
	}
	/** 查询数据
	 * @throws Exception */
	@RequestMapping("select")
	@ResponseBody
	public Result select(CreditorFindReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<CreditorFindResp> page = creditorService.creditorFind(req);
		rs.setData(page);
		return rs;
	}
	/** 修改
	 * @throws Exception */
	@RequestMapping("upt")
	@ResponseBody
	public Result upt(String id) throws Exception{
		Result rs = Result.getSuccessful();
		rs = creditorService.creditorDelete(id);
		return rs;
	}
}
