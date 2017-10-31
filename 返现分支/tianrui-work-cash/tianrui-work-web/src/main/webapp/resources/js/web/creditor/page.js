$(function(){
	init(0);
});
function init(pageNo){
	$.ajax({
		url:"/wechat/shop/creditor/select",
		data:{"pageNo":pageNo,
			"pageSize":10},
		type:"POST",
		success:function(ret){
			if(ret.code=="000000"){
				innerHTML(ret.data.list);
			}
		}
	});
}
function innerHTML(date){
	$("#innerHml").empty();
	for (var a = 0; a < date.length; a++) {
		var creType = "";
		if(date[a].creditorType=="1"){
			creType = "债权人-"+date[a].creditorName;
		}else{
			creType = "债务人-"+date[a].creditorName;
		}
		var hml = "<li><div class='hwc-tu f-l'><img src='"+date[a].creatorImg+"'></div>"+
		       "<div class='gwc-md f-l'><h3>"+creType+"</h3>"+
		       "<p class='gwc-p1'>债务金额：<span>￥"+date[a].debtAmount+"</span></p>"+
		       "<p class='gwc-p2'>活动公告：活动期间赠送商品总额5%的资金。</p>"+
		       "</div><div style='clear:both;'></div></li>";
		$("#innerHml").append(hml);
	}
}