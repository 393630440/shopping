package com.tianrui.web.util;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

import tianrui.work.bean.BusinesPay;
import tianrui.work.bean.Hongbao;
import tianrui.work.bean.LieBianHongbao;
import tianrui.work.bean.PayEntity;
import tianrui.work.bean.WeiXinPay;
import tianrui.work.comm.Constant;

import java.util.Map;
import java.util.HashMap;
import java.util.Formatter;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;  

public class Sign {
	
    /**
     * 获取随记签名
     * @Description :
     * @param 
     * @return 
     * ---------------
     * @Author  : My
     * @CreateData : 2016-1-26
     */
    public static String nonce_str(){
    	String noncestr = create_nonce_str();
    	return noncestr;
    }
    
    /**
     * 企业付款签名
     * @Description :
     * @param 
     * @return 
     * ---------------
     * @throws Exception 
     * @Author  : My
     * @CreateData : 2016-3-21
     */
    public static BusinesPay BusinesPaySign(BusinesPay bus) throws Exception{
    	String appid ="mch_appid=" + bus.getMch_appid();//公众号id
		String amount ="amount=" + bus.getAmount();//付款金额(分)
		String check_name ="check_name=" + bus.getCheck_name();//校验姓名，NO_CHECK：不校验真实姓名；FORCE_CHECK：强校验真实姓名OPTION_CHECK：针对已实名认证的用户才校验真实姓名
		String desc ="desc=" + bus.getDesc();//描述
		String mchid = "mchid=" + bus.getMchid();//商户id
		String nonce_str = "nonce_str=" + bus.getNonce_str();//随记字符串
		String openid = "openid=" + bus.getOpenid();//用户唯一标识
		String partner_trade_no = "partner_trade_no=" + bus.getPartner_trade_no();//商户订单号，需保持唯一性
		String ip = "spbill_create_ip=" + bus.getSpbill_create_ip();//调用接口的机器Ip地址
		String key="key=f4bf53f5fa00658a3ad9d1e2770db545";
		
		String[] arr = new String[]{appid,amount,check_name,desc,mchid,nonce_str,openid,partner_trade_no,ip};
		Arrays.sort(arr);
    	StringBuilder content = new StringBuilder();
    	for(int i = 0; i < arr.length; i++){
    		content.append(arr[i]+"&");
    	}
    	content.append(key);
    
        System.out.println("content========"+content.toString());
    	String sign = MD5.hbMD5(content.toString()).toUpperCase();
    	System.out.println("sign="+sign);
    	bus.setSign(sign);
    	return bus;
    }
    
    
    
    /**
     * 下单签名
     * @Description :
     * @param 
     * @return 
     * ---------------
     * @Author  : My
     * @CreateData : 2016-3-7
     */
    public static PayEntity llpaysign(PayEntity pay) throws Exception{
    	String appid = "appId="+ "wx9841030479d77c4c";
    	String timeStamp = "timeStamp="+pay.getTimeStamp();
    	String nonceStr = "nonceStr="+pay.getNonceStr();
    	String packages = "package="+pay.getPackages();
    	String signType = "signType=MD5";
    	String key="key=f4bf53f5fa00658a3ad9d1e2770db545";
    	String[] arr = new String[]{appid,timeStamp,nonceStr,packages,signType};
    	
    	Arrays.sort(arr);
    	StringBuilder content = new StringBuilder();
    	for(int i = 0; i < arr.length; i++){
    		content.append(arr[i]+"&");
    	}
    	content.append(key);
    
    	String ss = MD5.hbMD5(content.toString()).toUpperCase();
    	pay.setPaySign(ss);
    	return pay;
    }
    
    private static  String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

