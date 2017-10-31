$(function() {

	$(".quanbu-title2-zx li").click(function(event) {
		var index1 = $(this).index();
		$(this).addClass('current').siblings().removeClass('current');
		$(".my-dd .my-info").eq(index1).show().siblings().hide();
	});

});