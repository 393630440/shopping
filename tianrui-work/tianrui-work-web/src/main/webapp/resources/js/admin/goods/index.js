$(function() {
	init(0);
});

function init(pageNo) {
	$.ajax({
		url : "/admin/shop/goods/querylist",
		type : "POST",
		data : {
			"pageNo" : pageNo,
			"classifyId" : $("#classifyId").val(),
			"goodsName" : $("#goodsName").val(),
			"goodsStatus" : $("#goodsStatus").val(),
			"goodsType" : $("#goodsType").val(),
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

function innerHTML(data, pageNo) {
	$("#innerHml").empty();
	for (var a = 0; a < data.length; a++) {
		// 商品状态
		var goodsStatus = data[a].goodsStatus == "1" ? "已上架" : "已下架";
		// 商品类型
		var goodsType = data[a].goodsType == "1" ? "大众商品" : "宏包商品";
		// 发布时间
		var pubdate = "";
		if (data[a].pubdate != undefined)
			pubdate = new Date(data[a].pubdate).format("yyyy-MM-dd hh:mm:ss");

		var html = "<tr><td>" + (a + 1) + "</td>";
		html += "<td>" + data[a].classifyName + "</td>";
		html += "<td>" + data[a].goodsName + "</td>";
		html += "<td>" + goodsStatus + "</td>";
		html += "<td>" + goodsType + "</td>";
		html += "<td>" + data[a].goodsPrice + "</td>";
		html += "<td>" + data[a].redPacket + "</td>";
		html += "<td>" + pubdate + "</td>";
		html += "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>";
		if (data[a].goodsStatus == "1") {
			html += "<button onclick=\"editpage('";
			html += data[a].goodsId;
			html += "')\" class='am-btn am-btn-default am-btn-xs am-text-danger am-round'><span class='am-icon-pencil-square-o'></span>编辑</button>";
		}
		html += "<button onclick=\"edit('";
		html += data[a].goodsId + "','" + data[a].goodsStatus;
		html += "')\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\"><span class=\"am-icon-save\"></span>";
		html += data[a].goodsStatus == "1" ? "下架" : "上架";
		html += "</button></div></div></td></tr>";
		$("#innerHml").append(html);
	}
}

function editpage(goodsId) {
	window.location.href = "/admin/shop/goods/editpage?goodsId=" + goodsId;
}

function edit(goodsId, goodsStatus) {
	// 上架商品做下架，下架商品做上架
	var goodsStatusReq = goodsStatus == "2" ? "1" : "2";
	$.ajax({
		url : "/admin/shop/goods/edit",
		type : "POST",
		data : {
			"goodsId" : goodsId,
			"goodsStatus" : goodsStatusReq
		},
		success : function(ret) {
			if (ret.code == "000000") {
				init(0);
			}
		}
	});
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
