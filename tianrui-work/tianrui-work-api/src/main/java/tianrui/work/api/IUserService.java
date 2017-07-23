package tianrui.work.api;

import tianrui.work.req.LoginReq;
import tianrui.work.req.ResistReq;
import tianrui.work.vo.Result;

public interface IUserService {
	
	/** 微信登录接口*/
	Result wxLogin(LoginReq req)throws Exception;
	/** 普通登录接口*/
	Result login(LoginReq req) throws Exception;
	/** 注册接口
	 * @throws Exception */
	Result regist(ResistReq req) throws Exception;

}
