package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.MemberAddress;
import tianrui.work.bean.MemberAddressNew;

public interface MemberAddressNewMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberAddressNew record);

    int insertSelective(MemberAddressNew record);

    MemberAddressNew selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberAddressNew record);

    int updateByPrimaryKey(MemberAddressNew record);
    
    List<MemberAddressNew> selectByCondition(MemberAddressNew record);
    
    long selectBycount(MemberAddressNew record);
}