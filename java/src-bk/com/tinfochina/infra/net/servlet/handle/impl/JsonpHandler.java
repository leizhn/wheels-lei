package com.tinfochina.infra.net.servlet.handle.impl;

import javax.servlet.http.HttpServletRequest;

import com.tinfochina.infra.net.servlet.handle.ChainHandler;

/**
 * 
 * JSONP参数返回处理
 * 
 * @author leizhn
 * @version 0.1.0,2010-11-04
 * @deprecated
 */
public class JsonpHandler extends ChainHandler<String, String> {

	/**
	 * 请求中表示jsonp操作参数的名字，缺省符合行业习惯，使用jsonp
	 * 
	 * @param jsonpParameterName
	 *            参数名字
	 */
	public void setJsonpParameterName(String jsonpParameterName) {
		this.jsonpParameterName = jsonpParameterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.servlet.impl.ChainHandler#currentHandle(javax
	 * .servlet.http.HttpServletRequest, java.lang.Object)
	 */
	@Override
	protected String currentHandle(HttpServletRequest request,
			String previousResult) {
		String jsonpParameterValue = request.getParameter(jsonpParameterName);
		StringBuilder sb = new StringBuilder();
		sb.append(jsonpParameterValue);
		sb.append("(");
		sb.append(previousResult);
		sb.append(")");
		return sb.toString();
	}

	private String jsonpParameterName = "jsonp";
}
