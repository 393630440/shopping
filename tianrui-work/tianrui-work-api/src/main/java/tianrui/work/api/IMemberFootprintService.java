package tianrui.work.api;

import tianrui.work.req.foot.MemberFootprintFindReq;
import tianrui.work.req.foot.MemberFootprintSaveReq;
import tianrui.work.resp.foot.MemberFootprintResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/** 用户浏览足迹 */
public interface IMemberFootprintService {
	/** 添加足迹 */
	Result save(MemberFootprintSaveReq req) throws Exception;

	/** 查询足迹 */
	PageTool<MemberFootprintResp> select(MemberFootprintFindReq req) throws Exception;

	/** 查询足迹 */
	MemberFootprintResp queryByOne(MemberFootprintSaveReq req) throws Exception;

	/** 删除足迹 */
	Result deleteByOne(String id) throws Exception;

	/** 编辑足迹 */
	Result edit(MemberFootprintSaveReq req) throws Exception;
}
