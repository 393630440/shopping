package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
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
		Result rs = Result.getSuccessful();
		AdminUser user = new AdminUser();
		user.setAcount(req.getAcount());
		user.setPassword(req.getPassword());
		List<AdminUser> list = adminUserMapper.selectByCondition(user);
		if(list.size()==1){
			//登录成功
			rs.setData(list.get(0));
			changeLogin(list.get(0));
		}else {
			rs.setCode("1");
			rs.setError("用户名或密码错误");
		}
		return rs;
	}
	/**登录成功修改用户登录记录*/
	protected void changeLogin(AdminUser upt) {
		upt.setLoginNum(upt.getLoginNum()+1);
		upt.setLogintime(System.currentTimeMillis());
		adminUserMapper.updateByPrimaryKeySelective(upt);
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
		PageTool<UserFindResp> page = new PageTool<UserFindResp>();
		AdminUser record = new AdminUser();
		record.setAcount(req.getAcount());
		record.setUsername(req.getUsername());
		record.setTelphone(req.getTelphone());
		if(req.getPageNo()!=null){
			record.setPageNo(req.getPageNo()*req.getPageSize());
			record.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}
		List<AdminUser> list = adminUserMapper.selectByCondition(record);
		long a = adminUserMapper.selectByCount(record);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<UserFindResp> copyProperties2(List<AdminUser> list)throws Exception  {
		List<UserFindResp> resp = new ArrayList<UserFindResp>();
		for(AdminUser user : list){
			UserFindResp sp = new UserFindResp();
			PropertyUtils.copyProperties(sp, user);
			resp.add(sp);
		}
		return resp;
	}

}
