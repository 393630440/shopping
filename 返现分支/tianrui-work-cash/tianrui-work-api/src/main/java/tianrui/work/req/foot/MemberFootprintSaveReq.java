package tianrui.work.req.foot;

public class MemberFootprintSaveReq {
	private String id;

	private String memberId;

	private String goodsId;

	private String ffType;

	private Long seetheTime;

	private String goodsName;

	private Double goodsPrice;

	private Long createtime;

	private String goodsImg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId == null ? null : goodsId.trim();
	}

	public String getFfType() {
		return ffType;
	}

	public void setFfType(String ffType) {
		this.ffType = ffType == null ? null : ffType.trim();
	}

	public Long getSeetheTime() {
		return seetheTime;
	}

	public void setSeetheTime(Long seetheTime) {
		this.seetheTime = seetheTime;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg == null ? null : goodsImg.trim();
	}
}