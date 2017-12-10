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

import tianrui.work.api.IFileUploadService;
import tianrui.work.api.IGoodsClassifyService;
import tianrui.work.req.goods.GoodsClassifyFindReq;
import tianrui.work.req.goods.GoodsClassifyReq;
import tianrui.work.resp.goods.GoodsClassifyFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Controller
@RequestMapping("/admin/shop/goodsclassify")
public class AdminGoodsClassifyAction {
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	IGoodsClassifyService goodsClassifyService;
	@Autowired
	IFileUploadService fileUploadService;

	/** 跳转列表页面 */
	@RequestMapping("index")
	@AutherWeb(typeString = "admin")
	public ModelAndView goodsClassifyPage() {
		LoggerUtils.info(log, "---------- [/admin/shop/goodsclassify/index]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/goodsclassify/index");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryList(GoodsClassifyFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goodsclassify/querylist]");
		Result rs = Result.getSuccessful();
		PageTool<GoodsClassifyFindResp> page = goodsClassifyService.queryGoodsClassifyByList(req);
		rs.setData(page);
		return rs;
	}

	/** 跳转添加页面 */
	@RequestMapping("addpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView addPage(GoodsClassifyReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goodsclassify/addpage]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/goodsclassify/addpage");
		return view;
	}

	/** 添加数据 */
	@RequestMapping("add")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result add(GoodsClassifyReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goodsclassify/add]");
		Result rs = Result.getSuccessful();
		
		if (StringUtils.isNull(req.getIconStr())) {
			throw new Exception("没有图片怎么可以");
		} else {
			rs = fileUploadService.saveImg(req.getIconStr());
//			String imgName = FileUtils.saveImgFile("goodsClassify/", "", 0, ".png", req.getIconStr());
			if(rs.getCode().equals("000000")){
				req.setIcon(rs.getData().toString());
			}
		}

		req.setClassifyId(UUIDUtil.getUUID());// 商品分类ID
		req.setClassifyStatus("1");// 商品分类状态
		req.setPubdate(System.currentTimeMillis());
		rs = goodsClassifyService.addGoodsClassify(req);
		// rs.setData(req);
		return rs;
	}

	/** 跳转编辑页面 */
	@RequestMapping("editpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView editPage(GoodsClassifyReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goodsclassify/editpage]");
		ModelAndView view = new ModelAndView();
		view.addObject("goodsClassify", goodsClassifyService.queryGoodsClassify(req));
		view.setViewName("admin/goodsclassify/editpage");
		return view;
	}

	/** 编辑数据 */
	@RequestMapping("edit")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result edit(GoodsClassifyReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/goodsclassify/edit]");
		Result rs = Result.getSuccessful();
		if (!StringUtils.isNull(req.getIconStr())) {
			rs = fileUploadService.saveImg(req.getIconStr());
			if(rs.getCode().equals("000000")){
				req.setIcon(rs.getData().toString());
			}
		}
		rs = goodsClassifyService.editGoodsClassify(req);
		return rs;
	}

}
