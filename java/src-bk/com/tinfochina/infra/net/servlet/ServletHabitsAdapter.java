package com.tinfochina.infra.net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tinfochina.infra.net.servlet.handle.Handlee;

/**
 * 
 * 和Servlet框架适配，HttpServlet适合嵌入式Jetty，Controller通过Spring MVC适应托管容器
 * 
 * @author leizhn
 * @version 0.1.0,2010-11-15
 * @param <E>
 * @deprecated
 */
public abstract class ServletHabitsAdapter<E> extends HttpServlet implements
		Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.doPost(request, response);
		return null;
	}

	public void setHandler(Handlee<E> handler) {
		this.handler = handler;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response(handler.handle(request), response);
	}

	abstract protected void response(E handleResult,
			HttpServletResponse response) throws IOException;

	private Handlee<E> handler;

	private static final long serialVersionUID = -7966122445654239544L;
}
