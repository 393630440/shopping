package com.tianrui.web.action;

import java.util.ArrayList;
import java.util.Date;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.DateUtils;
import com.tianrui.web.util.LoggerUtils;
import com.tianrui.web.util.StringUtils;

import tianrui.work.api.IConfigurationInfoService;
import tianrui.work.api.IGoodsInfoService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.api.IOrderInfoService;
import tianrui.work.api.IShoppingCartService;
import tianrui.work.bean.MemberAddressNew;
import tianrui.work.bean.MemberInfo;
import tianrui.work.mapper.java.MemberAddressNewMapper;
import tianrui.work.req.configuration.ConfigurationInfoReq;
import tianrui.work.req.goods.GoodsInfoReq;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.req.shoppingcart.ShoppingCartFindReq;
import tianrui.work.req.shoppingcart.ShoppingCartReq;
import tianrui.work.resp.configuration.ConfigurationInfoResp;
import tianrui.work.resp.goods.GoodsInfoFindResp;
import tianrui.work.resp.order.OrderInfoFindResp;
import tianrui.work.resp.shoppingcart.ShoppingCartFindResp;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;


@Controller
@RequestMapping("/wechat/shop/shoppingcart")
public class ShoppingCartAction {
	Logger log = Logger.getLogger(getClass());

	@Autowired
	IGoodsInfoService goodsInfoService;
	@Autowired
	IShoppingCartService shoppingCartService;
	@Autowired
	IOrderInfoService orderInfoService;
	@Autowired
	MemberAddressNewMapper memberAddressMapper;
	@Autowired
	IConfigurationInfoService configurationInfoService;
	@Autowired
	IMemberInfoService memberInfoService;

	/** 跳转购物车列表页面 */
	@RequestMapping("shoppingcartlist")
	public ModelAndView shoppingCartList(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/shoppingcartlist]");
		MemberInfo member = SessionManage.getSessionManage(request);

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
			// size = goodsInfoList.size();
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

	/** 跳转大众购物车列表页面 */
	@RequestMapping("ordinarylist")
	public ModelAndView ordinaryList(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/ordinarylist]");
		MemberInfo member = SessionManage.getSessionManage(request);

		ShoppingCartFindReq req = new ShoppingCartFindReq();
		req.setMemberId(member.getMemberId());
		
		req.setGoodsType("1");// ; // 商品类型:1-大众商品;2-宏包商品
		req.setShoppingCartStatus("1");// 购物车商品状态:1-已添加;2-已购买;3-已删除

		Integer size = 0;
		Double price = 0d;
		String total = "0";
		List<ShoppingCartFindResp> goodsInfoList = shoppingCartService.getShoppingCartList(req);
		List<Integer> shoppingCartIdList = new ArrayList<Integer>();
		if (goodsInfoList != null && goodsInfoList.size() > 0) {
			for (int i = 0; i < goodsInfoList.size(); i++) {
				ShoppingCartFindResp goodsInfo = goodsInfoList.get(i);
				size += goodsInfo.getGoodsNum();
				price += goodsInfo.getGoodsPrice() * goodsInfo.getGoodsNum();
				shoppingCartIdList.add(goodsInfo.getShoppingCartId());
			}
			total = formatDoubleToString(price);
		}

