<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>编辑分类 </title>
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
			<div class="daohang"><ul></ul></div>
			<div class="admin-biaogelist">
				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on"> 编辑分类 </ul>
					<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="/admin/shop/goodsclassify/index">分类列表</a> > 编辑分类 </dl>
				</div>
				<div class="fbneirong">
					<div class="am-form">
						<!-- 
						<div class="am-form-group am-cf">
							<div class="zuo">商品类型：</div>
							<div class="you" style="margin-top: 5px;">
								<c:if test="${goodsClassify.goodsType == '1'}">大众商品</c:if>
								<c:if test="${goodsClassify.goodsType == '2'}">宏包商品</c:if>
							</div>
						</div>
						 -->
						<div class="am-form-group am-cf">
							<div class="zuo">分类名称：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="classifyName" name="classifyName" value="${goodsClassify.classifyName}" placeholder="请输入商品名称">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">分类图标：</div>
							<div class="you" id="input_div_showId"></div>
							<div class="you" id="icon_div_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">备注说明：</div>
							<div class="you">
								<textarea class="" rows="2" id="descr" name="descr">${goodsClassify.descr}</textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="you" style="margin-left: 11%;">
								<button onclick="edit();" class="am-btn am-btn-success am-radius">编辑并关闭窗口</button>
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
		var classifyId = "${goodsClassify.classifyId}";
		var icon = "${goodsClassify.icon}";
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
	<script src="/resources/js/admin/goodsclassify/edit.js?09130"></script>
	<script src="/resources/js/admin/ajaxfileupload.js"></script>
</body>
</html>