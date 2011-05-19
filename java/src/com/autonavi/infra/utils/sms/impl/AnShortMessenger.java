package com.autonavi.infra.utils.sms.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.DataAccessException;
import com.autonavi.infra.http.client.HttpOperation;
import com.autonavi.infra.http.client.HttpOperation.InputStreamCallback;
import com.autonavi.infra.utils.sms.MessageException;
import com.autonavi.infra.utils.sms.ShortMessageSendee;

/**
 * 高德短信通道发送实现
 * 
 * @author leizhn
 * @version 0.1.0,20101111
 * 
 */
public class AnShortMessenger implements ShortMessageSendee {

	/**
	 * 初始化读入配置参数
	 */
	public void init() {
		if (numbers == null)
			return;
		phoneNumbers = new ArrayList<String>();
		String[] _numbers = numbers.split(",");
		for (String number : _numbers) {
			phoneNumbers.add(number);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.message.ShortMessageSendee#send(java.lang.String)
	 */
	@Override
	public void send(String body) throws MessageException {
		String result = httpOperation.getResult(getQueryUrl(body),
				new InputStreamCallback<String>() {

					@Override
					public String parse(InputStream is) throws IOException,
							DataAccessException {
						StringBuilder sb = new StringBuilder();
						Scanner scanner = new Scanner(is);
						while (scanner.hasNext()) {
							sb.append(scanner.nextLine());
						}
						return sb.toString();
					}

				});
		logger.debug("sms service response : {}", result);
	}

	/**
	 * 设定http操作模板实例
	 * 
	 * @param httpOperation
	 *            http操作模板实例
	 */
	public void setHttpOperation(HttpOperation httpOperation) {
		this.httpOperation = httpOperation;
	}

	/**
	 * 设置短信发送服务用户名
	 * 
	 * @param name
	 *            短信发送服务用户名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设定接收短信号码列表，用逗号分隔，配置此项后会覆盖通过setPhoneNumbers所设置的值
	 * 
	 * @param numbers
	 *            接收短信号码列表
	 */
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	/**
	 * 设定短信发送服务口令
	 * 
	 * @param password
	 *            短信发送服务口令
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 设定接收短信号码列表
	 * 
	 * @param phoneNumbers
	 *            接收短信号码列表
	 */
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * 设定短信发送通道服务地址
	 * 
	 * @param serviceUrl
	 *            短信发送通道服务地址
	 */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	private String getEncodingBody(String body) {
		try {
			return URLEncoder.encode(body, Charset.defaultCharset().name());
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private String getPhones() {
		StringBuilder sb = new StringBuilder();
		for (String phoneNumber : phoneNumbers) {
			sb.append("&mobiles=");
			sb.append(phoneNumber);
		}
		return sb.toString();
	}

	private String getQueryUrl(String body) {
		StringBuilder sb = new StringBuilder();
		sb.append(serviceUrl);
		sb.append("?name=");
		sb.append(name);
		sb.append("&password=");
		sb.append(password);
		sb.append(getPhones());
		sb.append("&content=");
		sb.append(getEncodingBody(body));
		return sb.toString();
	}

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	private HttpOperation httpOperation;
	private String name;
	private String numbers = null;
	private String password;
	private List<String> phoneNumbers;

	private String serviceUrl;
}
