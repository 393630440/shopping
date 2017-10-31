package com.tianrui.admin.action;

import java.util.ArrayList;
import java.util.List;

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

import tianrui.work.api.IGoodsClassifyService;
import tianrui.work.api.IGoodsInfoService;
import tianrui.work.req.goods.GoodsClassifyReq;
import tianrui.work.req.goods.GoodsInfoFindReq;
import tianrui.work.req.goods.GoodsInfoReq;
import tianrui.work.resp.goods.GoodsClassifyFindResp;
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
		view.addObject("goodsClassifyList", goodsClassifyService.getGoodsClassifyList(new GoodsClassifyReq()));
		view.setViewName("admin/goods/index");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryList(GoodsInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/querylist]");
		PageTool<GoodsInfoFindResp> page = goodsInfoService.queryGoodsInfoByList(req, "1");
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
		view.addObject("goodsClassifyList", goodsClassifyService.getGoodsClassifyList(new GoodsClassifyReq()));
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
		rs.setData(goodsId);
		return rs;
	}

	/** 添加图片 */
	@RequestMapping("addimg")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result addImg(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/addimg]");

		if (StringUtils.isNull(req.getGoodsImgStr()) && StringUtils.isNull(req.getGoodsDetailsStr()))
			throw new Exception("没有图片怎么可以");

		String folder = "goodsInfo/" + req.getGoodsId() + "/";
		String imgData = "";
		String prefix = "";
		if (!StringUtils.isNull(req.getGoodsImgStr())) {
			imgData = req.getGoodsImgStr();
			prefix = "goodsImg_";
		} else if (!StringUtils.isNull(req.getGoodsDetailsStr())) {
			imgData = req.getGoodsDetailsStr();
			prefix = "goodsDetails_";
		}

		String imgName = FileUtils.saveImgFile(folder, prefix, 0, ".png", imgData);

		Result rs = Result.getSuccessful();
		rs.setData(imgName);
		return rs;
	}

	/** 跳转编辑页面 */
	@RequestMapping("editpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView editPage(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/editpage]");
		ModelAndView view = new ModelAndView();

		GoodsInfoFindResp goodsInfo = goodsInfoService.queryGoodsInfoByOne(req.getGoodsId(), "1");

		String goodsType = goodsInfo.getGoodsType();
		GoodsClassifyReq goodsClassifyReq = new GoodsClassifyReq(goodsType);
		List<GoodsClassifyFindResp> goodsClassifyList = goodsClassifyService.getGoodsClassifyList(goodsClassifyReq);

		List<String> goodsParamList = analysisParam(goodsInfo.getGoodsParam());

		view.addObject("goodsInfo", goodsInfo);
		view.addObject("goodsClassifyList", goodsClassifyList);
		view.addObject("goodsParamList", goodsParamList);
		view.addObject("goodsParamNum", goodsParamList.size());
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

	private List<String> analysisParam(String reqStr) {
		List<String> rspList = null;
		if (!StringUtils.isNull(reqStr)) {
			rspList = new ArrayList<String>();
			String[] arr = reqStr.split("[|]");
			for (String str : arr) {
				rspList.add(str);
			}
		}
		return rspList;
	}

}
