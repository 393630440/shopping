package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.CashBack;

public interface CashBackMapper {
    int deleteByPrimaryKey(String id);

    int insert(CashBack record);

    int insertSelective(CashBack record);

    CashBack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CashBack record);

    int updateByPrimaryKey(CashBack record);
    
    List<CashBack> selectByCondition(CashBack record);
    
    long selectByCount(CashBack record);
}