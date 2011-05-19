package com.tinfochina.infra.net.service.plain;

/**
 * WebPlainResult的生成服务过程的不可恢复异常
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100530
 * @deprecated
 */
public class WebPlainResultException extends RuntimeException {

	public WebPlainResultException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = -5358734221193271276L;

}
