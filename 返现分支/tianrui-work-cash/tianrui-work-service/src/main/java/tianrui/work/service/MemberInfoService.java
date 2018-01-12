package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberGainService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.CashBackInfo;
import tianrui.work.bean.MemberGain;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.MemberRecharge;
import tianrui.work.bean.MemberSetting;
import tianrui.work.mapper.java.CashBackInfoMapper;
import tianrui.work.mapper.java.MemberGainMapper;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.MemberRechargeMapper;
import tianrui.work.mapper.java.MemberSettingMapper;
import tianrui.work.req.HbaoPayReq;
import tianrui.work.req.gain.MemberGainSaveReq;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.req.member.MemberInfoHBaoReq;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.req.member.MemberSetUptReq;
import tianrui.work.req.rechange.MemberRechargeReq;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.resp.member.MemberSetResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class MemberInfoService implements IMemberInfoService{

	@Autowired
	MemberInfoMapper memberInfoMapper;
	@Autowired
	MemberSettingMapper memberSettingMapper;
	@Autowired
	IMemberGainService memberGainService;
	@Autowired
	CashBackInfoMapper cashBackInfoMapper;
	@Autowired
	MemberGainMapper memberGainMapper;
	@Autowired
	MemberRechargeMapper memberRechargeMapper;
	
	@Override
	public Result uptCashBack(String id, Double cashMoney) throws Exception {
		Result rs = Result.getSuccessful();
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(id);
		if(cashMoney <= info.getCashMoney()){
			MemberInfo upt = new MemberInfo();
			upt.setMemberId(id);
			upt.setBalance(info.getBalance()+(cashMoney/2));
			upt.setRedPacket(info.getRedPacket()+(cashMoney/2));
			upt.setCashMoney(info.getCashMoney()-cashMoney);
			memberInfoMapper.updateByPrimaryKeySelective(upt);
			
			//补贴提现记录
			CashBackInfo in = new CashBackInfo();
			in.setId(UUIDUtil.getUUID());
			in.setMemberId(info.getMemberId());
			in.setMemberName(info.getWechatName());
			in.setBackAmount(0.00);
			in.setBackMoney(-cashMoney);
			in.setBackRemark("补贴金额提现");
			in.setCreateTime(System.currentTimeMillis());
			in.setDesc1("3");
			cashBackInfoMapper.insertSelective(in);
			
			MemberGain gain = new MemberGain();
			gain.setId(UUIDUtil.getUUID());
			gain.setMemberId(info.getMemberId());
			gain.setRpType("2");
			gain.setWechatName(info.getWechatName());
			gain.setRpNum(cashMoney/2);
			gain.setSourceId("2");
			gain.setSourceDescribe("补贴提现获得积分");
			gain.setCreatetime(System.currentTimeMillis());
			memberGainMapper.insertSelective(gain);
			
			MemberRecharge save = new MemberRecharge();
			save.setId(UUIDUtil.getUUID());
			save.setMemberId(info.getMemberId());
			save.setRechargeAmount(cashMoney/2);
			save.setRechargeStatus("1");
			save.setCreatetime(System.currentTimeMillis());
			save.setRemark("补贴金额提现到余额");
			save.setMemberName(info.getWechatName());
			save.setDesc1("1");
			memberRechargeMapper.insertSelective(save);
			
		}else{
			rs.setCode("0");
			rs.setError("输入金额有误");
		}
		return rs;
	}

	
	@Override
	public Result selectByOpenid(String id) throws Exception {
		Result rs = Result.getSuccessful();
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(id);
		if(info!=null){
			rs.setData(info);
		}else{
			rs.setCode("12");
		}
		return rs;
	}

	@Override
	public PageTool<MemberInfoResp> select(MemberInfoFindReq req) throws Exception{
		PageTool<MemberInfoResp> page = new PageTool<MemberInfoResp>();
		MemberInfo query = new MemberInfo();
		query.setWechatName(req.getWechatName());
		query.setCellphone(req.getCellphone());
		query.setRpTradeMark(req.getRpTradeMark());
		query.setMemberRank(req.getMemberRank());
		if(req.getPageNo()!=null){
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		List<MemberInfo> list = memberInfoMapper.selectByCondition(query);
		long a = memberInfoMapper.selectBycount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<MemberInfoResp> copyProperties2(List<MemberInfo> list) throws Exception{
		List<MemberInfoResp> resp = new ArrayList<MemberInfoResp>();
		for(MemberInfo info : list){
			MemberInfoResp sp = new MemberInfoResp();
			PropertyUtils.copyProperties(sp, info);
			resp.add(sp);
		}
		return resp;
	}

	@Override
	public Result saveMember(MemberInfoSaveReq req) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(req.getMemberId());
		if(info!=null){
			//用户存在
			rs.setData(info);
		}else{
			//用户不存在
			MemberInfo save = new MemberInfo();
			save.setMemberId(req.getMemberId());
			save.setMemberName(req.getMemberName());
			save.setWechatName(req.getWechatName());
			save.setWechatImg(req.getWechatImg());
			save.setWechat(req.getWechat());
			save.setCity(req.getCity());
			save.setBalance((Double)0.0);//余额
			save.setRedPacket((Double)0.0);//宏包
			save.setRpExchangeRatio((Double)1.0);//兑换比例
			save.setRpTradeMark("0");//宏包交易关闭
			save.setRpListingRatio("*");
			save.setCreatetime(System.currentTimeMillis());
			memberInfoMapper.insertSelective(save);
//			MemberSetting set = new MemberSetting();
//			set.setMemberId(req.getMemberId());
//			memberSettingMapper.insertSelective(set);
			rs.setData(save);
		}
		return rs;
	}

	@Override
	public MemberSetResp findMemberSet(String id) throws Exception{
		MemberSetting set = memberSettingMapper.selectByPrimaryKey(id);
		MemberSetResp resp = new MemberSetResp();
		PropertyUtils.copyProperties(resp, set);
		return resp;
	}

	@Override
	public Result uptMemberSet(MemberSetUptReq req) throws Exception {
		Result rs = Result.getSuccessful();
		MemberSetting upt = new MemberSetting();
		PropertyUtils.copyProperties(upt, req);
		memberSettingMapper.updateByPrimaryKeySelective(upt);
		return rs;
	}

	@Override
	public Result saveHbao(MemberInfoHBaoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(req.getMemberId());
		MemberInfo upt = new MemberInfo();
		upt.setMemberId(req.getMemberId());
		upt.setRedPacket(info.getRedPacket()+req.getRedPacket());
		memberInfoMapper.updateByPrimaryKeySelective(upt);
		//宏包记录
		MemberGainSaveReq save = new MemberGainSaveReq();
		save.setMemberId(req.getMemberId());
		save.setRpNum(req.getRedPacket());
		save.setRpType("2");
		save.setSourceDescribe("商城派送积分");
		save.setSourceId("1");
		memberGainService.save(save);
		return rs;
	}

	@Override
	public Result changeHbao(HbaoPayReq req) throws Exception {
		Result rs = Result.getSuccessful();
		//支付人-买方
		MemberInfo goPay = memberInfoMapper.selectByPrimaryKey(req.getGoPayOpenid());
		//收款放-卖方
		MemberInfo toPay = memberInfoMapper.selectByPrimaryKey(req.getToPayOpenid());
		if(req.getPayNum()>toPay.getRedPacket()){
			rs.setCode("1");
			rs.setError("积分数量不够");
			return rs;
		}
		
		MemberInfo uptgo = new MemberInfo();
		uptgo.setMemberId(goPay.getMemberId());
		uptgo.setRedPacket(goPay.getRedPacket()+req.getPayNum());
		memberInfoMapper.updateByPrimaryKeySelective(uptgo);
		//宏包记录
		MemberGainSaveReq save = new MemberGainSaveReq();
		save.setMemberId(goPay.getMemberId());
		save.setRpNum(req.getPayNum());
		save.setRpType("2");
		save.setSourceDescribe("积分商城购买积分");
		save.setSourceId("1");
		memberGainService.save(save);
		
		MemberInfo uptto = new MemberInfo();
		uptto.setMemberId(toPay.getMemberId());
		uptto.setRedPacket(toPay.getRedPacket()-req.getPayNum());
		uptto.setBalance(toPay.getBalance()+(req.getPayNum()*toPay.getRpExchangeRatio()));
		memberInfoMapper.updateByPrimaryKeySelective(uptto);
		
		//宏包记录
		MemberGainSaveReq save2 = new MemberGainSaveReq();
		save2.setMemberId(toPay.getMemberId());
		save2.setRpNum(req.getPayNum());
		save2.setRpType("2");
		save2.setSourceDescribe("积分商城卖出积分");
		save2.setSourceId("1");
		memberGainService.save(save2);
		return rs;
	}

	@Override
	public Result uptMemberInfo(MemberInfoSaveReq req) throws Exception {
		Result rs = Result.getSuccessful();
		MemberInfo upt = new MemberInfo();
		upt.setMemberId(req.getMemberId());
		upt.setMemberName(req.getMemberName());
		upt.setBirthTime(req.getBirthTime());
		upt.setCellphone(req.getCellphone());
		upt.setRpTradeMark(req.getRpTradeMark());
		upt.setRpExchangeRatio(req.getRpExchangeRatio());
		upt.setCity(req.getCity());
		upt.setMemberRank(req.getMemberRank());
		upt.setRankMoney(req.getRankMoney());
		memberInfoMapper.updateByPrimaryKeySelective(upt);
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(req.getMemberId());
		rs.setData(info);
		return rs;
	}

	@Override
	public Result cashBackUptMember(MemberInfoHBaoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(req.getMemberId());
		if(info != null){
			MemberInfo upt = new MemberInfo();
			upt.setMemberId(req.getMemberId());
//			upt.setBalance(info.getBalance()+req.getCashMoney());
			upt.setCashMoney(info.getCashMoney()+req.getCashMoney());
			memberInfoMapper.updateByPrimaryKeySelective(upt);
		}else{
			rs.setCode("1");
			rs.setError("用户id有误");
		}
		return rs;
	}
	
}
