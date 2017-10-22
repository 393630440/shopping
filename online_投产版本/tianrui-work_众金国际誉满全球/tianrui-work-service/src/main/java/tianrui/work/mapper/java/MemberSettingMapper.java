package tianrui.work.mapper.java;

import tianrui.work.bean.MemberSetting;

public interface MemberSettingMapper {
    int deleteByPrimaryKey(String memberId);

    int insert(MemberSetting record);

    int insertSelective(MemberSetting record);

    MemberSetting selectByPrimaryKey(String memberId);

    int updateByPrimaryKeySelective(MemberSetting record);

    int updateByPrimaryKey(MemberSetting record);
}