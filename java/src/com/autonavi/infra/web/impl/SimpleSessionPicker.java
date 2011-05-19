package com.autonavi.infra.web.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.web.SessionPickee;

/**
 * 
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-04-19
 * 
 * @param <E>
 *            session中对应于session id的对象
 */
final public class SimpleSessionPicker<E> implements SessionPickee<E> {

	@Override
	final public boolean in(HttpServletRequest request) {
		E element = this.get(request);
		if (element == null)
			return false;
		else
			return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	final public E get(HttpServletRequest request) {
		Object sessionStore = request.getSession().getAttribute(
				sessionIndentify);
		try {
			return (E) sessionStore;
		} catch (ClassCastException e) {
			logger.warn(e.toString(), e);
			return null;
		}
	}

	final public void setSessionIndentify(String sessionIndentify) {
		this.sessionIndentify = sessionIndentify;
	}

	private String sessionIndentify = "user";

	final static Logger logger = LoggerFactory
			.getLogger(SimpleSessionPicker.class);
}
