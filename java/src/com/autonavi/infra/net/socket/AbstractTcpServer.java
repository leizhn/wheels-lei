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
 * socket服务器
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
	 * 设置触发处理的线程资源池
	 * 
	 * @param handleExecutor
	 */
	final public void setHandleExecutor(ExecutorService handleExecutor) {
		this.handleExecutor = handleExecutor;
	}

	/**
	 * 设置监听端口用的线程池
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
	 * 设置accept超时，如不设置，缺省5秒
	 * 
	 * @param timeoutOfAccept
	 *            超时的毫秒值
	 */
	final public void setTimeoutOfAccept(int timeoutOfAccept) {
		this.timeoutOfAccept = timeoutOfAccept;
	}

	/**
	 * 返回socket处理执行函数对象
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