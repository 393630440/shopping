package com.tianrui.web.action.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;

@Controller
@RequestMapping("member")
public class MemberAction {

	
	@RequestMapping("index")
	@AutherWeb(typeString = "2")
	public ModelAndView index(String openid){
		ModelAndView view = new ModelAndView();
		System.out.println("-------------------------"+openid);
		view.addObject("openid", openid);
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping("features")
	public ModelAndView features(){
		ModelAndView view = new ModelAndView();
		view.setViewName("features");
		return view;
	}
	
	@RequestMapping("contact")
	public ModelAndView contact(){
		ModelAndView view = new ModelAndView();
		view.setViewName("contact");
		return view;
	}
}
