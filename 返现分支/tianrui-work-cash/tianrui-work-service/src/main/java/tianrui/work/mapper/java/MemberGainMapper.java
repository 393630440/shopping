package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.MemberGain;

public interface MemberGainMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberGain record);

    int insertSelective(MemberGain record);

    MemberGain selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberGain record);

    int updateByPrimaryKey(MemberGain record);
    
    List<MemberGain> selectByCondition(MemberGain record);
    
    long selectBycount(MemberGain record);
}