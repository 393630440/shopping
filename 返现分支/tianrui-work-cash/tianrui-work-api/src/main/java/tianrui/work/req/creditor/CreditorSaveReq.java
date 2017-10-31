package tianrui.work.req.creditor;
/**
 * 债权发布bean
 * @author Administrator
 *
 */
public class CreditorSaveReq {
    private String id;

    private String creditorStatus;
    
    private String creatorImg;
    
    private String creditorType;

    private String creditorName;

    private String creditorPhone;

    private String creditorIdcard;

    private String creditorSex;

    private String creditorAddress;

    private String creditorCompany;

    private String creditorCompanyAddress;

//    private String debtorName;
//
//    private String debtorPhone;
//
//    private String debtorIdcrd;
//
//    private String debtorSex;
//
//    private String debtorAddress;
//
//    private String debtorCompany;
//
//    private String debtorCompanyAddress;

    private Double debtAmount;

    private String debtTimeStr;
    
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

    public String getCreditorType() {
		return creditorType;
	}

	public void setCreditorType(String creditorType) {
		this.creditorType = creditorType;
	}

	public String getDebtTimeStr() {
		return debtTimeStr;
	}

	public void setDebtTimeStr(String debtTimeStr) {
		this.debtTimeStr = debtTimeStr;
	}

	public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

	public String getCreatorImg() {
		return creatorImg;
	}

	public void setCreatorImg(String creatorImg) {
		this.creatorImg = creatorImg;
	}
}