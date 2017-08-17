<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>消息设置</title>
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/login.css" rel="stylesheet" type="text/css">
<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="mobile">
  <!--页面加载 开始-->
  <jsp:include page="../common/heads.jsp"></jsp:include>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/resources/web/images/iconfont-fanhui.png"></span> </a>
      <h2>账户信息</h2>
      </div>
  </header>
  <!--header 结束-->
  <div class="w main">
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="${MemberInfo.wechatName }">
       
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" placeholder="输入你的姓名">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" placeholder="输入你的手机号">
     </div>
     
     <div class="item item-password">
       <input type="date" class="txt-input txt-username" placeholder="输入你的出生日期">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="${MemberInfo.city }">
     </div>
     
     <div class="item item-password">
       <select class="txt-input txt-username">
       	<option>宏包比例</option>
       	<option>0.8</option>
       	<option>0.8</option>
       	<option>0.8</option>
       	<option>0.8</option>
       </select>
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="是否开启宏包交易">
       <b class="tp-btn_PwdTwo btn-on_PwdTwo"></b> 
     </div>
     
     <div style="height: 30px">
     </div>
  </div>
	<!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
</div>
</body>
</html>
<script type="text/javascript" >
	$(".tp-btn_PwdTwo").on("click",function(){
		var type = $(this).attr("setType");
		var value = $(this).attr("typeValue");
		if(value == "1"){
			$(this).removeClass("btn-on_PwdTwo");
			$(this).addClass("btn-off_PwdTwo");
			$(this).attr("typeValue","0");
			$.ajax({
				url:"/wechat/shop/member/memberSet",
				data:parment(type,"0"),
				type:"POST",
				success:function(ret){
					if(ret.code=="000000"){
						
					}
				}
			});
		}else if(value == "0"){
			$(this).addClass("btn-on_PwdTwo");
			$(this).removeClass("btn-off_PwdTwo");
			$(this).attr("typeValue","1");
			$.ajax({
				url:"/wechat/shop/member/memberSet",
				data:parment(type,"1"),
				type:"POST",
				success:function(ret){
					if(ret.code=="000000"){
						
					}
				}
			});
		}
	});
	
	function parment(type,value){
		switch (type) {
		case "ddtj":
			return {ddtj:value}
			break;
			
		case "ddqx":
			return {ddqx:value}
			break;
			
		case "gmcg":
			return {gmcg:value}
			break;
			
		case "ddfh":
			return {ddfh:value}
			break;
			
		case "tksq":
			return {tksq:value}
			break;
			
		case "tkjg":
			return {tkjg:value}
			break;
			
		case "czcg":
			return {czcg:value}
			break;
			
		case "txsq":
			return {txsq:value}
			break;
			
		case "txcg":
			return {txcg:value}
			break;
			
		case "txsb":
			return {txsb:value}
			break;
		default:
			break;
		}
	}
</script> 