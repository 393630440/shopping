package com.tianrui.web.util;

/**
 * 
 * @author My
 * @CreateDate 2016-3-25
 * @param
 */
public class PayxiadanReq {
	private String nonce_str;
	private String ip;
	private String openid;
	private String waybillid;
	private String money;
	private String total;
	private String notify;
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getWaybillid() {
		return waybillid;
	}
	public void setWaybillid(String waybillid) {
		this.waybillid = waybillid;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getNotify() {
		return notify;
	}
	public void setNotify(String notify) {
		this.notify = notify;
	}
}
