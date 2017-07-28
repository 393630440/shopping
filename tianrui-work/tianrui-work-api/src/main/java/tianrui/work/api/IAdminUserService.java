package tianrui.work.api;

import tianrui.work.req.admin.user.UserSaveReq;
import tianrui.work.req.admin.user.UserFindReq;
import tianrui.work.req.admin.user.UserLoginReq;
import tianrui.work.resp.admin.user.UserFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**后台用户管理*/
public interface IAdminUserService {

	/** 用户登录*/
	public Result loginIn(UserLoginReq req)throws Exception;
	/** 添加用户*/
	public Result saveUser(UserSaveReq req)throws Exception;
	/** 删除用户*/
	public Result delete(String id)throws Exception;
	/** 查询用户列表*/
	public PageTool<UserFindResp> select(UserFindReq req)throws Exception;

}
