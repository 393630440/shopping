<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title>发布信息</title>
<link rel="stylesheet" type="text/css" href="/resources/shop/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/shop/css/shoujisc.css">
<script type="text/javascript" src="/resources/shop/js/jquery.js"></script>
</head>

<body>
    <form id="creditorid">
	    <div class="sjsc-title1">
	    	<h3 class="sjsc-t1l f-l"><a href="JavaScript:;"><span><</span>发布信息</a></h3>
	        <a href="#" class="sjsc-t1r f-r" id="saveCreditor">保存</a>
	        <div style="clear:both;"></div>
	    </div>
	    <ul class="zlbj-ul1">
	    	<li>
	        	<p>债权人</p>
	            <div class="ipt-box f-l">
	            	<input type="radio" name="creditorType" checked="checked" value="1"/> 
	            </div>
	            <div style="clear:both;"></div>
	        </li>
	        <li>
	        	<p>债务人</p>
	            <div class="ipt-box f-l">
	            	<input type="radio" name="creditorType" value="2"/> 
	            </div>
	            <div style="clear:both;"></div>
	        </li>
	    	<li>
	        	<p>姓名</p>
	            <input type="text" name="creditorName" placeholder="" />
	            <div style="clear:both;"></div>
	        </li>
	    	<li>
	        	<p>电话</p>
	            <input type="text" name="creditorPhone" placeholder="输入你的qq号" />
	            <div style="clear:both;"></div>
	        </li>
	        <li>
	        	<p>性别</p>
	            <input type="radio" name="creditorSex" value="xy"/>男
	            <input type="radio" name="creditorSex" value="xx"/>女
	            <div style="clear:both;"></div>
	        </li>
	    	<li>
	        	<p>身份证号</p>
	            <input type="text" name="creditorIdcard" placeholder="输入你的微博" />
	            <div style="clear:both;"></div>
	        </li>
	    	<li>
	        	<p>身份证地址</p>
	            <input type="text" name="creditorAddress" placeholder="输入新密码" />
	            <div style="clear:both;"></div>
	        </li>
	    	<li>
	        	<p>公司名称</p>
	            <input type="text" name="creditorCompany" placeholder="输入你的邮箱" />
	            <div style="clear:both;"></div>
	        </li>
	    	<li>
	        	<p>公司地址</p>
	            <input type="text" name="creditorCompanyAddress" placeholder="输入你的手机号" />
	            <div style="clear:both;"></div>
	        </li>
	    	<li>
	        	<p>金额</p>
	            <input type="text" name="debtAmount" placeholder="输入你的推广码" />
	            <div style="clear:both;"></div>
	        </li>
	        <li>
	        	<p>债务类型</p>
	            <select name="debtType">
	             <option value="1">公司债务</option>
	             <option value="2">借条债务</option>
	             <option value="3">欠条债务</option>
	             <option value="4">判决债务</option>
	             <option value="5">其他债务</option>
	            </select>
	            <div style="clear:both;"></div>
	        </li>
	        <li>
	        	<p>债务时间</p>
	            <input type="date" name="debtTimeStr" />
	            <div style="clear:both;"></div>
	        </li>
	    </ul>
    </form>
</body>
<script type="text/javascript">
	$("#saveCreditor").on("click",function(){
		$.ajax({
			url:"/wechat/shop/creditor/save",
			data:$('#creditorid').serialize(),
			type:"POST",
			success:function(ret){
				
			}
		});
	});
</script>
</html>
