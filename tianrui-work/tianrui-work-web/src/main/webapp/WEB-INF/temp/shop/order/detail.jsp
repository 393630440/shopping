<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>订单详情</title>
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
      <h2>订单详情</h2>
      </div>
  </header>
  <!--header 结束-->
  <div class="w main">
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="订单编号：${order.orderCode }">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="收货人：${order.recipients }">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="联系电话：${order.phone }">
     </div>
     
     <div class="item item-password">
       <input type="text" id="price" class="txt-input txt-username" 
        value="详细地址：${order.city },${order.detailAddress }">
     </div>
     
     <div class="item item-password">
       <input type="text" id="price" class="txt-input txt-username" 
        value="运费：${order.expressFee }">
     </div>
     
     <div class="item item-password">
       <input type="text" id="price" class="txt-input txt-username" 
        value="金额：${order.orderAmount }">
     </div>
     
     <div class="item item-password">
       <input type="text" id="price" class="txt-input txt-username" 
        value="宏包：${order.orderRedPacket }">
     </div>
     <c:if test="${order.orderStatus eq '1' }">
     <div class="ui-btn-wrap"> 
     <a class="ui-btn-lg ui-btn-primary" id="save">去结算</a> 
     </div>
     </c:if>
        
     <input type="hidden" id="orderId" value="${order.orderId }">
     <div style="height: 30px">
     </div>
  </div>
	<!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
</div>
</body>
<script type="text/javascript">
$("#save").on("click",function(){
	window.location.href="/wechat/shop/pay/billPay?id="+$("#orderId").val();
});
</script>
</html>
