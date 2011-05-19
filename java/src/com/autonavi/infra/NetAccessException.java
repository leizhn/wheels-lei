package com.autonavi.infra;


/**
 * 网络访问异常类型
 * 
 * @author zhenhua.lei
 * @version 0.2.0,2011-4-19
 */
@SuppressWarnings("serial")
final public class NetAccessException extends DataAccessException {

	public NetAccessException() {
	}

	public NetAccessException(String message) {
		super(message);
	}

	public NetAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public NetAccessException(Throwable cause) {
		super(cause);
	}
}
