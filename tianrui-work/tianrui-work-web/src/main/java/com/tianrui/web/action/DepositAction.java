package com.tianrui.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/***
 * 提款申请
 * @author jh
 *
 */
@Controller
@RequestMapping("/wechat/shop/deposit")
public class DepositAction {

	@RequestMapping("page")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/deposit/page");
		return view;
	}
	
	@RequestMapping("savePage")
	public ModelAndView savePage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/deposit/save");
		return view;
	}
	
}
