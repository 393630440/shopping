<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>大众商品</title>
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/owl.carousel.css" rel="stylesheet">
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/index.css" rel="stylesheet" type="text/css" />
<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
<script src="/resources/web/js/owl.carousel.min.js"></script>
<script src="/resources/web/layer/layer.js"></script>
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
				<h2>大众商品</h2>
			</div>
		</header>
		<!--header 结束-->

		<div class="top w">
			<div class="m_banner" id="owl">
				<c:forEach var="adInfo" items="${adInfoList}">
					<a href="${adInfo.url}" class="item">
						<img src="${adInfo.path}${adInfo.img}" style="height: 260px;">
					</a>
				</c:forEach>
			</div>
			<div class="m_nav">
				<c:forEach var="classify" items="${classifyList}">
					<a href="/wechat/shop/goods/goodslist?goodsType=1&classifyId=${classify.classifyId}" class="item">
						<img src="${classify.path}${classify.icon}" style="width: 50px; height: 50px;">
						<span>${classify.classifyName}</span>
					</a>
				</c:forEach>
			</div>
		</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
	</div>
</body>
<script type="text/javascript">
	$(".foods_04").addClass("current");
</script>
</html>