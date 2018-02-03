package com.tianrui.web.action.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianrui.web.util.FormatXmlProcess;
import com.tianrui.web.util.ReceiveXmlEntity;
import com.tianrui.web.util.ReceiveXmlProcess;
import com.tianrui.web.util.SignUtilSignature;

import tianrui.work.api.IMemberReleteService;
import tianrui.work.comm.Constant;

@Controller
@RequestMapping("work/weixin")
public class WeixinAction {
	
	@Autowired
	IMemberReleteService memberReleteService;
	
	/** 微信验证接口
	 * @throws IOException */
	@RequestMapping(value = "index",method=RequestMethod.GET)
	@ResponseBody
	public void index(
			String signature,
			String timestamp,
			String nonce,
			String echostr,
			HttpServletResponse response
			) throws IOException{
		// 通过 signature 对请求进行校验，若校验成功则原样返回 echostr，表示接入成功，否则接入失败
		if (!SignUtilSignature.checkSignature(signature, timestamp, nonce)) {
			echostr = "";
		}
		System.out.println("echostr=-----------------"+echostr);
		response.getWriter().write(echostr);
	}
	
	/** 微信验证接口
	 * @throws Exception */
	@RequestMapping(value = "index",method=RequestMethod.POST)
	@ResponseBody
	public String indextow(
			String signature,
			String timestamp,
			String nonce,
			String echostr,
			HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		if (SignUtilSignature.checkSignature(signature, timestamp, nonce)) {
			String respXml = null;
			respXml = processRequest(request,response);
			return respXml;
		}
		return "";
	}
	
	public String processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FormatXmlProcess formatxmls = new FormatXmlProcess();
		
		/** 读取接收到的xml消息 */
		StringBuffer sb = new StringBuffer();
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		String xml = sb.toString();	//次即为接收到微信端发送过来的xml数据
		
		ReceiveXmlEntity xmlEntity =new ReceiveXmlEntity();
		xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);//解析xml数据
		
		try {
			String openid = xmlEntity.getFromUserName();
			String fatherid = "";
			if(xmlEntity.getMsgType().equals("event")&&xmlEntity.getEvent().equals("subscribe")){
				fatherid = xmlEntity.getEventKey().substring(8, xmlEntity.getEventKey().length());
				System.out.println("关注人"+xmlEntity.getFromUserName());
				System.out.println("未关注even="+xmlEntity.getEvent());
				System.out.println("未关注EventKey="+xmlEntity.getEventKey());
				System.out.println("未关注Ticket="+xmlEntity.getTicket());
			}else if(xmlEntity.getMsgType().equals("event")&&xmlEntity.getEvent().equals("SCAN")){
				fatherid = xmlEntity.getEventKey();
				System.out.println("关注人"+xmlEntity.getFromUserName());
				System.out.println("已关注even="+xmlEntity.getEvent());
				System.out.println("已关注EventKey="+xmlEntity.getEventKey());
				System.out.println("已关注Ticket="+xmlEntity.getTicket());
			}
			memberReleteService.saveMemberRelete(fatherid,openid);
		} catch (Exception e) {
			System.out.println("关系绑定异常");
		}
		
		
		String respXml = null;
		String contxml=Constant.WEIXIN_BASE_URL+"/public/user/loginPage?openid="+xmlEntity.getFromUserName();//发送文字内容
		respXml = formatxmls.formatXmlAllContent(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), contxml);
		return respXml;
	}
	
	
	
}
