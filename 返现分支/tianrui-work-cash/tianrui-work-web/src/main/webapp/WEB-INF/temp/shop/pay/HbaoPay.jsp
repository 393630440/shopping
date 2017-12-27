<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>积分交易</title>
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/shoujisc.css">
<script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
</head>
<body>
	
    <div class="sjsc-title1">
    	<h3 class="sjsc-t1l f-l"><a href="JavaScript:;"><span><</span>选择支付</a></h3>
        <div style="clear:both;"></div>
    </div>
    
    <div class="qrdd-info1">
    	<img src="${staticRoot}/shop/images/sjsc19.gif">
    </div>
    
    <div class="qrdd-info2">
    	<div class="qrdd-xian">
            <p class="qrdd-p1">积分广场交易积分</p>
            <p class="qrdd-p1">${time }</p>
        </div>
    	<p class="qrdd-p2">积分数量<span>  ${info.redPacket }</span></p>
    	<p class="qrdd-p2">积分单价<span>  ¥${info.rpExchangeRatio }</span></p>
       	<p class="qrdd-p2">购买数量
	       	<span>  
	       		<input type="text" id="baoNum" value="${info.redPacket }">
	       	</span>
       	</p>
       	<p class="qrdd-p2">支付价格
	       	¥<span id="baoPrice">  
				${info.redPacket * info.rpExchangeRatio }
	       	</span>
       	</p>
       	<input type="hidden" id="memberId" value="${info.memberId }">
       	<input type="hidden" id="rpExchangeRatio" value="${info.rpExchangeRatio }">
        <div class="qrdd-tj">
        	<button id="goPay" >去支付</button>
        	<button>取消</button>
        </div>
    </div>
</body>
<script type="text/javascript">
$("#baoNum").on("change",function(){
	var num = $("#baoNum").val();
	var price = $("#rpExchangeRatio").val();
	$("#baoPrice").html(+(num*price).toFixed(2));
});
$("#goPay").on("click",function(){
	var money = $("#baoPrice").html();
	window.location.href="/wechat/shop/pay/page?payMoney="+money+"&toPayOpenid="+$("#memberId").val()+"&payNum="+$("#baoNum").val();
	return;
	$.ajax({
		url:"/wechat/shop/HbaoPay/hBaoPay",
		data:{"toPayOpenid":$("#memberId").val(),
			"payNum":$("#baoNum").val()},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				window.location.href="/wechat/shop/Hbao/page";
			}else{
				alert(ret.error);
			}
		}
	});
});
</script>
</html>
