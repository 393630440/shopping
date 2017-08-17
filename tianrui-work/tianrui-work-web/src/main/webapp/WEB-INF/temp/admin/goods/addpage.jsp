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
					<ul class="am-icon-flag on">栏目名称</ul>
					<dl class="am-icon-home" style="float: right;">当前位置： 首页 ><a href="/admin/shop/goods/index">商品列表</a> > 添加商品</dl>
				</div>
				<div class="fbneirong">
					<div class="am-form">
						<div class="am-form-group am-cf">
							<div class="zuo">商品类型：</div>
							<div class="you" style="margin-top: 5px;">
								<label class="am-checkbox-inline">
									<input type="radio" name="goodsType" value="1" onclick="goodsType(1);" checked="checked"> 大众商品
								</label>
								<label class="am-checkbox-inline">
									<input type="radio" name="goodsType" value="2" onclick="goodsType(2);"> 宏包商品
								</label>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品名称：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="goodsName" name="goodsName" placeholder="请输入商品名称">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">分类：</div>
							<div class="you" id="goodsType1">
								<select id="classifyId1" name="classifyId1" data-am-selected="{btnWidth: 100, btnSize: 'sm', btnStyle: 'default'}">
									<option value="0">所属分类</option>
									<c:forEach var="goodsClassify" items="${goodsClassifyList}">
										<c:if test="${goodsClassify.goodsType == '1'}">
											<option value="${goodsClassify.classifyId}">${goodsClassify.classifyName}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div class="you" id="goodsType2" hidden="hidden">
								<select id="classifyId2" name="classifyId3" data-am-selected="{btnWidth: 100, btnSize: 'sm', btnStyle: 'default'}">
									<option value="0">所属分类</option>
									<c:forEach var="goodsClassify" items="${goodsClassifyList}">
										<c:if test="${goodsClassify.goodsType == '2'}">
											<option value="${goodsClassify.classifyId}">${goodsClassify.classifyName}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<c:forEach var="goodsClassify" items="${goodsClassifyList}">
								<input id="classifyId_${goodsClassify.classifyId}" value="${goodsClassify.classifyName}" hidden="hidden" />
							</c:forEach>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品价格：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="goodsPrice" name="goodsPrice" placeholder="请输入商品价格">
							</div>
						</div>
						<div class="am-form-group am-cf" id="redPacket_div">
							<div class="zuo">宏包：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="redPacket" name="redPacket" placeholder="请输入宏包数量">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品图片：</div>
							<div class="you" id="goodsImg_input_showId">
								<input type="file" id="goodsImg0" name="goodsImg0" onchange="imgShow(this,1);">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo"></div>
							<div class="you" id="goodsImg_img_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品详情：</div>
							<div class="you" id="goodsDetails_input_showId">
								<input type="file" id="goodsDetails0" name="goodsDetails0" onchange="imgShow(this,2);">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo"></div>
							<div class="you" id="goodsDetails_img_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品参数：</div>
							<div class="you">
								<textarea class="" rows="2" id="goodsParam" name="goodsDetails"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">快递费：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="expressFee" name="expressFee" placeholder="请输入快递费">
							</div>
						</div>
						<div class="am-form-group am-cf" id="redPacket_div">
							<div class="zuo">库存：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="inventory" name="inventory" placeholder="请输入库存数量">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">筛选条件：</div>
							<div class="you" style="margin-top: 5px;">
								<input type="radio" name="sifting" value="0" hidden="hidden" checked="checked" /> <label class="am-checkbox-inline"> <input type="radio" name="sifting" value="1" /> 推荐商品
								</label> <label class="am-checkbox-inline"> <input type="radio" name="sifting" value="2" /> 新品上市
								</label> <label class="am-checkbox-inline"> <input type="radio" name="sifting" value="3" /> 热卖商品
								</label> <label class="am-checkbox-inline"> <input type="radio" name="sifting" value="4" /> 促销商品
								</label> <label class="am-checkbox-inline"> <input type="radio" name="sifting" value="5" /> 卖家包邮
								</label> <label class="am-checkbox-inline"> <input type="radio" name="sifting" value="6" /> 限时抢购
								</label>
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
	<script src="/resources/js/admin/goods/add.js?0728"></script>
	<script src="/resources/js/admin/ajaxfileupload.js"></script>
</body>
</html>