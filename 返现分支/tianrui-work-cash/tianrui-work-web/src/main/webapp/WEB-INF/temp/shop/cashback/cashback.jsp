<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>补贴派送</title>
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="${staticRoot}/shop/css/shoujisc.css">

<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/baoliao.css" rel="stylesheet" type="text/css">
<link href="${staticRoot}/web/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${staticRoot}/shop/js/jQuery.js"></script>
<!-- <script type="text/javascript" src="${staticRoot}/shop/js/zx/rewrite.new.js"></script> -->
<script>
	$(window).load(function() {
		$("#status").fadeOut();
		$("#preloader").delay(350).fadeOut("slow");
	})
</script>
</head>
<body>
	<div class="mobile">
		<!--页面加载 开始-->
		<jsp:include page="../common/heads.jsp"></jsp:include>
		<!--页面加载 结束-->

		<!--header 开始
		<header>
			<div class="header">
				<a class="new-a-back" href="javascript:history.back();">
					<span style="margin-left: 8px;">
						<img src="${staticRoot}/web/images/iconfont-fanhui.png">
					</span>
				</a>
				<h2>补贴派送</h2>
			</div>
		</header>
		<!--header 结束-->
		<div class="user_top w">
			<a href="/wechat/shop/deposit/page">
	    	<div class="user_logo"><div class="img"><img src="${MemberInfo.wechatImg }"></div></div>
	        <div class="user_info">
	            <div class="user_dengji">会员等级：
	           <c:if test="${MemberInfo.memberRank eq '1' }">普通会员</c:if>        
            	<c:if test="${MemberInfo.memberRank eq 'S' }">加盟商</c:if>        
         		<c:if test="${MemberInfo.memberRank eq 'A' }">准股东</c:if>        
         		<c:if test="${MemberInfo.memberRank eq 'B' }">VIP会员</c:if>        
         		<c:if test="${MemberInfo.memberRank eq 'C' }">VIP客户</c:if>        
         
	            </div>
	            <div class="user_dengji">账户余额：<span id="MemberInfo_balance"></span></div>
	        </div>
			</a>
	    </div>
		<ul class="ui-tab-nav">
	         <li class="typeClass current" style="width: 33.33%">
	         <a>补贴：<span id="MemberInfo_cashMoney"></span></a>
	         </li>
	         <li class="typeClass" style="width: 33.33%">
	         <a href="/wechat/shop/Hbao/page">积分：<span id="MemberInfo_redPacket"></span></a>
	         </li>
	         <li class="typeClass" style="width: 33.33%">
	         <a href="/wechat/shop/cashback/mycashback">我的补贴</a>
	         </li>
	   	</ul>
	   	<div class="user_nav_list w">
	   		<ul>
	   			<a>
               	<div class="u_nav_icon money"></div>
                <div class="u_nav_name">当天明细</div>
                <div class="nt_icon"></div>
                <!-- 
                <div class="u_money"><i>${todayEarnings}</i></div>
                 -->
                <div class="u_money"><i></i></div>
                </a>
	   		</ul>
	   		<ul class="gwc-ul1" id="nowHtml">
    		
    		</ul>
	   	</div>
	   	<div class="user_nav_list w">
	   		<ul>
	   			<a>
               	<div class="u_nav_icon money"></div>
                <div class="u_nav_name">历史明细</div>
                <div class="nt_icon"></div>
                <div class="u_money"><i></i></div>
                </a>
	   		</ul>
	   		<ul class="gwc-ul1" id="innerHml">

    		</ul>
    		<ul class="gwc-ul1">
				<div class='msg w'>
					<div class='msg_title'>
					</div>
					<div class='msg_content'>
					</div>
				</div>
    		</ul>
	   	</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
	</div>
</body>
<input type="hidden" id="scrollPage">
<input type="hidden" id="scrollTotal">
<input type="hidden" id="member_id" value="${MemberInfo.memberId }">
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
	$(function(){
		init(0,1);
		init(0,0);
		getBlance();
	});
	
	function getBlance(){
		$.ajax({
			url : "/wechat/shop/member/getMember",
			type : "POST",
			data : {
				"id": $("#member_id").val()
			},
			success : function(ret) {
				if (ret.code == "000000") {
					$("#MemberInfo_balance").html(ret.data.balance);
					$("#MemberInfo_cashMoney").html(ret.data.cashMoney);
					$("#MemberInfo_redPacket").html(ret.data.redPacket);
				}
			}
		});
	}
	
	function init(pageNo,type) {
		$("#scrollPage").val(pageNo);
		$.ajax({
			url : "/wechat/shop/cashback/findList",
			type : "POST",
			data : {
				"type": type,
				"pageNo" : pageNo,
				"pageSize" : 10
			},
			success : function(ret) {
				if (ret.code == "000000") {
					$("#scrollTotal").val(ret.data.total);
					innerHTML(ret.data.list,type);
				}
			}
		});
	}
	
	function innerHTML(data,type){
		if (data != null) {
			for (var a = 0; a < data.length; a++) {
				var hml = "<a "+(data[a].desc1 == "1"?"href='/wechat/shop/cashback/cashbacklist?cashBackId="+data[a].cashBackId+"'":"")+"><div class='msg w'>"+
							"<div class='msg_title'>"+
							"<h1>"+data[a].backRemark+"</h1>"+
							"<span>"+(new Date(data[a].createTime).format("yyyy-MM-dd hh:mm:ss"))+"</span>"+
							"</div>"+
							"<div class='msg_content'>"+(data[a].backAmount!=undefined?("总额："+data[a].backAmount):"")+"<span>金额："+data[a].backMoney+"</span></div></div></a>";
				if(type == 0){
					$("#nowHtml").append(hml);
				}else if(type == 1){
					$("#innerHml").append(hml);
				}
			}
		}
	}
</script>
</html>