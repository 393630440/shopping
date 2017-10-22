package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.AdInfo;

public interface AdInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AdInfo record);

	int insertSelective(AdInfo record);

	AdInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AdInfo record);

	int updateByPrimaryKey(AdInfo record);

	List<AdInfo> selectList(AdInfo record);

	List<AdInfo> selectByAdInfo(AdInfo record);

	long selectBycount(AdInfo record);
}