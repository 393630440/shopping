$(function() {

});

// 根据商品类型判断是否显示宏包数量的页面显示
function goodsType(type) {
	if (type == 1) { // 1-大众商品,不显示宏包
		$("#redPacket_div").hide();
		$("#redPacket").val("");
	} else if (type == 2) { // 2-宏包商品,显示宏包
		$("#redPacket_div").show();
		$("#redPacket").val("");
	}
}

// 图片元素ID的集合
var imgIdList = [];
var imgIdMap = {};
// 图片元素ID的数量，用于区分多张图片时的
var imgIdNum = 0;

// 图片显示
function imgShow(ele, flag) {
	if (ele.value != "") {
		// 校验图片的格式
		if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ele.value)) {
			alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
			ele.value = "";
			return;
		}

		// 显示图片用的DIV的id
		var showId = "";
		if (flag == 1) {
			showId = "goodsImg_showId";
		} else if (flag == 2) {
			showId = "goodsDetails_showId";
		} else {
			ele.value = "";
			return;
		}

		// 图片元素的id，并且把id存放到集合中
		imgIdNum++;
		var imgId = showId + "_" + imgIdNum;
		imgIdList[imgIdList.length] = imgId;
		imgIdMap[imgId] = ele.value;

		// 添加显示图片的元素
		var html = "<span id=\"showId_" + imgId + "\">";
		html += "<img src=\"\" id=\"" + imgId + "\" style=\"height: 45px; width: 50px;\"/>";
		html += "<button type=\"button\" onclick=\"imgDelete('" + imgId + "');\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
		html += "<span class=\"am-icon-trash-o\"></span></button></span>";
		$("#" + showId).append(html);

		// 图片预览显示
		previewPicture(ele, imgId);
		ele.value = "";
	}
}

// 预览图片显示
function previewPicture(file, i) {
	if (file.files && file.files[0]) {
		var img = document.getElementById(i);
		var reader = new FileReader();
		reader.onload = function(evt) {
			img.src = evt.target.result;
		}
		reader.readAsDataURL(file.files[0]);
	}
}

// 删除图片信息
function imgDelete(imgId) {
	for (var i = 0; i < imgIdList.length; i++) {
		if (imgIdList[i] == imgId) {
			imgIdList.splice(i, 1);
			$("#showId_" + imgId).remove();
			break;
		}
	}
}

// 添加会员信息
function add(flag) {
	var msg = "";
	var goodsName = $("#goodsName").val(); // 商品名称
	if (goodsName == "") {
		msg += "商品名称不能为空\n";
	}

	// var classifyId = $("#classifyId").val(); // 分类ID
	// if (classifyId == "") { msg += "分类ID不能为空\n"; }

	var classifyName = $("#classifyName").val(); // 分类名称
	if (classifyName == "") {
		msg += "分类名称不能为空\n";
	}

	var goodsType = $('input:radio[name="goodsType"]:checked').val(); // 商品类型:1-大众商品;2-宏包商品
	if (goodsType == "" || goodsType == undefined) {
		msg += "商品类型不能为空\n";
	}

	var goodsPrice = $("#goodsPrice").val(); // 商品价格
	if (goodsPrice == "") {
		msg += "商品价格不能为空\n";
	}

	var redPacket = goodsType == "" || goodsType == undefined ? "" : goodsType == "1" ? "0" : $(
			"#redPacket").val(); // 商品宏包
	if (redPacket == "") {
		msg += "商品宏包不能为空\n";
	}

	var goodsImg = ""; // 商品图片
	var goodsDetails = ""; // 商品详情
	if (imgIdList.length > 0) {
		for (var i = 0; i < imgIdList.length; i++) {
			var imgId = imgIdList[i];
			if (imgId.indexOf("goodsImg_showId") == 0) {
				goodsImg += imgIdMap[imgId] + "|";
			} else if (imgId.indexOf("goodsDetails_showId") == 0) {
				goodsDetails += imgIdMap[imgId] + "|";
			} else {
				// window.location.href = "/admin/shop/goods/addpage";
				return;
			}
		}
	}
	if (goodsImg == "") {
		msg += "商品图片不能为空\n";
	}
	if (goodsDetails == "") {
		msg += "商品详情不能为空\n";
	}

	var goodsParam = $("#goodsParam").val(); // 商品参数
	if (goodsParam == "") {
		msg += "商品参数不能为空\n";
	}

	var expressFee = $("#expressFee").val(); // 快递费
	if (expressFee == "") {
		msg += "快递费不能为空\n";
	}

	var inventory = $("#inventory").val(); // 库存
	if (inventory == "") {
		msg += "库存不能为空\n";
	}

	var sifting = $('input:radio[name="sifting"]:checked').val(); // 默认值=0,筛选条件:0-普通商品;1-推荐商品;2-新品上市;3-热卖商品;4-促销商品;5-卖家包邮;6-限时抢购
	if (sifting == "") {
		msg += "筛选条件不能为空\n";
	}

	if (msg != "") {
		alert(msg);
		return;
	}

	$.ajax({
		url : "/admin/shop/goods/add",
		type : "POST",
		data : {
			"salesvolume" : "0",
			"buyNum" : "0",
			"browseNum" : "0",
			"goodsStatus" : "1",
			"goodsName" : goodsName,
			// "classifyId" : classifyId,
			"classifyName" : classifyName,
			"goodsType" : goodsType,
			"goodsPrice" : goodsPrice,
			"redPacket" : redPacket,
			"goodsImg" : goodsImg,
			"goodsDetails" : goodsDetails,
			"goodsParam" : goodsParam,
			"expressFee" : expressFee,
			"inventory" : inventory,
			"sifting" : sifting
		},
		success : function(ret) {
			if (ret.code == "000000") {
				if (flag == 2) {
					window.location.href = "/admin/shop/goods/addpage";
				} else {
					window.location.href = "/admin/shop/goods/index";
				}
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});

	// $.ajaxFileUpload({
	// type : "POST",
	// url : "/admin/shop/goods/add",
	// secureuri : false, // 是否需要安全协议，一般设置为false
	// fileElementId : imgIdList, // 文件上传域的ID
	// data : {
	// "salesvolume" : "0",
	// "buyNum" : "0",
	// "browseNum" : "0",
	// "goodsStatus" : "1",
	// "goodsName" : goodsName,
	// // "classifyId" : classifyId,
	// "classifyName" : classifyName,
	// "goodsType" : goodsType,
	// "goodsPrice" : goodsPrice,
	// "redPacket" : redPacket,
	// "goodsImg" : goodsImg,
	// "goodsDetails" : goodsDetails,
	// "goodsParam" : goodsParam,
	// "expressFee" : expressFee,
	// "inventory" : inventory,
	// "sifting" : sifting
	// },
	// success : function(ret) {
	// if (ret.code == "000000") {
	// if (flag == 2) {
	// window.location.href = "/admin/shop/goods/addpage";
	// } else {
	// window.location.href = "/admin/shop/goods/index";
	// }
	// }
	// },
	// error : function(data, status, e) {
	// alert(e);
	// }
	// });
}

var sdas = "<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-success am-round'><span class='am-icon-search'></span></button>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-secondary am-round'><span class='am-icon-pencil-square-o'></span></button>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-warning  am-round'><span class='am-icon-copy'></span></button>"
		+ "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-round'><span class='am-icon-trash-o'></span></button>"
		+ "</div></div></td>";