		ModelAndView view = new ModelAndView();
		view.addObject("size", size);
		view.addObject("total", total);
		view.addObject("goodsInfoList", goodsInfoList);
		view.addObject("shoppingCartIdList", shoppingCartIdList);
		view.setViewName("shop/shoppingcart/ordinarylist");
		return view;
	}

	/** 跳转宏包购物车列表页面 */
	@RequestMapping("redpacketlist")
	public ModelAndView redPacketList(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/redpacketlist]");
		MemberInfo member = SessionManage.getSessionManage(request);

		ShoppingCartFindReq req = new ShoppingCartFindReq();
		req.setMemberId(member.getMemberId());
		req.setGoodsType("2");// ; // 商品类型:1-大众商品;2-宏包商品
		req.setShoppingCartStatus("1");// 购物车商品状态:1-已添加;2-已购买;3-已删除

		Integer size = 0;
		Double price = 0d;
		String total = "0";
		List<ShoppingCartFindResp> goodsInfoList = shoppingCartService.getShoppingCartList(req);
		List<Integer> shoppingCartIdList = new ArrayList<Integer>();
		if (goodsInfoList != null && goodsInfoList.size() > 0) {
			for (int i = 0; i < goodsInfoList.size(); i++) {
				ShoppingCartFindResp goodsInfo = goodsInfoList.get(i);
				size += goodsInfo.getGoodsNum();
				price += goodsInfo.getGoodsPrice() * goodsInfo.getGoodsNum();
				shoppingCartIdList.add(goodsInfo.getShoppingCartId());
			}
			total = formatDoubleToString(price);
		}

		ModelAndView view = new ModelAndView();
		view.addObject("size", size);
		view.addObject("total", total);
		view.addObject("goodsInfoList", goodsInfoList);
		view.addObject("shoppingCartIdList", shoppingCartIdList);
		view.setViewName("shop/shoppingcart/redpacketlist");
		return view;
	}

	/** 跳转购物车列表页面 */
	@RequestMapping("delgoods")
	public Result delGoods(HttpServletRequest request, String shoppingCartIds) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/delgoods]");
		// Result rs = shoppingCartService.deleteShoppingCartGoods(shoppingCartIds);// 删除购物车中的商品
		Result rs = shoppingCartService.editShoppingCartStatus(shoppingCartIds);// 软删除，更改购物车中商品的状态
		return rs;
	}

	/** 生成订单 */
	@RequestMapping("placeorder")
	@ResponseBody
	public Result placeOrder(HttpServletRequest request, String shoppingCartInfo, String goodsType) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/placeorder]");
		MemberInfo member = SessionManage.getSessionManage(request);

		String orderId = UUIDUtil.getUUID();
		String orderCode = DateUtils.format(new Date(), DateUtils.DATE_YYYYMMDDHHMISS);
		Integer goodsNum = 0; // 商品数量
		Double goodsSubtotal = 0d; // 商品小计
		Double expressFee = 0d; // 运费
		Double orderAmount = 0d; // 订单总金额
		Integer orderRedPacket = 0; // 订单总宏包
		Long creationTime = System.currentTimeMillis();
		Map<Integer, Integer> shoppingCartInfoMap = new HashMap<Integer, Integer>();
		String shoppingCartIds = "";

		JSONArray ja = JSONArray.parseArray(shoppingCartInfo);
		for (int a = 0; a < ja.size(); a++) {
			JSONObject jo = ja.getJSONObject(a);
			Integer key = jo.getInteger("shoppingCartId");
			Integer value = jo.getInteger("newGoodsNum");
			shoppingCartInfoMap.put(key, value);

			if (!shoppingCartIds.equals(""))
				shoppingCartIds += ",";
			shoppingCartIds += String.valueOf(key);
		}

		Map<String, String> condition = new HashMap<String, String>();
		condition.put("memberId", member.getMemberId());
		condition.put("shoppingCartIds", shoppingCartIds.toString());
		condition.put("shoppingCartStatus", "1");

		List<ShoppingCartFindResp> shoppingCartFindRespList = shoppingCartService.getOrderByList(condition);
		for (ShoppingCartFindResp shoppingCartFindResp : shoppingCartFindRespList) {
			Integer newGoodsNum = shoppingCartInfoMap.get(shoppingCartFindResp.getShoppingCartId());
			goodsNum += newGoodsNum;
			goodsSubtotal += shoppingCartFindResp.getGoodsPrice() * newGoodsNum;
			orderRedPacket += shoppingCartFindResp.getGoodsRedPacket() * newGoodsNum;
			if (expressFee < shoppingCartFindResp.getExpressFee())
				expressFee = shoppingCartFindResp.getExpressFee();

			ShoppingCartReq shoppingCartReq = new ShoppingCartReq();
			shoppingCartReq.setShoppingCartId(shoppingCartFindResp.getShoppingCartId());
			shoppingCartReq.setOrderId(orderId);
			// shoppingCartReq.setGoodsId(shoppingCartFindResp.getGoodsId());
			// shoppingCartReq.setMemberId(shoppingCartFindResp.getMemberId());
			shoppingCartReq.setShoppingCartStatus("2");
			shoppingCartReq.setGoodsNum(newGoodsNum);
			shoppingCartService.editShoppingCart(shoppingCartReq);

			String goodsId = shoppingCartFindResp.getGoodsId();
			GoodsInfoFindResp goodsInfoFindResp = goodsInfoService.queryGoodsInfoByOne(goodsId, member.getMemberRank());
			Integer inventory = goodsInfoFindResp.getInventory() - newGoodsNum;// 库存
			Integer salesvolume = goodsInfoFindResp.getSalesvolume() + newGoodsNum;// 销量
			Integer buyNum = goodsInfoFindResp.getBuyNum() + newGoodsNum; // 购买数量
			GoodsInfoReq goodsInfoReq = new GoodsInfoReq();
			goodsInfoReq.setGoodsId(goodsId);
			goodsInfoReq.setInventory(inventory);
			goodsInfoReq.setSalesvolume(salesvolume);
			goodsInfoReq.setBuyNum(buyNum);
			goodsInfoService.editGoodsInfo(goodsInfoReq);
		}
		orderAmount = goodsSubtotal;

		OrderInfoReq req = new OrderInfoReq();
		req.setOrderId(orderId); // 订单ID
		req.setOrderCode(orderCode); // 订单编号
		req.setMemberId(member.getMemberId()); // 会员ID
		req.setGoodsType(goodsType); // 商品类型:1-大众商品;2-宏包商品
		req.setGoodsNum(goodsNum); // 商品数量
		req.setGoodsSubtotal(formatDouble(goodsSubtotal)); // 商品小计
		req.setExpressFee(expressFee); // 运费
		req.setOrderAmount(formatDouble(orderAmount)); // 订单总金额
		req.setOrderRedPacket(orderRedPacket); // 订单总宏包
		req.setOrderStatus("1"); // 订单状态:1-待付款;2-待发货;3-待收货;4-已完成;5-退款申请;6-退款失败;7-退款成功;8-已取消;9-已删除;0-彻底删除
		// req.setBuyerWord(null); // 买家留言
		req.setCreationTime(creationTime); // 创建时间
		// req.setRecipients(null); // 收件人
		// req.setPhone(null); // 联系电话
		// req.setCity(null); // 所在地区
		// req.setDetailAddress(null); // 详细地址

		Result rs = orderInfoService.addOrderInfo(req);
		rs.setData(orderId);
		return rs;
	}

	/**运单签收
	 * @throws Exception */
	@RequestMapping("signBill")
	@ResponseBody
	public Result signBill(String id) throws Exception{
		Result rs = Result.getSuccessful();
		OrderInfoFindResp resp = orderInfoService.queryOrderInfoByOne(id);
		if(resp!=null){
			if(resp.getOrderStatus().equals("3")){
				OrderInfoReq req = new OrderInfoReq();
				req.setOrderId(id);
				req.setOrderStatus("4");
				orderInfoService.editOrderInfo(req);
			}else{
				rs.setCode("1");
				rs.setError("不合法的签收状态");
			}
		}else{
			rs.setCode("1");
			rs.setError("未找到订单信息");
		}
		return rs;
	}
	
	/** 跳转到未付款订单详情页面 */
	@RequestMapping("unpaidorderpage")
	public ModelAndView unpaidOrderPage(String orderId, String addressId) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/unpaidorderpage]");
		OrderInfoFindResp orderInfo = orderInfoService.queryOrderInfoByOne(orderId);
		List<ShoppingCartFindResp> goodsInfoList = shoppingCartService.getListByOrderId(orderInfo.getOrderId());

		if (addressId.equals("0") && !StringUtils.isNull(orderInfo.getRecipients())
				&& !StringUtils.isNull(orderInfo.getPhone()) && !StringUtils.isNull(orderInfo.getCity())
				&& !StringUtils.isNull(orderInfo.getDetailAddress())) {
			addressId = "-1";
		}

		MemberAddressNew addressInfo = null;
		if (addressId.equals("0")) {

		} else if (addressId.equals("-1")) {
			addressInfo = new MemberAddressNew();
			addressInfo.setId(addressId);
			addressInfo.setRecipients(orderInfo.getRecipients());
			addressInfo.setPhone(orderInfo.getPhone());
			addressInfo.setCity(orderInfo.getCity());
			addressInfo.setDetailAddress(orderInfo.getDetailAddress());
		} else {
			addressInfo = memberAddressMapper.selectByPrimaryKey(addressId);
		}
		//TODO
		ConfigurationInfoReq req = new ConfigurationInfoReq();
		req.setFlag("1");
		List<ConfigurationInfoResp> con = configurationInfoService.getConfigurationInfoList(req);
		String redPark = "0";
		if(con.size()==1){
			redPark = con.get(0).getParamvalue();
		}
		//查询当前用户宏包
		Result mem = memberInfoService.selectByOpenid(orderInfo.getMemberId());
		MemberInfo fo = (MemberInfo) mem.getData();
		ModelAndView view = new ModelAndView();
		view.addObject("orderId", orderId);
		view.addObject("orderInfo", orderInfo);
		view.addObject("goodsInfoList", goodsInfoList);
		view.addObject("addressId", addressId);
		view.addObject("addressInfo", addressInfo);
		view.addObject("redPark", redPark);
		view.addObject("myredPark",fo.getRedPacket());
		view.setViewName("shop/shoppingcart/unpaidorderpage");
		return view;
	}

	/** 修改订单信息 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(String orderId, String addressId, String buyerWord) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/edit]");
		if (addressId.equals("-1") && StringUtils.isNull(buyerWord))
			return Result.getSuccessful();

		OrderInfoReq req = new OrderInfoReq();
		req.setOrderId(orderId); // 订单ID
		req.setBuyerWord(buyerWord); // 买家留言

		if (!addressId.equals("-1")) {
			MemberAddressNew addressInfo = memberAddressMapper.selectByPrimaryKey(addressId);
			req.setRecipients(addressInfo.getRecipients()); // 收件人
			req.setPhone(addressInfo.getPhone()); // 联系电话
			req.setCity(addressInfo.getCity()); // 所在地区
			req.setDetailAddress(addressInfo.getDetailAddress()); // 详细地址
		}

		Result rs = orderInfoService.editOrderInfo(req);
		return rs;
	}

	/** 跳转到未付款订单详情页面 */
	@RequestMapping("selectaddress")
	public ModelAndView selectAddress(HttpServletRequest request, String orderId, String addressId) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/selectaddress]");
		MemberInfo member = SessionManage.getSessionManage(request);

		MemberAddressNew memberAddressNew = new MemberAddressNew();
		memberAddressNew.setMemberId(member.getMemberId());
		List<MemberAddressNew> addressInfoList = memberAddressMapper.selectByCondition(memberAddressNew);

		ModelAndView view = new ModelAndView();
		view.addObject("orderId", orderId);
		view.addObject("addressId", addressId);
		view.addObject("addressInfoList", addressInfoList);
		view.setViewName("shop/shoppingcart/selectaddress");
		return view;
	}

	private String formatDoubleToString(double d) {
		d = (double) Math.round(d * 100) / 100;
		return String.valueOf(d);
	}

	private Double formatDouble(double d) {
		d = (double) Math.round(d * 100) / 100;
		return d;
	}

}
