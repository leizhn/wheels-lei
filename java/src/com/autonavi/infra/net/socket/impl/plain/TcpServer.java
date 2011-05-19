package com.autonavi.infra.net.socket.impl.plain;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.net.socket.AbstractTcpServer;
import com.autonavi.infra.net.socket.PlainSocketHandlee;
import com.autonavi.infra.net.socket.SocketHandleException;

/**
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-18
 */
final public class TcpServer extends AbstractTcpServer {

	final public void setHandler(PlainSocketHandlee handler) {
		this.handler = handler;
	}

	final public void setTimeoutOfRead(int timeoutOfRead) {
		this.timeoutOfRead = timeoutOfRead;
	}

	@Override
	protected Runnable getHandlee(Socket client) {
		return new HandleRunnable(client);
	}

	private PlainSocketHandlee handler;

	private int timeoutOfRead = 0;
	final static Logger logger = LoggerFactory.getLogger(TcpServer.class);

	final private class HandleRunnable implements Runnable {
		private HandleRunnable(Socket client) {
			this.client = client;
			this.remoteDetail = client.getRemoteSocketAddress().toString();
		}

		@Override
		public void run() {
			boolean needActive = false;
			try {
				client.setSoTimeout(timeoutOfRead);
				needActive = handler.handle(client);
			} catch (SocketHandleException e) {
				logger.error(e.toString(), e);
			} catch (SocketTimeoutException e) {
				logger.error(e.toString(), e);
			} catch (SocketException e) {
				logger.error(e.toString(), e);
			} catch (IOException e) {
				logger.error(e.toString(), e);
			} catch (RuntimeException e) {
				logger.error(e.toString(), e);
			} finally {
				if (!needActive)
					close();
				logger.debug("after client socket handle [{}]", remoteDetail);
			}
		}

		private void close() {
			try {
				client.close();
				logger.debug("client socket closed [{}]", remoteDetail);
			} catch (SocketException e) {
				logger.warn("client socket already closed [{}]", remoteDetail);
				logger.debug(e.toString(), e);
			} catch (IOException e) {
				logger.error(e.toString(), e);
			}
		}

		private final Socket client;
		private String remoteDetail;
	}
}
