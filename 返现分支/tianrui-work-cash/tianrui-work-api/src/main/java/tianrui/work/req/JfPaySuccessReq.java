package tianrui.work.req;

public class JfPaySuccessReq {

	private String id;//订单id
	
	private Double balance;
	
	private Double redPark;
	
	private Double cashMoney;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getRedPark() {
		return redPark;
	}
	public void setRedPark(Double redPark) {
		this.redPark = redPark;
	}
	public Double getCashMoney() {
		return cashMoney;
	}
	public void setCashMoney(Double cashMoney) {
		this.cashMoney = cashMoney;
	}
}
