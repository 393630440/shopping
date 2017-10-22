package tianrui.work.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DateChangeUtil {

	/**
	 * String时间格式转Long 
	 * type-日期格式 
	 * date-日期
	 * @throws Exception */
	public static Long changeStr(String date,String type) throws Exception{
		SimpleDateFormat fmt = new SimpleDateFormat(type);
		Long a = null;
		if(StringUtils.isNotBlank(date)){
			Date d = fmt.parse(date);
			a = d.getTime();
		}
		return a;
	}
	/**
	 * Long时间格式转String
	 * type-时间格式
	 * date-时间戳
	 * @return
	 */
	public static String changeLong(Long date,String type){
		SimpleDateFormat fmt = new SimpleDateFormat(type);
		String d = ""; 
		if(date!=null){
			d = fmt.format(new Date(date));
		}
		return d;
	}
}
