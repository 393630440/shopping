package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberGainService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.MemberSetting;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.MemberSettingMapper;
import tianrui.work.req.gain.MemberGainSaveReq;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.req.member.MemberInfoHBaoReq;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.req.member.MemberSetUptReq;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.resp.member.MemberSetResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Service
public class MemberInfoService implements IMemberInfoService{

	@Autowired
	MemberInfoMapper memberInfoMapper;
	@Autowired
	MemberSettingMapper memberSettingMapper;
	@Autowired
	IMemberGainService memberGainService;
	
	@Override
	public MemberInfoResp selectByOpenid(String id) throws Exception {
		MemberInfoResp resp = null;
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(id);
		if(info!=null){
			resp = new MemberInfoResp();
			PropertyUtils.copyProperties(resp, info);
		}
		return resp;
	}

	@Override
	public PageTool<MemberInfoResp> select(MemberInfoFindReq req) throws Exception{
		PageTool<MemberInfoResp> page = new PageTool<MemberInfoResp>();
		MemberInfo query = new MemberInfo();
		query.setWechatName(req.getWechatName());
		query.setCellphone(req.getCellphone());
		query.setRpTradeMark(req.getRpTradeMark());
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
			MemberSetting set = new MemberSetting();
			set.setMemberId(req.getMemberId());
			memberSettingMapper.insertSelective(set);
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
		save.setSourceDescribe("商城派送宏包");
		save.setSourceId("1");
		memberGainService.save(save);
		return rs;
	}

}
