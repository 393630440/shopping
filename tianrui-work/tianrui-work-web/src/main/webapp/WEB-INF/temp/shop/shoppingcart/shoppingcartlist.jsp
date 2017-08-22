<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>商品列表</title>
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/owl.carousel.css" rel="stylesheet">
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/index.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/shoujisc.css" rel="stylesheet" type="text/css">
<link href="/resources/shop/css/style.new.css" rel="stylesheet" type="text/css">
<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
<script src="/resources/web/js/owl.carousel.min.js"></script>
<script src="/resources/web/layer/layer.js"></script>
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
				<h2>购物车</h2>
			</div>
		</header>
		<!--header 结束-->

		<ul class="gwc-ul1">
			<c:forEach var="goodsInfo" items="${goodsInfoList}">
				<li>
					<div class="hwc-tu f-l" onclick="">
						<a href="#"><img src="${goodsInfo.path}${goodsInfo.goodsImg}"></a>
					</div>
					<div class="gwc-md f-l">
						<h3>
							<a href="#">${goodsInfo.goodsName}</a>
						</h3>
						<p class="gwc-p1">
							<span>${goodsInfo.price}</span>
						</p>
					</div>
					<a href="#" class="gwc-del f-r">
						<img src="/resources/shop/images/sjsc-10.gif">
					</a>
					<div style="clear: both;"></div>
				</li>
			</c:forEach>
		</ul>

		<div class="gwc-ft-zx">
			<p>
				共募集12件商品，总计：<span>￥12440.00</span>
			</p>
			<button>提交</button>
			<div style="clear: both;"></div>
		</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
	</div>
</body>
<script type="text/javascript">
	$(".foods_04").addClass("current");
</script>
<script src="/resources/js/web/shoppingcart/shoppingcartlist.js"></script>
</html>