<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>购物车</title>
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/login.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/shoujisc.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/style.new.css" rel="stylesheet" type="text/css">
<script src="/resources/web/js/jquery-1.8.3.min.js" type="text/javascript"></script>
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
				<a class="new-a-back" href="javascript:history.back();">
					<span>
						<img src="/resources/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>选择地址</h2>
			</div>
		</header>
		<!--header 结束-->

		<c:forEach var="addressInfo" items="${addressInfoList}">
			<dl class="drdd-info6-zx">
				<dt>
					<p>
						<input name="addressId" value="${addressInfo.id}" onclick="check();" <c:if test="${addressInfo.id == addressId}"> checked="checked"</c:if> type="radio" class="radio-zx" />
						<span class="f-l">收货人：${addressInfo.recipients}</span>
						<span class="f-r">联系电话：${addressInfo.phone}</span>
						<div style="clear: both;"></div>
					</p>
					<p>收货地址：${addressInfo.city} ${addressInfo.detailAddress}</p>
				</dt>
				<div style="clear: both;"></div>
			</dl>
		</c:forEach>

		<div class="w main">
			<div class="ui-btn-wrap">
				<a class="ui-btn-lg ui-btn-primary" id="save" onclick="select();">确认</a>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	$(".foods_04").addClass("current");
	var orderId = "${orderId}";
</script>
<script src="/resources/js/web/shoppingcart/selectaddress.js"></script>
</html>