package tianrui.work.bean;


public class WeiXinPayXml {

	/*
	 * 企业付款
	 */
	public String outpayXml(BusinesPay pay){
		StringBuffer str = new StringBuffer();
		str.append("<xml><mch_appid>");
		str.append("<![CDATA[");
		str.append("wx8c38f7256d081b10");
		str.append("]]>");
		str.append("</mch_appid>");
		
		str.append("<mchid>");
		str.append("<![CDATA[");
		str.append("1487100762");
		str.append("]]>");
		str.append("</mchid>");
		
		str.append("<nonce_str>");
		str.append("<![CDATA[");
		str.append(pay.getNonce_str());
		str.append("]]>");
		str.append("</nonce_str>");
		
		str.append("<partner_trade_no>");
		str.append("<![CDATA[");
		str.append(pay.getPartner_trade_no());
		str.append("]]>");
		str.append("</partner_trade_no>");
		
		str.append("<openid>");
		str.append("<![CDATA[");
		str.append(pay.getOpenid());
		str.append("]]>");
		str.append("</openid>");
		
		str.append("<check_name>");
		str.append("<![CDATA[");
		str.append(pay.getCheck_name());
		str.append("]]>");
		str.append("</check_name>");
		
		str.append("<amount>");
		str.append("<![CDATA[");
		str.append(pay.getAmount());
		str.append("]]>");
		str.append("</amount>");
		
		str.append("<desc>");
		str.append("<![CDATA[");
		str.append(pay.getDesc());
		str.append("]]>");
		str.append("</desc>");
		
		str.append("<spbill_create_ip>");
		str.append("<![CDATA[");
		str.append(pay.getSpbill_create_ip());
		str.append("]]>");
		str.append("</spbill_create_ip>");
		
		str.append("<sign>");
		str.append("<![CDATA[");
		str.append(pay.getSign());
		str.append("]]>");
		str.append("</sign></xml>");
		return str.toString();
	}
	/*
	 * 微信支付
	 */
	public String payXml(WeiXinPay pay){
		StringBuffer str = new StringBuffer();
		str.append("<xml><appid>");
		str.append("<![CDATA[");
		str.append(pay.getAppid());
		str.append("]]>");
		str.append("</appid>");
		
		str.append("<body>");
		str.append("<![CDATA[");
		str.append(pay.getBody());
		str.append("]]>");
		str.append("</body>");
		
		str.append("<mch_id>");
		str.append("<![CDATA[");
		str.append(pay.getMch_id());
		str.append("]]>");
		str.append("</mch_id>");
		
		str.append("<openid>");
		str.append("<![CDATA[");
		str.append(pay.getOpenid());
		str.append("]]>");
		str.append("</openid>");
		
		str.append("<nonce_str>");
		str.append("<![CDATA[");
		str.append(pay.getNonce_str());
		str.append("]]>");
		str.append("</nonce_str>");
		
		str.append("<notify_url>");
		str.append("<![CDATA[");
		str.append(pay.getNotify_url());
		str.append("]]>");
		str.append("</notify_url>");
		
		str.append("<out_trade_no>");
		str.append("<![CDATA[");
		str.append(pay.getOut_trade_no());
		str.append("]]>");
		str.append("</out_trade_no>");
		
		str.append("<spbill_create_ip>");
		str.append("<![CDATA[");
		str.append(pay.getSpbill_create_ip());
		str.append("]]>");
		str.append("</spbill_create_ip>");
		
		str.append("<total_fee>");
		str.append("<![CDATA[");
		str.append(pay.getTotal_fee());
		str.append("]]>");
		str.append("</total_fee>");
		
		str.append("<trade_type>");
		str.append("<![CDATA[");
		str.append(pay.getTrade_type());
		str.append("]]>");
		str.append("</trade_type>");
		
		str.append("<sign>");
		str.append("<![CDATA[");
		str.append(pay.getSign());
		str.append("]]>");
		str.append("</sign></xml>");
		return str.toString();
	}
}
