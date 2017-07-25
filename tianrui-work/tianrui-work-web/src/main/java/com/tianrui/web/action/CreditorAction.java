package com.tianrui.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tianrui.work.api.ICreditorService;
import tianrui.work.req.creditor.CreditorFindReq;
import tianrui.work.req.creditor.CreditorSaveReq;
import tianrui.work.resp.creditor.CreditorFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/***
 * 鍊烘潈鍙戝竷action
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wechat/shop/creditor")
public class CreditorAction {

	@Autowired
	ICreditorService creditorService;

	/**
	 * 发布信息页面
	 * @return
	 */
	@RequestMapping("savePage")
	public ModelAndView savePage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("shop/creditor/save");
		return view;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(CreditorSaveReq req) throws Exception{
		Result rs = Result.getSuccessful();
		rs = creditorService.creditorSave(req);
		return rs;
		
	}
	/**
	 * 信息广场页面
	 * @return
	 */
	@RequestMapping("selectPage")
	public ModelAndView selectPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("shop/creditor/page");
		return view;
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Result select(CreditorFindReq req)throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<CreditorFindResp> page = creditorService.creditorFind(req);
		rs.setData(page);
		return rs;
	}
	
}
