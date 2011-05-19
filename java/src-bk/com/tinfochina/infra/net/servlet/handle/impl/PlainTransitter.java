package com.tinfochina.infra.net.servlet.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.ProcedureException;
import com.autonavi.infra.http.client.HttpOperation;
import com.tinfochina.infra.net.servlet.handle.Handlee;

/**
 * 用做中转
 * 
 * @author leizhn
 * @version 0.1.0,2010-11-09
 * @deprecated
 * 
 */
public class PlainTransitter implements Handlee<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.servlet.handle.Handlee#handle(javax.servlet.
	 * http.HttpServletRequest)
	 */
	@Override
	public String handle(HttpServletRequest request) throws ProcedureException {
		logger.debug("method : {}", request.getMethod());
		return httpOperation.getResult(serviceUrl + "?"
				+ request.getQueryString());
	}

	/**
	 * @param httpOperation
	 */
	public void setHttpOperation(HttpOperation httpOperation) {
		this.httpOperation = httpOperation;
	}

	/**
	 * @param serviceUrl
	 */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	private HttpOperation httpOperation;
	private String serviceUrl;
}
