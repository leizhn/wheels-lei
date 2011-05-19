package com.autonavi.infra.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final public class SimpleSocket {
	public SimpleSocket(Socket socket) {
		this.socket = socket;
		this.remoteInfo = socket.getRemoteSocketAddress().toString();
	}

	final public void close() throws SimpleSocketException {
		try {
			socket.close();
			logger.debug("socket closed [{}]", remoteInfo);
		} catch (IOException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public SocketChannel getChannel() {
		return socket.getChannel();
	}

	final public InetAddress getInetAddress() {
		return socket.getInetAddress();
	}

	final public InputStream getInputStream() throws SimpleSocketException {
		try {
			return socket.getInputStream();
		} catch (IOException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public boolean getKeepAlive() throws SimpleSocketException {
		try {
			return socket.getKeepAlive();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public InetAddress getLocalAddress() {
		return socket.getLocalAddress();
	}

	final public int getLocalPort() {
		return socket.getLocalPort();
	}

	final public SocketAddress getLocalSocketAddress() {
		return socket.getLocalSocketAddress();
	}

	final public boolean getOOBInline() throws SimpleSocketException {
		try {
			return socket.getOOBInline();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public OutputStream getOutputStream() throws SimpleSocketException {
		try {
			return socket.getOutputStream();
		} catch (IOException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public int getPort() {
		return socket.getPort();
	}

	final public int getReceiveBufferSize() throws SimpleSocketException {
		try {
			return socket.getReceiveBufferSize();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public SocketAddress getRemoteSocketAddress() {
		return socket.getRemoteSocketAddress();
	}

	final public boolean getReuseAddress() throws SimpleSocketException {
		try {
			return socket.getReuseAddress();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public int getSendBufferSize() throws SimpleSocketException {
		try {
			return socket.getSendBufferSize();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public int getSoLinger() throws SimpleSocketException {
		try {
			return socket.getSoLinger();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public int getSoTimeout() throws SimpleSocketException {
		try {
			return socket.getSoTimeout();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public boolean getTcpNoDelay() throws SimpleSocketException {
		try {
			return socket.getTcpNoDelay();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public int getTrafficClass() throws SimpleSocketException {
		try {
			return socket.getTrafficClass();
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public boolean isBound() {
		return socket.isBound();
	}

	final public boolean isClosed() {
		return socket.isClosed();
	}

	final public boolean isConnected() {
		return socket.isConnected();
	}

	final public boolean isInputShutdown() {
		return socket.isInputShutdown();
	}

	final public boolean isOutputShutdown() {
		return socket.isOutputShutdown();
	}

	final public void sendUrgentData(int data) throws SimpleSocketException {
		try {
			socket.sendUrgentData(data);
		} catch (IOException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setKeepAlive(boolean on) throws SimpleSocketException {
		try {
			socket.setKeepAlive(on);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setOOBInline(boolean on) throws SimpleSocketException {
		try {
			socket.setOOBInline(on);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setPerformancePreferences(int connectionTime,
			int latency, int bandwidth) {
		socket.setPerformancePreferences(connectionTime, latency, bandwidth);
	}

	final public void setReceiveBufferSize(int size)
			throws SimpleSocketException {
		try {
			socket.setReceiveBufferSize(size);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setReuseAddress(boolean on) throws SimpleSocketException {
		try {
			socket.setReuseAddress(on);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setSendBufferSize(int size) throws SimpleSocketException {
		try {
			socket.setSendBufferSize(size);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setSoLinger(boolean on, int linger)
			throws SimpleSocketException {
		try {
			socket.setSoLinger(on, linger);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setSoTimeout(int timeout) throws SimpleSocketException {
		try {
			socket.setSoTimeout(timeout);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setTcpNoDelay(boolean on) throws SimpleSocketException {
		try {
			socket.setTcpNoDelay(on);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void setTrafficClass(int tc) throws SimpleSocketException {
		try {
			socket.setTrafficClass(tc);
		} catch (SocketException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void shutdownInput() throws SimpleSocketException {
		try {
			socket.shutdownInput();
		} catch (IOException e) {
			throw new SimpleSocketException(e);
		}
	}

	final public void shutdownOutput() throws SimpleSocketException {
		try {
			socket.shutdownOutput();
		} catch (IOException e) {
			throw new SimpleSocketException(e);
		}
	}

	private String remoteInfo;

	final private Socket socket;
	final static Logger logger = LoggerFactory.getLogger(SimpleSocket.class);
}
