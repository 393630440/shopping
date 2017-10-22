<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>宏包</title>
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="/resources/web/css/user.css" rel="stylesheet" type="text/css">
<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
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
      <h2>宏包</h2>
      <div class="header_right shaixuan"><img src="/resources/web/images/iconfont-shaixuan.png"></div>
    </div>
  </header>
  <!--header 结束-->
	<ul class="ui-tab-nav">
         <li class="current"><a href="/wechat/shop/Hbao/pubPage">宏包广场</a></li>
         <li><a href="/wechat/shop/Hbao/page">我的宏包</a></li>
   	</ul>
   <span id="innerHml"></span>
  </div>
   <!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
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
	$("#status").fadeOut();
	$.ajax({
		url:"/wechat/shop/Hbao/findHbao",
		data:{"pageNo":pageNo,
			"rpTradeMark":1,
			"pageSize":10},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				$("#scrollTotal").val(ret.data.total);
				innerHTML(ret.data.list,type);
				$("#preloader").fadeOut("slow");
			}
		}
	});
}
function innerHTML(data,type){
	if(type==0){
		$("#innerHml").empty();
	}
	for (var a = 0; a < data.length; a++) {
		var hml = "<a href='/wechat/shop/HbaoPay/page?id="+data[a].memberId+"'><div class='baoliao_content'><div class='bl_img'><img src='"+data[a].wechatImg+"' /></div>"+
        "<div class='bl_right'>"+
        "<div class='bl_title'>"+data[a].wechatName+"--出售宏包数量"+data[a].redPacket+"个</div>"+
        "<div class='bl_tag'>"+
        "<div class='bl_price'>优惠价："+(data[a].redPacket*data[a].rpExchangeRatio)+"</div>"+
        "<div class='bl_oprice'>原价："+data[a].redPacket+"</div>"+
        "</div></div></div></a>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>