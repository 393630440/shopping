package tianrui.work.resp.shoppingcart;

public class ShoppingCartFindResp {
	
	private String cashType;
	
	private Integer shoppingCartId;
	private String goodsId; // 商品ID
	private String memberId; // 会员ID
	private String orderId; // 订单ID
	private Long creationTime; // 添加时间
	private String goodsName; // 商品名称
	private String goodsImg; // 商品图片
	private Double goodsPrice; // 商品价格
	private Integer goodsRedPacket; // 商品宏包
	private Integer goodsNum; // 商品数量
	private String goodsType; // 商品类型:1-大众商品;2-宏包商品
	private String shoppingCartStatus; // 购物车商品状态:1-已添加;2-已购买;3-已删除

	private Double expressFee; // 快递费
	private String price;// 显示的价格
	private String subtotal;// 显示的商品小计

	private String path;

	public Double getGoodsSubtotal() {
		Double goodsSubtotal = 0d;
		if (goodsNum != null && goodsNum > 0 && goodsPrice != null && goodsPrice > 0)
			goodsSubtotal = goodsNum * goodsPrice;

		goodsSubtotal = (double) Math.round(goodsSubtotal * 100) / 100;
		return goodsSubtotal;
	}

	public Integer getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId == null ? null : goodsId.trim();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg == null ? null : goodsImg.trim();
	}

	public Double getGoodsPrice() {
		return goodsPrice = goodsPrice == null ? 0d : goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsRedPacket() {
		return goodsRedPacket = goodsRedPacket == null ? 0 : goodsRedPacket;
	}

	public void setGoodsRedPacket(Integer goodsRedPacket) {
		this.goodsRedPacket = goodsRedPacket;
	}

	public Integer getGoodsNum() {
		return goodsNum = goodsNum == null ? 0 : goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType == null ? null : goodsType.trim();
	}

	public String getShoppingCartStatus() {
		return shoppingCartStatus;
	}

	public void setShoppingCartStatus(String shoppingCartStatus) {
		this.shoppingCartStatus = shoppingCartStatus == null ? null : shoppingCartStatus.trim();
	}

	public Double getExpressFee() {
		return expressFee = expressFee == null ? 0d : expressFee;
	}

	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}

	public String getPath() {
		if (path == null)
			path = "";
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPrice() {
		if (goodsType == null || goodsType.equals("")) {
		} else {
			if (goodsType.equals("1")) {
				price = "￥" + goodsPrice;
			} else if (goodsType.equals("2")) {
				price = "￥" + goodsPrice + " + " + goodsRedPacket + "积分";
			} else {
			}
		}
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSubtotal() {
		if (goodsType == null || goodsType.equals("")) {
		} else {
			if (goodsType.equals("1")) {
				double d = goodsPrice * goodsNum;
				d = (double) Math.round(d * 100) / 100;
				subtotal = "￥" + String.valueOf(d);
			} else if (goodsType.equals("2")) {
				double d = goodsPrice * goodsNum;
				d = (double) Math.round(d * 100) / 100;
				subtotal = "￥" + String.valueOf(d) + " + " + (goodsRedPacket * goodsNum) + "积分";
			} else {
			}
		}
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}

}