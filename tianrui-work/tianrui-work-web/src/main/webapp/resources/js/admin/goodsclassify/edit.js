$(function() {

});

function edit() {
	var msg = "";

	var classifyName = $("#classifyName").val(); // 分类名称
	if (classifyName == "")
		msg += "分类名称不能为空\n";

	var descr = $("#descr").val(); // 备注说明
	if (descr == "")
		msg += "备注说明不能为空\n";

	if (msg != "") {
		alert(msg);
		return;
	}

	$.ajax({
		url : "/admin/shop/goodsclassify/edit",
		type : "POST",
		data : {
			"classifyId" : classifyId,
			"classifyName" : classifyName,
			"descr" : descr
		},
		success : function(ret) {
			if (ret.code == "000000")
				window.location.href = "/admin/shop/goodsclassify/index";
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
