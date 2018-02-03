package tianrui.work.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSONObject;

public class ImgUrlWeChat {
	
	/** 生成用户永久二维码*/
	public static String getQrImg(String openid,String token){
		JSONObject scene = new JSONObject(); 
		scene.put("scene_str", openid);
		JSONObject info = new JSONObject(); 
		info.put("scene", scene);
		JSONObject obj = new JSONObject();
		obj.put("action_name", "QR_LIMIT_STR_SCENE");
		obj.put("action_info", info);
		String param = obj.toJSONString();
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+token;
		
		String ss = httpPost(url,param);
		JSONObject ret = JSONObject.parseObject(ss);
		String trick = ret.getString("ticket");
		
		return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+URLEncoder.encode(trick);
	}
	
	public static String  httpPost(String url,String param){
		StringBuffer sb = new StringBuffer("");
	    try {
			URL realUrl = new URL(url);
	        // 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
	        // 设置通用的请求属性
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type","application/json");
	        // 发送POST请求必须设置如下两行
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        //连接
	        conn.connect();
	        // 获取URLConnection对象对应的输出流
	        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
	        out.writeBytes(param);
	        // flush输出流的缓冲
	        out.flush();
            out.close();
	        // 定义BufferedReader输入流来读取URL的响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String lines="";
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            // 断开连接
            conn.disconnect();
	    }catch(Exception e){
	    	System.out.println("异常信息"+e.getMessage());
	    }
	    return sb.toString();
	}
}
