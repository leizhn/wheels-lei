package com.autonavi.infra.net.socket;

@SuppressWarnings("serial")
public class SimpleSocketException extends RuntimeException {

	public SimpleSocketException() {
	}

	public SimpleSocketException(String message) {
		super(message);
	}

	public SimpleSocketException(String message, Throwable cause) {
		super(message, cause);
	}

	public SimpleSocketException(Throwable cause) {
		super(cause);
	}

}
