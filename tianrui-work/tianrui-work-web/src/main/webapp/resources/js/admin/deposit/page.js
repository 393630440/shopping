$(function(){
	$("#member_class").addClass("on");
	init(0);
});
function init(pageNo){
	$.ajax({
		url:"/admin/shop/deposit/select",
		data:{"pageNo":pageNo,
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
		var wit = "";
		if(data[a].withdrawalStatus == "0"){
			wit = "提现中";
		}else if(data[a].withdrawalStatus == "1"){
			wit = "提现成功";
		}else if(data[a].withdrawalStatus == "2"){
			wit = "提现失败";
		}
		var hml = "<tr><td>"+(a+1)+"</td>" +
				"<td>"+data[a].memberId+"</td>" +
				"<td>"+data[a].memberName+"</td>" +
				"<td>"+data[a].withdrawalAmount+"</td>" +
				"<td>"+wit+"</td>" +
				"<td>"+(data[a].createtime==undefined?"":(new Date(data[a].createtime).format("yyyy-MM-dd hh:mm:ss")))+"</td>" +
				"<td>"+(data[a].remark||"")+"</td>" +
				"<td>"+(data[a].auditTime==undefined?"":(new Date(data[a].auditTime).format("yyyy-MM-dd hh:mm:ss")))+"</td>" +
				"<td><div class='am-btn-toolbar'>" +
					"<div class='am-btn-group am-btn-group-xs'>" +
						"<button class='am-btn am-btn-default am-btn-xs am-text-danger am-round'>确认</button>" +
						"<button class='am-btn am-btn-default am-btn-xs am-text-danger am-round'>取消</button>" +
					"</div>" +
				"</div></td>" +
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









