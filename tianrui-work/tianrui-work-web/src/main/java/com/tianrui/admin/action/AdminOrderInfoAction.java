package com.tianrui.admin.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;
import com.tianrui.web.util.LoggerUtils;

import tianrui.work.api.IOrderInfoService;
import tianrui.work.req.order.OrderInfoFindReq;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.resp.order.OrderInfoFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/admin/shop/order")
public class AdminOrderInfoAction {
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	IOrderInfoService orderInfoService;

	/** 跳转列表页面 */
	@RequestMapping("index")
	@AutherWeb(typeString = "admin")
	public ModelAndView orderPage() throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/order/index]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/order/index");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryList(OrderInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/order/querylist]");
		PageTool<OrderInfoFindResp> page = orderInfoService.queryOrderInfoByList(req);
		Result rs = Result.getSuccessful();
		rs.setData(page);
		return rs;
	}

	/** 跳转退款列表页面 */
	@RequestMapping("querypage")
	@AutherWeb(typeString = "admin")
	public ModelAndView queryPage(OrderInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/order/querypage]");
		ModelAndView view = new ModelAndView();
		view.addObject("orderInfo", orderInfoService.queryOrderInfoByOne(req.getOrderId()));
		view.setViewName("admin/order/querypage");
		return view;
	}

	/** 跳转退款列表页面 */
	@RequestMapping("refundlist")
	@AutherWeb(typeString = "admin")
	public ModelAndView refundList() throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/order/refundlist]");
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/order/refundlist");
		return view;
	}

	/** 查询退款列表数据 */
	@RequestMapping("queryrefundlist")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result queryRefundList(OrderInfoFindReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/order/queryrefundlist]");
		req.setOrderStatus("5");// 退款申请
		PageTool<OrderInfoFindResp> page = orderInfoService.queryOrderInfoByList(req);
		Result rs = Result.getSuccessful();
		rs.setData(page);
		return rs;
	}

	/** 跳转退款列表页面 */
	@RequestMapping("auditpage")
	@AutherWeb(typeString = "admin")
	public ModelAndView auditPage(OrderInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/order/auditpage]");
		ModelAndView view = new ModelAndView();
		view.addObject("orderInfo", orderInfoService.queryOrderInfoByOne(req.getOrderId()));
		view.setViewName("admin/order/auditpage");
		return view;
	}

	/** 查询退款数据 */
	@RequestMapping("audit")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result audit(OrderInfoReq req) throws Exception {
		LoggerUtils.info(log, "---------- [/admin/shop/order/audit]");
		req.setRefundAuditTime(System.currentTimeMillis());
		Result rs = orderInfoService.editOrderInfo(req);
		return rs;
	}

}
