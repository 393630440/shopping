<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>提现申请</title>
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/login.css" rel="stylesheet" type="text/css">
<script src="${staticRoot}/web/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="mobile">
  <!--页面加载 开始-->
  <jsp:include page="../common/heads.jsp"></jsp:include>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <!-- 
  <header>
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>提现申请</h2>
      </div>
  </header>
   -->
  <!--header 结束-->
  <div class="w main">
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="用户名称：${info.wechatName }">
     </div>
     
     <div class="item item-password">
       <input type="text" class="txt-input txt-username" 
       readonly="readonly" value="账户余额：${info.balance }">
     </div>
     
     <div class="item item-password">
       <input type="text" id="price" class="txt-input txt-username" 
        placeholder="提现金额">
     </div>
     
     <div class="ui-btn-wrap"> 
     <a class="ui-btn-lg ui-btn-primary" id="save" href="#">确定</a> 
     </div>
        
     
     <div style="height: 30px">
     </div>
  </div>
	<!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
</div>
</body>
<script type="text/javascript">
$("#save").on("click",function(){
	var price = $("#price").val();
	$.ajax({
		url:"/wechat/shop/deposit/save",
		type:"POST",
		data:{withdrawalAmount:price},
		success:function(ret){
			if(ret.code=="000000"){
				window.location.href="/wechat/shop/deposit/page";
			}else{
				alert(ret.error);
			}
		}
	});
});
</script>
</html>
