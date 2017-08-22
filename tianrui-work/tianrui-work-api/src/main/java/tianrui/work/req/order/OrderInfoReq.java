package tianrui.work.req.order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单信息
 * 
 * @author Joe
 */
public class OrderInfoReq {
	private String orderId; // 订单ID
	private String orderCode; // 订单编号
	private String memberId; // 会员ID
	private String goodsType; // 商品类型:1-大众商品;2-宏包商品
	private Integer goodsNum; // 商品数量
	private Double goodsSubtotal; // 商品小计
	private Double expressFee; // 运费
	private Double orderAmount; // 订单总金额
	private Integer orderRedPacket; // 订单总宏包
	private String orderStatus; // 订单状态:1-待付款;2-待发货;3-待收货;4-已完成;5-退款申请;6-退款失败;7-退款成功;8-已取消;9-已删除;0-彻底删除
	private String buyerWord; // 买家留言
	private Long creationTime; // 创建时间
	private String recipients; // 收件人
	private String phone; // 联系电话
	private String city; // 所在地区
	private String detailAddress; // 详细地址
	private Long refundApplyTime;// 退货申请时间
	private Long refundAuditTime;// 退货审核时间
	private Long sendTime;// 发货时间

	private String creationTimeStr; // 创建时间
	private String refundApplyTimeStr;// 退货申请时间
	private String refundAuditTimeStr;// 退货审核时间
	private String sendTimeStr;// 发货时间

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
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
		this.orderStatus = orderStatus;
	}

	public String getBuyerWord() {
		return buyerWord;
	}

	public void setBuyerWord(String buyerWord) {
		this.buyerWord = buyerWord;
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
		this.recipients = recipients;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
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

	public void setCreationTimeStr(String creationTimeStr) {
		this.creationTimeStr = creationTimeStr;
	}

	public void setRefundApplyTimeStr(String refundApplyTimeStr) {
		this.refundApplyTimeStr = refundApplyTimeStr;
	}

	public void setRefundAuditTimeStr(String refundAuditTimeStr) {
		this.refundAuditTimeStr = refundAuditTimeStr;
	}

	public void setSendTimeStr(String sendTimeStr) {
		this.sendTimeStr = sendTimeStr;
	}

	public String getCreationTimeStr() {
		try {
			if (creationTime != null) {
				Date date = new Date(creationTime);
				creationTimeStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
			}
		} catch (Exception e) {
			creationTimeStr = "";
		}
		return creationTimeStr;
	}

	public String getRefundApplyTimeStr() {
		try {
			if (refundApplyTime != null) {
				Date date = new Date(refundApplyTime);
				refundApplyTimeStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
			}
		} catch (Exception e) {
			refundApplyTimeStr = "";
		}
		return refundApplyTimeStr;
	}

	public String getRefundAuditTimeStr() {
		try {
			if (refundAuditTime != null) {
				Date date = new Date(refundAuditTime);
				refundAuditTimeStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
			}
		} catch (Exception e) {
			refundAuditTimeStr = "";
		}
		return refundAuditTimeStr;
	}

	public String getSendTimeStr() {
		try {
			if (sendTime != null) {
				Date date = new Date(sendTime);
				sendTimeStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
			}
		} catch (Exception e) {
			sendTimeStr = "";
		}
		return sendTimeStr;
	}

}