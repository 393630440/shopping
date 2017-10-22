package tianrui.work.api;

import tianrui.work.req.order.OrderInfoFindReq;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.resp.order.OrderInfoFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**
 * 订单信息
 * 
 * @author Joe
 *
 */
public interface IOrderInfoService {

	/** 添加订单 */
	Result addOrderInfo(OrderInfoReq req) throws Exception;

	/** 编辑订单信息 */
	Result editOrderInfo(OrderInfoReq req) throws Exception;

	/** 查询订单信息 */
	OrderInfoFindResp queryOrderInfoByOne(String orderId) throws Exception;

	/** 列表查询订单信息 */
	PageTool<OrderInfoFindResp> queryOrderInfoByList(OrderInfoFindReq req) throws Exception;
	/** 订单支付成功 */
	Result orderPaySuccess(String id,Double tootal)throws Exception;

}
