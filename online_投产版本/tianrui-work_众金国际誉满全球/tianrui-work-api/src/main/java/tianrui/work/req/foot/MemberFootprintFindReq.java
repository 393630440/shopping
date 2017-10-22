package tianrui.work.req.foot;

public class MemberFootprintFindReq {
    private String memberId;

    private String goodsId;

    private String ffType;

    private Integer pageNo;
    
    private Integer pageSize;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getFfType() {
		return ffType;
	}

	public void setFfType(String ffType) {
		this.ffType = ffType;
	}

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
}