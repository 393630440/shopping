$(function() {
	init(0);
});

function init(pageNo) {
	$.ajax({
		url : "/admin/shop/order/queryrefundlist",
		type : "POST",
		data : {
			"pageNo" : pageNo,
			"pageSize" : 10,
			"orderCode" : $("#orderCode").val(),
			"goodsType" : $("#goodsType").val()
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
		// 创建时间
		var ct = "";
		if (data[a].creationTime != undefined)
			ct = new Date(data[a].creationTime).format("yyyy-MM-dd hh:mm:ss");

		var html = "<tr><td>" + (a + 1) + "</td>";
		html += "<td>" + data[a].orderCode + "</td>";
		html += "<td>" + goodsTypeMap[data[a].goodsType] + "</td>";
		html += "<td>" + data[a].goodsNum + "</td>";
		html += "<td>" + data[a].goodsSubtotal + "</td>";
		html += "<td>" + data[a].expressFee + "</td>";
		html += "<td>" + data[a].orderAmount + "</td>";
		html += "<td>" + data[a].orderRedPacket + "</td>";
		html += "<td>" + data[a].city + "</td>";
		html += "<td>" + ct + "</td>";
		html += "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>";
		html += "<button onclick=\"auditpage('" + data[a].orderId + "')\"";
		html += " class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\"><span class=\"am-icon-save\"></span>审核";
		html += "</button></div></div></td></tr>";
		$("#innerHml").append(html);
	}
}

function auditpage(orderId) {
	window.location.href = "/admin/shop/order/auditpage?orderId=" + orderId;
}

var goodsTypeMap = {
	"1" : "大众商品",
	"2" : "宏包商品"
};
