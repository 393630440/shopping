<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>我的会员</title>
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/shoujisc.css">

<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/web/css/user.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
</head>

<body>
<div class="mobile">
	<!--header 开始-->
  <!-- 
  <header>
	<div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img style="margin-left: 20px" src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>我的足迹</h2>
    </div>
  </header>
   -->
  <!--header 结束-->  
    <ul class="gwc-ul1" id="innerHml">
		<c:forEach items="${father }" var="father">
			<li>
				<div class='hwc-tu f-l'><img src='${father.fatherImg }'></div>
			       <div class='gwc-md f-l'>
			       <p class='gwc-p1'>微信名称：<span>${father.fatherName }</span></p>
			       <p class='gwc-p2'>上级会员</p>
			       <!-- 
			       <h3>关注时间：new Date(${father.createtime }).format("yyyy-MM-dd hh:mm:ss")</h3>
			        -->
			       </div>
		       <div style='clear:both;'></div>
	       </li>
		</c:forEach>
    </ul>
    <!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
    
    <input type="hidden" id="scrollPage">
    <input type="hidden" id="scrollTotal">
    
</div>
</body>
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
$(function(){
	$("#ffType_req").val("2");
	init(0);
});


function init(pageNo){
	$("#scrollPage").val(pageNo);
	$.ajax({
		url:"/wechat/shop/member/findRelete",
		data:{"pageNo":pageNo,
			"pageSize":10},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				$("#scrollTotal").val(ret.data.total);
				innerHTML(ret.data.list);
			}
		}
	});
}
function innerHTML(date){
	for (var a = 0; a < date.length; a++) {
		var hml = "<li><div class='hwc-tu f-l'><img src='"+date[a].memberImg+"'></div>"+
		       "<div class='gwc-md f-l'>"+
		       "<p class='gwc-p1'>会员名称：<span>"+date[a].memberName+"</span></p>"+
		       "<p class='gwc-p2'>我的会员</p>"+
		       "<h3>关注时间："+(new Date(date[a].createtime).format("yyyy-MM-dd hh:mm:ss"))+"</h3>"+
		       "</div><div style='clear:both;'></div></li></a>";
		$("#innerHml").append(hml);
	}
}
</script>
</html>
