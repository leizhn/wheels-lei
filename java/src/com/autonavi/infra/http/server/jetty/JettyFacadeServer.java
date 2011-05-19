package com.autonavi.infra.http.server.jetty;

import java.util.Map;

import javax.servlet.Servlet;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 * 
 * JETTY ���ü����ͣ�Ϊ����Ƕ��ʽ����Ӧ����������Ϊ/
 * 
 * @author zhenhua.lei
 * @version 0.2.0,2011-4-19
 */
final public class JettyFacadeServer {
	/**
	 * ���÷������˿ں�
	 * 
	 * @param port
	 *            �������˿ں�
	 */
	final public void setPort(int port) {
		this.port = port;
	}

	/**
	 * �趨servlet��path�Ķ�Ӧ��ϵ
	 * 
	 * @param urlmapping
	 *            servlet��path�Ķ�Ӧ��ϵ
	 */
	final public void setUrlmapping(Map<String, Servlet> urlmapping) {
		this.urlmapping = urlmapping;
	}

	/**
	 * ����������
	 * 
	 * @throws Exception
	 */
	final public void start() throws Exception {
		server = new Server(port);
		Context context = new Context(server, "/", Context.SESSIONS);
		for (Map.Entry<String, Servlet> entry : urlmapping.entrySet()) {
			context.addServlet(new ServletHolder(entry.getValue()),
					entry.getKey());
		}
		server.start();
	}

	/**
	 * ��������ֹ
	 * 
	 * @throws Exception
	 */
	final public void stop() throws Exception {
		server.stop();
	}

	private int port;

	private Server server;

	private Map<String, Servlet> urlmapping;

}
