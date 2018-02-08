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
<style>
a {
    color: #000;
    text-decoration: none;
}
</style>
</head>
<body>
<div class="mobile">
  <!--页面加载 开始-->
  <jsp:include page="../common/heads.jsp"></jsp:include>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <!-- 
  <header>
    <div class="header"> <a class="new-a-back" href="/wechat/shop/member/userPage"> <span><img src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>账户信息</h2>
      </div>
  </header>
   -->
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
     <div style="height: 30px">
     </div>
  </div>
	
	
	<ul class="quanbu-ul1" style="z-index:999">
    	<li class="foods_01" style="width: 25%">
        	<div class="qu-tu1">
            	<a class="atu1"><img src="${staticRoot}/shop/images/sjsc-02.gif"></a>
            	<a class="atu2"><img src="${staticRoot}/shop/images/sjsc-15-1.gif"></a>
            </div>
            <a class="qu-ul1a">禄里商城</a>
        </li>
    	<li class="foods_02" style="width: 25%">
        	<div class="qu-tu1">
            	<a class="atu1"><img src="${staticRoot}/shop/images/sjsc-16.png"></a>
            	<a class="atu2"><img src="${staticRoot}/shop/images/sjsc-16-1.png"></a>
            </div>
            <a class="qu-ul1a">分享</a>
        </li>
    	<li class="foods_03" style="width: 25%">
        	<div class="qu-tu1">
            	<a class="atu1"><img src="${staticRoot}/shop/images/sjsc-17.png"></a>
            	<a class="atu2"><img src="${staticRoot}/shop/images/sjsc-17-1.png"></a>
            </div>
            <a class="qu-ul1a">购物车</a>
        </li>
    	 
    	<li class="foods_05" style="width: 25%">
        	<div class="qu-tu1">
            	<a class="atu1"><img src="${staticRoot}/shop/images/sjsc-18.png"></a>
            	<a class="atu2"><img src="${staticRoot}/shop/images/sjsc18-1.png"></a>
            </div>
            <a class="qu-ul1a">我</a>
        </li>
        <div style="clear:both;"></div>
    </ul>
</div>
</body>
</html>
<script type="text/javascript" >
	$(".foods_01").on("click",function(){
		if($("#memberName_req").val()==""||$("#cellphone_req").val()==""){
			alert("请完善个人信息");
		}else{
			window.location.href="/wechat/shop/goods/goodshome?goodsType=1";
		}
	});
	$(".foods_02").on("click",function(){
		if($("#memberName_req").val()==""||$("#cellphone_req").val()==""){
			alert("请完善个人信息");
		}else{
			window.location.href="/web/show/qr/index?memberId="+$("#memberId_req").val();
		}
		
	});
	$(".foods_03").on("click",function(){
		if($("#memberName_req").val()==""||$("#cellphone_req").val()==""){
			alert("请完善个人信息");
		}else{
			window.location.href="/wechat/shop/shoppingcart/ordinarylist";
		}
		
	});
	$(".foods_05").on("click",function(){
		if($("#memberName_req").val()==""||$("#cellphone_req").val()==""){
			alert("请完善个人信息");
		}else{
			window.location.href="/wechat/shop/member/userPage";
		}
		
	});
	
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