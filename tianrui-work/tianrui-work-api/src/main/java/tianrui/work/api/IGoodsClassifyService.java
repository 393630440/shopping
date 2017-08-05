package tianrui.work.api;

import java.util.List;

import tianrui.work.req.goods.GoodsClassifyFindReq;
import tianrui.work.req.goods.GoodsClassifyReq;
import tianrui.work.resp.goods.GoodsClassifyFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**
 * 商品分类信息
 * 
 * @author Joe
 *
 */
public interface IGoodsClassifyService {

	/** 添加商品分类 */
	Result addGoodsClassify(GoodsClassifyReq req) throws Exception;

	/** 编辑商品分类信息 */
	Result editGoodsClassify(GoodsClassifyReq req) throws Exception;

	/** 查询商品分类信息 */
	GoodsClassifyFindResp queryGoodsClassify(GoodsClassifyReq req) throws Exception;

	/** 列表查询商品分类信息 */
	PageTool<GoodsClassifyFindResp> queryGoodsClassifyByList(GoodsClassifyFindReq req) throws Exception;

	/** 查询商品分类集合信息 */
	List<GoodsClassifyFindResp> getGoodsClassifyList() throws Exception;

}
