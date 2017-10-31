package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.CashBackInfo;

public interface CashBackInfoMapper {

	int deleteByPrimaryKey(String id);

	int insertSelective(CashBackInfo record);

	CashBackInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CashBackInfo record);

	List<CashBackInfo> selectByCondition(CashBackInfo record);

	long selectByCount(CashBackInfo record);

	/** 今日收益 */
	String getTodayEarnings(CashBackInfo record);

}