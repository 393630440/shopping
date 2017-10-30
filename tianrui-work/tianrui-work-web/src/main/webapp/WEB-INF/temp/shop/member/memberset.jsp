<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>消息设置</title>
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/login.css" rel="stylesheet" type="text/css">
<script src="${staticRoot}/web/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="mobile">
  <!--页面加载 开始-->
  <jsp:include page="../common/heads.jsp"></jsp:include>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>消息设置</h2>
      </div>
  </header>
  <!--header 结束-->
  <div class="w main">
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="订单提交">
       
       <b class="tp-btn_PwdTwo <c:if test="${set.ddtj eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.ddtj eq '1'}">btn-on_PwdTwo</c:if>" setType="ddtj" typeValue="${set.ddtj }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="订单取消">
       <b class="tp-btn_PwdTwo <c:if test="${set.ddqx eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.ddqx eq '1'}">btn-on_PwdTwo</c:if>" setType="ddqx" typeValue="${set.ddqx }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="购买成功">
       <b class="tp-btn_PwdTwo <c:if test="${set.gmcg eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.gmcg eq '1'}">btn-on_PwdTwo</c:if>" setType="gmcg" typeValue="${set.gmcg }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="订单发货">
       <b class="tp-btn_PwdTwo <c:if test="${set.ddfh eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.ddfh eq '1'}">btn-on_PwdTwo</c:if>" setType="ddfh" typeValue="${set.ddfh }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="退款申请">
       <b class="tp-btn_PwdTwo <c:if test="${set.tksq eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.tksq eq '1'}">btn-on_PwdTwo</c:if>" setType="tksq" typeValue="${set.tksq }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="退款结果">
       <b class="tp-btn_PwdTwo <c:if test="${set.tkjg eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.tkjg eq '1'}">btn-on_PwdTwo</c:if>" setType="tkjg" typeValue="${set.tkjg }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="充值成功">
       <b class="tp-btn_PwdTwo <c:if test="${set.czcg eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.czcg eq '1'}">btn-on_PwdTwo</c:if>" setType="czcg" typeValue="${set.czcg }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="提现申请">
       <b class="tp-btn_PwdTwo <c:if test="${set.txsq eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.txsq eq '1'}">btn-on_PwdTwo</c:if>" setType="txsq" typeValue="${set.txsq }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="提现成功">
       <b class="tp-btn_PwdTwo <c:if test="${set.txcg eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.txcg eq '1'}">btn-on_PwdTwo</c:if>" setType="txcg" typeValue="${set.txcg }"></b> 
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="提现失败">
       <b class="tp-btn_PwdTwo <c:if test="${set.txsb eq '0'}">btn-off_PwdTwo</c:if>
       <c:if test="${set.txsb eq '1'}">btn-on_PwdTwo</c:if>" setType="txsb" typeValue="${set.txsb }"></b> 
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