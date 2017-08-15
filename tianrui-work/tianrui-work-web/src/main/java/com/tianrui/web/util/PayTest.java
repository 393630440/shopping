package com.tianrui.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import tianrui.work.bean.BusinesPay;
import tianrui.work.bean.WeiXinPayXml;


public class PayTest {

	public static void main(String[] args) throws Exception {
		getprepay_id("2","o-OJTv_ftDalms42QPVn38jZ30L8");
	}
	 
	public static  Map getprepay_id(String money,String openid)  throws Exception {
		//设置请求参数
		BusinesPay bus = new BusinesPay();
		bus.setMch_appid("wx8c38f7256d081b10");//公众号id
		float mon = Float.parseFloat(money);
		mon = mon*100;
		String ss = String.valueOf(mon);
		bus.setAmount(ss.substring(0,ss.length()-2));//付款金额(分)
//		bus.setAmount("200");//付款金额(分)
		bus.setCheck_name("NO_CHECK");//校验姓名，NO_CHECK：不校验真实姓名；FORCE_CHECK：强校验真实姓名OPTION_CHECK：针对已实名认证的用户才校验真实姓名
		bus.setDesc("ceshi");//描述
		bus.setMchid("1487100762");//商户id
		bus.setNonce_str(Sign.nonce_str().substring(0,30));//随记字符串
		bus.setOpenid(openid);//用户唯一标识
//		bus.setOpenid("og3vKwnK20cgqE8GEWDrRpCnly7A");//用户唯一标识
		bus.setPartner_trade_no("20160304011"+Sign.create_timestamp());//商户订单号，需保持唯一性
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress();//获得本机IP
		bus.setSpbill_create_ip(ip);//调用接口的机器Ip地址
		
		BusinesPay paysign = Sign.BusinesPaySign(bus);
		
		String xml = new WeiXinPayXml().outpayXml(paysign);
		
		//设置请求参数
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
		
		ClassLoader classLoader = Thread.currentThread()  
                .getContextClassLoader();  
       
    	if (classLoader == null) {  
            classLoader = ClassLoader.getSystemClassLoader();  
        }  
		java.net.URL urls = classLoader.getResource("");  
    	String ROOT_CLASS_PATH = urls.getPath() + "/";  
        File rootFile = new File(ROOT_CLASS_PATH);  
    	String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";  
    	File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);  
    	String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/";  
        
//       String  xmlFile = SERVLET_CONTEXT_PATH + "/cert/apiclient_cert.p12";
    	 String  xmlFile = "F:/new/shopping/tianrui-work/tianrui-work-web/src/main/webapp/cert/apiclient_cert.p12";
    	System.out.println(xmlFile);
		
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(xmlFile));
        try {
            keyStore.load(instream, "1487100762".toCharArray());//商户密码
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, "1487100762".toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
       
        Map way = new HashMap();

        try {
        	HttpPost post = new HttpPost(url);
        	System.out.println("xml========="+xml);
        	HttpEntity ent = new StringEntity(xml, "UTF-8");  
        	post.setEntity(ent);
        	HttpResponse response2 = new DefaultHttpClient().execute(post);
            

        	System.out.println("executing request==" + post.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(post);
            try {
                HttpEntity entity = response.getEntity();

                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String text ;
                    StringBuffer buf = new StringBuffer();
                    while ((text = bufferedReader.readLine()) != null) {
                        buf.append(text);
                    	System.out.println(text);
                    }
                    way = new ReceiveXmlProcess().getwayEntity(buf.toString());
                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
		return way;
	}
}
