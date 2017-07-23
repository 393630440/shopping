package com.tianrui.web.smvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class WebAuthSpring implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("last");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("first");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		//鐢ㄦ埛鏉冮檺鎿嶄綔闇�
		if (!(handler instanceof HandlerMethod)) {
            return true;
        } else{
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			AutherWeb authType = handlerMethod.getMethodAnnotation(AutherWeb.class);
			System.out.println("authType="+authType.typeString());
        }
		return true;
	}

}
