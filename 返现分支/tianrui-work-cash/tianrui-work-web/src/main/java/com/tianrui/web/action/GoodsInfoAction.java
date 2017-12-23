package com.tianrui.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.LoggerUtils;
import com.tianrui.web.util.StringUtils;

import tianrui.work.api.IAdInfoService;
import tianrui.work.api.IConfigurationInfoService;
import tianrui.work.api.IGoodsClassifyService;
import tianrui.work.api.IGoodsInfoService;
import tianrui.work.api.IMemberFootprintService;
import tianrui.work.api.IMemberRechangeService;
import tianrui.work.api.IShoppingCartService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.ad.AdInfoReq;
import tianrui.work.req.foot.MemberFootprintSaveReq;
import tianrui.work.req.goods.GoodsClassifyReq;
import tianrui.work.req.goods.GoodsInfoFindReq;
import tianrui.work.req.goods.GoodsInfoReq;
import tianrui.work.req.rechange.RechargeFindReq;
import tianrui.work.req.shoppingcart.ShoppingCartFindReq;
import tianrui.work.req.shoppingcart.ShoppingCartReq;
import tianrui.work.resp.ad.AdInfoResp;
import tianrui.work.resp.configuration.ConfigurationInfoResp;
import tianrui.work.resp.foot.MemberFootprintResp;
import tianrui.work.resp.goods.GoodsClassifyFindResp;
import tianrui.work.resp.goods.GoodsInfoFindResp;
import tianrui.work.resp.rechange.MemberRechargeResp;
import tianrui.work.resp.shoppingcart.ShoppingCartFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/goods")
public class GoodsInfoAction {
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	IGoodsInfoService goodsInfoService;
	@Autowired
	IGoodsClassifyService goodsClassifyService;
	@Autowired
	IAdInfoService adInfoService;
	@Autowired
	IShoppingCartService shoppingCartService;
	@Autowired
	IMemberFootprintService memberFootprintService;
	@Autowired
	IMemberRechangeService memberRechangeService;
	@Autowired
	IConfigurationInfoService configurationInfoService;

	/** 跳转商品首页页面 */
	@RequestMapping("goodshome")
	public ModelAndView goodsHome(GoodsInfoReq req, HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/goods/goodshome]");
		String goodsType = req.getGoodsType();
		if (StringUtils.isNull(goodsType))
			throw new Exception("");

		MemberInfo info = SessionManage.getSessionManage(request);
		String viewName = "";
		if (goodsType.equals("1"))
			viewName = "shop/goods/ordinaryhome";
		else if (goodsType.equals("2")) {
			viewName = "shop/goods/redpackethome";
			ConfigurationInfoResp spc = configurationInfoService.queryConfigurationInfoByOne("RED_PACKET_SHOP_RATE");
			if (spc.getFlag().equals("1")) {
				RechargeFindReq chang = new RechargeFindReq();
				chang.setMemberId(info.getMemberId());
				chang.setDesc1("2");
				PageTool<MemberRechargeResp> tool = memberRechangeService.select(chang);
				List<MemberRechargeResp> lst = tool.getList();
				Double payMoney = 0.00;
				for (MemberRechargeResp sp : lst) {
					payMoney = payMoney + sp.getRechargeAmount();
				}
				Double conf = Double.valueOf(spc.getParamvalue());
				if (payMoney < conf) {
					viewName = "shop/goods/redpacketNO";
				}
			}
		} else
			throw new Exception("");

		ModelAndView view = new ModelAndView();
		view.addObject("goodsType", goodsType);

		AdInfoReq adInfoReq = new AdInfoReq(goodsType);
		List<AdInfoResp> adInfoList = adInfoService.getAdInfoList(adInfoReq);
		view.addObject("adInfoList", adInfoList);

		GoodsClassifyReq goodsClassifyReq = new GoodsClassifyReq(goodsType);
		List<GoodsClassifyFindResp> classifyList = goodsClassifyService.getGoodsClassifyList(goodsClassifyReq);
		view.addObject("classifyList", classifyList);

