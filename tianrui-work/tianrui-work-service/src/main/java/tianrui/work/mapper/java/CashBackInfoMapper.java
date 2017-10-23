package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.CashBackInfo;

public interface CashBackInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CashBackInfo record);

    int insertSelective(CashBackInfo record);

    CashBackInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CashBackInfo record);

    int updateByPrimaryKey(CashBackInfo record);
    
    List<CashBackInfo> selectByCondition(CashBackInfo record);
    
    long selectByCount(CashBackInfo record);
}