<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="foods">
    	<ul>版权所有@2015 .模板收集自 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> -  More Templates<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></ul>
    	<dl><a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a></dl>
</div>
<script type="text/javascript">
function uploadImg(imgStr){
	var data = null;
	$.ajax({
		url:"/upload/add",
		data:{imgStr:imgStr},
		type:"POST",
		success:function(ret){
			data = ret;
		}
	});
	return data;
}
</script>
