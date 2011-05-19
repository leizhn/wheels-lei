package com.autonavi.infra;

/**
 * 
 * 系统初始化过程抛出此异常
 * 
 * @author zhenhua.lei
 * @deprecated
 */
@SuppressWarnings("serial")
public class InitializeException extends RuntimeException {

	public InitializeException() {
	}

	public InitializeException(String message) {
		super(message);
	}

	public InitializeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InitializeException(Throwable cause) {
		super(cause);
	}
}
