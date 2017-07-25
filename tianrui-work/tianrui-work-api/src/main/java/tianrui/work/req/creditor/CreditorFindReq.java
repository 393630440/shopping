package tianrui.work.req.creditor;
/**
 * 债权发布bean
 * @author Administrator
 *
 */
public class CreditorFindReq {
    private String id;
    
    private Integer pageNo;

    private Integer pageSize;
    
    private String creditorStatus;

    private String creditorName;

    private String creditorPhone;

    private String creditorIdcard;

    private String creditorSex;

    private String creditorAddress;

    private String creditorCompany;

    private String creditorCompanyAddress;

    private String debtorName;

    private String debtorPhone;

    private String debtorIdcrd;

    private String debtorSex;

    private String debtorAddress;

    private String debtorCompany;

    private String debtorCompanyAddress;

    private Double debtAmount;

    private Long debtTime;

    private String debtType;

    private String creator;

    private Long creatorTime;

    private String updatetor;

    private Long updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCreditorStatus() {
        return creditorStatus;
    }

    public void setCreditorStatus(String creditorStatus) {
        this.creditorStatus = creditorStatus == null ? null : creditorStatus.trim();
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName == null ? null : creditorName.trim();
    }

    public String getCreditorPhone() {
        return creditorPhone;
    }

    public void setCreditorPhone(String creditorPhone) {
        this.creditorPhone = creditorPhone == null ? null : creditorPhone.trim();
    }

    public String getCreditorIdcard() {
        return creditorIdcard;
    }

    public void setCreditorIdcard(String creditorIdcard) {
        this.creditorIdcard = creditorIdcard == null ? null : creditorIdcard.trim();
    }

    public String getCreditorSex() {
        return creditorSex;
    }

    public void setCreditorSex(String creditorSex) {
        this.creditorSex = creditorSex == null ? null : creditorSex.trim();
    }

    public String getCreditorAddress() {
        return creditorAddress;
    }

    public void setCreditorAddress(String creditorAddress) {
        this.creditorAddress = creditorAddress == null ? null : creditorAddress.trim();
    }

    public String getCreditorCompany() {
        return creditorCompany;
    }

    public void setCreditorCompany(String creditorCompany) {
        this.creditorCompany = creditorCompany == null ? null : creditorCompany.trim();
    }

    public String getCreditorCompanyAddress() {
        return creditorCompanyAddress;
    }

    public void setCreditorCompanyAddress(String creditorCompanyAddress) {
        this.creditorCompanyAddress = creditorCompanyAddress == null ? null : creditorCompanyAddress.trim();
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName == null ? null : debtorName.trim();
    }

    public String getDebtorPhone() {
        return debtorPhone;
    }

    public void setDebtorPhone(String debtorPhone) {
        this.debtorPhone = debtorPhone == null ? null : debtorPhone.trim();
    }

    public String getDebtorIdcrd() {
        return debtorIdcrd;
    }

    public void setDebtorIdcrd(String debtorIdcrd) {
        this.debtorIdcrd = debtorIdcrd == null ? null : debtorIdcrd.trim();
    }

    public String getDebtorSex() {
        return debtorSex;
    }

    public void setDebtorSex(String debtorSex) {
        this.debtorSex = debtorSex == null ? null : debtorSex.trim();
    }

    public String getDebtorAddress() {
        return debtorAddress;
    }

    public void setDebtorAddress(String debtorAddress) {
        this.debtorAddress = debtorAddress == null ? null : debtorAddress.trim();
    }

    public String getDebtorCompany() {
        return debtorCompany;
    }

    public void setDebtorCompany(String debtorCompany) {
        this.debtorCompany = debtorCompany == null ? null : debtorCompany.trim();
    }

    public String getDebtorCompanyAddress() {
        return debtorCompanyAddress;
    }

    public void setDebtorCompanyAddress(String debtorCompanyAddress) {
        this.debtorCompanyAddress = debtorCompanyAddress == null ? null : debtorCompanyAddress.trim();
    }

    public Double getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(Double debtAmount) {
        this.debtAmount = debtAmount;
    }

    public Long getDebtTime() {
        return debtTime;
    }

    public void setDebtTime(Long debtTime) {
        this.debtTime = debtTime;
    }

    public String getDebtType() {
        return debtType;
    }

    public void setDebtType(String debtType) {
        this.debtType = debtType == null ? null : debtType.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Long getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Long creatorTime) {
        this.creatorTime = creatorTime;
    }

    public String getUpdatetor() {
        return updatetor;
    }

    public void setUpdatetor(String updatetor) {
        this.updatetor = updatetor == null ? null : updatetor.trim();
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
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