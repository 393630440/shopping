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
<link rel="icon" type="image/png" href="/resources/admin/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="/resources/admin/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="/resources/admin/css/amazeui.min.css" />
<link rel="stylesheet" href="/resources/admin/css/admin.css">
<script src="/resources/admin/js/jquery.min.js"></script>
<script src="/resources/admin/js/app.js"></script>
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
					<ul class="am-icon-flag on"> 添加广告 </ul>
					<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="/admin/shop/ad/index">广告列表</a> > 添加广告 </dl>
				</div>
				<div class="fbneirong">
					<div class="am-form">
						<div class="am-form-group am-cf">
							<div class="zuo">商品类型：</div>
							<div class="you" style="margin-top: 5px;">
								<label class="am-checkbox-inline"> <input type="radio" name="type" value="1"> 大众商品 </label>
								<label class="am-checkbox-inline"> <input type="radio" name="type" value="2"> 宏包商品 </label>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">广告图片：</div>
							<div class="you" id="input_div_showId">
								<input type="file" id="img" name="img" onchange="imgShow(this);">
							</div>
							<div class="you" id="img_div_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">广告描述：</div>
							<div class="you">
								<textarea class="" rows="2" id="depict" name="depict"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">广告链接：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="url" name="url" placeholder="请输入广告链接">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="you" style="margin-left: 11%;">
								<button onclick="add(1);" class="am-btn am-btn-success am-radius">发布并关闭窗口</button>
								&nbsp; &raquo; &nbsp;
								<button onclick="add(2);" class="am-btn am-btn-secondary am-radius">发布并继续发布</button>
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

	<!--[if lt IE 9]>
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
	<script src="/resources/admin/js/polyfill/rem.min.js"></script>
	<script src="/resources/admin/js/polyfill/respond.min.js"></script>
	<script src="/resources/admin/js/amazeui.legacy.js"></script>
	<![endif]-->
	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="/resources/admin/js/amazeui.min.js"></script>
	<!--<![endif]-->
	<script src="/resources/js/admin/ad/add.js?0728"></script>
	<script src="/resources/js/admin/ajaxfileupload.js"></script>
</body>
</html>