		view.setViewName(viewName);
		return view;
	}

	/** 跳转商品列表页面 */
	@RequestMapping("goodslist")
	public ModelAndView goodsList(HttpServletRequest request, GoodsInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/goods/goodslist]");
		MemberInfo member = SessionManage.getSessionManage(request);
		req.setGoodsStatus("1");

		req.setPageNo(0);
		req.setPageSize(10);

		ModelAndView view = new ModelAndView();
		view.addObject("classifyId", req.getClassifyId());
		view.addObject("goodsType", req.getGoodsType());
		view.addObject("sifting", req.getSifting());

		String pageSort = req.getPageSort();
		if (pageSort == null || "".equals(pageSort)) {
			req.setPageSort("salesvolume desc, goods_price desc, red_packet desc");
			view.addObject("pageSort", "1");
		} else {
			if (pageSort.equals("1"))
				req.setPageSort("salesvolume desc, goods_price desc, red_packet desc");
			else if (pageSort.equals("2"))
				req.setPageSort("salesvolume desc");
			else if (pageSort.equals("3"))
				req.setPageSort("goods_price desc, red_packet desc");
			else if (pageSort.equals("4"))
				req.setPageSort("goods_price asc, red_packet asc");
			view.addObject("pageSort", pageSort);
		}

		GoodsClassifyReq goodsClassifyReq = new GoodsClassifyReq(req.getGoodsType());
		List<GoodsClassifyFindResp> classifyList = goodsClassifyService.getGoodsClassifyList(goodsClassifyReq);
		view.addObject("classifyList", classifyList);

		List<GoodsInfoFindResp> goodsList = goodsInfoService.getGoodsInfoList(req, member.getMemberRank());
		view.addObject("goodsList", goodsList);

		view.setViewName("shop/goods/goodslist");
		return view;
	}

	/** 加载商品数据 */
	@RequestMapping("toloadgoodslist")
	@ResponseBody
	public Result toLoadGoodsList(HttpServletRequest request, GoodsInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/goods/toloadgoodslist]");
		MemberInfo member = SessionManage.getSessionManage(request);
		String pageSort = req.getPageSort();

		if (!StringUtils.isNull(pageSort)) {
			if (pageSort.equals("1"))
				req.setPageSort("salesvolume desc, goods_price desc, red_packet desc");
			else if (pageSort.equals("2"))
				req.setPageSort("salesvolume desc");
			else if (pageSort.equals("3"))
				req.setPageSort("goods_price desc, red_packet desc");
			else if (pageSort.equals("4"))
				req.setPageSort("goods_price asc, red_packet asc");
		}

		PageTool<GoodsInfoFindResp> goodsList = goodsInfoService.queryGoodsInfoByList(req, member.getMemberRank());
		Result rs = Result.getSuccessful();
		rs.setData(goodsList);
		return rs;
	}

	/** 跳转商品详情页面 */
	@RequestMapping("goodsdetails")
	public ModelAndView goodsDetails(HttpServletRequest request, GoodsInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/goods/goodsdetails]");
		MemberInfo member = SessionManage.getSessionManage(request);
		GoodsInfoFindResp goodsInfo = goodsInfoService.queryGoodsInfoByOne(req.getGoodsId(), member.getMemberRank());

		// 更新浏览记录数
		req.setBrowseNum(goodsInfo.getBrowseNum() + 1);
		goodsInfoService.editGoodsInfo(req);

		// 会员足迹信息保存
		MemberFootprintSaveReq memberFootprintSaveReq = new MemberFootprintSaveReq();
		memberFootprintSaveReq.setMemberId(member.getMemberId());// 会员ID
		memberFootprintSaveReq.setGoodsId(goodsInfo.getGoodsId());// 商品ID
		memberFootprintSaveReq.setFfType("2");// 1-关注;2-足迹
		memberFootprintSaveReq.setSeetheTime(System.currentTimeMillis());// 查看时间
		memberFootprintSaveReq.setGoodsName(goodsInfo.getGoodsName());// 商品名称
		memberFootprintSaveReq.setGoodsImg(goodsInfo.getFirstGoodsImg());// 商品图片
		memberFootprintSaveReq.setGoodsPrice(goodsInfo.getGoodsPrice());// 商品价格
		memberFootprintService.save(memberFootprintSaveReq);

		String followFlag = "0";// 关注标志：0-未关注；1-已关注
		MemberFootprintSaveReq query = new MemberFootprintSaveReq();
		query.setMemberId(member.getMemberId());
		query.setGoodsId(goodsInfo.getGoodsId());
		query.setFfType("1");// 关注足迹类型:1-关注;2-足迹
		MemberFootprintResp memberFootprintResp = memberFootprintService.queryByOne(query);
		if (memberFootprintResp != null)
			followFlag = "1";

		ModelAndView view = new ModelAndView();
		view.addObject("goodsInfo", goodsInfo);
		view.addObject("goodsImgList", analysisImg(goodsInfo.getGoodsImg()));
		view.addObject("goodsDetailsList", analysisImg(goodsInfo.getGoodsDetails()));
		view.addObject("goodsParamList", analysisParam(goodsInfo.getGoodsParam()));
		view.addObject("followFlag", followFlag);
		view.setViewName("shop/goods/goodsdetails");
		return view;
	}

	/** 添加商品到购物车 */
	@RequestMapping("addgoods")
	@ResponseBody
	public Result addGoods(HttpServletRequest request, ShoppingCartReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/goods/addgoods]");
		MemberInfo member = SessionManage.getSessionManage(request);
		GoodsInfoFindResp goodsInfoFindResp = goodsInfoService.queryGoodsInfoByOne(req.getGoodsId(), member.getMemberRank());

		// 添加购物车
		req.setMemberId(member.getMemberId());
		req.setCreationTime(System.currentTimeMillis());
		req.setGoodsName(goodsInfoFindResp.getGoodsName());
		req.setGoodsImg(goodsInfoFindResp.getFirstGoodsImg());
		req.setGoodsPrice(goodsInfoFindResp.getGoodsPrice());
		req.setGoodsRedPacket(goodsInfoFindResp.getRedPacket());
		req.setGoodsType(goodsInfoFindResp.getGoodsType());
		req.setShoppingCartStatus("1");// 购物车商品状态:1-已添加;2-已购买;3-已删除
		req.setExpressFee(goodsInfoFindResp.getExpressFee());
		Result rs = shoppingCartService.addShoppingCart(req);

		// 更新商品库存和销量
		// Integer inventory = goodsInfoFindResp.getInventory() - req.getGoodsNum();// 库存
		// Integer salesvolume = goodsInfoFindResp.getSalesvolume() + req.getGoodsNum();// 销量
		// Integer buyNum = goodsInfoFindResp.getBuyNum() + req.getGoodsNum(); // 购买数量
		// GoodsInfoReq goodsInfoReq = new GoodsInfoReq();
		// goodsInfoReq.setGoodsId(goodsInfoFindResp.getGoodsId());
		// goodsInfoReq.setInventory(inventory);
		// goodsInfoReq.setSalesvolume(salesvolume);
		// goodsInfoReq.setBuyNum(buyNum);
		// rs = goodsInfoService.editGoodsInfo(goodsInfoReq);

		return rs;
	}

	/** 商品关注 */
	@RequestMapping("goodsfollow")
	@ResponseBody
	public Result goodsFollow(HttpServletRequest request, String goodsId, String FfType) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/goods/goodsfollow]");
		MemberInfo member = SessionManage.getSessionManage(request);

		MemberFootprintSaveReq query = new MemberFootprintSaveReq();
		query.setMemberId(member.getMemberId());
		query.setGoodsId(goodsId);
		query.setFfType("1");// 关注足迹类型:1-关注;2-足迹
		MemberFootprintResp memberFootprintResp = memberFootprintService.queryByOne(query);

		if (FfType.equals("0")) {
			if (memberFootprintResp == null) {
				// 如果是取消关注，并且没有查到关注信息，那么则不做任何操作
			} else {
				// 如果是取消关注，并且查到关注信息，则删除原关注信息
				memberFootprintService.deleteByOne(memberFootprintResp.getId());
			}
		} else if (FfType.equals("1")) {
			if (memberFootprintResp == null) {
				GoodsInfoFindResp goodsInfo = goodsInfoService.queryGoodsInfoByOne(goodsId, member.getMemberRank());

				// 如果是关注，并且没有查到关注信息，则保存关注信息
				MemberFootprintSaveReq memberFootprintSaveReq = new MemberFootprintSaveReq();
				memberFootprintSaveReq.setMemberId(member.getMemberId());// 会员ID
				memberFootprintSaveReq.setGoodsId(goodsId);// 商品ID
				memberFootprintSaveReq.setFfType("1");// 1-关注;2-足迹
				memberFootprintSaveReq.setSeetheTime(System.currentTimeMillis());// 查看时间
				memberFootprintSaveReq.setGoodsName(goodsInfo.getGoodsName());// 商品名称
				memberFootprintSaveReq.setGoodsImg(goodsInfo.getFirstGoodsImg());// 商品图片
				memberFootprintSaveReq.setGoodsPrice(goodsInfo.getGoodsPrice());// 商品价格
				memberFootprintService.save(memberFootprintSaveReq);
			} else {
				// 如果是关注，并且查到关注信息，则更新关注时间
				MemberFootprintSaveReq memberFootprintSaveReq = new MemberFootprintSaveReq();
				memberFootprintSaveReq.setId(memberFootprintResp.getId());
				memberFootprintSaveReq.setCreatetime(System.currentTimeMillis());
				memberFootprintService.edit(memberFootprintSaveReq);
			}
		}

		Result rs = Result.getSuccessful();
		return rs;
	}

	@RequestMapping("buynow")
	public ModelAndView buyNow(HttpServletRequest request, String goodsId, Integer goodsNum) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/goods/buynow]");
		MemberInfo member = SessionManage.getSessionManage(request);
		GoodsInfoFindResp goodsInfoFindResp = goodsInfoService.queryGoodsInfoByOne(goodsId, member.getMemberRank());

		// 添加购物车
		ShoppingCartReq shoppingCartReq = new ShoppingCartReq();
		shoppingCartReq.setGoodsId(goodsId);
		shoppingCartReq.setGoodsNum(goodsNum);
		shoppingCartReq.setMemberId(member.getMemberId());
		shoppingCartReq.setCreationTime(System.currentTimeMillis());
		shoppingCartReq.setGoodsName(goodsInfoFindResp.getGoodsName());
		shoppingCartReq.setGoodsImg(goodsInfoFindResp.getFirstGoodsImg());
		shoppingCartReq.setGoodsPrice(goodsInfoFindResp.getGoodsPrice());
		shoppingCartReq.setGoodsRedPacket(goodsInfoFindResp.getRedPacket());
		shoppingCartReq.setGoodsType(goodsInfoFindResp.getGoodsType());
		shoppingCartReq.setShoppingCartStatus("1");// 购物车商品状态:1-已添加;2-已购买;3-已删除
		shoppingCartReq.setExpressFee(goodsInfoFindResp.getExpressFee());
		shoppingCartService.addShoppingCart(shoppingCartReq);

		ShoppingCartFindReq req = new ShoppingCartFindReq();
		req.setMemberId(member.getMemberId());
		req.setShoppingCartStatus("1");// 购物车商品状态:1-已添加;2-已购买;3-已删除

		Integer size = 0;
		Double price = 0d;
		Integer redPacket = 0;
		String total = "0";
		List<ShoppingCartFindResp> goodsInfoList = shoppingCartService.getShoppingCartList(req);
		List<Integer> shoppingCartIdList = new ArrayList<Integer>();
		if (goodsInfoList != null && goodsInfoList.size() > 0) {
			for (int i = 0; i < goodsInfoList.size(); i++) {
				ShoppingCartFindResp goodsInfo = goodsInfoList.get(i);
				size += goodsInfo.getGoodsNum();
				price += goodsInfo.getGoodsPrice() * goodsInfo.getGoodsNum();
				redPacket += goodsInfo.getGoodsRedPacket() * goodsInfo.getGoodsNum();
				shoppingCartIdList.add(goodsInfo.getShoppingCartId());
			}
			total = formatDoubleToString(price) + " + " + String.valueOf(redPacket) + "积分";
		}

		ModelAndView view = new ModelAndView();
		view.addObject("size", size);
		view.addObject("total", total);
		view.addObject("goodsInfoList", goodsInfoList);
		view.addObject("shoppingCartIdList", shoppingCartIdList);
		view.setViewName("shop/shoppingcart/shoppingcartlist");
		return view;
	}

	/** 解析图片字段 */
	private List<String> analysisImg(String reqStr) {
		List<String> rspList = null;
		if (!StringUtils.isNull(reqStr)) {
			rspList = new ArrayList<>();
			String[] arr = reqStr.split("[|]");
			for (int i = 0; i < arr.length; i++) {
				String img = arr[i];
				if (!StringUtils.isNull(img))
					rspList.add(arr[i]);
			}
		}
		return rspList;
	}

	/** 解析商品参数 */
	private List<Map<String, String>> analysisParam(String reqStr) {
		List<Map<String, String>> rspList = null;
		if (!StringUtils.isNull(reqStr)) {
			rspList = new ArrayList<Map<String, String>>();
			String[] arr = reqStr.split("[|]");
			for (int i = 0; i < arr.length; i++) {
				String[] a = arr[i].split(":");
				Map<String, String> map = new HashMap<String, String>();
				map.put("key", a[0]);
				map.put("value", a[1]);
				rspList.add(map);
			}
		}
		return rspList;
	}

	private String formatDoubleToString(double d) {
		d = (double) Math.round(d * 100) / 100;
		return String.valueOf(d);
	}

}
