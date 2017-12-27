$(function() {
	$("#save").hide();
	// 编辑
	$("#edit").click(function(event) {
		$(".gwc-p2").hide();
		$(".bl_view_tag").show();
		$(".gwc-del").show();
		$("#edit").hide();
		$("#save").show();

		$('input:checkbox').each(function() {
			$(this).attr('checked', false);
			$(this).hide();
		});
		$("#size_total").hide();
	});

	// 完成
	$("#save").click(function(event) {
		goodsNumShow();
		$(".gwc-p2").show();
		$(".bl_view_tag").hide();
		$(".gwc-del").hide();
		$("#edit").show();
		$("#save").hide();

		$('input:checkbox').each(function() {
			$(this).show();
		});

		if (delShoppingCartIds != "") {
			delGoods();
			delShoppingCartIds = "";
		}
	});

});

function goodsNumShow() {
	for (var a = 0; a < shoppingCartIdList.length; a++) {
		var shoppingCartId = shoppingCartIdList[a];

		var goodsNum = $("#goodsNum_hide_" + shoppingCartId).val() * 1;
		var newGoodsNum = $("#goodsNum_" + shoppingCartId).val() * 1;

		if (goodsNum == newGoodsNum)
			continue;

		var goodsNumShowStr = "数量：" + newGoodsNum;
		var goodsNum_showId = "#goodsNum_showId_" + shoppingCartId;
		var subtotalShowStr = "小计：";
		var subtotal_showId = "#subtotal_showId_" + shoppingCartId;

		var goodsPrice = $("#goodsPrice_hide_" + shoppingCartId).val() * 1;
		var goodsRedPacket = $("#goodsRedPacket_hide_" + shoppingCartId).val() * 1;
		var goodsType1 = $("#goodsType_hide_" + shoppingCartId).val();
		if (goodsType1 == "1")
			subtotalShowStr += (goodsPrice * newGoodsNum).toFixed(2);
		else if (goodsType1 == "2")
			subtotalShowStr += (goodsPrice * newGoodsNum).toFixed(2) + " + " + (goodsRedPacket * newGoodsNum) + "积分";
		else
			continue;

		$(goodsNum_showId).empty();
		$(goodsNum_showId).append(goodsNumShowStr);
		$(subtotal_showId).empty();
		$(subtotal_showId).append(subtotalShowStr);
	}

	// var sizeTotalStr = "共" + size + "件商品，总计：<span>￥" + price + " + " + redPacket + "积分</span>";
	// $("#size_total").empty();
	// $("#size_total").append(sizeTotalStr);
}

function check() {
	var size = 0;
	var total = "";
	var price = 0;
	var redPacket = 0;
	$('input[name="shoppingCartId"]:checked').each(function() {
		var shoppingCartId = $(this).val();
		var newGoodsNum = $("#goodsNum_" + shoppingCartId).val() * 1;
		var goodsPrice = $("#goodsPrice_hide_" + shoppingCartId).val() * 1;
		var goodsRedPacket = $("#goodsRedPacket_hide_" + shoppingCartId).val() * 1;

		size += newGoodsNum;
		price += goodsPrice * newGoodsNum;
		if (goodsType == "2")
			redPacket += goodsRedPacket * newGoodsNum;
	});

	if (size > 0) {
		$("#size_total").show();
		var sizeTotalStr = "共选 " + size + " 件商品，总计：<span>￥" + price.toFixed(2);
		if (goodsType == "2")
			sizeTotalStr += " + " + redPacket + "积分</span>";
		$("#size_total").empty();
		$("#size_total").append(sizeTotalStr);
	} else {
		$("#size_total").hide();
	}
}

function placeOrder() {
	var shoppingCartInfo = "";
	$('input[name="shoppingCartId"]:checked').each(function() {
		if (shoppingCartInfo != "")
			shoppingCartInfo += ",";

		var shoppingCartId = $(this).val();
		var newGoodsNum = $("#goodsNum_" + shoppingCartId).val();

		shoppingCartInfo += "{\"shoppingCartId\":\"" + shoppingCartId + "\",\"newGoodsNum\":" + newGoodsNum + "}";
	});

	if (shoppingCartInfo == "") {
		alert("请先选择商品，在进行下单。");
		return;
	}

	shoppingCartInfo = "[" + shoppingCartInfo + "]";
	$.ajax({
		url : "/wechat/shop/shoppingcart/placeorder",
		type : "POST",
		data : {
			"shoppingCartInfo" : shoppingCartInfo,
			"goodsType" : goodsType
		},
		success : function(ret) {
			if (ret.code == "000000") {
				window.location.href = "/wechat/shop/shoppingcart/unpaidorderpage?addressId=0&orderId=" + ret.data;
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

var delShoppingCartIds = "";

function del(shoppingCartId) {
	$("#goodsInfo_" + shoppingCartId).hide();

	if (delShoppingCartIds != "")
		delShoppingCartIds += ",";
	delShoppingCartIds += shoppingCartId;
}

function delGoods() {
	$.ajax({
		url : "/wechat/shop/shoppingcart/delgoods",
		type : "POST",
		data : {
			"shoppingCartIds" : delShoppingCartIds
		},
		success : function(ret) {
			if (ret.code == "000000") {
				if (goodsType == "1")
					window.location.href = "/wechat/shop/shoppingcart/ordinarylist";
				else if (goodsType == "2")
					window.location.href = "/wechat/shop/shoppingcart/redpacketlist";
				else
					window.location.href = "/wechat/shop/shoppingcart/shoppingcartlist";
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
