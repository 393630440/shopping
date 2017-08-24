package tianrui.work.api;

import tianrui.work.req.massage.MessageReq;
import tianrui.work.vo.Result;
/**
 * 模板消息推送管理
 * @author jh
 *
 */
public interface IWeChatMassageService {

	public Result saveMassage(MessageReq req);
}
