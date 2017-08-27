package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IConfigurationInfoService;
import tianrui.work.api.IMemberGainService;
import tianrui.work.api.IMemberRechangeService;
import tianrui.work.api.IOrderInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.OrderInfo;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.OrderInfoMapper;
import tianrui.work.req.gain.MemberGainSaveReq;
import tianrui.work.req.order.OrderInfoFindReq;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.resp.configuration.ConfigurationInfoResp;
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
	@Autowired
	IMemberRechangeService memberRechangeService;
	@Autowired
	IMemberGainService memberGainService;
	@Autowired
	MemberInfoMapper memberInfoMapper;
	@Autowired
	IConfigurationInfoService configurationInfoService;

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
		find.setMemberId(req.getMemberId());
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

	@Override
	public Result orderPaySuccess(String id) throws Exception {
		Result rs = Result.getSuccessful();
		OrderInfo info = orderInfoMapper.selectByPrimaryKey(id);
		if (StringUtils.equals("1", info.getOrderStatus())) {
			// 宏包记录
			if(info.getGoodsType().equals("2")){
				//宏包商品
				if (info.getOrderRedPacket() != 0) {
					MemberGainSaveReq gain = new MemberGainSaveReq();
					gain.setMemberId(info.getMemberId());
					gain.setRpType("2");
					gain.setRpNum(-Double.valueOf(info.getOrderRedPacket()));
					gain.setSourceId("2");
					gain.setSourceDescribe("商品消费宏包");
					memberGainService.save(gain);
					
					MemberInfo member = memberInfoMapper.selectByPrimaryKey(info.getMemberId());
					MemberInfo uptto = new MemberInfo();
					uptto.setMemberId(member.getMemberId());
					uptto.setRedPacket(member.getRedPacket() - info.getOrderRedPacket());
					memberInfoMapper.updateByPrimaryKeySelective(uptto);
				}
			}else if(info.getGoodsType().equals("1")){
				//大众商品
				ConfigurationInfoResp sp = configurationInfoService.queryConfigurationInfoByOne("RED_PACKET_AWARD_RATE");
				if(sp.getFlag().equals("1")){
					//派送宏包有效
					//宏包派送比例
					String value = sp.getParamvalue();
					//宏包派送数量
					Double unmb = info.getOrderAmount()*Double.valueOf(value);
					MemberGainSaveReq gain = new MemberGainSaveReq();
					gain.setMemberId(info.getMemberId());
					gain.setRpType("2");
					gain.setRpNum(unmb);
					gain.setSourceId("1");
					gain.setSourceDescribe("购买商品赠送宏包");
					memberGainService.save(gain);
					
					MemberInfo member = memberInfoMapper.selectByPrimaryKey(info.getMemberId());
					MemberInfo uptto = new MemberInfo();
					uptto.setMemberId(member.getMemberId());
					uptto.setRedPacket(member.getRedPacket() + unmb);
					memberInfoMapper.updateByPrimaryKeySelective(uptto);
				}
			}

			OrderInfo upt = new OrderInfo();
			upt.setOrderId(info.getOrderId());
			upt.setOrderStatus("2");// 待发货
			orderInfoMapper.updateByPrimaryKeySelective(upt);
		} else {
			rs.setCode("1");
			rs.setError("不合法的支付状态");
		}
		return rs;
	}

}
