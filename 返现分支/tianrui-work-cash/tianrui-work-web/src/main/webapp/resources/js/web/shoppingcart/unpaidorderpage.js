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
	var show_balance = $("#show_balance").val();
	var hidden_balance = $("#hidden_balance").val();
	if(Number(show_balance)>Number(hidden_balance)){
		alert("账户余额不足");
		return;
	}
	var show_cashMoney = $("#show_cashMoney").val();
	var hidden_cashMoney = $("#hidden_cashMoney").val();
	if(Number(show_cashMoney)>Number(hidden_cashMoney)){
		alert("返现余额不足");
		return;
	}
	var show_redPacket = $("#show_redPacket").val();
	var hidden_redPacket = $("#hidden_redPacket").val();
	if(Number(show_redPacket)>Number(hidden_redPacket)){
		alert("用户积分不足");
		return;
	}
	var buyerWord = $("#buyerWord").val();
	var uuul = "/wechat/shop/pay/billPay?id="+orderId+"&cashMoney="+show_cashMoney+"&redPacket="+show_redPacket+"&balance="+show_balance;
	if (addressId == "-1" && buyerWord == "") {
		window.location.href = uuul;
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
					window.location.href = uuul;
				}
			},
			error : function(data, status, e) {
				alert(e);
			}
		});
	}
}
//收货确认
function signBill(id){
	$.ajax({
		url:"/wechat/shop/shoppingcart/signBill",
		type:"POST",
		data:{"id":id},
		success:function(ret){
			if(ret.code==000000){
				alert("确认收货成功");
				$(".sign_bill").hide();
			}else{
				alert(ret.error);
			}
		}
	});
}
