$(function() {

});

function send(orderStatus) {
	var name = $("#wuliu_type").val();
	var numb = $("#wuliu_numb").val();
	if(name==""){
		alert("物流类别不能为空");
		return;
	}
	if(numb == ""){
		alert("快递编号不能为空");
	}
	$.ajax({
		url : "/admin/shop/order/send",
		type : "POST",
		data : {
			"orderId" : orderId,
			"orderStatus" : orderStatus,
			"wuliuName":name,
			"wuliuNumb":numb
		},
		success : function(ret) {
			if (ret.code == "000000") {
				alert("发货成功");
				window.location.href = "/admin/shop/order/waitsendlist";
			}
		}
	});
}
