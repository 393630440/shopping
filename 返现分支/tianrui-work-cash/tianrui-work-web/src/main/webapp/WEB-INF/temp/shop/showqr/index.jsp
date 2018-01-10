<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>我的二维码</title>
    <link href="/resources/ewm/css/base.css" rel='stylesheet' type='text/css'/>
    <link href="/resources/ewm/css/style.css" rel='stylesheet' type='text/css'/>
    <script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
	<script type="text/javascript" src="${staticRoot}/web/js/qrcode.js"></script>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body >
<div class="advertise">
    <div class="advleft">
        <img src="${base.wechatImg }">
    </div>
    <div class="advright">
         <h4>我是${base.wechatName }</h4>
        <div class="ershow">
            <label>我为</label>
            <img src="/resources/ewm/images/logo.jpg">
            <label>代言</label>
        </div>
    </div>
</div>
<input id="pathUrl" type="hidden" value="${pathUrl }"/>
<div class="erweima">
    <div class="erbg">
        <img src="/resources/ewm/images/circle.png">
        <div class="erimg">
	       	<div align="center" style="margin-top: 30px">
				<div id="qrcode" align="center" class="pic_head" style="width:40%; margin-top:15px;display: inline-block;"></div>
			</div>
            <!-- 
            <img src="images/erwei.png">
             -->
        </div>
    </div>
</div>
<div class="foot">
    <div class="footcont">
        <p>艾灸禄里堂，消费获补贴</p>
        <p>关注转发有惊喜。</p>
    </div>
</div>
<!--底部-->
<script src="/resources/ewm/js/jquery-1.11.1.js"></script>
<script src="/resources/ewm/js/swiper.jquery.js"></script>
<script type="text/javascript">
var qrcode = new QRCode(document.getElementById("qrcode"), {
});

function makeCode () {		
	var elText = document.getElementById("pathUrl");
	if (!elText.value) {
		alert("Input a text");
		elText.focus();
		return;
	}
	
	qrcode.makeCode(elText.value);
}
makeCode();
$("#qrcode").find("img").addClass("pic_head");
</script>
</body>
</html>


