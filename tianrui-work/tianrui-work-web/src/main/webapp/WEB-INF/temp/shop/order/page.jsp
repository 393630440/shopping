<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>我的订单</title>
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/web/css/user.css" rel="stylesheet" type="text/css">

<script src="${staticRoot}/web/js/jquery-1.8.3.min.js"></script>
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
  <div id="preloader">
    <div id="status">
      <p class="center-text"><span>拼命加载中···</span></p>
    </div>
  </div>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="/wechat/shop/member/userPage"> <span><img src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>我的订单</h2>
      <div class="header_right shaixuan"><img src="${staticRoot}/web/images/iconfont-shaixuan.png"></div>
    </div>
  </header>
  <!--header 结束-->
   <ul class="ui-tab-nav">
         <li class="current payType"><a>未支付</a></li>
         <li class="payType"><a>待发货</a></li>
         <li class="payType"><a>运输中</a></li>
         <li class="payType"><a>已完成</a></li>
   	</ul>
   	 <ul class="gwc-ul1" id="innerHml">

     </ul>
  </div>
<input type="hidden" id="scrollPage">
<input type="hidden" id="scrollTotal">
<input type="hidden" id="orderStatus_req" value="1">
</body>
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
$(".payType").on("click",function(){
	$(".payType").removeClass('current');
	$(this).addClass('current');
	var hml = $(this).html();
	if(hml == "<a>未支付</a>"){
		$("#orderStatus_req").val("1");
	}else if(hml == "<a>待发货</a>"){
		$("#orderStatus_req").val("2");
	}else if(hml == "<a>运输中</a>"){
		$("#orderStatus_req").val("3");
	}else if(hml == "<a>已完成</a>"){
		$("#orderStatus_req").val("4");
	}
	init(0,0);
});

$(function(){
	init(0,0);
});
function init(pageNo,type){
	$("#scrollPage").val(pageNo);
	$.ajax({
		url:"/wechat/shop/order/querylist",
		data:{"pageNo":pageNo,
			"orderStatus":$("#orderStatus_req").val(),
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
function innerHTML(data,type){
	if(type==0){
		$("#innerHml").empty();
	}
	for (var a = 0; a < data.length; a++) {
		var orderStatus = "";
		if(data[a].orderStatus=="1"){
			orderStatus = "未支付"
		}else if(data[a].orderStatus=="2"){
			orderStatus = "待发货"
		}else if(data[a].orderStatus=="3"){
			orderStatus = "运输中"
		}else if(data[a].orderStatus=="4"){
			orderStatus = "已完成"
		}///wechat/shop/shoppingcart/unpaidorderpage?addressId=0&orderId=
		///wechat/shop/order/detailPage?id=
		var hml = "<a href='/wechat/shop/shoppingcart/unpaidorderpage?addressId=0&orderId="+data[a].orderId+"'><div class='msg w'>"+
				"<div class='msg_title'>"+
				"<h1>订单编号："+data[a].orderCode+"</h1>"+
				"<span>"+(new Date(data[a].creationTime).format("yyyy-MM-dd hh:mm:ss"))+"</span>"+
				"</div>"+
				"<div class='msg_content'>"+orderStatus+"<span>订单金额："+data[a].orderAmount+"</span></div></div></a>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>