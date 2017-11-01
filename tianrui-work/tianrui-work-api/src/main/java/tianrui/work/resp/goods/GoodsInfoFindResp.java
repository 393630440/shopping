package tianrui.work.resp.goods;

/**
 * 商品信息
 */
public class GoodsInfoFindResp {
	private String goodsId; // 商品ID
	private String goodsName; // 商品名称
	private String goodsImg; // 商品图片 图片地址
	private String firstGoodsImg;// 显示第一张的商品图片
	private String goodsStatus; // 商品状态:1-已上架;2-已下架
	private String goodsType; // 商品类型:1-大众商品;2-宏包商品
	private Double goodsPrice; // 商品价格
	private Integer redPacket; // 宏包
	private String price;// 显示的价格
	private String goodsDetails; // 详情
	private String goodsParam; // 参数
	private Double expressFee; // 快递费
	private String expressFeeStr; // 显示的快递费
	private Integer inventory; // 库存
	private Integer salesvolume; // 销量
	private Integer buyNum; // 购买数量
	private Integer browseNum; // 浏览记录
	private String sifting; // 默认值=0,筛选条件:0-普通商品;1-推荐商品;2-新品上市;3-热卖商品;4-促销商品;5-卖家包邮;6-限时抢购
	private String classifyId; // 分类ID
	private String classifyName; // 分类名称
	private Long pubdate;// 发布时间
	private Double discountPrice;// 折扣价格

	private String path;
	private String memberRank;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getFirstGoodsImg() {
		if (goodsImg == null || goodsImg.equals("")) {
		} else {
			String[] arr = goodsImg.split("[|]");
			if (arr.length > 0)
				firstGoodsImg = arr[0];
		}
		return firstGoodsImg;
	}

	public void setFirstGoodsImg(String firstGoodsImg) {
		this.firstGoodsImg = firstGoodsImg;
	}

	public String getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public Double getGoodsPrice() {
		if (memberRank == null || memberRank.equals("")) {
		} else {
			if (memberRank.equals("1")) {
			} else if (memberRank.equals("2")) {
				goodsPrice = discountPrice;
			} else {
			}
		}
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getRedPacket() {
		if (redPacket == null)
			redPacket = 0;
		return redPacket;
	}

	public void setRedPacket(Integer redPacket) {
		if (redPacket == null)
			this.redPacket = 0;
		else
			this.redPacket = redPacket;
	}

	public String getPrice() {
		if (goodsType == null || goodsType.equals("")) {
		} else {
			if (memberRank == null || memberRank.equals("")) {
				if (goodsType.equals("1")) {
					price = "￥" + goodsPrice;
				} else if (goodsType.equals("2")) {
					price = "￥" + goodsPrice + " + " + redPacket + "宏包";
				}
			} else {
				if (memberRank.equals("1")) {
					if (goodsType.equals("1")) {
						price = "￥" + goodsPrice;
					} else if (goodsType.equals("2")) {
						price = "￥" + goodsPrice + " + " + redPacket + "宏包";
					}
				} else if (memberRank.equals("2")) {
					if (goodsType.equals("1")) {
						price = "￥" + discountPrice;
					} else if (goodsType.equals("2")) {
						price = "￥" + discountPrice + " + " + redPacket + "宏包";
					}
				}
			}
		}
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(String goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public String getGoodsParam() {
		return goodsParam;
	}

	public void setGoodsParam(String goodsParam) {
		this.goodsParam = goodsParam;
	}

	public Double getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}

	public String getExpressFeeStr() {
		if (expressFee == null || expressFee == 0)
			expressFeeStr = "包邮";
		else if (expressFee > 0)
			expressFeeStr = String.valueOf(expressFee) + "元";
		return expressFeeStr;
	}

	public void setExpressFeeStr(String expressFeeStr) {
		this.expressFeeStr = expressFeeStr;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Integer getSalesvolume() {
		return salesvolume;
	}

	public void setSalesvolume(Integer salesvolume) {
		this.salesvolume = salesvolume;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public Integer getBrowseNum() {
		return browseNum;
	}

	public void setBrowseNum(Integer browseNum) {
		this.browseNum = browseNum;
	}

	public String getSifting() {
		return sifting;
	}

	public void setSifting(String sifting) {
		this.sifting = sifting;
	}

	public String getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public Long getPubdate() {
		return pubdate;
	}

	public void setPubdate(Long pubdate) {
		this.pubdate = pubdate;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getPath() {
		if (path == null)
			path = "/resources/file/goodsInfo/" + goodsId + "/";
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}

}