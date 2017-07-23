package tianrui.work.resp;

public class BaesResp {

	private String id;
	
	private Integer pageNo;
	
	private Integer PageSize;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return PageSize;
	}

	public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
