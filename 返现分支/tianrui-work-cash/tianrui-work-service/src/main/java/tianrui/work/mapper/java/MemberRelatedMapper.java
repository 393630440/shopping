package tianrui.work.mapper.java;

import tianrui.work.bean.MemberRelated;

public interface MemberRelatedMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberRelated record);

    int insertSelective(MemberRelated record);

    MemberRelated selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberRelated record);

    int updateByPrimaryKey(MemberRelated record);
}