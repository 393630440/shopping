package tianrui.work.bean;

public class ConfigurationInfo {
	private String paramkey;

	private String paramvalue;

	private String depict;

	private String flag;

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