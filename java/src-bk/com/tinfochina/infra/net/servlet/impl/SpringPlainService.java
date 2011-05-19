package com.tinfochina.infra.net.servlet.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.tinfochina.infra.net.servlet.SpringMvcControllerAdatpter;

@Deprecated
public class SpringPlainService extends SpringMvcControllerAdatpter<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.servlet.SpringMvcControllerAdatpter#response
	 * (java.lang.Object, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void response(String handleResult, HttpServletResponse response)
			throws IOException {
		response.getWriter().write(handleResult);
	}

}
