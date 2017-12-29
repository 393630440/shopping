<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>账户充值</title>
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
  <!-- 
  <header>
    <div class="header"> <a class="new-a-back" href="/wechat/shop/member/userPage"> <span><img src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>账户充值</h2>
      </div>
  </header>
   -->
  <!--header 结束-->
  <div class="w main">
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="用户名称：${info.wechatName }">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="账户余额：${info.balance }">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="补贴余额：${info.cashMoney }">
     </div>
     
      <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="使用补贴余额">
       <b class="tp-btn_PwdTwo btn-off_PwdTwo " setType="0"></b>
       <input type="hidden" id="save_type" value="0">
     </div>
     
     <div class="item item-password blance_money">
       <input type="text" id="price" class="txt-input txt-username" 
        placeholder="使用现金充值">
     </div>
     
     <div class="item item-password cash_money">
       <input type="text" id="cash_price" class="txt-input txt-username"
        value="${info.cashMoney }" readonly="readonly"
        placeholder="使用补贴余额充值">
     </div>
     
     <div class="ui-btn-wrap"> 
     <a class="ui-btn-lg ui-btn-primary" id="save" href="#">确定</a> 
     </div>
        
     
     <div style="height: 30px">
     </div>
     <input type="hidden" id="memberId" value="${info.memberId }">
  </div>
	<!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
</div>
</body>
<script type="text/javascript">
$(".cash_money").hide();
$(".tp-btn_PwdTwo").on("click",function(){
	var setType = $(this).attr("setType");
	if(setType == "1"){
		$(this).removeClass("btn-on_PwdTwo");
		$(this).addClass("btn-off_PwdTwo");
		$(this).attr("setType","0");
		$("#save_type").val(0);
		$(".blance_money").show();
		$(".cash_money").hide();
	}else if(setType == "0"){
		$(this).addClass("btn-on_PwdTwo");
		$(this).removeClass("btn-off_PwdTwo");
		$(this).attr("setType","1");
		$("#save_type").val(1);
		$(".blance_money").hide();
		$(".cash_money").show();
	}
});

$("#save").on("click",function(){
	var save_type = $("#save_type").val();
	if(save_type == 0){
		var price = $("#price").val();
		if(price == ""){
			alert("请输入金额");	
			return;
		}
		window.location.href="/wechat/shop/deposit/payPage?money="+price;
	}else{
		if($("#cash_price").val()==0){
			alert("请输入正确金额");
			return;
		}
		$.ajax({
			url:"/wechat/shop/deposit/uptCashBack",
			data:{id:$("#memberId").val(),
				cashMoney:$("#cash_price").val()},
			type:"POST",
			success:function(ret){
				if(ret.code=="000000"){
					alert("操作成功");
				}else{
					alert(ret.error);
				}
			}
		});
	}
});
</script>
</html>
