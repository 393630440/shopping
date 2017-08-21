package com.tianrui.admin.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;
import com.tianrui.web.util.FileUtils;
import com.tianrui.web.util.LoggerUtils;
import com.tianrui.web.util.StringUtils;

import tianrui.work.api.IAdInfoService;
import tianrui.work.req.ad.AdInfoFindReq;
import tianrui.work.req.ad.AdInfoReq;
import tianrui.work.resp.ad.AdInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/admin/shop/ad")
public class AdminAdInfoAction {
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	IAdInfoService adInfoService;

	/** 跳转列表页面 */
	@RequestMapping("index")
	@AutherWeb(typeString = "admin")
	public ModelAndView adPage() throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/ad/index]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/ad/index");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryList(AdInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/ad/querylist]");
		PageTool<AdInfoResp> page = adInfoService.queryAdInfoByList(req);
		Result rs = Result.getSuccessful();
		rs.setData(page);
		return rs;
	}

	/** 跳转添加页面 */
	@RequestMapping("addpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView addPage(AdInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/ad/addpage]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/ad/addpage");
		return view;
	}

	/** 添加数据 */
	@RequestMapping("add")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result add(AdInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/ad/add]");

		if (StringUtils.isNull(req.getImgStr())) {
			throw new Exception("没有图片怎么可以");
		} else {
			String imgName = FileUtils.saveImgFile("adInfo/", "", 0, ".png", req.getImgStr());
			req.setImg(imgName);
		}

		req.setStatus("1");
		req.setPubdate(System.currentTimeMillis());
		Result rs = adInfoService.addAdInfo(req);
		// rs.setData(req);
		return rs;
	}

	/** 跳转编辑页面 */
	@RequestMapping("editpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView editPage(AdInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/ad/editpage]");
		ModelAndView view = new ModelAndView();
		view.addObject("adInfo", adInfoService.queryAdInfoByOne(req.getId()));
		view.setViewName("admin/ad/editpage");
		return view;
	}

	/** 编辑数据 */
	@RequestMapping("edit")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result edit(AdInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/ad/edit]");

		if (!StringUtils.isNull(req.getImgStr())) {
			String imgName = FileUtils.saveImgFile("adInfo/", "", 0, ".png", req.getImgStr());
			req.setImg(imgName);
		}

		Result rs = adInfoService.editAdInfo(req);
		return rs;
	}

}
