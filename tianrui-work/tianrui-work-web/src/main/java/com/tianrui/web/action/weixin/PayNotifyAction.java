package com.tianrui.web.action.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tianrui.web.util.ReceiveXmlProcess;

/**
 * 微信支付回调
 * */
@Controller
@RequestMapping("weChat/payNotify")
public class PayNotifyAction {

	@RequestMapping("main")
	@ResponseBody
	public String main(HttpServletRequest request) throws IOException{
		BufferedReader re = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuffer bf = new StringBuffer();
		while((line = re.readLine())!=null){
			bf.append(line);
		}
		System.out.println("支付结果---"+bf.toString());
		//"<xml><appid><![CDATA[wx8c38f7256d081b10]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[50]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1487100762]]></mch_id><nonce_str><![CDATA[5293f298-178d-4f3a-b550-6086189]]></nonce_str><openid><![CDATA[o-OJTv_ftDalms42QPVn38jZ30L8]]></openid><out_trade_no><![CDATA[2017-0811-1843-1502448197]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[3EFDF777FAAC7A59A45DA6CEDBAB7857]]></sign><time_end><![CDATA[20170811183636]]></time_end><total_fee>50</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4003862001201708115697179097]]></transaction_id></xml>"
		Map map = new ReceiveXmlProcess().getwayEntity(bf.toString());
        System.out.println(map);
        String return_code = (String) map.get("return_code");
        String result_code = (String) map.get("result_code");
        if(return_code.equals("SUCCESS")&&result_code.equals("SUCCESS")){
        	JSONObject json = new JSONObject();
        	json.put("openId", map.get("openid"));
        	json.put("appId", map.get("appid"));
        	json.put("mchId", map.get("mch_id"));
        	json.put("outTradeNo", map.get("out_trade_no"));
        	json.put("totalFee", map.get("total_fee"));
        	json.put("timeEnd", map.get("time_end"));
        	json.put("tradeType", map.get("trade_type"));
        	json.put("transactionId", map.get("transaction_id"));
        	json.put("returnCode", map.get("return_code"));
        	json.put("resultCode", map.get("result_code"));
//        	String js = new ChuliService().commonUrl(json.toString(), "/App/addWeiXinPay", null);
     	    System.out.println(json);
        }
//        {"returnCode":"SUCCESS",
//        	"tradeType":"JSAPI",
//        	"transactionId":"4003862001201708115700800718",//订单号
//        	"timeEnd":"20170811184913",
//        	"totalFee":"10",
//        	"appId":"wx8c38f7256d081b10",
//        	"resultCode":"SUCCESS",
//        	"outTradeNo":"2017-0811-1855-1502448953",
//        	"mchId":"1487100762",
//        	"openId":"o-OJTv_ftDalms42QPVn38jZ30L8"}


		return null;
	}
}
