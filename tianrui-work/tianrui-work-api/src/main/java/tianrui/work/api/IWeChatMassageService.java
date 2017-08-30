package tianrui.work.api;

import tianrui.work.req.massage.MessageReq;
/**
 * 模板消息推送管理
 * @author jh
 *
 */
public interface IWeChatMassageService {

	public void saveMassage(MessageReq req);
}
