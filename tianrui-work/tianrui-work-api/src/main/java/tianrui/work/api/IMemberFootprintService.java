package tianrui.work.api;

import tianrui.work.req.foot.MemberFootprintFindReq;
import tianrui.work.req.foot.MemberFootprintSaveReq;
import tianrui.work.resp.foot.MemberFootprintResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
/** 用户浏览足迹*/
public interface IMemberFootprintService {
	/** 添加足迹*/
	public Result save(MemberFootprintSaveReq req)throws Exception;
	/** 查询足迹*/
	public PageTool<MemberFootprintResp> select(MemberFootprintFindReq req)throws Exception;
}
