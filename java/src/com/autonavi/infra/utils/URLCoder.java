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
 * URLEncoder��URLDecoder����URL������ط����쳣�����װ�͹��ߺ���
 * 
 * ���������ַ����޷�ʶ��ʱ��ʹ��ϵͳȱʡ�ַ���
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
	 * ��URLDecoder#decode�ķ�װ
	 * 
	 * @param content
	 *            Ҫ�������ִ�
	 * @param charsetName
	 *            �����õ��ַ�������
	 * @return �������ַ���
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
	 * ��URLEncoder#encode�ķ�װ
	 * 
	 * @param content
	 *            Ҫ������ִ�
	 * @param charsetName
	 *            ����������ַ���
	 * @return �������ִ�
	 */
	final public static String encode(String content, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return encode(content, charset);
	}

	/**
	 * ����ָ��URLConnection�з���˸������ַ�������ֵ�����û����������ã�����null
	 * 
	 * @param connection
	 *            Ҫ����������
	 * @return �ַ��������û��Content-Type�����ã������õ�����û��charset����charsetֵ�޷�ʶ���򷵻�null
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
