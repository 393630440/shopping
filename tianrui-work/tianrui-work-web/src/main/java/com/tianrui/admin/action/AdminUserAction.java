package com.tianrui.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.admin.action.util.SessionAdminManager;
import com.tianrui.web.smvc.AutherWeb;

import tianrui.work.api.IAdminUserService;
import tianrui.work.bean.AdminUser;
import tianrui.work.req.admin.user.UserFindReq;
import tianrui.work.req.admin.user.UserSaveReq;
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
	
	/**
	 * 个人信息修改
	 * @param request
	 * @return
	 */
	@RequestMapping("uptPage")
	@AutherWeb(typeString = "admin")
	public ModelAndView uptPage(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		AdminUser user = SessionAdminManager.getSessionManager(request);
		view.setViewName("admin/user/upt_user");
		view.addObject("user", user);
		return view;
	}
	@RequestMapping("upt")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result upt(UserSaveReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		rs = adminUserService.uptUser(req);
		SessionAdminManager.setSessionManager(request, (AdminUser)rs.getData());
		return rs;
	}
	
	/** 添加后台会员*/
	@RequestMapping("saveUsre")
	@AutherWeb(typeString = "admin")
	public ModelAndView saveUsrePage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/user/save_user");
		return view;
	}
	
	@RequestMapping("select")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result select(UserFindReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<UserFindResp> page = adminUserService.select(req);
		rs.setData(page);
		return rs;
	}
	/**修改会员状态
	 * @throws Exception */
	@RequestMapping("uptUser")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result uptUser(String id) throws Exception{
		return adminUserService.userDisable(id);
	}
	/** 添加会员
	 * @throws Exception */
	@RequestMapping("save")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result save(UserSaveReq req) throws Exception{
		return adminUserService.saveUser(req);
	}
}
