<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>返现派送</title>
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/style.new.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/shoujisc.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/web/css/index.css" />
<link rel="stylesheet" type="text/css" href="${staticRoot}/web/css/public.css" />
<script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
<script type="text/javascript" src="${staticRoot}/shop/js/woxiangyao.js"></script>
<!-- <script type="text/javascript" src="${staticRoot}/shop/js/zx/rewrite.new.js"></script> -->
<script>
	$(window).load(function() {
		$("#status").fadeOut();
		$("#preloader").delay(350).fadeOut("slow");
	})
</script>
</head>
<body>
	<div class="mobile">
		<!--页面加载 开始-->
		<jsp:include page="../common/heads.jsp"></jsp:include>
		<!--页面加载 结束-->

		<!--header 开始
		<header>
			<div class="header">
				<a class="new-a-back" href="javascript:history.back();">
					<span style="margin-left: 8px;">
						<img src="${staticRoot}/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>返现派送</h2>
			</div>
		</header>
		<!--header 结束-->

		<div class="m_baoliao w">
			<div class="baoliao_title">
				<span style="margin-left: 30%; color: #040504;">账户余额：${balance}</span>
			</div>

			<ul class="quanbu-title2-zx">
				<li style="width: 40%;"><a href="JavaScript:;">累计收益：${totalEarnings}</a></li>
				<li style="width: 40%;"><a href="JavaScript:;">当天收益：${todayEarnings}</a></li>
				<li style="width: 20%;"><a href="/wechat/shop/cashback/mycashback">我的返现</a></li>
				<div style="clear: both;"></div>
			</ul>

			<div class="my-dd">
				<div class="my-info">
					<div class="my-k1" id="dataList_showId">
						<c:forEach var="data" items="${dataList}">
							<div class="my-p2-zx">
								<span class="my-sp3 f-l">${data.backRemark}</span>
								<span class="my-sp3-zx f-l">${data.backAmount}</span>
								<span class="my-sp3 f-r">${data.backMoney}</span>
								<div style="clear: both;"></div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="w-zx-1">
				<div class="bl_more">
					<a href="javascript:void(0);" onclick="toLoad();">加载更多</a>
				</div>
			</div>
		</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
	</div>
</body>
<script type="text/javascript">
	var pageNo = 0;
	var pageSize = 10;

	function toLoad() {
		pageNo++;
		$.ajax({
			url : "/wechat/shop/cashback/querylist",
			type : "POST",
			data : {
				"type" : "1",
				"pageNo" : pageNo,
				"pageSize" : pageSize
			},
			success : function(ret) {
				if (ret.code == "000000") {
					innerHTML(ret.data);
				}
			}
		});
	}

	function innerHTML(data) {
		if (data != null) {
			for (var a = 0; a < data.length; a++) {
				var html = "";
				html += "<div class=\"my-p2-zx\">";
				html += "<span class=\"my-sp3 f-l\">" + data[a].backRemark + "</span>";
				html += "<span class=\"my-sp3-zx f-l\">" + data[a].backAmount + "</span>";
				html += "<span class=\"my-sp3 f-r\">" + data[a].backMoney + "</span>";
				html += "<div style=\"clear: both;\"></div>";
				html += "</div>";
				$("#dataList_showId").append(html);
			}
		}
	}
</script>
</html>