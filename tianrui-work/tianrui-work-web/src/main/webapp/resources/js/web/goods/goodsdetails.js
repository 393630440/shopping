$(function() {

});

function addGoods(type) {
	var goodsNum = $("#goodsNum").val();// 商品数量
	if (goodsNum == 0) {
		alert("请选择商品数量");
		return;
	}
	if (goodsNum > inventory) {
		alert("库存有限，请重新选择商品数量。");
		return;
	}

	$.ajax({
		url : "/wechat/shop/goods/addgoods",
		type : "POST",
		data : {
			"goodsId" : goodsId,
			"goodsNum" : goodsNum,
		},
		success : function(ret) {
			if (ret.code == "000000") {
				alert("已添加到购物车");
				if(type == 1){
					if(goodsType==1){
						window.location.href="/wechat/shop/shoppingcart/ordinarylist";
					}else if(goodsType==2){
						window.location.href="/wechat/shop/shoppingcart/redpacketlist";
					}
				}
			}
		}
	});
}

function follow() {
	// 0-未关注；1-已关注
	if (tempFlag == "0") {
		$("#follow_i").attr("class", "i-fav-active");
		tempFlag = "1";
	} else if (tempFlag == "1") {
		$("#follow_i").attr("class", "i-fav");
		tempFlag = "0";
	}

	$.ajax({
		url : "/wechat/shop/goods/goodsfollow",
		type : "POST",
		data : {
			"goodsId" : goodsId,
			"FfType" : tempFlag,
		},
		success : function(ret) {
			if (ret.code == "000000") {
			}
		}
	});
}

function buyNow() {
	var goodsNum = $("#goodsNum").val();// 商品数量
	if (goodsNum == 0) {
		goodsNum = 1;
		// alert("请选择商品数量");
		// return;
	}
	if (goodsNum > inventory) {
		alert("库存有限，请重新选择商品数量。");
		return;
	}

	window.location.href = "/wechat/shop/goods/buynow?goodsId=" + goodsId + "&goodsNum=" + goodsNum;
}
