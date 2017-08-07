package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IOrderInfoService;
import tianrui.work.bean.OrderInfo;
import tianrui.work.mapper.java.OrderInfoMapper;
import tianrui.work.req.order.OrderInfoFindReq;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.resp.order.OrderInfoFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**
 * 订单信息
 * 
 * @author Joe
 */
@Service
public class OrderInfoService implements IOrderInfoService {

	@Autowired
	OrderInfoMapper orderInfoMapper;

	@Override
	public Result addOrderInfo(OrderInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		OrderInfo record = new OrderInfo();
		PropertyUtils.copyProperties(record, req);
		orderInfoMapper.insert(record);
		return rs;
	}

	@Override
	public Result editOrderInfo(OrderInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		OrderInfo record = new OrderInfo();
		PropertyUtils.copyProperties(record, req);
		orderInfoMapper.updateByPrimaryKeySelective(record);
		return rs;
	}

	@Override
	public OrderInfoFindResp queryOrderInfoByOne(String orderId) throws Exception {
		OrderInfo record = orderInfoMapper.selectByPrimaryKey(orderId);
		OrderInfoFindResp resp = new OrderInfoFindResp();
		PropertyUtils.copyProperties(resp, record);
		return resp;
	}

	@Override
	public PageTool<OrderInfoFindResp> queryOrderInfoByList(OrderInfoFindReq req) throws Exception {
		PageTool<OrderInfoFindResp> page = new PageTool<OrderInfoFindResp>();
		OrderInfo find = new OrderInfo();
		if (req.getPageNo() != null) {
			find.setPageNo(req.getPageSize() * req.getPageNo());
			find.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}

		find.setOrderCode(req.getOrderCode());
		find.setGoodsType(req.getGoodsType());
		find.setOrderStatus(req.getOrderStatus());

		List<OrderInfo> list = orderInfoMapper.selectByOrderInfo(find);
		long a = orderInfoMapper.selectBycount(find);

		List<OrderInfoFindResp> resp = new ArrayList<OrderInfoFindResp>();
		for (OrderInfo bean : list) {
			OrderInfoFindResp sp = new OrderInfoFindResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		page.setList(resp);
		page.setTotal(a);

		return page;
	}

}
