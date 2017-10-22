package com.tianrui.web.util;

import org.apache.log4j.Logger;

/** 日志工具类 */
public class LoggerUtils {

	public static synchronized void debug(Logger logger, String msg) {
		logger.debug(msg);
	}

	public static synchronized void debug(Logger logger, Object msg) {
		logger.debug(msg);
	}

	public static synchronized void info(Logger logger, String msg) {
		logger.info(msg);
	}

	public static synchronized void info(Logger logger, Object msg) {
		logger.info(msg);
	}

	public static synchronized void error(Logger logger, String msg) {
		logger.error(msg);
	}

	public static synchronized void error(Logger logger, Object msg) {
		logger.error(msg);
	}

	public static synchronized void error(Logger logger, Exception e) {
		logger.error(e);
		StackTraceElement[] trace = e.getStackTrace();
		for (int i = 0; i < trace.length; i++) {
			logger.error("\tat " + trace[i]);
		}
	}

	public static synchronized void error(Logger logger, String msg, Exception e) {
		logger.error(msg);
		logger.error(e);
		StackTraceElement[] trace = e.getStackTrace();
		for (int i = 0; i < trace.length; i++) {
			logger.error("\tat " + trace[i]);
		}
	}

}
