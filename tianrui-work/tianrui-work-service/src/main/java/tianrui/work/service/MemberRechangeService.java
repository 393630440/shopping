package tianrui.work.service;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberRechangeService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.MemberRecharge;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.MemberRechargeMapper;
import tianrui.work.req.rechange.MemberRechargeReq;
import tianrui.work.req.rechange.RechargeFindReq;
import tianrui.work.resp.rechange.MemberRechargeResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class MemberRechangeService implements IMemberRechangeService {

	@Autowired
	MemberRechargeMapper memberRechargeMapper;
	@Autowired
	MemberInfoMapper memberInfoMapper;
	
	@Override
	public Result save(MemberRechargeReq req) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info= memberInfoMapper.selectByPrimaryKey(req.getMemberId());
		if(info!=null){
			MemberRecharge save = new MemberRecharge();
			save.setId(UUIDUtil.getUUID());
			save.setMemberId(req.getMemberId());
			save.setRechargeAmount(req.getRechargeAmount());
			save.setRechargeStatus("1");
			save.setCreatetime(System.currentTimeMillis());
			save.setRemark(req.getRemark());
			save.setMemberName(info.getWechatName());
			save.setDesc1(req.getDesc1());
			memberRechargeMapper.insertSelective(save);
			if(StringUtils.equals("1", req.getDesc1())){
				info.setBalance(info.getBalance()+req.getRechargeAmount());
				memberInfoMapper.updateByPrimaryKeySelective(info);
			}
		}else{
			rs.setCode("1");
			rs.setError("未找到用户");
		}
		return rs;
	}

	@Override
	public PageTool<MemberRechargeResp> select(RechargeFindReq req) throws Exception{
		PageTool<MemberRechargeResp> page = new PageTool<MemberRechargeResp>();
		MemberRecharge query = new MemberRecharge();
		query.setMemberId(req.getMemberId());
		if(req.getPageNo()!=null){
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		List<MemberRecharge> list = memberRechargeMapper.selectByCondition(query);
		long a = memberRechargeMapper.selectBycount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<MemberRechargeResp> copyProperties2(List<MemberRecharge> list) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<MemberRechargeResp> resp = new ArrayList<MemberRechargeResp>();
		for(MemberRecharge rec : list){
			MemberRechargeResp sp = new MemberRechargeResp();
			PropertyUtils.copyProperties(sp, rec);
			resp.add(sp);
		}
		return resp;
	}

	@Override
	public Result upt(MemberRechargeReq req) throws Exception{
		// TODO Auto-generated method stub
		MemberRecharge upt = new MemberRecharge();
		
		memberRechargeMapper.updateByPrimaryKeySelective(upt);
		return null;
	}

}
