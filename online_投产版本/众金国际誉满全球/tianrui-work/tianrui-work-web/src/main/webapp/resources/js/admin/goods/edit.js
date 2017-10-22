$(function() {
	imgInit(oldGoodsImg, 1);
	imgInit(oldGoodsDetails, 2);
});

var goodsImgNum = 0;
var oldGoodsImgMap = {};
var oldGoodsImgList = [];

var goodsDetailsNum = 0;
var oldGoodsDetailsMap = {};
var oldGoodsDetailsList = [];

function imgInit(oldDataStr, flag) {
	var oldDataArr = oldDataStr.split("|");
	for (var i = 0; i < oldDataArr.length; i++) {
		if (oldDataArr[i] == null || oldDataArr[i] == "")
			continue;

		var img_showId = "";
		var old_img_id = "";
		if (flag == 1) {
			img_showId = "goodsImg_img_showId";
			old_img_id = "oldGoodsImg" + i;
			oldGoodsImgMap[old_img_id] = oldDataArr[i];
			oldGoodsImgList[oldGoodsImgList.length] = old_img_id;
		} else if (flag == 2) {
			img_showId = "goodsDetails_img_showId";
			old_img_id = "oldGoodsDetails" + i;
			oldGoodsDetailsMap[old_img_id] = oldDataArr[i];
			oldGoodsDetailsList[oldGoodsDetailsList.length] = old_img_id;
		} else {
			alert("请检查一下图片标识.");
			return;
		}

		var html = "<span id=\"old_img_showId_" + old_img_id;
		html += "\"><img src=\"" + path + oldDataArr[i];
		html += "\" style=\"height: 45px; width: 50px;\"/><button type=\"button\" onclick=\"oldImgDelete('";
		html += old_img_id + "'," + flag;
		html += ");\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\"><span class=\"am-icon-trash-o\"></span></button></span>";
		$("#" + img_showId).append(html);
	}

	var input_showId = "";
	var input_Id = "";
	if (flag == 1) {
		goodsImgNum = oldDataArr.length;
		input_showId = "goodsImg_input_showId";
		input_Id = "goodsImg" + goodsImgNum;
	} else if (flag == 2) {
		goodsDetailsNum = oldDataArr.length;
		input_showId = "goodsDetails_input_showId";
		input_Id = "goodsDetails" + goodsDetailsNum;
	} else {
		alert("请检查一下图片标识.");
		return;
	}

	var html = "";
	html += "<input type=\"file\" id=\"" + input_Id + "\" name=\"";
	html += input_Id + "\" onchange=\"imgShow(this," + flag + ");\">";
	$("#" + input_showId).append(html);
}

function oldImgDelete(oldImgId, flag) {
	if (flag == 1) {
		oldImgDel(oldGoodsImgList, oldImgId);
	} else if (flag == 2) {
		oldImgDel(oldGoodsDetailsList, oldImgId);
	} else {
		alert("请检查一下图片标识.");
		return;
	}
}

function oldImgDel(list, id) {
	for (var i = 0; i < list.length; i++) {
		if (list[i] == id) {
			list.splice(i, 1);
			$("#old_img_showId_" + id).remove();
			break;
		}
	}
}

var goodsImgFileIds = [];
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
	html += "<span id=\"img_showId_" + input_Id_front;
	html += "\"><img src=\"\" id=\"" + imgId;
	html += "\" style=\"height: 45px; width: 50px;\"/><button type=\"button\" onclick=\"imgDelete('";
	html += input_Id_front + "'," + flag;
	html += ");\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\"><span class=\"am-icon-trash-o\"></span></button></span>";
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

