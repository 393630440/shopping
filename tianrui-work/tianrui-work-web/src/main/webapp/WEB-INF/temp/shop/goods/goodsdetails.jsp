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
<link rel="stylesheet" type="text/css" href="/resources/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/shop/css/shoujisc.css">
<link rel="stylesheet" type="text/css" href="/resources/shop/css/style.new.css">
<script type="text/javascript" src="/resources/shop/js/jQuery.js"></script>
<script type="text/javascript" src="/resources/shop/js/woxiangyao.js"></script>
<script type="text/javascript" src="/resources/shop/js/TouchSlide.1.1.js"></script>
<script type="text/javascript" src="/resources/shop/js/foot.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/web/css/public.css">
<link rel="stylesheet" type="text/css" href="/resources/web/frozenui/css/frozen.css">
<link rel="stylesheet" type="text/css" href="/resources/web/css/baoliao.css">
<link rel="stylesheet" type="text/css" href="/resources/web/css/shoujisc.css">
<script type="text/javascript" src="/resources/web/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/resources/shop/js/zx/prodDetail.js"></script>
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
				<a class="new-a-back" href="javascript:history.back();"> <span> <img src="/resources/web/images/iconfont-fanhui.png">
				</span>
				</a>
				<h2>商品详情</h2>
			</div>
		</header>
		<!--header 结束-->

		<div class="spxq-info2">
			<ul class="spxq-ul2">
				<li class="current"><a href="javascript:void(0);">商品</a></li>
				<li><a href="javascript:void(0);">详情</a></li>
				<li><a href="javascript:void(0);">参数</a></li>
			</ul>
			<div class="spxq-box">
				<!--商品 开始-->
				<div class="spxq-k spxq-k1">
					<div class="view w">
						<div class="bl_view_img">
							<div class="banner1" id="ban1">
								<ul class="sy-ul">
									<c:forEach var="goodsImg" items="${goodsImgList}">
										<li><a href="javascript:void(0);"> <img src="/getimg?imgPath=goodsInfo/${goodsInfo.goodsId}/${goodsImg}" />
										</a></li>
									</c:forEach>
								</ul>
								<ol class="sy-ol"></ol>
							</div>
						</div>
						<div class="bl_view_title">${goodsInfo.goodsName}</div>
						<div class="bl_view_tag">
							<div class="bl_view_price">${goodsInfo.price}</div>
						</div>
						<div class="bl_view_tag">
							<div class="bl_view_user">快递：${goodsInfo.expressFeeStr}</div>
							<div class="bl_view_time">销量：${goodsInfo.salesvolume}</div>
						</div>
						<div class="bl_view_tag details_con">
							<div class="bl_view_user">
								数量：
								<div class="count_div" style="height: 30px; width: 130px;">
									<a href="javascript:void(0);" class="minus"></a>
									<input type="text" class="count" value="1" id="goodsNum" readonly="readonly" />
									<a href="javascript:void(0);" class="add"></a>
								</div>
							</div>
							<div class="bl_view_time">
								<a href="javascript:void(0);" onclick="addGoods();" class="if3-aa f-l a_addgoods-zx">
									<img src="/resources/shop/images/sjsc-17-2.png">
								</a>
							</div>
						</div>
					</div>
				</div>
				<!--商品 结束-->

				<!--详情 开始-->
				<div class="spxq-k spxq-k2" style="display: none;">
					<c:forEach var="goodsDetails" items="${goodsDetailsList}">
						<img src="/getimg?imgPath=goodsInfo/${goodsInfo.goodsId}/${goodsDetails}" />
					</c:forEach>
				</div>
				<!--详情 结束-->

				<!--参数 开始-->
				<div class="spxq-k spxq-k3" style="display: none;">
					<c:forEach var="goodsParam" items="${goodsParamList}">
						<div class="bl_view_tag">
							<div class="bl_view_price">${goodsParam.key}</div>
							<div class="bl_view_oprice-zx">${goodsParam.value}</div>
						</div>
						<hr />
					</c:forEach>
				</div>
				<!--参数 结束-->
			</div>
		</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
	</div>
</body>
<script type="text/javascript">
	$(".foods_04").addClass("current");
	var goodsId = "${goodsInfo.goodsId}"; // 商品ID
	var goodsType = "${goodsInfo.goodsType}"; // 商品类型:1-大众商品;2-宏包商品
	var inventory = ${goodsInfo.inventory}; // 库存
</script>
<script src="/resources/js/web/goods/goodsdetails.js"></script>
</html>