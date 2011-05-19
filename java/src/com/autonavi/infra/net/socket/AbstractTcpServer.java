package com.autonavi.infra.net.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.DataAccessException;

/**
 * socket������
 * 
 * @author zhenhua.lei
 * @version 0.1.2,2011-03-18
 */
public abstract class AbstractTcpServer implements ConfigurableTransportServer {

	@Override
	final public void listening() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			server.setSoTimeout(timeoutOfAccept);
		} catch (IOException e) {
			logger.debug(e.toString(), e);
			throw new DataAccessException(e);
		}
		listenExecutor.execute(new Listenable(server));
	}

	/**
	 * ���ô���������߳���Դ��
	 * 
	 * @param handleExecutor
	 */
	final public void setHandleExecutor(ExecutorService handleExecutor) {
		this.handleExecutor = handleExecutor;
	}

	/**
	 * ���ü����˿��õ��̳߳�
	 * 
	 * @param listenExecutor
	 */
	final public void setListenExecutor(ExecutorService listenExecutor) {
		this.listenExecutor = listenExecutor;
	}

	@Override
	final public void setPort(int port) {
		this.port = port;
	}

	/**
	 * ����accept��ʱ���粻���ã�ȱʡ5��
	 * 
	 * @param timeoutOfAccept
	 *            ��ʱ�ĺ���ֵ
	 */
	final public void setTimeoutOfAccept(int timeoutOfAccept) {
		this.timeoutOfAccept = timeoutOfAccept;
	}

	/**
	 * ����socket����ִ�к�������
	 * 
	 * @param client
	 * @return
	 */
	abstract protected Runnable getHandlee(Socket client);

	private ExecutorService handleExecutor = Executors.newCachedThreadPool();
	private ExecutorService listenExecutor = Executors
			.newSingleThreadExecutor();
	private int port;
	private int timeoutOfAccept = 5000;

	final static Logger logger = LoggerFactory
			.getLogger(AbstractTcpServer.class);

	private final class Listenable implements Runnable {
		Listenable(ServerSocket server) {
			this.server = server;
		}

		@Override
		public void run() {
			logger.info("start listen : {}", port);
			while (true) {
				Socket client;
				try {
					logger.debug("waiting accept !");
					client = server.accept();
					handleExecutor.execute(getHandlee(client));
				} catch (SocketTimeoutException e) {
					logger.trace("waiting accept timeout!", e);
				} catch (SocketHandleException e) {
					logger.error(e.toString(), e);
				} catch (IOException e) {
					logger.error(e.toString(), e);
				}
			}
		}

		private ServerSocket server;
	}

}