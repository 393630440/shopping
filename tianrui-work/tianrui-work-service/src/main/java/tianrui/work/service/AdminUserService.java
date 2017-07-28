package tianrui.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IAdminUserService;
import tianrui.work.bean.AdminUser;
import tianrui.work.mapper.java.AdminUserMapper;
import tianrui.work.req.admin.user.UserFindReq;
import tianrui.work.req.admin.user.UserLoginReq;
import tianrui.work.req.admin.user.UserSaveReq;
import tianrui.work.resp.admin.user.UserFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;
@Service
public class AdminUserService implements IAdminUserService{

	@Autowired
	AdminUserMapper adminUserMapper;
	
	@Override
	public Result loginIn(UserLoginReq req) throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Result saveUser(UserSaveReq req) throws Exception {
		// TODO Auto-generated method stub
		Result rs = Result.getSuccessful();
		AdminUser user = new AdminUser();
		user.setId(UUIDUtil.getUUID());
		user.setPassword("666666");
		user.setLogintime(System.currentTimeMillis());
		user.setCreatetime(System.currentTimeMillis());
		user.setAcountStatus("1");
		adminUserMapper.insertSelective(user);
		return rs;
	}

	@Override
	public Result delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageTool<UserFindResp> select(UserFindReq req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
