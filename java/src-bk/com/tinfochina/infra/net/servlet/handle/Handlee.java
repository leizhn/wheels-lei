package com.tinfochina.infra.net.servlet.handle;

import javax.servlet.http.HttpServletRequest;

import com.autonavi.infra.ProcedureException;

/**
 * 
 * ��web����޹صĴ�����̶���
 * 
 * @author leizhn
 * @deprecated
 * 
 * @param <E>
 *            ��������������
 */
public interface Handlee<E> {
	/**
	 * ��������������ĳ������
	 * 
	 * @param request
	 *            ԭʼ�������
	 * @return ����������
	 * @throws ProcedureException
	 */
	E handle(HttpServletRequest request) throws ProcedureException;
}
