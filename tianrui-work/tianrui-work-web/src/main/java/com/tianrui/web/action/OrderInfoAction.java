package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.LoggerUtils;

import tianrui.work.api.IOrderInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.order.OrderInfoFindReq;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.resp.order.OrderInfoFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/order")
public class OrderInfoAction {
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	IOrderInfoService orderInfoService;

	/** 跳转列表页面 */
	@RequestMapping("index")
	public ModelAndView orderPage() throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/order/index]");
		ModelAndView view = new ModelAndView();
		view.setViewName("shop/order/page");
		return view;
	}

	/** 查询列表数据 */
	@RequestMapping("querylist")
	@ResponseBody
	public Result queryList(OrderInfoFindReq req, HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/order/querylist]");
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		PageTool<OrderInfoFindResp> page = orderInfoService.queryOrderInfoByList(req);
		Result rs = Result.getSuccessful();
		rs.setData(page);
		return rs;
	}

	/** 跳转详情页面 */
	@RequestMapping("detailPage")
	public ModelAndView detailPage(HttpServletRequest request, String id) throws Exception {
		MemberInfo info = SessionManage.getSessionManage(request);

		ModelAndView view = new ModelAndView();
		OrderInfoFindResp resp = orderInfoService.queryOrderInfoByOne(id);
		view.addObject("memberRank", info.getMemberRank());
		view.addObject("order", resp);
		view.setViewName("shop/order/detail");
		return view;
	}

	/** 退货申请 */
	@RequestMapping("refund")
	@ResponseBody
	public Result refund(HttpServletRequest request, String id) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/order/refund]");
		Result rs = Result.getSuccessful();

		MemberInfo info = SessionManage.getSessionManage(request);
		if (info.getMemberRank().equals("2")) {
			rs.setCode("1");
			rs.setError("加盟商不允许退货");
		} else {
			OrderInfoFindResp resp = orderInfoService.queryOrderInfoByOne(id);
			if (resp != null) {
				// 订单状态只有在[==2-待发货]的时候才可以申请退货
				if (resp.getOrderStatus().equals("2")) {
					OrderInfoReq req = new OrderInfoReq();
					req.setOrderId(id);
					req.setOrderStatus("5");// 5-退款申请
					orderInfoService.editOrderInfo(req);
				} else {
					rs.setCode("1");
					rs.setError("非法退货状态");
				}
			} else {
				rs.setCode("1");
				rs.setError("订单信息异常");
			}
		}

		return rs;
	}

}
