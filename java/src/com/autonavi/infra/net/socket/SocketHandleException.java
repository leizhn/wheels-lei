package com.autonavi.infra.net.socket;

/**
 * Socket¥¶¿Ì“Ï≥£
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-02-11
 */

@SuppressWarnings("serial")
public class SocketHandleException extends RuntimeException {

	public SocketHandleException() {
	}

	public SocketHandleException(String message) {
		super(message);
	}

	public SocketHandleException(String message, Throwable cause) {
		super(message, cause);
	}

	public SocketHandleException(Throwable cause) {
		super(cause);
	}
}
