$(function() {

});

function addGoods() {
	var goodsNum = $("#goodsNum").val();// 商品数量
	if (goodsNum == 0) {
		alert("请选择商品数量");
		return;
	}
	alert(goodsNum);
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
				location.replace(location.href);
			}
		}
	});
}