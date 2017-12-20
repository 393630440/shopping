package com.tianrui.web.action.weixin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.CommonUtil;
import com.tianrui.web.util.LoggerUtils;
import com.tianrui.web.util.PaySignUtil;
import com.tianrui.web.util.Payxiadan;
import com.tianrui.web.util.PayxiadanReq;
import com.tianrui.web.util.Sign;

import tianrui.work.api.IOrderInfoService;
import tianrui.work.api.IWeChatPayService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.PayEntity;
import tianrui.work.bean.ZhifuSign;
import tianrui.work.comm.Constant;
import tianrui.work.req.HbaoPayReq;
import tianrui.work.req.JfPaySuccessReq;
import tianrui.work.req.WeChatPayReq;
import tianrui.work.resp.WeChatPayResp;
import tianrui.work.resp.order.OrderInfoFindResp;

@Controller
@RequestMapping("/wechat/shop/pay")
public class PayAction {

	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	IWeChatPayService weChatPayService;
	@Autowired
	IOrderInfoService orderInfoService;
	
	@RequestMapping("billPay")
	public ModelAndView billPay(HttpServletRequest request,String id,double balance,double cashMoney,double redPacket) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		LoggerUtils.info(log, "订单支付结算开始");
		OrderInfoFindResp resp = orderInfoService.queryOrderInfoByOne(id);
		Double money = resp.getOrderAmount()+resp.getExpressFee()-balance-cashMoney-redPacket;
		LoggerUtils.info(log, "结算金额="+money);
		if(money<=0){
			WeChatPayResp req = new WeChatPayResp();
			req.setTransid(id);
			req.setBlance(balance);
			req.setCashMoney(cashMoney);
			req.setRedPacket(redPacket);
			orderInfoService.orderPaySuccess(req);
			view.setViewName("redirect:/wechat/shop/member/userPage");
		}else{
			String openid = info.getMemberId();
			LoggerUtils.info(log, "用户openid"+openid);
			String nonce_str = PaySignUtil.create_nonce_str().substring(0,31);//随记字符创
			String timestamp = PaySignUtil.create_timestamp();//时间戳
			//获取jsapi_ticket
			String jsapi_ticket = jsapi_ticket();
			//获取发送者IP；
			String spbill_create_ip = request.getRemoteAddr();
			//config签名验证,调用微信jssdk凭证
			ZhifuSign zhifu = new ZhifuSign();
			zhifu = PaySignUtil.mapSign(jsapi_ticket, Constant.WEIXIN_BASE_URL+"/wechat/shop/pay/billPay?id="+id+"&cashMoney="+cashMoney+"&redPacket="+redPacket+"&balance="+balance,nonce_str,timestamp);//网页验证成功
			zhifu.setAppid(Constant.WEIXIN_APPID);
			Map<String, String> way = new HashMap<String, String>();
			PayEntity pay = new PayEntity();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm"); 
			String payNo = formatter.format(new Date())+timestamp; 
			//微信支付下单
			PayxiadanReq xd = new PayxiadanReq();
			xd.setNonce_str(nonce_str);
			xd.setIp(spbill_create_ip);
			xd.setOpenid(openid);
			xd.setWaybillid(payNo);
			xd.setMoney(money.toString());
			xd.setTotal("订单支付");
			xd.setNotify("/weChat/payNotify/billPay");
			way = new Payxiadan().getprepay_id(xd);
			
			WeChatPayReq save = new WeChatPayReq();
			save.setTransid(id);
			save.setTotalfee(money);
			save.setCashMoney(cashMoney);
			save.setBlance(balance);
			save.setRedPacket(redPacket);
			save.setPayNum(Double.valueOf(resp.getOrderRedPacket()));
			save.setOpenid(info.getMemberId());
			save.setOuttradeno(payNo);
			weChatPayService.save(save);
			pay.setPackages("prepay_id="+way.get("prepay_id").toString());
			//微信支付签名
			pay.setNonceStr(nonce_str);
			pay.setTimeStamp(timestamp);
			PayEntity payEntity=Sign.llpaysign(pay);
			view.addObject("zhifu", zhifu);
			view.addObject("payEntity", payEntity);
			view.addObject("payMoney", money);
			view.setViewName("/shop/pay/weChatPay");
		}
		return view;
	}
	
	@RequestMapping("cpage")
	public ModelAndView cpage(HttpServletRequest request,Double payMoney) throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		LoggerUtils.info(log, "账户充值结算开始");
		String openid = info.getMemberId();
		LoggerUtils.info(log, "用户openid"+openid);
		String nonce_str = PaySignUtil.create_nonce_str().substring(0,31);//随记字符创
	    String timestamp = PaySignUtil.create_timestamp();//时间戳
	    //获取jsapi_ticket
	    String jsapi_ticket = jsapi_ticket();
		//获取发送者IP；
		String spbill_create_ip = request.getRemoteAddr();
		//config签名验证,调用微信jssdk凭证
		ZhifuSign zhifu = new ZhifuSign();
		zhifu = PaySignUtil.mapSign(jsapi_ticket, Constant.WEIXIN_BASE_URL+"/wechat/shop/pay/cpage?payMoney="+payMoney,nonce_str,timestamp);//网页验证成功
		zhifu.setAppid(Constant.WEIXIN_APPID);
		Map<String, String> way = new HashMap<String, String>();
		PayEntity pay = new PayEntity();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm"); 
		String payNo = formatter.format(new Date())+timestamp; 
		//微信支付下单
		PayxiadanReq xd = new PayxiadanReq();
		xd.setNonce_str(nonce_str);
		xd.setIp(spbill_create_ip);
		xd.setOpenid(openid);
		xd.setWaybillid(payNo);
		xd.setMoney(payMoney.toString());
		xd.setTotal("会员充值");
		xd.setNotify("/weChat/payNotify/chongZ");
		way = new Payxiadan().getprepay_id(xd);
		
		WeChatPayReq save = new WeChatPayReq();
		save.setTransid(way.get("prepay_id").toString());
		save.setTotalfee(payMoney);
		save.setOpenid(info.getMemberId());
		save.setOuttradeno(payNo);
		weChatPayService.save(save);
		
		pay.setPackages("prepay_id="+way.get("prepay_id").toString());
		
		//微信支付签名
		pay.setNonceStr(nonce_str);
		pay.setTimeStamp(timestamp);
		PayEntity payEntity=Sign.llpaysign(pay);
		
		view.addObject("zhifu", zhifu);
		view.addObject("payEntity", payEntity);
		view.addObject("payMoney", payMoney);
		view.setViewName("/shop/pay/weChatPay");
		return view;
	}
	
	@RequestMapping("page")
	public ModelAndView page(HttpServletRequest request,HbaoPayReq req) throws Exception{
		
		LoggerUtils.info(log, "宏包交易结算开始");
		ModelAndView view = new ModelAndView();
		MemberInfo info = SessionManage.getSessionManage(request);
		
		String openid = info.getMemberId();
		LoggerUtils.info(log, "用户openid"+openid);
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
		PayxiadanReq xd = new PayxiadanReq();
		xd.setNonce_str(nonce_str);
		xd.setIp(spbill_create_ip);
		xd.setOpenid(openid);
		xd.setWaybillid(payNo);
		xd.setMoney(req.getPayMoney().toString());
		xd.setTotal("宏包交易");
		xd.setNotify("/weChat/payNotify/main");
		way = new Payxiadan().getprepay_id(xd);
		
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
		String accessToken = "";
		String jsapi_ticket = "";
		// 凭证获取（GET）
		String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		String requestUrl = token_url.replace("APPID", Constant.WEIXIN_APPID).replace("APPSECRET", Constant.WEIXIN_APPSECRET);
		// 发起GET请求获取凭证
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		LoggerUtils.info(log, "token请求结果="+jsonObject);
		if (null != jsonObject) {
			try {
				accessToken = jsonObject.getString("access_token");
			} catch (JSONException e) {
				// 获取token失败
				LoggerUtils.info(log, "token请求失败");
			}
		}
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
		JSONObject js = CommonUtil.httpsRequest(url, "GET", null);
		LoggerUtils.info(log, "jsapi_ticket请求结果="+js);
		try {
			jsapi_ticket = js.getString("ticket");
		} catch (Exception e) {
			LoggerUtils.info(log, "jsapi_ticket请求失败");
		}
		return jsapi_ticket;
	}
}
