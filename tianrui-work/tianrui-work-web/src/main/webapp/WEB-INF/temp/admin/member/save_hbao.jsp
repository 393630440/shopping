<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>宏包派发</title>
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="/resources/admin/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="/resources/admin/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="/resources/admin/css/amazeui.min.css"/>
<link rel="stylesheet" href="/resources/admin/css/admin.css">
<link rel="stylesheet" href="/resources/admin/css/select2.css">
<script src="/resources/admin/js/jquery.min.js"></script>
<script src="/resources/admin/js/select2.js"></script>
<script src="/resources/admin/js/app.js"></script>
</head>
<body>
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>
<body>
<!-- top-head begin -->
<jsp:include page="../common/top_head.jsp" flush="false"></jsp:include>
<!-- top-head end -->
<div class="am-cf admin-main"> 
<!-- left-head begin -->
<jsp:include page="../common/left_head.jsp" flush="false"></jsp:include>
<!-- left-head end -->
<div class=" admin-content">
		<div class="daohang">
			<ul>
			</ul>
		</div>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
		      <ul class="am-icon-flag on">宏包派发</ul>
		      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">宏包派发</a></dl>
		    </div>
			<div class="fbneirong">
		      <form class="am-form" id="form_member">
		        <div class="am-form-group am-cf">
		          <div class="zuo">微信名称：</div>
		          <div class="you">
						<select class="select2">
							<option value="">选择用户</option>
							<c:forEach items="${mlist }" var="member">
								<option value="${member.memberId }">${member.wechatName }</option>
							</c:forEach>
						</select>
					</div>	
				</div>
				<div class="am-form-group am-cf">
		          <div class="zuo">会员头像：</div>
		          <div class="you">
		            <img id="member_img" style="width: 60px">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">唯一标识：</div>
		          <div class="you">
		          	<input type="text" id="member_id" readonly="readonly" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">会员名称：</div>
		          <div class="you">
		            <input type="text" id="member_name" readonly="readonly" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">联系电话：</div>
		          <div class="you">
		            <input type="text" id="member_tel" readonly="readonly" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">宏包：</div>
		          <div class="you">
		            <input type="text" id="member_redPacket" readonly="readonly" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">派发数量：</div>
		          <div class="you">
		            <input type="text" id="redPacket_num" value="0" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="you" style="margin-left: 11%;">
		              <button type="button" id="save_member_hbao" class="am-btn am-btn-success am-radius">派发</button>
		          </div>
		        </div>
		      </form>
		    </div>
		</div>
	</div>
</div>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="/resources/admin/js/polyfill/rem.min.js"></script>
<script src="/resources/admin/js/polyfill/respond.min.js"></script>
<script src="/resources/admin/js/amazeui.legacy.js"></script>
<![endif]--> 
<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="/resources/admin/js/amazeui.min.js"></script>
<!--<![endif]-->
<script type="text/javascript">
$(function(){
	$("#member_class").addClass("on");
	$(".select2").select2(); 
});
$(".select2").on("change",function(){
	var openid = $(this).val();
	$.ajax({
		url:"/admin/shop/member/findMemberID",
		data:{"id":openid},
		type:"POST",
		success:function(ret){
			if(ret.code == "000000"){
				var data = ret.data;
				$("#member_img").attr("src",data.wechatImg);
				$("#member_id").val(data.memberId);
				$("#member_name").val(data.memberName);
				$("#member_tel").val(data.cellphone);
				$("#member_redPacket").val(data.redPacket);
				$("#redPacket_num").val("0")
			}
		}
	});
});
$("#save_member_hbao").on("click",function(){
	if($("#member_id").val()==""){
		alert("请选择会员");
		return;
	}
	$.ajax({
		url:"/admin/shop/member/saveHbao",
		data:{"memberId":$("#member_id").val(),
			"redPacket":$("#redPacket_num").val()},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				alert("添加成功");
			}
		}
	});
});

</script>
</body>
</html>