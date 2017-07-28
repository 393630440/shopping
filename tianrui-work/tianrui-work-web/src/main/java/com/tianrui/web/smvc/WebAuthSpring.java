package com.tianrui.web.smvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.admin.action.util.SessionAdminManager;

import tianrui.work.bean.AdminUser;

public class WebAuthSpring implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("last");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view)
			throws Exception {
		System.out.println("first");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod)) {
            return true;
        } else{
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			AutherWeb authType = handlerMethod.getMethodAnnotation(AutherWeb.class);
			if(StringUtils.equals(authType.typeString(), "admin")){
				AdminUser user = SessionAdminManager.getSessionManager(request);
				if(user == null){
					response.sendRedirect("/public/shop/adminLogin/loginPage");
					return false;
				}
			}
        }
		return true;
	}

}