	/**
     * 裂变红包签名
     * @Description :
     * @param 
     * @return 
     * ---------------
     * @throws Exception 
     * @Author  : My
     * @CreateData : 2016-1-29
     */
    public static LieBianHongbao lbhongbaosign(LieBianHongbao hb) throws Exception{
    	String string1;
    	String signature;
    	
//    	String act_name = hb.getAct_name();
//    	string1 = 
    	String act_name="act_name="+hb.getAct_name();
    	String amt_type="amt_type="+hb.getAmt_type();
    	String mch_billno="mch_billno="+hb.getMch_billno();
    	String mch_id="mch_id="+hb.getMch_id();
    	String nonce_str="nonce_str="+hb.getNonce_str();
    	String re_openid="re_openid="+hb.getRe_openid();
    	String remark="remark="+hb.getRemark();
    	String send_name="send_name="+hb.getSend_name();
    	String total_amount="total_amount="+hb.getTotal_amount();
    	String total_num="total_num="+hb.getTotal_num();
    	String wishing="wishing="+hb.getWishing();
    	String wxappid="wxappid="+hb.getWxappid();
    	String key="key=f4bf53f5fa00658a3ad9d1e2770db545";
    	
    	String[] arr= new String[]{act_name,amt_type,mch_billno,mch_id,nonce_str,re_openid,remark,send_name,total_amount,total_num
    			,wishing,wxappid};	
    	 StringBuilder content = new StringBuilder();
         for(int i = 0; i < arr.length; i++){
             content.append(arr[i]+"&");
         }
         content.append(key);
    	String ss = MD5.hbMD5(content.toString()).toUpperCase();
    	hb.setSign(ss);
    	
    	return hb;
    }
    
    /**
     * 普通红包签名
     * @Description :
     * @param 
     * @return 
     * ---------------
     * @throws Exception 
     * @Author  : My
     * @CreateData : 2016-1-26
     */
    public static Hongbao hongbaosign(Hongbao hb) throws Exception {
    	
    	//注意这里参数名必须全部小写，且必须有序
    	String act_name = "act_name="+hb.getAct_name();
    	String client_ip = "client_ip="+hb.getClient_ip();
    	String mch_billno =	"mch_billno="+hb.getMch_billno();
    	String mch_id = "mch_id="+hb.getMch_id();
    	String nonce_str = "nonce_str="+hb.getNonce_str();
    	String re_openid = "re_openid="+hb.getRe_openid();
    	String remark =	"remark="+hb.getRemark();
    	String send_name = "send_name="+hb.getSend_name();
    	String total_amount = "total_amount="+hb.getTotal_amount();
    	String total_num = "total_num="+hb.getTotal_num();
    	String wishing = "wishing="+hb.getWishing();
    	String wxappid = "wxappid="+hb.getWxappid();
    	String key ="key=f4bf53f5fa00658a3ad9d1e2770db545";
    	
    	String[] arr = new String[]{act_name,client_ip,mch_billno,mch_id,nonce_str,re_openid,remark,send_name,total_amount,total_num,wishing,wxappid};
    	
    	StringBuilder content = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            content.append(arr[i]+"&");
        }
        content.append(key);
        String ss = MD5.hbMD5(content.toString()).toUpperCase();
    	hb.setSign(ss);
    	return hb;
    }

    /**
     * 微信下单签名
     * @Description :
     * @param 
     * @return 
     * ---------------
     * @Author  : My
     * @CreateData : 2016-3-4
     */
    public static WeiXinPay paysign(WeiXinPay pay) throws Exception {
    	
    	//公众号唯一标识
    	String appid= "appid="+Constant.WEIXIN_APPID;
    	
    	String openid = "openid="+pay.getOpenid();
    	//商户唯一标识
    	String mch_id="mch_id="+Constant.WEIXIN_SHANGPU;
    	//随记字符串
    	String nonce_str="nonce_str="+pay.getNonce_str();
    	//商品描述
    	String body="body="+pay.getBody();
    	//商户订单号
    	String out_trade_no="out_trade_no="+pay.getOut_trade_no();
    	//总金额
    	String total_fee="total_fee="+pay.getTotal_fee();
    	//终端IP
    	String spbill_create_ip="spbill_create_ip="+pay.getSpbill_create_ip();
    	//通知地址
    	String notify_url="notify_url="+pay.getNotify_url();
    	//交易类型 取值如下：JSAPI，NATIVE，APP
    	String trade_type="trade_type="+pay.getTrade_type();
    	
    	String key ="key=";
    	
    	String[] arr = new String[]{openid,appid,mch_id,nonce_str,body,out_trade_no,total_fee,spbill_create_ip,notify_url,trade_type};
    	
    	Arrays.sort(arr);
    	StringBuilder content = new StringBuilder();
    	for(int i = 0; i < arr.length; i++){
    		content.append(arr[i]+"&");
    	}
    	content.append(key);
    	System.out.println("paysign="+content.toString());
    	String ss = MD5.hbMD5(content.toString()).toUpperCase();
    	System.out.println("sign="+ss);
    	pay.setSign(ss);
    	return pay;
    }
    
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    public static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
