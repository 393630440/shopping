package tianrui.work.api;

import tianrui.work.req.cash.CashBackInfoReq;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.resp.cash.CashBackInfoResp;
import tianrui.work.resp.cash.CashBackResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface ICashBackService {

	/** 添加返现 */
	Result addCashBack(CashBackReq req) throws Exception;
	/** 添加返现明细*/
	Result addBankInfo(CashBackInfoReq req)throws Exception;
	/** 列表返现 */
	PageTool<CashBackResp> queryCashBack(CashBackReq req) throws Exception;
	/** 列表明细*/
	PageTool<CashBackInfoResp> queryCashBack(CashBackInfoReq req) throws Exception;

}
