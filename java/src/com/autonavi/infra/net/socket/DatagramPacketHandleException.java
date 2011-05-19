package com.autonavi.infra.net.socket;

/**
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-11
 */
@SuppressWarnings("serial")
final public class DatagramPacketHandleException extends RuntimeException {
	public DatagramPacketHandleException() {
		super();
	}

	public DatagramPacketHandleException(String message) {
		super(message);
	}

	public DatagramPacketHandleException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatagramPacketHandleException(Throwable cause) {
		super(cause);
	}
}