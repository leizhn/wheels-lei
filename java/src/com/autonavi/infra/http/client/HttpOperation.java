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
 * HTTP������ʲ�����ģ��ص����壬���ڷ�װ����������쳣
 * 
 * @author zhenhua.lei
 * 
 */
public interface HttpOperation {
	/**
	 * �������ַ�������󲢽���responseΪ���ı���GET��ʽ��ʹ��Content-type���ݽ��н���
	 * 
	 * ��ͬ��getResult(url,null,HTTPRequestMethod.GET);
	 * 
	 * @param url
	 *            �����ַ
	 * @return ��Ӧ����
	 */
	String getResult(String url) throws NetAccessException, DataAccessException;

	/**
	 * �������ַ�������󲢽���responseΪ���ı���GET��ʽ����responseͷȱ��Content-Type��Ϣʱ��
	 * �ø�����charset���ý����ı�
	 * 
	 * @param url
	 *            �����ַ
	 * @param charset
	 *            ǿ�ƽ������ַ���������������û�з���Content-Type��Ϣ�������Ϣ��������������Ϊnull��ʾ������Content
	 *            -Type�Զ�ʶ��
	 * @return
	 * @throws NetAccessException
	 * @throws DataAccessException
	 */
	String getResult(String url, Charset charset) throws NetAccessException,
			DataAccessException;

	/**
	 * ʹ��ָ���ķ����������ַ�������󲢽���responseΪ���ı�����responseͷȱ��Content-Type��Ϣʱ��
	 * �ø�����charset���ý����ı�
	 * 
	 * @param url
	 *            �����ַ
	 * @param charset
	 *            ǿ�ƽ������ַ���������������û�з���Content-Type��Ϣ�������Ϣ��������������Ϊnull��ʾ������Content
	 *            -Type�Զ�ʶ��
	 * @param method
	 *            HTTP�����󷽷�����������Ϊ��
	 * @return ��Ӧ����
	 * @throws NullPointerException
	 *             ������methodΪnullʱ���׳���ָ���쳣
	 */
	String getResult(String url, Charset charset, HTTPRequestMethod method)
			throws NullPointerException, NetAccessException,
			DataAccessException;

	/**
	 * �򷵻�xml���ݵķ����ַ��������GET������������Ԫ�������д���
	 * 
	 * @param <T>
	 *            �������������
	 * @param url
	 *            ������Դ��URL
	 * @param callback
	 *            ������Դ���ݵĻص�
	 * @return ���ػص��������
	 * @throws NetAccessException
	 * @throws DataAccessException
	 */
	<T> T getResult(String url, DomCallback<T> callback)
			throws NetAccessException, DataAccessException;

	/**
	 * 
	 * ʹ��HttpURLConnection���ʷ���
	 * 
	 * @param <T>
	 *            �����������
	 * @param url
	 *            ������Դ��ʶ
	 * @param callback
	 *            ������Դ���ݵĻص�
	 * @return ���ػص��������
	 * @throws NetAccessException
	 *             �����׳�����ʱ�쳣������ͨ�ŷ�������ʱ
	 * 
	 */
	<T> T getResult(String url, HttpURLConnectionCallback<T> callback)
			throws NetAccessException, DataAccessException;

	/**
	 * 
	 * ��÷����ַ��������GET������ʹ����������������
	 * 
	 * @param <T>
	 *            �����������
	 * @param url
	 *            ������Դ��ʶ
	 * @param callback
	 *            ������Դ���ݵĻص�
	 * @return ���ػص��������
	 * @throws NetAccessException
	 * @throws DataAccessException
	 */
	<T> T getResult(String url, InputStreamCallback<T> callback)
			throws NetAccessException, DataAccessException;

	/**
	 * 
	 * �����ʵķ��񷵻�xmlʱ���������ڵ�
	 * 
	 * @author leizhn
	 * 
	 * @param <T>
	 *            �����������
	 */
	interface DomCallback<T> {
		/**
		 * 
		 * ����xml�ĵ��ĸ�Ԫ�ش��������Ӧ���
		 * 
		 * @param root
		 *            ���ڵ��w3c�ӿ���ʽ
		 * @return �������
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
	 * ʹ�ͻ�����ʹ��HttpURLConnection���д���Ļص�
	 * 
	 * @author leizhn
	 * 
	 * @param <T>
	 *            �����������
	 */
	interface HttpURLConnectionCallback<T> {
		/**
		 * ʹ�ô����connection���д����������Ӧ
		 * 
		 * @param connection
		 *            ��ʶhttp������
		 * @return �������
		 * @throws IOAccessException
		 *             ��ͨ�Ź��̷����쳣ʱ
		 */
		T parse(HttpURLConnection connection) throws IOException,
				DataAccessException;
	}

	/**
	 * 
	 * ʹ�ͻ�����ʹ�������д���Ļص�
	 * 
	 * @author leizhn
	 * 
	 * @param <T>
	 *            �����������
	 */
	interface InputStreamCallback<T> {
		/**
		 * 
		 * ��InputStream�л�ý�����������Ӧ
		 * 
		 * @param is
		 *            ���ؽ������������ʽ
		 * @return �������
		 * @throws IOException
		 * @throws DataAccessException
		 */
		T parse(InputStream is) throws IOException, DataAccessException;
	}
}
