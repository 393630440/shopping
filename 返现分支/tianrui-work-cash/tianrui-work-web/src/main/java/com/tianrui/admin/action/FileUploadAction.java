package com.tianrui.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tianrui.work.api.IFileUploadService;
import tianrui.work.vo.Result;

/***
 * 文件上传
 * @author jh
 *
 */
@Controller
@RequestMapping("/upload")
public class FileUploadAction {

	@Autowired
	IFileUploadService fileUploadService;
	
	@RequestMapping("add")
	@ResponseBody
	public Result add(String imgStr){
		return fileUploadService.saveImg(imgStr);
	}
}
