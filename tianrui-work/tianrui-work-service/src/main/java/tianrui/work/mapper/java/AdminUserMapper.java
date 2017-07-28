package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
    
    List<AdminUser> selectByCondition(AdminUser record);
    
    long selectByCount(AdminUser record);
}