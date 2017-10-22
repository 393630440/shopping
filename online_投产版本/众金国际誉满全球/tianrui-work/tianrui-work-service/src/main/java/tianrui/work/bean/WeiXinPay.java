package tianrui.work.bean;

import tianrui.work.comm.Constant;

/**
 * 微信统一下单实体类
 * @author My
 * @CreateDate 2016-3-3
 * @param
 */
public class WeiXinPay {
	//公众号唯一标识
	private String appid=Constant.WEIXIN_APPID;
	
	private String openid;
	//商户唯一标识
	private String mch_id=Constant.WEIXIN_SHANGPU;
	//随记字符串
	private String nonce_str;
	//签名
	private String sign;
	//商品描述
	private String body;
	//商户订单号
	private String out_trade_no;
	//总金额
	private String total_fee;
	//终端IP
	private String spbill_create_ip;
	//通知地址
	private String notify_url;
	//交易类型 取值如下：JSAPI，NATIVE，APP
	private String trade_type="JSAPI";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}


	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	
	
}
