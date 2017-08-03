package com.tianrui.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wechat/shop/member")
public class MemberAction {

	
	@RequestMapping("infoPage")
	public ModelAndView infoPage(String openid){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/member/member");
		return view;
	}
	
	@RequestMapping("userPage")
	public ModelAndView userPage(String openid){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/member/user");
		return view;
	}
	
	@RequestMapping("setPage")
	public ModelAndView setPage(String openid){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/member/memberset");
		return view;
	}
	
}
