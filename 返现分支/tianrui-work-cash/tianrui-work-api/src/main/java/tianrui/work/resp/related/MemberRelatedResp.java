package tianrui.work.resp.related;

public class MemberRelatedResp {

	private String id;
	    
    private String member;

    private String memberName;

    private String memberImg;

    private String memberFather;

    private String fatherName;

    private String fatherImg;

    private String relType;

    private Long createtime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberImg() {
		return memberImg;
	}

	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

	public String getMemberFather() {
		return memberFather;
	}

	public void setMemberFather(String memberFather) {
		this.memberFather = memberFather;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherImg() {
		return fatherImg;
	}

	public void setFatherImg(String fatherImg) {
		this.fatherImg = fatherImg;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public Long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
}
