package tianrui.work.req.goods;

/**
 * 商品信息
 * 
 * @author Joe
 *
 */
public class GoodsInfoFindReq {
	private String goodsId; // 商品ID
	private String goodsName; // 商品名称
	private String goodsImg; // 商品图片 图片地址)
	private String goodsStatus; // 商品状态:1-已上架;2-已下架
	private String goodsType; // 商品类型:1-大众商品;2-宏包商品
	private Double goodsPrice; // 商品价格
	private Integer redPacket; // 宏包
	private String goodsDetails; // 详情
	private String goodsParam; // 参数
	private Double expressFee; // 快递费
	private Integer inventory; // 库存
	private Integer salesvolume; // 销量
	private Integer buyNum; // 购买数量
	private Integer browseNum; // 浏览记录
	private String sifting; // 默认值=0,筛选条件:0-普通商品;1-推荐商品;2-新品上市;3-热卖商品;4-促销商品;5-卖家包邮;6-限时抢购
	private String classifyId; // 分类ID
	private String classifyName; // 分类名称
	private Long pubLong;// 发布时间
	private Double discountPrice;// 折扣价格

	private Integer pageNo;
	private Integer pageSize;
	private String pageSort;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public void setPageSort(String sordName, String sord) {
		if (sord == null)
			sord = "desc";

		if (pageSort == null)
			pageSort = sordName + " " + sord;
		else
			pageSort = ", " + sordName + " " + sord;
	}

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
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getRedPacket() {
		return redPacket;
	}

	public void setRedPacket(Integer redPacket) {
		this.redPacket = redPacket;
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

	public Long getPubLong() {
		return pubLong;
	}

	public void setPubLong(Long pubLong) {
		this.pubLong = pubLong;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

}