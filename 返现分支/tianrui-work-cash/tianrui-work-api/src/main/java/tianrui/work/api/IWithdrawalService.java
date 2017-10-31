package tianrui.work.api;

import tianrui.work.req.WithdrawalFindReq;
import tianrui.work.req.WithdrawalReq;
import tianrui.work.resp.WithdrawalResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface IWithdrawalService {

	/** 提现申请
	 * @throws Exception */
	public Result save(WithdrawalReq req) throws Exception;
	/** 提现查询*/
	public PageTool<WithdrawalResp> select(WithdrawalFindReq req)throws Exception;
	/** 提现审核*/
	public Result audit(String id)throws Exception;
	/** 查询提现申请*/
	public Result findId(String id)throws Exception;
} 
