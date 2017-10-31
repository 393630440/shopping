<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>宏包商品</title>
<link href="${staticRoot}/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/owl.carousel.css" rel="stylesheet">
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/index.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/shop/css/shoujisc.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/shop/css/style.new.css" rel="stylesheet" type="text/css">
<script src="${staticRoot}/web/js/jquery-1.8.3.min.js"></script>
<script src="${staticRoot}/web/js/owl.carousel.min.js"></script>
<script src="${staticRoot}/web/layer/layer.js"></script>
</head>
<body>
	<div class="mobile">
		<!--页面加载 开始-->
		<jsp:include page="../common/heads.jsp"></jsp:include>
		<!--页面加载 结束-->

		<!--header 开始-->
		<header>
			<div class="header">
				<a class="new-a-back" href="/wechat/shop/member/userPage">
					<span style="margin-left: 8px;">
						<img src="${staticRoot}/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>宏包商品</h2>
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
					<a href="/wechat/shop/goods/goodslist?goodsType=2&classifyId=${classify.classifyId}" class="item">
						<img src="${classify.path}${classify.icon}" style="width: 50px; height: 50px;">
						<span>${classify.classifyName}</span>
					</a>
				</c:forEach>
			</div>
		</div>
		<!-- 商品列表 -->
		<div class="m_baoliao w">
			<div class="baoliao_title">
				<span>宏包商城</span><em><span onclick="init(0,0)"><img src="${staticRoot}/web/images/iconfont-shuaxin.png"></span></em>
			</div>
			<ul class="ssjg-ul-zx" id="innerHml"></ul>
			<div class="baoliao_content" style="margin-top: 0px; margin-bottom: 50px;"></div>
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
	$(function() {
		init(0, 0);
	});

	function init(pageNo, type) {
		$("#scrollPage").val(pageNo);
		$.ajax({
			url : "/wechat/shop/goods/toloadgoodslist",
			data : {
				"pageNo" : pageNo,
				"goodsStatus":1,
				"goodsType" : 2,
				"pageSize" : 10
			},
			type : "POST",
			success : function(ret) {
				if (ret.code == "000000") {
					$("#scrollTotal").val(ret.data.total);
					innerHTML(ret.data.list, type);
				}
			}
		});
	}
	function innerHTML(date, type) {
		if (type == 0) {
			$("#innerHml").empty();
		}
		for (var a = 0; a < date.length; a++) {
			var hml = "<li>";
			hml += "<div class=\"ssjg-tu\">";
			hml += "<a href=\"/wechat/shop/goods/goodsdetails?goodsId=" + date[a].goodsId + "\">";
			hml += "<img src=\""+date[a].path+date[a].firstGoodsImg+"\">";
			hml += "</a>";
			hml += "</div>";
			hml += "<h3 style=\"font-size:12px;margin-top:0px;\">";
			hml += "<a href=\"/wechat/shop/goods/goodsdetails?goodsId=" + date[a].goodsId + "\"> " + date[a].goodsName + " </a>";
			hml += "</h3>";
			hml += "<dl class=\"ssjg-dl1\" style=\"margin-top:-10px;\">";
			hml += "<dt>";
			hml += "<span style=\"color: #DB3751; margin-left: 0px; font-size:12px;\">" + date[a].goodsPrice + "</span>";
			//hml += "<br />";
			//hml += "<span style=\"color: #7F7F7F; font-size: 12px; margin-left: 0px;\">销售量：" + date[a].salesvolume + "</span>";
			hml += "</dt>";
			//hml += "<dd>";
			//hml += "<a href=\"javascript:void(0);\" onclick=\"addGoods('" + date[a].goodsId + "');\">";
			//hml += "<img src=\"${staticRoot}/shop/images/sjsc-09.gif\">";
			//hml += "</a>";
			//hml += "</dd>";
			hml += "</dl>";
			hml += "</li>";
			$("#innerHml").append(hml);
		}
	}
</script>
</html>