package tianrui.work.req.configuration;

public class ConfigurationInfoReq {
	private String paramkey;
	private String paramvalue;
	private String depict;
	private String flag;// 维护标志:0-失效;1-有效

	private Integer pageNo;
	private Integer pageSize;

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

	public ConfigurationInfoReq() {
	}

	public ConfigurationInfoReq(String flag) {
		if (flag == null || "".equals(flag))
			flag = "1";

		this.flag = flag;
	}

	public String getParamkey() {
		return paramkey;
	}

	public void setParamkey(String paramkey) {
		this.paramkey = paramkey == null ? null : paramkey.trim();
	}

	public String getParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue == null ? null : paramvalue.trim();
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict == null ? null : depict.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

}