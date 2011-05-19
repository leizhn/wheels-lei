package com.tinfochina.infra.net.servlet.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.tinfochina.infra.net.Bytesable;
import com.tinfochina.infra.net.servlet.ServletHabitsAdapter;

/**
 * 
 * 非REST类型，响应结果为二进制的服务
 * 
 * @author leizhn
 * @deprecated
 * 
 */
public class HabitsBytesableService extends ServletHabitsAdapter<Bytesable> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.servlet.ServletHabitsAdapter#response(java.lang
	 * .Object, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void response(Bytesable handleResult, HttpServletResponse response)
			throws IOException {
		response.getOutputStream().write(handleResult.toBytes());

	}

	private static final long serialVersionUID = -4881464527254672719L;

}
