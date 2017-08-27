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
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/owl.carousel.css" rel="stylesheet">
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/index.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="/resources/web/css/login.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/shoujisc.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/style.new.css" rel="stylesheet" type="text/css">
<script src="/resources/web/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="/resources/web/js/owl.carousel.min.js" type="text/javascript"></script>
<script src="/resources/web/layer/layer.js" type="text/javascript"></script>
<script src="/resources/shop/js/zx/prodDetail.js" type="text/javascript"></script>
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
		<header>
			<div class="header">
				<a class="new-a-back" href="/wechat/shop/order/index">
					<span>
						<img src="/resources/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>确认订单</h2>
			</div>
		</header>
		<!--header 结束-->

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

		<div class="drdd-info2">
			<p class="p1 f-l">共 ${orderInfo.goodsNum} 件商品</p>
			<p class="p2 f-r">
				总计：<span>${orderInfo.price}</span>
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
			<div style="clear: both;"></div>
		</div>
		
		<div class="drdd-info4">
			<p>配送方式：${orderInfo.wuliuName}</p>
			<div style="clear: both;"></div>
		</div>
		
		<div class="drdd-info4">
			<p>快递单号：${orderInfo.wuliuNumb}</p>
			<div style="clear: both;"></div>
		</div>
		
		<c:if test="${orderInfo.goodsType eq 1}">
		<div class="drdd-info4">
			<p>商品类别：大众商品</p>
			<div style="clear: both;"></div>
		</div>
		<div class="drdd-info4">
			<p>奖励宏包：<fmt:formatNumber type="number" value="${orderInfo.orderAmount * redPark}" maxFractionDigits="0"/></p>
			<div style="clear: both;"></div>
		</div>
		</c:if>
		
		<c:if test="${orderInfo.goodsType eq 2}">
		<div class="drdd-info4">
			<p>商品类别：宏包商品</p>
			<div style="clear: both;"></div>
		</div>
		</c:if>

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
	$(".foods_04").addClass("current");
	var orderId = "${orderId}";
	var addressId = "${addressId}";
</script>
<script src="/resources/js/web/shoppingcart/unpaidorderpage.js"></script>
</html>