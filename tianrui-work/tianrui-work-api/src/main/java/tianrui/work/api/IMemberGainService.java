package tianrui.work.api;

import tianrui.work.req.gain.MemberGainFindReq;
import tianrui.work.req.gain.MemberGainSaveReq;
import tianrui.work.resp.gain.MemberGainResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface IMemberGainService {
	/** 添加消费记录*/
	public Result save(MemberGainSaveReq req)throws Exception;
	/** 查询消费记录*/
	public PageTool<MemberGainResp> select(MemberGainFindReq req)throws Exception;
}
