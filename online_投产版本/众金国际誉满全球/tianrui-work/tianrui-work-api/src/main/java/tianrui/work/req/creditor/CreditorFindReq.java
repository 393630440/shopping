package tianrui.work.req.creditor;
/**
 * 债权发布bean
 * @author Administrator
 *
 */
public class CreditorFindReq {
    
    private Integer pageNo;

    private Integer pageSize;
    
    private String creditorStatus;

    private String creditorIdcard;

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

	public String getCreditorStatus() {
		return creditorStatus;
	}

	public void setCreditorStatus(String creditorStatus) {
		this.creditorStatus = creditorStatus;
	}

	public String getCreditorIdcard() {
		return creditorIdcard;
	}

	public void setCreditorIdcard(String creditorIdcard) {
		this.creditorIdcard = creditorIdcard;
	}
}