package tianrui.work.comm;

public class Constant {

	public static String WEIXIN_BASE_URL;
	
	public static String WEIXIN_TOKEN;
	
	public static String WEIXIN_APPID;
	
	public static String WEIXIN_APPSECRET;
	
	public static String WEIXIN_SHANGPU;
	
	public static String WEIXIN_SIGN_KEY;
	//公众好支付
	public static String WEIXIN_PAY_JSAPI="JSAPI";
	//二维码支付
	public static String WEIXIN_PAY_NATIVE="NATIVE";

	public static String getWEIXIN_TOKEN() {
		return WEIXIN_TOKEN;
	}

	public static void setWEIXIN_TOKEN(String wEIXIN_TOKEN) {
		WEIXIN_TOKEN = wEIXIN_TOKEN;
	}

	public static String getWEIXIN_BASE_URL() {
		return WEIXIN_BASE_URL;
	}

	public static void setWEIXIN_BASE_URL(String wEIXIN_BASE_URL) {
		WEIXIN_BASE_URL = wEIXIN_BASE_URL;
	}

	public static String getWEIXIN_APPID() {
		return WEIXIN_APPID;
	}

	public static void setWEIXIN_APPID(String wEIXIN_APPID) {
		WEIXIN_APPID = wEIXIN_APPID;
	}

	public static String getWEIXIN_APPSECRET() {
		return WEIXIN_APPSECRET;
	}

	public static void setWEIXIN_APPSECRET(String wEIXIN_APPSECRET) {
		WEIXIN_APPSECRET = wEIXIN_APPSECRET;
	}

	public static String getWEIXIN_SHANGPU() {
		return WEIXIN_SHANGPU;
	}

	public static void setWEIXIN_SHANGPU(String wEIXIN_SHANGPU) {
		WEIXIN_SHANGPU = wEIXIN_SHANGPU;
	}

	public static String getWEIXIN_SIGN_KEY() {
		return WEIXIN_SIGN_KEY;
	}

	public static void setWEIXIN_SIGN_KEY(String wEIXIN_SIGN_KEY) {
		WEIXIN_SIGN_KEY = wEIXIN_SIGN_KEY;
	}
}
