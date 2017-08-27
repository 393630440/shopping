package com.tianrui.admin.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;
import com.tianrui.web.util.LoggerUtils;

import tianrui.work.api.IConfigurationInfoService;
import tianrui.work.req.configuration.ConfigurationInfoReq;
import tianrui.work.resp.configuration.ConfigurationInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/admin/shop/configuration")
public class AdminConfigurationAction {
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	IConfigurationInfoService configurationInfoService;

	/** 跳转列表页面 */
	@RequestMapping("index")
	@AutherWeb(typeString = "admin")
	public ModelAndView adPage() throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/configuration/index]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/configuration/index");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryList(ConfigurationInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/configuration/querylist]");
		PageTool<ConfigurationInfoResp> page = configurationInfoService.queryConfigurationInfoByList(req);
		Result rs = Result.getSuccessful();
		rs.setData(page);
		return rs;
	}

	/** 跳转添加页面 */
	@RequestMapping("addpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView addPage(ConfigurationInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/configuration/addpage]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/configuration/addpage");
		return view;
	}

	/** 添加数据 */
	@RequestMapping("add")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result add(ConfigurationInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/configuration/add]");
		req.setFlag("1");// 维护标志:0-失效;1-有效
		Result rs = configurationInfoService.addConfigurationInfo(req);
		return rs;
	}

	/** 跳转编辑页面 */
	@RequestMapping("editpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView editPage(ConfigurationInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/configuration/editpage]");
		ConfigurationInfoResp info = configurationInfoService.queryConfigurationInfoByOne(req.getParamkey());

		ModelAndView view = new ModelAndView();
		view.addObject("configurationInfo", info);
		view.setViewName("admin/configuration/editpage");
		return view;
	}

	/** 编辑数据 */
	@RequestMapping("edit")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result edit(ConfigurationInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/configuration/edit]");
		Result rs = configurationInfoService.editConfigurationInfo(req);
		return rs;
	}

}
