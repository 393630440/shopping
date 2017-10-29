package tianrui.work.req.member;

public class MemberInfoHBaoReq {
    private String memberId;

    private String memberName;

    private String wechat;

    private String wechatImg;

    private String wechatName;

    private Double balance;

    private Double redPacket;
    //返现金额
    private Double cashMoney;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getWechatImg() {
        return wechatImg;
    }

    public void setWechatImg(String wechatImg) {
        this.wechatImg = wechatImg == null ? null : wechatImg.trim();
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName == null ? null : wechatName.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getRedPacket() {
        return redPacket;
    }

    public void setRedPacket(Double redPacket) {
        this.redPacket = redPacket;
    }

	public Double getCashMoney() {
		return cashMoney;
	}

	public void setCashMoney(Double cashMoney) {
		this.cashMoney = cashMoney;
	}

}