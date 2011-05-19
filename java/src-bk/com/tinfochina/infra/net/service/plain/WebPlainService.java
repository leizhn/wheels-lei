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
 * һ�����������������ݵĲ�������ͬʱ����Servlet�淶��spring MVC�Ľӿڣ������ֻ����¾�����
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
	 * JSONP��ʽ�Ŀ���ص��ķ�װ
	 * 
	 * @param funcName
	 *            �ص�������
	 * @param result
	 *            ���ص���������
	 * @return ����JSONP��ʽ�Ŀ���ص���ʽ����������
	 */
	private String getJSONPContent(String funcName, WebPlainResult result) {
		StringBuffer sb = new StringBuffer();
		sb.append(funcName + "(");
		sb.append(result.getPlainResponse());
		sb.append(")");
		return sb.toString();
	}

	/**
	 * ���������������һ�����������
	 * 
	 * @param returnFormat
	 *            ���ظ�ʽ��ʶ
	 * @return ��������������Ϊnull����ʾû�в��ҵ����ʵĽ�����
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
	 * ����Ƿ����JSONP����
	 * 
	 * @param callbackFuncName
	 *            ��ʾָ���ص��������Ĳ���
	 * @return �ж��Ƿ���JSONP����
	 */
	private boolean jsonp(String callbackFuncName) {
		if ("".equals(callbackFuncName) || callbackFuncName == null) {
			return false;
		}
		return true;
	}

	/**
	 * ��־��¼��
	 */
	final Logger logger = LoggerFactory.getLogger(WebPlainService.class);

	private WebPlainResultGeneratee defaultResultProvider;

	/**
	 * ����json����Ļص����������������
	 */
	private String parameterNameOfJsonp = "jsonp";

	private String parameterNameOfReturnType = "rType";
	private Map<String, WebPlainResultGeneratee> resultProviders;
	private static final long serialVersionUID = 5519516196994796192L;
}
