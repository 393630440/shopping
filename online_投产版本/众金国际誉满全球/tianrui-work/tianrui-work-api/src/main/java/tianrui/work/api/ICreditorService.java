package tianrui.work.api;

import tianrui.work.req.creditor.CreditorFindReq;
import tianrui.work.req.creditor.CreditorSaveReq;
import tianrui.work.req.creditor.CreditorUpdateReq;
import tianrui.work.resp.creditor.CreditorFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**
 * 债权发布接口
 * @author Administrator
 *
 */
public interface ICreditorService {
	/**
	 * 发布债权信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	Result creditorSave(CreditorSaveReq req) throws Exception;
	/**
	 * 修改债权信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	Result creditorUpdate(CreditorUpdateReq req)throws Exception;
	/**
	 * 作废、删除债权信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Result creditorDelete(String id)throws Exception;
	/**
	 * 查询债权信息借口
	 * @param req
	 * @return
	 * @throws Exception
	 */
	PageTool<CreditorFindResp> creditorFind(CreditorFindReq req)throws Exception;
}
