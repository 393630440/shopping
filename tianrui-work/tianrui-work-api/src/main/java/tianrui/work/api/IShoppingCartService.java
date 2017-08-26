package tianrui.work.api;

import java.util.List;
import java.util.Map;

import tianrui.work.req.shoppingcart.ShoppingCartFindReq;
import tianrui.work.req.shoppingcart.ShoppingCartReq;
import tianrui.work.resp.shoppingcart.ShoppingCartFindResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

/**
 * 购物车信息
 * 
 * @author Joe
 *
 */
public interface IShoppingCartService {

	/** 添加购物车 */
	Result addShoppingCart(ShoppingCartReq req) throws Exception;

	/** 编辑购物车信息 */
	Result editShoppingCart(ShoppingCartReq req) throws Exception;

	/** 列表查询购物车信息 */
	PageTool<ShoppingCartFindResp> queryShoppingCartByList(ShoppingCartFindReq req) throws Exception;

	/** 查询购物车集合信息 */
	List<ShoppingCartFindResp> getShoppingCartList(ShoppingCartFindReq req) throws Exception;

	/** 查询要生成订单的商品信息 */
	List<ShoppingCartFindResp> getOrderByList(Map<String, String> condition) throws Exception;

	/** 删除购物车中的商品 */
	void deleteShoppingCartGoods(String shoppingCartIds) throws Exception;

}
