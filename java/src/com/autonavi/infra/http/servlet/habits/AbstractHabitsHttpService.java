package com.autonavi.infra.http.servlet.habits;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 兼容Spring MVC和JETTY的SERVLET“实例化”注入配置两种接口
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-4-19
 */
@SuppressWarnings("serial")
public abstract class AbstractHabitsHttpService extends HttpServlet implements
		Controller {

	@Override
	final public void destroy() {
		super.destroy();
	}

	@Override
	final public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		handle(request, response);
		return null;
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
	final protected void doDelete(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
	}

	@Override
	final protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		bridgeServletMethod(req, resp);
	}

	@Override
	final protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doHead(req, resp);
	}

	@Override
	final protected void doOptions(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		super.doOptions(arg0, arg1);
	}

	@Override
	final protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		bridgeServletMethod(req, resp);
	}

	@Override
	final protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPut(req, resp);
	}

	@Override
	final protected void doTrace(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doTrace(request, response);
	}

	/**
	 * 简化Spring MVC的接口，仅保留方法签名，不包括返回值，拒绝服务端MVC
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	abstract protected void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
