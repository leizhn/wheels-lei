package com.tinfochina.infra.net.servlet.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.tinfochina.infra.net.Bytesable;
import com.tinfochina.infra.net.servlet.SpringMvcControllerAdatpter;

@Deprecated
public class SpringBytesableService extends
		SpringMvcControllerAdatpter<Bytesable> {

	@Override
	protected void response(Bytesable handleResult, HttpServletResponse response)
			throws IOException {
		response.getOutputStream().write(handleResult.toBytes());
	}

}
