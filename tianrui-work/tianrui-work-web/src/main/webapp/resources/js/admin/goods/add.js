$(function() {

});

function goodsType(type) {
	if (type == 1) { // 1-大众商品,不显示宏包
		$("#goodsType1").show();
		$("#goodsType2").hide();
		$("#redPacket_div").hide();
		$("#redPacket").val("");
	} else if (type == 2) { // 2-宏包商品,显示宏包
		$("#goodsType1").hide();
		$("#goodsType2").show();
		$("#redPacket_div").show();
	}
}

var goodsImgNum = 0;
var goodsImgFileIds = [];

var goodsDetailsNum = 0;
var goodsDetailsFileIds = [];

function imgShow(ele, flag) {
	if (ele.value == "" || ele.value == undefined) {
		alert("请检查一下图片参数.");
		return;
	}

	if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ele.value)) {
		alert("图片类型必须是.gif,jpeg,jpg,png中的一种.");
		ele.value = "";
		return;
	}

	var input_showId = "";
	var input_Id_front = "";
	var input_Id_back = "";
	var img_showId = "";
	if (flag == 1) {
		input_showId = "goodsImg_input_showId";
		input_Id_front = "goodsImg" + goodsImgNum;
		goodsImgNum++;
		input_Id_back = "goodsImg" + goodsImgNum;
		img_showId = "goodsImg_img_showId";
		goodsImgFileIds[goodsImgFileIds.length] = input_Id_front;
	} else if (flag == 2) {
		input_showId = "goodsDetails_input_showId";
		input_Id_front = "goodsDetails" + goodsDetailsNum;
		goodsDetailsNum++;
		input_Id_back = "goodsDetails" + goodsDetailsNum;
		img_showId = "goodsDetails_img_showId";
		goodsDetailsFileIds[goodsDetailsFileIds.length] = input_Id_front;
	} else {
		alert("请检查一下图片标识.");
		return;
	}

	var imgId = img_showId + "_" + input_Id_front;
	var html = "";
	html += "<span id=\"img_showId_" + input_Id_front + "\">";
	html += "<img src=\"\" id=\"" + imgId;
	html += "\" style=\"height: 45px; width: 50px;\"/>";
	html += "<button type=\"button\" onclick=\"imgDelete('";
	html += input_Id_front + "'," + flag;
	html += ");\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
	html += "<span class=\"am-icon-trash-o\"></span></button></span>";
	$("#" + img_showId).append(html);
	previewPicture(ele, imgId);

	$("#" + input_Id_front).hide();

	html = "";
	html += "<input type=\"file\" id=\"" + input_Id_back + "\" name=\"";
	html += input_Id_back + "\" onchange=\"imgShow(this," + flag + ");\">";
	$("#" + input_showId).append(html);
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

function imgDelete(imgId, flag) {
	if (flag == 1) {
		del(goodsImgFileIds, imgId);
	} else if (flag == 2) {
		del(goodsDetailsFileIds, imgId);
	} else {
		return;
	}
}

function del(list, id) {
	for (var i = 0; i < list.length; i++) {
		if (list[i] == id) {
			list.splice(i, 1);
			$("#img_showId_" + id).remove();
			break;
		}
	}
}

function add(buttonType) {
	var msg = "";
	var goodsType = $('input:radio[name="goodsType"]:checked').val(); // 商品类型:1-大众商品;2-宏包商品
	if (goodsType == "" || goodsType == undefined)
		msg += "商品类型不能为空\n";

	var goodsName = $("#goodsName").val(); // 商品名称
	if (goodsName == "")
		msg += "商品名称不能为空\n";

	var classifyId = ""; // 分类ID
	if (goodsType == "1")
		classifyId = $("#classifyId1").val();
	else if (goodsType == "2")
		classifyId = $("#classifyId2").val();

	var classifyName = ""; // 分类名称
	if (classifyId == "0")
		msg += "所属分类不能为空\n";
	else
		classifyName = $("#classifyId_" + classifyId).val();

	var goodsPrice = $("#goodsPrice").val(); // 商品价格
	if (goodsPrice == "")
		msg += "商品价格不能为空\n";

	var redPacket = ""; // 商品宏包
	if (goodsType == "1")
		redPacket = "0";
	else if (goodsType == "2")
		redPacket = $("#redPacket").val();
	if (redPacket == "")
		msg += "商品宏包不能为空\n";

	if (goodsImgFileIds.length == 0)
		msg += "商品图片不能为空\n";

	if (goodsDetailsFileIds.length == 0)
		msg += "商品详情不能为空\n";

	var goodsParam = $("#goodsParam").val(); // 商品参数
	if (goodsParam == "")
		msg += "商品参数不能为空\n";

	var expressFee = $("#expressFee").val(); // 快递费
	if (expressFee == "")
		msg += "快递费不能为空\n";

	var inventory = $("#inventory").val(); // 库存
	if (inventory == "")
		msg += "库存不能为空\n";

	var sifting = $('input:radio[name="sifting"]:checked').val(); // 默认值=0,筛选条件:0-普通商品;1-推荐商品;2-新品上市;3-热卖商品;4-促销商品;5-卖家包邮;6-限时抢购
	if (sifting == "")
		msg += "筛选条件不能为空\n";

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
			"goodsName" : goodsName,
			"classifyId" : classifyId,
			"classifyName" : classifyName,
			"goodsType" : goodsType,
			"goodsPrice" : goodsPrice,
			"redPacket" : redPacket,
			"goodsParam" : goodsParam,
			"expressFee" : expressFee,
			"inventory" : inventory,
			"sifting" : sifting
		},
		success : function(ret) {
			if (ret.code == "000000") {
				var goodsId = ret.data.goodsId;
				imgUpload(goodsImgFileIds, goodsId, 1);
				imgUpload(goodsDetailsFileIds, goodsId, 2);
				if (buttonType == 2) {
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
}

function imgUpload(fileElementId, id, flag) {
	var mark = "goodsDetails";
	if (flag == 1)
		mark = "goodsImg";

	var name = "";
	for (var i = 0; i < fileElementId.length; i++) {
		name += fileElementId[i];
		if (i < (fileElementId.length - 1))
			name += "|";
	}

	$.ajaxFileUpload({
		url : "/addimg",
		type : "POST",
		secureuri : false, // 是否需要安全协议，一般设置为false
		fileElementId : fileElementId, // 文件上传域的ID
		data : {
			"type" : "1",
			"id" : id,
			"mark" : mark,
			"name" : name
		},
		success : function(ret) {

		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
