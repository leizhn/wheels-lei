package com.autonavi.infra.net.socket;

/**
 * �����ô�������
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-02-16
 */
public interface ConfigurableTransportServer {
	/**
	 * �����Զ˿ڵ�����
	 */
	void listening();

	/**
	 * ����Ҫ�����Ķ˿�
	 * 
	 * @param port
	 *            Ҫ�����Ķ˿�
	 */
	void setPort(int port);
}
