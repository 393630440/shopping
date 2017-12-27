<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>用户信息</title>
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="${staticRoot}/admin/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="${staticRoot}/admin/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="${staticRoot}/admin/css/amazeui.min.css"/>
<link rel="stylesheet" href="${staticRoot}/admin/css/admin.css">
<link rel="stylesheet" href="${staticRoot}/admin/css/select2.css">
<script src="${staticRoot}/admin/js/jquery.min.js"></script>
<script src="${staticRoot}/admin/js/select2.js"></script>
<script src="${staticRoot}/admin/js/app.js"></script>
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
		      <ul class="am-icon-flag on">用户信息</ul>
		      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">用户信息</a></dl>
		    </div>
			<div class="fbneirong">
		      <form class="am-form" id="form_member">
		        <div class="am-form-group am-cf">
		          <div class="zuo">微信名称：</div>
		          <div class="you">
						<input type="text" value="${member.wechatName }" class="am-input-sm" readonly="readonly">
					</div>	
				</div>
				<div class="am-form-group am-cf">
		          <div class="zuo">会员头像：</div>
		          <div class="you">
		            <img style="width: 60px" src="${member.wechatImg }">
	         	  </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">会员名称：</div>
		          <div class="you">
		            <input type="text" value="${member.memberName }" readonly="readonly" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">联系电话：</div>
		          <div class="you">
		            <input type="text" value="${member.cellphone }" readonly="readonly" class="am-input-sm">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">父级：</div>
		          <div class="you">
					<c:forEach items="${f_member }" var="fm">
			            <a href="/admin/shop/member/memberInfo?id=${fm.memberFather }">
			            <img style="width: 60px" src="${fm.fatherImg }"><br>${fm.fatherName }
			            </a>
					</c:forEach>
	         	  </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="zuo">子级：</div>
		          <div class="you">
					<c:forEach items="${c_member }" var="cm">
			            <a href="/admin/shop/member/memberInfo?id=${cm.member }">
			            <img style="width: 60px" src="${cm.memberImg }"><br>${cm.memberName }
			            </a>
					</c:forEach>
	         	  </div>
		        </div>
		        
		         <div class="am-form-group am-cf">
		          <div class="zuo">会员等级</div>
		          <div class="you">
		          	<select id="member_rank">
		          		<option value="">未设置</option>
		          		<option value="S">加盟商</option>
		          		<option value="A">A级会员</option>
		          		<option value="B">B级会员</option>
		          		<option value="C">C级会员</option>
		          	</select>
		          </div>
		        </div>
		         <div class="am-form-group am-cf">
		          <div class="zuo">缴费金额</div>
		          <div class="you">
		         	 <input type="number" id="rank_money"  placeholder="单位：元">
		          </div>
		        </div>
		        <div class="am-form-group am-cf">
		          <div class="you" style="margin-left: 11%;">
		              <button type="button" id="set_member_rank" class="am-btn am-btn-success am-radius">设置</button>
		          </div>
		        </div>
		      </form>
		    </div>
		</div>
	</div>
</div>
<input type="hidden" id="memberId" value="${member.memberId }">
<input type="hidden" id="mmm_rank" value="${member.memberRank }">

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${staticRoot}/admin/js/polyfill/rem.min.js"></script>
<script src="${staticRoot}/admin/js/polyfill/respond.min.js"></script>
<script src="${staticRoot}/admin/js/amazeui.legacy.js"></script>
<![endif]--> 
<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="${staticRoot}/admin/js/amazeui.min.js"></script>
<!--<![endif]-->
<script type="text/javascript">
$("#member_rank").val($("#mmm_rank").val());
$("#set_member_rank").on("click",function(){
	var rank = $("#member_rank").val();
	if(rank == ""){
		alert("请选择会员等级");
		return;
	}
	$.ajax({
		url:"/admin/shop/member/uptMemberRank",
		data:{"id":$("#memberId").val(),"rank":rank,"rankMoney":$("#rank_money").val()},
		type:"POST",
		success:function(ret){
			if(ret.code == "000000"){
				window.location.href="/admin/shop/member/page";
			}else{
				alert(ret.error);
			}
		}
	});
});

</script>
</body>
</html>