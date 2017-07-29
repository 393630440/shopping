<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>后台会员管理</title>
<meta name="description" content="这是一个 index 页面">
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
		      <ul class="am-icon-flag on"> 管理员管理</ul>
		      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">管理员管理</a></dl>
		    </div>
			<div class="fbneirong">
		      <form class="am-form" id="form_user">
		        <div class="am-form-group am-cf">
		          <div class="zuo">登录账号：</div>
		          <div class="you">
		            <input type="text" class="am-input-sm" name="acount" id="acount_req" placeholder="请输入登录账号">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">登录密码：</div>
		          <div class="you">
		            <input type="text" class="am-input-sm" name="password" id="password_req" placeholder="请输入登录密码">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">管理员名称：</div>
		          <div class="you">
		            <input type="text" class="am-input-sm" name="username" id="username_req" placeholder="请输入管理员名称">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">联系电话：</div>
		          <div class="you">
		          	<input type="text" class="am-input-sm" name="telphone" id="telphone_req" placeholder="请输入联系电话">
		          </div>
		        </div>
		       	<!-- 
		        <div class="am-form-group am-cf">
			        <div class="zuo">会员权限：</div>
			        <div class="you" style="margin-top: 5px;">
			          <label class="am-checkbox-inline">
			            <input type="checkbox" value="option1">超级管理员
			          </label>
			          <label class="am-checkbox-inline">
			            <input type="checkbox" value="option2">商品管理员
			          </label>
			          <label class="am-checkbox-inline">
			            <input type="checkbox" value="option3">会员管理员
			          </label>
		            </div>
		        </div>
		       	 -->
		        <div class="am-form-group am-cf">
		          <div class="you" style="margin-left: 11%;">
		              <button type="button" id="save_admin_user" class="am-btn am-btn-success am-radius">添加管理员</button>
		          </div>
		        </div>
		      </form>
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

$("#save_admin_user").on("click",function(){
	if($("#acount_req").val()==""){
		alert("登录账号不能为空");
		return;
	}
	if($("#password_req").val()==""){
		alert("登录密码");
		return;
	}
	if($("#username_req").val()==""){
		alert("管理员名称");
		return;
	}
	if($("#telphone_req").val()==""){
		alert("联系电话");
		return;
	}
	$.ajax({
		url:"/admin/shop/user/save",
		data:$('#form_user').serialize(),
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				alert("添加成功");
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