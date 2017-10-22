$(function() {
	init(0);
	$("#skip_add_page").on("click", function() {
		window.location.href = "/admin/shop/configuration/addpage";
	});
});

function init(pageNo) {
	$.ajax({
		url : "/admin/shop/configuration/querylist",
		type : "POST",
		data : {
			"pageNo" : pageNo,
			"pageSize" : 10,
			"depict" : $("#depict").val(),
			"flag" : $("#flag").val()
		},
		success : function(ret) {
			if (ret.code == "000000") {
				innerHTML(ret.data.list, pageNo);
				pageTool(ret.data.total, pageNo, 10);
			}
		}
	});
}

function innerHTML(data, pageNo) {
	$("#innerHml").empty();
	for (var a = 0; a < data.length; a++) {
		// 维护标志
		var flag = data[a].flag == "1" ? "有效" : "失效";

		var html = "<tr><td>" + (a + 1) + "</td>";
		html += "<td>" + data[a].paramkey + "</td>";
		html += "<td>" + data[a].paramvalue + "</td>";
		html += "<td>" + data[a].depict + "</td>";
		html += "<td>" + flag + "</td>";
		html += "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>";
		if (data[a].flag == "1") {
			html += "<button onclick=\"editpage('";
			html += data[a].paramkey;
			html += "')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'><span class='am-icon-pencil-square-o'></span>编辑</button>";
		}
		html += "<button onclick=\"edit('";
		html += data[a].paramkey + "','" + data[a].flag;
		html += "')\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\"><span class=\"am-icon-save\"></span>";
		html += data[a].flag == "1" ? "失效" : "有效";
		html += "</button></div></div></td></tr>";
		$("#innerHml").append(html);
	}
}

function editpage(paramkey) {
	window.location.href = "/admin/shop/configuration/editpage?paramkey=" + paramkey;
}

function edit(paramkey, flag) {
	var flagReq = flag == "0" ? "1" : "0";
	$.ajax({
		url : "/admin/shop/configuration/edit",
		type : "POST",
		data : {
			"paramkey" : paramkey,
			"flag" : flagReq
		},
		success : function(ret) {
			if (ret.code == "000000") {
				init(0);
			}
		}
	});
}
