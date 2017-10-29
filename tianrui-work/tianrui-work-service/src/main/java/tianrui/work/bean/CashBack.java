package tianrui.work.bean;

public class CashBack {
	private String id;
	private String cashType;
	private String cashMember;
	private String cashMemberName;
	private Double cashAmount;
	private Double cashAlre;
	private Double cashRatio;
	private String cashRemark;
	private String paysId;
	private String creater;
	private Long createTime;
	private String modify;
	private Long modifyTime;
	private String desc1;
	private String desc2;
	private String desc3;
	private String desc4;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType == null ? null : cashType.trim();
	}

	public String getCashMember() {
		return cashMember;
	}

	public void setCashMember(String cashMember) {
		this.cashMember = cashMember == null ? null : cashMember.trim();
	}

	public String getCashMemberName() {
		return cashMemberName;
	}

	public void setCashMemberName(String cashMemberName) {
		this.cashMemberName = cashMemberName == null ? null : cashMemberName.trim();
	}

	public Double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public Double getCashAlre() {
		return cashAlre;
	}

	public void setCashAlre(Double cashAlre) {
		this.cashAlre = cashAlre;
	}

	public Double getCashRatio() {
		return cashRatio;
	}

	public void setCashRatio(Double cashRatio) {
		this.cashRatio = cashRatio;
	}

	public String getCashRemark() {
		return cashRemark;
	}

	public void setCashRemark(String cashRemark) {
		this.cashRemark = cashRemark == null ? null : cashRemark.trim();
	}

	public String getPaysId() {
		return paysId;
	}

	public void setPaysId(String paysId) {
		this.paysId = paysId == null ? null : paysId.trim();
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater == null ? null : creater.trim();
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify == null ? null : modify.trim();
	}

	public Long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1 == null ? null : desc1.trim();
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2 == null ? null : desc2.trim();
	}

	public String getDesc3() {
		return desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3 == null ? null : desc3.trim();
	}

	public String getDesc4() {
		return desc4;
	}

	public void setDesc4(String desc4) {
		this.desc4 = desc4 == null ? null : desc4.trim();
	}

}