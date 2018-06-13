package com.example.common.util;

public class StringUtil {

	/**
	 * 判断字符串是否是null或""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		boolean result = true;
		if (null == str || "".equals(str.trim())) {
			result = false;
		}
		return result;
	}
}
