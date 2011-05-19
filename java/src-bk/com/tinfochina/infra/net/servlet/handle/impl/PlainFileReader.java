package com.tinfochina.infra.net.servlet.handle.impl;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.autonavi.infra.ProcedureException;
import com.tinfochina.infra.net.servlet.handle.Handlee;

/**
 * 该处理器读取纯文本内容
 * 
 * @author leizhn
 * @version 0.1.0,2010-11-15
 * @deprecated
 */
public class PlainFileReader implements Handlee<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.net.servlet.handle.Handlee#handle(javax.servlet.
	 * http.HttpServletRequest)
	 */
	@Override
	public String handle(HttpServletRequest request) throws ProcedureException {
		StringBuilder sb = new StringBuilder();
		try {
			Scanner scanner = new Scanner(resource.getInputStream());
			while (scanner.hasNext()) {
				sb.append(scanner.nextLine());
				sb.append(System.getProperty("line.separator"));
			}
			return sb.toString();
		} catch (IOException e) {
			logger.debug(e.toString(), e);
			throw new ProcedureException(e);
		}
	}

	/**
	 * 设置要读取的文本的路径
	 * 
	 * @param resource
	 *            要读取的文本的路径
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Resource resource;
}
