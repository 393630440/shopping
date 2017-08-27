$(function() {

});

function selectAddress(id) {
	window.location.href = "/wechat/shop/shoppingcart/selectaddress?addressId=" + id + "&orderId=" + orderId;
}

function pay() {
	if (addressId == "0") {
		alert("请选择发货地址");
		return;
	}

	var buyerWord = $("#buyerWord").val();
	if (addressId == "-1" && buyerWord == "") {
		window.location.href = "/wechat/shop/pay/billPay?id=" + orderId;
	} else {
		$.ajax({
			url : "/wechat/shop/shoppingcart/edit",
			type : "POST",
			data : {
				"orderId" : orderId,
				"addressId" : addressId,
				"buyerWord" : buyerWord
			},
			success : function(ret) {
				if (ret.code == "000000") {
					window.location.href = "/wechat/shop/pay/billPay?id=" + orderId;
				}
			},
			error : function(data, status, e) {
				alert(e);
			}
		});
	}
}
