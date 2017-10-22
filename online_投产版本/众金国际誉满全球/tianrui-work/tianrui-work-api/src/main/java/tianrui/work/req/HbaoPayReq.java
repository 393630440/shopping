package tianrui.work.req;

public class HbaoPayReq {
	
	//支付人id-买方
	private String goPayOpenid;
	//收款人id-卖方
	private String toPayOpenid;
	//数量
	private Double payNum;
	
	private Double payMoney;

	public String getGoPayOpenid() {
		return goPayOpenid;
	}
	public void setGoPayOpenid(String goPayOpenid) {
		this.goPayOpenid = goPayOpenid;
	}
	public String getToPayOpenid() {
		return toPayOpenid;
	}
	public void setToPayOpenid(String toPayOpenid) {
		this.toPayOpenid = toPayOpenid;
	}
	public Double getPayNum() {
		return payNum;
	}
	public void setPayNum(Double payNum) {
		this.payNum = payNum;
	}
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
}
