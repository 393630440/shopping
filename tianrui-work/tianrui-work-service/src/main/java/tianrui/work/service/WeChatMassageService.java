package tianrui.work.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import tianrui.work.api.IWeChatMassageService;
import tianrui.work.comm.Constant;
import tianrui.work.req.massage.MessageReq;
import tianrui.work.util.CommonUtil;
import tianrui.work.util.Tokens;
import tianrui.work.vo.Result;

@Service
public class WeChatMassageService implements IWeChatMassageService{

	@Override
	public Result saveMassage(MessageReq req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		String token = CommonUtil.getToken("wx8c38f7256d081b10", "6480e17b1b7a2ca96772d9a01c7be122");
		System.out.println(token);
		
		MessageReq req = new MessageReq();
		req.setId(Constant.MESSAGE_HPAO);
		req.setOpenid("o-OJTv_ftDalms42QPVn38jZ30L8");
		req.setObj1("2015-12-12");//交易时间
		req.setObj2("宏包交易");//交易类型
		req.setObj3("15");//交易积分
		req.setObj4("个人宏包");//交易来源
		putMessageHbao(req,token);
		
//		req.setId(Constant.MESSAGE_DINGD);
//		req.setOpenid("o-OJTv_ftDalms42QPVn38jZ30L8");
//		req.setObj1("035697452");//快递单号
//		req.setObj2("18331236598");//联系电话
//		putMessageDingD(req,token);
		
//		req.setId(Constant.MESSAGE_DSUCCE);
//		req.setOpenid("o-OJTv_ftDalms42QPVn38jZ30L8");
//		req.setObj1("035697452");//订单号
//		req.setObj2("10个");//数量
//		req.setObj3("100元");//金额
//		putMessageDsucce(req,token);
		
//		req.setId(Constant.MESSAGE_WDING);
//		req.setOpenid("o-OJTv_ftDalms42QPVn38jZ30L8");
//		req.setObj1("035697452");//订单号
//		req.setObj2("10元");//金额
//		putMessageWDing(req,token);
	}
	
	protected static void  putMessageWDing(MessageReq massages,String token) {
		//微信接口
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);//转换为响应接口模式
		//封装数据
		JSONObject json = new JSONObject();
		json.put("touser", massages.getOpenid());//接收者wxName
		json.put("template_id", massages.getId());//消息模板
//				json.put("url", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9841030479d77c4c&redirect_uri=http%3a%2f%2fwww.fagangwang.com%2fweixin%2fWWZ%2fchuli%3fact%3dshouquan&response_type=code&scope=snsapi_base&state=lahuo#wechat_redirect");
		
		JSONObject dd = new JSONObject();
		
		JSONObject dd2 = new JSONObject();
		dd2.put("value", "本次网购成功，祝您网购愉快...\n");//消息提示
		dd2.put("color", "#173177");
		dd.put("first", dd2);
		
		JSONObject ee2 = new JSONObject();
		ee2.put("value", massages.getObj1());//交易类型
		ee2.put("color", "#173177");
		dd.put("orderno", ee2);
	
		JSONObject jf = new JSONObject();
		jf.put("value", massages.getObj2());//交易积分
		jf.put("color", "#173177");
		dd.put("amount", jf);
		
		JSONObject gg2 = new JSONObject();
		gg2.put("value", "\n感谢对平台的支持...");
		gg2.put("color", "#173177");
//								gg2.put("value", "每天上午八点准时更新，请注意查看"+"\n(回复TD,取消消息提醒)");
		dd.put("remark", gg2);
		
		json.put("data", dd);
		System.out.println(json.toString());
		JSONObject js = CommonUtil.httpsRequest(url, "POST", json.toString());
		System.out.println(js.toString());
	}
	
	protected static void  putMessageDsucce(MessageReq massages,String token) {
		//微信接口
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);//转换为响应接口模式
		//封装数据
		JSONObject json = new JSONObject();
		json.put("touser", massages.getOpenid());//接收者wxName
		json.put("template_id", massages.getId());//消息模板
