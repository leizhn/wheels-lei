package com.autonavi.infra.http.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.autonavi.infra.DataAccessException;
import com.autonavi.infra.NetAccessException;
import com.autonavi.infra.http.client.HTTPRequestMethod;
import com.autonavi.infra.http.client.HttpOperation;
import com.autonavi.infra.utils.URLCoder;

/**
 * 
 * http访问的模板方法实现
 * 
 * @author zhenhua.lei
 * @version 0.2.0,2011-04-19
 * 
 */
final public class HttpTemplate implements HttpOperation {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.http.HttpOperation#getResult(java.lang.String)
	 */
	@Override
	final public String getResult(String url) {
		return this.getResult(url, null, HTTPRequestMethod.GET);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.http.HttpOperation#getResult(java.lang.String,
	 * java.nio.charset.Charset)
	 */
	@Override
	final public String getResult(String url, Charset charset)
			throws NetAccessException, DataAccessException {
		return this.getResult(url, charset, HTTPRequestMethod.GET);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.http.HttpOperation#getResult(java.lang.String,
	 * java.nio.charset.Charset,
	 * com.tinfochina.infra.net.http.HTTPRequestMethod)
	 */
	@Override
	final public String getResult(String url, final Charset charset,
			final HTTPRequestMethod method) throws NullPointerException,
			NetAccessException, DataAccessException {
		if (method == null) {
			throw new NullPointerException("Parameter method is Null ! ");
		}
		return this.getResult(url, new HttpURLConnectionCallback<String>() {

			@Override
			public String parse(HttpURLConnection connection)
					throws IOException, DataAccessException {

				connection.setRequestMethod(method.getMethodName());

				String charsetName;
				if (charset != null)
					charsetName = charset.name();
				else {
					Charset checkedCharset = URLCoder.getCharset(connection);
					if (checkedCharset == null)
						throw new DataAccessException("unknown charset ! ");
					charsetName = checkedCharset.name();
				}

				InputStream is = connection.getInputStream();
				StringBuilder sb = new StringBuilder();

				try {
					Scanner scanner = new Scanner(is, charsetName);
					while (scanner.hasNext()) {
						sb.append(scanner.nextLine());
					}
					return sb.toString();
				} catch (IllegalArgumentException e) {
					logger.debug(e.toString(), e);
					throw new DataAccessException(e);
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tinfochina.infra.net.HttpOperation#getResult(java.lang.String,
	 * com.tinfochina.infra.net.HttpOperation.DomCallback)
	 */
	@Override
	final public <T> T getResult(String url, DomCallback<T> callback)
			throws NetAccessException, DataAccessException {
		validateProtocal(url);
		HttpURLConnection connection = (HttpURLConnection) getConnection(url);
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(connection.getInputStream());
			return callback.parse(doc.getDocumentElement());
		} catch (IOException e) {
			logger.debug(e.toString(), e);
			throw new NetAccessException(e);
		} catch (ParserConfigurationException e) {
			logger.debug(e.toString(), e);
			throw new DataAccessException(e);
		} catch (SAXException e) {
			logger.debug(e.toString(), e);
			throw new DataAccessException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tinfochina.infra.net.HttpOperation#getResult(java.lang.String,
	 * com.tinfochina.infra.net.HttpOperation.HttpURLConnectionCallback)
	 */
	@Override
	final public <T> T getResult(String url, HttpURLConnectionCallback<T> callback)
			throws NetAccessException, DataAccessException {
		validateProtocal(url);
		HttpURLConnection connection = (HttpURLConnection) getConnection(url);
		try {
			return callback.parse(connection);
		} catch (IOException e) {
			logger.debug(e.toString(), e);
			throw new NetAccessException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tinfochina.infra.net.HttpOperation#getResult(java.lang.String,
	 * com.tinfochina.infra.net.HttpOperation.InputStreamCallback)
	 */
	@Override
	final public <T> T getResult(String url, InputStreamCallback<T> callback)
			throws NetAccessException, DataAccessException {
		validateProtocal(url);
		HttpURLConnection connection = (HttpURLConnection) getConnection(url);
		try {
			return callback.parse(connection.getInputStream());
		} catch (IOException e) {
			logger.debug(e.toString(), e);
			throw new NetAccessException(e);
		}
	}

	/**
	 * 设置连接超时，单位毫秒，0为不设超时
	 * 
	 * @param connectTimeout
	 */
	final public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	/**
	 * 设置读超时，单位毫秒，0为不设超时
	 * 
	 * @param readTimeout
	 */
	final public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	/**
	 * 
	 * @param urlStr
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private URLConnection getConnection(String urlStr)
			throws NetAccessException {
		logger.info("{}", urlStr);
		try {
			URL url = new URL(urlStr);
			URLConnection connection = url.openConnection();
			connection.setReadTimeout(readTimeout);
			connection.setConnectTimeout(connectTimeout);
			return connection;
		} catch (MalformedURLException e) {
			logger.debug(e.toString(), e);
			throw new NetAccessException(e);
		} catch (IOException e) {
			logger.debug(e.toString(), e);
			throw new NetAccessException(e);
		}

	}

	/**
	 * @param url
	 */
	private void validateProtocal(String url) {
		if (!url.toLowerCase().startsWith("http://")) {
			String message = "protocal error, " + url;
			throw new DataAccessException(message);
		}
	}

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private int connectTimeout;

	private int readTimeout;
}
