package com.autonavi.infra.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.web.JsonpHandlee;

/**
 * @author zhenhua.lei
 * @version 0.1.0,2011-01-25
 * 
 */
final class JsonpHandler implements JsonpHandlee {

	@Override
	final public String jsonpWrap(HttpServletRequest request, String content) {
		String paraJsonp = request.getParameter(nameOfJsonpParameter);
		String pathInfo = request.getPathInfo();
		if (paraJsonp == null) {
			logger.debug("need not jsonp [{}]", pathInfo);
			return content;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(paraJsonp);
		sb.append("(");
		sb.append(content);
		sb.append(")");
		logger.debug("jsonp : {}(),{}", paraJsonp, pathInfo);
		return sb.toString();
	}

	final public void setNameOfJsonpParameter(String nameOfJsonpParameter) {
		this.nameOfJsonpParameter = nameOfJsonpParameter;
	}

	private String nameOfJsonpParameter = "jsonp";
	final static Logger logger = LoggerFactory.getLogger(JsonpHandler.class);
}
