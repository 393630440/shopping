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
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/owl.carousel.css" rel="stylesheet">
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/index.css" rel="stylesheet" type="text/css" />
<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
<script src="/resources/web/js/owl.carousel.min.js"></script>
<script src="/resources/web/layer/layer.js"></script>
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
					<span>
						<img src="/resources/web/images/iconfont-fanhui.png">
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
		  	<div class="baoliao_title"><span>宏包商城</span><em><span onclick="init(0,0)"><img src="/resources/web/images/iconfont-shuaxin.png"></span></em></div>
		    <div class="baoliao_list" id="innerHml">
		        <a href="#">
		        <div class="baoliao_content">
		            <div class="bl_img"><img src="http://baoliao.178hui.com/upload/2015/0710/12332059693.jpg" /></div>
		            <div class="bl_right">
		                <div class="bl_title">韩国现代（HYUNDAI) BD-YS2003 多功能养生壶 煎药壶2.0L</div>
		                <div class="bl_note">手机端：99元包邮</div>
		                <div class="bl_tag">
		                    <div class="bl_price">￥99.00</div>
		                    <div class="bl_oprice">￥138.00</div>
		                    <div class="bl_time">07-10 12:33</div>
		                    <div class="bl_mall">京东商城</div>
		                </div>
		            </div>
		        </div> 
		        </a>
		    </div>
		  <div class="baoliao_content">
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
$(function(){
	init(0,0);
});

function init(pageNo,type){
	$("#scrollPage").val(pageNo);
	$.ajax({
		url:"/wechat/shop/goods/toloadgoodslist",
		data:{"pageNo":pageNo,
			"goodsType":2,
			"pageSize":10},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				$("#scrollTotal").val(ret.data.total);
				innerHTML(ret.data.list,type);
			}
		}
	});
}
function innerHTML(date,type){
	if(type==0){
		$("#innerHml").empty();
	}
	for (var a = 0; a < date.length; a++) {
		var goodsType = "";
		if(date[a].goodsType == 1){
			goodsType = "大众商品";
		}else if(date[a].goodsType == 2) {
			goodsType = "宏包商品";
		}
		
		var hml = "<a href='/wechat/shop/goods/goodsdetails?goodsId="+date[a].goodsId+"'>"+
		"<div class='baoliao_content'>"+
		"<div class='bl_img'>"+
		"<img src='"+date[a].path+date[a].firstGoodsImg+"' />"+
		"</div><div class='bl_right'>"+
            "<div class='bl_title'>"+date[a].goodsName+"</div>"+
            "<div class='bl_note'>邮费："+date[a].expressFee+"</div>"+
            "<div class='bl_tag'>"+
            "<div class='bl_price'>￥"+date[a].goodsPrice+"</div>"+
            //"<div class='bl_oprice'>￥138.00</div>"+
            "<div class='bl_time'>"+(new Date(date[a].pubdate).format("yyyy-MM-dd hh:mm:ss"))+"</div>"+
            "<div class='bl_mall'>"+goodsType+"</div></div>"+
            "</div></div></a>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>