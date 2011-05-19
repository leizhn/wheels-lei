package com.tinfochina.infra.utils.xml;

import java.util.Collection;

/**
 * 
 * 文本格式化
 * 
 * @author zhenhua.lei
 * 
 */
public class PlainTextFormattee {
	public static String getXMLTag(String tagName, boolean tagValue) {
		return getXMLTag(tagName, String.valueOf(tagValue));
	}

	public static <E extends XMLDesc> String getXMLTag(String tagName,
			Collection<E> objs) {
		StringBuilder sb = new StringBuilder();
		for (E e : objs) {
			sb.append(e.toXMLFragment());
		}
		return getXMLTag(tagName, sb.toString());
	}

	public static String getXMLTag(String tagName, int tagValue) {
		return getXMLTag(tagName, String.valueOf(tagValue));
	}

	public static String getXMLTag(String tagName, Object tagValue) {
		return getXMLTag(tagName, String.valueOf(tagValue));
	}

	/**
	 * 
	 * 创建xml的标记值字符串
	 * 
	 * @param tagName
	 * @param tagValue
	 * @return
	 */
	public static String getXMLTag(String tagName, String tagValue) {
		if ((!"".equals(tagValue)) && (!"null".equals(tagValue))
				&& tagValue != null) {
			StringBuffer sb = new StringBuffer();
			sb.append("<");
			sb.append(tagName);
			sb.append(">");
			sb.append(tagValue);
			sb.append("</");
			sb.append(tagName);
			sb.append(">");
			return sb.toString();
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("<");
			sb.append(tagName);
			sb.append(" />");
			return sb.toString();
		}
	}

	public static interface XMLDesc {
		public String toXMLFragment();
	}
}
