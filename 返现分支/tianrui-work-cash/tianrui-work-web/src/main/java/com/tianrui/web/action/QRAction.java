package com.tianrui.web.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;

import tianrui.work.bean.MemberInfo;
import tianrui.work.comm.Constant;

@Controller
@RequestMapping("web/show/qr")
public class QRAction {

	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request){
		MemberInfo member = SessionManage.getSessionManage(request);
		ModelAndView view = new ModelAndView();
		String url = Constant.WEIXIN_BASE_URL+"/web/show/qr/relete?fatherId="+member.getMemberId();
		view.addObject("pathUrl", url);
		view.setViewName("shop/showqr/index");
		return view;
	}
	@RequestMapping("relete")
	public ModelAndView relete(String fatherId){
		ModelAndView view = new ModelAndView();
		String baseUrl = Constant.WEIXIN_BASE_URL+"/oauth2/weChat?fatherId="+fatherId;
		baseUrl = URLEncoder.encode(baseUrl);
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Constant.WEIXIN_APPID+"&redirect_uri="+baseUrl+"&response_type=code&scope=snsapi_userinfo&state=relete#wechat_redirectinfo";
		System.out.println("00000000000000000"+url);
		view.setViewName("redirect:"+url);
		return view;
	}
}
