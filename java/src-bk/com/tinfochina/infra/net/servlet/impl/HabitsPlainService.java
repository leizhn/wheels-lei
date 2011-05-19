package com.tinfochina.infra.net.servlet.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.tinfochina.infra.net.servlet.ServletHabitsAdapter;

/**
 * 非REST类型返回纯文本响应的服务
 * 
 * @author leizhn
 * @version 0.1.0,2010-11-15
 * @deprecated
 */
public class HabitsPlainService extends ServletHabitsAdapter<String> {

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.servlet.ServletHabitsAdapter#response(java.lang
	 * .Object, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void response(String handleResult, HttpServletResponse response)
			throws IOException {
		response.setContentType(contentType);
		response.getWriter().write(handleResult);
	}

	private String contentType = "text/xml;charset=utf-8";
	private static final long serialVersionUID = -9120871681906221461L;
}
