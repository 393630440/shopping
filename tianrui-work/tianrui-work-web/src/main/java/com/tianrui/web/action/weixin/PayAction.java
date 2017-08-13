package com.tianrui.web.action.weixin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.CommonUtil;
import com.tianrui.web.util.PaySignUtil;
import com.tianrui.web.util.Payxiadan;
import com.tianrui.web.util.Sign;

import tianrui.work.api.IWeChatPayService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.PayEntity;
import tianrui.work.bean.ZhifuSign;
import tianrui.work.comm.Constant;
import tianrui.work.req.HbaoPayReq;
import tianrui.work.req.WeChatPayReq;

@Controller
@RequestMapping("/wechat/shop/pay")
public class PayAction {

	@Autowired
	IWeChatPayService weChatPayService;
	
	@RequestMapping("page")
	public ModelAndView page(HttpServletRequest request,HbaoPayReq req) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		
		String openid = info.getMemberId();
		System.out.println("openid==" + openid);
		String nonce_str = PaySignUtil.create_nonce_str().substring(0,31);//随记字符创
	    String timestamp = PaySignUtil.create_timestamp();//时间戳
	    //获取jsapi_ticket
	    String jsapi_ticket = jsapi_ticket();
		//获取发送者IP；
		String spbill_create_ip = request.getRemoteAddr();
		//config签名验证,调用微信jssdk凭证
		ZhifuSign zhifu = new ZhifuSign();
		zhifu = PaySignUtil.mapSign(jsapi_ticket, Constant.WEIXIN_BASE_URL+"/wechat/shop/pay/page?payMoney="+req.getPayMoney()+"&toPayOpenid="+req.getToPayOpenid()+"&payNum="+req.getPayNum(),nonce_str,timestamp);//网页验证成功
		zhifu.setAppid(Constant.WEIXIN_APPID);
		Map<String, String> way = new HashMap<String, String>();
		PayEntity pay = new PayEntity();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm"); 
		String payNo = formatter.format(new Date())+timestamp; 
		//微信支付下单
		way = new Payxiadan().getprepay_id(nonce_str,spbill_create_ip,openid,payNo,req.getPayMoney().toString());
		
		WeChatPayReq save = new WeChatPayReq();
		save.setTransid(way.get("prepay_id").toString());
		save.setTotalfee(req.getPayMoney());
		save.setOpenid(info.getMemberId());
		save.setMemberid(req.getToPayOpenid());
		save.setOuttradeno(payNo);
		save.setPayNum(req.getPayNum());
		weChatPayService.save(save);
		
		pay.setPackages("prepay_id="+way.get("prepay_id").toString());
		
		//微信支付签名
		pay.setNonceStr(nonce_str);
		pay.setTimeStamp(timestamp);
		PayEntity payEntity=Sign.llpaysign(pay);
		
		view.addObject("zhifu", zhifu);
		view.addObject("payEntity", payEntity);
		view.addObject("payMoney", req.getPayMoney());
		view.setViewName("/shop/pay/weChatPay");
		return view;
	}
	
	public String jsapi_ticket(){
		// TODO Auto-generated method stub
		String accessToken = "";
		String jsapi_ticket = "";
		// 凭证获取（GET）
		String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		String requestUrl = token_url.replace("APPID", Constant.WEIXIN_APPID).replace("APPSECRET", Constant.WEIXIN_APPSECRET);
		// 发起GET请求获取凭证
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				accessToken = jsonObject.getString("access_token");
				System.out.println("token = " + accessToken);
			} catch (JSONException e) {
				// 获取token失败
				System.out.println("获取token失败");
			}
		}
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
		JSONObject js = CommonUtil.httpsRequest(url, "GET", null);
		try {
			jsapi_ticket = js.getString("ticket");
			System.out.println("jsapi_ticket="+jsapi_ticket);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取token失败");
		}
		return jsapi_ticket;
	}
}
