package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IShoppingCartService;
import tianrui.work.bean.ShoppingCart;
import tianrui.work.mapper.java.ShoppingCartMapper;
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
@Service
public class ShoppingCartService implements IShoppingCartService {

	@Autowired
	ShoppingCartMapper shoppingCartMapper;

	@Override
	public Result addShoppingCart(ShoppingCartReq req) throws Exception {
		Result rs = Result.getSuccessful();
		ShoppingCart record = new ShoppingCart();
		PropertyUtils.copyProperties(record, req);
		shoppingCartMapper.insertSelective(record);
		return rs;
	}

	@Override
	public Result editShoppingCart(ShoppingCartReq req) throws Exception {
		Result rs = Result.getSuccessful();
		ShoppingCart record = new ShoppingCart();
		PropertyUtils.copyProperties(record, req);
		shoppingCartMapper.updateByPrimaryKeySelective(record);
		return rs;
	}

	@Override
	public PageTool<ShoppingCartFindResp> queryShoppingCartByList(ShoppingCartFindReq req) throws Exception {
		PageTool<ShoppingCartFindResp> page = new PageTool<ShoppingCartFindResp>();
		ShoppingCart find = new ShoppingCart();
		if (req.getPageNo() != null) {
			find.setPageNo(req.getPageSize() * req.getPageNo());
			find.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}

		find.setGoodsId(req.getGoodsId());
		find.setMemberId(req.getMemberId());
		find.setOrderId(req.getOrderId());
		find.setGoodsType(req.getGoodsType());
		find.setShoppingCartStatus(req.getShoppingCartStatus());

		List<ShoppingCart> list = shoppingCartMapper.selectByShoppingCart(find);
		long a = shoppingCartMapper.selectBycount(find);

		List<ShoppingCartFindResp> resp = new ArrayList<ShoppingCartFindResp>();
		for (ShoppingCart bean : list) {
			ShoppingCartFindResp sp = new ShoppingCartFindResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		page.setList(resp);
		page.setTotal(a);

		return page;
	}

	@Override
	public List<ShoppingCartFindResp> getShoppingCartList(ShoppingCartFindReq req) throws Exception {
		ShoppingCart find = new ShoppingCart();
		if (req.getPageNo() != null) {
			find.setPageNo(req.getPageSize() * req.getPageNo());
			find.setPageSize(req.getPageSize());
		}

		find.setGoodsId(req.getGoodsId());
		find.setMemberId(req.getMemberId());
		find.setOrderId(req.getOrderId());
		find.setGoodsType(req.getGoodsType());
		find.setShoppingCartStatus(req.getShoppingCartStatus());

		List<ShoppingCart> list = shoppingCartMapper.selectByShoppingCart(find);

		List<ShoppingCartFindResp> resp = new ArrayList<ShoppingCartFindResp>();
		for (ShoppingCart bean : list) {
			ShoppingCartFindResp sp = new ShoppingCartFindResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		return resp;
	}

	@Override
	public List<ShoppingCartFindResp> getOrderByList(Map<String, String> condition) throws Exception {
		List<ShoppingCart> list = shoppingCartMapper.getOrderByGoodsInfoList(condition);

		List<ShoppingCartFindResp> resp = new ArrayList<ShoppingCartFindResp>();
		for (ShoppingCart bean : list) {
			ShoppingCartFindResp sp = new ShoppingCartFindResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		return resp;
	}

	@Override
	public void deleteShoppingCartGoods(String shoppingCartIds) throws Exception {
		String[] shoppingCartIdArr = shoppingCartIds.split(",");
		for (String shoppingCartIdStr : shoppingCartIdArr) {
			Integer shoppingCartId = Integer.valueOf(shoppingCartIdStr);
			shoppingCartMapper.deleteByPrimaryKey(shoppingCartId);
		}
	}

}
