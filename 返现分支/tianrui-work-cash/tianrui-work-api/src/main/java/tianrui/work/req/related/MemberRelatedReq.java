package tianrui.work.req.related;

public class MemberRelatedReq {
	
	private Integer pageNo;
    
    private Integer pageSize;
    
    private String member;

    private String memberFather;

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

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getMemberFather() {
		return memberFather;
	}

	public void setMemberFather(String memberFather) {
		this.memberFather = memberFather;
	}

    
}
