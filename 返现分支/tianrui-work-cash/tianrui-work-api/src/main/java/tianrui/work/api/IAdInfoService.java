package tianrui.work.api;

import java.util.List;

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
public interface IAdInfoService {

	/** 添加广告 */
	Result addAdInfo(AdInfoReq req) throws Exception;

	/** 编辑广告信息 */
	Result editAdInfo(AdInfoReq req) throws Exception;

	/** 查询广告信息 */
	AdInfoResp queryAdInfoByOne(Integer id) throws Exception;

	/** 列表查询广告信息 */
	PageTool<AdInfoResp> queryAdInfoByList(AdInfoFindReq req) throws Exception;

	/** 查询广告集合信息 */
	List<AdInfoResp> getAdInfoList(AdInfoReq req) throws Exception;

}
