<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>我的二维码</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
<script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
<script type="text/javascript" src="${staticRoot}/web/js/qrcode.js"></script>
<style type="text/css">
.member_tc_top {
    background: #666666;
    color: #fff;
    text-align: center;
}
.modal-header {
    min-height: 16.42857143px;
    padding: 15px;
    border-bottom: 1px solid #e5e5e5;
}
.member_tc_xx {
    height: 33px;
    width: 33px;
    margin-top: -6px!important;
    font-size: 34px;
    color: #fff;
    font-weight: normal;
    opacity: 1;
}
.member_m_pic {
    width: 25%;
    text-align: center;
    position: absolute;
    top: 6%;
    left: 3%;
    height: 100%;
    border-radius: 50%;
}

.pic_head{
	width:100%;
    text-align: center;
    border:2px solid #F8F8FF;
}
</style>
</head>
<body style="background-color:#8EE5EE;">
<div style="width: 100%;height: 100% ">
	<div style="overflow:hidden;width: 100%;padding-top: 20px;">
		<div class="member_m_pic">
			<img style="width: 60px;border:2px solid #F8F8FF;"  src="${MemberInfo.wechatImg }">
		</div>
		<div style="display:inline;overflow:hidden;padding-top: 1px;">
			<span style="margin-left: 90px;font-weight:20px">
			我是<span style="color: blue;font-size: 35px">${MemberInfo.wechatName }</span>
			</span>
			<br>
			<span style="margin-left: 90px">
				我为<span style="color: red;font-size: 30px;">自己代言...</span>
			</span>
		</div>
	</div>
	<input id="pathUrl" type="hidden" value="${pathUrl }"/>
	<div style="margin-top: 200px">
		<div style="width: 30%;display: inline-block;"></div>
		<div id="qrcode" class="pic_head" style="width:40%; margin-top:15px;display: inline-block;"></div>
		<div style="width: 30%;display: inline-block;"></div>
	</div>
	<div style="text-align: center;">
		<span style="font-size: 35px;color: red">
		会员返点&nbsp消费返现<br>快快加入我们吧
		</span>
	</div>
</div>

</body>
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