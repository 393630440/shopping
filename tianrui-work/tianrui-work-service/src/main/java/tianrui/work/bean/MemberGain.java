package tianrui.work.bean;

public class MemberGain {
    private String id;
    
    private Integer pageNo;
    
    private Integer pageSize;

    private String memberId;

    private String rpType;

    private Double rpNum;

    private String sourceId;

    private String sourceDescribe;

    private Long createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getRpType() {
        return rpType;
    }

    public void setRpType(String rpType) {
        this.rpType = rpType == null ? null : rpType.trim();
    }

    public Double getRpNum() {
        return rpNum;
    }

    public void setRpNum(Double rpNum) {
        this.rpNum = rpNum;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public String getSourceDescribe() {
        return sourceDescribe;
    }

    public void setSourceDescribe(String sourceDescribe) {
        this.sourceDescribe = sourceDescribe == null ? null : sourceDescribe.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
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
    
}