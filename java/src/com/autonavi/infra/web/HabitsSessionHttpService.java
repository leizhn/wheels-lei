package com.autonavi.infra.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public abstract class HabitsSessionHttpService<E> extends HttpServlet implements
		Controller {
	@Override
	final public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		handleRequest(request, response, sessionChecker);
		return null;
	}

	final public void setSessionChecker(SessionPickee<E> sessionChecker) {
		this.sessionChecker = sessionChecker;
	}

	protected void bridgeServletMethod(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			handleRequest(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	final protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		bridgeServletMethod(req, resp);
	}

	@Override
	final protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		bridgeServletMethod(req, resp);
	}

	/**
	 * @param request
	 *            «Î«Û
	 * @param response
	 *            œÏ”¶
	 * @param sessionChecker
	 *            sessionºÏ≤È∆˜
	 * @throws IOException
	 */
	abstract protected void handleRequest(HttpServletRequest request,
			HttpServletResponse response, SessionPickee<E> sessionChecker)
			throws IOException;

	private SessionPickee<E> sessionChecker;

	private static final long serialVersionUID = -8011315076314507622L;

}
