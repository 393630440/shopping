package com.work.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.work.api.IMainTestService;

@Controller
@RequestMapping("main/test")
public class MainTestAction {

	@Autowired
	IMainTestService mainTestService;
	
	@RequestMapping("main")
	@ResponseBody
	public String main(String id){
		String test = mainTestService.mainTest(id);
		return test;
	}
	
	@RequestMapping("page")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/web_page/index");
		return view;
	}
}
