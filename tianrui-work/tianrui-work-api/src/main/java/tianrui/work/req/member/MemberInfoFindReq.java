package tianrui.work.req.member;

public class MemberInfoFindReq {

	private Integer pageNo;
	
	private Integer pageSize;
	//微信名称
    private String wechatName;
    //联系电话
    private String cellphone;
    //1-开启 0-关闭
    private String rpTradeMark;
    //会员等级
    private String memberRank;

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
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

	public String getRpTradeMark() {
		return rpTradeMark;
	}

	public void setRpTradeMark(String rpTradeMark) {
		this.rpTradeMark = rpTradeMark;
	}

}