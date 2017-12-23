package tianrui.work.api;

import tianrui.work.req.related.MemberRelatedReq;
import tianrui.work.resp.related.MemberRelatedResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface IMemberReleteService {

	/** 建立用户关系*/
	Result saveMemberRelete(String fatherId,String memberId);
	/** 获取父级用户*/
	Result getFatherMember(String id);
	
	public PageTool<MemberRelatedResp> select(MemberRelatedReq req)throws Exception;
}
