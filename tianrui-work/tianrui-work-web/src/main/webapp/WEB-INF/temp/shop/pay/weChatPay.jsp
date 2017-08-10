<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  	  <meta name="viewport"
			content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta name="format-detection" content="telephone=yes" />
		<meta name="format-detection" content="email=no" />
		<meta name="screen-orientation" content="portrait">	<!-- 强制竖屏 -->
    <title>微信支付</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
 <div align="center" style="margin-top: 40px; font-size: 20px">
	  	<div style="width: 10%"></div>
	  	<div align="left" style="width: 80%" >
	  		<div align="center" style="font-size: 25px">发钢网运费结算</div>
	  		<div style="margin-top: 20px">
	  		订单编号：${waybillId }<br>
	    	支付金额：<span style="color: red">${money }</span>元<br>
	  		</div>
	  	</div>
	  	<div style="width: 10%"></div>
	    <input style="border:0; font-size:20px; margin-top:20px; color:#FFFAFA; background-color: #00CD00;width: 80%;height: 40px" type="button" onclick="onBridgeReady();" value="微信支付">
 </div> 
 <div align="center" style="font-size: 13px; margin-top: 80px">
		郑东新区农业东路（如意西路）建业总部港F栋北10F<br>
	Tell: 400-679-1881<br>
	Email: service@fagangwang.com<br>
 </div>
 </body>
  
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
  /*
   * 注意：
   * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
   * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
   * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
   *
   * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
   * 邮箱地址：weixin-open@qq.com
   * 邮件主题：【微信JS-SDK反馈】具体问题
   * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
   */
  wx.config({
      debug: true ,
      appId: '${zhifu.appid}',
      timestamp: ${zhifu.timestamp},
      nonceStr: '${zhifu.nonceStr}',
      signature: '${zhifu.signature}',
      jsApiList: [
        'chooseWXPay',
        'getBrandWCPayRequest'
      ]
  });
  
  wx.ready(function(){
  });
  wx.error(function(res){
	alert("微信支付暂无法使用");
});
  
   function onBridgeReady(){
	   WeixinJSBridge.invoke(
	       'getBrandWCPayRequest', {
	           "appId":"${payEntity.appid}", 
	           "timeStamp":"${payEntity.timeStamp}",       
	           "nonceStr": "${payEntity.nonceStr}",
	           "package":"${payEntity.packages}",     
	           "signType":"MD5",       
	           "paySign":"${payEntity.paySign}"
	       },
	       function(res){ 
	       		WeixinJSBridge.log(res.err_msg);
	       		alert(res.err_code +","+ res.err_desc +","+ res.err_msg);
	           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
	           // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	           		alert("支付成功");
	           		//window.location.href="http://183-lisijia.imwork.net/weixin/pay?money=${money}&openid=${openid}";
	           }else if(res.err_msg == "get_brand_wcpay_request:cancel"){
	           		alert("支付取消");
	           }else{
	           		alert("支付失败");
	           }     
	       }
	   ); 
   }
  
   
</script>
</html>
