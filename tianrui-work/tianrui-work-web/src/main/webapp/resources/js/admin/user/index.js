$(function(){
	$("#user_class").addClass("on");
	init(0);
});
function init(pageNo){
	$.ajax({
		url:"/admin/shop/user/select",
		data:{"pageNo":pageNo,
			"acount":$("#acount").val(),
			"acountStatus":$("#acountStatus").val(),
			"telphone":$("#telphone").val(),
			"username":$("#username").val(),
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
function innerHTML(date,pageNo){
	$("#innerHml").empty();
	for (var a = 0; a < date.length; a++) {
		var ststus = "";
		var upt = "";
		if(date[a].acountStatus == "1"){//primary
			ststus = "<i class='am-icon-check am-text-warning'></i>";
			upt = "<span class='am-icon-trash-o'>禁用</span>";
		}
		if(date[a].acountStatus == "0"){//warning
			ststus = "<i class='am-icon-close am-text-primary'></i>";
			upt = "<span class='am-icon-copy'>启用</span>";
		}
		var hml = "<tr><td>"+(a+1)+"</td>" +
				"<td>"+date[a].userRole+"</td>" +
				"<td class='am-hide-sm-only'>"+ststus+"</td>" +
				"<td>"+date[a].acount+"</td>" +
				"<td>"+date[a].username+"</td>" +
				"<td>"+date[a].telphone+"</td>" +
				"<td>"+(date[a].logintime==undefined?"":(new Date(date[a].logintime).format("yyyy-MM-dd hh:mm:ss")))+"</td>" +
				"<td>"+date[a].loginNum+"</td>" +
				"<td><div class='am-btn-toolbar'>" +
					"<div class='am-btn-group am-btn-group-xs'>" +
						"<button onclick=\"uptUser('"+date[a].id+"','"+pageNo+"')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'>"+
						upt+
						"</button>" +
					"</div>" +
				"</div></td></tr>";
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









