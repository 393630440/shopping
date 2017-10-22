package tianrui.work.mapper.java;

import java.util.List;
import java.util.Map;

import tianrui.work.bean.ShoppingCart;

public interface ShoppingCartMapper {
	int deleteByPrimaryKey(Integer shoppingCartId);

	int insert(ShoppingCart record);

	int insertSelective(ShoppingCart record);

	ShoppingCart selectByPrimaryKey(Integer shoppingCartId);

	int updateByPrimaryKeySelective(ShoppingCart record);

	int updateByPrimaryKey(ShoppingCart record);

	List<ShoppingCart> selectByShoppingCart(ShoppingCart record);

	long selectBycount(ShoppingCart record);

	List<ShoppingCart> getOrderByGoodsInfoList(Map<String, String> condition);

	List<ShoppingCart> getShoppingCartListByOrderId(String orderId);

}