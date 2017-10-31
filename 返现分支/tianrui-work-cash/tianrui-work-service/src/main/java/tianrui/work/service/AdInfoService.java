package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IAdInfoService;
import tianrui.work.bean.AdInfo;
import tianrui.work.mapper.java.AdInfoMapper;
import tianrui.work.req.ad.AdInfoFindReq;
import tianrui.work.req.ad.AdInfoReq;
import tianrui.work.resp.ad.AdInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**
 * 广告信息
 * 
 * @author Joe
 *
 */
@Service
public class AdInfoService implements IAdInfoService {

	@Autowired
	AdInfoMapper adInfoMapper;

	@Override
	public Result addAdInfo(AdInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		AdInfo record = new AdInfo();
		PropertyUtils.copyProperties(record, req);
		adInfoMapper.insertSelective(record);
		req.setId(record.getId());
		return rs;
	}

	@Override
	public Result editAdInfo(AdInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		AdInfo record = new AdInfo();
		PropertyUtils.copyProperties(record, req);
		adInfoMapper.updateByPrimaryKeySelective(record);
		return rs;
	}

	@Override
	public List<AdInfoResp> getAdInfoList(AdInfoReq req) throws Exception {
		AdInfo record = new AdInfo();
		PropertyUtils.copyProperties(record, req);

		List<AdInfoResp> resp = new ArrayList<AdInfoResp>();
		List<AdInfo> list = adInfoMapper.selectList(record);
		for (AdInfo bean : list) {
			AdInfoResp sp = new AdInfoResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		return resp;
	}

	@Override
	public AdInfoResp queryAdInfoByOne(Integer id) throws Exception {
		AdInfo record = adInfoMapper.selectByPrimaryKey(id);
		AdInfoResp resp = new AdInfoResp();
		PropertyUtils.copyProperties(resp, record);
		return resp;
	}

	@Override
	public PageTool<AdInfoResp> queryAdInfoByList(AdInfoFindReq req) throws Exception {
		PageTool<AdInfoResp> page = new PageTool<AdInfoResp>();
		AdInfo find = new AdInfo();
		if (req.getPageNo() != null) {
			find.setPageNo(req.getPageSize() * req.getPageNo());
			find.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}

		find.setDepict(req.getDepict());
		find.setStatus(req.getStatus());
		find.setType(req.getType());

		List<AdInfo> list = adInfoMapper.selectByAdInfo(find);
		long a = adInfoMapper.selectBycount(find);

		List<AdInfoResp> resp = new ArrayList<AdInfoResp>();
		for (AdInfo bean : list) {
			AdInfoResp sp = new AdInfoResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		page.setList(resp);
		page.setTotal(a);

		return page;
	}

}
