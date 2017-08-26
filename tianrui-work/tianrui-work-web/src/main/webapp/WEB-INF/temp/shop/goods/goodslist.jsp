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
<script type="text/javascript">
	$(document).ready(function() {
		$(".shaixuan").click(function(event) {
			event.stopPropagation();
			$(".shaixuan_box").show();
			$(".shaixuan_box").animate({
				right : '100%'
			});
			$("body,html").css("overflow", "hidden");
			$(".shaixuan_box").css("overflow", "auto");
			$('body').bind("touchmove", function(e) {
				e.preventDefault();
			});
		});
		$(".shaixuan_mall a").click(function(event) {
			$("body,html").css("overflow", "auto");
			$(".shaixuan_box").animate({
				right : '-100%'
			});
			$(".shaixuan_box").hide(5);
			$("body").unbind("touchmove");
		});
	});
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
				<c:if test="${goodsType == '1'}"><h2>大众商品</h2></c:if>
				<c:if test="${goodsType == '2'}"><h2>宏包商品</h2></c:if>
				<div class="header_right shaixuan">
					<img src="/resources/web/images/iconfont-shaixuan.png">
				</div>
			</div>
		</header>
		<!--header 结束-->

		<div class="w">
			<form action="" method="get">
				<input id="goodsName" name="goodsName" type="text" class="search_input" placeholder="请输入您想要查找的商品">
				<input onclick="query();" type="button" class="search_submit" value="搜索">
			</form>
		</div>

		<div class="w-zx">
			<ul class="ui-tab-nav">
				<li <c:if test="${pageSort == '1'}"> class="current"</c:if>>
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&pageSort=1">综合</a>
				</li>
				<li <c:if test="${pageSort == '2'}"> class="current"</c:if>>
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&pageSort=2">销量</a>
				</li>
				<li <c:if test="${pageSort == '3' || pageSort == '4'}"> class="current"</c:if>>
					<c:if test="${pageSort == '1' || pageSort == '2'}">
						<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&pageSort=3">
							价格
							<i class="icon_sort"></i>
						</a>
					</c:if>
					<c:if test="${pageSort == '3'}">
						<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&pageSort=4">
							价格
							<i class="icon_sort_down"></i>
						</a>
					</c:if>
					<c:if test="${pageSort == '4'}">
						<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}">
							价格
							<i class="icon_sort_up"></i>
						</a>
					</c:if>
				</li>
			</ul>
		</div>

		<ul class="ssjg-ul-zx" id="goodsList_showId">
			<c:forEach var="goods" items="${goodsList}">
				<li>
					<div class="ssjg-tu">
						<a href="/wechat/shop/goods/goodsdetails?goodsId=${goods.goodsId}">
							<img src="${goods.path}${goods.firstGoodsImg}">
						</a>
					</div>
					<h3>
						<a href="/wechat/shop/goods/goodsdetails?goodsId=${goods.goodsId}">
							${goods.goodsName}
						</a>
					</h3>
					<dl class="ssjg-dl1">
						<dt>
							<span style="color: #DB3751; margin-left: 0px;">${goods.price}</span>
							<br />
							<span style="color: #7F7F7F; font-size: 12px; margin-left: 0px;">销售量：${goods.salesvolume}</span>
						</dt>
						<dd>
							<a href="javascript:void(0);" onclick="addGoods('${goods.goodsId}');">
								<img src="/resources/shop/images/sjsc-09.gif">
							</a>
						</dd>
					</dl>
				</li>
			</c:forEach>
		</ul>

		<div class="w-zx-1">
			<div class="bl_more">
				<a href="javascript:void(0);" onclick="toLoad();">加载更多</a>
			</div>
		</div>

		<!--筛选-->
		<div class="shaixuan_box">
			<div class="shaixuan_mall">
				<h1>商城筛选</h1>
				<div class="shaixun_item-zx">
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&sifting=1&pageSort=${pageSort}" <c:if test="${sifting != null && sifting == '1'}">class="current"</c:if>>推荐商品</a>
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&sifting=2&pageSort=${pageSort}" <c:if test="${sifting != null && sifting == '2'}">class="current"</c:if>>新品上市</a>
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&sifting=3&pageSort=${pageSort}" <c:if test="${sifting != null && sifting == '3'}">class="current"</c:if>>热卖商品</a>
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&sifting=4&pageSort=${pageSort}" <c:if test="${sifting != null && sifting == '4'}">class="current"</c:if>>促销商品</a>
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&sifting=5&pageSort=${pageSort}" <c:if test="${sifting != null && sifting == '5'}">class="current"</c:if>>卖家包邮</a>
					<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classifyId}&sifting=6&pageSort=${pageSort}" <c:if test="${sifting != null && sifting == '6'}">class="current"</c:if>>限时抢购</a>
					<c:forEach var="classify"  items="${classifyList}">
						<a href="/wechat/shop/goods/goodslist?goodsType=${goodsType}&classifyId=${classify.classifyId}&pageSort=${pageSort}" <c:if test="${classifyId != null && classifyId == classify.classifyId}">class="current"</c:if>>${classify.classifyName}</a>
					</c:forEach>
				</div>
				<p>
					<a href="javascript:void(0);"  class="shaixuan_colos">关闭</a>
				</p>
			</div>
		</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
 	<input type="hidden" id="scrollPage">
    <input type="hidden" id="scrollTotal">
	</div>
</body>
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
	$(".foods_04").addClass("current");
	var classifyId = "${classifyId}";
	var goodsType = "${goodsType}";
	var sifting = "${sifting}";
	var pageSort = "${pageSort}";
</script>
<script src="/resources/js/web/goods/goodslist.js"></script>
</html>