<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="nav-navicon admin-main admin-sidebar">
	<div class="sideMenu am-icon-dashboard" style="color: #aeb2b7; margin: 10px 0 0 0;">欢迎系统管理员：${user.username }</div>
	<div class="sideMenu">
		<h3 class="am-icon-flag">
			<em></em> 商品管理
		</h3>
		<ul>
			<li><a href="/admin/shop/goods/index">商品列表</a></li>
			<li><a href="/admin/shop/goods/addpage">添加新商品</a></li>
			<li><a href="/admin/shop/goodsclassify/index">商品分类</a></li>
			<li><a href="/admin/shop/goodsclassify/addpage">添加新分类</a></li>
			<li><a href="/admin/shop/ad/index">广告列表</a></li>
			<li><a href="/admin/shop/ad/addpage">添加新广告</a></li>
		</ul>
		<h3 class="am-icon-cart-plus">
			<em></em> 订单管理
		</h3>
		<ul>
			<li><a href="/admin/shop/order/index">订单列表</a></li>
			<li><a href="/admin/shop/order/waitsendlist">待发货订单列表</a></li>
			<li><a href="/admin/shop/order/refundlist">退货订单列表</a></li>
		</ul>
		<h3 class="am-icon-users" id="member_class">
			<em></em> 微信会员管理
		</h3>
		<ul>
			<li><a href="/admin/shop/member/page">会员列表</a></li>
			<li><a href="/admin/shop/member/saveHbaoPage">宏包派发</a></li>
			<li><a href="/admin/shop/member/gainPage">宏包记录</a></li>
			<li><a href="/admin/shop/deposit/page">提现管理</a></li>
		</ul>
		<h3 class="am-icon-users" id="user_class">
			<em></em> 管理员档案
		</h3>
		<ul>
			<li><a href="/admin/shop/user/index">管理员列表</a></li>
			<li><a href="/admin/shop/user/saveUsre">添加管理员</a></li>
			<li><a href="/admin/shop/user/uptPage">个人中心</a></li>
		</ul>
		<h3 class="am-icon-volume-up" id="creditor_class">
			<em></em> 债权中心
		</h3>
		<ul>
			<li><a href="/admin/shop/creditor/index">债权管理 </a></li>
		</ul>
		<h3 class="am-icon-volume-up" id="cash_class">
			<em></em> 返现管理
		</h3>
		<ul>
			<li><a href="/admin/shop/cash/page">用户返现列表 </a></li>
			<li><a href="/admin/shop/cash/pageInfo">用户返现明细 </a></li>
			<li><a href="/admin/shop/cash/savepage">新增用户返现 </a></li>
		</ul>
		<h3 class="am-icon-gears">
			<em></em> 系统设置
		</h3>
		<ul>
			<li><a href="/admin/shop/configuration/index">平台配置 </a></li>
		</ul>
	</div>

	<script type="text/javascript">
		jQuery(".sideMenu").slide({
			titCell : "h3", //鼠标触发对象
			targetCell : "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
			effect : "slideDown", //targetCell下拉效果
			delayTime : 300, //效果时间
			triggerTime : 150, //鼠标延迟触发时间（默认150）
			defaultPlay : false, //默认是否执行效果（默认true）
			returnDefault : false //鼠标从.sideMen移走后返回默认状态（默认false）
		});

		// long类型装dataStr-----new Date(data[a].createtime).format("yyyy-MM-dd hh:mm:ss")
		Date.prototype.format = function(f) {
			var o = {
				"M+" : this.getMonth() + 1, //month
				"d+" : this.getDate(), //day
				"h+" : this.getHours(), //hour
				"m+" : this.getMinutes(), //minute
				"s+" : this.getSeconds(), //second
				"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter
				"S" : this.getMilliseconds() //millisecond
			}

			if (/(y+)/.test(f)) {
				f = f.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			}
			for ( var k in o) {
				if (new RegExp("(" + k + ")").test(f)) {
					f = f.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
				}
			}
			return f
		}
	</script>
</div>