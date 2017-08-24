package com.tianrui.web.action;

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

import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.DateUtils;
import com.tianrui.web.util.LoggerUtils;

import tianrui.work.api.IGoodsInfoService;
import tianrui.work.api.IOrderInfoService;
import tianrui.work.api.IShoppingCartService;
import tianrui.work.bean.MemberAddressNew;
import tianrui.work.bean.MemberInfo;
import tianrui.work.mapper.java.MemberAddressNewMapper;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.req.shoppingcart.ShoppingCartFindReq;
import tianrui.work.req.shoppingcart.ShoppingCartReq;
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

	/** 跳转购物车列表页面 */
	@RequestMapping("shoppingcartlist")
	public ModelAndView goodsDetails(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/shoppingcartlist]");
		MemberInfo member = SessionManage.getSessionManage(request);

		ShoppingCartFindReq req = new ShoppingCartFindReq();
		req.setMemberId(member.getMemberId());
//		req.setMemberId("123456789");
		req.setShoppingCartStatus("1");// 购物车商品状态:1-已添加;2-已购买;3-已删除

		List<ShoppingCartFindResp> goodsInfoList = shoppingCartService.getShoppingCartList(req);

		ModelAndView view = new ModelAndView();
		view.addObject("goodsInfoList", goodsInfoList);
		view.setViewName("shop/shoppingcart/shoppingcartlist");
		return view;
	}

	/** 生成订单 */
	@RequestMapping("createorder")
	@ResponseBody
	public Result createOrder(HttpServletRequest request, String addressId, String goodsIds, String buyerWord)
			throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/shoppingcart/createorder]");
		MemberInfo member = SessionManage.getSessionManage(request);
		MemberAddressNew addressFindReq = memberAddressMapper.selectByPrimaryKey(addressId);

		String orderId = UUIDUtil.getUUID();
		String orderCode = DateUtils.format(new Date(), DateUtils.DATE_YYYYMMDDHHMISS);
		Integer goodsNum = 0; // 商品数量
		Double goodsSubtotal = 0d; // 商品小计
		Double expressFee = 0d; // 运费
		Double orderAmount = 0d; // 订单总金额
		Integer orderRedPacket = 0; // 订单总宏包
		Long creationTime = System.currentTimeMillis();

		Map<String, String> queryCondition = new HashMap<String, String>();
		queryCondition.put("memberId", member.getMemberId());
		queryCondition.put("goodsIds", goodsIds);
		queryCondition.put("shoppingCartStatus", "1");

		List<ShoppingCartFindResp> shoppingCartFindRespList = shoppingCartService
				.getOrderByGoodsInfoList(queryCondition);
		for (ShoppingCartFindResp shoppingCartFindResp : shoppingCartFindRespList) {
			goodsNum += shoppingCartFindResp.getGoodsNum();
			goodsSubtotal += shoppingCartFindResp.getGoodsSubtotal();
			orderRedPacket += shoppingCartFindResp.getGoodsRedPacket();
			if (expressFee < shoppingCartFindResp.getExpressFee())
				expressFee = shoppingCartFindResp.getExpressFee();

			ShoppingCartReq shoppingCartReq = new ShoppingCartReq();
			shoppingCartReq.setShoppingCartId(shoppingCartFindResp.getShoppingCartId());
			shoppingCartReq.setOrderId(orderId);
			shoppingCartReq.setGoodsId(shoppingCartFindResp.getGoodsId());
			shoppingCartReq.setMemberId(shoppingCartFindResp.getMemberId());
			shoppingCartReq.setShoppingCartStatus("2");
			shoppingCartService.editShoppingCart(shoppingCartReq);
		}
		orderAmount = goodsSubtotal;

		OrderInfoReq req = new OrderInfoReq();
		req.setOrderId(orderId); // 订单ID
		req.setOrderCode(orderCode); // 订单编号
		req.setMemberId(member.getMemberId()); // 会员ID
		// req.setGoodsType(null); // 商品类型:1-大众商品;2-宏包商品
		req.setGoodsNum(goodsNum); // 商品数量
		req.setGoodsSubtotal(goodsSubtotal); // 商品小计
		req.setExpressFee(expressFee); // 运费
		req.setOrderAmount(orderAmount); // 订单总金额
		req.setOrderRedPacket(orderRedPacket); // 订单总宏包
		req.setOrderStatus("1"); // 订单状态:1-待付款;2-待发货;3-待收货;4-已完成;5-退款申请;6-退款失败;7-退款成功;8-已取消;9-已删除;0-彻底删除
		// req.setBuyerWord(null); // 买家留言
		req.setCreationTime(creationTime); // 创建时间
		req.setRecipients(addressFindReq.getRecipients()); // 收件人
		req.setPhone(addressFindReq.getPhone()); // 联系电话
		req.setCity(addressFindReq.getCity()); // 所在地区
		req.setDetailAddress(addressFindReq.getDetailAddress()); // 详细地址

		Result rs = orderInfoService.addOrderInfo(req);
		return rs;
	}

}
