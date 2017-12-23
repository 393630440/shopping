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
					<ul class="am-icon-flag on"> 订单列表 </ul>
					<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > 订单列表 </dl>
				</div>
				<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
					<ul>
						<li>
							<div class="am-btn-group am-btn-group-xs">
								<select id="orderStatus" data-am-selected="{btnWidth: 100, btnSize: 'sm', btnStyle: 'default'}">
									<option value="">订单状态</option>
									<option value="1">待付款</option>
									<option value="2">待发货</option>
									<option value="3">待收货</option>
									<option value="4">已完成</option>
									<option value="5">退款申请</option>
									<option value="6">退款失败</option>
									<option value="7">退款成功</option>
									<!-- <option value="8">已取消</option> -->
									<!-- <option value="9">已删除</option> -->
									<!-- <option value="0">彻底删除</option> -->
								</select>
							</div>
						</li>
						<li>
							<div class="am-btn-group am-btn-group-xs">
								<select id="goodsType" data-am-selected="{btnWidth: 100, btnSize: 'sm', btnStyle: 'default'}">
									<option value="">商品类型</option>
									<option value="1">大众商品</option>
									<option value="2">积分商品</option>
								</select>
							</div>
						</li>
						<li><input type="text" id="orderCode" style="width: 160px" class="am-form-field am-input-sm am-input-xm" placeholder="订单编号" /></li>
						<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" onclick="init(0)" style="margin-top: -1px;">搜索</button></li>
					</ul>
				</div>
				<div class="am-form am-g">
					<table style="width: 100%" class="am-table am-table-bordered am-table-radius am-table-striped">
						<thead>
							<tr class="am-success">
								<th class="table-id">序号</th>
								<th class="table-title">订单编号</th>
								<th class="table-type">商品类型</th>
								<th class="table-type">商品数量</th>
								<th class="table-type">商品小计</th>
								<th class="table-type">运费</th>
								<th class="table-type">订单总金额</th>
								<th class="table-type">订单总积分</th>
								<th class="table-type">订单状态</th>
								<th class="table-title">所在地区</th>
								<th class="table-date am-hide-sm-only">创建时间</th>
								<th width="163px" class="table-set">操作</th>
							</tr>
						</thead>
						<tbody id="innerHml"></tbody>
					</table>
					<!-- page begin-->
					<jsp:include page="../common/pageTool.jsp" flush="false"></jsp:include>
					<!-- page end -->
					<hr />
				</div>
			</div>
			<!-- left-head begin-->
			<jsp:include page="../common/foods.jsp" flush="false"></jsp:include>
			<!-- left-head end -->
		</div>
	</div>

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
	<script src="/resources/js/admin/order/index.js?0728"></script>
</body>
</html>