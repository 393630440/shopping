<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>个人中心</title>
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="/resources/admin/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="/resources/admin/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="/resources/admin/css/amazeui.min.css"/>
<link rel="stylesheet" href="/resources/admin/css/admin.css">
<script src="/resources/admin/js/jquery.min.js"></script>
<script src="/resources/admin/js/app.js"></script>
</head>
<body>
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>
<body>
<!-- top-head begin -->
<jsp:include page="../common/top_head.jsp" flush="false"></jsp:include>
<!-- top-head end -->
<div class="am-cf admin-main"> 
<!-- left-head begin -->
<jsp:include page="../common/left_head.jsp" flush="false"></jsp:include>
<!-- left-head end -->
<div class=" admin-content">
		<div class="daohang">
			<ul>
			</ul>
		</div>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
		      <ul class="am-icon-flag on"> 个人中心</ul>
		      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">个人中心</a></dl>
		    </div>
			<div class="fbneirong">
		      <div class="am-form">
		        <div class="am-form-group am-cf">
		          <div class="zuo">登录账号：</div>
		          <div class="you">
		            <input type="text" readonly="readonly" value="${user.acount }" class="am-input-sm" id="acount_req">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">登录密码：</div>
		          <div class="you">
		            <input type="password" value="${user.password }" readonly="readonly" class="am-input-sm" id="password_req">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">管理员名称：</div>
		          <div class="you">
		            <input type="text" value="${user.username }" class="am-input-sm" id="username_req">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">联系电话：</div>
		          <div class="you">
		          	<input type="tel" maxlength="11" value="${user.telphone }" class="am-input-sm" id="telphone_req">
		          </div>
		        </div>
		        
		        <div class="am-form-group am-cf">
		          <div class="zuo">确认密码：</div>
		          <div class="you">
		            <input type="text" id="password_upt" placeholder="请输入原密码" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">修改密码：</div>
		          <div class="you">
		            <input type="text" id="password_upt1" placeholder="请输入新密码" class="am-input-sm">
		          </div>
		        </div>
		        <input type="hidden" id="user_id" value="${user.id }">
		        <div class="am-form-group am-cf">
		          <div class="you" style="margin-left: 11%;">
		              <button type="button" id="upt_admin_user" class="am-btn am-btn-success am-radius">修改信息</button>
		          </div>
		        </div>
		      </div>
		    </div>
		</div>
	</div>
</div>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="/resources/admin/js/polyfill/rem.min.js"></script>
<script src="/resources/admin/js/polyfill/respond.min.js"></script>
<script src="/resources/admin/js/amazeui.legacy.js"></script>
<![endif]--> 
<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="/resources/admin/js/amazeui.min.js"></script>
<!--<![endif]-->
<script type="text/javascript">
$(function(){
	$("#user_class").addClass("on");
});

$("#upt_admin_user").on("click",function(){
	var old = $("#password_req").val();
	if($("#username_req").val()==""){
		alert("管理员名称不能为空");
		return;
	}
	if($("#telphone_req").val()==""){
		alert("联系电话不能为空");
		return;
	}
	if($("#password_upt1").val()!=""){
		if($("#password_req").val()!=$("#password_upt").val()){
			alert("确认密码有误");
			return;
		}
	}
	$.ajax({
		url:"/admin/shop/user/upt",
		data:{id:$("#user_id").val(),
			password:$("#password_upt1").val(),
			username:$("#username_req").val(),
			telphone:$("#telphone_req").val()
			},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				window.location.href="/admin/shop/user/index";
			}else{
				alert(ret.error);
			}
		}
	});
	
});

</script>
</body>
</html>