package com.autonavi.infra.net.socket;

@SuppressWarnings("serial")
final public class SimpleSocketHandleException extends RuntimeException {

	public SimpleSocketHandleException() {
	}

	public SimpleSocketHandleException(String message) {
		super(message);
	}

	public SimpleSocketHandleException(String message, Throwable cause) {
		super(message, cause);
	}

	public SimpleSocketHandleException(Throwable cause) {
		super(cause);
	}

}
