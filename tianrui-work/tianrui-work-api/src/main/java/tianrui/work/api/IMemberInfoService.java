package tianrui.work.api;

import tianrui.work.req.HbaoPayReq;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.req.member.MemberInfoHBaoReq;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.req.member.MemberSetUptReq;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.resp.member.MemberSetResp;
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
	/** 查询用户消息推送配置
	 * @throws Exception */
	public MemberSetResp findMemberSet(String id) throws Exception;
	/** 修改用户消息推送配置*/
	public Result uptMemberSet(MemberSetUptReq req)throws Exception;
	/** 发送宏包*/
	public Result saveHbao(MemberInfoHBaoReq req)throws Exception;
	/** 宏包交易*/
	public Result changeHbao(HbaoPayReq req)throws Exception;
}
