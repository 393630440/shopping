<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>账户信息</title>
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
    <div class="header"> <a class="new-a-back" href="/wechat/shop/member/userPage"> <span><img src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>账户信息</h2>
      </div>
  </header>
  <!--header 结束-->
  <div class="w main">
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" readonly="readonly" value="${MemberInfo.wechatName }">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username uptInfo" value="${MemberInfo.memberName }" id="memberName_req" placeholder="输入你的姓名">
     </div>
     
     <div class="item item-password">
       <input type="text" maxlength="11" class="txt-input txt-username uptInfo" value="${MemberInfo.cellphone }" id="cellphone_req" placeholder="输入你的手机号">
     </div>
     
     <div class="item item-password">
       <input type="date" class="txt-input txt-username uptInfo" value="${MemberInfo.birthTime }"  id="birthTime_req" placeholder="输入你的出生日期">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username uptInfo" id="city_req" value="${MemberInfo.city }" placeholder="所在城市">
     </div>
     <input type="hidden" id="memberId_req" value="${MemberInfo.memberId }">
     <div class="item item-password">
       <select id="rpExchangeRatio_req" class="txt-input txt-username uptInfo">
       	<option value="" >交易比例</option>
       	<option value="1" <c:if test="${MemberInfo.rpExchangeRatio eq 1}">selected = "selected"</c:if>>1.0</option>
       	<option value="0.9" <c:if test="${MemberInfo.rpExchangeRatio eq 0.9}">selected = "selected"</c:if>>0.9</option>
       	<option value="0.8" <c:if test="${MemberInfo.rpExchangeRatio eq 0.8}">selected = "selected"</c:if>>0.8</option>
       	<option value="0.7" <c:if test="${MemberInfo.rpExchangeRatio eq 0.7}">selected = "selected"</c:if>>0.7</option>
       	<option value="0.6" <c:if test="${MemberInfo.rpExchangeRatio eq 0.6}">selected = "selected"</c:if>>0.6</option>
       	<option value="0.5" <c:if test="${MemberInfo.rpExchangeRatio eq 0.5}">selected = "selected"</c:if>>0.5</option>
       	<option value="0.4" <c:if test="${MemberInfo.rpExchangeRatio eq 0.4}">selected = "selected"</c:if>>0.4</option>
       	<option value="0.3" <c:if test="${MemberInfo.rpExchangeRatio eq 0.3}">selected = "selected"</c:if>>0.3</option>
       </select>
     </div>
     
     <div class="item item-password">
       <input type="text" id="rpTradeMark_req" class="txt-input txt-username" readonly="readonly" value="是否开启宏包交易">
       
       <b class="tp-btn_PwdTwo <c:if test="${MemberInfo.rpTradeMark eq 0}">btn-off_PwdTwo</c:if>
       <c:if test="${MemberInfo.rpTradeMark eq 1}">btn-on_PwdTwo</c:if>" typeValue=${MemberInfo.rpTradeMark }></b> 
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
		var value = $(this).attr("typeValue");
		var par;
		if(value == 1){
			$(this).removeClass("btn-on_PwdTwo");
			$(this).addClass("btn-off_PwdTwo");
			$(this).attr("typeValue","0");
			par = 0;
		}else{
			$(this).addClass("btn-on_PwdTwo");
			$(this).removeClass("btn-off_PwdTwo");
			$(this).attr("typeValue","1");
			par = 1;
		}
		$.ajax({
			url:"/wechat/shop/member/uptMemberInfo",
			data:{"memberId":$("#memberId_req").val(),
				"rpTradeMark":par
				},
			type:"POST",
			success:function(ret){
				
			}
		});
	});

	$(".uptInfo").on("change",function(){
		$.ajax({
			url:"/wechat/shop/member/uptMemberInfo",
			data:{"memberId":$("#memberId_req").val(),
				"memberName":$("#memberName_req").val(),
				"cellphone":$("#cellphone_req").val(),
				"birthTime":$("#birthTime_req").val(),
				//"rpTradeMark":$("#").val(),
				"city":$("#city_req").val(),
				"rpExchangeRatio":$("#rpExchangeRatio_req").val()
				},
			type:"POST",
			success:function(ret){
				
			}
		});
	});
</script> 