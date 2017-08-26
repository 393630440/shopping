package tianrui.work.bean;

public class OrderInfo {
	private String orderId;

	private String orderCode;

	private String memberId;

	private String goodsType;

	private Integer goodsNum;

	private Double goodsSubtotal;

	private Double expressFee;

	private Double orderAmount;

	private Integer orderRedPacket;

	private String orderStatus;

	private String buyerWord;

	private Long creationTime;

	private String recipients;

	private String phone;

	private String city;

	private String detailAddress;

	private Long refundApplyTime;

	private Long refundAuditTime;

	private Long sendTime;

	private Long payTime;

	private Integer pageNo;
	private Integer pageSize;

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode == null ? null : orderCode.trim();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType == null ? null : goodsType.trim();
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Double getGoodsSubtotal() {
		return goodsSubtotal;
	}

	public void setGoodsSubtotal(Double goodsSubtotal) {
		this.goodsSubtotal = goodsSubtotal;
	}

	public Double getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderRedPacket() {
		return orderRedPacket;
	}

	public void setOrderRedPacket(Integer orderRedPacket) {
		this.orderRedPacket = orderRedPacket;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus == null ? null : orderStatus.trim();
	}

	public String getBuyerWord() {
		return buyerWord;
	}

	public void setBuyerWord(String buyerWord) {
		this.buyerWord = buyerWord == null ? null : buyerWord.trim();
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients == null ? null : recipients.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress == null ? null : detailAddress.trim();
	}

	public Long getRefundApplyTime() {
		return refundApplyTime;
	}

	public void setRefundApplyTime(Long refundApplyTime) {
		this.refundApplyTime = refundApplyTime;
	}

	public Long getRefundAuditTime() {
		return refundAuditTime;
	}

	public void setRefundAuditTime(Long refundAuditTime) {
		this.refundAuditTime = refundAuditTime;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public Long getPayTime() {
		return payTime;
	}

	public void setPayTime(Long payTime) {
		this.payTime = payTime;
	}

}