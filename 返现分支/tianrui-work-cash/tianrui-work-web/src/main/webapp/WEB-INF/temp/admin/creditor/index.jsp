<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>债权管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="${staticRoot}/admin/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="${staticRoot}/admin/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="${staticRoot}/admin/css/amazeui.min.css"/>
<link rel="stylesheet" href="${staticRoot}/admin/css/admin.css">
<script src="${staticRoot}/admin/js/jquery.min.js"></script>
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
		      <ul class="am-icon-flag on"> 债权管理</ul>
		      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">债权管理</a></dl>
		    </div>
			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
			  <ul>
			    <li>
			      <div class="am-btn-group am-btn-group-xs">
			        <select id="creditStatus" data-am-selected="{btnWidth: 100, btnSize: 'sm', btnStyle: 'default'}">
			          <option value="">信息状态</option>
			          <option value="1">正常</option>
			          <option value="0">禁用</option>
			        </select>
			      </div>
			    </li>
			    <li><input type="text" id="creditIdCard" style="width: 160px" class="am-form-field am-input-sm am-input-xm" placeholder="身份证号" /></li>
			    <li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" onclick="init(0)" style="margin-top: -1px;">搜索</button></li>
			  </ul>
			</div>
		    <div class="am-form am-g" style="overflow:scroll;">
		          <table style="white-space:nowrap;" class="am-table am-table-bordered am-table-radius am-table-striped">
		            <thead>
		              <tr class="am-success">
		                <th class="table-title">排序</th>
		                <th class="table-title">类别</th>
		                <th class="table-author am-hide-sm-only">正常/禁用 <i class="am-icon-check am-text-warning"></i> <i class="am-icon-close am-text-primary"></i></th>
		               	<th class="table-title">姓名</th>
		               	<th class="table-type">性别</th>
		               	<th class="table-type">电话</th>
		               	<th class="table-type">身份证号</th>
		               	<th class="table-type">公司名称</th>
		               	<th class="table-type">公司地址</th>
		               	<th class="table-type">债务金额</th>
		               	<th class="table-type">债务来源</th>
		                <th class="table-date am-hide-sm-only">产生时间</th>
		                <th class="table-date am-hide-sm-only">发布时间</th>
		                <th width="163px" class="table-set">操作</th>
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
<script src="/resources/js/admin/creditor/index.js?0820"></script>
</body>
</html>