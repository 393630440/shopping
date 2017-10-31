package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.GoodsInfo;

public interface GoodsInfoMapper {
	int deleteByPrimaryKey(String goodsId);

	int insert(GoodsInfo record);

	int insertSelective(GoodsInfo record);

	GoodsInfo selectByPrimaryKey(String goodsId);

	int updateByPrimaryKeySelective(GoodsInfo record);

	int updateByPrimaryKey(GoodsInfo record);

	List<GoodsInfo> selectByGoodsInfo(GoodsInfo record);

	long selectBycount(GoodsInfo record);
}