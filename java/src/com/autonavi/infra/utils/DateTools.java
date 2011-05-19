package com.autonavi.infra.utils;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ʱ�������ع��ߺ���
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-4-20
 */
final public class DateTools {
	/**
	 * Date �� Calendar����ת��
	 * 
	 * @param date
	 *            Date����ʱ��
	 * @return Calendar����ʱ��
	 */
	final public static Calendar parse(Date date) {
		Calendar timestamp = Calendar.getInstance();
		timestamp.setTime(date);
		return timestamp;
	}

	final static Logger logger = LoggerFactory.getLogger(DateTools.class);
}
