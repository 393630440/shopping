<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no">
<title>返现派送</title>
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
				<h2>返现派送</h2>
			</div>
		</header>
		<!--header 结束-->
		<div class="user_top w">
			<a href="/wechat/shop/member/memberInfo">
	    	<div class="user_logo"><div class="img"><img src="${MemberInfo.wechatImg }"></div></div>
	        <div class="user_info">
	        	<div class="user_name">${MemberInfo.wechatName }</div>
	            <div class="user_dengji">会员等级：
	            <c:if test="${MemberInfo.memberRank eq '1'}">
	            	普通会员
	            </c:if>
	            <c:if test="${MemberInfo.memberRank eq '2'}">
	            	加盟商
	            </c:if>
	            </div>
	            <div class="user_dengji">账户余额：${balance}</div>
	        </div>
			</a>
	    </div>
		<ul class="ui-tab-nav">
	         <li class="typeClass current"><a>累计收益：${totalEarnings}</a></li>
	         <li class="typeClass"><a>消费记录</a></li>
	         <li class="typeClass"><a href="/wechat/shop/cashback/mycashback">我的返现</a></li>
	   	</ul>
	   	<div class="user_nav_list w">
	   		<ul>
	   			<a>
               	<div class="u_nav_icon money"></div>
                <div class="u_nav_name">当天收益</div>
                <div class="nt_icon"></div>
                <div class="u_money"><i>${todayEarnings}</i></div>
                </a>
	   		</ul>
	   		<ul class="gwc-ul1" id="nowHtml">
    		
    		</ul>
	   		
	   	</div>
	   	<div class="user_nav_list w">
	   		<ul>
	   			<a>
               	<div class="u_nav_icon money"></div>
                <div class="u_nav_name">历史收益</div>
                <div class="nt_icon"></div>
                <div class="u_money"><i></i></div>
                </a>
	   		</ul>
	   		<ul class="gwc-ul1" id="innerHml">

    		</ul>
	   	</div>

		<!-- foods -->
		<jsp:include page="../common/foods.jsp"></jsp:include>
		<!-- foods -->
	</div>
</body>
<script src="/resources/js/scroll/scroll.js"></script>
<script type="text/javascript">
	var pageNo = 0;
	var pageSize = 10;
	$(function(){
		toLoad(1);
		toLoad(2);
	});
	function toLoad(type) {
		pageNo++;
		$.ajax({
			url : "/wechat/shop/cashback/findList",
			type : "POST",
			data : {
				"type":type,
				"pageNo" : pageNo,
				"pageSize" : pageSize
			},
			success : function(ret) {
				if (ret.code == "000000") {
					innerHTML(ret.data.list,type);
				}
			}
		});
	}
	
	function innerHTML(data,type){
		if (data != null) {
			for (var a = 0; a < data.length; a++) {
				var hml = "<a href='#'><div class='msg w'>"+
							"<div class='msg_title'>"+
							"<h1>"+data[a].backRemark+"</h1>"+
							"<span>"+(new Date(data[a].createTime).format("yyyy-MM-dd hh:mm:ss"))+"</span>"+
							"</div>"+
							"<div class='msg_content'>总额："+data[a].backAmount+"<span>返现金额："+data[a].backMoney+"</span></div></div></a>";
				if(type == 1){
					$("#nowHtml").append(hml);
				}else if(type == 2){
					$("#innerHml").append(hml);
				}
			}
		}
	}
</script>
</html>