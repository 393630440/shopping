package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.ConfigurationInfo;

public interface ConfigurationInfoMapper {
	int deleteByPrimaryKey(String paramkey);

	int insert(ConfigurationInfo record);

	int insertSelective(ConfigurationInfo record);

	ConfigurationInfo selectByPrimaryKey(String paramkey);

	List<ConfigurationInfo> selectList(ConfigurationInfo record);

	int updateByPrimaryKeySelective(ConfigurationInfo record);

	int updateByPrimaryKey(ConfigurationInfo record);

	List<ConfigurationInfo> selectByConfigurationInfo(ConfigurationInfo record);

	long selectBycount(ConfigurationInfo record);
}