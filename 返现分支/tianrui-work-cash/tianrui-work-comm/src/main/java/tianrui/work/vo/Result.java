package tianrui.work.vo;

public class Result {

	private String code;
	
	private String error;
	
	private Object data;
	
	public static Result getSuccessful(){
		return new Result("000000");
	}
	
	public Result(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
