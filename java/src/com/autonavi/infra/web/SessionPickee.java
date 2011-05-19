package com.autonavi.infra.web;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * ��������Ƿ����һ����Чsession
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-01-27
 * 
 * @param <E>
 *            session�ж�Ӧ��session��ʶ�Ķ���
 */
public interface SessionPickee<E> {
	/**
	 * ���ָ��request�Ƿ�����ĳsession
	 * 
	 * @param request
	 * @return
	 */
	boolean in(HttpServletRequest request);

	/**
	 * ��ȡϵͳ�кʹ������session���Ӧ�Ķ���
	 * 
	 * @param request
	 * @return
	 */
	E get(HttpServletRequest request);
}
