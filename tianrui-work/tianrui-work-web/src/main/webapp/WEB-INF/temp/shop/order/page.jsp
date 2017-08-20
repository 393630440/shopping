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
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="/resources/web/css/user.css" rel="stylesheet" type="text/css">

<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
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
    <div class="header"> <a class="new-a-back" href="/wechat/shop/member/userPage"> <span><img src="/resources/web/images/iconfont-fanhui.png"></span> </a>
      <h2>我的订单</h2>
      <div class="header_right shaixuan"><img src="/resources/web/images/iconfont-shaixuan.png"></div>
    </div>
  </header>
  <!--header 结束-->
   <ul class="ui-tab-nav">
         <li class="current"><a href="">未支付</a></li>
         <li><a href="">待发货</a></li>
         <li><a href="">运输中</a></li>
         <li><a href="">已完成</a></li>
   	</ul>
   	 <ul class="gwc-ul1" id="innerHml">

     </ul>
  </div>
<input type="hidden" id="scrollPage">
<input type="hidden" id="scrollTotal">
</body>
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
$(function(){
	init(0,0);
});
function init(pageNo,type){
	$("#scrollPage").val(pageNo);
	$.ajax({
		url:"/wechat/shop/order/querylist",
		data:{"pageNo":pageNo,
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
		var hml = "<a href='/wechat/shop/order/detailPage?id="+data[a].orderId+"'><div class='msg w'>"+
				"<div class='msg_title'>"+
				"<h1>订单编号："+data[a].orderCode+"</h1>"+
				"<span>"+(new Date(data[a].creationTime).format("yyyy-MM-dd hh:mm:ss"))+"</span>"+
				"</div>"+
				"<div class='msg_content'>未支付<span>订单金额："+data[a].orderAmount+"</span></div></div></a>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>