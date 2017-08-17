package tianrui.work.req.goods;

/**
 * 商品分类信息
 * 
 * @author Joe
 *
 */
public class GoodsClassifyReq {
	private String classifyId;
	private String classifyName;
	private String classifyStatus;
	private String goodsType; // 商品类型:1-大众商品;2-宏包商品
	private String parentId;
	private String descr;
	private Long pubdate;
	private String icon;

	public GoodsClassifyReq() {
	}

	public GoodsClassifyReq(String goodsType) {
		this.classifyStatus = "1";
		this.goodsType = goodsType == null ? null : goodsType.trim();
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

	public String getClassifyStatus() {
		return classifyStatus;
	}

	public void setClassifyStatus(String classifyStatus) {
		this.classifyStatus = classifyStatus;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Long getPubdate() {
		return pubdate;
	}

	public void setPubdate(Long pubdate) {
		this.pubdate = pubdate;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}