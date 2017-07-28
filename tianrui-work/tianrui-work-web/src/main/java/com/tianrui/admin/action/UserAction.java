package com.tianrui.admin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/shop/user")
public class UserAction {

	@RequestMapping("/loginPage")
	public ModelAndView loginPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/login/login");
		return view;
	}
}
