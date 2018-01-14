<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>确认订单</title>
<link href="${staticRoot}/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/owl.carousel.css" rel="stylesheet">
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/index.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/web/css/login.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/shop/css/style.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/shop/css/shoujisc.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/shop/css/style.new.css" rel="stylesheet" type="text/css">

<script src="${staticRoot}/web/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="${staticRoot}/web/js/owl.carousel.min.js" type="text/javascript"></script>
<script src="${staticRoot}/web/layer/layer.js" type="text/javascript"></script>
<script src="${staticRoot}/shop/js/zx/prodDetail.js" type="text/javascript"></script>
<script>
	$(window).load(function() {
		$("#status").fadeOut();
		$("#preloader").delay(350).fadeOut("slow");
	})
</script>
</head>
<body>
	<div class="mobile">
		<!--页面加载 开始-->
		<jsp:include page="../common/heads.jsp"></jsp:include>
		<!--页面加载 结束-->

		<!--header 开始-->
		<!-- 
		<header>
			<div class="header">
				<a class="new-a-back" href="/wechat/shop/order/index">
					<span style="margin-left: 8px;">
						<img src="${staticRoot}/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>确认订单</h2>
			</div>
		</header>
		 -->
		<!--header 结束-->
		<input type="hidden" id="cashType_check" value="${cashType }">
		<c:if test="${cashType eq '2' }">
			<c:if test="${addressInfo == null}">
				<dl class="drdd-info1">
					<dt>
						<p>选择添加收货地址</p>
					</dt>
					<dd>
						<a href="javascript:void(0);" onclick="selectAddress('0');">></a>
					</dd>
					<div style="clear: both;"></div>
				</dl>
			</c:if>
			<c:if test="${addressInfo != null}">
				<dl class="drdd-info6-zx">
					<dt>
						<p>
							<span class="f-l">收货人：${addressInfo.recipients}</span>
							<span class="f-r">联系电话：${addressInfo.phone}</span>
							<div style="clear: both;"></div>
						</p>
						<p>收货地址：${addressInfo.city} ${addressInfo.detailAddress}</p>
					</dt>
					<dd>
						<a href="javascript:void(0);" onclick="selectAddress('${addressInfo.id}');">></a>
					</dd>
					<div style="clear: both;"></div>
				</dl>
			</c:if>
		</c:if>

		<div class="drdd-info2">
			<p class="p1 f-l">共 ${orderInfo.goodsNum} 件商品</p>
			<p class="p2 f-r">
				总计：<span>${orderInfo.price}</span>
				<input type="hidden" id="price_info" value="${orderInfo.orderAmount}">
			</p>
			<div style="clear: both;"></div>
		</div>

		<c:forEach var="goodsInfo" items="${goodsInfoList}">
			<div class="drdd-info3">
				<div class="drdd-if3tu f-l">
					<a href="/wechat/shop/goods/goodsdetails?goodsId=${goodsInfo.goodsId}">
						<img src="${goodsInfo.path}${goodsInfo.goodsImg}">
					</a>
				</div>
				<h3 class="drdd-h31-zx f-l">
					<a href="/wechat/shop/goods/goodsdetails?goodsId=${goodsInfo.goodsId}">${goodsInfo.goodsName}</a>
				</h3>
				<h3 class="drdd-h31-zx f-l">
					数量：${goodsInfo.goodsNum}
				</h3>
				<h3 class="drdd-h31-zx1 f-l">
					${goodsInfo.subtotal}
				</h3>
				<div style="clear: both;"></div>
			</div>
		</c:forEach>
		
		<div class="drdd-info4">
			<p>配送费：${orderInfo.expressFeeStr}</p>
			<input type="hidden" id="expressFeeStr_info" value="${orderInfo.expressFee}">
			<div style="clear: both;"></div>
		</div>
		
		<div class="main">
			<div class="item item-password">
		       <input type="text" id="show_balance_a"  class="txt-input txt-username" 
		       readonly="readonly" value="使用账户余额">
		       <input type="text" class="txt-input txt-username" 
		       id="show_balance" value="">
		       <b class="tp-btn_PwdTwo btn-off_PwdTwo " setType="0" idtype="_balance"></b>
		       <input type="hidden" id="hidden_balance" value="${member.balance}">
     		</div>
			<div class="item item-password">
		       <input type="text" id="show_cashMoney_a"  class="txt-input txt-username" 
		       readonly="readonly" value="使用补贴金额">
		       <input type="text" class="txt-input txt-username" 
		       id="show_cashMoney" value="">
		       <b class="tp-btn_PwdTwo btn-off_PwdTwo " setType="0" idtype="_cashMoney"></b>
		       <input type="hidden" id="hidden_cashMoney" value="${member.cashMoney}">
     		</div>
			<div class="item item-password">
		       <input type="text" id="show_redPacket_a"  class="txt-input txt-username" 
		       readonly="readonly" value="使用用户积分">
		       <input type="text" class="txt-input txt-username" 
		       id="show_redPacket" value="">
		       <b class="tp-btn_PwdTwo btn-off_PwdTwo " setType="0" idtype="_redPacket"></b>
		       <input type="hidden" id="hidden_redPacket" value="${member.redPacket}">
     		</div>
		</div>
		
		<div class="drdd-info4">
			<p>配送方式：${orderInfo.wuliuName}</p>
			<div style="clear: both;"></div>
		</div><br>
		
		<div class="drdd-info4">
			<p>快递单号：${orderInfo.wuliuNumb}</p>
			<div style="clear: both;"></div>
		</div>

		<div class="fbsd-info4">
			<textarea placeholder="客户留言" id="buyerWord"></textarea>
			<div style="clear: both;"></div>
		</div>
		<c:if test="${orderInfo.orderStatus eq 1}">
		<div class="w main">
			<div class="ui-btn-wrap">
				<a class="ui-btn-lg ui-btn-primary" id="save" onclick="pay();">去结算</a>
			</div>
		</div>
		</c:if>
		
		
		
		<c:if test="${orderInfo.orderStatus eq 3}">
		<div class="w main sign_bill">
			<div class="ui-btn-wrap">
				<a class="ui-btn-lg ui-btn-primary" onclick="signBill('${orderInfo.orderId}');">确认收货</a>
			</div>
		</div>
		</c:if>

	</div>
</body>
<script type="text/javascript">
	$("#show_balance").hide();
	$("#show_cashMoney").hide();
	$("#show_redPacket").hide();
	var orderId = "${orderId}";
	var addressId = "${addressId}";
	$(".tp-btn_PwdTwo").on("click",function(){
		var setType = $(this).attr("setType");
		var idtype = $(this).attr("idtype");
		var blan = $("#hidden"+idtype).val();
		var price_info = $("#price_info").val();
		if(setType == "1"){
			$(this).removeClass("btn-on_PwdTwo");
			$(this).addClass("btn-off_PwdTwo");
			$(this).attr("setType","0");
			$("#show"+idtype).val("0");
			$("#show"+idtype).hide();
			$("#show"+idtype+"_a").show();
		}else if(setType == "0"){
			$(this).addClass("btn-on_PwdTwo");
			$(this).removeClass("btn-off_PwdTwo");
			$(this).attr("setType","1");
			if(blan>price_info){
				$("#show"+idtype).val(price_info);
			}else{
				$("#show"+idtype).val(blan);
			}
			$("#show"+idtype).show();
			$("#show"+idtype+"_a").hide();
		}
	});
</script>
<script src="/resources/js/web/shoppingcart/unpaidorderpage.js?0114"></script>
</html>