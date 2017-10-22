package tianrui.work.mapper.java;

import java.util.List;

import tianrui.work.bean.OrderInfo;

public interface OrderInfoMapper {
	int deleteByPrimaryKey(String orderId);

	int insert(OrderInfo record);

	int insertSelective(OrderInfo record);

	OrderInfo selectByPrimaryKey(String orderId);

	int updateByPrimaryKeySelective(OrderInfo record);

	int updateByPrimaryKey(OrderInfo record);

	List<OrderInfo> selectByOrderInfo(OrderInfo record);

	long selectBycount(OrderInfo record);
}