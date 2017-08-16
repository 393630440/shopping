<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>信息广场</title>
<link rel="stylesheet" type="text/css" href="/resources/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/shop/css/shoujisc.css">

<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="/resources/web/css/user.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="/resources/shop/js/jQuery.js"></script>
</head>

<body>
<div class="mobile">
	<!--header 开始-->
  <header>
	<div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img style="margin-left: 20px" src="/resources/web/images/iconfont-fanhui.png"></span> </a>
      <h2>信息广场</h2>
      <div class="header_right shaixuan"><img src="/resources/web/images/iconfont-shaixuan.png"></div>
    </div>
  </header>
  <!--header 结束-->  
    <ul class="gwc-ul1" id="innerHml">

    </ul>
    
     <div class="gwc-ft">
        <button onclick="window.location.href='/wechat/shop/creditor/savePage'">发布</button>
    </div>
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
		url:"/wechat/shop/creditor/select",
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
function innerHTML(date,type){
	if(type==0){
		$("#innerHml").empty();
	}
	for (var a = 0; a < date.length; a++) {
		var creType = "";
		if(date[a].creditorType=="1"){
			creType = "债权人-"+date[a].creditorName;
		}else{
			creType = "债务人-"+date[a].creditorName;
		}
		var hml = "<li><div class='hwc-tu f-l'><img src='"+date[a].creatorImg+"'></div>"+
		       "<div class='gwc-md f-l'><h3>"+creType+"</h3>"+
		       "<p class='gwc-p1'>债务金额：<span>￥"+date[a].debtAmount+"</span></p>"+
		       "<p class='gwc-p2'>发布时间："+(new Date(date[a].creatorTime).format("yyyy-MM-dd hh:mm:ss"))+"</p>"+
		       "</div><div style='clear:both;'></div></li>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>
