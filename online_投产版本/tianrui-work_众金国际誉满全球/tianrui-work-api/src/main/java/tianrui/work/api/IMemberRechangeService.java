package tianrui.work.api;

import tianrui.work.req.rechange.MemberRechargeReq;
import tianrui.work.req.rechange.RechargeFindReq;
import tianrui.work.resp.rechange.MemberRechargeResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface IMemberRechangeService {

	public Result save(MemberRechargeReq req) throws Exception;
	
	public PageTool<MemberRechargeResp> select(RechargeFindReq req)throws Exception;
	/** 充值*/
	public Result upt(MemberRechargeReq req)throws Exception;
}
