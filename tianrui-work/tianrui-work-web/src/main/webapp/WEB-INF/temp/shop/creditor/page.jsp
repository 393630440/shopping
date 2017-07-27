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
<script type="text/javascript" src="/resources/shop/js/jquery.js"></script>
</head>

<body>
	
    <div class="sjsc-title2">
    	<h3 class="sjsc-t2l">信息广场</h3>
        <a href="javascript:history.back();" class="sjsc-t2r"><</a>
    </div>
    
    <ul class="gwc-ul1" >
    	<span id="innerHml">
	    	<li>
	        	<div class="hwc-tu f-l"><img src="/resources/shop/images/sjsc-11-1.jpg"></div>
	            <div class="gwc-md f-l">
	            	<h3>The new Macbook 12英寸 标配 256G闪存</h3>
	                <p class="gwc-p1">募集价：<span>￥2888.00</span></p>
	                <p class="gwc-p1">剩余：<span>880</span>台</p>
	                <p class="gwc-p2">活动公告：活动期间赠送商品总额5%的资金。</p>
	            </div>
	            <div style="clear:both;"></div>
	        </li>
    	</span>
    </ul>
</body>
<script type="text/javascript">
$(function(){
	init(0);
});
function init(pageNo){
	$.ajax({
		url:"/wechat/shop/creditor/select",
		data:{"pageNo":pageNo,
			"pageSize":10},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				innerHTML(ret.data.list);
			}
		}
	});
}
function innerHTML(date){
	$("#innerHml").empty();
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
		       "<p class='gwc-p2'>活动公告：活动期间赠送商品总额5%的资金。</p>"+
		       "</div><div style='clear:both;'></div></li>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>
