package tianrui.work.api;

import java.util.List;

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
public interface IGoodsInfoService {

	/** 添加商品 */
	Result addGoodsInfo(GoodsInfoReq req) throws Exception;

	/** 编辑商品信息 */
	Result editGoodsInfo(GoodsInfoReq req) throws Exception;

	/** 查询商品信息 */
	GoodsInfoFindResp queryGoodsInfoByOne(String goodsId, String memberRank) throws Exception;

	/** 列表查询商品信息 */
	PageTool<GoodsInfoFindResp> queryGoodsInfoByList(GoodsInfoFindReq req, String memberRank) throws Exception;

	/** 查询商品集合信息 */
	List<GoodsInfoFindResp> getGoodsInfoList(GoodsInfoFindReq req, String memberRank) throws Exception;

}
