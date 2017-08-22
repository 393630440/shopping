$(function() {

});

function send(orderStatus) {
	$.ajax({
		url : "/admin/shop/order/send",
		type : "POST",
		data : {
			"orderId" : orderId,
			"orderStatus" : orderStatus
		},
		success : function(ret) {
			if (ret.code == "000000") {
				alert("发货成功");
				window.location.href = "/admin/shop/order/waitsendlist";
			}
		}
	});
}
