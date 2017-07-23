package com.tianrui.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String randNumber = "0123456789";//随机产生的字符串
//		String no = "18";
//		int num = 0;
//		do {
//			for (int i = 0; i < 9; i++) {
//				//获取10以内的数
//				int a = (int)(Math.random()*10);
//				no += String.valueOf(randNumber.charAt(a));
//			}
//			System.out.println(no);
//			font("18337129805");
//			num += 1;
//			System.out.println("发送条数："+num+"条");
//			no = "18";
//		} while (num<1);
		font("18337129805");
	}
	
	public static String font(String phone){
		try {
			URL url = new URL("http://www.371n.com/Yanzhengma_zc.i?phone="+phone);
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", " application/json");//设定 请求格式 json，也可以设定xml格式
			connection.setRequestProperty("Accept-Charset", "utf-8");  //设置编码语言
			
//			JSONObject obj = new JSONObject();
//			obj.put("phone", phone);
//			
//			String dataString = obj.toString();
//			byte[] bypes = dataString.getBytes("utf-8");
//			
//			connection.getOutputStream().write(bypes);// 输入参数
			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String response = in.readLine();
			System.out.println("请求返回数据："+response);
			return response;
		} catch (Exception e) {
			JSONObject obj = new JSONObject();
			obj.put("code", "1");
			obj.put("error", "网络异常");
			return obj.toString();
		}
	}
	

}
