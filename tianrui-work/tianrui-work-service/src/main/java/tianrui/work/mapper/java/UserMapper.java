package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectBycontion(User record);
    
    long selectBycount(User record);
}