package tianrui.work.api;

import java.util.List;

import tianrui.work.req.cash.CashBackInfoReq;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.req.cash.MemberCashBackReq;
import tianrui.work.resp.cash.CashBackInfoResp;
import tianrui.work.resp.cash.CashBackResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface ICashBackService {

	/** 用户返现 */
	Result memberCashBack(MemberCashBackReq req) throws Exception;
	
	/** 添加返现任务 */
	Result addCashBack(CashBackReq req) throws Exception;
	/** 添加返现金额
	 * @throws Exception */
	Result addCashBackInfo(CashBackInfoReq req) throws Exception;

	/** 列表返现 */
	PageTool<CashBackResp> queryCashBack(CashBackReq req) throws Exception;

	/** 列表明细 */
	PageTool<CashBackInfoResp> queryCashBackInfo(CashBackInfoReq req) throws Exception;

	/** 列表返现 */
	List<CashBackResp> queryCashBackList(CashBackReq req) throws Exception;

	/** 列表明细 */
	List<CashBackInfoResp> queryCashBackInfoList(CashBackInfoReq req) throws Exception;

	/** 累计收益 */
	String getTotalEarnings(String memberId) throws Exception;

	/** 今日收益 */
	String getTodayEarnings(String memberId) throws Exception;

	/**
	 * 返现每日定时任务
	 * 
	 * @throws Exception
	 */
	void cashQuart() throws Exception;

}
