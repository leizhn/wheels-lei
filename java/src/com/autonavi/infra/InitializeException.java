package com.autonavi.infra;

/**
 * 
 * ϵͳ��ʼ�������׳����쳣
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
