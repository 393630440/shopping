package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.MemberFootprint;

public interface MemberFootprintMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberFootprint record);

    int insertSelective(MemberFootprint record);

    MemberFootprint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberFootprint record);

    int updateByPrimaryKeyWithBLOBs(MemberFootprint record);

    int updateByPrimaryKey(MemberFootprint record);
    
    List<MemberFootprint> selectByCondition(MemberFootprint record);
    
    long selectBycount(MemberFootprint record);
}