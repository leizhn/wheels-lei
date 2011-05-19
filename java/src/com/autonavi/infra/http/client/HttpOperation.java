package com.autonavi.infra.http.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.autonavi.infra.DataAccessException;
import com.autonavi.infra.NetAccessException;

/**
 * 
 * HTTP服务访问操作的模板回调定义，用于封装网络操作和异常
 * 
 * @author zhenhua.lei
 * 
 */
public interface HttpOperation {
	/**
	 * 向给定地址发送请求并解析response为纯文本，GET方式，使用Content-type内容进行解析
	 * 
	 * 等同于getResult(url,null,HTTPRequestMethod.GET);
	 * 
	 * @param url
	 *            请求地址
	 * @return 响应内容
	 */
	String getResult(String url) throws NetAccessException, DataAccessException;

	/**
	 * 向给定地址发送请求并解析response为纯文本，GET方式，当response头缺少Content-Type信息时，
	 * 用给定的charset设置解析文本
	 * 
	 * @param url
	 *            请求地址
	 * @param charset
	 *            强制解析用字符集（请求服务可能没有返回Content-Type信息，或该信息不完整），设置为null表示，根据Content
	 *            -Type自动识别
	 * @return
	 * @throws NetAccessException
	 * @throws DataAccessException
	 */
	String getResult(String url, Charset charset) throws NetAccessException,
			DataAccessException;

	/**
	 * 使用指定的方法向给定地址发送请求并解析response为纯文本，当response头缺少Content-Type信息时，
	 * 用给定的charset设置解析文本
	 * 
	 * @param url
	 *            请求地址
	 * @param charset
	 *            强制解析用字符集（请求服务可能没有返回Content-Type信息，或该信息不完整），设置为null表示，根据Content
	 *            -Type自动识别
	 * @param method
	 *            HTTP的请求方法，参数不能为空
	 * @return 响应内容
	 * @throws NullPointerException
	 *             当参数method为null时，抛出空指针异常
	 */
	String getResult(String url, Charset charset, HTTPRequestMethod method)
			throws NullPointerException, NetAccessException,
			DataAccessException;

	/**
	 * 向返回xml内容的服务地址发送请求（GET），并获得其根元素来进行处理
	 * 
	 * @param <T>
	 *            解析结果的类型
	 * @param url
	 *            请求资源的URL
	 * @param callback
	 *            处理资源内容的回调
	 * @return 返回回调解析结果
	 * @throws NetAccessException
	 * @throws DataAccessException
	 */
	<T> T getResult(String url, DomCallback<T> callback)
			throws NetAccessException, DataAccessException;

	/**
	 * 
	 * 使用HttpURLConnection访问服务
	 * 
	 * @param <T>
	 *            解析结果类型
	 * @param url
	 *            请求资源标识
	 * @param callback
	 *            处理资源内容的回调
	 * @return 返回回调解析结果
	 * @throws NetAccessException
	 *             可能抛出运行时异常，网络通信发生故障时
	 * 
	 */
	<T> T getResult(String url, HttpURLConnectionCallback<T> callback)
			throws NetAccessException, DataAccessException;

	/**
	 * 
	 * 向该服务地址发送请求（GET），并使用流来处理返回内容
	 * 
	 * @param <T>
	 *            解析结果类型
	 * @param url
	 *            请求资源标识
	 * @param callback
	 *            处理资源内容的回调
	 * @return 返回回调解析结果
	 * @throws NetAccessException
	 * @throws DataAccessException
	 */
	<T> T getResult(String url, InputStreamCallback<T> callback)
			throws NetAccessException, DataAccessException;

	/**
	 * 
	 * 当访问的服务返回xml时，获得其根节点
	 * 
	 * @author leizhn
	 * 
	 * @param <T>
	 *            解析结果类型
	 */
	interface DomCallback<T> {
		/**
		 * 
		 * 解析xml文档的根元素处理服务响应结果
		 * 
		 * @param root
		 *            根节点的w3c接口形式
		 * @return 解析结果
		 * @throws ParserConfigurationException
		 * @throws SAXException
		 * @throws IOException
		 * @throws DataAccessException
		 */
		T parse(Element root) throws ParserConfigurationException,
				SAXException, IOException, DataAccessException;
	}

	/**
	 * 
	 * 使客户程序使用HttpURLConnection进行处理的回调
	 * 
	 * @author leizhn
	 * 
	 * @param <T>
	 *            解析结果类型
	 */
	interface HttpURLConnectionCallback<T> {
		/**
		 * 使用传入的connection进行处理请求和响应
		 * 
		 * @param connection
		 *            标识http的链接
		 * @return 解析结果
		 * @throws IOAccessException
		 *             当通信过程发生异常时
		 */
		T parse(HttpURLConnection connection) throws IOException,
				DataAccessException;
	}

	/**
	 * 
	 * 使客户程序使用流进行处理的回调
	 * 
	 * @author leizhn
	 * 
	 * @param <T>
	 *            解析结果类型
	 */
	interface InputStreamCallback<T> {
		/**
		 * 
		 * 从InputStream中获得结果并处理该响应
		 * 
		 * @param is
		 *            返回结果的输入流形式
		 * @return 解析结果
		 * @throws IOException
		 * @throws DataAccessException
		 */
		T parse(InputStream is) throws IOException, DataAccessException;
	}
}
