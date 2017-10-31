package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.Creditor;

public interface CreditorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Creditor record);

    int insertSelective(Creditor record);

    Creditor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Creditor record);

    int updateByPrimaryKey(Creditor record);
    
    List<Creditor> selectByCondition(Creditor record);
    
    long selectBycount(Creditor record);
}