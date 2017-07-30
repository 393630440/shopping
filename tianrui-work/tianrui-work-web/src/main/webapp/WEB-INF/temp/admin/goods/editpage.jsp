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
			<div class="daohang"><ul></ul></div>
			<div class="admin-biaogelist">
				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on">栏目名称</ul>
					<dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="/admin/shop/goods/index">商品列表</a> > 编辑商品
					</dl>
				</div>
				<div class="fbneirong">
					<form class="am-form">
						<div class="am-form-group am-cf">
							<div class="zuo">标题：</div>
							<div class="you">
								<input type="email" class="am-input-sm" id="doc-ipt-email-1" placeholder="请输入标题">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">关键词：</div>
							<div class="you">
								<input type="password" class="am-input-sm" id="doc-ipt-pwd-1" placeholder="请输入关键词">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">描述：</div>
							<div class="you">
								<textarea class="" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">缩略图：</div>
							<div class="you">
								<input type="file" id="doc-ipt-file-1">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">产品图片：</div>
							<div class="you" style="height: 45px;">
								<input type="file" id="doc-ipt-file-1">
								<p class="am-form-help">请选择要上传的文件...</p>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">内容：</div>
							<div class="you">
								<textarea class="" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">其他信息：</div>
							<div class="you">
								<textarea class="" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">推荐：</div>
							<div class="you" style="margin-top: 5px;">
								<label class="am-checkbox-inline"> <input type="checkbox" value="option1"> 选我
								</label> <label class="am-checkbox-inline"> <input type="checkbox" value="option2"> 同时可以选我
								</label> <label class="am-checkbox-inline"> <input type="checkbox" value="option3"> 还可以选我
								</label>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="you" style="margin-left: 11%;">
								<button type="submit" class="am-btn am-btn-success am-radius">发布并关闭窗口</button>
								&nbsp; &raquo; &nbsp;
								<button type="submit" class="am-btn am-btn-secondary am-radius">发布并继续发布</button>
							</div>
						</div>
					</form>
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
	<script src="/resources/js/admin/goods/edit.js?0728"></script>
</body>
</html>