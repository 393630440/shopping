<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>新增收货地址</title>
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
      <h2>收货地址</h2>
      <div class="header_right shaixuan"></div>
    </div>
  </header>
  <!--header 结束-->  	
    <form id="address_id">
	    <ul class="xzdz-ul1">
	    	<li>
	        	<p class="xzdz-p1 f-l">收货人</p>
	            <input type="text" name="recipients" placeholder="姓名" class="xzdz-ipt1 f-l" />
	            <div style="clear:both;"></div>            
	        </li>
	    	<li>
	        	<p class="xzdz-p1 f-l">手机号</p>
	            <input type="text" name="phone" placeholder="11位手机号" maxlength="11" class="xzdz-ipt1 f-l" />
	            <div style="clear:both;"></div>            
	        </li>
	    	<li>
	        	<p class="xzdz-p1 f-l">地区信息</p>
	            <div class="xzdz-ipt2box f-l">
	            	<input type="text" name="city" placeholder="省" class="xzdz-ipt2 f-l" />
	            	<input type="text" name="city" placeholder="市" class="xzdz-ipt2 f-l" />
	            	<input type="text" name="city" placeholder="区" class="xzdz-ipt2 f-l" />
	                <div style="clear:both;"></div>
	            </div>
	            <div style="clear:both;"></div>            
	        </li>
	    	<li>
	        	<p class="xzdz-p1 f-l">详细地址</p>
	            <input type="text" name="detailAddress" placeholder="街道门牌信息" class="xzdz-ipt1 f-l" />
	            <div style="clear:both;"></div>            
	        </li>
	    	<li>
	        	<p class="xzdz-p1 f-l">邮政编码</p>
	            <input type="text" name="zipCode" placeholder="邮政编码" class="xzdz-ipt1 f-l" />
	            <div style="clear:both;"></div>            
	        </li>
	    </ul>
	     <button class="drdd-btn" id="save_id">保存</button>
	    
    </form>
</div>
</body>

<script type="text/javascript">
$("#save_id").on("click",function(){
	$.ajax({
		url:"/wechat/shop/address/save",
		data:$('#address_id').serialize(),
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				window.location.href="/wechat/shop/address/page";
			}
		}
	});
});
</script>

</html>
