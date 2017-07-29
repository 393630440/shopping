$(function(){
	$("#creditor_class").addClass("on")
	init(0);
});
function init(pageNo){
	var idCard = $("#creditIdCard").val();
	var creditStatus = $("#creditStatus").val();
	$.ajax({
		url:"/admin/shop/creditor/select",
		data:{"pageNo":pageNo,
			"creditorStatus":creditStatus,
			"creditorIdcard":idCard,
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
		var creType = "";
		if(date[a].creditorType=="1"){
			creType = "债权信息";
		}else{
			creType = "债务信息";
		}
		var sex = "";
		if(date[a].creditorSex=="xx"){
			sex = "女";
		}
		if(date[a].creditorSex=="xy"){
			sex = "男";
		}
		var debtType = "";
		if(date[a].debtType == "1"){
			debtType = "公司债务";
		}
		if(date[a].debtType == "2"){
			debtType = "借条债务";
		}
		if(date[a].debtType == "3"){
			debtType = "欠条债务";
		}
		if(date[a].debtType == "4"){
			debtType = "判决债务";
		}
		if(date[a].debtType == "5"){
			debtType = "其他债务";
		}
		var ststus = "";
		var uptsta = "";
		if(date[a].creditorStatus == "1"){//primary
			ststus = "<i class='am-icon-check am-text-warning'></i>";
			uptsta = "<span class='am-icon-trash-o'></span>";
		}
		if(date[a].creditorStatus == "0"){//warning
			ststus = "<i class='am-icon-close am-text-primary'></i>";
			uptsta = "<span class='am-icon-copy'></span>";
		}
		var hml = "<tr><td><input type='checkbox' /></td>" +
				"<td>"+(a+1)+"</td>" +
				"<td>"+creType+"</td>" +
				"<td class='am-hide-sm-only'>"+ststus+"</td>" +
				"<td>"+date[a].creditorName+"</td>" +
				"<td>"+sex+"</td>" +
				"<td>"+date[a].creditorPhone+"</td>" +
				"<td>"+date[a].creditorIdcard+"</td>" +
				"<td>"+date[a].debtorCompany+"</td>" +
				"<td>"+date[a].debtorCompanyAddress+"</td>" +
				"<td>"+(date[a].debtAmount||"")+"</td>" +
				"<td>"+debtType+"</td>" +
				"<td>"+(date[a].debtTime==undefined?"":(new Date(date[a].debtTime).format("yyyy-MM-dd")))+"</td>" +
				"<td>"+(new Date(date[a].creatorTime).format("yyyy-MM-dd hh:mm:ss")||"")+"</td>" +
				"<td><div class='am-btn-toolbar'>" +
					"<div class='am-btn-group am-btn-group-xs'>" +
						"<button onclick=\"uptCreator('"+date[a].id+"','"+pageNo+"')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'>" +
						uptsta +
						"</button>" +
					"</div>" +
				"</div></td></tr>";
		$("#innerHml").append(hml);
	}
}
//禁用数据
function uptCreator(id,pageNo){
	$.ajax({
		url:"/admin/shop/creditor/upt",
		data:{"id":id},
		type:"POST",
		success:function(ret){
			if(ret.code == "000000"){
				init(pageNo);
			}
		}
	});
}

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









