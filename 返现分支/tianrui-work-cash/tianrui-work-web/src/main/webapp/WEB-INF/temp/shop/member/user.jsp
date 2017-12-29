<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>个人中心</title>
<link href="${staticRoot}/web/css/public.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/shoujisc.css" rel="stylesheet" type="text/css" />
<link href="${staticRoot}/web/css/user.css" rel="stylesheet" type="text/css">
<script src="${staticRoot}/web/js/jquery-1.8.3.min.js"></script>
<script src="${staticRoot}/web/js/jquery-1.8.3.min.js"></script>
<script src="/resources/web/js/bootstrap.min.js"></script>
<style type="text/css">
.member_top {
    overflow: hidden;
    position: relative;
    max-width: 768px;
    margin: 0 auto;
}
.member_m_z {
    width: 30%;
    position: absolute;
    left: 32%;
    top: 10%;
}
.member_m_pic {
    width: 25%;
    text-align: center;
    position: absolute;
    top: 6%;
    left: 3%;
    height: 100%;
    border-radius: 50%;
}
.member_m_x {
    color: #fff;
    font-size: 15px;
}
.member_m_r {
    width: 33%;
    position: absolute;
    right: 4%;
    text-align: right;
    bottom: 10%;
    color: #fff;
    font-size: 10px;
}
.member_mp_img {
    position: absolute;
    width: 35px;
    top: 10px;
    right: 10px;
    height: 44px;
}

</style>
</head>

<body>
<div class="mobile">
  <!--页面加载 开始-->
  <jsp:include page="../common/heads.jsp"></jsp:include>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <!-- 
  <header>
    <div class="header"> <a class="new-a-back" href="#"> <span><img src="${staticRoot}/web/images/iconfont-fanhui.png"></span> </a>
      <h2>个人中心</h2>
      </div>
  </header>
   -->
  <!--header 结束-->
	<!-- 
	<div class="member_top member_top_1">
		<div class="member_top_bg"><img  src="/resources/member_bg.png"></div>
		<div class="member_m_pic member_m_pic_1">
			<img class="img-circle" src="${MemberInfo.wechatImg }">
       			</div>
		<div  class="member_m_z member_m_z_1">
			<div class="member_m_x">萧雅哲</div>
			</div>
	</div>
	<div class="member_mp_img" data-toggle="modal" data-target="#myModalmin" data-title="我的名片" data-tpl="mp"><img src="/resources/member_mp_img.png"></div>
	 -->
		
	<div class="user_top w">
		<a href="/wechat/shop/member/memberInfo">
    	<div class="user_logo"><div class="img"><img src="${MemberInfo.wechatImg }"></div></div>
        <div class="user_info">
        	<div class="user_name">${MemberInfo.wechatName }</div>
            <div class="user_dengji">会员等级：
    			<c:if test="${MemberInfo.memberRank eq '1' }">普通会员</c:if>        
            	<c:if test="${MemberInfo.memberRank eq 'S' }">加盟商</c:if>        
         		<c:if test="${MemberInfo.memberRank eq 'A' }">准股东</c:if>        
         		<c:if test="${MemberInfo.memberRank eq 'B' }">VIP会员</c:if>        
         		<c:if test="${MemberInfo.memberRank eq 'C' }">VIP客户</c:if>        
         
            </div>
        </div>
		</a>
    </div>
    <div class="user_nav_list w">
    	<ul>
           <!-- 
            <li>
            	<a href="/wechat/shop/deposit/page">
                	<div class="u_nav_icon money"></div>
                    <div class="u_nav_name">我的现金</div>
                     <div class="nt_icon"></div>
                    <div class="u_money"><i>${balance }元</i></div>
              </a>
            </li>
            <li>
            	<a href="/wechat/shop/Hbao/page">
                	<div class="u_nav_icon huibi"></div>
                    <div class="u_nav_name">我的积分</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i>${redpack }个</i></div>
              </a>
            </li>
            -->
            <li>
            	<a href="/wechat/shop/cashback/index">
                	<div class="u_nav_icon huibi"></div>
                    <div class="u_nav_name">账户中心</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i></i></div>
              </a>
            </li>
           
            <li>
            	<a href="/wechat/shop/member/memberRelete">
                	<div class="u_nav_icon huibi"></div>
                    <div class="u_nav_name">我的会员</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"><i></i></div>
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
            	<a href="/wechat/shop/shoppingcart/ordinarylist">
                	<div class="u_nav_icon dingdan"></div>
                    <div class="u_nav_name">购物车</div>
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
            <!-- 
            <li>
            	<a href="/wechat/shop/member/setPage">
                	<div class="u_nav_icon znx"></div>
                    <div class="u_nav_name">消息设置</div>
                    <div class="nt_icon"></div>
                    <div class="u_money"></div>
              </a>
            </li>
             -->
            <li>
            	<a href="/wechat/shop/address/page">
                	<div class="u_nav_icon anquan"></div>
                    <div class="u_nav_name">收货地址</div>
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