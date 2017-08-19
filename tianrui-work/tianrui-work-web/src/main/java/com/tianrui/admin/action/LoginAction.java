package com.tianrui.admin.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.admin.action.util.SessionAdminManager;

import tianrui.work.api.IAdminUserService;
import tianrui.work.bean.AdminUser;
import tianrui.work.req.admin.user.UserLoginReq;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/public/shop/adminLogin")
public class LoginAction {

	@Autowired
	IAdminUserService adminUserService;
	
	@RequestMapping("/loginPage")
	public ModelAndView loginPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/login/login");
		
		ClassLoader classLoader = Thread.currentThread()  
                .getContextClassLoader();  
       
    	if (classLoader == null) {  
            classLoader = ClassLoader.getSystemClassLoader();  
        }  
		java.net.URL urls = classLoader.getResource("");  
    	String ROOT_CLASS_PATH = urls.getPath() + "/";  
        File rootFile = new File(ROOT_CLASS_PATH);  
    	String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";  
    	File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);  
    	String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/"; 
    	
    	System.out.println(SERVLET_CONTEXT_PATH+"resources\\file");
		
		return view;
	}
	/** 后台登录
	 * @throws Exception */
	@RequestMapping("loginin")
	@ResponseBody
	public Result loginin(UserLoginReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		rs = adminUserService.loginIn(req);
		SessionAdminManager.setSessionManager(request, (AdminUser)rs.getData());
		return rs;
	}
}
