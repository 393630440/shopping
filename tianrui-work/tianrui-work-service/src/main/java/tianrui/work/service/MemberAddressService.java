package tianrui.work.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberAddressService;
import tianrui.work.bean.MemberAddress;
import tianrui.work.mapper.java.MemberAddressMapper;
import tianrui.work.req.address.AddressFindReq;
import tianrui.work.req.address.AddressSaveReq;
import tianrui.work.resp.address.AddressResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Service
public class MemberAddressService implements IMemberAddressService{

	@Autowired
	MemberAddressMapper memberAddressMapper;
	
	@Override
	public Result save(AddressSaveReq req) throws Exception {
		Result rs = Result.getSuccessful();
		MemberAddress save = new MemberAddress();
		PropertyUtils.copyProperties(save, req);
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
		MemberAddress query = new MemberAddress();
		query.setMemberId(req.getMemberId());
		if(req.getPageNo()!=null){
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}
		List<MemberAddress> list = memberAddressMapper.selectByCondition(query);
		long a = memberAddressMapper.selectBycount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<AddressResp> copyProperties2(List<MemberAddress> list) throws Exception{
		List<AddressResp> resp = new ArrayList<AddressResp>();
		for(MemberAddress add : list){
			AddressResp ress = new AddressResp();
			PropertyUtils.copyProperties(ress, add);
			resp.add(ress);
		}
		return resp;
	}

}
