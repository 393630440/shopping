$(function() {

});

function aaa(){
	alert(imgIdList);
}

var imgIdList = [];
var imgIdNum = 0;

// 验证文件上传框
function a(ele) {
	if (ele.value != "") {
		if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ele.value)) {
			alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
			ele.value = "";
			return;
		}
		imgIdNum++;
		var imgId = "img" + imgIdNum;
		imgIdList[imgIdList.length] = imgId;
		show(imgId);
		previewPicture(ele, imgId);
		ele.value = "";
	}
}

// 预览
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

function show(imgId) {
	var html = "";
	html += "<span id=\"" + imgId + imgId + "\">";
	html += "<img src=\"\" id=\"" + imgId + "\" style=\"height: 45px; width: 50px;\"/>";
	html += "<button type=\"button\" onclick=\"imgDelete('" + imgId + "');\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-round\"><span class=\"am-icon-trash-o\"></span></button>";
	html += "</span>";
	$("#showImg").append(html);
}

function imgDelete(imgId) {
	for (var i = 0; i < imgIdList.length; i++) {
		if (imgIdList[i] == imgId) {
			imgIdList.splice(i, 1);
			$("#" + imgId + imgId).remove();
			break;
		}
	}
}

function upload() {
	$.ajaxFileUpload({
		type : "POST",
		url : 'doUploadCargoImage.html', // 用于文件上传的服务器端请求地址
		secureuri : false, // 是否需要安全协议，一般设置为false
		fileElementId : imgIdList, // 文件上传域的ID
		data : {
			userId : userId,
			uploadFlag : "edit"
		},
		success : function(data, status) {
			if (userId != "" && userId != "undefined") {
				var html = "";
				html += "<br/><span width=\"100%\" height=\"100%\">&nbsp;&nbsp;上传图片中，请稍等...&nbsp;&nbsp;&nbsp;<i class=\"am-icon-spinner am-icon-spin\"></i></span>";
				html += "<br/><br/><div width=\"100%\" align=\"center\"><span id=\"closeWaitWinSpan\" class=\"am-btn am-btn-primary am-btn-xs\"></span></div>";
				parent.indexShowDiv("15%", "15%", html);
				timeClose(parent.document.getElementById("closeWaitWinSpan"), "edit.html?userType=3&&userId=" + userId);
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