function edit() {
	var msg = "";
	var goodsName = $("#goodsName").val(); // 商品名称
	if (goodsName == "")
		msg += "商品名称不能为空\n";

	var classifyId = $("#classifyId").val(); // 分类ID
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

	if (goodsImgFileIds.length == 0 && oldGoodsImgList.length == 0)
		msg += "商品图片不能为空\n";

	if (goodsDetailsFileIds.length == 0 && oldGoodsDetailsList.length == 0)
		msg += "商品详情不能为空\n";

	// var goodsParam = $("#goodsParam").val(); // 商品参数
	var goodsParam = getGoodsParam(); // 商品参数
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
		url : "/admin/shop/goods/edit",
		type : "POST",
		data : {
			"goodsId" : goodsId,
			"goodsName" : goodsName,
			"classifyId" : classifyId,
			"classifyName" : classifyName,
			"goodsPrice" : goodsPrice,
			"redPacket" : redPacket,
			"goodsParam" : goodsParam,
			"expressFee" : expressFee,
			"inventory" : inventory,
			"sifting" : sifting
		},
		success : function(ret) {
			if (ret.code == "000000") {
				upload();
				window.location.href = "/admin/shop/goods/index";
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

function upload() {
	show();

	var oldData = "";
	var oldList = [];
	var oldMap = {};
	var fileElementId = [];
	var mark = "";

	for (var i = 0; i < 2; i++) {
		if (i == 0) {
			oldData = oldGoodsImg;
			oldList = oldGoodsImgList;
			oldMap = oldGoodsImgMap;
			fileElementId = goodsImgFileIds;
			mark = "goodsImg";
		} else if (i == 1) {
			oldData = oldGoodsDetails;
			oldList = oldGoodsDetailsList;
			oldMap = oldGoodsDetailsMap;
			fileElementId = goodsDetailsFileIds;
			mark = "goodsDetails";
		} else {
			break;
		}

		var old = oldData;
		if (!compare(oldData, oldList))
			old = getOld(oldList, oldMap);

		if (fileElementId.length > 0) {
			// imgUpload(fileElementId, mark, old);
			saveImg(i, old);
		} else {
			if (old != oldData) {
				// imgUpdate(old, mark);
				if (mark == "goodsImg")
					goodsImgName = old;
				else if (mark == "goodsDetails")
					goodsDetailsName = old;
			}
		}
	}

	if (goodsImgName == "" && goodsDetailsName == "") {
		// 没有做任何修改则不更新图片名称
	} else {
		exit();
	}

	hide();
}

function compare(oldData, oldList) {
	var val1 = oldData.split("|").length;
	var val2 = oldList.length;
	if (val1 == val2)
		return true;
	return false;
}

function getOld(list, map) {
	var str = "";
	if (list.length > 0) {
		for (var i = 0; i < list.length; i++) {
			str += map[list[i]];
			// if (i < (list.length - 1))
			str += "|";
		}
	}
	return str;
}

function imgUpload(fileElementId, mark, old) {
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
			"type" : "2",
			"id" : goodsId,
			"mark" : mark,
			"name" : name,
			"old" : old
		},
		success : function(ret) {

		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

function imgUpdate(old, mark) {
	var data = {};
	if (mark == "goodsImg") {
		data = {
			"goodsId" : goodsId,
			"goodsImg" : old
		};
	} else if (mark == "goodsDetails") {
		data = {
			"goodsId" : goodsId,
			"goodsDetails" : old
		};
	}

	$.ajax({
		url : "/admin/shop/goods/edit",
		type : "POST",
		async : false,
		data : data,
		success : function(ret) {

		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

function saveImg(flag, old) {
	if (flag == 0) {
		goodsImgName += old;
		var goodsImgStrArr = [];// 商品图片数据
		var img_showId = "goodsImg_img_showId";
		for (var i = 0; i < goodsImgFileIds.length; i++) {
			var input_Id_front = goodsImgFileIds[i];
			var imgId = img_showId + "_" + input_Id_front;
			var imgStr = $("#" + imgId)[0].src;
			var size = imgStr.length;
			var index = imgStr.indexOf("base64,") + 7;
			var data = imgStr.substring(index, size);
			goodsImgStrArr[goodsImgStrArr.length] = data;
		}
		uploadGoodsImg(goodsImgStrArr, 0);
	} else if (flag == 1) {
		goodsDetailsName += old;
		var goodsDetailsStrArr = [];// 商品详情图片数据
		var details_showid = "goodsDetails_img_showId";
		for (var i = 0; i < goodsDetailsFileIds.length; i++) {
			var input_Id_front = goodsDetailsFileIds[i];
			var imgId = details_showid + "_" + input_Id_front;
			var imgStr = $("#" + imgId)[0].src;
			var size = imgStr.length;
			var index = imgStr.indexOf("base64,") + 7;
			var data = imgStr.substring(index, size);
			goodsDetailsStrArr[goodsDetailsStrArr.length] = data;
		}
		uploadGoodsDetails(goodsDetailsStrArr, 0);
	}
}

var goodsImgName = "";
function uploadGoodsImg(goodsImgStrArr, index) {
	$.ajax({
		url : "/admin/shop/goods/addimg",
		type : "POST",
		async : false,
		data : {
			"goodsId" : goodsId,
			"goodsImgStr" : goodsImgStrArr[index]
		},
		success : function(ret) {
			if (ret.code == "000000") {
				goodsImgName += ret.data + "|";

				index = index + 1;
				if (index < goodsImgStrArr.length) {
					uploadGoodsImg(goodsImgStrArr, index);
				}
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

var goodsDetailsName = "";
function uploadGoodsDetails(goodsDetailsStrArr, index) {
	$.ajax({
		url : "/admin/shop/goods/addimg",
		type : "POST",
		async : false,
		data : {
			"goodsId" : goodsId,
			"goodsDetailsStr" : goodsDetailsStrArr[index]
		},
		success : function(ret) {
			if (ret.code == "000000") {
				goodsDetailsName += ret.data + "|";

				index = index + 1;
				if (index < goodsDetailsStrArr.length) {
					uploadGoodsDetails(goodsDetailsStrArr, index);
				}
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

function exit() {
	$.ajax({
		url : "/admin/shop/goods/edit",
		type : "POST",
		async : false,
		data : {
			"goodsId" : goodsId,
			"goodsImg" : goodsImgName,
			"goodsDetails" : goodsDetailsName
		},
		success : function(ret) {
			if (ret.code == "000000") {
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

// 显示隐藏层和弹出层
function show() {
	var tpscz = document.getElementById("tpscz-zx");
	tpscz.style.display = "block"; // 显示隐藏层
	tpscz.style.height = document.documentElement.clientHeight + "px"; // 设置隐藏层的高度为当前页面高度
	// $("#tpscz-zx").css('display', 'block');
	// $("#tpscz-zx").css("height", document.documentElement.clientHeight + "px");
}

// 去除隐藏层和弹出层
function hide() {
	document.getElementById("tpscz-zx").style.display = "none";
	// $("#tpscz-zx").css('display', 'none');
}

function goodsParamSub() {
	var key = $("#goodsParam_key").val();
	var value = $("#goodsParam_value").val();
	if (key == "" || key == undefined) {
		return;
	} else {
		var index = key.indexOf(":");
		if (index > -1) {
			alert("请按照规格名称的规范填写");
			$("#goodsParam_key").focus();
			return;
		}
	}
	if (value == "" || value == undefined) {
		return;
	} else {
		var index = value.indexOf(":");
		if (index > -1) {
			alert("请按照规格数据的规范填写");
			$("#goodsParam_key").focus();
			$("#goodsParam_value").focus();
			return;
		}
	}

	var html = "";
	html += "<span id=\"goodsParam_showId_" + goodsParamNum + "\">";
	html += "<input type=\"text\" class=\"am-input-sm\" style=\"width: 60%; display: inline;\" id=\"goodsParam" + goodsParamNum + "\" name=\"goodsParam" + goodsParamNum + "\" value=\"" + key + ":" + value + "\" disabled=\"disabled\" />";
	html += "<button type=\"button\" onclick=\"goodsParamDelete(" + goodsParamNum + ");\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
	html += "<span class=\"am-icon-trash-o\"></span>";
	html += "</button>";
	html += "</span>";
	$("#goodsParam_input_showId").append(html);

	goodsParamNum++;
	$("#goodsParam_key").val("");
	$("#goodsParam_value").val("");
}

function goodsParamDelete(num) {
	$("#goodsParam_showId_" + num).remove();
}

function getGoodsParam() {
	var goodsParamStr = "";
	for (var a = 0; a < goodsParamNum; a++) {
		var gp = $("#goodsParam" + a).val();
		if (gp != null && gp != "" && gp != undefined) {
			if (goodsParamStr != "")
				goodsParamStr += "|";
			goodsParamStr += gp;
		}
	}
	return goodsParamStr;
}