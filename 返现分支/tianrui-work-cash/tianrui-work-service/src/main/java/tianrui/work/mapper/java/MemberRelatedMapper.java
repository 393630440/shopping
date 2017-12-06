package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.MemberRelated;

public interface MemberRelatedMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberRelated record);

    int insertSelective(MemberRelated record);

    MemberRelated selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberRelated record);

    int updateByPrimaryKey(MemberRelated record);
    
    List<MemberRelated> selectByCoudition(MemberRelated record);
    
    long selectByCount(MemberRelated record);
}