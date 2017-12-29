<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
a {
    color: #000;
    text-decoration: none;
}
</style>
<ul class="quanbu-ul1" style="z-index:999">
    	<li class="foods_01" style="width: 25%">
        	<div class="qu-tu1">
            	<a href="/wechat/shop/goods/goodshome?goodsType=1" class="atu1"><img src="${staticRoot}/shop/images/sjsc-02.gif"></a>
            	<a href="/wechat/shop/goods/goodshome?goodsType=1" class="atu2"><img src="${staticRoot}/shop/images/sjsc-15-1.gif"></a>
            </div>
            <a href="/wechat/shop/goods/goodshome?goodsType=1" class="qu-ul1a">会员商城</a>
        </li>
    	<li class="foods_02" style="width: 25%">
        	<div class="qu-tu1">
            	<a href="/web/show/qr/index?memberId=${MemberInfo.memberId }" class="atu1"><img src="${staticRoot}/shop/images/sjsc-16.png"></a>
            	<a href="/web/show/qr/index?memberId=${MemberInfo.memberId }" class="atu2"><img src="${staticRoot}/shop/images/sjsc-16-1.png"></a>
            </div>
            <a href="/web/show/qr/index?memberId=${MemberInfo.memberId }" class="qu-ul1a">分享</a>
        </li>
    	<li class="foods_03" style="width: 25%">
        	<div class="qu-tu1">
            	<a href="/wechat/shop/shoppingcart/ordinarylist" class="atu1"><img src="${staticRoot}/shop/images/sjsc-17.png"></a>
            	<a href="/wechat/shop/shoppingcart/ordinarylist" class="atu2"><img src="${staticRoot}/shop/images/sjsc-17-1.png"></a>
            </div>
            <a href="/wechat/shop/shoppingcart/ordinarylist" class="qu-ul1a">购物车</a>
        </li>
    	 
    	<li class="foods_05" style="width: 25%">
        	<div class="qu-tu1">
            	<a href="/wechat/shop/member/userPage" class="atu1"><img src="${staticRoot}/shop/images/sjsc-18.png"></a>
            	<a href="/wechat/shop/member/userPage" class="atu2"><img src="${staticRoot}/shop/images/sjsc18-1.png"></a>
            </div>
            <a href="/wechat/shop/member/userPage" class="qu-ul1a">我</a>
        </li>
        <div style="clear:both;"></div>
    </ul>
