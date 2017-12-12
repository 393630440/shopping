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

.pic_head{
	width:100%;
    text-align: center;
}
</style>
</head>
<body>
<div class="modal-header member_tc_top">

</div>
<div class="pic_head">
	<img style="width: 200px;" src="${MemberInfo.wechatImg }">
</div>
<input id="pathUrl" type="hidden" value="${pathUrl }"/><br />
<div>
	<div style="text-align: center">${MemberInfo.wechatName }</div>
	<div style="width: 30%;display: inline-block;"></div>
	<div id="qrcode" style="width:30%; margin-top:15px;display: inline-block;"></div>
	<div style="width: 30%;display: inline-block;"></div>
</div>

</body>
<script type="text/javascript">
var qrcode = new QRCode(document.getElementById("qrcode"), {
	width : 100,
	height : 100
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
</script>