package tianrui.work.mapper.java;

import tianrui.work.bean.Minutes;

public interface MinutesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Minutes record);

    int insertSelective(Minutes record);

    Minutes selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Minutes record);

    int updateByPrimaryKey(Minutes record);
}