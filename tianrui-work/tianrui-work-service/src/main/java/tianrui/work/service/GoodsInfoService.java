package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IGoodsInfoService;
import tianrui.work.bean.GoodsInfo;
import tianrui.work.mapper.java.GoodsInfoMapper;
import tianrui.work.req.goods.GoodsInfoFindReq;
import tianrui.work.req.goods.GoodsInfoReq;
import tianrui.work.resp.goods.GoodsInfoFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**
 * 商品信息
 * 
 * @author Joe
 *
 */
@Service
public class GoodsInfoService implements IGoodsInfoService {

	@Autowired
	GoodsInfoMapper goodsInfoMapper;

	@Override
	public Result addGoodsInfo(GoodsInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		GoodsInfo record = new GoodsInfo();
		PropertyUtils.copyProperties(record, req);
		goodsInfoMapper.insert(record);
		return rs;
	}

	@Override
	public Result editGoodsInfo(GoodsInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		GoodsInfo record = new GoodsInfo();
		PropertyUtils.copyProperties(record, req);
		goodsInfoMapper.updateByPrimaryKey(record);
		return rs;
	}

	@Override
	public GoodsInfoFindResp queryGoodsInfo(GoodsInfoReq req) throws Exception {
		return null;
	}

	@Override
	public PageTool<GoodsInfoFindResp> queryGoodsInfoByList(GoodsInfoFindReq req) throws Exception {
		PageTool<GoodsInfoFindResp> page = new PageTool<GoodsInfoFindResp>();
		GoodsInfo find = new GoodsInfo();
		if (req.getPageNo() != null) {
			find.setPageNo(req.getPageSize() * req.getPageNo());
			find.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}

		find.setClassifyName(req.getClassifyName());
		find.setGoodsName(req.getGoodsName());
		find.setGoodsStatus(req.getGoodsStatus());
		find.setGoodsType(req.getGoodsType());

		List<GoodsInfo> list = goodsInfoMapper.selectByGoodsInfo(find);
		long a = goodsInfoMapper.selectBycount(find);

		List<GoodsInfoFindResp> resp = new ArrayList<GoodsInfoFindResp>();
		for (GoodsInfo bean : list) {
			GoodsInfoFindResp sp = new GoodsInfoFindResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		page.setList(resp);
		page.setTotal(a);

		return page;
	}

}
