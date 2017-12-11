package tianrui.work.req.cash;

public class MemberCashBackReq {

	private String id;//设置用户id
	
	private String rank;//会员等级
	
	private Double money;//用户缴费金额

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
}
