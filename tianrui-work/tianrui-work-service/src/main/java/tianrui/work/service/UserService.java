package tianrui.work.service;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IUserService;
import tianrui.work.bean.User;
import tianrui.work.mapper.java.UserMapper;
import tianrui.work.req.LoginReq;
import tianrui.work.req.ResistReq;
import tianrui.work.vo.Result;
@Service
public class UserService implements IUserService{

	@Autowired
	UserMapper userMapper;

	public Result login(LoginReq req) {
		Result rs = Result.getSuccessful();
		User user = new User();
		user.setUsercode(req.getUsercode());
		List<User> list = userMapper.selectBycontion(user);
		if(list.size()==1){
			User u = list.get(0);
			if(!u.getPassword().equals(req.getPassword())){
				rs.setCode("2");
				rs.setError("密码有误，请重新输入");
				return rs;
			}else{
				rs.setData(u);
				//openid不为空 清除之前保存openid 保存现登账号openid
				if(StringUtils.isNotBlank(req.getOpenid())){
					User weixin = new User();
					weixin.setOpenid(req.getOpenid());
					List<User> wxuser = userMapper.selectBycontion(weixin);
					for(User us : wxuser){
						us.setOpenid("");
						userMapper.updateByPrimaryKeySelective(us);
					}
					u.setOpenid(req.getOpenid());
					userMapper.updateByPrimaryKeySelective(u);
				}
			}
		}else{
			rs.setCode("0");
			rs.setError("用户不存在");
		}
		return rs;
	}

	public Result regist(ResistReq req) throws Exception{
		Result rs = Result.getSuccessful();
		User find = new User();
		find.setUsercode(req.getUsercode());
		long a = userMapper.selectBycount(find);
		long c = 0;
		if(a!=c){
			rs.setCode("1");
			rs.setError("该账号已被注册");
			return rs;
		}
		User user = new User();
		PropertyUtils.copyProperties(user, req);
		user.setStatus("0");
		user.setCreatetime(System.currentTimeMillis());;
		userMapper.insertSelective(user);
		rs.setData(user);
		return rs;
	}

	public Result wxLogin(LoginReq req) throws Exception {
		// TODO Auto-generated method stub
		Result rs = Result.getSuccessful();
		User user = new User();
		user.setOpenid(req.getOpenid());
		List<User> list = userMapper.selectBycontion(user);
		if(list.size()==1){
			rs.setData(list.get(0));
		}else{
			rs.setCode("1");
			rs.setError("暂无微信绑定关系");
		}
		return rs;
	}
}
