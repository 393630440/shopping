package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.MemberAddress;

public interface MemberAddressMapper {
    int deleteByPrimaryKey(String addressId);

    int insert(MemberAddress record);

    int insertSelective(MemberAddress record);

    MemberAddress selectByPrimaryKey(String addressId);

    int updateByPrimaryKeySelective(MemberAddress record);

    int updateByPrimaryKey(MemberAddress record);
    
    List<MemberAddress> selectByCondition(MemberAddress record);
    
    long selectBycount(MemberAddress record);
}