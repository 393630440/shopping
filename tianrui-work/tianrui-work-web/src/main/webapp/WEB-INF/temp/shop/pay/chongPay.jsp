<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>充值中心</title>
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
            <p class="qrdd-p1">充值中心</p>
            <p class="qrdd-p1"></p>
        </div>
       	<p class="qrdd-p2">充值金额
	       	¥<span id="PriceMoney">  
				${money }
	       	</span>
       	</p>
        <div class="qrdd-tj">
        	<button id="goPay" >去支付</button>
        	<button>取消</button>
        </div>
    </div>
</body>
<script type="text/javascript">
$("#goPay").on("click",function(){
	var money = $("#PriceMoney").html();
	window.location.href="/wechat/shop/pay/cpage?payMoney="+money;
});
</script>
</html>
