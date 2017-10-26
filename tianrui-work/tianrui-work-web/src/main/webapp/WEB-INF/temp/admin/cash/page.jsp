<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>返现管理</title>
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="/resources/admin/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="/resources/admin/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="/resources/admin/css/amazeui.min.css"/>
<link rel="stylesheet" href="/resources/admin/css/admin.css">
<script src="/resources/admin/js/jquery.min.js"></script>
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
		      <ul class="am-icon-flag on"> 返现管理</ul>
		      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">返现管理</a></dl>
		    </div>
			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
			  <ul>
			   	<li>
			      <div class="am-btn-group am-btn-group-xs">
			        <select id="cashTypeReq" data-am-selected="{btnWidth: 100, btnSize: 'sm', btnStyle: 'default'}">
			          <option value="">返现类型</option>
			          <option value="1">后台</option>
			          <option value="2">前台</option>
			        </select>
			      </div>
			    </li>
			   	<li>
			   	<input type="text" id="cashMemberNameReq" style="width: 160px"
			   	 class="am-form-field am-input-sm am-input-xm" placeholder="返现用户" /></li>
			    <li>
			    <input type="text" id="cashRemarkReq" style="width: 160px" 
			    class="am-form-field am-input-sm am-input-xm" placeholder="备注信息" /></li>
			    <li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" onclick="init(0)" style="margin-top: -1px;">搜索</button></li>
			  </ul>
			</div>
		    <div class="am-form am-g">
		          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
		            <thead>
		              <tr class="am-success">
		                <th class="table-title">序号</th>
		               	<th class="table-type">返现用户</th>
		               	<th class="table-type">备注信息</th>
		               	<th class="table-type">返现类别 </th>
		               	<th class="table-type">返现金额</th>
		               	<th class="table-type">已返金额</th>
		               	<th class="table-type">创建时间</th>
		               	<th class="table-type">更新时间</th>
		              </tr>
		            </thead>
		            <tbody id="innerHml">
		            
		            </tbody>
		          </table>
		         <!-- page begin-->
				  <jsp:include page="../common/pageTool.jsp" flush="false"></jsp:include>
				 <!-- page end -->
		          <hr />
		        </div>
		</div>
		<!-- left-head begin-->
		<jsp:include page="../common/foods.jsp" flush="false"></jsp:include>
		<!-- left-head end -->
		</div>
</div>
<script src="/resources/admin/js/amazeui.min.js"></script>
<script src="/resources/js/admin/cash/page.js?10262"></script>
</body>
</html>