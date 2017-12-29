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
<title>补贴明细列表</title>
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/shoujisc.css">
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/web/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
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
				<h2>补贴明细列表</h2>
			</div>
		</header>
		<!--header 结束-->

		<div class="m_baoliao w">
			<div class="my-dd">
				<div class="my-info">
					<div class="my-k1" id="dataList_showId">
						
					</div>
				</div>
			</div>
		</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
	</div>
</body>
<input type="hidden" id="scrollPage">
<input type="hidden" id="scrollTotal">
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
	var cashBackId = "${cashBackId}";
	init(0,0);
	function init(pageNo,type) {
		$("#scrollPage").val(pageNo);
		$.ajax({
			url : "/wechat/shop/cashback/findList",
			type : "POST",
			data : {
				"cashBackId":cashBackId,
				"pageNo" : pageNo,
				"pageSize" : 10
			},
			success : function(ret) {
				if (ret.code == "000000") {
					$("#scrollTotal").val(ret.data.total);
					innerHTML(ret.data.list,type);
				}
			}
		});
	}
	
	function innerHTML(data,type){
		if (data != null) {
			for (var a = 0; a < data.length; a++) {
				var hml = "<a><div class='msg w'>"+
							"<div class='msg_title'>"+
							"<h1>"+data[a].backRemark+"</h1>"+
							"<span>"+(new Date(data[a].createTime).format("yyyy-MM-dd hh:mm:ss"))+"</span>"+
							"</div>"+
							"<div class='msg_content'>总额："+data[a].backAmount+"<span>补贴金额："+data[a].backMoney+"</span></div></div></a>";
				$("#dataList_showId").append(hml);
			}
		}
	}

</script>
</html>