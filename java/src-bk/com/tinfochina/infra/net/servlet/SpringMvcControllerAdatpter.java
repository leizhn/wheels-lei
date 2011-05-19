package com.tinfochina.infra.net.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tinfochina.infra.net.servlet.handle.Handlee;

/**
 * 
 * 向Spring mvc框架service发布端点适配的类
 * 
 * @author leizhn
 * @deprecated
 * 
 * @param <E>
 */
public abstract class SpringMvcControllerAdatpter<E> implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			response(handler.handle(request), response);
		} catch (Exception e) {
			handleException(request, response, e);
		}
		return null;
	}

	public void setHandler(Handlee<E> handler) {
		this.handler = handler;
	}

	protected void handleException(HttpServletRequest request,
			HttpServletResponse response, Exception e) {
		logger.error(e.toString(), e);
	}

	/**
	 * @param handleResult
	 * @param response
	 * @throws IOException
	 */
	abstract protected void response(E handleResult,
			HttpServletResponse response) throws IOException;

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Handlee<E> handler;
}
