$(function() {
	init(0);
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
		var html = "<tr><td><input type='checkbox' value='" + date[a].classifyId + "' /></td>";
		html += "<td>" + date[a].classifyName + "</td>";
		html += "<td>" + date[a].descr + "</td>";
		html += "<td>" + (date[a].pubdate == undefined ? "" : (new Date(date[a].pubdate).format("yyyy-MM-dd hh:mm:ss"))) + "</td>";
		html += "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>";
		// html += "<a class='am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file' data-am-modal='{target: \"#my-popups\"}' title='添加子栏目'></a>";
		html += "<button onclick=\"editpage('" + date[a].classifyId + "')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'><span class='am-icon-pencil-square-o'></span></button>";
		html += "</div></div></td></tr>";
		$("#innerHml").append(html);
	}
}

// 编辑
function editpage(goodsId) {
	window.location.href = "/admin/shop/goodsclassify/editpage";
}

var sdas = "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-success am-round'>"
		+ "<span class='am-icon-search'></span></button>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-secondary am-round'>"
		+ "<span class='am-icon-pencil-square-o'></span></button>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-warning  am-round'>"
		+ "<span class='am-icon-copy'></span></button>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-round'>"
		+ "<span class='am-icon-trash-o'></span></button></div></div></td>";
