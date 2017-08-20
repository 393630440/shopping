package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberGainService;
import tianrui.work.bean.MemberGain;
import tianrui.work.mapper.java.MemberGainMapper;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.req.gain.MemberGainFindReq;
import tianrui.work.req.gain.MemberGainSaveReq;
import tianrui.work.resp.gain.MemberGainResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class MemberGainService implements IMemberGainService{

	@Autowired
	MemberGainMapper memberGainMapper;
	@Autowired
	MemberInfoMapper memberInfoMapper;
	
	@Override
	public Result save(MemberGainSaveReq req) throws Exception{
		Result rs = Result.getSuccessful();
		MemberGain save = new MemberGain();
		PropertyUtils.copyProperties(save, req);
		save.setId(UUIDUtil.getUUID());
		save.setCreatetime(System.currentTimeMillis());
		memberGainMapper.insertSelective(save);
		return rs;
	}

	@Override
	public PageTool<MemberGainResp> select(MemberGainFindReq req) throws Exception{
		PageTool<MemberGainResp> page = new PageTool<MemberGainResp>();
		MemberGain query = new MemberGain();
		if(req.getPageNo()!=null){
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}
		query.setMemberId(req.getMemberId());
		query.setRpType(req.getRpType());
		List<MemberGain> list = memberGainMapper.selectByCondition(query);
		long a = memberGainMapper.selectBycount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<MemberGainResp> copyProperties2(List<MemberGain> list)throws Exception {
		List<MemberGainResp> resp = new ArrayList<MemberGainResp>();
		for(MemberGain gain : list){
			MemberGainResp sp = new MemberGainResp();
			PropertyUtils.copyProperties(sp, gain);
			resp.add(sp);
		}
		return resp;
	}

}
