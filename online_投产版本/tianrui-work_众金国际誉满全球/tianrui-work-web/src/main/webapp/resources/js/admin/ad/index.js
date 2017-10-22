$(function() {
	init(0);
	$("#skip_add_page").on("click", function() {
		window.location.href = "/admin/shop/ad/addpage";
	});
});

function init(pageNo) {
	$.ajax({
		url : "/admin/shop/ad/querylist",
		type : "POST",
		data : {
			"pageNo" : pageNo,
			"pageSize" : 10,
			"depict" : $("#depict").val(),
			"status" : $("#status").val(),
			"type" : $("#type").val()
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
		// 广告状态
		var status = data[a].status == "1" ? "有效" : "失效";
		// 商品类型
		var type = data[a].type == "1" ? "大众商品" : "宏包商品";
		// 发布时间
		var pubdate = "";
		if (data[a].pubdate != undefined)
			pubdate = new Date(data[a].pubdate).format("yyyy-MM-dd hh:mm:ss");

		var html = "<tr><td>" + (a + 1) + "</td>";
		html += "<td>" + data[a].depict + "</td>";
		html += "<td>" + status + "</td>";
		html += "<td>" + type + "</td>";
		html += "<td><img src=\"/resources/file/adInfo/" + data[a].img;
		html += "\" style=\"height: 45px; width: 50px;\"/></td>";
		html += "<td>" + pubdate + "</td>";
		html += "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>";
		if (data[a].status == "1") {
			html += "<button onclick=\"editpage('";
			html += data[a].id;
			html += "')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'><span class='am-icon-pencil-square-o'></span>编辑</button>";
		}
		html += "<button onclick=\"edit('";
		html += data[a].id + "','" + data[a].status;
		html += "')\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\"><span class=\"am-icon-save\"></span>";
		html += data[a].status == "1" ? "失效" : "有效";
		html += "</button></div></div></td></tr>";
		$("#innerHml").append(html);
	}
}

function editpage(id) {
	window.location.href = "/admin/shop/ad/editpage?id=" + id;
}

function edit(id, status) {
	// 上架商品做下架，下架商品做上架
	var statusReq = status == "0" ? "1" : "0";
	$.ajax({
		url : "/admin/shop/ad/edit",
		type : "POST",
		data : {
			"id" : id,
			"status" : statusReq
		},
		success : function(ret) {
			if (ret.code == "000000") {
				init(0);
			}
		}
	});
}
