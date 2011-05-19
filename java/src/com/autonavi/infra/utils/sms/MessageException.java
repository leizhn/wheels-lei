package com.autonavi.infra.utils.sms;

/**
 * 消息发送异常
 * 
 * @author zhenhua.lei
 * @version 0.2.0,2011-03-08
 */
public class MessageException extends RuntimeException {

	public MessageException() {
	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -8069682178676413463L;
}
