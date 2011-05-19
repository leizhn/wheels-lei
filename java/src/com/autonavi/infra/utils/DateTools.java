package com.autonavi.infra.utils;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 时间操作相关工具函数
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-4-20
 */
final public class DateTools {
	/**
	 * Date 向 Calendar类型转化
	 * 
	 * @param date
	 *            Date类型时刻
	 * @return Calendar类型时刻
	 */
	final public static Calendar parse(Date date) {
		Calendar timestamp = Calendar.getInstance();
		timestamp.setTime(date);
		return timestamp;
	}

	final static Logger logger = LoggerFactory.getLogger(DateTools.class);
}
