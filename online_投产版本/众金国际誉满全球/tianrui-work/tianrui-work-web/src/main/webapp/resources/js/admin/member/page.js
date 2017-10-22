$(function(){
	$("#member_class").addClass("on");
	init(0);
});
function init(pageNo){
	$.ajax({
		url:"/admin/shop/member/select",
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
		var ststus = "";
		var upt = "";
		if(data[a].rpTradeMark == "1"){//primary
			ststus = "<i class='am-icon-check am-text-warning'></i>";
			upt = "<span class='am-icon-trash-o'>关闭</span>";
		}
		if(data[a].rpTradeMark == "0"){//warning
			ststus = "<i class='am-icon-close am-text-primary'></i>";
			upt = "<span class='am-icon-copy'>开启</span>";
		}
		var hml = "<tr><td>"+(a+1)+"</td>" +
				"<td>"+data[a].wechat+"</td>" +
				"<td class='am-hide-sm-only'>"+ststus+"</td>" +
				"<td>"+data[a].wechatName+"</td>" +
				"<td>"+data[a].memberName+"</td>" +
				"<td>"+data[a].cellphone+"</td>" +
				"<td>"+data[a].birthTime+"</td>" +
				"<td>"+data[a].city+"</td>" +
				"<td>"+data[a].balance+"</td>" +
				"<td>"+data[a].redPacket+"</td>" +
				"<td>"+(data[a].createtime==undefined?"":(new Date(data[a].createtime).format("yyyy-MM-dd hh:mm:ss")))+"</td>" +
//				"<td><div class='am-btn-toolbar'>" +
//					"<div class='am-btn-group am-btn-group-xs'>" +
//						"<button onclick=\"uptUser('"+data[a].id+"','"+pageNo+"')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'>"+
//						upt+
//						"</button>" +
//					"</div>" +
//				"</div></td>" +
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









