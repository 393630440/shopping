package tianrui.work.req.massage;

public class MessageReq {

	//模板id
	private String id;
	//跳转url
	private String url;
	//接受人openid
	private String openid;
	//消息类型
	private String type;
	
	private String obj1;
	private String obj2;
	private String obj3;
	private String obj4;
	private String first;
	private String foots;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getFoots() {
		return foots;
	}
	public void setFoots(String foots) {
		this.foots = foots;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getObj1() {
		return obj1;
	}
	public void setObj1(String obj1) {
		this.obj1 = obj1;
	}
	public String getObj2() {
		return obj2;
	}
	public void setObj2(String obj2) {
		this.obj2 = obj2;
	}
	public String getObj3() {
		return obj3;
	}
	public void setObj3(String obj3) {
		this.obj3 = obj3;
	}
	public String getObj4() {
		return obj4;
	}
	public void setObj4(String obj4) {
		this.obj4 = obj4;
	}
}
