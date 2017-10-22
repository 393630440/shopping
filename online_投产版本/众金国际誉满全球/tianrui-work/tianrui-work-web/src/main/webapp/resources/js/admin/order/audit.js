$(function() {

});

function audit(orderStatus) {
	$.ajax({
		url : "/admin/shop/order/audit",
		type : "POST",
		data : {
			"orderId" : orderId,
			"orderStatus" : orderStatus
		},
		success : function(ret) {
			if (ret.code == "000000") {
				alert("审核成功");
				window.location.href = "/admin/shop/order/refundlist";
			}
		}
	});
}
