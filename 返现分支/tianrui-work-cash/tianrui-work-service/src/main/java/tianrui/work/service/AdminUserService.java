package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
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
		//登录成功
		if(list.size() == 1){
			AdminUser admin = list.get(0);
			if(StringUtils.equals(admin.getAcountStatus(), "1")){
				rs.setData(admin);
				changeLogin(admin);
			}else{
				rs.setCode("1");
				rs.setError("账号已被禁用");
			}
		}else{
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
		Result rs = Result.getSuccessful();
		AdminUser query = new AdminUser();
		query.setAcount(req.getAcount());
		List<AdminUser> list = adminUserMapper.selectByCondition(query);
		if(list.size()!=0){
			rs.setCode("1");
			rs.setError("会员账号已被添加，请重新输入会员账号");
			return rs;
		}
		AdminUser user = new AdminUser();
		user.setId(UUIDUtil.getUUID());
		user.setAcount(req.getAcount());
		user.setPassword(req.getPassword());
		user.setUsername(req.getUsername());
		user.setTelphone(req.getTelphone());
		user.setLoginNum(0);
		user.setCreatetime(System.currentTimeMillis());
		user.setAcountStatus("1");
		adminUserMapper.insertSelective(user);
		return rs;
	}

	@Override
	public Result delete(String id) throws Exception {
		return null;
	}

	@Override
	public PageTool<UserFindResp> select(UserFindReq req) throws Exception {
		PageTool<UserFindResp> page = new PageTool<UserFindResp>();
		AdminUser record = new AdminUser();
		record.setAcount(req.getAcount());
		record.setUsername(req.getUsername());
		record.setTelphone(req.getTelphone());
		record.setAcountStatus(req.getAcountStatus());
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
	@Override
	public Result userDisable(String id) throws Exception {
		Result rs = Result.getSuccessful();
		AdminUser user = adminUserMapper.selectByPrimaryKey(id);
		if(user!=null){
			if(user.getAcount().equals("admin")){
				rs.setCode("1");
				rs.setError("admin账号不能被禁用");
			}else{
				AdminUser upt = new AdminUser();
				upt.setId(id);
				if(StringUtils.equals(user.getAcountStatus(), "1")){
					upt.setAcountStatus("0");
				}else{
					upt.setAcountStatus("1");
				}
				adminUserMapper.updateByPrimaryKeySelective(upt);
			}
		}
		return rs;
	}
	@Override
	public Result uptUser(UserSaveReq req) throws Exception {
		Result rs = Result.getSuccessful();
		AdminUser upt = new AdminUser();
		upt.setId(req.getId());
		if(StringUtils.isNotBlank(req.getPassword())){
			upt.setPassword(req.getPassword());
		}
		upt.setUsername(req.getUsername());
		upt.setTelphone(req.getTelphone());
		adminUserMapper.updateByPrimaryKeySelective(upt);
		AdminUser user = adminUserMapper.selectByPrimaryKey(req.getId());
		rs.setData(user);
		return rs;
	}
	@Override
	public Result findByid(String id) throws Exception {
		Result rs = Result.getSuccessful();
		AdminUser user = adminUserMapper.selectByPrimaryKey(id);
		rs.setData(user);
		return rs;
	}

}
