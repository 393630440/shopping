package com.tianrui.web.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;

import tianrui.work.bean.ZhifuSign;

public class PaySignUtil {
	/**
	 * js签名
	 * @Description :
	 * @param 
	 * @return 
	 * ---------------
	 * @Author  : My
	 * @CreateData : 2016-2-15
	 */
    public static  ZhifuSign mapSign(String jsapi_ticket, String url,String nonce_str,String timestamp ) {
	        String string1;
	        String signature = "";
	        //注意这里参数名必须全部小写，且必须有序
	        string1 = "jsapi_ticket=" + jsapi_ticket +
	                  "&noncestr=" + nonce_str +
	                  "&timestamp=" + timestamp +
	                  "&url=" + url;
	        System.out.println("mapSign="+string1);
	        try
	        {
	            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	            crypt.reset();
	            crypt.update(string1.getBytes("UTF-8"));
	            signature = byteToHex(crypt.digest());
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
	        catch (UnsupportedEncodingException e)
	        {
	            e.printStackTrace();
	        }

	        ZhifuSign zhifu = new ZhifuSign();
	        zhifu.setUrl(url);
	        zhifu.setJsapi_ticket(jsapi_ticket);
	        zhifu.setNonceStr(nonce_str);
	        zhifu.setSignature(signature);
	        zhifu.setTimestamp(timestamp);
	        return zhifu;
	    }
	 
	  private static String byteToHex(final byte[] hash) {
	        Formatter formatter = new Formatter();
	        for (byte b : hash)
	        {
	            formatter.format("%02x", b);
	        }
	        String result = formatter.toString();
	        formatter.close();
	        return result;
	    }

	  public static  String create_nonce_str() {
	        return UUID.randomUUID().toString();
	    }

	  public static  String create_timestamp() {
	        return Long.toString(System.currentTimeMillis() / 1000);
	    }
}
