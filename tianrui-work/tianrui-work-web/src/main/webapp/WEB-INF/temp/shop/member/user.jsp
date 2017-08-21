<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>个人中心</title>
<link href="/resources/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="/resources/web/css/user.css" rel="stylesheet" type="text/css">
<script src="/resources/web/js/jquery-1.8.3.min.js"></script>
<script src="/resources/web/layer/layer.js"></script>
</head>
<body>
<div class="mobile">
  <!--页面加载 开始-->
  <jsp:include page="../common/heads.jsp"></jsp:include>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/resources/web/images/iconfont-fanhui.png"></span> </a>
      <h2>个人中心</h2>
      </div>
  </header>
  <!--header 结束-->
	<div class="user_top w">
		<a href="/wechat/shop/member/memberInfo">
    	<div class="user_logo"><div class="img"><img src="${MemberInfo.wechatImg }"></div></div>
        <div class="user_info">
        	<div class="user_name">${MemberInfo.wechatName }</div>
            <div class="user_dengji">会员等级：普通会员</div>
        </div>
		</a>
    </div>
    <div class="user_nav_list w">
    	<ul>
            <li>
            	<a href="/wechat/shop/deposit/page">
                	<div class="u_nav_icon money"></div>
                    <div class="u_nav_name">我的现金</div>
                     <div class="nt_icon"></div>
                    <div class="u_money"><i>${MemberInfo.balance }元</i></div>
              </a>
            </li>
            <li>
            	<a href="/wechat/shop/Hbao/page">
                	<div class="u_nav_icon huibi"></div>
                    <div class="u_nav_name">我的宏包</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i>${MemberInfo.redPacket }个</i></div>
              </a>
            </li>
            <li>
            	<a href="/wechat/shop/deposit/savePage">
                	<div class="u_nav_icon tixian"></div>
                    <div class="u_nav_name">金额提现</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i></i></div>
                </a>
            </li>
            <li>
            	<a href="/wechat/shop/deposit/savecPage">
                	<div class="u_nav_icon tixian"></div>
                    <div class="u_nav_name">账户充值</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i></i></div>
              </a>
            </li>
            <li>
            	<a href="/wechat/shop/creditor/selectPage">
                	<div class="u_nav_icon dingdan"></div>
                    <div class="u_nav_name">信息广场</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i></i></div>
              </a>
            </li>
            <li>
            	<a href="/wechat/shop/order/index">
                	<div class="u_nav_icon dingdan"></div>
                    <div class="u_nav_name">我的订单</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i></i></div>
              </a>
            </li>
             <li>
            	<a href="/wechat/shop/memberFoot/page">
                	<div class="u_nav_icon znx"></div>
                    <div class="u_nav_name">我的关注</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"></div>
              </a>
            </li>
            <li>
            	<a href="/wechat/shop/member/setPage">
                	<div class="u_nav_icon znx"></div>
                    <div class="u_nav_name">消息设置</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"></div>
              </a>
            </li>
            <li>
            	<a href="/wechat/shop/address/page">
                	<div class="u_nav_icon anquan"></div>
                    <div class="u_nav_name">收获地址</div>
                    <div class="nt_icon"></div>
              </a>
            </li>
            <li style="height: 60px">
            </li>
        </ul>
    </div>
    <!-- foods -->
    <jsp:include page="../common/foods.jsp"></jsp:include>
     <!-- foods -->
</div>
</body>
</html>