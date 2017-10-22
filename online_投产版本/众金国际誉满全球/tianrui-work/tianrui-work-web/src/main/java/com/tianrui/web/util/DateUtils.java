package com.tianrui.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/** 日期工具类 */
public class DateUtils {

	public final static String DATE_YYYYMMDD = "yyyyMMdd";

	public final static String DATE_YYYYMMDD_F = "yyyy-MM-dd";

	public final static String DATE_HHMISS = "HHmmss";

	public final static String DATE_HHMISS_F = "HH:mm:ss";

	public final static String DATE_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

	public final static String DATE_YYYYMMDDHHMISS_F = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 格式化日期
	 * 
	 * @param source
	 *            毫秒数
	 * @return
	 */
	public static String format(Long source) {
		String res = "";
		try {
			Date date = new Date(source);
			res = (new SimpleDateFormat(DATE_YYYYMMDDHHMISS_F)).format(date);
		} catch (Exception e) {
			res = format(null, null);
		}
		return res;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期对象
	 * @param format
	 *            格式，为空时默认为yyyy-MM-dd格式
	 * @return 格式化后的日期字符串
	 */
	public static String format(Date date, String format) {
		String res = "";
		if (date == null) {
			date = new Date();
		}
		if (StringUtils.isNull(format)) {
			format = DateUtils.DATE_YYYYMMDD_F;
		}
		try {
			res = (new SimpleDateFormat(format)).format(date);
		} catch (Exception e) {
			res = format(null, null);
		}
		return res;
	}

	/**
	 * 格式化日期字符串yyyyMMdd
	 * 
	 * @param source
	 *            日期字符串对象
	 * @return 格式化后的日期字符串
	 */
	public static String formatToYmd(String source) {
		String res = "";
		if (StringUtils.hasLength(source)) {
			try {
				Date date = parseToDate(source);
				if (date != null) {
					res = (new SimpleDateFormat(DateUtils.DATE_YYYYMMDD)).format(date);
				}
			} catch (Exception e) {
				res = source;
				System.err.println("格式化日期字符串(yyyyMMdd)失败：" + e.getMessage());
			}
		}
		return res;
	}

	/**
	 * 格式化时间字符串HHmmss
	 * 
	 * @param source
	 *            时间字符串对象
	 * @return 格式化后的日期字符串
	 */
	public static String formatToHms(String source) {
		String res = "";
		if (StringUtils.hasLength(source)) {
			try {
				Date date = parseToDate(source);
				if (date != null) {
					res = (new SimpleDateFormat(DateUtils.DATE_HHMISS)).format(date);
				}
			} catch (Exception e) {
				res = source;
				System.err.println("格式化时间字符串(HHmmss)失败：" + e.getMessage());
			}
		}
		return res;
	}

	/**
	 * 格式化日期字符串yyyy-MM-dd
	 * 
	 * @param source
	 *            日期字符串对象
	 * @return 格式化后的日期字符串
	 */
	public static String formatToY_m_d(String source) {
		String res = "";
		if (StringUtils.hasLength(source)) {
			try {
				Date date = parseToDate(source);
				if (date != null) {
					res = (new SimpleDateFormat(DateUtils.DATE_YYYYMMDD_F)).format(date);
				}
			} catch (Exception e) {
				res = source;
				System.err.println("格式化日期字符串(yyyy-MM-dd)失败：" + e.getMessage());
			}
		}
		return res;
	}

	/**
	 * 格式化时间字符串HH:mm:ss
	 * 
	 * @param source
	 *            时间字符串对象
	 * @return 格式化后的日期字符串
	 */
	public static String formatToH_m_s(String source) {
		String res = "";
		if (StringUtils.hasLength(source)) {
			try {
				Date date = parseToDate(source);
				if (date != null) {
					res = (new SimpleDateFormat(DateUtils.DATE_HHMISS_F)).format(date);
				}
			} catch (Exception e) {
				res = source;
				System.err.println("格式化时间字符串(HH:mm:ss)失败：" + e.getMessage());
			}
		}
		return res;
	}

	/**
	 * 将字符串解析为日期对象
	 * 
	 * @param source
	 * @return
	 */
	public static Date parseToDate(String source) {
		Date date = null;
		if (StringUtils.hasLength(source)) {
			try {
				source = source.trim();
				String format = DateUtils.DATE_YYYYMMDD_F;
				if (source.matches("^\\d{4}\\d{2}\\d{2}$")) {
					format = DateUtils.DATE_YYYYMMDD;
				} else if (source.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
					format = DateUtils.DATE_YYYYMMDD_F;
				} else if (source.matches("^\\d{2}\\d{2}\\d{2}$")) {
					format = DateUtils.DATE_HHMISS;
				} else if (source.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
					format = DateUtils.DATE_HHMISS_F;
				} else if (source.matches("^\\d{4}\\d{2}\\d{2}\\d{2}\\d{2}\\d{2}$")) {
					format = DateUtils.DATE_YYYYMMDDHHMISS;
				} else if (source.matches("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$")) {
					format = DateUtils.DATE_YYYYMMDDHHMISS_F;
				} else {
					source = format(null, format);
				}
				date = (new SimpleDateFormat(format)).parse(source);
			} catch (ParseException e) {
				date = new Date();
			}
		}
		return date;
	}

	/**
	 * 将字符串解析为日期对象
	 * 
	 * @param source
	 *            日期字符串对象
	 * @param format
	 *            格式，为空时默认为yyyy-MM-dd格式
	 * @return
	 */
	public static Date parseToDate(String source, String format) {
		Date date = null;
		if (StringUtils.hasLength(source)) {
			try {
				source = source.trim();
				if (StringUtils.isNull(format)) {
					format = DateUtils.DATE_YYYYMMDD_F;
				}
				date = (new SimpleDateFormat(format)).parse(source);
			} catch (ParseException e) {
				date = new Date();
			}
		}
		return date;
	}

	/**
	 * 对日期时间进行增删操作
	 * 
	 * @param obj
	 *            日期对象(Date/String) 为null时,为当天日期
	 * @param tp
	 *            操作类型 'y' : 年; 'M' : 月; 'd' : 日; 'H' : 小时; 'm' : 分钟; 's' : 秒;
	 * @param amount
	 *            增加/减少 的数量
	 * @param format
	 *            返回的日期字符格式 可为null
	 * @return
	 */
	public static String operateDateTime(Object obj, char tp, int amount, String format) {
		Date date = new Date();
		if (obj != null) {
			if (obj instanceof Date) {
				date = (Date) obj;
			}
			if (obj instanceof String) {
				date = parseToDate(obj.toString());
			}
		}

		int field = Calendar.DAY_OF_MONTH;

		// 操作类型 'y' : 年; 'M' : 月; 'd' : 日; 'H' : 小时; 'm' : 分钟; 's' : 秒;
		switch (tp) {
		case 'y':
			field = Calendar.YEAR;
			break;
		case 'M':
			field = Calendar.MONTH;
			break;
		case 'd':
			field = Calendar.DAY_OF_MONTH;
			break;
		case 'H':
			field = Calendar.HOUR_OF_DAY;
			break;
		case 'm':
			field = Calendar.MINUTE;
			break;
		case 's':
			field = Calendar.SECOND;
			break;
		default:
			break;
		}

		Calendar riqi = new GregorianCalendar();
		riqi.setTime(date);
		riqi.add(field, amount);
		if (format == null || format.equals("")) {
			format = DateUtils.DATE_YYYYMMDDHHMISS_F;
		}
		return (new SimpleDateFormat(format)).format(riqi.getTime());
	}

	/**
	 * 判断给定日期是否是周末（六、日）
	 * 
	 * @param theDate
	 * @return
	 */
	public static boolean isWeekend(Date theDate) {
		java.util.Calendar c = new GregorianCalendar(TimeZone.getTimeZone("EST"), Locale.US);
		c.setTime(theDate);
		if (c.get(java.util.Calendar.DAY_OF_WEEK) < 7 && c.get(java.util.Calendar.DAY_OF_WEEK) > 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 获取当前的完整时间
	 * 
	 * @return 时间字符串
	 */
	public static String getCurTime() {
		return format(null, DateUtils.DATE_YYYYMMDDHHMISS_F);
	}

	/**
	 * 获取指定格式的时间
	 * 
	 * @param strTime
	 *            需要格式化的时间字符串 ，必须包含时分秒的数值 类似:2007-08-27 16:04:25 ,如果为空，则使用当天的日期时间
	 * @param iTimeType
	 *            0:返回完整格式(例:2007-08-09 16:04:25) 1:返回完整日期(例:2007-08-28) 2:返回完整时间(例:16:04:25) 3:返回月日(例:08-27) 4:当天返回时间，否则返回日期(例:今天16:12 别天:08-27) 5:返回日期字符串(例:20070828) 6:返回完整的日期字符串(例:20070928120249) 7:返回秒的字符串(例：100525) 8:返回日期的字符串(例：071019) 9:返回日期的字符串(例：2007年10月19日)
	 * @return 格式化后的时间
	 */
	public static String getStrTime(String strTime, int iTimeType) {
		String strResult = "";
		if (StringUtils.isNull(strTime))
			strTime = getCurTime();// 如果传入为空，就默认为当前时间
		if (strTime.length() < 19) {// 不合格的日期格式
			return strTime;
		}
		switch (iTimeType) {
		case 0: // yyyy-MM-dd HH:mm:ss
			strResult = strTime.substring(0, 10) + strTime.substring(10, 19);
			break;
		case 1: // yyyy-MM-dd
			strResult = strTime.substring(0, 10);
			break;
		case 2: // HH:mm:ss
			strResult = strTime.substring(11, 19);
			break;
		case 3: // MM-dd
			strResult = strTime.substring(5, 10);
			break;
		case 4: // 今天mm:ss 别天:MM-dd
			if (getCurTime().indexOf(strTime) >= 0) {
				strResult = strTime.substring(13, 19);
			} else {
				strResult = strTime.substring(5, 10);
			}
			break;
		case 5: // yyyyMMdd
			strResult = strTime.substring(0, 4) + strTime.substring(5, 7) + strTime.substring(8, 10);
			break;
		case 6: // yyyyMMddHHmmss
			strResult = strTime.substring(0, 4) + strTime.substring(5, 7) + strTime.substring(8, 10)
					+ strTime.substring(11, 13) + strTime.substring(14, 16) + strTime.substring(17, 19);
			break;
		case 7: // HHmmss
			strResult = strTime.substring(11, 13) + strTime.substring(14, 16) + strTime.substring(17, 19);
			break;
		case 8: // yyMMdd
			strResult = strTime.substring(2, 4) + strTime.substring(5, 7) + strTime.substring(8, 10);
			break;
		case 9: // yyyy年MM月dd日
			strResult = strTime.substring(0, 4) + "年" + strTime.substring(5, 7) + "月" + strTime.substring(8, 10) + "日";
			break;
		}
		return strResult;
	}

	// 增加或减少天数
	public static Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}

	public static Date setTimerDate(int hour, int minutes, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour); // 每天23点59分59秒启动定时任务
		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.SECOND, second);
		Date date = calendar.getTime(); // 第一次执行定时任务的时间
		// 如果第一次执行定时任务的时间 小于当前的时间 向后加一天
		if (date.before(new Date())) {
			date = addDay(date, 1);
		}
		return date;
	}
}
