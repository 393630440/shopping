package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IWithdrawalService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.Withdrawal;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.WithdrawalMapper;
import tianrui.work.req.WithdrawalFindReq;
import tianrui.work.req.WithdrawalReq;
import tianrui.work.resp.WithdrawalResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class WithdrawalService implements IWithdrawalService{

	@Autowired
	WithdrawalMapper withdrawalMapper;
	@Autowired
	MemberInfoMapper memberInfoMapper;
	
	@Override
	public Result save(WithdrawalReq req) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(req.getMemberId());
		if(req.getWithdrawalAmount()>info.getBalance()){
			rs.setCode("1");
			rs.setError("提现超额");
			return rs;
		}
		Withdrawal query = new Withdrawal();
		query.setMemberId(req.getMemberId());
		query.setWithdrawalStatus("0");
		List<Withdrawal> list = withdrawalMapper.selectByCondition(query);
		if(list.size()==0){
			Withdrawal save = new Withdrawal();
			PropertyUtils.copyProperties(save, req);
			save.setId(UUIDUtil.getUUID());
			save.setWithdrawalStatus("0");
			save.setWithdrawalAmount(req.getWithdrawalAmount()*0.99);
			save.setCreatetime(System.currentTimeMillis());
			withdrawalMapper.insertSelective(save);
			MemberInfo upt = new MemberInfo();
			upt.setMemberId(info.getMemberId());
			upt.setBalance(info.getBalance()-req.getWithdrawalAmount());
			memberInfoMapper.updateByPrimaryKeySelective(upt);
			
		}else{
			rs.setCode("1");
			rs.setError("有提现中订单");
			return rs;
		}
		return rs;
	}

	@Override
	public PageTool<WithdrawalResp> select(WithdrawalFindReq req) throws Exception {
		PageTool<WithdrawalResp> page = new PageTool<WithdrawalResp>();
		Withdrawal query = new Withdrawal();
		query.setMemberId(req.getMemberId());
		query.setMemberName(req.getMemberName());
		query.setWithdrawalStatus(req.getWithdrawalStatus());
		if(req.getPageNo()!=null){
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}
		List<Withdrawal> list = withdrawalMapper.selectByCondition(query);
	    long a = withdrawalMapper.selectBycount(query);
		page.setList(copyProperties2(list));
	    page.setTotal(a);
	    return page;
	}

	protected List<WithdrawalResp> copyProperties2(List<Withdrawal> list) throws Exception {
		List<WithdrawalResp> resp = new ArrayList<WithdrawalResp>();
		for(Withdrawal rew : list){
			WithdrawalResp sp = new WithdrawalResp();
			PropertyUtils.copyProperties(sp, rew);
			resp.add(sp);
		}
		return resp;
	}
	
	@Override
	public Result findId(String id) throws Exception {
		Result rs = Result.getSuccessful();
		Withdrawal draw = withdrawalMapper.selectByPrimaryKey(id);
		rs.setData(draw);
		return rs;
	}

	@Override
	public Result audit(String id) throws Exception {
		Result rs = Result.getSuccessful();
		Withdrawal draw = withdrawalMapper.selectByPrimaryKey(id);
		MemberInfo info = memberInfoMapper.selectByPrimaryKey(draw.getMemberId());
		if(draw.getWithdrawalStatus().equals("0")){
			if((info.getBalance()-draw.getWithdrawalAmount())<0){
				rs.setCode("1");
				rs.setError("提现超额");
				return rs;
			}else{
				draw.setWithdrawalStatus("1");
				withdrawalMapper.updateByPrimaryKeySelective(draw);
			}	
		}else{
			rs.setCode("1");
			rs.setError("已处理过数据");
		}
		return rs;
	}

}
