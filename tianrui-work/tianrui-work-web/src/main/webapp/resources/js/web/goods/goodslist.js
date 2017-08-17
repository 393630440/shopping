$(function() {

});

var pageNo = 0;
var pageSize = 2;

function query() {
	var goodsName = $("#goodsName").val();
	if (goodsName == "" || goodsName == null || goodsName == undefined) {

	} else {
		pageNo = 0;
		$.ajax({
			url : "/wechat/shop/goods/toloadgoodslist",
			type : "POST",
			data : {
				"pageNo" : pageNo,
				"pageSize" : pageSize,
				"goodsName" : goodsName
			},
			success : function(ret) {
				if (ret.code == "000000") {
					$("#goodsList_showId").empty();
					innerHTML(ret.data);
				}
			}
		});
	}
}

function toLoad() {
	var goodsName = $("#goodsName").val();

	pageNo++;
	$.ajax({
		url : "/wechat/shop/goods/toloadgoodslist",
		type : "POST",
		data : {
			"pageNo" : pageNo,
			"pageSize" : pageSize,
			"classifyId" : classifyId,
			"goodsType" : goodsType,
			"sifting" : sifting,
			"goodsName" : goodsName
		},
		success : function(ret) {
			if (ret.code == "000000") {
				innerHTML(ret.data);
			}
		}
	});
}

function innerHTML(data) {
	if (data != null) {
		for (var a = 0; a < data.length; a++) {
			var html = "";
			html += "<li>";
			html += "<div class=\"ssjg-tu\">";
			html += "<a href=\"/wechat/shop/goods/goodsdetails?goodsId=" + data[a].goodsId + "\">";
			html += "<img src=\"/getimg?imgPath=goodsInfo/" + data[a].goodsId + "/" + data[a].firstGoodsImg + "\">";
			html += "</a>";
			html += "</div>";
			html += "<h3>";
			html += "<a href=\"/wechat/shop/goods/goodsdetails?goodsId=" + data[a].goodsId + "\">" + data[a].goodsName + "</a>";
			html += "</h3>";
			html += "<dl class=\"ssjg-dl1\">";
			html += "<dt class=\"ssjg-p1\">";
			html += "<span>" + data[a].price + "</span>";
			html += "</dt>";
			html += "<dd>";
			html += "<a href=\"javascript:void(0);\" onclick=\"addGoods('" + data[a].goodsId + "')\">";
			html += "<img src=\"/resources/shop/images/sjsc-09.gif\">";
			html += "</a>";
			html += "</dd>";
			html += "</dl>";
			html += "</li>";
			$("#goodsList_showId").append(html);
		}
	}
}

function addGoods(goodsId) {
	$.ajax({
		url : "/wechat/shop/goods/addgoods",
		type : "POST",
		data : {
			"goodsId" : goodsId,
			"goodsNum" : 1
		},
		success : function(ret) {
			if (ret.code == "000000") {
				alert("已添加到购物车");
			}
		}
	});
}
