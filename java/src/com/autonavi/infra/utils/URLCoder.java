package com.autonavi.infra.utils;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * URLEncoder和URLDecoder，及URL请求相关方法异常处理封装和工具函数
 * 
 * 当给定的字符集无法识别时，使用系统缺省字符集
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-04-20
 */
final public class URLCoder {
	final public static String decode(String content, Charset charset) {
		try {
			return URLDecoder.decode(content, charset.name());
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e.toString(), e);
		}
	}

	/**
	 * 对URLDecoder#decode的封装
	 * 
	 * @param content
	 *            要解析的字串
	 * @param charsetName
	 *            解析用的字符集名称
	 * @return 解码后的字符串
	 */
	final public static String decode(String content, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return decode(content, charset);
	}

	final public static String encode(String content, Charset charset) {
		try {
			return URLEncoder.encode(content, charset.name());
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e.toString(), e);
		}
	}

	/**
	 * 对URLEncoder#encode的封装
	 * 
	 * @param content
	 *            要编码的字串
	 * @param charsetName
	 *            用来编码的字符集
	 * @return 编码后的字串
	 */
	final public static String encode(String content, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return encode(content, charset);
	}

	/**
	 * 解析指定URLConnection中服务端给出的字符集设置值，如果没有这个段设置，返回null
	 * 
	 * @param connection
	 *            要解析的连接
	 * @return 字符集，如果没有Content-Type段设置，或设置的内容没有charset，或charset值无法识别，则返回null
	 */
	final public static Charset getCharset(HttpURLConnection connection) {
		String headerFieldContentType = connection
				.getHeaderField("Content-Type");
		if (headerFieldContentType == null) {
			logger.warn("no field Content-Type in URL : [{}]",
					connection.getURL());
			return null;
		}
		int start = headerFieldContentType.indexOf("=");
		String charsetName = headerFieldContentType.substring(start + 1);
		try {
			return Charset.forName(charsetName);
		} catch (RuntimeException e) {
			logger.warn("value of charset name : [{}]", charsetName);
			logger.warn(e.toString(), e);
			return null;
		}
	}
	final static Logger logger = LoggerFactory.getLogger(URLCoder.class);
}
