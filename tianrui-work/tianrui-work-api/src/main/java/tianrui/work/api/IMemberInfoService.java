package tianrui.work.api;

import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface IMemberInfoService {

	/** openid判断用户是否存在
	 * @throws Exception */
	public MemberInfoResp selectByOpenid(String id) throws Exception;
	/** 查询用户*/
	public PageTool<MemberInfoResp> select(MemberInfoFindReq req)throws Exception;
	/** 添加用户*/
	public Result saveMember(MemberInfoSaveReq req)throws Exception;
}