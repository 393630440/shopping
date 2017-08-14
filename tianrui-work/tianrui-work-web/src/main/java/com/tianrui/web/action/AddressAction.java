package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;

import tianrui.work.api.IMemberAddressService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.address.AddressFindReq;
import tianrui.work.req.address.AddressSaveReq;
import tianrui.work.resp.address.AddressResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/address")
public class AddressAction {
	
	@Autowired
	IMemberAddressService memberAddressService;
	
	@RequestMapping("page")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/address/address");
		return view;
	}
	
	@RequestMapping("savePage")
	public ModelAndView savePage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/address/save");
		return view;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(AddressSaveReq req,HttpServletRequest request) throws Exception{
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		Result rs = memberAddressService.save(req);
		return rs;
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Result select(AddressFindReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		PageTool<AddressResp> page = memberAddressService.select(req);
		rs.setData(page);
		return rs;
	}
	@RequestMapping("only")
	@ResponseBody
	public Result only(String id,HttpServletRequest request) throws Exception{
		MemberInfo info = SessionManage.getSessionManage(request);
		return memberAddressService.only(id, info.getMemberId());
	}
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String id) throws Exception{
		return memberAddressService.delete(id);
	}

}
