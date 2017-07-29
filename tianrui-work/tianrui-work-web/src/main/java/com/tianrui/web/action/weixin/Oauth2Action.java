package com.tianrui.web.action.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.tianrui.web.util.CommonUtil;
import com.tianrui.web.util.Configure;

/**
 * 网页授权处理工具
 * @author Administrator
 *
 */
@Controller
@RequestMapping("oauth2")
public class Oauth2Action {

	@RequestMapping("weChat")
	public void weChat(String code,String state){
		//http://183-lisijia.imwork.net/oauth2/weChat
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf22ce076abf3d066&redirect_uri=http%3a%2f%2f183-lisijia.imwork.net%2foauth2%2fweChat&response_type=code&scope=snsapi_base&state=test#wechat_redirect";
		JSONObject obj = CommonUtil.getOpenid(code);
		String openid= obj.getString("openid");
		String access_token = obj.getString("access_token");
		JSONObject objInfo = CommonUtil.getWeChatInfo(openid, access_token);
		System.out.println(objInfo);
//		{"sex":1,
//		"nickname":"李思佳",
//		"privilege":[],
//		"province":"河南",
//		"openid":"oxN_GwUfDDT47iFOpJz3LQ70z4KI",
//		"language":"zh_CN",
//		"headimgurl":"http://wx.qlogo.cn/mmopen/icMVrWV8Nt98yshm81GicqiblYz1BDI5WrsYuaO90iaqYsxOnBxehss9UNn7cQIHxeYL8eGR6iacJsYKGz9ZiazpUgDGyJXcZqDtyia/0",
//		"country":"中国",
//		"city":"郑州"}

	}
	
}
