package tianrui.work.mapper.java;

import tianrui.work.bean.Connect;

public interface ConnectMapper {
    int deleteByPrimaryKey(String id);

    int insert(Connect record);

    int insertSelective(Connect record);

    Connect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Connect record);

    int updateByPrimaryKey(Connect record);
}