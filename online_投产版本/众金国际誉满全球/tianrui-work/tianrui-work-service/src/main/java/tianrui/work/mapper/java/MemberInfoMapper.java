package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.MemberInfo;

public interface MemberInfoMapper {
    int deleteByPrimaryKey(String memberId);

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    MemberInfo selectByPrimaryKey(String memberId);

    int updateByPrimaryKeySelective(MemberInfo record);

    int updateByPrimaryKey(MemberInfo record);
    
    List<MemberInfo> selectByCondition(MemberInfo record);
    
    long selectBycount(MemberInfo record);
}