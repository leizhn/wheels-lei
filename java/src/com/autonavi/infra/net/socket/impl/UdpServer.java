package com.autonavi.infra.net.socket.impl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.IllegalBlockingModeException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.net.socket.ConfigurableTransportServer;
import com.autonavi.infra.net.socket.DatagramPacketHandlee;
import com.autonavi.infra.net.socket.DatagramPacketHandleException;

/**
 * @author zhenhua.lei
 * @version 0.1.1,2011-03-15
 */
final public class UdpServer implements ConfigurableTransportServer {
	@Override
	final public void listening() {
		receivExcutors.execute(new Runnable() {
			@Override
			public void run() {
				DatagramSocket datagramSocket;
				try {
					datagramSocket = new DatagramSocket(port);

					datagramSocket.setSoTimeout(timeout);
					datagramSocket.setReceiveBufferSize(receiveBufferSize);
				} catch (SocketException e) {
					throw new RuntimeException(e);
				}

				for (;;) {
					final DatagramPacket dp = getDatagramPacket();
					try {
						datagramSocket.receive(dp);
						handleExcutors.execute(new Runnable() {
							@Override
							public void run() {
								try {
									datagramPackethandler.handle(dp);
								} catch (DatagramPacketHandleException e) {
									logger.error(e.toString(), e);
								}
							}
						});
					} catch (SocketTimeoutException e) {
						logger.trace("waiting read timeout", e);
					} catch (IOException e) {
						logger.debug(e.toString(), e);
					} catch (IllegalBlockingModeException e) {
						logger.debug(e.toString(), e);
					}
				}
			}
		});

	}

	final public void setDatagramPackethandler(
			DatagramPacketHandlee datagramPackethandler) {
		this.datagramPackethandler = datagramPackethandler;
	}

	@Override
	final public void setPort(int port) {
		this.port = port;
	}

	final public void setReceiveBufferSize(int receiveBufferSize) {
		this.receiveBufferSize = receiveBufferSize;
	}

	final public void setSize(int size) {
		this.size = size;
	}

	final public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	private DatagramPacket getDatagramPacket() {
		byte[] buffer = new byte[size];
		return new DatagramPacket(buffer, buffer.length);
	}

	private DatagramPacketHandlee datagramPackethandler;

	private ExecutorService handleExcutors = Executors.newCachedThreadPool();

	private int port;
	private int receiveBufferSize = 1024 * 1024 * 10;

	private ExecutorService receivExcutors = Executors
			.newSingleThreadExecutor();
	private int size = 200;
	private int timeout = 0;

	final static Logger logger = LoggerFactory.getLogger(UdpServer.class);
}
