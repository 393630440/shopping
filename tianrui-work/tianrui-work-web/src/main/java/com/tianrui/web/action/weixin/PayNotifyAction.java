package com.tianrui.web.action.weixin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianrui.web.util.ReceiveXmlProcess;

import tianrui.work.api.IMemberInfoService;
import tianrui.work.api.IWeChatPayService;
import tianrui.work.req.HbaoPayReq;
import tianrui.work.resp.WeChatPayResp;

/**
 * 寰俊鏀粯鍥炶皟
 * */
@Controller
@RequestMapping("weChat/payNotify")
public class PayNotifyAction {
	
	@Autowired
	IMemberInfoService memberInfoService;
	@Autowired
	IWeChatPayService weChatPayService;
	
	@RequestMapping("main")
	@ResponseBody
	public String main(HttpServletRequest request) throws Exception{
		BufferedReader re = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuffer bf = new StringBuffer();
		while((line = re.readLine())!=null){
			bf.append(line);
		}
		System.out.println("鏀粯缁撴灉---"+bf.toString());
		//"<xml><appid><![CDATA[wx8c38f7256d081b10]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[50]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1487100762]]></mch_id><nonce_str><![CDATA[5293f298-178d-4f3a-b550-6086189]]></nonce_str><openid><![CDATA[o-OJTv_ftDalms42QPVn38jZ30L8]]></openid><out_trade_no><![CDATA[2017-0811-1843-1502448197]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[3EFDF777FAAC7A59A45DA6CEDBAB7857]]></sign><time_end><![CDATA[20170811183636]]></time_end><total_fee>50</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4003862001201708115697179097]]></transaction_id></xml>"
		Map map = new ReceiveXmlProcess().getwayEntity(bf.toString());
        System.out.println(map);
        String return_code = (String) map.get("return_code");
        String result_code = (String) map.get("result_code");
        if(return_code.equals("SUCCESS")&&result_code.equals("SUCCESS")){
        	//支付成功-修改记录
        	String outTradeNo = map.get("out_trade_no").toString();
        	WeChatPayResp resp = weChatPayService.select(outTradeNo);
        	if(resp.getPaystatus().equals("0")){
        		//支付成功
        		HbaoPayReq req =new HbaoPayReq();
        		req.setGoPayOpenid(resp.getOpenid());
        		req.setPayNum(resp.getPaynum());
        		req.setToPayOpenid(resp.getMemberid());
        		memberInfoService.changeHbao(req);
        		weChatPayService.uptPayStatus(outTradeNo);
        		return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        	}
        }
        return null;
	}
}