//		json.put("url", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9841030479d77c4c&redirect_uri=http%3a%2f%2fwww.fagangwang.com%2fweixin%2fWWZ%2fchuli%3fact%3dshouquan&response_type=code&scope=snsapi_base&state=lahuo#wechat_redirect");
		
		JSONObject dd = new JSONObject();
		
		JSONObject dd2 = new JSONObject();
		dd2.put("value", "您的订单已创建成功，请尽快支付...\n");//消息提示
		dd2.put("color", "#173177");
		dd.put("first", dd2);
		
		JSONObject ee2 = new JSONObject();
		ee2.put("value", massages.getObj1());//交易类型
		ee2.put("color", "#173177");
		dd.put("orderno", ee2);
	
		JSONObject jf = new JSONObject();
		jf.put("value", massages.getObj2());//交易积分
		jf.put("color", "#173177");
		dd.put("refundno", jf);
		
		JSONObject jfs = new JSONObject();
		jfs.put("value", massages.getObj3());//交易积分
		jfs.put("color", "#173177");
		dd.put("refundproduct", jfs);
	
		
		JSONObject gg2 = new JSONObject();
		gg2.put("value", "\n感谢对平台的支持...");
		gg2.put("color", "#173177");
//						gg2.put("value", "每天上午八点准时更新，请注意查看"+"\n(回复TD,取消消息提醒)");
		dd.put("remark", gg2);
		
		json.put("data", dd);
		System.out.println(json.toString());
		JSONObject js = CommonUtil.httpsRequest(url, "POST", json.toString());
		System.out.println(js.toString());
	}
	
	protected static void putMessageDingD(MessageReq massages,String token) {
		//微信接口
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);//转换为响应接口模式
		//封装数据
		JSONObject json = new JSONObject();
		json.put("touser", massages.getOpenid());//接收者wxName
		json.put("template_id", massages.getId());//消息模板
//				json.put("url", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9841030479d77c4c&redirect_uri=http%3a%2f%2fwww.fagangwang.com%2fweixin%2fWWZ%2fchuli%3fact%3dshouquan&response_type=code&scope=snsapi_base&state=lahuo#wechat_redirect");
		
		JSONObject dd = new JSONObject();
		
		JSONObject dd2 = new JSONObject();
		dd2.put("value", "您的商品订单已配送...\n");
		dd2.put("color", "#173177");
		dd.put("first", dd2);
		
		JSONObject ee2 = new JSONObject();
		ee2.put("value", massages.getObj1());
		ee2.put("color", "#173177");
		dd.put("keyword1", ee2);
	
		JSONObject jf = new JSONObject();
		jf.put("value", massages.getObj2());
		jf.put("color", "#173177");
		dd.put("keyword2", jf);
	
		
		JSONObject gg2 = new JSONObject();
		gg2.put("value", "\n感谢对平台的支持...");
		gg2.put("color", "#173177");
//				gg2.put("value", "每天上午八点准时更新，请注意查看"+"\n(回复TD,取消消息提醒)");
		dd.put("remark", gg2);
		
		json.put("data", dd);
		System.out.println(json.toString());
		JSONObject js = CommonUtil.httpsRequest(url, "POST", json.toString());
		System.out.println(js.toString());
	}
	
	protected static void putMessageHbao(MessageReq massages,String token) {
		//微信接口
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);//转换为响应接口模式
		//封装数据
		JSONObject json = new JSONObject();
		json.put("touser", massages.getOpenid());//接收者wxName
		json.put("template_id", massages.getId());//消息模板
//		json.put("url", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9841030479d77c4c&redirect_uri=http%3a%2f%2fwww.fagangwang.com%2fweixin%2fWWZ%2fchuli%3fact%3dshouquan&response_type=code&scope=snsapi_base&state=lahuo#wechat_redirect");
		
		JSONObject dd = new JSONObject();
		
		JSONObject dd2 = new JSONObject();
		dd2.put("value", "您有会员宏包交易...\n");//消息提示
		dd2.put("color", "#173177");
		dd.put("first", dd2);
		
	    JSONObject cc2 = new JSONObject();//交易时间
	    cc2.put("value", massages.getObj1());
	    cc2.put("color", "#173177");
		dd.put("time", cc2);
		
		JSONObject ee2 = new JSONObject();
		ee2.put("value", massages.getObj2());//交易类型
		ee2.put("color", "#173177");
		dd.put("type", ee2);
	
		JSONObject jf = new JSONObject();
		jf.put("value", massages.getObj3());//交易积分
		jf.put("color", "#173177");
		dd.put("Point", jf);
	
		JSONObject ly = new JSONObject();
		ly.put("value", massages.getObj4());//来源
		ly.put("color", "#173177");
		dd.put("From", ly);
		
		JSONObject gg2 = new JSONObject();
		gg2.put("value", "感谢对平台的支持...");
		gg2.put("color", "#173177");
//		gg2.put("value", "每天上午八点准时更新，请注意查看"+"\n(回复TD,取消消息提醒)");
		dd.put("remark", gg2);
		
		json.put("data", dd);
		System.out.println(json.toString());
		JSONObject js = CommonUtil.httpsRequest(url, "POST", json.toString());
		System.out.println(js.toString());
	}
	

}
