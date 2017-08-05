<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>管理员登录</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="stylesheet" href="/resources/admin/login/css/amazeui.min.css">
  <link rel="stylesheet" href="/resources/admin/login/css/app.css">
</head>
<body>
<div class="am-g myapp-login">
	<div class="myapp-login-bg">
		 <div class="myapp-login-logo">
		 	<i class="am-icon-stumbleupon"></i>
		 </div>
		 <div class="am-u-sm-10 myapp-login-form">
		 	<form class="am-form">
			  <fieldset>
			    <div class="am-form-group" style="text-align:center">
			      <input type="text" class="" id="acount" value="admin" placeholder="请输入账号">
			    </div>
			    <div class="am-form-group">
			      <input type="password" class="" id="passward" value="666666"  placeholder="请输入密码">
			    </div>
			    <p><button type="button" class="am-btn am-btn-default" id="loginIn">Login</button></p>
			    <div class="login-text">
			    	Forgot Password?
			    </div>
			  </fieldset>
			</form>
		 </div>
	</div>
</div>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="/resources/admin/login/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="/resources/admin/login/js/amazeui.min.js"></script>
<script src="/resources/admin/login/js/app.js"></script>
<script type="text/javascript">
$("#loginIn").on("click",function(){
	var acount = $("#acount").val();
	var passward = $("#passward").val();
	$.ajax({
		url:"/public/shop/adminLogin/loginin",
		data:{"acount":acount,"password":passward},
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