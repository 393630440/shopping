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
import tianrui.work.api.IWeChatMassageService;
import tianrui.work.bean.CashBackInfo;
import tianrui.work.bean.MemberGain;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.OrderInfo;
import tianrui.work.comm.Constant;
import tianrui.work.mapper.java.CashBackInfoMapper;
import tianrui.work.mapper.java.MemberGainMapper;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.OrderInfoMapper;
import tianrui.work.req.JfPaySuccessReq;
import tianrui.work.req.gain.MemberGainSaveReq;
import tianrui.work.req.massage.MessageReq;
import tianrui.work.req.order.OrderInfoFindReq;
import tianrui.work.req.order.OrderInfoReq;
import tianrui.work.req.rechange.MemberRechargeReq;
import tianrui.work.resp.WeChatPayResp;
import tianrui.work.resp.configuration.ConfigurationInfoResp;
import tianrui.work.resp.order.OrderInfoFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

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
	@Autowired
	IWeChatMassageService weChatMassageService;
	@Autowired
	MemberGainMapper memberGainMapper;
	@Autowired
	CashBackInfoMapper cashBackInfoMapper;

	@Override
	public Result addOrderInfo(OrderInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		OrderInfo record = new OrderInfo();
		PropertyUtils.copyProperties(record, req);
		orderInfoMapper.insert(record);
		
		MessageReq msg = new MessageReq();
		msg.setOpenid(req.getMemberId());
		msg.setFirst("亲，您的订单已产生，稍后将通知本店客服...");
		msg.setId(Constant.MESSAGE_DSUCCE);
		msg.setObj1(req.getOrderCode());
		msg.setObj2(req.getGoodsNum().toString());
		msg.setObj3(req.getOrderAmount().toString());
		msg.setFoots("\n谢谢亲的支持，宝贝已为您保存，请尽快去支付吧");
		weChatMassageService.saveMassage(msg);
		
		return rs;
	}

	@Override
	public Result editOrderInfo(OrderInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		OrderInfo record = new OrderInfo();
		PropertyUtils.copyProperties(record, req);
		orderInfoMapper.updateByPrimaryKeySelective(record);
		OrderInfo info = orderInfoMapper.selectByPrimaryKey(req.getOrderId());
		if(info.getOrderStatus().equals("3")){
			//已发货
			MessageReq msg = new MessageReq();
			msg.setOpenid(req.getMemberId());
			msg.setFirst("亲，让您久等了，您的订单已经开始发货了...");
			msg.setId(Constant.MESSAGE_DINGD);
			msg.setObj1(info.getWuliuName());//快递公司
			msg.setObj2(info.getWuliuNumb());//快递号
			msg.setObj3(info.getOrderCode());
			msg.setObj4(info.getGoodsNum().toString());
			msg.setFoots("\n您的宝贝已经发货，近期请注意查收...");
			weChatMassageService.saveMassage(msg);
		}
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
	public Result orderPaySuccess(WeChatPayResp weChatPay) throws Exception {
		Result rs = Result.getSuccessful();
		OrderInfo info = orderInfoMapper.selectByPrimaryKey(weChatPay.getTransid());
		if (StringUtils.equals("1", info.getOrderStatus())) {//待付款
			MemberInfo member = memberInfoMapper.selectByPrimaryKey(info.getMemberId());
			
			Double coMone = 0.00;
			if(weChatPay.getTotalfee()!=null){
				coMone = coMone + weChatPay.getTotalfee();
			}
			if(weChatPay.getBlance()!=null){
				coMone = coMone + weChatPay.getBlance();
			}
			if(weChatPay.getCashMoney()!=null){
				CashBackInfo in = new CashBackInfo();
				in.setId(UUIDUtil.getUUID());
				in.setMemberId(member.getMemberId());
				in.setMemberName(member.getWechatName());
				in.setBackAmount(0.00);
				in.setBackMoney(-weChatPay.getCashMoney());
				in.setBackRemark("购买商品消费");
				in.setCreateTime(System.currentTimeMillis());
				in.setDesc1("3");
				cashBackInfoMapper.insertSelective(in);
			}
			if(weChatPay.getRedPacket()!=null){
				MemberGain gain = new MemberGain();
				gain.setId(UUIDUtil.getUUID());
				gain.setMemberId(member.getMemberId());
				gain.setRpType("2");
				gain.setWechatName(member.getWechatName());
				gain.setRpNum(-weChatPay.getRedPacket());
				gain.setSourceId("2");
				gain.setSourceDescribe("购买商品消费宏包");
				gain.setCreatetime(System.currentTimeMillis());
				memberGainMapper.insertSelective(gain);
			}
			
			MemberInfo uptto = new MemberInfo();
			uptto.setMemberId(member.getMemberId());
			uptto.setRedPacket(member.getRedPacket() - weChatPay.getRedPacket());
			uptto.setBalance(member.getBalance()-weChatPay.getBlance());
			uptto.setCashMoney(member.getCashMoney()-weChatPay.getCashMoney());
			memberInfoMapper.updateByPrimaryKeySelective(uptto);
			
			if(coMone > 0){
				MemberRechargeReq req = new MemberRechargeReq();
				req.setMemberId(member.getMemberId());
				req.setRechargeAmount(-coMone);
				req.setRemark("商品消费");
				req.setDesc1("2");
				memberRechangeService.save(req);
			}
			
			//TODO
			MessageReq msg = new MessageReq();
			msg.setId(Constant.MESSAGE_WDING);
			msg.setOpenid(info.getMemberId());
			msg.setFirst("哎呀，购物成功了，欢迎对本平台的支持..\n");
			msg.setObj1(info.getOrderCode());
			msg.setObj2(coMone.toString());
			msg.setFoots("\n客服人员将以最快的方式为您寄送宝贝");
			weChatMassageService.saveMassage(msg);
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

	@Override
	public Result jfPaySuccess(JfPaySuccessReq req) {
		// TODO Auto-generated method stub
		return null;
	}

}
