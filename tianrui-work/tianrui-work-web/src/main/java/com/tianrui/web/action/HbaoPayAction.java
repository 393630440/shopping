package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.DateUtils;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.HbaoPayReq;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/HbaoPay")
public class HbaoPayAction {

	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("page")
	public ModelAndView page(String id) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfoResp info = memberInfoService.selectByOpenid(id);
		view.setViewName("/shop/pay/HbaoPay");
		view.addObject("info",info);
		view.addObject("time", DateUtils.format(System.currentTimeMillis()));
		return view;
	}
	
	@RequestMapping("hBaoPay")
	@ResponseBody
	public Result hBaoPay(HbaoPayReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setGoPayOpenid(info.getMemberId());
		rs = memberInfoService.changeHbao(req);
		return rs;
	}
}
