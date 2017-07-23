package com.tianrui.web.action.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;

import tianrui.work.api.IUserService;
import tianrui.work.bean.User;
import tianrui.work.req.LoginReq;
import tianrui.work.req.ResistReq;
import tianrui.work.vo.Result;

/**
 * 注册，登录
 * @author jh
 *
 */
@Controller
@RequestMapping("public/user")
public class PublicMemberAction {

	@Autowired
	IUserService userService;
	
	@RequestMapping("loginPage")
	public ModelAndView index(String openid){
		ModelAndView view = new ModelAndView();
		System.out.println("-------------------------"+openid);
		view.addObject("openid", openid);
		view.setViewName("login");
		return view;
	}
	
	/** 登录*/
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Result login(HttpServletRequest request,LoginReq req) throws Exception{
		Result rs = Result.getSuccessful();
		rs = userService.login(req);
		User user = (User) rs.getData();
		SessionManage.setSessionManage(request, user);
		return rs;
	}
	/** 注册*/
	@RequestMapping(value="regist",method=RequestMethod.POST)
	@ResponseBody
	public Result regist(HttpServletRequest request,ResistReq req) throws Exception{
		Result rs = Result.getSuccessful();
		rs = userService.regist(req);
		User user = (User) rs.getData();
		SessionManage.setSessionManage(request, user);
		return rs;
	}
	/** 微信登录*/
	@RequestMapping(value="wxLogin",method=RequestMethod.POST)
	@ResponseBody
	public Result wxLogin(HttpServletRequest request,LoginReq req) throws Exception{
		Result rs = Result.getSuccessful();
		rs = userService.wxLogin(req);
		User user = (User) rs.getData();
		SessionManage.setSessionManage(request, user);
		return rs;
	}
}
