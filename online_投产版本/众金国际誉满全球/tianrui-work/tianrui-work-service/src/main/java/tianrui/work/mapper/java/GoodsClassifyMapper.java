package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.GoodsClassify;

public interface GoodsClassifyMapper {
	int deleteByPrimaryKey(String classifyId);

	int insert(GoodsClassify record);

	int insertSelective(GoodsClassify record);

	GoodsClassify selectByPrimaryKey(String classifyId);

	List<GoodsClassify> selectList(GoodsClassify record);

	int updateByPrimaryKeySelective(GoodsClassify record);

	int updateByPrimaryKey(GoodsClassify record);

	List<GoodsClassify> selectByGoodsClassify(GoodsClassify record);

	long selectBycount(GoodsClassify record);
}