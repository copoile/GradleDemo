package com.example.common.excption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统日志记录器
 * 
 * @desc
 * @author <a href="mailto:wuaj@asiainfo.com">wuaj</a>
 * @createTime 2017年1月7日 下午3:17:21
 */
public class SystemLogger {

	private SystemLogger() {
	}

	public static final Logger errorLog = LoggerFactory.getLogger(SystemLogger.class);


	public static void info(Throwable e) {
		errorLog.info(e.getMessage(), e);
	}

}
