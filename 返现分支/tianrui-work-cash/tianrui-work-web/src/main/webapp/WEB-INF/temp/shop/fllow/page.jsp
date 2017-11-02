<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>我的足迹</title>
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/shoujisc.css">

<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/web/css/user.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
</head>

<body>
<div class="mobile">
	<!--header 开始-->
  <!-- 
  <header>
	<div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img style="margin-left: 20px" src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>我的足迹</h2>
    </div>
  </header>
   -->
  <!--header 结束-->  
  <ul class="ui-tab-nav">
         <li class="typeClass current"><a>我的足迹</a></li>
         <li class="typeClass"><a>我的关注</a></li>
   	</ul>
   	<input type="hidden" id="ffType_req" value="2">
    <ul class="gwc-ul1" id="innerHml">

    </ul>
    
    <input type="hidden" id="scrollPage">
    <input type="hidden" id="scrollTotal">
    
</div>
</body>
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
$(function(){
	$("#ffType_req").val("2");
	init(0,0);
});

$(".typeClass").on("click",function(){
	$(".typeClass").removeClass('current');
	$(this).addClass('current');
	var hml = $(this).html();
	//默认足迹  2
	if(hml=="<a>我的足迹</a>"){
		$("#ffType_req").val("2");
	}else if(hml=="<a>我的关注</a>"){
		$("#ffType_req").val("1");
	}
	init(0,0);
});

function init(pageNo,type){
	$("#scrollPage").val(pageNo);
	$.ajax({
		url:"/wechat/shop/memberFoot/find",
		data:{"pageNo":pageNo,
			"ffType":$("#ffType_req").val(),
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
		var creType = "商品名称："+date[a].goodsName;
		var ff = "";
		if(date[a].ffType=="1"){
			ff = "我的关注";
		}else if(date[a].ffType=="2"){
			ff = "我的足迹";
		}
		var hml = "<a href='/wechat/shop/goods/goodsdetails?goodsId="+date[a].goodsId+"'><li><div class='hwc-tu f-l'><img src='"+date[a].goodsImg+"'></div>"+
		       "<div class='gwc-md f-l'><h3>"+creType+ff+"</h3>"+
		       "<p class='gwc-p1'>商品单价：<span>￥"+date[a].goodsPrice+"</span></p>"+
		       "<p class='gwc-p2'>"+(new Date(date[a].createtime).format("yyyy-MM-dd hh:mm:ss"))+"</p>"+
		       "</div><div style='clear:both;'></div></li></a>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>
