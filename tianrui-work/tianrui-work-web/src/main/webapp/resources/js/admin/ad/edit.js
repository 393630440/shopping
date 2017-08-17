$(function() {
	imgInit();
});

var mark = 0;

function imgInit() {
	var html = "<span id=\"img_span_showId\">";
	html += "<img src=\"/getimg?imgPath=adInfo/" + img + "\" style=\"height: 45px; width: 50px;\"/>";
	html += "<button type=\"button\" onclick=\"imgDelete(1);\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
	html += "<span class=\"am-icon-trash-o\"></span>";
	html += "</button>";
	html += "</span>";
	$("#img_div_showId").append(html);
}

function imgDelete(flag) {
	if (flag == 1) {
		mark = 1;
	} else if (flag == 2) {
		$("#img").remove();
	}
	$("#img_span_showId").remove();

	var html = "<input type=\"file\" id=\"img\" name=\"img\" onchange=\"imgShow(this);\">";
	$("#input_div_showId").append(html);
}

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

	$("#img").hide();

	var html = "";
	html += "<span id=\"img_span_showId\">";
	html += "<img src=\"\" id=\"img_showId\" style=\"height: 45px; width: 50px;\"/>";
	html += "<button type=\"button\" onclick=\"imgDelete(2);\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
	html += "<span class=\"am-icon-trash-o\"></span>";
	html += "</button>";
	html += "</span>";
	$("#img_div_showId").append(html);
	previewPicture(ele, "img_showId");
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
	var depict = $("#depict").val(); // 广告描述
	if (depict == "")
		msg += "广告描述不能为空\n";

	var url = $("#url").val(); // 广告链接
	if (url == "")
		msg += "广告链接不能为空\n";

	var img = $("#img").val(); // 广告图片
	if (img == "")
		msg += "广告图片不能为空\n";

	if (msg != "") {
		alert(msg);
		return;
	}

	$.ajax({
		url : "/admin/shop/ad/edit",
		type : "POST",
		data : {
			"id" : id,
			"depict" : depict,
			"url" : url
		},
		success : function(ret) {
			if (ret.code == "000000") {
				if (mark == 1)
					imgUpload();
				window.location.href = "/admin/shop/ad/index";
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

function imgUpload() {
	$.ajaxFileUpload({
		url : "/addimg",
		type : "POST",
		secureuri : false, // 是否需要安全协议，一般设置为false
		fileElementId : [ "img" ], // 文件上传域的ID
		data : {
			"type" : "3",
			"id" : id,
			"mark" : "adImg",
			"name" : "img"
		},
		success : function(ret) {

		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
