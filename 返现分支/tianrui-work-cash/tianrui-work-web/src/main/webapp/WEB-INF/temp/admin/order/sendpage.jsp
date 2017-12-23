<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>信息管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="${staticRoot}/admin/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="${staticRoot}/admin/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="${staticRoot}/admin/css/amazeui.min.css" />
<link rel="stylesheet" href="${staticRoot}/admin/css/admin.css">
<script src="${staticRoot}/admin/js/jquery.min.js"></script>
<script src="${staticRoot}/admin/js/app.js"></script>
</head>
<body>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>
<body>
	<!-- top-head begin -->
	<jsp:include page="../common/top_head.jsp" flush="false"></jsp:include>
	<!-- top-head end -->
	<div class="am-cf admin-main">
		<!-- left-head begin -->
		<jsp:include page="../common/left_head.jsp" flush="false"></jsp:include>
		<!-- left-head end -->
		<div class=" admin-content">
			<div class="daohang">
				<ul></ul>
			</div>
			<div class="admin-biaogelist">
				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on"> 待发货订单 </ul>
					<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="/admin/shop/order/waitsendlist">待发货订单列表</a> > 待发货订单 </dl>
				</div>
				<div class="fbneirong">
					<div class="am-form">
						<div class="am-form-group am-cf">
							<div class="zuo">订单编号：</div>
							<div class="you">${orderInfo.orderCode}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品类型：</div>
							<div class="you" style="margin-top: 5px;">
								<c:if test="${orderInfo.goodsType == '1'}">大众商品</c:if>
								<c:if test="${orderInfo.goodsType == '2'}">积分商品</c:if>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品数量：</div>
							<div class="you">${orderInfo.goodsNum}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品小计：</div>
							<div class="you">${orderInfo.goodsSubtotal}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">运费：</div>
							<div class="you">${orderInfo.expressFee}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">订单总金额：</div>
							<div class="you">${orderInfo.orderAmount+orderInfo.expressFee}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">订单总积分：</div>
							<div class="you">${orderInfo.orderRedPacket}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">买家留言：</div>
							<div class="you">${orderInfo.buyerWord}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">创建时间：</div>
							<div class="you">${orderInfo.creationTimeStr}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">订单状态：</div>
							<div class="you" style="margin-top: 5px;">
								<c:if test="${orderInfo.orderStatus == '1'}">待付款</c:if>
								<c:if test="${orderInfo.orderStatus == '2'}">待发货</c:if>
								<c:if test="${orderInfo.orderStatus == '3'}">待收货</c:if>
								<c:if test="${orderInfo.orderStatus == '4'}">已完成</c:if>
								<c:if test="${orderInfo.orderStatus == '5'}">退款申请</c:if>
								<c:if test="${orderInfo.orderStatus == '6'}">退款失败</c:if>
								<c:if test="${orderInfo.orderStatus == '7'}">退款成功</c:if>
								<c:if test="${orderInfo.orderStatus == '8'}">已取消</c:if>
								<c:if test="${orderInfo.orderStatus == '9'}">已删除</c:if>
								<c:if test="${orderInfo.orderStatus == '0'}">彻底删除</c:if>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">收件人：</div>
							<div class="you">${orderInfo.recipients}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">联系电话：</div>
							<div class="you">${orderInfo.phone}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">所在地区：</div>
							<div class="you">${orderInfo.city}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">详细地址：</div>
							<div class="you">${orderInfo.detailAddress}</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">物流类别：</div>
							<div class="you"><input type="text" id="wuliu_type"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">快递编号：</div>
							<div class="you"><input type="text" id="wuliu_numb"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="you" style="margin-left: 11%;">
								<button onclick="send('3');" class="am-btn am-btn-success am-radius">发货</button>
								&nbsp; &raquo; &nbsp;
								<!-- <button onclick="send('7');" class="am-btn am-btn-secondary am-radius">拒绝</button> -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- left-head begin-->
			<jsp:include page="../common/foods.jsp" flush="false"></jsp:include>
			<!-- left-head end -->
		</div>
	</div>
	<script type="text/javascript">
		var orderId = "${orderInfo.orderId}";
	</script>

	<!--[if lt IE 9]>
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
	<script src="${staticRoot}/admin/js/polyfill/rem.min.js"></script>
	<script src="${staticRoot}/admin/js/polyfill/respond.min.js"></script>
	<script src="${staticRoot}/admin/js/amazeui.legacy.js"></script>
	<![endif]-->
	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="${staticRoot}/admin/js/amazeui.min.js"></script>
	<!--<![endif]-->
	<script src="/resources/js/admin/order/send.js?0728"></script>
</body>
</html>