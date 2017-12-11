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
<link href="${staticRoot}/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/owl.carousel.css" rel="stylesheet">
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/index.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/baoliao.css" rel="stylesheet" type="text/css">
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
				<a class="new-a-back" href="javascript:history.back();">
					<span style="margin-left: 8px;">
						<img src="${staticRoot}/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>购物车</h2>
				<c:if test="${goodsInfoList.size()  != 0}">
					<a href="#" style="color: #fff; position: absolute; right: 10; top: 10;" id="edit">编辑</a>
					<a href="#" style="color: #fff; position: absolute; right: 10; top: 10;" id="save" hidden="hidden">完成</a>
				</c:if>
			</div>
		</header>
		 -->
		<!--header 结束-->

		<div class="w-zx">
			<ul class="ui-tab-nav">
				<li class="current"><a href="javascript:void(0);">我的购物车</a></li>
				<!-- 
				<li><a href="/wechat/shop/shoppingcart/redpacketlist">宏包商品</a></li>
				 -->
			</ul>
		</div>

		<c:if test="${goodsInfoList.size()  != 0}">
			<ul class="gwc-ul1">
				<c:forEach var="goodsInfo" items="${goodsInfoList}">
					<li id="goodsInfo_${goodsInfo.shoppingCartId}">
						<div style="float: left;">
							<input type="checkbox" name="shoppingCartId" value="${goodsInfo.shoppingCartId}" onclick="check();" class="checkbox-zx"/>
							<input type="text" hidden="hidden" value="${goodsInfo.goodsPrice}" id="goodsPrice_hide_${goodsInfo.shoppingCartId}" />
							<input type="text" hidden="hidden" value="${goodsInfo.goodsRedPacket}" id="goodsRedPacket_hide_${goodsInfo.shoppingCartId}" />
							<input type="text" hidden="hidden" value="${goodsInfo.goodsType}" id="goodsType_hide_${goodsInfo.shoppingCartId}" />
							<input type="text" hidden="hidden" value="${goodsInfo.goodsNum}" id="goodsNum_hide_${goodsInfo.shoppingCartId}" />
						</div>
						<div class="hwc-tu f-l">
							<a href="/wechat/shop/goods/goodsdetails?goodsId=${goodsInfo.goodsId}">
								<img src="${goodsInfo.goodsImg}">
							</a>
						</div>
						<div class="gwc-md f-l">
							<h3>
								<a href="/wechat/shop/goods/goodsdetails?goodsId=${goodsInfo.goodsId}">
									${goodsInfo.goodsName}
								</a>
							</h3>
							<p class="gwc-p1">
								<span>${goodsInfo.price}</span>
							</p>
							<p class="gwc-p2">
								<span id="goodsNum_showId_${goodsInfo.shoppingCartId}">数量：${goodsInfo.goodsNum}</span>
							</p>
							<p class="gwc-p2">
								<span id="subtotal_showId_${goodsInfo.shoppingCartId}">小计：${goodsInfo.subtotal}</span>
							</p>
							<div class="bl_view_tag details_con" hidden="hidden">
								<div class="bl_view_user">
									<div class="count_div" style="height: 30px; width: 130px;">
										<a href="javascript:void(0);" class="minus"></a>
										<input type="text" class="count" value="${goodsInfo.goodsNum}" id="goodsNum_${goodsInfo.shoppingCartId}" readonly="readonly" />
										<a href="javascript:void(0);" class="add"></a>
									</div>
								</div>
							</div>
						</div>
						<a href="javascript:void(0);" onclick="del(${goodsInfo.shoppingCartId});" class="gwc-del f-r" hidden="hidden">
							<img src="${staticRoot}/shop/images/sjsc-10.gif">
						</a>
						<div style="clear: both;"></div>
					</li>
				</c:forEach>
			</ul>
		</c:if>

		<div class="gwc-ft-zx">
			<p id="size_total" hidden="hidden">
				共${size}件商品，总计：<span>￥${total}</span>
			</p>
			<button onclick="placeOrder();">立即下单</button>
			<div style="clear: both;"></div>
		</div>

	</div>
</body>
<script type="text/javascript">
	var shoppingCartIdList = ${shoppingCartIdList};
	var goodsType = "1";
</script>
<script src="/resources/js/web/shoppingcart/shoppingcartlist.js"></script>
</html>