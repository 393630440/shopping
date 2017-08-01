package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberFootprintService;
import tianrui.work.bean.MemberFootprint;
import tianrui.work.mapper.java.MemberFootprintMapper;
import tianrui.work.req.foot.MemberFootprintFindReq;
import tianrui.work.req.foot.MemberFootprintSaveReq;
import tianrui.work.resp.foot.MemberFootprintResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class MemberFootprintService implements IMemberFootprintService{

	@Autowired
	MemberFootprintMapper memberFootprintMapper;
	
	@Override
	public Result save(MemberFootprintSaveReq req) throws Exception {
		Result rs = Result.getSuccessful();
		MemberFootprint query = new MemberFootprint();
		query.setMemberId(req.getMemberId());
		query.setGoodsId(req.getGoodsId());
		query.setFfType(req.getFfType());
		List<MemberFootprint> list = memberFootprintMapper.selectByCondition(query);
		for(MemberFootprint delt : list){
			memberFootprintMapper.deleteByPrimaryKey(delt.getId());
		}
		MemberFootprint save = new MemberFootprint();
		PropertyUtils.copyProperties(save, req);
		save.setId(UUIDUtil.getUUID());
		save.setCreatetime(System.currentTimeMillis());
		memberFootprintMapper.insertSelective(save);
		return rs;
	}

	@Override
	public PageTool<MemberFootprintResp> select(MemberFootprintFindReq req) throws Exception {
		PageTool<MemberFootprintResp> page = new PageTool<MemberFootprintResp>();
		MemberFootprint query = new MemberFootprint();
		if(req.getPageNo()!=null){
			page.setPageNo(req.getPageNo()*req.getPageSize());
			page.setPageSize(req.getPageSize());
		}
		query.setMemberId(req.getMemberId());
		query.setFfType(req.getFfType());
		List<MemberFootprint> list = memberFootprintMapper.selectByCondition(query);
		long a = memberFootprintMapper.selectBycount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<MemberFootprintResp> copyProperties2(List<MemberFootprint> list) throws Exception{
		List<MemberFootprintResp> resp = new ArrayList<MemberFootprintResp>();
		for(MemberFootprint mf : list){
			MemberFootprintResp sp = new MemberFootprintResp();
			PropertyUtils.copyProperties(sp, mf);
			resp.add(sp);
		}
		return resp;
	}

}
