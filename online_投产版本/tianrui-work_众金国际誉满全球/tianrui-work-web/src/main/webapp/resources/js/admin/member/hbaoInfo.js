$(function(){
	$("#member_class").addClass("on");
	init(0);
});
function init(pageNo){
	$.ajax({
		url:"/admin/shop/member/find",
		data:{"pageNo":pageNo,
			"wechatName":$("#wechatName").val(),
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
				"<td>"+data[a].memberId+"</td>" +
				"<td>"+data[a].wechatName+"</td>" +
				"<td>"+data[a].sourceDescribe+"</td>" +
				"<td>"+data[a].rpNum+"</td>" +
				"<td>"+(data[a].createtime==undefined?"":(new Date(data[a].createtime).format("yyyy-MM-dd hh:mm:ss")))+"</td>" +
				"</tr>";
		$("#innerHml").append(hml);
	}
}



