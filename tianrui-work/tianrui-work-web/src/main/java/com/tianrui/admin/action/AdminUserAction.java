package com.tianrui.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;

import tianrui.work.api.IAdminUserService;
import tianrui.work.req.admin.user.UserFindReq;
import tianrui.work.resp.admin.user.UserFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/admin/shop/user")
public class AdminUserAction {

	@Autowired
	IAdminUserService adminUserService;
	
	@RequestMapping("index")
	@AutherWeb(typeString = "admin")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/user/index");
		return view;
	}
	@RequestMapping("find")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result find(UserFindReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<UserFindResp> page = adminUserService.select(req);
		rs.setData(page);
		return rs;
	}
}
