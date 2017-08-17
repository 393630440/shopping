$(function() {

});
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
	html += "<button type=\"button\" onclick=\"iconDelete();\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\">";
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

function iconDelete() {
	$("#icon").remove();
	$("#icon_span_showId").remove();

	var html = "<input type=\"file\" id=\"icon\" name=\"icon\" onchange=\"iconShow(this);\">";
	$("#input_div_showId").append(html);
}

function add(buttonType) {
	var msg = "";

	var classifyName = $("#classifyName").val(); // 分类名称
	if (classifyName == "")
		msg += "分类名称不能为空\n";

	var goodsType = $('input:radio[name="goodsType"]:checked').val(); // 商品类型:1-大众商品;2-宏包商品
	if (goodsType == "" || goodsType == undefined)
		msg += "商品类型不能为空\n";

	var descr = $("#descr").val(); // 备注说明
	if (descr == "")
		msg += "备注说明不能为空\n";

	if (msg != "") {
		alert(msg);
		return;
	}

	$.ajax({
		url : "/admin/shop/goodsclassify/add",
		type : "POST",
		data : {
			"classifyName" : classifyName,
			"goodsType" : goodsType,
			"descr" : descr
		},
		success : function(ret) {
			if (ret.code == "000000") {
				var id = ret.data.classifyId;
				iconUpload(id);
				if (buttonType == 2)
					window.location.href = "/admin/shop/goodsclassify/addpage";
				else
					window.location.href = "/admin/shop/goodsclassify/index";
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

function iconUpload(id) {
	$.ajaxFileUpload({
		url : "/addimg",
		type : "POST",
		secureuri : false, // 是否需要安全协议，一般设置为false
		fileElementId : [ "icon" ], // 文件上传域的ID
		data : {
			"type" : "4",
			"id" : id,
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