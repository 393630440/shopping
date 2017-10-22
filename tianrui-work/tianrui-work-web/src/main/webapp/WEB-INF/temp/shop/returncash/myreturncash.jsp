<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>返现派送</title>
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/resources/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/shop/css/style.new.css">
<link rel="stylesheet" type="text/css" href="/resources/shop/css/shoujisc.css">
<script type="text/javascript" src="/resources/shop/js/jQuery.js"></script>
<script type="text/javascript" src="/resources/shop/js/woxiangyao.js"></script>
<script type="text/javascript" src="/resources/shop/js/zx/rewrite.new.js"></script>
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
					<span style="margin-left: 8px;">
						<img src="/resources/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>我的返现</h2>
			</div>
		</header>
		<!--header 结束-->

		<div class="my-dd">
			<div class="my-info">
				<div class="my-k1">
					<div class="my-p2-zx">
						<span class="my-sp3 f-l">商品111返现</span>
						<span class="my-sp3-zx f-l">返现总额</span>
						<span class="my-sp3 f-r">已反金额</span>
						<div style="clear: both;"></div>
					</div>
					<div class="my-p2-zx">
						<span class="my-sp3 f-l">商品222返现</span>
						<span class="my-sp3-zx f-l">返现总额</span>
						<span class="my-sp3 f-r">已反金额</span>
						<div style="clear: both;"></div>
					</div>
					<div class="my-p2-zx">
						<span class="my-sp3 f-l">商品333返现</span>
						<span class="my-sp3-zx f-l">返现总额</span>
						<span class="my-sp3 f-r">已反金额</span>
						<div style="clear: both;"></div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	
</script>
</html>