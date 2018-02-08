package com.tianrui.web.action.weixin;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.CommonUtil;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.api.IMemberReleteService;
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
	@Autowired
	IMemberReleteService memberReleteService;
	
	@RequestMapping("/MP_verify_xNE20nqeZABSEqki.txt")
	@ResponseBody
	public String conf(){
		return "xNE20nqeZABSEqki";
	}
	
	@RequestMapping("weChat")
	public ModelAndView weChat(String code,String state,String fatherId,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		ModelAndView view = new ModelAndView();
		JSONObject obj = CommonUtil.getOpenid(code);
		String openid= obj.getString("openid");
		
		String access_token = obj.getString("access_token");
		rs = memberInfoService.selectByOpenid(openid);
		if(!rs.getCode().equals("000000")){
			JSONObject objInfo = CommonUtil.getWeChatInfo(openid, access_token);
			System.out.println(objInfo);
			MemberInfoSaveReq req = new MemberInfoSaveReq();
			req.setMemberId(openid);
			req.setWechatName(objInfo.getString("nickname"));
			req.setWechatImg(objInfo.getString("headimgurl"));
			req.setWechat(openid);
			req.setCity(objInfo.getString("city"));
			rs = memberInfoService.saveMember(req);
		}
		if(StringUtils.isNotBlank(fatherId)){
			memberReleteService.saveMemberRelete(fatherId,openid);
		}
		MemberInfo info = (MemberInfo)rs.getData();
		SessionManage.setSessionManage(request, info);
		if(StringUtils.isNotBlank(info.getMemberName())||StringUtils.isNotBlank(info.getCellphone())){
			switch (state) {
			case "member":
				view.setViewName("redirect:/wechat/shop/member/userPage");
				break;
			case "creditor":
				view.setViewName("redirect:/wechat/shop/creditor/selectPage");
				break;
			case "goodsA":
				view.setViewName("redirect:/wechat/shop/goods/goodshome?goodsType=1");
				break;
			case "goodsB":
				view.setViewName("redirect:/wechat/shop/goods/goodshome?goodsType=2");
				break;
			case "ewm":
				view.setViewName("redirect:/web/show/qr/index?memberId="+openid);
				break;
			case "relete":
				view.setViewName("redirect:/wechat/shop/member/memberRelete");
				break;
			case "cash":
				view.setViewName("redirect:/wechat/shop/cashback/index");
				break;
			default:
				view.setViewName("redirect:/wechat/shop/member/userPage");
				break;
			}
		}else{
			view.setViewName("redirect:/wechat/shop/member/memberInfo");
		}
		return view;
	}
	
}
