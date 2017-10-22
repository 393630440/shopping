package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.Withdrawal;

public interface WithdrawalMapper {
    int deleteByPrimaryKey(String id);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);
    
    List<Withdrawal> selectByCondition(Withdrawal record);
    
    long selectBycount(Withdrawal record);
}