package tianrui.work.req.member;

public class MemberInfoSaveReq {
    private String memberId;

    private String memberName;

    private String wechat;

    private String wechatImg;

    private String wechatName;

    private Double balance;

    private Double redPacket;

    private String cellphone;

    private String birthTime;

    private String city;

    private Double rpExchangeRatio;

    private String rpTradeMark;

    private String rpListingRatio;

    private Long createtime;

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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime == null ? null : birthTime.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Double getRpExchangeRatio() {
        return rpExchangeRatio;
    }

    public void setRpExchangeRatio(Double rpExchangeRatio) {
        this.rpExchangeRatio = rpExchangeRatio;
    }

    public String getRpTradeMark() {
        return rpTradeMark;
    }

    public void setRpTradeMark(String rpTradeMark) {
        this.rpTradeMark = rpTradeMark == null ? null : rpTradeMark.trim();
    }

    public String getRpListingRatio() {
        return rpListingRatio;
    }

    public void setRpListingRatio(String rpListingRatio) {
        this.rpListingRatio = rpListingRatio == null ? null : rpListingRatio.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}