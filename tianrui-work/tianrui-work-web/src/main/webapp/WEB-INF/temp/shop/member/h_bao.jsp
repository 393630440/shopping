<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>优惠爆料 — 一起惠返利网·触摸版</title>
<link href="/resources/shop/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/shop/css/baoliao.css" rel="stylesheet" type="text/css">

<script src="js/jquery-1.8.3.min.js"></script>
<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
})
</script>
<script type="text/javascript">
$(document).ready(function(){
	$(".shaixuan").click(function(event){
		event.stopPropagation(); 
		$(".shaixuan_box").show();
		$(".shaixuan_box").animate({right:'100%'});
		$("body,html").css("overflow","hidden");
		$(".shaixuan_box").css("overflow","auto");
		$('body').bind("touchmove",function(e){    
                    e.preventDefault();    
            });
	});
	$(".shaixuan_mall a").click(function(event){
		 $("body,html").css("overflow","auto");
		$(".shaixuan_box").animate({right:'-100%'});
		$(".shaixuan_box").hide(5);	
		$("body").unbind("touchmove");  
	});
});
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
    <div class="header"> <a class="new-a-back" href="index.html"> <span><img src="images/iconfont-fanhui.png"></span> </a>
      <h2>优惠爆料</h2>
      <div class="header_right shaixuan"><img src="images/iconfont-shaixuan.png"></div>
    </div>
  </header>
  <!--header 结束-->
  <div class="baoliao w">
  	<div class="ui-tab">
		<ul class="ui-tab-nav">
            <li class="current"><a href="#">最新爆料</a></li>
            <li><a href="#">优质爆料</a></li>
      </ul>
      <div class="ui-tab-content">
        
            <a href="baoliao_view.html">
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
        <div class="bl_more"><a href="#">加载更多</a></div>
    </div>
  </div>
</div>
</body>
</html>