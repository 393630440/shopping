package com.tianrui.web.action.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.CommonUtil;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.vo.Result;

/**
 * 网页授权处理工具
 * @author Administrator
 *
 */
@Controller
@RequestMapping("oauth2")
public class Oauth2Action {

	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("/MP_verify_T6OvneLFANuYNbvr.txt")
	@ResponseBody
	public String conf(){
		return "T6OvneLFANuYNbvr";
	}
	
	@RequestMapping("weChat")
	public ModelAndView weChat(String code,String state,HttpServletRequest request) throws Exception{
		//http://183-lisijia.imwork.net/oauth2/conf
//		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8c38f7256d081b10&redirect_uri=http%3a%2f%2f183-lisijia.imwork.net%2foauth2%2fweChat&response_type=code&scope=snsapi_base&state=test#wechat_redirect";
		ModelAndView view = new ModelAndView();
		JSONObject obj = CommonUtil.getOpenid(code);
		String openid= obj.getString("openid");
		String access_token = obj.getString("access_token");
		JSONObject objInfo = CommonUtil.getWeChatInfo(openid, access_token);
		System.out.println(objInfo);
		MemberInfoSaveReq req = new MemberInfoSaveReq();
		req.setMemberId(openid);
		req.setWechatName(objInfo.getString("nickname"));
		req.setWechatImg(objInfo.getString("headimgurl"));
		req.setWechat(openid);
		req.setCity(objInfo.getString("city"));
		Result rs = memberInfoService.saveMember(req);
		switch (state) {
		case "member":
			view.setViewName("");
		case "goods":
			view.setViewName("");
			break;

		default:
			view.setViewName("/shop/member/memberInfo");
			break;
		}
		SessionManage.setSessionManage(request, (MemberInfo)rs.getData());

		return view;
	}
	
}
