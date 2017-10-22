package tianrui.work.req.admin.user;

public class UserFindReq {

    private String acount;

    private String acountStatus;

    private String password;

    private String telphone;
    
    private String username;
    
    private Integer pageNo;
    
    private Integer pageSize;

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount == null ? null : acount.trim();
    }

    public String getAcountStatus() {
        return acountStatus;
    }

    public void setAcountStatus(String acountStatus) {
        this.acountStatus = acountStatus == null ? null : acountStatus.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}