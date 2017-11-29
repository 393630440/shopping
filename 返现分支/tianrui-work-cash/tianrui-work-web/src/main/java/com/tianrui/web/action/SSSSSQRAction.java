package com.tianrui.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("web/show/qr")
public class SSSSSQRAction {

	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView();
		view.addObject("pathUrl", "http://www.da156.cn");
		view.setViewName("shop/showqr/index");
		return view;
	}
}
