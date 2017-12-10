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
<link rel="stylesheet" href="${staticRoot}/admin/css/admin.new.css">
<script src="${staticRoot}/admin/js/jquery.min.js"></script>
<script src="${staticRoot}/admin/js/app.js"></script>
</head>
<body>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>
	<img class="tpscz-zx" src="${staticRoot}/admin/i/tpscz.gif" id="tpscz-zx" />
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
					<ul class="am-icon-flag on"> 编辑商品 </ul>
					<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="/admin/shop/goods/index">商品列表</a> > 编辑商品 </dl>
				</div>
				<div class="fbneirong">
					<div class="am-form">
						<!-- 
						<div class="am-form-group am-cf">
							<div class="zuo">商品类型：</div>
							<div class="you" style="margin-top: 5px;">
								<c:if test="${goodsInfo.goodsType == '1'}">大众商品</c:if>
								<c:if test="${goodsInfo.goodsType == '2'}">宏包商品</c:if>
							</div>
						</div>
						 -->
						<div class="am-form-group am-cf">
							<div class="zuo">商品名称：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="goodsName" name="goodsName" value="${goodsInfo.goodsName}" placeholder="请输入商品名称">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">分类：</div>
							<div class="you">
								<select id="classifyId" name="classifyId" data-am-selected="{btnWidth: 100, btnSize: 'sm', btnStyle: 'default'}">
									<option value="0">所属分类</option>
									<c:forEach var="goodsClassify" items="${goodsClassifyList}">
											<option value="${goodsClassify.classifyId}" <c:if test="${goodsClassify.classifyId == goodsInfo.classifyId}"> selected="selected"</c:if>>${goodsClassify.classifyName}</option>
									</c:forEach>
								</select>
								<c:forEach var="goodsClassify" items="${goodsClassifyList}">
										<input id="classifyId_${goodsClassify.classifyId}" value="${goodsClassify.classifyName}" hidden="hidden" />
								</c:forEach>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品状态：</div>
							<div class="you" style="margin-top: 5px;">
								<c:if test="${goodsInfo.goodsStatus == '1'}">已上架</c:if>
								<c:if test="${goodsInfo.goodsStatus == '2'}">已下架</c:if>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品价格：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="goodsPrice" name="goodsPrice" value="${goodsInfo.goodsPrice}" placeholder="请输入商品价格">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">折扣价格：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="discountPrice" name="discountPrice" value="${goodsInfo.discountPrice}" placeholder="请输入折扣价格">
							</div>
						</div>
						<c:if test="${goodsInfo.goodsType == '2'}">
							<div class="am-form-group am-cf" id="redPacket_div">
								<div class="zuo">宏包：</div>
								<div class="you">
									<input type="text" class="am-input-sm" id="redPacket" name="redPacket" value="${goodsInfo.redPacket}" placeholder="请输入宏包数量">
								</div>
							</div>
						</c:if>
						<div class="am-form-group am-cf">
							<div class="zuo">商品图片：</div>
							<div class="you" id="goodsImg_input_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo"></div>
							<div class="you" id="goodsImg_img_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品详情：</div>
							<div class="you" id="goodsDetails_input_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo"></div>
							<div class="you" id="goodsDetails_img_showId"></div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">商品参数：</div>
							<div class="you" id="goodsParam_input_showId">
								<c:forEach var="goodsParam" items="${goodsParamList}" varStatus="status">
									<span id="goodsParam_showId_${status.index}">
										<input type="text" class="am-input-sm" style="width: 60%; display: inline;" id="goodsParam${status.index}" name="goodsParam${status.index}" value="${goodsParam}" disabled="disabled" />
										<button type="button" onclick="goodsParamDelete(${status.index});" class="am-btn am-btn-default am-btn-xs am-text-danger am-round">
											<span class="am-icon-trash-o"></span>
										</button>
									</span>
								</c:forEach>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo"></div>
							<div class="you">
								<input type="text" class="am-input-sm" style="width: 30%; display: inline;" id="goodsParam_key" name="goodsParam_key" placeholder="请输入规格名称，请不要输入英文冒号" />
								<input type="text" class="am-input-sm" style="width: 30%; display: inline;" id="goodsParam_value" name="goodsParam_value" placeholder="请输入规格数据，请不要输入英文冒号" />
								<button type="button" onclick="goodsParamSub();" class="am-btn am-btn-default am-btn-xs am-text-danger am-round">添加</button>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">快递费：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="expressFee" name="expressFee" value="${goodsInfo.expressFee}" placeholder="请输入快递费">
							</div>
						</div>
						<div class="am-form-group am-cf" id="redPacket_div">
							<div class="zuo">库存：</div>
							<div class="you">
								<input type="text" class="am-input-sm" id="inventory" name="inventory" value="${goodsInfo.inventory}" placeholder="请输入库存数量">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">筛选条件：</div>
							<div class="you" style="margin-top: 5px;">
								<label class="am-checkbox-inline"> <input type="radio" name="sifting" value="0" <c:if test="${goodsInfo.sifting == '0'}"> checked="checked"</c:if>/> 普通商品 </label>
								<label class="am-checkbox-inline"> <input type="radio" name="sifting" value="1" <c:if test="${goodsInfo.sifting == '1'}"> checked="checked"</c:if>/> 推荐商品 </label>
								<label class="am-checkbox-inline"> <input type="radio" name="sifting" value="2" <c:if test="${goodsInfo.sifting == '2'}"> checked="checked"</c:if>/> 新品上市 </label>
								<label class="am-checkbox-inline"> <input type="radio" name="sifting" value="3" <c:if test="${goodsInfo.sifting == '3'}"> checked="checked"</c:if>/> 热卖商品 </label>
								<label class="am-checkbox-inline"> <input type="radio" name="sifting" value="4" <c:if test="${goodsInfo.sifting == '4'}"> checked="checked"</c:if>/> 促销商品 </label>
								<label class="am-checkbox-inline"> <input type="radio" name="sifting" value="5" <c:if test="${goodsInfo.sifting == '5'}"> checked="checked"</c:if>/> 卖家包邮 </label>
								<label class="am-checkbox-inline"> <input type="radio" name="sifting" value="6" <c:if test="${goodsInfo.sifting == '6'}"> checked="checked"</c:if>/> 限时抢购 </label>
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
		var goodsId = "${goodsInfo.goodsId}";
		var goodsType = "${goodsInfo.goodsType}";
		var oldGoodsImg = "${goodsInfo.goodsImg}";
		var oldGoodsDetails = "${goodsInfo.goodsDetails}";
		var path = "${goodsInfo.path}";
		var goodsParamNum = ${goodsParamNum};
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
	<script src="/resources/js/admin/goods/edit.js?1210"></script>
	<script src="/resources/js/admin/ajaxfileupload.js"></script>
</body>
</html>