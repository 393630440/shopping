$(function() {

});

function select() {
	var addressId = $('input:radio[name="addressId"]:checked').val();
	window.location.href = "/wechat/shop/shoppingcart/unpaidorderpage?addressId=" + addressId + "&orderId=" + orderId;
}
