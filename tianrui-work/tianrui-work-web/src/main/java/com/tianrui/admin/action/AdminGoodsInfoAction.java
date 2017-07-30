package com.tianrui.admin.action;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;
import com.tianrui.web.util.FileUtils;
import com.tianrui.web.util.LoggerUtils;

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

	/** 页面跳转 */
	@RequestMapping("index")
	@AutherWeb(typeString = "admin")
	public ModelAndView goodsPage() {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/index] To [AdminGoodsInfoAction.goodsPage]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/goods/index");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryList(GoodsInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/querylist] To [AdminGoodsInfoAction.queryList]");
		Result rs = Result.getSuccessful();
		PageTool<GoodsInfoFindResp> page = goodsInfoService.queryGoodsInfoByList(req);
		rs.setData(page);
		return rs;
	}

	/** 查询列表数据 */
	@RequestMapping("query")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result query(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/query] To [AdminGoodsInfoAction.query]");
		Result rs = Result.getSuccessful();
		GoodsInfoFindResp data = goodsInfoService.queryGoodsInfo(req);
		rs.setData(data);
		return rs;
	}

	/** 跳转添加页面 */
	@RequestMapping("addpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView addPage(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/addpage] To [AdminGoodsInfoAction.addPage]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/goods/addpage");
		return view;
	}

	/** 添加数据 */
	@RequestMapping("add")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result add(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/add] To [AdminGoodsInfoAction.add]");
		Result rs = null;
		if (isFile(req.getGoodsImg()) && isFile(req.getGoodsDetails())) {

			String goodsId = UUIDUtil.getUUID();
			Long pubdate = System.currentTimeMillis();
			req.setGoodsId(goodsId);// 商品ID
			req.setGoodsStatus("1");// 商品状态:1-已上架;2-已下架
			req.setPubdate(pubdate);
			req.setGoodsId(saveImg(req.getGoodsImg(), goodsId, pubdate));
			req.setGoodsDetails(saveImg(req.getGoodsDetails(), goodsId, pubdate));

			rs = goodsInfoService.addGoodsInfo(req);
		} else {
			rs = new Result("999999");
		}
		return rs;
	}

	/** 跳转编辑页面 */
	@RequestMapping("editpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView editPage(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/editpage] To [AdminGoodsInfoAction.editPage]");
		ModelAndView view = new ModelAndView();
		view.addObject("goodsInfo", goodsInfoService.queryGoodsInfo(req));
		view.setViewName("admin/goods/editpage");
		return view;
	}

	/** 编辑数据 */
	@RequestMapping("edit")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result edit(GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goods/edit] To [AdminGoodsInfoAction.edit]");
		Result rs = Result.getSuccessful();
		rs = goodsInfoService.editGoodsInfo(req);
		return rs;
	}

	/**
	 * 校验文件是否存在
	 */
	private static boolean isFile(String pathArrStr) {
		boolean flag = true;
		String[] pathArr = pathArrStr.split("[|]");
		for (String path : pathArr) {
			if ("".equals(path) || path == null)
				break;
			File file = new File(path);
			if (!file.exists()) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private String saveImg(String pathArrStr, String goodsId, Long pubdate) {
		StringBuilder sb = new StringBuilder();

		String sysPath = Thread.currentThread().getContextClassLoader().getResource("").toString();
		sysPath = sysPath.substring(6, sysPath.indexOf("WEB-INF"));
		if (sysPath.indexOf(":") == -1)
			sysPath = "/" + sysPath;

		String[] pathArr = pathArrStr.split("[|]");
		for (String path : pathArr) {
			if ("".equals(path) || path == null)
				break;

			File file = new File(sysPath + goodsId + "/");
			if (!file.isDirectory())
				file.mkdirs();

			String newPath = goodsId + "/" + pubdate + path.substring(path.indexOf("."), path.length());
			sb.append(newPath).append("|");
			newPath = sysPath + newPath;
			byte[] b = FileUtils.readFileBytes(path);
			FileUtils.writeFileAll(newPath, b, 0, b.length);
		}
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

}
