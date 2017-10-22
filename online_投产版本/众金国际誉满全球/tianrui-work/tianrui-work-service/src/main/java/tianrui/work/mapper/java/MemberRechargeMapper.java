package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.MemberRecharge;

public interface MemberRechargeMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberRecharge record);

    int insertSelective(MemberRecharge record);

    MemberRecharge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberRecharge record);

    int updateByPrimaryKey(MemberRecharge record);
    
    List<MemberRecharge> selectByCondition(MemberRecharge record);
    
    long selectBycount(MemberRecharge record);
}