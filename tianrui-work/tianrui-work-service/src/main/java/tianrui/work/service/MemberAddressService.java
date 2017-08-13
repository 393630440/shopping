package tianrui.work.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberAddressService;
import tianrui.work.bean.MemberAddressNew;
import tianrui.work.mapper.java.MemberAddressNewMapper;
import tianrui.work.req.address.AddressFindReq;
import tianrui.work.req.address.AddressSaveReq;
import tianrui.work.resp.address.AddressResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class MemberAddressService implements IMemberAddressService{

	@Autowired
	MemberAddressNewMapper memberAddressMapper;
	
	@Override
	public Result save(AddressSaveReq req) throws Exception {
		Result rs = Result.getSuccessful();
		MemberAddressNew save = new MemberAddressNew();
		PropertyUtils.copyProperties(save, req);
		save.setId(UUIDUtil.getUUID());
		memberAddressMapper.insertSelective(save);
		return rs;
	}

	@Override
	public Result delete(String id) throws Exception{
		Result rs = Result.getSuccessful();
		memberAddressMapper.deleteByPrimaryKey(id);
		return rs;
	}

	@Override
	public PageTool<AddressResp> select(AddressFindReq req) throws Exception{
		PageTool<AddressResp> page = new PageTool<AddressResp>();
		MemberAddressNew query = new MemberAddressNew();
		query.setMemberId(req.getMemberId());
		if(req.getPageNo()!=null){
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}
		List<MemberAddressNew> list = memberAddressMapper.selectByCondition(query);
		long a = memberAddressMapper.selectBycount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<AddressResp> copyProperties2(List<MemberAddressNew> list) throws Exception{
		List<AddressResp> resp = new ArrayList<AddressResp>();
		for(MemberAddressNew add : list){
			AddressResp ress = new AddressResp();
			PropertyUtils.copyProperties(ress, add);
			resp.add(ress);
		}
		return resp;
	}

	@Override
	public Result only(String id, String memberId) throws Exception {
		Result rs = Result.getSuccessful();
		MemberAddressNew query = new MemberAddressNew();
		query.setMemberId(memberId);
		List<MemberAddressNew> list = memberAddressMapper.selectByCondition(query);
		for(MemberAddressNew ne : list){
			ne.setIsDefault("0");
			memberAddressMapper.updateByPrimaryKeySelective(ne);
		}
		MemberAddressNew upt = new MemberAddressNew();
		upt.setId(id);
		upt.setIsDefault("1");
		memberAddressMapper.updateByPrimaryKeySelective(upt);
		return rs;
	}


}
