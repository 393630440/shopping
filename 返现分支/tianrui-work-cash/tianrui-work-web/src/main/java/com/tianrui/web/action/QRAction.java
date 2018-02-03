package com.tianrui.web.action;

import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.comm.Constant;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.util.CommonUtil;
import tianrui.work.util.ImgUrlWeChat;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("web/show/qr")
public class QRAction {

	@Autowired
	IMemberInfoService memberInfoService;
	
	@RequestMapping("index")
	public ModelAndView index(String memberId) throws Exception{
		ModelAndView view = new ModelAndView();
		Result rs = memberInfoService.selectByOpenid(memberId);
		MemberInfo info = (MemberInfo) rs.getData();
		String img = "";
		if(StringUtils.isNotBlank(info.getShowQr())){
			img = info.getShowQr();
		}else{
			img = ImgUrlWeChat.getQrImg(memberId, CommonUtil.getToken().getAccessToken());
			MemberInfoSaveReq upt = new MemberInfoSaveReq();
			upt.setMemberId(memberId);
			upt.setShowQr(img);
			memberInfoService.uptMemberInfo(upt);
		}
//		String url = Constant.WEIXIN_BASE_URL+"/web/show/qr/relete?fatherId="+memberId;
		
		view.addObject("pathUrl", img);
		view.addObject("base", rs.getData());
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
