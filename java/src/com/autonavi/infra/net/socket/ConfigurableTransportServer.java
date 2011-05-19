package com.autonavi.infra.net.socket;

/**
 * 可配置传输层服务
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-02-16
 */
public interface ConfigurableTransportServer {
	/**
	 * 启动对端口的侦听
	 */
	void listening();

	/**
	 * 设置要侦听的端口
	 * 
	 * @param port
	 *            要侦听的端口
	 */
	void setPort(int port);
}
