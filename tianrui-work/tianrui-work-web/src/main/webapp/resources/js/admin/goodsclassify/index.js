$(function() {
	init(0);
	$("#skip_add_page").on("click", function() {
		window.location.href = "/admin/shop/goodsclassify/addpage";
	});
});

function init(pageNo) {
	$.ajax({
		url : "/admin/shop/goodsclassify/querylist",
		type : "POST",
		data : {
			"pageNo" : pageNo,
			"classifyName" : $("#classifyName").val(),
			"pageSize" : 10
		},
		success : function(ret) {
			if (ret.code == "000000") {
				innerHTML(ret.data.list, pageNo);
				pageTool(ret.data.total, pageNo, 10);
			}
		}
	});
}

// 数据显示
function innerHTML(date, pageNo) {
	$("#innerHml").empty();
	for (var a = 0; a < date.length; a++) {
		var pubdate = "";
		if (date[a].pubdate != undefined)
			pubdate = new Date(date[a].pubdate).format("yyyy-MM-dd hh:mm:ss");

		var html = "<tr>";
		html += "<td>" + (a + 1) + "</td>";
		html += "<td>" + date[a].classifyName + "</td>";
		html += "<td>" + date[a].descr + "</td>";
		html += "<td>" + pubdate + "</td>";
		html += "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>";
		html += "<button onclick=\"editpage('" + date[a].classifyId;
		html += "')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'><span class='am-icon-pencil-square-o'></span></button>";
		html += "</div></div></td>";
		html += "</tr>";
		$("#innerHml").append(html);
	}
}

// 编辑
function editpage(classifyId) {
	window.location.href = "/admin/shop/goodsclassify/editpage?classifyId=" + classifyId;
}
