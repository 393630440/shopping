<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>债权发布</title>
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/login.css" rel="stylesheet" type="text/css">
<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="mobile">
  <!--页面加载 开始-->
  <jsp:include page="../common/heads.jsp"></jsp:include>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/resources/web/images/iconfont-fanhui.png"></span> </a>
      <h2>债权发布</h2>
      </div>
  </header>
  <!--header 结束-->
  <div class="w main">
     <form id="creditorid">
     <div class="item item-password">
       <select name="creditorType" class="txt-input txt-username">
       	<option value="1">债权</option>
       	<option value="2">债务</option>
       </select>
     </div>
     
     <div class="item item-password">
     	<input type="text" value="${MemberInfo.wechatName }" class="txt-input txt-username" name="creditorName" placeholder="姓名" />
     </div>
     
     <div class="item item-password">
      	<input type="text" value="${MemberInfo.cellphone }" name="creditorPhone" class="txt-input txt-username" placeholder="电话" />
     </div>
     
     <div class="item item-password">
       <select name="creditorSex" class="txt-input txt-username">
       	<option value="xy">男</option>
       	<option value="xx">女</option>
       </select>
     </div>
     
     <div class="item item-password">
     	<input type="text" name="creditorIdcard" class="txt-input txt-username" placeholder="身份证号" />
     </div>
     
     <div class="item item-password">
     	<input type="text" class="txt-input txt-username" name="creditorAddress" placeholder="身份证地址" />
     </div>
     
     <div class="item item-password">
     	<input type="text" class="txt-input txt-username" name="creditorCompany" placeholder="公司名称" />
     </div>
     
     <div class="item item-password">
     	<input type="text" class="txt-input txt-username" name="creditorCompanyAddress" placeholder="公司地址" />
     </div>
     
     <div class="item item-password">
     	<input type="text" class="txt-input txt-username" id="debtAmount_req" name="debtAmount" placeholder="金额/万元" />
     </div>
     
     <div class="item item-password">
       <select name="debtType" class="txt-input txt-username">
        <option value="1">公司债务</option>
        <option value="2">借条债务</option>
        <option value="3">欠条债务</option>
        <option value="4">判决债务</option>
        <option value="5">其他债务</option>
       </select>
     </div>
     
     <div class="item item-password">
     	<input type="date" name="debtTimeStr" class="txt-input txt-username"/>
     </div>
      </form>
    <div class="item item-password">
     	<input type="button" style="background-color: " id="saveCreditor" value="发布信息" class="txt-input txt-username"/>
     </div>
    
     <div style="height: 30px">
    
     </div>
  </div>
	<!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
</div>
</body>
</html>
<script type="text/javascript" >
$("#saveCreditor").on("click",function(){
	if($("#debtAmount_req").val()==""){
		alert("请输入金额");
		return;
	}
	$("#status").fadeOut();
	$.ajax({
		url:"/wechat/shop/creditor/save",
		data:$('#creditorid').serialize(),
		type:"POST",
		success:function(ret){
			window.location.href="/wechat/shop/creditor/selectPage";
		}
	});
});
</script> 