$(function(){
	$("#cash_class").addClass("on");
	init(0);
});
function init(pageNo){
	$.ajax({
		url:"/admin/shop/cash/find",
		data:{"pageNo":pageNo,
			"cellphone":$("#telphone").val(),
			"wechatName":$("#wechatName").val(),
			"rpTradeMark":$("#rpTradeMark").val(),
			"pageSize":10},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				innerHTML(ret.data.list,pageNo);
				pageTool(ret.data.total,pageNo,10);
			}
		}
	});
}
function innerHTML(data,pageNo){
	$("#innerHml").empty();
	for (var a = 0; a < data.length; a++) {
		var hml = "<tr><td>"+(a+1)+"</td>" +
				"<td>"+(data[a].cashMemberName||"")+"</td>" +
				"<td "+(data[a].cashType||"")+"</td>" +
				"<td>"+(data[a].cashAmount||"")+"</td>" +
				"<td>"+(data[a].cashAlre||"")+"</td>" +
				"<td>"+(data[a].createTime||"")+"</td>" +
				"<td>"+(data[a].modifyTime==undefined?"":(new Date(data[a].modifyTime).format("yyyy-MM-dd hh:mm:ss")))+"</td>" +
				"</tr>";
		$("#innerHml").append(hml);
	}
}
//禁用数据
function uptUser(id,pageNo){
	$.ajax({
		url:"/admin/shop/user/uptUser",
		data:{"id":id},
		type:"POST",
		success:function(ret){
			if(ret.code == "000000"){
				init(pageNo);
			}else{
				alert(ret.error);
			}
		}
	});
}
$("#save_adminUSer").on("click",function(){
	window.location.href="/admin/shop/user/saveUsre";
});

var sdas = "<td><div class='am-btn-toolbar'>" +
			"<div class='am-btn-group am-btn-group-xs'>" +
			"<button class='am-btn am-btn-default am-btn-xs am-text-success am-round'>" +
			"<span class='am-icon-search'></span>" +
			"</button>" +
			"<button class='am-btn am-btn-default am-btn-xs am-text-secondary am-round'>" +
			"<span class='am-icon-pencil-square-o'></span>" +
			"</button>" +
			"<button class='am-btn am-btn-default am-btn-xs am-text-warning  am-round'>" +
			"<span class='am-icon-copy'></span>" +
			"</button>" +
			"<button class='am-btn am-btn-default am-btn-xs am-text-danger am-round'>" +
			"<span class='am-icon-trash-o'></span>" +
			"</button>" +
			"</div>" +
			"</div></td>";









