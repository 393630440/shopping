package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.ICashBackService;
import tianrui.work.bean.CashBack;
import tianrui.work.bean.CashBackInfo;
import tianrui.work.mapper.java.CashBackInfoMapper;
import tianrui.work.mapper.java.CashBackMapper;
import tianrui.work.req.cash.CashBackInfoReq;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.resp.cash.CashBackInfoResp;
import tianrui.work.resp.cash.CashBackResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class CashBackService implements ICashBackService{

	@Autowired
	CashBackMapper cashBackMapper;
	@Autowired
	CashBackInfoMapper cashBackInfoMapper;
	
	@Override
	public Result addCashBack(CashBackReq req) throws Exception {
		Result rs = Result.getSuccessful();
		CashBack save = new CashBack();
		PropertyUtils.copyProperties(save, req);
		save.setId(UUIDUtil.getUUID());
		save.setCreateTime(System.currentTimeMillis());
		cashBackMapper.insertSelective(save);
		return rs;
	}

	@Override
	public PageTool<CashBackResp> queryCashBack(CashBackReq req) throws Exception {
		PageTool<CashBackResp> page = new PageTool<CashBackResp>();
		CashBack query = new CashBack();
		if(req.getPageNo() != null){
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		query.setCashMember(req.getCashMember());
		query.setCashMemberName(req.getCashMemberName());
		query.setCashType(req.getCashType());
		List<CashBack> list = cashBackMapper.selectByCondition(query);
		long a = cashBackMapper.selectByCount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<CashBackResp> copyProperties2(List<CashBack> list) throws Exception{
		List<CashBackResp> resp = new ArrayList<CashBackResp>();
		for(CashBack bk : list){
			CashBackResp sp = new CashBackResp();
			PropertyUtils.copyProperties(sp, bk);
			resp.add(sp);
		}
		return resp;
	}

	@Override
	public Result addBankInfo(CashBackInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		CashBackInfo save = new CashBackInfo();
		PropertyUtils.copyProperties(save, req);
		save.setId(UUIDUtil.getUUID());
		save.setCreateTime(System.currentTimeMillis());
		cashBackInfoMapper.insertSelective(save);
		return rs;
	}

	@Override
	public PageTool<CashBackInfoResp> queryCashBack(CashBackInfoReq req) throws Exception {
		PageTool<CashBackInfoResp> page = new PageTool<CashBackInfoResp>();
		CashBackInfo query = new CashBackInfo();
		if(req.getPageNo()!= null){
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		query.setCashBackId(req.getCashBackId());
		query.setMemberId(req.getMemberId());
		query.setMemberName(req.getMemberName());
		List<CashBackInfo> list = cashBackInfoMapper.selectByCondition(query);
		long a = cashBackInfoMapper.selectByCount(query);
		page.setList(copyPropertieInfo(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<CashBackInfoResp> copyPropertieInfo(List<CashBackInfo> list) throws Exception {
		List<CashBackInfoResp> resp = new ArrayList<CashBackInfoResp>();
		for(CashBackInfo info : list){
			CashBackInfoResp sp = new CashBackInfoResp();
			PropertyUtils.copyProperties(sp, info);
			resp.add(sp);
		}
		return resp;
	}

}
