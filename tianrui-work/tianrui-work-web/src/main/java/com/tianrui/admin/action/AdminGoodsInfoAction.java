package com.tianrui.admin.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;
import com.tianrui.web.util.LoggerUtils;

import tianrui.work.api.IGoodsClassifyService;
import tianrui.work.api.IGoodsInfoService;
import tianrui.work.req.goods.GoodsInfoFindReq;
import tianrui.work.req.goods.GoodsInfoReq;
import tianrui.work.resp.goods.GoodsInfoFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Controller
@RequestMapping("/admin/shop/goods")
public class AdminGoodsInfoAction {
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	IGoodsInfoService goodsInfoService;
	@Autowired
	IGoodsClassifyService goodsClassifyService;

	/** 跳转列表页面 */
	@RequestMapping("index")
	@AutherWeb(typeString = "admin")
	public ModelAndView goodsPage() throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/index]");
		ModelAndView view = new ModelAndView();
		view.addObject("goodsClassifyList", goodsClassifyService.getGoodsClassifyList());
		view.setViewName("admin/goods/index");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryList(GoodsInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/querylist]");
		PageTool<GoodsInfoFindResp> page = goodsInfoService.queryGoodsInfoByList(req);
		Result rs = Result.getSuccessful();
		rs.setData(page);
		return rs;
	}

	/** 跳转添加页面 */
	@RequestMapping("addpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView addPage(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/addpage]");
		ModelAndView view = new ModelAndView();
		view.addObject("goodsClassifyList", goodsClassifyService.getGoodsClassifyList());
		view.setViewName("admin/goods/addpage");
		return view;
	}

	/** 添加数据 */
	@RequestMapping("add")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result add(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/add]");
		String goodsId = UUIDUtil.getUUID();
		Long pubdate = System.currentTimeMillis();
		req.setGoodsId(goodsId);// 商品ID
		req.setGoodsStatus("1");// 商品状态:1-已上架;2-已下架
		req.setPubdate(pubdate);
		Result rs = goodsInfoService.addGoodsInfo(req);
		return rs;
	}

	/** 跳转编辑页面 */
	@RequestMapping("editpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView editPage(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/editpage]");
		ModelAndView view = new ModelAndView();
		view.addObject("goodsInfo", goodsInfoService.queryGoodsInfoByOne(req.getGoodsId()));
		view.addObject("goodsClassifyList", goodsClassifyService.getGoodsClassifyList());
		view.setViewName("admin/goods/editpage");
		return view;
	}

	/** 编辑数据 */
	@RequestMapping("edit")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result edit(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/edit]");
		Result rs = goodsInfoService.editGoodsInfo(req);
		return rs;
	}

}
