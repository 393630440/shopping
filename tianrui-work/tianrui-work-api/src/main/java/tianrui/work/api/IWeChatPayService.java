package tianrui.work.api;

import tianrui.work.req.WeChatPayReq;
import tianrui.work.vo.Result;
/***
 * 下单处理
 * @author Administrator
 *
 */
public interface IWeChatPayService {

	public Result save(WeChatPayReq req) throws Exception;
	
	public Result select(String id);
}
