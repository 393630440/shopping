$(function() {
	iconInit();
});

var mark = 0;

function iconInit() {
	var html = "<span id=\"icon_span_showId\">";
	html += "<img src=\"" + icon + "\" style=\"height: 45px; width: 50px;\"/>";
	html += "<button type=\"button\" onclick=\"iconDelete(1);\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
	html += "<span class=\"am-icon-trash-o\"></span>";
	html += "</button>";
	html += "</span>";
	$("#icon_div_showId").append(html);
}

function iconDelete(flag) {
	if (flag == 1) {
		mark = 1;
	} else if (flag == 2) {
		$("#icon").remove();
	}
	$("#icon_span_showId").remove();

	var html = "<input type=\"file\" id=\"icon\" name=\"icon\" onchange=\"iconShow(this);\">";
	$("#input_div_showId").append(html);
}

function iconShow(ele) {
	if (ele.value == "" || ele.value == undefined) {
		alert("请检查一下图片参数.");
		return;
	}

	if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ele.value)) {
		alert("图片类型必须是.gif,jpeg,jpg,png中的一种.");
		ele.value = "";
		return;
	}

	$("#icon").hide();

	var html = "";
	html += "<span id=\"icon_span_showId\">";
	html += "<img src=\"\" id=\"icon_showId\" style=\"height: 45px; width: 50px;\"/>";
	html += "<button type=\"button\" onclick=\"iconDelete(2);\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
	html += "<span class=\"am-icon-trash-o\"></span>";
	html += "</button>";
	html += "</span>";
	$("#icon_div_showId").append(html);
	previewPicture(ele, "icon_showId");
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

function edit() {
	var msg = "";

	var classifyName = $("#classifyName").val(); // 分类名称
	if (classifyName == "")
		msg += "分类名称不能为空\n";

	var descr = $("#descr").val(); // 备注说明
	if (descr == "")
		msg += "备注说明不能为空\n";

	var img = $("#icon").val(); // 图标
//	if (img == "" || img == undefined)
//		msg += "图标不能为空\n";

	if (msg != "") {
		alert(msg);
		return;
	}
	var iconStr = "";
	if (mark == 1) {
		iconStr = $("#icon_showId")[0].src;
		var size = iconStr.length;
		var index = iconStr.indexOf("base64,") + 7;
		iconStr = iconStr.substring(index, size);
	}

	$.ajax({
		url : "/admin/shop/goodsclassify/edit",
		type : "POST",
		data : {
			"classifyId" : classifyId,
			"classifyName" : classifyName,
			"descr" : descr,
			"iconStr" : iconStr
		},
		success : function(ret) {
			if (ret.code == "000000") {
				// if (mark == 1)
				// iconUpload();
				window.location.href = "/admin/shop/goodsclassify/index";
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

function iconUpload() {
	$.ajaxFileUpload({
		url : "/addimg",
		type : "POST",
		secureuri : false, // 是否需要安全协议，一般设置为false
		fileElementId : [ "icon" ], // 文件上传域的ID
		data : {
			"type" : "4",
			"id" : classifyId,
			"mark" : "goodsClassifyIcon",
			"name" : "icon"
		},
		success : function(ret) {

		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
