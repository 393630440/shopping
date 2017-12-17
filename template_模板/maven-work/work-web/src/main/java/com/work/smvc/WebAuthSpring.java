package com.work.smvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class WebAuthSpring implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod)) {
            return true;
        } else{
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			AutherWeb authType = handlerMethod.getMethodAnnotation(AutherWeb.class);
			if(authType != null && StringUtils.equals(authType.typeString(), "admin")){
//				AdminUser user = SessionAdminManager.getSessionManager(request);
//				if(user == null){
//					response.sendRedirect("/public/shop/adminLogin/loginPage");
//					return false;
//				}
			}
        }
		return true;
	}

}
