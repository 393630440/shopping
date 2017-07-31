<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>个人资料</title>
<link rel="stylesheet" type="text/css" href="/resources/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/shop/css/shoujisc.css">
<script type="text/javascript" src="/resources/shop/js/jquery.js"></script>
</head>

<body>
	
    <div class="sjsc-title1">
    	<h3 class="sjsc-t1l f-l"><a href="JavaScript:;"><span><</span>个人信息</a></h3>
        <a href="#" class="sjsc-t1r f-r">保存</a>
        <div style="clear:both;"></div>
    </div>
    <ul class="zlbj-ul1">
    	<li>
        	<p>姓名</p>
            <input type="text" value="${MemberInfo.memberName }" placeholder="输入你的姓名" />
            <div style="clear:both;"></div>
        </li>
    	<li>
        	<p>手机号</p>
            <input type="text" value="${MemberInfo.cellphone }" placeholder="输入你的微信号" />
            <div style="clear:both;"></div>
        </li>
    	<li>
        	<p>微信名称</p>
            <input type="text" value="${MemberInfo.wechatName }" placeholder="输入你的手机号" />
            <div style="clear:both;"></div>
        </li>
    	<li>
        	<p>出生日期</p>
            <input type="text" value="${MemberInfo.birthTime }" placeholder="输入你的手机号" />
            <div style="clear:both;"></div>
        </li>
        <li>
        	<p>所在城市</p>
            <input type="text" value="${MemberInfo.city }" placeholder="输入你的手机号" />
            <div style="clear:both;"></div>
        </li>
        <li>
        	<p>宏包比例</p>
            <input type="text" value="${MemberInfo.rpExchangeRatio }" placeholder="输入你的手机号" />
            <div style="clear:both;"></div>
        </li>
        <li>
        	<p>挂牌宏包</p>
            <input type="text" value="${MemberInfo.rpListingRatio }" placeholder="输入你的手机号" />
            <div style="clear:both;"></div>
        </li>
    </ul>
    
   	<!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
    <!-- foods -->
    
</body>
</html>
