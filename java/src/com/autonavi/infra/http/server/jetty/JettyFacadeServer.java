package com.autonavi.infra.http.server.jetty;

import java.util.Map;

import javax.servlet.Servlet;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 * 
 * JETTY 配置简化类型，为方便嵌入式服务，应用上下文设为/
 * 
 * @author zhenhua.lei
 * @version 0.2.0,2011-4-19
 */
final public class JettyFacadeServer {
	/**
	 * 设置服务器端口号
	 * 
	 * @param port
	 *            服务器端口号
	 */
	final public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 设定servlet和path的对应关系
	 * 
	 * @param urlmapping
	 *            servlet和path的对应关系
	 */
	final public void setUrlmapping(Map<String, Servlet> urlmapping) {
		this.urlmapping = urlmapping;
	}

	/**
	 * 服务器启动
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
	 * 服务器终止
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
