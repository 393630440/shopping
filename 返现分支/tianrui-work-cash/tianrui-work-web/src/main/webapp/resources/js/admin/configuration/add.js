$(function() {

});

function add(buttonType) {
	var msg = "";
	var paramkey = $("#paramkey").val(); // 参数键
	if (paramkey == "")
		msg += "参数键不能为空\n";

	var paramvalue = $("#paramvalue").val(); // 参数值
	if (paramvalue == "")
		msg += "参数值不能为空\n";

	var depict = $("#depict").val(); // 配置描述
	if (depict == "")
		msg += "配置描述不能为空\n";

	if (msg != "") {
		alert(msg);
		return;
	}

	$.ajax({
		url : "/admin/shop/configuration/add",
		type : "POST",
		data : {
			"depict" : depict,
			"paramvalue" : paramvalue,
			"paramkey" : paramkey
		},
		success : function(ret) {
			if (ret.code == "000000") {
				if (buttonType == 2) {
					window.location.href = "/admin/shop/configuration/addpage";
				} else {
					window.location.href = "/admin/shop/configuration/index";
				}
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
