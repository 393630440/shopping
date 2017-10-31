package tianrui.work.api;

import tianrui.work.req.WeChatPayReq;
import tianrui.work.resp.WeChatPayResp;
import tianrui.work.vo.Result;
/***
 * 下单处理
 * @author Administrator
 *
 */
public interface IWeChatPayService {

	public Result save(WeChatPayReq req) throws Exception;
	
	public WeChatPayResp select(String id) throws Exception;
	//修改支付状态
	public void uptPayStatus(String id);
}
