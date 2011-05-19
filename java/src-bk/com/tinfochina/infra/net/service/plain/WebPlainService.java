package com.tinfochina.infra.net.service.plain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 一个包含跨域请求数据的参数处理，同时满足Servlet规范和spring MVC的接口，在两种环境下均适用
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100901
 * @deprecated
 */
public class WebPlainService extends HttpServlet implements Controller {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.doPost(request, response);
		return null;
	}

	public void setDefaultResultProvider(
			WebPlainResultGeneratee defaultResultProvider) {
		this.defaultResultProvider = defaultResultProvider;
	}

	public void setParameterNameOfJsonp(String parameterNameOfJsonp) {
		this.parameterNameOfJsonp = parameterNameOfJsonp;
	}

	public void setParameterNameOfReturnType(String parameterNameOfReturnType) {
		this.parameterNameOfReturnType = parameterNameOfReturnType;
	}

	public void setResultProviders(
			Map<String, WebPlainResultGeneratee> resultProviders) {
		this.resultProviders = resultProviders;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		logger.info(request.getQueryString());
		String callbackFuncName = request.getParameter(parameterNameOfJsonp);
		String returnFormat = request.getParameter(parameterNameOfReturnType);

		WebPlainResultGeneratee resultProvider = getResultProvider(returnFormat);
		if (resultProvider == null) {
			logger.warn("configuration error, not any result provider...");
			return;
		}
		WebPlainResult result;
		try {
			result = resultProvider.parseResult(request);
		} catch (WebPlainResultException e) {
			logger.error(e.toString(), e);
			return;
		}

		PrintWriter out = response.getWriter();
		if (jsonp(callbackFuncName))
			out.print(getJSONPContent(callbackFuncName, result));
		else
			out.print(result.getPlainResponse());
		// ?
		out.close();
		logger.info("response...");
	}

	/**
	 * JSONP方式的跨域回调的封装
	 * 
	 * @param funcName
	 *            回调函数名
	 * @param result
	 *            返回的数据内容
	 * @return 包含JSONP方式的跨域回调形式的数据内容
	 */
	private String getJSONPContent(String funcName, WebPlainResult result) {
		StringBuffer sb = new StringBuffer();
		sb.append(funcName + "(");
		sb.append(result.getPlainResponse());
		sb.append(")");
		return sb.toString();
	}

	/**
	 * 根据请求参数返回一个结果解析器
	 * 
	 * @param returnFormat
	 *            返回格式标识
	 * @return 结果解析器，如果为null，表示没有查找到合适的解析器
	 */
	private WebPlainResultGeneratee getResultProvider(String returnFormat) {
		if (resultProviders == null)
			return defaultResultProvider;
		WebPlainResultGeneratee provider = this.resultProviders
				.get(returnFormat);
		if (provider != null)
			return provider;
		return defaultResultProvider;
	}

	/**
	 * 检查是否存在JSONP参数
	 * 
	 * @param callbackFuncName
	 *            表示指明回调函数名的参数
	 * @return 判断是否是JSONP调用
	 */
	private boolean jsonp(String callbackFuncName) {
		if ("".equals(callbackFuncName) || callbackFuncName == null) {
			return false;
		}
		return true;
	}

	/**
	 * 日志记录器
	 */
	final Logger logger = LoggerFactory.getLogger(WebPlainService.class);

	private WebPlainResultGeneratee defaultResultProvider;

	/**
	 * 跨域json请求的回调函数请求参数定义
	 */
	private String parameterNameOfJsonp = "jsonp";

	private String parameterNameOfReturnType = "rType";
	private Map<String, WebPlainResultGeneratee> resultProviders;
	private static final long serialVersionUID = 5519516196994796192L;
}
